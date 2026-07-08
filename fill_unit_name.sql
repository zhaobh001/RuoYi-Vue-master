-- 使用FIRST_VALUE等开窗函数方式填充空的单位名称，支持多层嵌套

-- 假设表名为：unit_table，字段为：id, parent_id, unit_name

-- 方案：通过构建完整的父子关系，然后使用FIRST_VALUE开窗函数获取有效的单位名称

-- 第一步：构建所有节点的基本信息
base_data AS (
  SELECT 
    id,
    parent_id,
    unit_name
  FROM unit_table
),

-- 第二步：构建多层父子关系（支持最多4层嵌套）
multi_level_relations AS (
  SELECT 
    b1.id as node_id,
    b1.parent_id,
    b1.unit_name as level_0_name,  -- 当前节点名称
    
    -- 第一层父节点
    b2.id as level_1_id,
    b2.unit_name as level_1_name,
    
    -- 第二层父节点
    b3.id as level_2_id,
    b3.unit_name as level_2_name,
    
    -- 第三层父节点
    b4.id as level_3_id,
    b4.unit_name as level_3_name,
    
    -- 第四层父节点
    b5.id as level_4_id,
    b5.unit_name as level_4_name
  FROM base_data b1
  LEFT JOIN base_data b2 ON b1.parent_id = b2.id
  LEFT JOIN base_data b3 ON b2.parent_id = b3.id
  LEFT JOIN base_data b4 ON b3.parent_id = b4.id
  LEFT JOIN base_data b5 ON b4.parent_id = b5.id
),

-- 第三步：使用FIRST_VALUE开窗函数为每个节点确定有效的单位名称
processed_data AS (
  SELECT 
    node_id as id,
    parent_id,
    level_0_name,
    level_1_name,
    level_2_name,
    level_3_name,
    level_4_name,
    
    -- 使用FIRST_VALUE获取第一个非空的单位名称
    FIRST_VALUE(
      COALESCE(
        NULLIF(TRIM(level_0_name), ''),
        NULLIF(TRIM(level_1_name), ''),
        NULLIF(TRIM(level_2_name), ''),
        NULLIF(TRIM(level_3_name), ''),
        NULLIF(TRIM(level_4_name), '')
      )
    ) OVER (
      PARTITION BY COALESCE(level_4_id, level_3_id, level_2_id, level_1_id, node_id)
      ORDER BY node_id
      ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING
    ) as inherited_name
  FROM multi_level_relations
),

-- 第四步：确定每个节点的最终单位名称
final_data AS (
  SELECT 
    id,
    parent_id,
    COALESCE(
      NULLIF(TRIM(level_0_name), ''),
      inherited_name
    ) as unit_name
  FROM processed_data
)

-- 最终查询结果
SELECT 
  id,
  parent_id,
  unit_name
FROM final_data
ORDER BY id;
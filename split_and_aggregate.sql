-- Hive SQL to split string by delimiter and calculate sum and max values
WITH split_data AS (
  SELECT explode(split('847.593|573.277|248.334|2707.385|143.809|906.427', '\\|')) AS value
)
SELECT 
  SUM(CAST(value AS DOUBLE)) AS total_sum,
  MAX(CAST(value AS DOUBLE)) AS max_value
FROM split_data;

-- Corrected version of your query - handling WEIGHT and PRICE splits separately
-- Option 1: Using lateral view (recommended approach)
SELECT 
    income.INCOMEEXPEND_ID,
    weight_split.WEIGHT_split,
    price_split.PRICE_split
FROM ods_hb_incomeexpend_hy_d income
LATERAL VIEW explode(split(income.WEIGHT, '\\|')) weight_split AS WEIGHT_split
LATERAL VIEW explode(split(income.PRICE, '\\|')) price_split AS PRICE_split;

-- Option 2: If you want to process WEIGHT and PRICE separately
-- For WEIGHT:
SELECT 
    income.INCOMEEXPEND_ID,
    wt.WEIGHT_split
FROM ods_hb_incomeexpend_hy_d income
LATERAL VIEW explode(split(income.WEIGHT, '\\|')) wt AS WEIGHT_split;

-- For PRICE:
SELECT 
    income.INCOMEEXPEND_ID,
    pr.PRICE_split
FROM ods_hb_incomeexpend_hy_d income
LATERAL VIEW explode(split(income.PRICE, '\\|')) pr AS PRICE_split;

-- Option 3: If you want aggregations on the split values
SELECT 
    income.INCOMEEXPEND_ID,
    SUM(CAST(wt.WEIGHT_split AS DOUBLE)) AS total_weight,
    MAX(CAST(wt.WEIGHT_split AS DOUBLE)) AS max_weight,
    SUM(CAST(pr.PRICE_split AS DOUBLE)) AS total_price,
    MAX(CAST(pr.PRICE_split AS DOUBLE)) AS max_price
FROM ods_hb_incomeexpend_hy_d income
LATERAL VIEW explode(split(income.WEIGHT, '\\|')) wt AS WEIGHT_split
LATERAL VIEW explode(split(income.PRICE, '\\|')) pr AS PRICE_split
GROUP BY income.INCOMEEXPEND_ID;
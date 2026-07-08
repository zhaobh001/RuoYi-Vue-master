-- Detailed check of tables with CDC/supplemental logging enabled

-- 1. Check all tables with supplemental logging
SELECT 
    LOG_GROUP_NAME,
    TABLE_NAME,
    LOG_GROUP_TYPE,
    ALWAYS
FROM USER_LOG_GROUPS
ORDER BY TABLE_NAME;

-- 2. Check which columns are included in supplemental logging for these tables
SELECT 
    LOG_GROUP_NAME,
    TABLE_NAME,
    COLUMN_NAME,
    POSITION
FROM USER_LOG_GROUP_COLUMNS
ORDER BY TABLE_NAME, POSITION;

-- 3. Check additional information about these tables
SELECT 
    TABLE_NAME,
    NUM_ROWS,
    LAST_ANALYZED
FROM USER_TABLES
WHERE TABLE_NAME IN (
    SELECT TABLE_NAME 
    FROM USER_LOG_GROUPS
)
ORDER BY TABLE_NAME;

-- 4. Check if these tables have any triggers
SELECT 
    TABLE_NAME,
    TRIGGER_NAME,
    TRIGGER_TYPE,
    TRIGGERING_EVENT,
    STATUS
FROM USER_TRIGGERS
WHERE TABLE_NAME IN (
    SELECT TABLE_NAME 
    FROM USER_LOG_GROUPS
)
ORDER BY TABLE_NAME, TRIGGER_NAME;

EXIT;
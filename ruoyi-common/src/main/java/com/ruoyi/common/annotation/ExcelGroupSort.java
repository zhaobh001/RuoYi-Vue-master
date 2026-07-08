package com.ruoyi.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel分组排序注解
 * 用于实现类似SQL ROW_NUMBER() OVER(PARTITION BY ... ORDER BY ...) 的功能
 * 
 * @author ruoyi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelGroupSort {
    
    /**
     * 分组字段名称（对应实体类中的字段名）
     * 可以指定多个字段进行分组
     */
    String[] groupByFields() default {};
    
    /**
     * 排序字段名称（对应实体类中的字段名）
     * 默认按该字段排序
     */
    String sortByField() default "";
    
    /**
     * 排序方式
     * true: 升序, false: 降序
     */
    boolean ascending() default true;
    
    /**
     * 序号列的标题名称
     */
    String name() default "序号";
    
    /**
     * 导出时在excel中排序
     */
    int sort() default Integer.MAX_VALUE;
}
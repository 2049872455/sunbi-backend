package com.sun.springbootInit.model.dto.chart;

import lombok.Data;

import java.io.Serializable;

/**
 * 请求
 */
@Data
public class GenChartByAiRequest implements Serializable {

    /**
     * 图表名称
     */
    private String chartName;

    /**
     * 分析目标
     */
    private String goal;

    /**
     * 图表类型
     */
    private String chartType;

    private static final long serialVersionUID = 1L;
}
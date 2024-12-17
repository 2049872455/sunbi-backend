package com.sun.springbootInit.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.springbootInit.model.dto.chart.ChartQueryRequest;
import com.sun.springbootInit.model.dto.post.PostQueryRequest;
import com.sun.springbootInit.model.entity.Chart;
import com.sun.springbootInit.model.entity.Post;

/**
* @author sundaqing
* @description 针对表【chart(图标信息表)】的数据库操作Service
*/
public interface ChartService extends IService<Chart> {

    /**
     * 获取查询条件
     *
     * @param chartQueryRequest
     * @return
     */
    QueryWrapper<Chart> getQueryWrapper(ChartQueryRequest chartQueryRequest);

    /**
     * 处理图表更新错误
     * @param chatId
     * @param execMessage
     */
    void handleChartUpdateError(Long chatId,String execMessage);
}

package com.sun.springbootInit.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.springbootInit.constant.CommonConstant;
import com.sun.springbootInit.mapper.UserMapper;
import com.sun.springbootInit.model.dto.chart.ChartQueryRequest;
import com.sun.springbootInit.model.entity.Chart;
import com.sun.springbootInit.model.entity.Post;
import com.sun.springbootInit.service.ChartService;
import com.sun.springbootInit.mapper.ChartMapper;
import com.sun.springbootInit.utils.SqlUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author sundaqing
* @description 针对表【chart(图标信息表)】的数据库操作Service实现
*/
@Service
public class ChartServiceImpl extends ServiceImpl<ChartMapper, Chart>
    implements ChartService{

    private final UserMapper userMapper;

    private final ChartMapper chartMapper;

    public ChartServiceImpl(UserMapper userMapper, ChartMapper chartMapper) {
        this.userMapper = userMapper;
        this.chartMapper = chartMapper;
    }

    public void handleChartUpdateError(Long chatId,String execMessage){
        Chart updateChart = new Chart();
        updateChart.setId(chatId);
        updateChart.setStatus("failed");
        updateChart.setExecMessage(execMessage);
        int b = chartMapper.updateById(updateChart);
        if(!(b >0)){
            log.error("更新图表失败状态失败"+chatId+execMessage);
        }

    }

    @Override
    public QueryWrapper<Chart> getQueryWrapper(ChartQueryRequest chartQueryRequest) {
        QueryWrapper<Chart> queryWrapper = new QueryWrapper<>();
        if (chartQueryRequest == null) {
            return queryWrapper;
        }
        String chartName = chartQueryRequest.getChartName();
        Long userId = chartQueryRequest.getUserId();
        String sortField = chartQueryRequest.getSortField();
        String sortOrder = chartQueryRequest.getSortOrder();
        // 拼接查询条件
        if (StringUtils.isNotBlank(chartName)) {
            queryWrapper.and(qw -> qw.like("chartName", chartName));
        }
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId),"userId",userId);

        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }
}





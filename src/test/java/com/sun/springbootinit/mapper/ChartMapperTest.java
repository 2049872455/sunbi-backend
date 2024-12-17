package com.sun.springbootinit.mapper;

import com.sun.springbootInit.mapper.ChartMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChartMapperTest {


    @Resource
    private ChartMapper chartMapper;

    @Test
    void queryChartData() {
        String chartId = "1866690727872507905";
        String querySql = String.format("select * from chart_%s", chartId);
        List<Map<String, Object>> resultData = chartMapper.queryChartData(querySql);
        System.out.println(resultData);
    }

}

package com.ruoyi.manage.service;

import java.util.List;
import java.util.Date;
import com.ruoyi.manage.domain.BookInventoryStats;

public interface IBookInventoryStatsService {
    /**
     * 查询图书进销存统计
     * 
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 统计结果列表
     */
    public List<BookInventoryStats> getBookInventoryStats(Date startDate, Date endDate);
}
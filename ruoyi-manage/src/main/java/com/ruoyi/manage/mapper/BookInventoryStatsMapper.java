package com.ruoyi.manage.mapper;

import java.util.List;
import java.util.Date;
import com.ruoyi.manage.domain.BookInventoryStats;

public interface BookInventoryStatsMapper {
    /**
     * 查询图书进销存统计
     * 
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 统计结果列表
     */
    public List<BookInventoryStats> getBookInventoryStats(Date startDate, Date endDate);
}
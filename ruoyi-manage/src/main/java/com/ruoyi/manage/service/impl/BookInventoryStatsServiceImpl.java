package com.ruoyi.manage.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.BookInventoryStatsMapper;
import com.ruoyi.manage.domain.BookInventoryStats;
import com.ruoyi.manage.service.IBookInventoryStatsService;

@Service
public class BookInventoryStatsServiceImpl implements IBookInventoryStatsService {
    @Autowired
    private BookInventoryStatsMapper bookInventoryStatsMapper;

    @Override
    public List<BookInventoryStats> getBookInventoryStats(Date startDate, Date endDate) {
        return bookInventoryStatsMapper.getBookInventoryStats(startDate, endDate);
    }
}
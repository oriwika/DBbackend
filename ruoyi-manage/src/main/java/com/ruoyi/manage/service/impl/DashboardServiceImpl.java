package com.ruoyi.manage.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.manage.mapper.DashboardMapper;
import com.ruoyi.manage.service.IDashboardService;

/**
 * 首页统计数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-01-20
 */
@Service
public class DashboardServiceImpl implements IDashboardService {
    
    @Autowired
    private DashboardMapper dashboardMapper;
    
    /**
     * 获取图书总数
     */
    @Override
    public int getTotalBooks() {
        return dashboardMapper.getTotalBooks();
    }
    
    /**
     * 获取库存总量
     */
    @Override
    public int getTotalInventory() {
        return dashboardMapper.getTotalInventory();
    }
    
    /**
     * 获取今日销售额
     */
    @Override
    public BigDecimal getTodaySales() {
        BigDecimal sales = dashboardMapper.getTodaySales();
        return sales != null ? sales : BigDecimal.ZERO;
    }
    
    /**
     * 获取库存预警图书数量
     */
    @Override
    public int getLowStockBooksCount(int threshold) {
        return dashboardMapper.getLowStockBooksCount(threshold);
    }
    
    /**
     * 获取出版社数量
     */
    @Override
    public int getPublishersCount() {
        return dashboardMapper.getPublishersCount();
    }
    
    /**
     * 获取图书类别数量
     */
    @Override
    public int getCategoriesCount() {
        return dashboardMapper.getCategoriesCount();
    }
    
    /**
     * 获取仓库数量
     */
    @Override
    public int getWarehousesCount() {
        return dashboardMapper.getWarehousesCount();
    }
    
    /**
     * 获取本月进货订单数
     */
    @Override
    public int getMonthlyPurchaseOrders() {
        return dashboardMapper.getMonthlyPurchaseOrders();
    }
    
    /**
     * 获取本月销售订单数
     */
    @Override
    public int getMonthlySalesOrders() {
        return dashboardMapper.getMonthlySalesOrders();
    }
    
    /**
     * 获取热销图书列表
     */
    @Override
    public List<Map<String, Object>> getHotBooks(int limit) {
        return dashboardMapper.getHotBooks(limit);
    }
    
    /**
     * 获取库存预警列表
     */
    @Override
    public List<Map<String, Object>> getLowStockList(int threshold) {
        return dashboardMapper.getLowStockList(threshold);
    }
}
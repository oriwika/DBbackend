package com.ruoyi.manage.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 首页统计数据Mapper接口
 * 
 * @author ruoyi
 * @date 2025-01-20
 */
public interface DashboardMapper {
    
    /**
     * 获取图书总数
     * @return 图书总数
     */
    int getTotalBooks();
    
    /**
     * 获取库存总量
     * @return 库存总量
     */
    int getTotalInventory();
    
    /**
     * 获取今日销售额
     * @return 今日销售额
     */
    BigDecimal getTodaySales();
    
    /**
     * 获取库存预警图书数量
     * @param threshold 库存阈值
     * @return 库存预警图书数量
     */
    int getLowStockBooksCount(@Param("threshold") int threshold);
    
    /**
     * 获取出版社数量
     * @return 出版社数量
     */
    int getPublishersCount();
    
    /**
     * 获取图书类别数量
     * @return 图书类别数量
     */
    int getCategoriesCount();
    
    /**
     * 获取仓库数量
     * @return 仓库数量
     */
    int getWarehousesCount();
    
    /**
     * 获取本月进货订单数
     * @return 本月进货订单数
     */
    int getMonthlyPurchaseOrders();
    
    /**
     * 获取本月销售订单数
     * @return 本月销售订单数
     */
    int getMonthlySalesOrders();
    
    /**
     * 获取热销图书列表
     * @param limit 返回数量限制
     * @return 热销图书列表
     */
    List<Map<String, Object>> getHotBooks(@Param("limit") int limit);
    
    /**
     * 获取库存预警列表
     * @param threshold 库存阈值
     * @return 库存预警列表
     */
    List<Map<String, Object>> getLowStockList(@Param("threshold") int threshold);
}
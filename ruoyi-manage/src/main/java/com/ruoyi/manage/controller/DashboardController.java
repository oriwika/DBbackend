package com.ruoyi.manage.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.manage.service.IDashboardService;

/**
 * 首页统计数据Controller
 * 
 * @author ruoyi
 * @date 2025-01-20
 */
@RestController
@RequestMapping("/manage/dashboard")
public class DashboardController extends BaseController {
    
    @Autowired
    private IDashboardService dashboardService;
    
    /**
     * 获取首页统计数据
     */
    @GetMapping("/stats")
    public AjaxResult getStats() {
        Map<String, Object> stats = new HashMap<>();
        
        // 图书总数
        int totalBooks = dashboardService.getTotalBooks();
        stats.put("totalBooks", totalBooks);
        
        // 库存总量
        int totalInventory = dashboardService.getTotalInventory();
        stats.put("totalInventory", totalInventory);
        
        // 今日销售额
        BigDecimal todaySales = dashboardService.getTodaySales();
        stats.put("todaySales", todaySales);
        
        // 库存预警数量（库存少于10本的图书种类数）
        int lowStockBooks = dashboardService.getLowStockBooksCount(10);
        stats.put("lowStockBooks", lowStockBooks);
        
        return AjaxResult.success(stats);
    }
    
    /**
     * 获取业务概览数据
     */
    @GetMapping("/overview")
    public AjaxResult getOverview() {
        Map<String, Object> overview = new HashMap<>();
        
        // 出版社数量
        int publishers = dashboardService.getPublishersCount();
        overview.put("publishers", publishers);
        
        // 图书类别数量
        int categories = dashboardService.getCategoriesCount();
        overview.put("categories", categories);
        
        // 仓库数量
        int warehouses = dashboardService.getWarehousesCount();
        overview.put("warehouses", warehouses);
        
        // 本月进货订单数
        int monthlyPurchase = dashboardService.getMonthlyPurchaseOrders();
        overview.put("monthlyPurchase", monthlyPurchase);
        
        // 本月销售订单数
        int monthlySales = dashboardService.getMonthlySalesOrders();
        overview.put("monthlySales", monthlySales);
        
        return AjaxResult.success(overview);
    }
    
    /**
     * 获取热销图书
     */
    @GetMapping("/hotbooks")
    public AjaxResult getHotBooks() {
        List<Map<String, Object>> hotBooks = dashboardService.getHotBooks(5);
        return AjaxResult.success(hotBooks);
    }
    
    /**
     * 获取库存预警列表
     */
    @GetMapping("/lowstock")
    public AjaxResult getLowStockList() {
        List<Map<String, Object>> lowStockList = dashboardService.getLowStockList(10);
        return AjaxResult.success(lowStockList);
    }
}
package com.ruoyi.manage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.manage.domain.BookInventoryStats;
import com.ruoyi.manage.service.IBookInventoryStatsService;

@RestController
@RequestMapping("/manage/bookstats")
public class BookInventoryStatsController extends BaseController {
    @Autowired
    private IBookInventoryStatsService bookInventoryStatsService;

    /**
     * 查询图书进销存统计列表
     */
    @PreAuthorize("@ss.hasPermi('manage:bookstats:list')")
    @GetMapping("/list")
    public AjaxResult list(String startDate, String endDate) {
        // 不使用分页，直接返回统计结果
        List<BookInventoryStats> list = bookInventoryStatsService.getBookInventoryStats(
                java.sql.Timestamp.valueOf(startDate + " 00:00:00"),
                java.sql.Timestamp.valueOf(endDate + " 23:59:59")
        );
        return AjaxResult.success(list);
    }
}
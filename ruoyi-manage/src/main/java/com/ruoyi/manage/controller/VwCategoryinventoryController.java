package com.ruoyi.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.manage.domain.VwCategoryinventory;
import com.ruoyi.manage.service.IVwCategoryinventoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 各类别图书库存详情Controller
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@RestController
@RequestMapping("/manage/categoryinventory")
public class VwCategoryinventoryController extends BaseController
{
    @Autowired
    private IVwCategoryinventoryService vwCategoryinventoryService;

    /**
     * 查询各类别图书库存详情列表
     */
    @PreAuthorize("@ss.hasPermi('manage:categoryinventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(VwCategoryinventory vwCategoryinventory)
    {
        startPage();
        List<VwCategoryinventory> list = vwCategoryinventoryService.selectVwCategoryinventoryList(vwCategoryinventory);
        return getDataTable(list);
    }

    /**
     * 导出各类别图书库存详情列表
     */
    @PreAuthorize("@ss.hasPermi('manage:categoryinventory:export')")
    @Log(title = "各类别图书库存详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VwCategoryinventory vwCategoryinventory)
    {
        List<VwCategoryinventory> list = vwCategoryinventoryService.selectVwCategoryinventoryList(vwCategoryinventory);
        ExcelUtil<VwCategoryinventory> util = new ExcelUtil<VwCategoryinventory>(VwCategoryinventory.class);
        util.exportExcel(response, list, "各类别图书库存详情数据");
    }

    /**
     * 获取各类别图书库存详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:categoryinventory:query')")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId)
    {
        return success(vwCategoryinventoryService.selectVwCategoryinventoryByCategoryId(categoryId));
    }

    /**
     * 新增各类别图书库存详情
     */
    @PreAuthorize("@ss.hasPermi('manage:categoryinventory:add')")
    @Log(title = "各类别图书库存详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VwCategoryinventory vwCategoryinventory)
    {
        return toAjax(vwCategoryinventoryService.insertVwCategoryinventory(vwCategoryinventory));
    }

    /**
     * 修改各类别图书库存详情
     */
    @PreAuthorize("@ss.hasPermi('manage:categoryinventory:edit')")
    @Log(title = "各类别图书库存详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VwCategoryinventory vwCategoryinventory)
    {
        return toAjax(vwCategoryinventoryService.updateVwCategoryinventory(vwCategoryinventory));
    }

    /**
     * 删除各类别图书库存详情
     */
    @PreAuthorize("@ss.hasPermi('manage:categoryinventory:remove')")
    @Log(title = "各类别图书库存详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Long[] categoryIds)
    {
        return toAjax(vwCategoryinventoryService.deleteVwCategoryinventoryByCategoryIds(categoryIds));
    }
}

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
import com.ruoyi.manage.domain.TbWarehouse;
import com.ruoyi.manage.service.ITbWarehouseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓库管理Controller
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@RestController
@RequestMapping("/manage/warehouse")
public class TbWarehouseController extends BaseController
{
    @Autowired
    private ITbWarehouseService tbWarehouseService;

    /**
     * 查询仓库管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:warehouse:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbWarehouse tbWarehouse)
    {
        startPage();
        List<TbWarehouse> list = tbWarehouseService.selectTbWarehouseList(tbWarehouse);
        return getDataTable(list);
    }

    /**
     * 导出仓库管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:warehouse:export')")
    @Log(title = "仓库管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbWarehouse tbWarehouse)
    {
        List<TbWarehouse> list = tbWarehouseService.selectTbWarehouseList(tbWarehouse);
        ExcelUtil<TbWarehouse> util = new ExcelUtil<TbWarehouse>(TbWarehouse.class);
        util.exportExcel(response, list, "仓库管理数据");
    }

    /**
     * 获取仓库管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:warehouse:query')")
    @GetMapping(value = "/{warehouseId}")
    public AjaxResult getInfo(@PathVariable("warehouseId") Long warehouseId)
    {
        return success(tbWarehouseService.selectTbWarehouseByWarehouseId(warehouseId));
    }

    /**
     * 新增仓库管理
     */
    @PreAuthorize("@ss.hasPermi('manage:warehouse:add')")
    @Log(title = "仓库管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbWarehouse tbWarehouse)
    {
        return toAjax(tbWarehouseService.insertTbWarehouse(tbWarehouse));
    }

    /**
     * 修改仓库管理
     */
    @PreAuthorize("@ss.hasPermi('manage:warehouse:edit')")
    @Log(title = "仓库管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbWarehouse tbWarehouse)
    {
        return toAjax(tbWarehouseService.updateTbWarehouse(tbWarehouse));
    }

    /**
     * 删除仓库管理
     */
    @PreAuthorize("@ss.hasPermi('manage:warehouse:remove')")
    @Log(title = "仓库管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseIds}")
    public AjaxResult remove(@PathVariable Long[] warehouseIds)
    {
        return toAjax(tbWarehouseService.deleteTbWarehouseByWarehouseIds(warehouseIds));
    }
}

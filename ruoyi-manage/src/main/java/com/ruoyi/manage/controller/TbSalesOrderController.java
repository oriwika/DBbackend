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
import com.ruoyi.manage.domain.TbSalesOrder;
import com.ruoyi.manage.service.ITbSalesOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售订单管理Controller
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@RestController
@RequestMapping("/manage/saleorder")
public class TbSalesOrderController extends BaseController
{
    @Autowired
    private ITbSalesOrderService tbSalesOrderService;

    /**
     * 查询销售订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:saleorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbSalesOrder tbSalesOrder)
    {
        startPage();
        List<TbSalesOrder> list = tbSalesOrderService.selectTbSalesOrderList(tbSalesOrder);
        return getDataTable(list);
    }

    /**
     * 导出销售订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:saleorder:export')")
    @Log(title = "销售订单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbSalesOrder tbSalesOrder)
    {
        List<TbSalesOrder> list = tbSalesOrderService.selectTbSalesOrderList(tbSalesOrder);
        ExcelUtil<TbSalesOrder> util = new ExcelUtil<TbSalesOrder>(TbSalesOrder.class);
        util.exportExcel(response, list, "销售订单管理数据");
    }

    /**
     * 获取销售订单管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:saleorder:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return success(tbSalesOrderService.selectTbSalesOrderByOrderId(orderId));
    }

    /**
     * 新增销售订单管理
     */
    @PreAuthorize("@ss.hasPermi('manage:saleorder:add')")
    @Log(title = "销售订单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbSalesOrder tbSalesOrder)
    {
        return toAjax(tbSalesOrderService.insertTbSalesOrder(tbSalesOrder));
    }

    /**
     * 修改销售订单管理
     */
    @PreAuthorize("@ss.hasPermi('manage:saleorder:edit')")
    @Log(title = "销售订单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbSalesOrder tbSalesOrder)
    {
        return toAjax(tbSalesOrderService.updateTbSalesOrder(tbSalesOrder));
    }

    /**
     * 删除销售订单管理
     */
    @PreAuthorize("@ss.hasPermi('manage:saleorder:remove')")
    @Log(title = "销售订单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(tbSalesOrderService.deleteTbSalesOrderByOrderIds(orderIds));
    }
}

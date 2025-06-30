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
import com.ruoyi.manage.domain.TbPurchaseOrder;
import com.ruoyi.manage.service.ITbPurchaseOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 进货订单管理Controller
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@RestController
@RequestMapping("/manage/purchaseorder")
public class TbPurchaseOrderController extends BaseController
{
    @Autowired
    private ITbPurchaseOrderService tbPurchaseOrderService;

    /**
     * 查询进货订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:purchaseorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbPurchaseOrder tbPurchaseOrder)
    {
        startPage();
        List<TbPurchaseOrder> list = tbPurchaseOrderService.selectTbPurchaseOrderList(tbPurchaseOrder);
        return getDataTable(list);
    }

    /**
     * 导出进货订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:purchaseorder:export')")
    @Log(title = "进货订单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbPurchaseOrder tbPurchaseOrder)
    {
        List<TbPurchaseOrder> list = tbPurchaseOrderService.selectTbPurchaseOrderList(tbPurchaseOrder);
        ExcelUtil<TbPurchaseOrder> util = new ExcelUtil<TbPurchaseOrder>(TbPurchaseOrder.class);
        util.exportExcel(response, list, "进货订单管理数据");
    }

    /**
     * 获取进货订单管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:purchaseorder:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return success(tbPurchaseOrderService.selectTbPurchaseOrderByOrderId(orderId));
    }

    /**
     * 新增进货订单管理
     */
    @PreAuthorize("@ss.hasPermi('manage:purchaseorder:add')")
    @Log(title = "进货订单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbPurchaseOrder tbPurchaseOrder)
    {
        return toAjax(tbPurchaseOrderService.insertTbPurchaseOrder(tbPurchaseOrder));
    }

    /**
     * 修改进货订单管理
     */
    @PreAuthorize("@ss.hasPermi('manage:purchaseorder:edit')")
    @Log(title = "进货订单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbPurchaseOrder tbPurchaseOrder)
    {
        return toAjax(tbPurchaseOrderService.updateTbPurchaseOrder(tbPurchaseOrder));
    }

    /**
     * 删除进货订单管理
     */
    @PreAuthorize("@ss.hasPermi('manage:purchaseorder:remove')")
    @Log(title = "进货订单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(tbPurchaseOrderService.deleteTbPurchaseOrderByOrderIds(orderIds));
    }
}

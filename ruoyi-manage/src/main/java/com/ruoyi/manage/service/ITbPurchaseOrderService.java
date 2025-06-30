package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.TbPurchaseOrder;

/**
 * 进货订单管理Service接口
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public interface ITbPurchaseOrderService 
{
    /**
     * 查询进货订单管理
     * 
     * @param orderId 进货订单管理主键
     * @return 进货订单管理
     */
    public TbPurchaseOrder selectTbPurchaseOrderByOrderId(Long orderId);

    /**
     * 查询进货订单管理列表
     * 
     * @param tbPurchaseOrder 进货订单管理
     * @return 进货订单管理集合
     */
    public List<TbPurchaseOrder> selectTbPurchaseOrderList(TbPurchaseOrder tbPurchaseOrder);

    /**
     * 新增进货订单管理
     * 
     * @param tbPurchaseOrder 进货订单管理
     * @return 结果
     */
    public int insertTbPurchaseOrder(TbPurchaseOrder tbPurchaseOrder);

    /**
     * 修改进货订单管理
     * 
     * @param tbPurchaseOrder 进货订单管理
     * @return 结果
     */
    public int updateTbPurchaseOrder(TbPurchaseOrder tbPurchaseOrder);

    /**
     * 批量删除进货订单管理
     * 
     * @param orderIds 需要删除的进货订单管理主键集合
     * @return 结果
     */
    public int deleteTbPurchaseOrderByOrderIds(Long[] orderIds);

    /**
     * 删除进货订单管理信息
     * 
     * @param orderId 进货订单管理主键
     * @return 结果
     */
    public int deleteTbPurchaseOrderByOrderId(Long orderId);
}

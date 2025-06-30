package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.TbPurchaseOrder;
import com.ruoyi.manage.domain.TbPurchaseDetail;

/**
 * 进货订单管理Mapper接口
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public interface TbPurchaseOrderMapper 
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
     * 删除进货订单管理
     * 
     * @param orderId 进货订单管理主键
     * @return 结果
     */
    public int deleteTbPurchaseOrderByOrderId(Long orderId);

    /**
     * 批量删除进货订单管理
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbPurchaseOrderByOrderIds(Long[] orderIds);

    /**
     * 批量删除进货从表管理
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbPurchaseDetailByOrderIds(Long[] orderIds);
    
    /**
     * 批量新增进货从表管理
     * 
     * @param tbPurchaseDetailList 进货从表管理列表
     * @return 结果
     */
    public int batchTbPurchaseDetail(List<TbPurchaseDetail> tbPurchaseDetailList);
    

    /**
     * 通过进货订单管理主键删除进货从表管理信息
     * 
     * @param orderId 进货订单管理ID
     * @return 结果
     */
    public int deleteTbPurchaseDetailByOrderId(Long orderId);
}

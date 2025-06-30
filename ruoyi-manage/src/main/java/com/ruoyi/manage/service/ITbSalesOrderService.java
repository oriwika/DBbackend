package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.TbSalesOrder;

/**
 * 销售订单管理Service接口
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public interface ITbSalesOrderService 
{
    /**
     * 查询销售订单管理
     * 
     * @param orderId 销售订单管理主键
     * @return 销售订单管理
     */
    public TbSalesOrder selectTbSalesOrderByOrderId(Long orderId);

    /**
     * 查询销售订单管理列表
     * 
     * @param tbSalesOrder 销售订单管理
     * @return 销售订单管理集合
     */
    public List<TbSalesOrder> selectTbSalesOrderList(TbSalesOrder tbSalesOrder);

    /**
     * 新增销售订单管理
     * 
     * @param tbSalesOrder 销售订单管理
     * @return 结果
     */
    public int insertTbSalesOrder(TbSalesOrder tbSalesOrder);

    /**
     * 修改销售订单管理
     * 
     * @param tbSalesOrder 销售订单管理
     * @return 结果
     */
    public int updateTbSalesOrder(TbSalesOrder tbSalesOrder);

    /**
     * 批量删除销售订单管理
     * 
     * @param orderIds 需要删除的销售订单管理主键集合
     * @return 结果
     */
    public int deleteTbSalesOrderByOrderIds(Long[] orderIds);

    /**
     * 删除销售订单管理信息
     * 
     * @param orderId 销售订单管理主键
     * @return 结果
     */
    public int deleteTbSalesOrderByOrderId(Long orderId);
}

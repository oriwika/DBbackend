package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.TbSalesOrder;
import com.ruoyi.manage.domain.TbSalesDetail;

/**
 * 销售订单管理Mapper接口
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public interface TbSalesOrderMapper 
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
     * 删除销售订单管理
     * 
     * @param orderId 销售订单管理主键
     * @return 结果
     */
    public int deleteTbSalesOrderByOrderId(Long orderId);

    /**
     * 批量删除销售订单管理
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbSalesOrderByOrderIds(Long[] orderIds);

    /**
     * 批量删除销售从表管理
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbSalesDetailByOrderIds(Long[] orderIds);
    
    /**
     * 批量新增销售从表管理
     * 
     * @param tbSalesDetailList 销售从表管理列表
     * @return 结果
     */
    public int batchTbSalesDetail(List<TbSalesDetail> tbSalesDetailList);
    

    /**
     * 通过销售订单管理主键删除销售从表管理信息
     * 
     * @param orderId 销售订单管理ID
     * @return 结果
     */
    public int deleteTbSalesDetailByOrderId(Long orderId);
}

package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.manage.domain.TbSalesDetail;
import com.ruoyi.manage.mapper.TbSalesOrderMapper;
import com.ruoyi.manage.domain.TbSalesOrder;
import com.ruoyi.manage.service.ITbSalesOrderService;

/**
 * 销售订单管理Service业务层处理
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@Service
public class TbSalesOrderServiceImpl implements ITbSalesOrderService 
{
    @Autowired
    private TbSalesOrderMapper tbSalesOrderMapper;

    /**
     * 查询销售订单管理
     * 
     * @param orderId 销售订单管理主键
     * @return 销售订单管理
     */
    @Override
    public TbSalesOrder selectTbSalesOrderByOrderId(Long orderId)
    {
        return tbSalesOrderMapper.selectTbSalesOrderByOrderId(orderId);
    }

    /**
     * 查询销售订单管理列表
     * 
     * @param tbSalesOrder 销售订单管理
     * @return 销售订单管理
     */
    @Override
    public List<TbSalesOrder> selectTbSalesOrderList(TbSalesOrder tbSalesOrder)
    {
        return tbSalesOrderMapper.selectTbSalesOrderList(tbSalesOrder);
    }

    /**
     * 新增销售订单管理
     * 
     * @param tbSalesOrder 销售订单管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertTbSalesOrder(TbSalesOrder tbSalesOrder)
    {
        int rows = tbSalesOrderMapper.insertTbSalesOrder(tbSalesOrder);
        insertTbSalesDetail(tbSalesOrder);
        return rows;
    }

    /**
     * 修改销售订单管理
     * 
     * @param tbSalesOrder 销售订单管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateTbSalesOrder(TbSalesOrder tbSalesOrder)
    {
        tbSalesOrderMapper.deleteTbSalesDetailByOrderId(tbSalesOrder.getOrderId());
        insertTbSalesDetail(tbSalesOrder);
        return tbSalesOrderMapper.updateTbSalesOrder(tbSalesOrder);
    }

    /**
     * 批量删除销售订单管理
     * 
     * @param orderIds 需要删除的销售订单管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTbSalesOrderByOrderIds(Long[] orderIds)
    {
        tbSalesOrderMapper.deleteTbSalesDetailByOrderIds(orderIds);
        return tbSalesOrderMapper.deleteTbSalesOrderByOrderIds(orderIds);
    }

    /**
     * 删除销售订单管理信息
     * 
     * @param orderId 销售订单管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTbSalesOrderByOrderId(Long orderId)
    {
        tbSalesOrderMapper.deleteTbSalesDetailByOrderId(orderId);
        return tbSalesOrderMapper.deleteTbSalesOrderByOrderId(orderId);
    }

    /**
     * 新增销售从表管理信息
     * 
     * @param tbSalesOrder 销售订单管理对象
     */
    public void insertTbSalesDetail(TbSalesOrder tbSalesOrder)
    {
        List<TbSalesDetail> tbSalesDetailList = tbSalesOrder.getTbSalesDetailList();
        Long orderId = tbSalesOrder.getOrderId();
        if (StringUtils.isNotNull(tbSalesDetailList))
        {
            List<TbSalesDetail> list = new ArrayList<TbSalesDetail>();
            for (TbSalesDetail tbSalesDetail : tbSalesDetailList)
            {
                tbSalesDetail.setOrderId(orderId);
                list.add(tbSalesDetail);
            }
            if (list.size() > 0)
            {
                tbSalesOrderMapper.batchTbSalesDetail(list);
            }
        }
    }
}

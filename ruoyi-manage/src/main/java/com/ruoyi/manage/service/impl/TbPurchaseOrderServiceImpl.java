package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.manage.domain.TbPurchaseDetail;
import com.ruoyi.manage.mapper.TbPurchaseOrderMapper;
import com.ruoyi.manage.domain.TbPurchaseOrder;
import com.ruoyi.manage.service.ITbPurchaseOrderService;

/**
 * 进货订单管理Service业务层处理
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@Service
public class TbPurchaseOrderServiceImpl implements ITbPurchaseOrderService 
{
    @Autowired
    private TbPurchaseOrderMapper tbPurchaseOrderMapper;

    /**
     * 查询进货订单管理
     * 
     * @param orderId 进货订单管理主键
     * @return 进货订单管理
     */
    @Override
    public TbPurchaseOrder selectTbPurchaseOrderByOrderId(Long orderId)
    {
        return tbPurchaseOrderMapper.selectTbPurchaseOrderByOrderId(orderId);
    }

    /**
     * 查询进货订单管理列表
     * 
     * @param tbPurchaseOrder 进货订单管理
     * @return 进货订单管理
     */
    @Override
    public List<TbPurchaseOrder> selectTbPurchaseOrderList(TbPurchaseOrder tbPurchaseOrder)
    {
        return tbPurchaseOrderMapper.selectTbPurchaseOrderList(tbPurchaseOrder);
    }

    /**
     * 新增进货订单管理
     * 
     * @param tbPurchaseOrder 进货订单管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertTbPurchaseOrder(TbPurchaseOrder tbPurchaseOrder)
    {
        int rows = tbPurchaseOrderMapper.insertTbPurchaseOrder(tbPurchaseOrder);
        insertTbPurchaseDetail(tbPurchaseOrder);
        return rows;
    }

    /**
     * 修改进货订单管理
     * 
     * @param tbPurchaseOrder 进货订单管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateTbPurchaseOrder(TbPurchaseOrder tbPurchaseOrder)
    {
        tbPurchaseOrderMapper.deleteTbPurchaseDetailByOrderId(tbPurchaseOrder.getOrderId());
        insertTbPurchaseDetail(tbPurchaseOrder);
        return tbPurchaseOrderMapper.updateTbPurchaseOrder(tbPurchaseOrder);
    }

    /**
     * 批量删除进货订单管理
     * 
     * @param orderIds 需要删除的进货订单管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTbPurchaseOrderByOrderIds(Long[] orderIds)
    {
        tbPurchaseOrderMapper.deleteTbPurchaseDetailByOrderIds(orderIds);
        return tbPurchaseOrderMapper.deleteTbPurchaseOrderByOrderIds(orderIds);
    }

    /**
     * 删除进货订单管理信息
     * 
     * @param orderId 进货订单管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTbPurchaseOrderByOrderId(Long orderId)
    {
        tbPurchaseOrderMapper.deleteTbPurchaseDetailByOrderId(orderId);
        return tbPurchaseOrderMapper.deleteTbPurchaseOrderByOrderId(orderId);
    }

    /**
     * 新增进货从表管理信息
     * 
     * @param tbPurchaseOrder 进货订单管理对象
     */
    public void insertTbPurchaseDetail(TbPurchaseOrder tbPurchaseOrder)
    {
        List<TbPurchaseDetail> tbPurchaseDetailList = tbPurchaseOrder.getTbPurchaseDetailList();
        Long orderId = tbPurchaseOrder.getOrderId();
        if (StringUtils.isNotNull(tbPurchaseDetailList))
        {
            List<TbPurchaseDetail> list = new ArrayList<TbPurchaseDetail>();
            for (TbPurchaseDetail tbPurchaseDetail : tbPurchaseDetailList)
            {
                tbPurchaseDetail.setOrderId(orderId);
                list.add(tbPurchaseDetail);
            }
            if (list.size() > 0)
            {
                tbPurchaseOrderMapper.batchTbPurchaseDetail(list);
            }
        }
    }
}

package com.ruoyi.manage.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 进货订单管理对象 tb_purchase_order
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public class TbPurchaseOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 进货订单id */
    @Excel(name = "进货订单id")
    private Long orderId;

    /** 进货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "进货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderDate;

    /** 进货从表管理信息 */
    private List<TbPurchaseDetail> tbPurchaseDetailList;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }

    public void setOrderDate(Date orderDate) 
    {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() 
    {
        return orderDate;
    }

    public List<TbPurchaseDetail> getTbPurchaseDetailList()
    {
        return tbPurchaseDetailList;
    }

    public void setTbPurchaseDetailList(List<TbPurchaseDetail> tbPurchaseDetailList)
    {
        this.tbPurchaseDetailList = tbPurchaseDetailList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("orderDate", getOrderDate())
            .append("tbPurchaseDetailList", getTbPurchaseDetailList())
            .toString();
    }
}

package com.ruoyi.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 进货从表管理对象 tb_purchase_detail
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public class TbPurchaseDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 进货从表id */
    private Long detailId;

    /** 进货主表id */
    @Excel(name = "进货主表id")
    private Long orderId;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long warehouseId;

    /** 图书id */
    @Excel(name = "图书id")
    private Long bookId;

    /** 数量 */
    @Excel(name = "数量")
    private Long quantity;

    public void setDetailId(Long detailId) 
    {
        this.detailId = detailId;
    }

    public Long getDetailId() 
    {
        return detailId;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
    }
    public void setBookId(Long bookId) 
    {
        this.bookId = bookId;
    }

    public Long getBookId() 
    {
        return bookId;
    }
    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("detailId", getDetailId())
            .append("orderId", getOrderId())
            .append("warehouseId", getWarehouseId())
            .append("bookId", getBookId())
            .append("quantity", getQuantity())
            .toString();
    }
}

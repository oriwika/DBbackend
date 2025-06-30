package com.ruoyi.manage.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图书信息管理对象 tb_book
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public class TbBook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图书id */
    @Excel(name = "图书id")
    private Long bookId;

    /** 书籍名称 */
    @Excel(name = "书籍名称")
    private String title;

    /** 作者名称 */
    @Excel(name = "作者名称")
    private String author;

    /** 类别id */
    @Excel(name = "类别id")
    private Long categoryId;

    /** 出版社id */
    @Excel(name = "出版社id")
    private Long publisherId;

    /** 进货价 */
    @Excel(name = "进货价")
    private BigDecimal purchasePrice;

    /** 零售价 */
    @Excel(name = "零售价")
    private BigDecimal retailPrice;

    /** 总库存 */
    @Excel(name = "总库存")
    private Long totalStock;

    public void setBookId(Long bookId) 
    {
        this.bookId = bookId;
    }

    public Long getBookId() 
    {
        return bookId;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }

    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }

    public void setPublisherId(Long publisherId) 
    {
        this.publisherId = publisherId;
    }

    public Long getPublisherId() 
    {
        return publisherId;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) 
    {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getPurchasePrice() 
    {
        return purchasePrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) 
    {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getRetailPrice() 
    {
        return retailPrice;
    }

    public void setTotalStock(Long totalStock) 
    {
        this.totalStock = totalStock;
    }

    public Long getTotalStock() 
    {
        return totalStock;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bookId", getBookId())
            .append("title", getTitle())
            .append("author", getAuthor())
            .append("categoryId", getCategoryId())
            .append("publisherId", getPublisherId())
            .append("purchasePrice", getPurchasePrice())
            .append("retailPrice", getRetailPrice())
            .append("totalStock", getTotalStock())
            .toString();
    }
}

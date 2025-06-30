package com.ruoyi.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 各类别图书库存详情对象 vw_categoryinventory
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public class VwCategoryinventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图书类别id */
    @Excel(name = "图书类别id")
    private Long categoryId;

    /** 图书类名 */
    @Excel(name = "图书类名")
    private String categoryName;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long totalInventory;

    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }

    public void setCategoryName(String categoryName) 
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName() 
    {
        return categoryName;
    }

    public void setTotalInventory(Long totalInventory) 
    {
        this.totalInventory = totalInventory;
    }

    public Long getTotalInventory() 
    {
        return totalInventory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("categoryId", getCategoryId())
            .append("categoryName", getCategoryName())
            .append("totalInventory", getTotalInventory())
            .toString();
    }
}

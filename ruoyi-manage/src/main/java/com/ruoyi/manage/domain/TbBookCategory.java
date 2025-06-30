package com.ruoyi.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 书类管理对象 tb_book_category
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public class TbBookCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 书类ID */
    @Excel(name = "书类ID")
    private Long categoryId;

    /** 书类名 */
    @Excel(name = "书类名")
    private String categoryName;

    /** 书类描述 */
    @Excel(name = "书类描述")
    private String description;

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

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("categoryId", getCategoryId())
            .append("categoryName", getCategoryName())
            .append("description", getDescription())
            .toString();
    }
}

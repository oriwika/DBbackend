package com.ruoyi.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出版社管理对象 tb_publisher
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public class TbPublisher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出版社id */
    @Excel(name = "出版社id")
    private Long publisherId;

    /** 出版社名称 */
    @Excel(name = "出版社名称")
    private String publisherName;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contactPhone;

    /** 出版社地址 */
    @Excel(name = "出版社地址")
    private String address;

    public void setPublisherId(Long publisherId) 
    {
        this.publisherId = publisherId;
    }

    public Long getPublisherId() 
    {
        return publisherId;
    }

    public void setPublisherName(String publisherName) 
    {
        this.publisherName = publisherName;
    }

    public String getPublisherName() 
    {
        return publisherName;
    }

    public void setContactPhone(String contactPhone) 
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() 
    {
        return contactPhone;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("publisherId", getPublisherId())
            .append("publisherName", getPublisherName())
            .append("contactPhone", getContactPhone())
            .append("address", getAddress())
            .toString();
    }
}

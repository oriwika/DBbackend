package com.ruoyi.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓库管理对象 tb_warehouse
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public class TbWarehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long warehouseId;

    /** 仓库名 */
    @Excel(name = "仓库名")
    private String warehouseName;

    /** 仓库地址 */
    @Excel(name = "仓库地址")
    private String location;

    /** 管理人信息 */
    @Excel(name = "管理人信息")
    private String manager;

    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
    }

    public void setWarehouseName(String warehouseName) 
    {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName() 
    {
        return warehouseName;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }

    public void setManager(String manager) 
    {
        this.manager = manager;
    }

    public String getManager() 
    {
        return manager;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("warehouseId", getWarehouseId())
            .append("warehouseName", getWarehouseName())
            .append("location", getLocation())
            .append("manager", getManager())
            .toString();
    }
}

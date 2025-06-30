package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.TbWarehouse;

/**
 * 仓库管理Mapper接口
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public interface TbWarehouseMapper 
{
    /**
     * 查询仓库管理
     * 
     * @param warehouseId 仓库管理主键
     * @return 仓库管理
     */
    public TbWarehouse selectTbWarehouseByWarehouseId(Long warehouseId);

    /**
     * 查询仓库管理列表
     * 
     * @param tbWarehouse 仓库管理
     * @return 仓库管理集合
     */
    public List<TbWarehouse> selectTbWarehouseList(TbWarehouse tbWarehouse);

    /**
     * 新增仓库管理
     * 
     * @param tbWarehouse 仓库管理
     * @return 结果
     */
    public int insertTbWarehouse(TbWarehouse tbWarehouse);

    /**
     * 修改仓库管理
     * 
     * @param tbWarehouse 仓库管理
     * @return 结果
     */
    public int updateTbWarehouse(TbWarehouse tbWarehouse);

    /**
     * 删除仓库管理
     * 
     * @param warehouseId 仓库管理主键
     * @return 结果
     */
    public int deleteTbWarehouseByWarehouseId(Long warehouseId);

    /**
     * 批量删除仓库管理
     * 
     * @param warehouseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbWarehouseByWarehouseIds(Long[] warehouseIds);
}

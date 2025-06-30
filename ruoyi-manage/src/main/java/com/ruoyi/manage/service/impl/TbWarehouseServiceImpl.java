package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.TbWarehouseMapper;
import com.ruoyi.manage.domain.TbWarehouse;
import com.ruoyi.manage.service.ITbWarehouseService;

/**
 * 仓库管理Service业务层处理
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@Service
public class TbWarehouseServiceImpl implements ITbWarehouseService 
{
    @Autowired
    private TbWarehouseMapper tbWarehouseMapper;

    /**
     * 查询仓库管理
     * 
     * @param warehouseId 仓库管理主键
     * @return 仓库管理
     */
    @Override
    public TbWarehouse selectTbWarehouseByWarehouseId(Long warehouseId)
    {
        return tbWarehouseMapper.selectTbWarehouseByWarehouseId(warehouseId);
    }

    /**
     * 查询仓库管理列表
     * 
     * @param tbWarehouse 仓库管理
     * @return 仓库管理
     */
    @Override
    public List<TbWarehouse> selectTbWarehouseList(TbWarehouse tbWarehouse)
    {
        return tbWarehouseMapper.selectTbWarehouseList(tbWarehouse);
    }

    /**
     * 新增仓库管理
     * 
     * @param tbWarehouse 仓库管理
     * @return 结果
     */
    @Override
    public int insertTbWarehouse(TbWarehouse tbWarehouse)
    {
        return tbWarehouseMapper.insertTbWarehouse(tbWarehouse);
    }

    /**
     * 修改仓库管理
     * 
     * @param tbWarehouse 仓库管理
     * @return 结果
     */
    @Override
    public int updateTbWarehouse(TbWarehouse tbWarehouse)
    {
        return tbWarehouseMapper.updateTbWarehouse(tbWarehouse);
    }

    /**
     * 批量删除仓库管理
     * 
     * @param warehouseIds 需要删除的仓库管理主键
     * @return 结果
     */
    @Override
    public int deleteTbWarehouseByWarehouseIds(Long[] warehouseIds)
    {
        return tbWarehouseMapper.deleteTbWarehouseByWarehouseIds(warehouseIds);
    }

    /**
     * 删除仓库管理信息
     * 
     * @param warehouseId 仓库管理主键
     * @return 结果
     */
    @Override
    public int deleteTbWarehouseByWarehouseId(Long warehouseId)
    {
        return tbWarehouseMapper.deleteTbWarehouseByWarehouseId(warehouseId);
    }
}

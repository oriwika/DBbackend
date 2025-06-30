package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.VwCategoryinventoryMapper;
import com.ruoyi.manage.domain.VwCategoryinventory;
import com.ruoyi.manage.service.IVwCategoryinventoryService;

/**
 * 各类别图书库存详情Service业务层处理
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@Service
public class VwCategoryinventoryServiceImpl implements IVwCategoryinventoryService 
{
    @Autowired
    private VwCategoryinventoryMapper vwCategoryinventoryMapper;

    /**
     * 查询各类别图书库存详情
     * 
     * @param categoryId 各类别图书库存详情主键
     * @return 各类别图书库存详情
     */
    @Override
    public VwCategoryinventory selectVwCategoryinventoryByCategoryId(Long categoryId)
    {
        return vwCategoryinventoryMapper.selectVwCategoryinventoryByCategoryId(categoryId);
    }

    /**
     * 查询各类别图书库存详情列表
     * 
     * @param vwCategoryinventory 各类别图书库存详情
     * @return 各类别图书库存详情
     */
    @Override
    public List<VwCategoryinventory> selectVwCategoryinventoryList(VwCategoryinventory vwCategoryinventory)
    {
        return vwCategoryinventoryMapper.selectVwCategoryinventoryList(vwCategoryinventory);
    }

    /**
     * 新增各类别图书库存详情
     * 
     * @param vwCategoryinventory 各类别图书库存详情
     * @return 结果
     */
    @Override
    public int insertVwCategoryinventory(VwCategoryinventory vwCategoryinventory)
    {
        return vwCategoryinventoryMapper.insertVwCategoryinventory(vwCategoryinventory);
    }

    /**
     * 修改各类别图书库存详情
     * 
     * @param vwCategoryinventory 各类别图书库存详情
     * @return 结果
     */
    @Override
    public int updateVwCategoryinventory(VwCategoryinventory vwCategoryinventory)
    {
        return vwCategoryinventoryMapper.updateVwCategoryinventory(vwCategoryinventory);
    }

    /**
     * 批量删除各类别图书库存详情
     * 
     * @param categoryIds 需要删除的各类别图书库存详情主键
     * @return 结果
     */
    @Override
    public int deleteVwCategoryinventoryByCategoryIds(Long[] categoryIds)
    {
        return vwCategoryinventoryMapper.deleteVwCategoryinventoryByCategoryIds(categoryIds);
    }

    /**
     * 删除各类别图书库存详情信息
     * 
     * @param categoryId 各类别图书库存详情主键
     * @return 结果
     */
    @Override
    public int deleteVwCategoryinventoryByCategoryId(Long categoryId)
    {
        return vwCategoryinventoryMapper.deleteVwCategoryinventoryByCategoryId(categoryId);
    }
}

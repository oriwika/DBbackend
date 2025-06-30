package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.VwCategoryinventory;

/**
 * 各类别图书库存详情Service接口
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public interface IVwCategoryinventoryService 
{
    /**
     * 查询各类别图书库存详情
     * 
     * @param categoryId 各类别图书库存详情主键
     * @return 各类别图书库存详情
     */
    public VwCategoryinventory selectVwCategoryinventoryByCategoryId(Long categoryId);

    /**
     * 查询各类别图书库存详情列表
     * 
     * @param vwCategoryinventory 各类别图书库存详情
     * @return 各类别图书库存详情集合
     */
    public List<VwCategoryinventory> selectVwCategoryinventoryList(VwCategoryinventory vwCategoryinventory);

    /**
     * 新增各类别图书库存详情
     * 
     * @param vwCategoryinventory 各类别图书库存详情
     * @return 结果
     */
    public int insertVwCategoryinventory(VwCategoryinventory vwCategoryinventory);

    /**
     * 修改各类别图书库存详情
     * 
     * @param vwCategoryinventory 各类别图书库存详情
     * @return 结果
     */
    public int updateVwCategoryinventory(VwCategoryinventory vwCategoryinventory);

    /**
     * 批量删除各类别图书库存详情
     * 
     * @param categoryIds 需要删除的各类别图书库存详情主键集合
     * @return 结果
     */
    public int deleteVwCategoryinventoryByCategoryIds(Long[] categoryIds);

    /**
     * 删除各类别图书库存详情信息
     * 
     * @param categoryId 各类别图书库存详情主键
     * @return 结果
     */
    public int deleteVwCategoryinventoryByCategoryId(Long categoryId);
}

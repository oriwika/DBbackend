package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.TbBookCategory;

/**
 * 书类管理Service接口
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public interface ITbBookCategoryService 
{
    /**
     * 查询书类管理
     * 
     * @param categoryId 书类管理主键
     * @return 书类管理
     */
    public TbBookCategory selectTbBookCategoryByCategoryId(Long categoryId);

    /**
     * 查询书类管理列表
     * 
     * @param tbBookCategory 书类管理
     * @return 书类管理集合
     */
    public List<TbBookCategory> selectTbBookCategoryList(TbBookCategory tbBookCategory);

    /**
     * 新增书类管理
     * 
     * @param tbBookCategory 书类管理
     * @return 结果
     */
    public int insertTbBookCategory(TbBookCategory tbBookCategory);

    /**
     * 修改书类管理
     * 
     * @param tbBookCategory 书类管理
     * @return 结果
     */
    public int updateTbBookCategory(TbBookCategory tbBookCategory);

    /**
     * 批量删除书类管理
     * 
     * @param categoryIds 需要删除的书类管理主键集合
     * @return 结果
     */
    public int deleteTbBookCategoryByCategoryIds(Long[] categoryIds);

    /**
     * 删除书类管理信息
     * 
     * @param categoryId 书类管理主键
     * @return 结果
     */
    public int deleteTbBookCategoryByCategoryId(Long categoryId);
}

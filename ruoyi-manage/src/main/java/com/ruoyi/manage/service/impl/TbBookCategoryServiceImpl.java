package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.TbBookCategoryMapper;
import com.ruoyi.manage.domain.TbBookCategory;
import com.ruoyi.manage.service.ITbBookCategoryService;

/**
 * 书类管理Service业务层处理
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@Service
public class TbBookCategoryServiceImpl implements ITbBookCategoryService 
{
    @Autowired
    private TbBookCategoryMapper tbBookCategoryMapper;

    /**
     * 查询书类管理
     * 
     * @param categoryId 书类管理主键
     * @return 书类管理
     */
    @Override
    public TbBookCategory selectTbBookCategoryByCategoryId(Long categoryId)
    {
        return tbBookCategoryMapper.selectTbBookCategoryByCategoryId(categoryId);
    }

    /**
     * 查询书类管理列表
     * 
     * @param tbBookCategory 书类管理
     * @return 书类管理
     */
    @Override
    public List<TbBookCategory> selectTbBookCategoryList(TbBookCategory tbBookCategory)
    {
        return tbBookCategoryMapper.selectTbBookCategoryList(tbBookCategory);
    }

    /**
     * 新增书类管理
     * 
     * @param tbBookCategory 书类管理
     * @return 结果
     */
    @Override
    public int insertTbBookCategory(TbBookCategory tbBookCategory)
    {
        return tbBookCategoryMapper.insertTbBookCategory(tbBookCategory);
    }

    /**
     * 修改书类管理
     * 
     * @param tbBookCategory 书类管理
     * @return 结果
     */
    @Override
    public int updateTbBookCategory(TbBookCategory tbBookCategory)
    {
        return tbBookCategoryMapper.updateTbBookCategory(tbBookCategory);
    }

    /**
     * 批量删除书类管理
     * 
     * @param categoryIds 需要删除的书类管理主键
     * @return 结果
     */
    @Override
    public int deleteTbBookCategoryByCategoryIds(Long[] categoryIds)
    {
        return tbBookCategoryMapper.deleteTbBookCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除书类管理信息
     * 
     * @param categoryId 书类管理主键
     * @return 结果
     */
    @Override
    public int deleteTbBookCategoryByCategoryId(Long categoryId)
    {
        return tbBookCategoryMapper.deleteTbBookCategoryByCategoryId(categoryId);
    }
}

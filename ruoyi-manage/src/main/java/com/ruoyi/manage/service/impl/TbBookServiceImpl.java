package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.TbBookMapper;
import com.ruoyi.manage.domain.TbBook;
import com.ruoyi.manage.service.ITbBookService;

/**
 * 图书信息管理Service业务层处理
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@Service
public class TbBookServiceImpl implements ITbBookService 
{
    @Autowired
    private TbBookMapper tbBookMapper;

    /**
     * 查询图书信息管理
     * 
     * @param bookId 图书信息管理主键
     * @return 图书信息管理
     */
    @Override
    public TbBook selectTbBookByBookId(Long bookId)
    {
        return tbBookMapper.selectTbBookByBookId(bookId);
    }

    /**
     * 查询图书信息管理列表
     * 
     * @param tbBook 图书信息管理
     * @return 图书信息管理
     */
    @Override
    public List<TbBook> selectTbBookList(TbBook tbBook)
    {
        return tbBookMapper.selectTbBookList(tbBook);
    }

    /**
     * 新增图书信息管理
     * 
     * @param tbBook 图书信息管理
     * @return 结果
     */
    @Override
    public int insertTbBook(TbBook tbBook)
    {
        return tbBookMapper.insertTbBook(tbBook);
    }

    /**
     * 修改图书信息管理
     * 
     * @param tbBook 图书信息管理
     * @return 结果
     */
    @Override
    public int updateTbBook(TbBook tbBook)
    {
        return tbBookMapper.updateTbBook(tbBook);
    }

    /**
     * 批量删除图书信息管理
     * 
     * @param bookIds 需要删除的图书信息管理主键
     * @return 结果
     */
    @Override
    public int deleteTbBookByBookIds(Long[] bookIds)
    {
        return tbBookMapper.deleteTbBookByBookIds(bookIds);
    }

    /**
     * 删除图书信息管理信息
     * 
     * @param bookId 图书信息管理主键
     * @return 结果
     */
    @Override
    public int deleteTbBookByBookId(Long bookId)
    {
        return tbBookMapper.deleteTbBookByBookId(bookId);
    }
}

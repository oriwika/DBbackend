package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.TbBook;

/**
 * 图书信息管理Service接口
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public interface ITbBookService 
{
    /**
     * 查询图书信息管理
     * 
     * @param bookId 图书信息管理主键
     * @return 图书信息管理
     */
    public TbBook selectTbBookByBookId(Long bookId);

    /**
     * 查询图书信息管理列表
     * 
     * @param tbBook 图书信息管理
     * @return 图书信息管理集合
     */
    public List<TbBook> selectTbBookList(TbBook tbBook);

    /**
     * 新增图书信息管理
     * 
     * @param tbBook 图书信息管理
     * @return 结果
     */
    public int insertTbBook(TbBook tbBook);

    /**
     * 修改图书信息管理
     * 
     * @param tbBook 图书信息管理
     * @return 结果
     */
    public int updateTbBook(TbBook tbBook);

    /**
     * 批量删除图书信息管理
     * 
     * @param bookIds 需要删除的图书信息管理主键集合
     * @return 结果
     */
    public int deleteTbBookByBookIds(Long[] bookIds);

    /**
     * 删除图书信息管理信息
     * 
     * @param bookId 图书信息管理主键
     * @return 结果
     */
    public int deleteTbBookByBookId(Long bookId);
}

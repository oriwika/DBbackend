package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.TbBook;

/**
 * 图书信息管理Mapper接口
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public interface TbBookMapper 
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
     * 删除图书信息管理
     * 
     * @param bookId 图书信息管理主键
     * @return 结果
     */
    public int deleteTbBookByBookId(Long bookId);

    /**
     * 批量删除图书信息管理
     * 
     * @param bookIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbBookByBookIds(Long[] bookIds);
}

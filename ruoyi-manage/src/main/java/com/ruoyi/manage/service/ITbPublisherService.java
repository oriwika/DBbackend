package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.TbPublisher;

/**
 * 出版社管理Service接口
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
public interface ITbPublisherService 
{
    /**
     * 查询出版社管理
     * 
     * @param publisherId 出版社管理主键
     * @return 出版社管理
     */
    public TbPublisher selectTbPublisherByPublisherId(Long publisherId);

    /**
     * 查询出版社管理列表
     * 
     * @param tbPublisher 出版社管理
     * @return 出版社管理集合
     */
    public List<TbPublisher> selectTbPublisherList(TbPublisher tbPublisher);

    /**
     * 新增出版社管理
     * 
     * @param tbPublisher 出版社管理
     * @return 结果
     */
    public int insertTbPublisher(TbPublisher tbPublisher);

    /**
     * 修改出版社管理
     * 
     * @param tbPublisher 出版社管理
     * @return 结果
     */
    public int updateTbPublisher(TbPublisher tbPublisher);

    /**
     * 批量删除出版社管理
     * 
     * @param publisherIds 需要删除的出版社管理主键集合
     * @return 结果
     */
    public int deleteTbPublisherByPublisherIds(Long[] publisherIds);

    /**
     * 删除出版社管理信息
     * 
     * @param publisherId 出版社管理主键
     * @return 结果
     */
    public int deleteTbPublisherByPublisherId(Long publisherId);
}

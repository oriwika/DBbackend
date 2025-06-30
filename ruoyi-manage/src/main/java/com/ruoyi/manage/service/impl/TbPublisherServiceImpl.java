package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.TbPublisherMapper;
import com.ruoyi.manage.domain.TbPublisher;
import com.ruoyi.manage.service.ITbPublisherService;

/**
 * 出版社管理Service业务层处理
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@Service
public class TbPublisherServiceImpl implements ITbPublisherService 
{
    @Autowired
    private TbPublisherMapper tbPublisherMapper;

    /**
     * 查询出版社管理
     * 
     * @param publisherId 出版社管理主键
     * @return 出版社管理
     */
    @Override
    public TbPublisher selectTbPublisherByPublisherId(Long publisherId)
    {
        return tbPublisherMapper.selectTbPublisherByPublisherId(publisherId);
    }

    /**
     * 查询出版社管理列表
     * 
     * @param tbPublisher 出版社管理
     * @return 出版社管理
     */
    @Override
    public List<TbPublisher> selectTbPublisherList(TbPublisher tbPublisher)
    {
        return tbPublisherMapper.selectTbPublisherList(tbPublisher);
    }

    /**
     * 新增出版社管理
     * 
     * @param tbPublisher 出版社管理
     * @return 结果
     */
    @Override
    public int insertTbPublisher(TbPublisher tbPublisher)
    {
        return tbPublisherMapper.insertTbPublisher(tbPublisher);
    }

    /**
     * 修改出版社管理
     * 
     * @param tbPublisher 出版社管理
     * @return 结果
     */
    @Override
    public int updateTbPublisher(TbPublisher tbPublisher)
    {
        return tbPublisherMapper.updateTbPublisher(tbPublisher);
    }

    /**
     * 批量删除出版社管理
     * 
     * @param publisherIds 需要删除的出版社管理主键
     * @return 结果
     */
    @Override
    public int deleteTbPublisherByPublisherIds(Long[] publisherIds)
    {
        return tbPublisherMapper.deleteTbPublisherByPublisherIds(publisherIds);
    }

    /**
     * 删除出版社管理信息
     * 
     * @param publisherId 出版社管理主键
     * @return 结果
     */
    @Override
    public int deleteTbPublisherByPublisherId(Long publisherId)
    {
        return tbPublisherMapper.deleteTbPublisherByPublisherId(publisherId);
    }
}

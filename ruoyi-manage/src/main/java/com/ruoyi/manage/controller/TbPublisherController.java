package com.ruoyi.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.manage.domain.TbPublisher;
import com.ruoyi.manage.service.ITbPublisherService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出版社管理Controller
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@RestController
@RequestMapping("/manage/publisher")
public class TbPublisherController extends BaseController
{
    @Autowired
    private ITbPublisherService tbPublisherService;

    /**
     * 查询出版社管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:publisher:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbPublisher tbPublisher)
    {
        startPage();
        List<TbPublisher> list = tbPublisherService.selectTbPublisherList(tbPublisher);
        return getDataTable(list);
    }

    /**
     * 导出出版社管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:publisher:export')")
    @Log(title = "出版社管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbPublisher tbPublisher)
    {
        List<TbPublisher> list = tbPublisherService.selectTbPublisherList(tbPublisher);
        ExcelUtil<TbPublisher> util = new ExcelUtil<TbPublisher>(TbPublisher.class);
        util.exportExcel(response, list, "出版社管理数据");
    }

    /**
     * 获取出版社管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:publisher:query')")
    @GetMapping(value = "/{publisherId}")
    public AjaxResult getInfo(@PathVariable("publisherId") Long publisherId)
    {
        return success(tbPublisherService.selectTbPublisherByPublisherId(publisherId));
    }

    /**
     * 新增出版社管理
     */
    @PreAuthorize("@ss.hasPermi('manage:publisher:add')")
    @Log(title = "出版社管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbPublisher tbPublisher)
    {
        return toAjax(tbPublisherService.insertTbPublisher(tbPublisher));
    }

    /**
     * 修改出版社管理
     */
    @PreAuthorize("@ss.hasPermi('manage:publisher:edit')")
    @Log(title = "出版社管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbPublisher tbPublisher)
    {
        return toAjax(tbPublisherService.updateTbPublisher(tbPublisher));
    }

    /**
     * 删除出版社管理
     */
    @PreAuthorize("@ss.hasPermi('manage:publisher:remove')")
    @Log(title = "出版社管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{publisherIds}")
    public AjaxResult remove(@PathVariable Long[] publisherIds)
    {
        return toAjax(tbPublisherService.deleteTbPublisherByPublisherIds(publisherIds));
    }
}

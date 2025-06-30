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
import com.ruoyi.manage.domain.TbBookCategory;
import com.ruoyi.manage.service.ITbBookCategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 书类管理Controller
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@RestController
@RequestMapping("/manage/category")
public class TbBookCategoryController extends BaseController
{
    @Autowired
    private ITbBookCategoryService tbBookCategoryService;

    /**
     * 查询书类管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbBookCategory tbBookCategory)
    {
        startPage();
        List<TbBookCategory> list = tbBookCategoryService.selectTbBookCategoryList(tbBookCategory);
        return getDataTable(list);
    }

    /**
     * 导出书类管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:category:export')")
    @Log(title = "书类管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbBookCategory tbBookCategory)
    {
        List<TbBookCategory> list = tbBookCategoryService.selectTbBookCategoryList(tbBookCategory);
        ExcelUtil<TbBookCategory> util = new ExcelUtil<TbBookCategory>(TbBookCategory.class);
        util.exportExcel(response, list, "书类管理数据");
    }

    /**
     * 获取书类管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:category:query')")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId)
    {
        return success(tbBookCategoryService.selectTbBookCategoryByCategoryId(categoryId));
    }

    /**
     * 新增书类管理
     */
    @PreAuthorize("@ss.hasPermi('manage:category:add')")
    @Log(title = "书类管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbBookCategory tbBookCategory)
    {
        return toAjax(tbBookCategoryService.insertTbBookCategory(tbBookCategory));
    }

    /**
     * 修改书类管理
     */
    @PreAuthorize("@ss.hasPermi('manage:category:edit')")
    @Log(title = "书类管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbBookCategory tbBookCategory)
    {
        return toAjax(tbBookCategoryService.updateTbBookCategory(tbBookCategory));
    }

    /**
     * 删除书类管理
     */
    @PreAuthorize("@ss.hasPermi('manage:category:remove')")
    @Log(title = "书类管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Long[] categoryIds)
    {
        return toAjax(tbBookCategoryService.deleteTbBookCategoryByCategoryIds(categoryIds));
    }
}

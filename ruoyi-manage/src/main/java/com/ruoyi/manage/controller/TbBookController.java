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
import com.ruoyi.manage.domain.TbBook;
import com.ruoyi.manage.service.ITbBookService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图书信息管理Controller
 * 
 * @author 廖宏宇
 * @date 2025-06-30
 */
@RestController
@RequestMapping("/manage/book")
public class TbBookController extends BaseController
{
    @Autowired
    private ITbBookService tbBookService;

    /**
     * 查询图书信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:book:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbBook tbBook)
    {
        startPage();
        List<TbBook> list = tbBookService.selectTbBookList(tbBook);
        return getDataTable(list);
    }

    /**
     * 导出图书信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:book:export')")
    @Log(title = "图书信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbBook tbBook)
    {
        List<TbBook> list = tbBookService.selectTbBookList(tbBook);
        ExcelUtil<TbBook> util = new ExcelUtil<TbBook>(TbBook.class);
        util.exportExcel(response, list, "图书信息管理数据");
    }

    /**
     * 获取图书信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:book:query')")
    @GetMapping(value = "/{bookId}")
    public AjaxResult getInfo(@PathVariable("bookId") Long bookId)
    {
        return success(tbBookService.selectTbBookByBookId(bookId));
    }

    /**
     * 新增图书信息管理
     */
    @PreAuthorize("@ss.hasPermi('manage:book:add')")
    @Log(title = "图书信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbBook tbBook)
    {
        return toAjax(tbBookService.insertTbBook(tbBook));
    }

    /**
     * 修改图书信息管理
     */
    @PreAuthorize("@ss.hasPermi('manage:book:edit')")
    @Log(title = "图书信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbBook tbBook)
    {
        return toAjax(tbBookService.updateTbBook(tbBook));
    }

    /**
     * 删除图书信息管理
     */
    @PreAuthorize("@ss.hasPermi('manage:book:remove')")
    @Log(title = "图书信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bookIds}")
    public AjaxResult remove(@PathVariable Long[] bookIds)
    {
        return toAjax(tbBookService.deleteTbBookByBookIds(bookIds));
    }
}

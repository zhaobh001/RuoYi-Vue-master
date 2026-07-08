package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.SysNotice;
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
import com.ruoyi.system.domain.Storeroom;
import com.ruoyi.system.service.IStoreroomService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 库房Controller
 * 
 * @author ruoyi
 * @date 2023-07-01
 */
@RestController
@RequestMapping("/system/storeroom")
public class StoreroomController extends BaseController
{
    @Autowired
    private IStoreroomService storeroomService;

    /**
     * 查询库房列表
     */
    @PreAuthorize("@ss.hasPermi('system:storeroom:list')")
    @GetMapping("/list")
    public TableDataInfo list(Storeroom storeroom)
    {
        startPage();
        List<Storeroom> list = storeroomService.selectStoreroomList(storeroom);
        return getDataTable(list);
    }
    /**
     * 导出库房列表
     */
    @PreAuthorize("@ss.hasPermi('system:storeroom:export')")
    @Log(title = "库房", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Storeroom storeroom)
    {
        List<Storeroom> list = storeroomService.selectStoreroomList(storeroom);
        ExcelUtil<Storeroom> util = new ExcelUtil<Storeroom>(Storeroom.class);
        util.exportExcel(response, list, "库房数据");
    }

    /**
     * 获取库房详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:storeroom:query')")
    @GetMapping(value = "/{storeroomid}")
    public AjaxResult getInfo(@PathVariable("storeroomid") Long storeroomid)
    {
        return success(storeroomService.selectStoreroomByStoreroomid(storeroomid));
    }

    /**
     * 新增库房
     */
    @PreAuthorize("@ss.hasPermi('system:storeroom:add')")
    @Log(title = "库房", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Storeroom storeroom)
    {
        return toAjax(storeroomService.insertStoreroom(storeroom));
    }

    /**
     * 修改库房
     */
    @PreAuthorize("@ss.hasPermi('system:storeroom:edit')")
    @Log(title = "库房", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Storeroom storeroom)
    {
        return toAjax(storeroomService.updateStoreroom(storeroom));
    }

    /**
     * 删除库房
     */
    @PreAuthorize("@ss.hasPermi('system:storeroom:remove')")
    @Log(title = "库房", businessType = BusinessType.DELETE)
	@DeleteMapping("/{storeroomids}")
    public AjaxResult remove(@PathVariable Long[] storeroomids)
    {
        return toAjax(storeroomService.deleteStoreroomByStoreroomids(storeroomids));
    }
}

package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysWebCount;
import com.ruoyi.system.service.ISysWebCountService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 监控网站访问量 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-08-22
 */
@Controller
@RequestMapping("/system/webCount")
public class SysWebCountController extends BaseController {
    private String prefix = "system/webCount";
	
	@Autowired
	private ISysWebCountService sysWebCountService;
	
	@RequiresPermissions("system:webCount:view")
	@GetMapping()
	public String sysWebCount() {
	    return prefix + "/webCount";
	}
	
	/**
	 * 查询监控网站访问量列表
	 */
	@RequiresPermissions("system:webCount:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysWebCount sysWebCount) {
		startPage();
        List<SysWebCount> list = sysWebCountService.selectSysWebCountList(sysWebCount);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出监控网站访问量列表
	 */
	@RequiresPermissions("system:webCount:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(SysWebCount sysWebCount) {
		List<SysWebCount> list = sysWebCountService.selectSysWebCountList(sysWebCount);
		ExcelUtil<SysWebCount> util = new ExcelUtil<SysWebCount>(SysWebCount.class);
		return util.exportExcel(list, "webCount");
	}
	
	/**
	 * 新增监控网站访问量
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}
	
	/**
	 * 新增保存监控网站访问量
	 */
	@RequiresPermissions("system:webCount:add")
	@Log(title = "监控网站访问量", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SysWebCount sysWebCount) {		
		return toAjax(sysWebCountService.insertSysWebCount(sysWebCount));
	}

	/**
	 * 修改监控网站访问量
	 */
	@GetMapping("/edit/{apiCode}")
	public String edit(@PathVariable("apiCode") String apiCode, ModelMap mmap) {
		SysWebCount sysWebCount = sysWebCountService.selectSysWebCountById(apiCode);
		mmap.put("sysWebCount", sysWebCount);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存监控网站访问量
	 */
	@RequiresPermissions("system:webCount:edit")
	@Log(title = "监控网站访问量", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SysWebCount sysWebCount) {		
		return toAjax(sysWebCountService.updateSysWebCount(sysWebCount));
	}
	
	/**
	 * 删除监控网站访问量
	 */
	@RequiresPermissions("system:webCount:remove")
	@Log(title = "监控网站访问量", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {		
		return toAjax(sysWebCountService.deleteSysWebCountByIds(ids));
	}
	
}

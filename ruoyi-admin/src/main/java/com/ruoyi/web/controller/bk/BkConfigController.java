package com.ruoyi.web.controller.bk;

import java.util.Date;
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
import com.ruoyi.bk.domain.BkConfig;
import com.ruoyi.bk.service.IBkConfigService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;

/**
 * 博客项目参数 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-07-25
 */
@Controller
@RequestMapping("/bk/bkConfig")
public class BkConfigController extends BaseController {
    private String prefix = "bk/bkConfig";
	
	@Autowired
	private IBkConfigService bkConfigService;
	
	@RequiresPermissions("bk:bkConfig:view")
	@GetMapping()
	public String bkConfig() {
	    return prefix + "/bkConfig";
	}
	
	/**
	 * 查询博客项目参数列表
	 */
	@RequiresPermissions("bk:bkConfig:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BkConfig bkConfig) {
		startPage();
        List<BkConfig> list = bkConfigService.selectBkConfigList(bkConfig);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出博客项目参数列表
	 */
	@RequiresPermissions("bk:bkConfig:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(BkConfig bkConfig) {
		List<BkConfig> list = bkConfigService.selectBkConfigList(bkConfig);
		ExcelUtil<BkConfig> util = new ExcelUtil<BkConfig>(BkConfig.class);
		return util.exportExcel(list, "bkConfig");
	}
	
	/**
	 * 新增博客项目参数
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}
	
	/**
	 * 新增保存博客项目参数
	 */
	@RequiresPermissions("bk:bkConfig:add")
	@Log(title = "博客项目参数", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BkConfig bkConfig) {	

		//获取登录用户
		SysUser user = ShiroUtils.getSysUser();
		bkConfig.setCreateDate(new Date());
		bkConfig.setCreateBy(user.getLoginName());
		
		return toAjax(bkConfigService.insertBkConfig(bkConfig));
	}

	/**
	 * 修改博客项目参数
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		BkConfig bkConfig = bkConfigService.selectBkConfigById(id);
		mmap.put("bkConfig", bkConfig);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存博客项目参数
	 */
	@RequiresPermissions("bk:bkConfig:edit")
	@Log(title = "博客项目参数", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BkConfig bkConfig) {		
		return toAjax(bkConfigService.updateBkConfig(bkConfig));
	}
	
	/**
	 * 删除博客项目参数
	 */
	@RequiresPermissions("bk:bkConfig:remove")
	@Log(title = "博客项目参数", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {		
		return toAjax(bkConfigService.deleteBkConfigByIds(ids));
	}
	
}

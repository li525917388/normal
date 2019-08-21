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
import com.ruoyi.bk.domain.BkWeService;
import com.ruoyi.bk.service.IBkWeServiceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;

/**
 * 我们的服务 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-07-25
 */
@Controller
@RequestMapping("/bk/bkWeService")
public class BkWeServiceController extends BaseController {
    private String prefix = "bk/bkWeService";
	
	@Autowired
	private IBkWeServiceService bkWeServiceService;
	
	@RequiresPermissions("bk:bkWeService:view")
	@GetMapping()
	public String bkWeService() {
	    return prefix + "/bkWeService";
	}
	
	/**
	 * 查询我们的服务列表
	 */
	@RequiresPermissions("bk:bkWeService:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BkWeService bkWeService) {
		startPage();
        List<BkWeService> list = bkWeServiceService.selectBkWeServiceList(bkWeService);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出我们的服务列表
	 */
	@RequiresPermissions("bk:bkWeService:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(BkWeService bkWeService) {
		List<BkWeService> list = bkWeServiceService.selectBkWeServiceList(bkWeService);
		ExcelUtil<BkWeService> util = new ExcelUtil<BkWeService>(BkWeService.class);
		return util.exportExcel(list, "bkWeService");
	}
	
	/**
	 * 新增我们的服务
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}
	
	/**
	 * 新增保存我们的服务
	 */
	@RequiresPermissions("bk:bkWeService:add")
	@Log(title = "我们的服务", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BkWeService bkWeService) {	
		
		//获取登录用户
		SysUser user = ShiroUtils.getSysUser();
				
		bkWeService.setCreateTime(new Date());
		bkWeService.setCreateBy(user.getLoginName());
		
		return toAjax(bkWeServiceService.insertBkWeService(bkWeService));
	}

	/**
	 * 修改我们的服务
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
		BkWeService bkWeService = bkWeServiceService.selectBkWeServiceById(id);
		mmap.put("bkWeService", bkWeService);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存我们的服务
	 */
	@RequiresPermissions("bk:bkWeService:edit")
	@Log(title = "我们的服务", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BkWeService bkWeService) {		
		return toAjax(bkWeServiceService.updateBkWeService(bkWeService));
	}
	
	/**
	 * 删除我们的服务
	 */
	@RequiresPermissions("bk:bkWeService:remove")
	@Log(title = "我们的服务", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {		
		return toAjax(bkWeServiceService.deleteBkWeServiceByIds(ids));
	}
	
}

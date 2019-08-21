package com.ruoyi.web.controller.ex;

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
import com.ruoyi.ex.domain.ScanSign;
import com.ruoyi.ex.service.IScanSignService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 签收 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-07-16
 */
@Controller
@RequestMapping("/ex/scanSign")
public class ScanSignController extends BaseController
{
    private String prefix = "ex/scanSign";
	
	@Autowired
	private IScanSignService scanSignService;
	
	@RequiresPermissions("ex:scanSign:view")
	@GetMapping()
	public String scanSign()
	{
	    return prefix + "/scanSign";
	}
	
	/**
	 * 查询签收列表
	 */
	@RequiresPermissions("ex:scanSign:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ScanSign scanSign)
	{
		startPage();
        List<ScanSign> list = scanSignService.selectScanSignList(scanSign);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出签收列表
	 */
	@RequiresPermissions("ex:scanSign:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ScanSign scanSign)
    {
    	List<ScanSign> list = scanSignService.selectScanSignList(scanSign);
        ExcelUtil<ScanSign> util = new ExcelUtil<ScanSign>(ScanSign.class);
        return util.exportExcel(list, "scanSign");
    }
	
	/**
	 * 新增签收
	 */
	@GetMapping("/add")
	public String add() {
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存签收
	 */
	@RequiresPermissions("ex:scanSign:add")
	@Log(title = "签收", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ScanSign scanSign) {	
		
		//获取登录用户
		SysUser user = ShiroUtils.getSysUser();
		
		scanSign.setCreateBy(user.getUserId() + "");
		scanSign.setSignDeptId(user.getDeptId());
		scanSign.setSignTime(new Date());
		scanSign.setCreateTime(new Date());
				
		return scanSignService.insertScanSign(scanSign);
	}

	/**
	 * 修改签收
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		ScanSign scanSign = scanSignService.selectScanSignById(id);
		mmap.put("scanSign", scanSign);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存签收
	 */
	@RequiresPermissions("ex:scanSign:edit")
	@Log(title = "签收", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ScanSign scanSign)
	{		
		return toAjax(scanSignService.updateScanSign(scanSign));
	}
	
	/**
	 * 删除签收
	 */
	@RequiresPermissions("ex:scanSign:remove")
	@Log(title = "签收", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(scanSignService.deleteScanSignByIds(ids));
	}
	
}

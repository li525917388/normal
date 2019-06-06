package com.ruoyi.web.controller.ex;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
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
import com.ruoyi.ex.domain.Waybill;
import com.ruoyi.ex.service.IWaybillService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 运单 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-05-31
 */
@Controller
@RequestMapping("/ex/waybill")
public class WaybillController extends BaseController
{
    private String prefix = "ex/waybill";
	
	@Autowired
	private IWaybillService waybillService;
	
	@RequiresPermissions("ex:waybill:view")
	@GetMapping()
	public String waybill()
	{
	    return prefix + "/waybill";
	}
	
	/**
	 * 查询运单列表
	 */
	@RequiresPermissions("ex:waybill:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Waybill waybill)
	{
		startPage();
        List<Waybill> list = waybillService.selectWaybillList(waybill);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出运单列表
	 */
	@RequiresPermissions("ex:waybill:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Waybill waybill)
    {
    	List<Waybill> list = waybillService.selectWaybillList(waybill);
        ExcelUtil<Waybill> util = new ExcelUtil<Waybill>(Waybill.class);
        return util.exportExcel(list, "waybill");
    }
	
	/**
	 * 新增运单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存运单
	 */
	@RequiresPermissions("ex:waybill:add")
	@Log(title = "运单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Waybill waybill)
	{		
		return toAjax(waybillService.insertWaybill(waybill));
	}

	/**
	 * 修改运单
	 */
	@GetMapping("/edit/{waybillId}")
	public String edit(@PathVariable("waybillId") Long waybillId, ModelMap mmap)
	{
		Waybill waybill = waybillService.selectWaybillById(waybillId);
		mmap.put("waybill", waybill);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存运单
	 */
	@RequiresPermissions("ex:waybill:edit")
	@Log(title = "运单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Waybill waybill)
	{		
		return toAjax(waybillService.updateWaybill(waybill));
	}
	
	/**
	 * 删除运单
	 */
	@RequiresPermissions("ex:waybill:remove")
	@Log(title = "运单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(waybillService.deleteWaybillByIds(ids));
	}
	
	

	
	
	/**
	 * 收件页面
	 * @return
	 */
	@RequiresPermissions("ex:waybill:pickup:view")
	@GetMapping("/pickup")
	public String pickup() {
	    return prefix + "/pickup/pickup";
	}
	
	
	
	/**
	 * 新增收件页面
	 * @return
	 */
	@GetMapping("/pickup/add")
	public String pickupAdd() {
	    return prefix + "/pickup/add";
	}
	
	

	/**
	 * 收件操作
	 * @param order
	 * @return
	 */
	@RequiresPermissions("ex:waybill:pickup:oper")
	@Log(title = "收件操作", businessType = BusinessType.UPDATE)
	@PostMapping("/pickup/add")
	@ResponseBody
	public AjaxResult pickupOper(Waybill waybill) {	
		
		//shiro
		Subject subject = SecurityUtils.getSubject();	
		//获取登录用户信息
		SysUser user = (SysUser) subject.getPrincipal();
		
		return toAjax(waybillService.pickupOper(waybill, user));
	}
	
	
	
	
	/**
	 * 发件页面
	 * @return
	 */
	@RequiresPermissions("ex:waybill:departure:view")
	@GetMapping("/departure")
	public String departure() {
	    return prefix + "/departure/departure";
	}
	
	
	
	/**
	 * 新增发件页面
	 * @return
	 */
	@GetMapping("/departure/add")
	public String departureAdd() {
	    return prefix + "/departure/add";
	}
}

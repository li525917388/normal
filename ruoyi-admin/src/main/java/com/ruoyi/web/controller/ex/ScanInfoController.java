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
import com.ruoyi.ex.domain.ScanInfo;
import com.ruoyi.ex.service.IScanInfoService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 扫描 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-06-05
 */
@Controller
@RequestMapping("/ex/scanInfo")
public class ScanInfoController extends BaseController
{
    private String prefix = "ex/scanInfo";
	
	@Autowired
	private IScanInfoService scanInfoService;
	
	
	
	@RequiresPermissions("ex:scanInfo:pickup:view")
	@GetMapping("/pickup")
	public String pickup()
	{
	    return prefix + "/pickup/pickup";
	}
	
	
	
	/**
	 * 查询扫描列表
	 */
	@RequiresPermissions("ex:scanInfo:pickup:list")
	@PostMapping("/pickup/list")
	@ResponseBody
	public TableDataInfo pickupList(ScanInfo scanInfo) {
		startPage();
		
		//获取当前登录信息
		SysUser user = ShiroUtils.getSysUser();
		
		scanInfo.setScanType(20);		//发件
		scanInfo.setScanUserId(user.getUserId());	//当前登录人
		
        List<ScanInfo> list = scanInfoService.selectScanTempList(scanInfo);
		return getDataTable(list);
	}
	
	
	

	/**
	 * 导出扫描列表
	 */
	@RequiresPermissions("ex:scanInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ScanInfo scanInfo) {
		
		//获取登录用户
		SysUser user = ShiroUtils.getSysUser();
		scanInfo.setScanUserId(user.getUserId()); //扫描员
		scanInfo.setScanDeptId(user.getDeptId()); //扫描网点
		
    	List<ScanInfo> list = scanInfoService.selectScanTempList(scanInfo);
        ExcelUtil<ScanInfo> util = new ExcelUtil<ScanInfo>(ScanInfo.class);
        return util.exportExcel(list, "scanInfo");
    }
	
	

	/**
	 * 上传数据
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:upload")
	@Log(title = "上传扫描数据", businessType = BusinessType.UPLOAD)
	@PostMapping( "/upload")
	@ResponseBody
	public AjaxResult upload(String ids) {
		
		return toAjax(scanInfoService.uploadScanInfoByIds(ids));
	}
	
	
	
	
	
	
	/**
	 * 新增收件扫描页面
	 * @return
	 */
	@GetMapping("/pickup/add")
	public String pickupAdd()
	{
	    return prefix + "/pickup/add";
	}
	
	
	/**
	 * 新增保存收件扫描
	 * @param scanInfo
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:pickup:add")
	@Log(title = "收件扫描", businessType = BusinessType.INSERT)
	@PostMapping("/pickup/add")
	@ResponseBody
	public AjaxResult pickupAddSave(ScanInfo scanInfo) {
		
		//获取登录用户
		SysUser user = ShiroUtils.getSysUser();
		scanInfo.setScanType(10);			//收件扫描
		scanInfo.setScanTime(new Date());
		scanInfo.setScanUserId(user.getUserId()); //扫描员
		scanInfo.setScanDeptId(user.getDeptId()); //扫描网点
		
		return toAjax(scanInfoService.insertScanTemp(scanInfo));
	}
	
	
	
	/**
	 * 修改收件扫描页面
	 * @param scanId
	 * @param mmap
	 * @return
	 */
	@GetMapping("/pickup/edit/{scanId}")
	public String pickupEdit(@PathVariable("scanId") Long scanId, ModelMap mmap) {
		ScanInfo scanInfo = scanInfoService.selectScanTempById(scanId);
		mmap.put("scanInfo", scanInfo);
	    return prefix + "/pickup/edit";
	}
	
	
	
	/**
	 * 修改保存收件扫描
	 * @param scanInfo
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:pickup:edit")
	@Log(title = "收件扫描", businessType = BusinessType.UPDATE)
	@PostMapping("/pickup/edit")
	@ResponseBody
	public AjaxResult pickupEditSave(ScanInfo scanInfo) {
		
		scanInfo.setScanType(10); 	//收件
		return toAjax(scanInfoService.updateScanTemp(scanInfo));
	}
	
	
	/**
	 * 删除收件扫描
	 */
	@RequiresPermissions("ex:scanInfo:pickup:remove")
	@Log(title = "收件扫描", businessType = BusinessType.DELETE)
	@PostMapping( "/pickup/remove")
	@ResponseBody
	public AjaxResult pickupRemove(String ids) {		
		return toAjax(scanInfoService.deleteScanTempByIds(ids));
	}
	
	
	
	
	/**
	 * 跳转发件页面
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:departure:view")
	@GetMapping("/departure")
	public String departure()
	{
	    return prefix + "/departure/departure";
	}
	
	/**
	 * 查询扫描列表
	 */
	@RequiresPermissions("ex:scanInfo:departure:view")
	@PostMapping("/departure/list")
	@ResponseBody
	public TableDataInfo departureList(ScanInfo scanInfo) {
		startPage();
		
		//获取当前登录信息
		SysUser user = ShiroUtils.getSysUser();
		
		scanInfo.setScanType(20);		//发件
		scanInfo.setScanUserId(user.getUserId());	//当前登录人
		
        List<ScanInfo> list = scanInfoService.selectScanTempList(scanInfo);
		return getDataTable(list);
	}
	
	
	
	/**
	 * 新增发件扫描页面
	 * @return
	 */
	@GetMapping("/departure/add")
	public String departureAdd()
	{
	    return prefix + "/departure/add";
	}
	
	/**
	 * 新增保存发件扫描
	 * @param scanInfo
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:departure:add")
	@Log(title = "扫描", businessType = BusinessType.INSERT)
	@PostMapping("/departure/add")
	@ResponseBody
	public AjaxResult departureAddSave(ScanInfo scanInfo) {
		
		//获取登录用户
		SysUser user = ShiroUtils.getSysUser();
		
		scanInfo.setScanType(20);			//发件扫描
		scanInfo.setScanTime(new Date());	//扫描时间
		scanInfo.setScanUserId(user.getUserId()); //扫描员
		scanInfo.setScanDeptId(user.getDeptId()); //扫描网点
		
		return toAjax(scanInfoService.insertScanTemp(scanInfo));
	}

	/**
	 * 修改发件扫描页面
	 * @param scanId
	 * @param mmap
	 * @return
	 */
	@GetMapping("/departure/edit/{scanId}")
	public String departureEdit(@PathVariable("scanId") Long scanId, ModelMap mmap) {
		ScanInfo scanInfo = scanInfoService.selectScanTempById(scanId);
		mmap.put("scanInfo", scanInfo);
	    return prefix + "/departure/edit";
	}
	
	/**
	 * 修改保存发件扫描
	 * @param scanInfo
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:departure:edit")
	@Log(title = "扫描", businessType = BusinessType.UPDATE)
	@PostMapping("/departure/edit")
	@ResponseBody
	public AjaxResult departureEditSave(ScanInfo scanInfo) {
		
		scanInfo.setScanType(20); 		//发件
		return toAjax(scanInfoService.updateScanTemp(scanInfo));
	}
	
	
	
	/**
	 * 删除发件扫描
	 */
	@RequiresPermissions("ex:scanInfo:departure:remove")
	@Log(title = "发件扫描", businessType = BusinessType.DELETE)
	@PostMapping( "/departure/remove")
	@ResponseBody
	public AjaxResult departureRemove(String ids) {		
		return toAjax(scanInfoService.deleteScanTempByIds(ids));
	}
	
	
	

	/**
	 * 跳转到件页面
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:arrival:view")
	@GetMapping("/arrival")
	public String arrival() {
	    return prefix + "/arrival/arrival";
	}
	
	
	/**
	 * 查询到件扫描列表
	 */
	@RequiresPermissions("ex:scanInfo:arrival:list")
	@PostMapping("/arrival/list")
	@ResponseBody
	public TableDataInfo arrivalList(ScanInfo scanInfo) {
		startPage();
		
		//获取当前登录信息
		SysUser user = ShiroUtils.getSysUser();
		
		scanInfo.setScanType(30);		//到件
		scanInfo.setScanUserId(user.getUserId());	//当前登录人
		
        List<ScanInfo> list = scanInfoService.selectScanTempList(scanInfo);
		return getDataTable(list);
	}
	
	
	
	/**
	 * 新增到件扫描页面
	 * @return
	 */
	@GetMapping("/arrival/add")
	public String arrivalAdd()
	{
	    return prefix + "/arrival/add";
	}
	
	
	
	
	/**
	 * 新增保存到件扫描
	 * @param scanInfo
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:arrival:add")
	@Log(title = "扫描", businessType = BusinessType.INSERT)
	@PostMapping("/arrival/add")
	@ResponseBody
	public AjaxResult arrivalAddSave(ScanInfo scanInfo) {
		
		//获取登录用户
		SysUser user = ShiroUtils.getSysUser();
		
		scanInfo.setScanType(30);			//到件扫描
		scanInfo.setScanTime(new Date());
		scanInfo.setScanUserId(user.getUserId()); //扫描员
		scanInfo.setScanDeptId(user.getDeptId()); //扫描网点
		
		return toAjax(scanInfoService.insertScanTemp(scanInfo));
	}
	
	
	
	
	/**
	 * 修改发件扫描页面
	 * @param scanId
	 * @param mmap
	 * @return
	 */
	@GetMapping("/arrival/edit/{scanId}")
	public String arrivalEdit(@PathVariable("scanId") Long scanId, ModelMap mmap)
	{
		ScanInfo scanInfo = scanInfoService.selectScanTempById(scanId);
		mmap.put("scanInfo", scanInfo);
	    return prefix + "/arrival/edit";
	}
	
	
	
	/**
	 * 修改保存到件扫描
	 * @param scanInfo
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:arrival:edit")
	@Log(title = "到件扫描", businessType = BusinessType.UPDATE)
	@PostMapping("/arrival/edit")
	@ResponseBody
	public AjaxResult arrivalEditSave(ScanInfo scanInfo) {
		
		scanInfo.setScanType(30);		//到件
		
		return toAjax(scanInfoService.updateScanTemp(scanInfo));
	}
	
	
	
	/**
	 * 删除到件扫描
	 */
	@RequiresPermissions("ex:scanInfo:arrival:remove")
	@Log(title = "派件扫描", businessType = BusinessType.DELETE)
	@PostMapping( "/arrival/remove")
	@ResponseBody
	public AjaxResult arrivalRemove(String ids) {	
		return toAjax(scanInfoService.deleteScanTempByIds(ids));
	}
	
	
	
	
	/**
	 * 跳转派件页面
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:delivery:view")
	@GetMapping("/delivery")
	public String delivery() {
	    return prefix + "/delivery/delivery";
	}
	
	
	/**
	 * 查询派件扫描列表
	 */
	@RequiresPermissions("ex:scanInfo:delivery:list")
	@PostMapping("/delivery/list")
	@ResponseBody
	public TableDataInfo deliveryList(ScanInfo scanInfo) {
		startPage();
		
		//获取当前登录信息
		SysUser user = ShiroUtils.getSysUser();
		
		scanInfo.setScanType(40);		//派件
		scanInfo.setScanUserId(user.getUserId());	//当前登录人
		
        List<ScanInfo> list = scanInfoService.selectScanTempList(scanInfo);
		return getDataTable(list);
	}
	
	
	
	/**
	 * 新增派件扫描页面
	 * @return
	 */
	@GetMapping("/delivery/add")
	public String deliveryAdd()
	{
	    return prefix + "/delivery/add";
	}
	
	
	
	
	/**
	 * 新增保存派件扫描
	 * @param scanInfo
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:delivery:add")
	@Log(title = "扫描", businessType = BusinessType.INSERT)
	@PostMapping("/delivery/add")
	@ResponseBody
	public AjaxResult deliveryAddSave(ScanInfo scanInfo) {
		
		//获取登录用户
		SysUser user = ShiroUtils.getSysUser();
				
		scanInfo.setScanType(40);			//派件扫描
		scanInfo.setScanTime(new Date());
		scanInfo.setScanUserId(user.getUserId()); //扫描员
		scanInfo.setScanDeptId(user.getDeptId()); //扫描网点
		
		return toAjax(scanInfoService.insertScanTemp(scanInfo));
	}
	
	
	
	
	/**
	 * 修改派件扫描页面
	 * @param scanId
	 * @param mmap
	 * @return
	 */
	@GetMapping("/delivery/edit/{scanId}")
	public String deliveryEdit(@PathVariable("scanId") Long scanId, ModelMap mmap)
	{
		ScanInfo scanInfo = scanInfoService.selectScanTempById(scanId);
		mmap.put("scanInfo", scanInfo);
	    return prefix + "/delivery/edit";
	}
	
	
	
	/**
	 * 修改保存派件扫描
	 * @param scanInfo
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:delivery:edit")
	@Log(title = "派件扫描", businessType = BusinessType.UPDATE)
	@PostMapping("/delivery/edit")
	@ResponseBody
	public AjaxResult deliveryEditSave(ScanInfo scanInfo) {
		
		scanInfo.setScanType(40);		//派件
		
		return toAjax(scanInfoService.updateScanTemp(scanInfo));
	}
	
	
	
	/**
	 * 删除派件扫描
	 */
	@RequiresPermissions("ex:scanInfo:delivery:remove")
	@Log(title = "派件扫描", businessType = BusinessType.DELETE)
	@PostMapping( "/delivery/remove")
	@ResponseBody
	public AjaxResult deliveryRemove(String ids) {		
		return toAjax(scanInfoService.deleteScanTempByIds(ids));
	}
	
	
	
	

	/**
	 * 跳转自提件页面
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:self:view")
	@GetMapping("/self")
	public String self() {
	    return prefix + "/self/self";
	}
	
	
	/**
	 * 查询自提件扫描列表
	 */
	@RequiresPermissions("ex:scanInfo:self:list")
	@PostMapping("/self/list")
	@ResponseBody
	public TableDataInfo selfList(ScanInfo scanInfo) {
		startPage();
		
		//获取当前登录信息
		SysUser user = ShiroUtils.getSysUser();
		
		scanInfo.setScanType(41);		//自提
		scanInfo.setScanUserId(user.getUserId());	//当前登录人
		
        List<ScanInfo> list = scanInfoService.selectScanTempList(scanInfo);
		return getDataTable(list);
	}
	
	
	
	/**
	 * 新增自提件扫描页面
	 * @return
	 */
	@GetMapping("/self/add")
	public String selfAdd()
	{
	    return prefix + "/self/add";
	}
	
	
	
	
	/**
	 * 新增保存自提件扫描
	 * @param scanInfo
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:self:add")
	@Log(title = "自提件扫描", businessType = BusinessType.INSERT)
	@PostMapping("/self/add")
	@ResponseBody
	public AjaxResult selfAddSave(ScanInfo scanInfo) {
		
		//获取登录用户
		SysUser user = ShiroUtils.getSysUser();
				
		scanInfo.setScanType(41);			//自提件扫描
		scanInfo.setScanTime(new Date());
		scanInfo.setScanUserId(user.getUserId()); //扫描员
		scanInfo.setScanDeptId(user.getDeptId()); //扫描网点
		
		return toAjax(scanInfoService.insertScanTemp(scanInfo));
	}
	
	
	
	
	/**
	 * 修改自提件扫描页面
	 * @param scanId
	 * @param mmap
	 * @return
	 */
	@GetMapping("/self/edit/{scanId}")
	public String selfEdit(@PathVariable("scanId") Long scanId, ModelMap mmap)
	{
		ScanInfo scanInfo = scanInfoService.selectScanTempById(scanId);
		mmap.put("scanInfo", scanInfo);
	    return prefix + "/self/edit";
	}
	
	
	
	/**
	 * 修改保存自提件扫描
	 * @param scanInfo
	 * @return
	 */
	@RequiresPermissions("ex:scanInfo:self:edit")
	@Log(title = "自提件扫描", businessType = BusinessType.UPDATE)
	@PostMapping("/self/edit")
	@ResponseBody
	public AjaxResult selfEditSave(ScanInfo scanInfo) {
		
		scanInfo.setScanType(41);		//自提件
		
		return toAjax(scanInfoService.updateScanTemp(scanInfo));
	}
	
	
	
	/**
	 * 删除自提件扫描
	 */
	@RequiresPermissions("ex:scanInfo:self:remove")
	@Log(title = "自提件扫描", businessType = BusinessType.DELETE)
	@PostMapping( "/self/remove")
	@ResponseBody
	public AjaxResult selfRemove(String ids) {		
		return toAjax(scanInfoService.deleteScanTempByIds(ids));
	}
	
	
	
	
}

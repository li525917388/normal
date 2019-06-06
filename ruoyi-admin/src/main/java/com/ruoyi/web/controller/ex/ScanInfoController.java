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
	
	@RequiresPermissions("ex:scanInfo:departure:view")
	@GetMapping("/departure")
	public String departure()
	{
	    return prefix + "/departure/departure";
	}
	
	/**
	 * 查询扫描列表
	 */
	@RequiresPermissions("ex:scanInfo:departure:list")
	@PostMapping("/departure/list")
	@ResponseBody
	public TableDataInfo departureList(ScanInfo scanInfo) {
		startPage();
		
		//获取当前登录信息
		SysUser user = ShiroUtils.getSysUser();
		
		scanInfo.setScanType(20);		//发件
		scanInfo.setScanUserId(user.getUserId());	//当前登录人
		
        List<ScanInfo> list = scanInfoService.selectScanInfoList(scanInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出扫描列表
	 */
	@RequiresPermissions("ex:scanInfo:departure:export")
    @PostMapping("/departure/export")
    @ResponseBody
    public AjaxResult export(ScanInfo scanInfo)
    {
    	List<ScanInfo> list = scanInfoService.selectScanInfoList(scanInfo);
        ExcelUtil<ScanInfo> util = new ExcelUtil<ScanInfo>(ScanInfo.class);
        return util.exportExcel(list, "scanInfo");
    }
	
	/**
	 * 新增发件扫描页面
	 * @return
	 */
	@GetMapping("/departure/add")
	public String add()
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
	public AjaxResult addSave(ScanInfo scanInfo) {
		
		scanInfo.setScanType(20);			//发件扫描
		scanInfo.setScanTime(new Date());
		
		return toAjax(scanInfoService.insertScanInfo(scanInfo));
	}

	/**
	 * 修改发件扫描页面
	 * @param scanId
	 * @param mmap
	 * @return
	 */
	@GetMapping("/departure/edit/{scanId}")
	public String edit(@PathVariable("scanId") Long scanId, ModelMap mmap)
	{
		ScanInfo scanInfo = scanInfoService.selectScanInfoById(scanId);
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
	public AjaxResult editSave(ScanInfo scanInfo) {
		
		return toAjax(scanInfoService.updateScanInfo(scanInfo));
	}
	
	/**
	 * 删除扫描
	 */
	@RequiresPermissions("ex:scanInfo:departure:remove")
	@Log(title = "扫描", businessType = BusinessType.DELETE)
	@PostMapping( "/departure/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(scanInfoService.deleteScanInfoByIds(ids));
	}
	
	
	
	
	
	
}

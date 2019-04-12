package com.ruoyi.web.controller.req;

import java.util.Date;
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
import com.ruoyi.req.domain.Requisition;
import com.ruoyi.req.service.IRequisitionService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 申购 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-04-12
 */
@Controller
@RequestMapping("/req/requisition")
public class RequisitionController extends BaseController
{
    private String prefix = "req/requisition";
	
	@Autowired
	private IRequisitionService requisitionService;
	
	@RequiresPermissions("req:requisition:view")
	@GetMapping()
	public String requisition() {
	    return prefix + "/requisition";
	}
	
	/**
	 * 查询申购列表
	 * @param requisition
	 * @return
	 */
	@RequiresPermissions("req:requisition:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Requisition requisition) {
		startPage();
        List<Requisition> list = requisitionService.selectRequisitionList(requisition);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出申购列表
	 */
	@RequiresPermissions("req:requisition:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Requisition requisition) {
    	List<Requisition> list = requisitionService.selectRequisitionList(requisition);
        ExcelUtil<Requisition> util = new ExcelUtil<Requisition>(Requisition.class);
        return util.exportExcel(list, "requisition");
    }
	
	/**
	 * 新增申购
	 */
	@GetMapping("/add")
	public String add() {
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存申购
	 */
	@RequiresPermissions("req:requisition:add")
	@Log(title = "申购", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Requisition requisition) {
		//shiro
		Subject subject = SecurityUtils.getSubject();
		
		//获取登录用户信息
		SysUser user = (SysUser) subject.getPrincipal();
		
		requisition.setReqCode("SG-" + System.currentTimeMillis());
		requisition.setApplySite(user.getDeptId());				//申请网点
		requisition.setApplyEmp(user.getUserId()); 				//申请人
		requisition.setApplyDate(new Date());					//申请时间
		requisition.setStatus("SAVE");
		
		return toAjax(requisitionService.insertRequisition(requisition));
	}

	/**
	 * 修改申购
	 */
	@GetMapping("/edit/{reqCode}")
	public String edit(@PathVariable("reqCode") String reqCode, ModelMap mmap) {
		Requisition requisition = requisitionService.selectRequisitionById(reqCode);
		mmap.put("requisition", requisition);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存申购
	 */
	@RequiresPermissions("req:requisition:edit")
	@Log(title = "申购", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Requisition requisition) {		
		return toAjax(requisitionService.updateRequisition(requisition));
	}
	
	/**
	 * 删除申购
	 */
	@RequiresPermissions("req:requisition:remove")
	@Log(title = "申购", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {		
		return toAjax(requisitionService.deleteRequisitionByIds(ids));
	}
	
}

package com.ruoyi.web.controller.base;

import java.util.ArrayList;
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
import com.ruoyi.base.domain.EcCompany;
import com.ruoyi.base.service.IEcCompanyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Select2;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 电商-公司 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-09-04
 */
@Controller
@RequestMapping("/base/ecCompany")
public class EcCompanyController extends BaseController {
    private String prefix = "base/ecCompany";
	
	@Autowired
	private IEcCompanyService ecCompanyService;
	
	@RequiresPermissions("base:ecCompany:view")
	@GetMapping()
	public String ecCompany() {
	    return prefix + "/ecCompany";
	}
	
	/**
	 * 查询电商-公司列表
	 */
	@RequiresPermissions("base:ecCompany:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(EcCompany ecCompany) {
		startPage();
        List<EcCompany> list = ecCompanyService.selectEcCompanyList(ecCompany);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出电商-公司列表
	 */
	@RequiresPermissions("base:ecCompany:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(EcCompany ecCompany) {
		List<EcCompany> list = ecCompanyService.selectEcCompanyList(ecCompany);
		ExcelUtil<EcCompany> util = new ExcelUtil<EcCompany>(EcCompany.class);
		return util.exportExcel(list, "ecCompany");
	}
	
	/**
	 * 新增电商-公司
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}
	
	/**
	 * 新增保存电商-公司
	 */
	@RequiresPermissions("base:ecCompany:add")
	@Log(title = "电商-公司", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(EcCompany ecCompany) {		
		return toAjax(ecCompanyService.insertEcCompany(ecCompany));
	}

	/**
	 * 修改电商-公司
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
		EcCompany ecCompany = ecCompanyService.selectEcCompanyById(id);
		mmap.put("ecCompany", ecCompany);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存电商-公司
	 */
	@RequiresPermissions("base:ecCompany:edit")
	@Log(title = "电商-公司", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(EcCompany ecCompany) {		
		return toAjax(ecCompanyService.updateEcCompany(ecCompany));
	}
	
	/**
	 * 删除电商-公司
	 */
	@RequiresPermissions("base:ecCompany:remove")
	@Log(title = "电商-公司", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {		
		return toAjax(ecCompanyService.deleteEcCompanyByIds(ids));
	}
	
	
	
	/**
	 * select2
	 * @param keywords
	 * @return
	 */
	@RequestMapping("/select2")
	@ResponseBody
	public List<Select2> select2(String keywords){
		
		List<EcCompany> list = ecCompanyService.select2(keywords);
		
		List<Select2> res = new ArrayList<Select2>();
		
		for(EcCompany company : list){
			Select2 s = new Select2();
			s.setId(company.getEcCompanyId());
			s.setText(company.getEcCompanyName());
			res.add(s);
		}
		
		return res;
	}
}

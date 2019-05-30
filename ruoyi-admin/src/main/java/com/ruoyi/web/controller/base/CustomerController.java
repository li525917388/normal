package com.ruoyi.web.controller.base;

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
import com.ruoyi.base.domain.Customer;
import com.ruoyi.base.service.ICustomerService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 客户 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-05-28
 */
@Controller
@RequestMapping("/base/customer")
public class CustomerController extends BaseController
{
    private String prefix = "base/customer";
	
	@Autowired
	private ICustomerService customerService;
	
	@RequiresPermissions("base:customer:view")
	@GetMapping()
	public String customer()
	{
	    return prefix + "/customer";
	}
	
	/**
	 * 查询客户列表
	 */
	@RequiresPermissions("base:customer:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Customer customer)
	{
		startPage();
        List<Customer> list = customerService.selectCustomerList(customer);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出客户列表
	 */
	@RequiresPermissions("base:customer:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Customer customer)
    {
    	List<Customer> list = customerService.selectCustomerList(customer);
        ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
        return util.exportExcel(list, "customer");
    }
	
	/**
	 * 新增客户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存客户
	 */
	@RequiresPermissions("base:customer:add")
	@Log(title = "客户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Customer customer) {
		
		return toAjax(customerService.insertCustomer(customer));
	}

	/**
	 * 修改客户
	 */
	@GetMapping("/edit/{custId}")
	public String edit(@PathVariable("custId") Long custId, ModelMap mmap)
	{
		Customer customer = customerService.selectCustomerById(custId);
		mmap.put("customer", customer);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存客户
	 */
	@RequiresPermissions("base:customer:edit")
	@Log(title = "客户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Customer customer)
	{		
		return toAjax(customerService.updateCustomer(customer));
	}
	
	/**
	 * 删除客户
	 */
	@RequiresPermissions("base:customer:remove")
	@Log(title = "客户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(customerService.deleteCustomerByIds(ids));
	}
	
}

package com.ruoyi.web.controller.purchase;

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
import com.ruoyi.purchase.domain.PurchaseApply;
import com.ruoyi.purchase.service.IPurchaseApplyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 采购申请 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-03-22
 */
@Controller
@RequestMapping("/purchase/purchaseApply")
public class PurchaseApplyController extends BaseController
{
    private String prefix = "purchase/purchaseApply";
	
	@Autowired
	private IPurchaseApplyService purchaseApplyService;
	
	@RequiresPermissions("purchase:purchaseApply:view")
	@GetMapping()
	public String purchaseApply()
	{
	    return prefix + "/purchaseApply";
	}
	
	/**
	 * 查询采购申请列表
	 */
	@RequiresPermissions("purchase:purchaseApply:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PurchaseApply purchaseApply)
	{
		startPage();
        List<PurchaseApply> list = purchaseApplyService.selectPurchaseApplyList(purchaseApply);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出采购申请列表
	 */
	@RequiresPermissions("purchase:purchaseApply:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PurchaseApply purchaseApply)
    {
    	List<PurchaseApply> list = purchaseApplyService.selectPurchaseApplyList(purchaseApply);
        ExcelUtil<PurchaseApply> util = new ExcelUtil<PurchaseApply>(PurchaseApply.class);
        return util.exportExcel(list, "purchaseApply");
    }
	
	/**
	 * 新增采购申请
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存采购申请
	 */
	@RequiresPermissions("purchase:purchaseApply:add")
	@Log(title = "采购申请", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PurchaseApply purchaseApply)
	{		
		return toAjax(purchaseApplyService.insertPurchaseApply(purchaseApply));
	}

	/**
	 * 修改采购申请
	 */
	@GetMapping("/edit/{applyNo}")
	public String edit(@PathVariable("applyNo") String applyNo, ModelMap mmap)
	{
		PurchaseApply purchaseApply = purchaseApplyService.selectPurchaseApplyById(applyNo);
		mmap.put("purchaseApply", purchaseApply);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存采购申请
	 */
	@RequiresPermissions("purchase:purchaseApply:edit")
	@Log(title = "采购申请", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PurchaseApply purchaseApply)
	{		
		return toAjax(purchaseApplyService.updatePurchaseApply(purchaseApply));
	}
	
	/**
	 * 删除采购申请
	 */
	@RequiresPermissions("purchase:purchaseApply:remove")
	@Log(title = "采购申请", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(purchaseApplyService.deletePurchaseApplyByIds(ids));
	}
	
}

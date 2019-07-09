package com.ruoyi.web.controller.fin;

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
import com.ruoyi.fin.domain.PriceStandardDetail;
import com.ruoyi.fin.service.IPriceStandardDetailService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 标准报价明细 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-07-02
 */
@Controller
@RequestMapping("/fin/priceStandardDetail")
public class PriceStandardDetailController extends BaseController
{
    private String prefix = "fin/priceStandardDetail";
	
	@Autowired
	private IPriceStandardDetailService priceStandardDetailService;
	
	@RequiresPermissions("fin:priceStandard:view")
	@GetMapping()
	public String priceStandardDetail()
	{
	    return prefix + "/priceStandardDetail";
	}
	
	/**
	 * 查询标准报价明细列表
	 */
	@RequiresPermissions("fin:priceStandard:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PriceStandardDetail priceStandardDetail)
	{
		startPage();
        List<PriceStandardDetail> list = priceStandardDetailService.selectPriceStandardDetailList(priceStandardDetail);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出标准报价明细列表
	 */
	@RequiresPermissions("fin:priceStandard:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PriceStandardDetail priceStandardDetail)
    {
    	List<PriceStandardDetail> list = priceStandardDetailService.selectPriceStandardDetailList(priceStandardDetail);
        ExcelUtil<PriceStandardDetail> util = new ExcelUtil<PriceStandardDetail>(PriceStandardDetail.class);
        return util.exportExcel(list, "priceStandardDetail");
    }
	
	/**
	 * 新增标准报价明细
	 */
	@GetMapping("/add/{priceId}")
	public String add(@PathVariable("priceId") Long priceId, ModelMap mmap) {
		
		mmap.put("priceId", priceId);
		
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存标准报价明细
	 */
	@RequiresPermissions("fin:priceStandard:add")
	@Log(title = "标准报价明细", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PriceStandardDetail priceStandardDetail) {

		return priceStandardDetailService.insertPriceStandardDetail(priceStandardDetail);
	}

	/**
	 * 修改标准报价明细
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		PriceStandardDetail priceStandardDetail = priceStandardDetailService.selectPriceStandardDetailById(id);
		mmap.put("priceStandardDetail", priceStandardDetail);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存标准报价明细
	 */
	@RequiresPermissions("fin:priceStandard:edit")
	@Log(title = "标准报价明细", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PriceStandardDetail priceStandardDetail) {	
		
		return priceStandardDetailService.updatePriceStandardDetail(priceStandardDetail);
	}
	
	/**
	 * 删除标准报价明细
	 */
	@RequiresPermissions("fin:priceStandard:remove")
	@Log(title = "标准报价明细", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(priceStandardDetailService.deletePriceStandardDetailByIds(ids));
	}
	
}

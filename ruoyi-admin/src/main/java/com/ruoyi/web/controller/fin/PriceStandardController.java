package com.ruoyi.web.controller.fin;

import java.math.BigDecimal;
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

import com.ruoyi.base.domain.Area;
import com.ruoyi.base.service.IAreaService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.fin.domain.PriceStandard;
import com.ruoyi.fin.service.IPriceStandardDetailService;
import com.ruoyi.fin.service.IPriceStandardService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 标准报价 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-06-20
 */
@Controller
@RequestMapping("/fin/priceStandard")
public class PriceStandardController extends BaseController
{
    private String prefix = "fin/priceStandard";
	
	@Autowired
	private IPriceStandardService priceStandardService;
	
	@Autowired
	private IPriceStandardDetailService priceStandardDetailService;
	
	@Autowired
	private IAreaService areaService;
	
	@RequiresPermissions("fin:priceStandard:view")
	@GetMapping()
	public String priceStandard()
	{
	    return prefix + "/priceStandard";
	}
	
	/**
	 * 查询标准报价列表
	 */
	@RequiresPermissions("fin:priceStandard:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PriceStandard priceStandard)
	{
		startPage();
        List<PriceStandard> list = priceStandardService.selectPriceStandardList(priceStandard);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出标准报价列表
	 */
	@RequiresPermissions("fin:priceStandard:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PriceStandard priceStandard)
    {
    	List<PriceStandard> list = priceStandardService.selectPriceStandardList(priceStandard);
        ExcelUtil<PriceStandard> util = new ExcelUtil<PriceStandard>(PriceStandard.class);
        return util.exportExcel(list, "priceStandard");
    }
	
	/**
	 * 新增标准报价
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存标准报价
	 */
	@RequiresPermissions("fin:priceStandard:add")
	@Log(title = "标准报价", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PriceStandard priceStandard) {
		
		//发件地格式
		priceStandard.setSendArea("," + priceStandard.getSendArea() + ",");
		priceStandard.setSendAreaName("," + priceStandard.getSendAreaName() + ",");
		
		//收件地格式
		priceStandard.setReceiveArea("," + priceStandard.getReceiveArea() + ",");
		priceStandard.setReceiveAreaName("," + priceStandard.getReceiveAreaName() + ",");
		
		return toAjax(priceStandardService.insertPriceStandard(priceStandard));
	}

	/**
	 * 修改标准报价
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		PriceStandard priceStandard = priceStandardService.selectPriceStandardById(id);
		mmap.put("priceStandard", priceStandard);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存标准报价
	 */
	@RequiresPermissions("fin:priceStandard:edit")
	@Log(title = "标准报价", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PriceStandard priceStandard) {
		
		//发件地址格式化
		if(!StringUtils.isEmpty(priceStandard.getSendArea()) && ',' != priceStandard.getSendArea().charAt(0)) {
			priceStandard.setSendArea("," + priceStandard.getSendArea() + ",");
			priceStandard.setSendAreaName("," + priceStandard.getSendAreaName() + ",");
		}
		
		//收件地址格式化
		if(!StringUtils.isEmpty(priceStandard.getReceiveArea()) && ',' != priceStandard.getReceiveArea().charAt(0)) {
			priceStandard.setReceiveArea("," + priceStandard.getReceiveArea() + ",");
			priceStandard.setReceiveAreaName("," + priceStandard.getReceiveAreaName() + ",");
		}

		return toAjax(priceStandardService.updatePriceStandard(priceStandard));
	}
	
	
 
    
    /**
     * 报价有效值修改
     */
    @Log(title = "标准报价", businessType = BusinessType.UPDATE)
    @RequiresPermissions("fin:priceStandard:edit")
    @PostMapping("/changeValid")
    @ResponseBody
    public AjaxResult changeValid(PriceStandard priceStandard)
    {
        return toAjax(priceStandardService.updatePriceStandard(priceStandard));
    }
    
	
	/**
	 * 删除标准报价
	 */
	@RequiresPermissions("fin:priceStandard:remove")
	@Log(title = "标准报价", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(priceStandardService.deletePriceStandardByIds(ids));
	}
	
	
	
	
	/**
	 * 选择区域树
	 * @param areaId
	 * @param mmap
	 * @return
	 */
	@GetMapping("/selectAreaTree/{areaId}")
	public String selectAreaTree(@PathVariable("areaId") Long priceId, ModelMap mmap) {
		
		mmap.put("priceId", priceId + "");
		mmap.put("level", getRequest().getParameter("level"));
		mmap.put("type", getRequest().getParameter("type"));
		mmap.put("column", getRequest().getParameter("column"));
		
		return prefix + "/tree";
	}
	
	
	
	/**
     * 加载地区列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData(Area area) {
    	
    	String priceId = getRequest().getParameter("priceId");
    	String type = getRequest().getParameter("type");
    	String column = getRequest().getParameter("column");
    	
		List<Ztree> list = areaService.selectAreaTree(area);
		
		PriceStandard priceStandard = priceStandardService.selectPriceStandardById(Convert.toLong(priceId));
		
		//判断是否多选
		if(priceStandard != null && "checkbox".equals(type)){
			//遍历  判断是否选中
			for(Ztree ztree : list){
				String str = "receive".equals(column) ? priceStandard.getReceiveArea() : priceStandard.getSendArea();
				
				if(str != null && str.contains("," + ztree.getId() + ",")){
					ztree.setChecked(true);
				}
				
			}
		}
		
		
        return list;
    }

    
    
    /**
	 * 标准报价详情列表
	 */
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long id, ModelMap mmap) {
		
		mmap.put("priceId", id);
		
	    return prefix + "Detail/priceStandardDetail";
	}
	
	
	
	/**
	 * 试算页面跳转
	 * @param mmap
	 * @return
	 */
	@GetMapping("/calculate")
	public String calculate(ModelMap mmap) {
		
	    return prefix + "/calculate";
	}
	
    
	
	/**
	 * 试算查询
	 * @param priceStandard
	 * @return
	 */
	@RequiresPermissions("fin:priceStandard:calculate")
	@PostMapping("/calculate")
	@ResponseBody
	public AjaxResult calculateQuery(PriceStandard priceStandard, String weight) {
		
		//发件地格式
		priceStandard.setSendArea("," + priceStandard.getSendArea() + ",");
		priceStandard.setSendAreaName("," + priceStandard.getSendAreaName() + ",");
		
		//收件地格式
		priceStandard.setReceiveArea("," + priceStandard.getReceiveArea() + ",");
		priceStandard.setReceiveAreaName("," + priceStandard.getReceiveAreaName() + ",");
		
		return priceStandardService.calculateQuery(priceStandard, new BigDecimal(weight));
	}
}

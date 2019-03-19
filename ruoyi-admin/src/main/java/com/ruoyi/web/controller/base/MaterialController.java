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
import com.ruoyi.base.domain.Material;
import com.ruoyi.base.service.IMaterialService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 物资 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-03-19
 */
@Controller
@RequestMapping("/base/material")
public class MaterialController extends BaseController
{
    private String prefix = "base/material";
	
	@Autowired
	private IMaterialService materialService;
	
	@RequiresPermissions("base:material:view")
	@GetMapping()
	public String material()
	{
	    return prefix + "/material";
	}
	
	/**
	 * 查询物资列表
	 */
	@RequiresPermissions("base:material:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Material material)
	{
		startPage();
        List<Material> list = materialService.selectMaterialList(material);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出物资列表
	 */
	@RequiresPermissions("base:material:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Material material)
    {
    	List<Material> list = materialService.selectMaterialList(material);
        ExcelUtil<Material> util = new ExcelUtil<Material>(Material.class);
        return util.exportExcel(list, "material");
    }
	
	/**
	 * 新增物资
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存物资
	 */
	@RequiresPermissions("base:material:add")
	@Log(title = "物资", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Material material)
	{		
		return toAjax(materialService.insertMaterial(material));
	}

	/**
	 * 修改物资
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Material material = materialService.selectMaterialById(id);
		mmap.put("material", material);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存物资
	 */
	@RequiresPermissions("base:material:edit")
	@Log(title = "物资", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Material material)
	{		
		return toAjax(materialService.updateMaterial(material));
	}
	
	/**
	 * 删除物资
	 */
	@RequiresPermissions("base:material:remove")
	@Log(title = "物资", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(materialService.deleteMaterialByIds(ids));
	}
	
}

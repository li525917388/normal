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
import com.ruoyi.base.domain.Area;
import com.ruoyi.base.service.IAreaService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 地区码 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-06-11
 */
@Controller
@RequestMapping("/base/area")
public class AreaController extends BaseController
{
    private String prefix = "base/area";
	
	@Autowired
	private IAreaService areaService;
	
	@RequiresPermissions("base:area:view")
	@GetMapping()
	public String area()
	{
	    return prefix + "/area";
	}
	
	/**
	 * 查询地区码列表
	 */
	@RequiresPermissions("base:area:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Area area) {
		startPage();
        List<Area> list = areaService.selectAreaList(area);
		return getDataTable(list);
	}
	
	@PostMapping("/queryList")
	@ResponseBody
	public List<Area> queryList(Area area) {
        List<Area> list = areaService.selectAreaList(area);
		return list;
	}
	
	
	/**
	 * 导出地区码列表
	 */
	@RequiresPermissions("base:area:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Area area)
    {
    	List<Area> list = areaService.selectAreaList(area);
        ExcelUtil<Area> util = new ExcelUtil<Area>(Area.class);
        return util.exportExcel(list, "area");
    }
	
	/**
	 * 新增地区码
	 */
	@GetMapping("/add")
	public String add() {
		
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存地区码
	 */
	@RequiresPermissions("base:area:add")
	@Log(title = "地区码", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Area area)
	{		
		return toAjax(areaService.insertArea(area));
	}

	/**
	 * 修改地区码
	 */
	@GetMapping("/edit/{areaId}")
	public String edit(@PathVariable("areaId") Integer areaId, ModelMap mmap)
	{
		Area area = areaService.selectAreaById(areaId);
		mmap.put("area", area);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存地区码
	 */
	@RequiresPermissions("base:area:edit")
	@Log(title = "地区码", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Area area)
	{		
		return toAjax(areaService.updateArea(area));
	}
	
	/**
	 * 删除地区码
	 */
	@RequiresPermissions("base:area:remove")
	@Log(title = "地区码", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {		
		return toAjax(areaService.deleteAreaByIds(ids));
	}
	
	
	
	/**
     * 选择区域树
     */
	@GetMapping("/selectAreaTree/{areaId}")
	public String selectAreaTree(@PathVariable("areaId") Integer areaId, ModelMap mmap) {
		
		mmap.put("area", areaService.selectAreaById(areaId));
		mmap.put("areaLevel", getRequest().getParameter("level"));
		mmap.put("type", getRequest().getParameter("type"));
		
		return prefix + "/tree";
	}
    
	
	
	/**
     * 加载地区列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData(Area area) {
    	
    	//执行：查询
        List<Ztree> ztrees = areaService.selectAreaTree(area);
        
        return ztrees;
    }
	
}

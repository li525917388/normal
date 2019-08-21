package com.ruoyi.web.controller.bk;

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
import com.ruoyi.bk.domain.BkAlbum;
import com.ruoyi.bk.service.IBkAlbumService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;

/**
 * 影集 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-07-25
 */
@Controller
@RequestMapping("/bk/bkAlbum")
public class BkAlbumController extends BaseController {
    private String prefix = "bk/bkAlbum";
	
	@Autowired
	private IBkAlbumService bkAlbumService;
	
	@RequiresPermissions("bk:bkAlbum:view")
	@GetMapping()
	public String bkAlbum() {
	    return prefix + "/bkAlbum";
	}
	
	/**
	 * 查询影集列表
	 */
	@RequiresPermissions("bk:bkAlbum:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BkAlbum bkAlbum) {
		startPage();
        List<BkAlbum> list = bkAlbumService.selectBkAlbumList(bkAlbum);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出影集列表
	 */
	@RequiresPermissions("bk:bkAlbum:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(BkAlbum bkAlbum) {
		List<BkAlbum> list = bkAlbumService.selectBkAlbumList(bkAlbum);
		ExcelUtil<BkAlbum> util = new ExcelUtil<BkAlbum>(BkAlbum.class);
		return util.exportExcel(list, "bkAlbum");
	}
	
	/**
	 * 新增影集
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}
	
	/**
	 * 新增保存影集
	 */
	@RequiresPermissions("bk:bkAlbum:add")
	@Log(title = "影集", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BkAlbum bkAlbum) {	

		//获取登录用户
		SysUser user = ShiroUtils.getSysUser();
		bkAlbum.setCreateDate(new Date());
		bkAlbum.setCreateBy(user.getLoginName());
		
		return toAjax(bkAlbumService.insertBkAlbum(bkAlbum));
	}

	/**
	 * 修改影集
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		BkAlbum bkAlbum = bkAlbumService.selectBkAlbumById(id);
		mmap.put("bkAlbum", bkAlbum);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存影集
	 */
	@RequiresPermissions("bk:bkAlbum:edit")
	@Log(title = "影集", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BkAlbum bkAlbum) {		
		return toAjax(bkAlbumService.updateBkAlbum(bkAlbum));
	}
	
	/**
	 * 删除影集
	 */
	@RequiresPermissions("bk:bkAlbum:remove")
	@Log(title = "影集", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {		
		return toAjax(bkAlbumService.deleteBkAlbumByIds(ids));
	}
	
}

package com.ruoyi.web.controller.other;

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
import com.ruoyi.other.domain.FriendLink;
import com.ruoyi.other.service.IFriendLinkService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;

/**
 * 友情链接 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-07-26
 */
@Controller
@RequestMapping("/other/friendLink")
public class FriendLinkController extends BaseController {
    private String prefix = "other/friendLink";
	
	@Autowired
	private IFriendLinkService friendLinkService;
	
	@RequiresPermissions("other:friendLink:view")
	@GetMapping()
	public String friendLink() {
	    return prefix + "/friendLink";
	}
	
	/**
	 * 查询友情链接列表
	 */
	@RequiresPermissions("other:friendLink:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FriendLink friendLink) {
		startPage();
        List<FriendLink> list = friendLinkService.selectFriendLinkList(friendLink);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出友情链接列表
	 */
	@RequiresPermissions("other:friendLink:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(FriendLink friendLink) {
		List<FriendLink> list = friendLinkService.selectFriendLinkList(friendLink);
		ExcelUtil<FriendLink> util = new ExcelUtil<FriendLink>(FriendLink.class);
		return util.exportExcel(list, "friendLink");
	}
	
	/**
	 * 新增友情链接
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}
	
	/**
	 * 新增保存友情链接
	 */
	@RequiresPermissions("other:friendLink:add")
	@Log(title = "友情链接", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FriendLink friendLink) {		
		
		SysUser user = ShiroUtils.getSysUser();
		friendLink.setCreateTime(new Date());
		friendLink.setCreateBy(user.getLoginName());
		return toAjax(friendLinkService.insertFriendLink(friendLink));
	}

	/**
	 * 修改友情链接
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		FriendLink friendLink = friendLinkService.selectFriendLinkById(id);
		mmap.put("friendLink", friendLink);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存友情链接
	 */
	@RequiresPermissions("other:friendLink:edit")
	@Log(title = "友情链接", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FriendLink friendLink) {		
		return toAjax(friendLinkService.updateFriendLink(friendLink));
	}
	
	/**
	 * 删除友情链接
	 */
	@RequiresPermissions("other:friendLink:remove")
	@Log(title = "友情链接", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {		
		return toAjax(friendLinkService.deleteFriendLinkByIds(ids));
	}
	
}

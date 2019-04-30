package com.ruoyi.web.controller.my;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.my.domain.MyTask;
import com.ruoyi.my.service.MyTaskService;
import com.ruoyi.req.domain.Requisition;
import com.ruoyi.req.service.IRequisitionService;
import com.ruoyi.system.domain.SysUser;

/**
 * 我的待办任务 controller
 * @author Li Dehuan
 * @date 2019年4月28日
 *
 */
@Controller
@RequestMapping("/my/task")
public class MyTaskController extends BaseController {

	private String prefix = "my/task";
	
	@Autowired
	MyTaskService myTaskService;
	
	@Autowired
	private IRequisitionService requisitionService;
	
	/**
	 * 页面跳转
	 * @return
	 */
	@RequiresPermissions("my:task:view")
	@GetMapping()
	public String task() {
	    return prefix + "/task";
	}
	
	
	@RequiresPermissions("my:task:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MyTask myTask) {
		startPage();
		SysUser user = ShiroUtils.getSysUser();
        List<MyTask> list = myTaskService.selectMyTaskList(myTask, user);
		return getDataTable(list);
	}
	
	
	/**
	 * 查看详情
	 */
	@GetMapping("/detail")
	public String detail(String formKey, String businessId, ModelMap mmap) {
		
		if(StringUtils.isEmpty(businessId)){
			
			return "";
		}
		
		String[] bidArr = businessId.split("::");
		
		String business = bidArr[0];
		String id = bidArr[1];
		
		if("flow1".equals(business)){
			Requisition requisition = requisitionService.selectRequisitionById(id);
			mmap.put("requisition", requisition);
			return "req/requisitionApprov/edit";
		}
		
	    return prefix + "/add";
	}
	
	
	/**
	 * 修改申购
	 */
	@GetMapping("/edit/{taskId}")
	public String edit(@PathVariable("taskId") String taskId, ModelMap mmap) {
		System.out.println(taskId);
		
		MyTask task = myTaskService.getTaskInfo(taskId);
		
		if(StringUtils.isEmpty(task.getBusinessId())){
			
			return "";
		}
		
		String[] bidArr = task.getBusinessId().split("::");
		
		String business = bidArr[0];
		String id = bidArr[1];
		
		if("requisition".equals(business)){
			Requisition requisition = requisitionService.selectRequisitionById(id);
			mmap.put("requisition", requisition);
			return "req/requisitionApprov/edit";
		}
		
	    return prefix + "/edit";
	}
	
	
	@RequiresPermissions("my:task:doTask")
	@Log(title = "任务", businessType = BusinessType.UPDATE)
	@PostMapping("/doTask")
	@ResponseBody
	public int doTask(String taskId, int op, String remark) {
		
		SysUser user = ShiroUtils.getSysUser();
		
		int res = myTaskService.doRask(taskId, op, remark, user.getUserId().toString());
		
		return res;
	}
}

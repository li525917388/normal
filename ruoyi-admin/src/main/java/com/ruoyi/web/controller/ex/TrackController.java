package com.ruoyi.web.controller.ex;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.ex.domain.Track;
import com.ruoyi.ex.service.ITrackService;


/**
 * 快件跟踪controller
 * @author Li Dehuan
 * @date 2019年6月5日
 *
 */
@Controller
@RequestMapping("/ex/track")
public class TrackController extends BaseController {
	
	private String prefix = "ex/track";
	
	@Autowired
	private ITrackService trackService;
	
	/**
	 * 快件跟踪页面
	 * @return
	 */
	@RequiresPermissions("ex:track:view")
	@GetMapping()
	public String waybill() {
		
	    return prefix + "/track";
	}
	
	
	
	/**
	 * 查询运单列表
	 */
	@RequiresPermissions("ex:waybill:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(String no, String noType) {
		startPage();
        List<Track> list = trackService.selectTrackList(no, noType);
		return getDataTable(list);
	}
	
}

package com.ruoyi.web.controller.ex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ruoyi.base.service.IEcCompanyService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.ex.domain.Order;
import com.ruoyi.ex.service.IOrderService;
import com.ruoyi.report.domain.MapReport;
import com.ruoyi.report.domain.ReportData;
import com.ruoyi.system.service.ISysConfigService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 订单 信息操作处理
 * 
 * @author Li Dehuan
 * @date 2019-05-28
 */
@Controller
@RequestMapping("/ex/order")
public class OrderController extends BaseController
{
    private String prefix = "ex/order";
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IAreaService areaService;
	
	@Autowired
	private IEcCompanyService ecCompanyService;
	
	@Autowired
	private ISysConfigService sysConfigService;
	
	@RequiresPermissions("ex:order:view")
	@GetMapping()
	public String order() {
	    return prefix + "/order";
	}
	
	/**
	 * 查询订单列表
	 */
	@RequiresPermissions("ex:order:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Order order)
	{
		startPage();
        List<Order> list = orderService.selectOrderList(order);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出订单列表
	 */
	@RequiresPermissions("ex:order:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Order order)
    {
    	List<Order> list = orderService.selectOrderList(order);
        ExcelUtil<Order> util = new ExcelUtil<Order>(Order.class);
        return util.exportExcel(list, "order");
    }
	
	/**
	 * 新增订单
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap) {
		
		Area area = new Area();
		area.setLevel(1);
		mmap.addAttribute("pnovince", areaService.selectAreaList(area));
		
		// 电商列表
		mmap.addAttribute("ecCompanyList", ecCompanyService.select2(""));
		
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单
	 */
	@RequiresPermissions("ex:order:add")
	@Log(title = "订单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Order order) {	
		
		return toAjax(orderService.insertOrder(order));
	}

	/**
	 * 修改订单
	 */
	@GetMapping("/edit/{orderid}")
	public String edit(@PathVariable("orderid") Long orderid, ModelMap mmap)
	{
		Order order = orderService.selectOrderById(orderid);
		mmap.put("order", order);
		
		// 电商列表
		mmap.addAttribute("ecCompanyList", ecCompanyService.select2(""));
		
		//省
		Area area = new Area();
		area.setLevel(1);
		mmap.addAttribute("pnovince", areaService.selectAreaList(area));
		
		//寄件市
		area.setLevel(2);
		area.setParentId(Convert.toInt(order.getSenderProv()));
		mmap.addAttribute("senderCity", areaService.selectAreaList(area));
		
		//寄件区
		area.setLevel(3);
		area.setParentId(Convert.toInt(order.getSenderCity()));
		mmap.addAttribute("senderArea", areaService.selectAreaList(area));
		
		//收件市
		area.setLevel(2);
		area.setParentId(Convert.toInt(order.getReceiverProv()));
		mmap.addAttribute("receiverCity", areaService.selectAreaList(area));
		
		//收件区
		area.setLevel(3);
		area.setParentId(Convert.toInt(order.getReceiverCity()));
		mmap.addAttribute("receiverArea", areaService.selectAreaList(area));
		
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单
	 */
	@RequiresPermissions("ex:order:edit")
	@Log(title = "订单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Order order)
	{		
		return toAjax(orderService.updateOrder(order));
	}
	
	/**
	 * 删除订单
	 */
	@RequiresPermissions("ex:order:remove")
	@Log(title = "订单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(orderService.deleteOrderByIds(ids));
	}
	
	
	
	/**
	 * 调度网点
	 * @param order
	 * @return
	 */
	@RequiresPermissions("ex:order:dispSite")
	@Log(title = "调度网点", businessType = BusinessType.OTHER)
	@PostMapping("/dispSite")
	@ResponseBody
	public AjaxResult dispSite(String orderids, long deptid) {
		
		Long[] orderid = Convert.toLongArray(orderids);
		
		return toAjax(orderService.dispSiet(orderid, deptid));
	}
	
	
	
	
	/**
	 * 调度业务员
	 * @param orderids
	 * @param userid
	 * @return
	 */
	@RequiresPermissions("ex:order:dispSalesman")
	@Log(title = "调度业务员", businessType = BusinessType.OTHER)
	@PostMapping("/dispSalesman")
	@ResponseBody
	public AjaxResult dispSalesman(String orderids, long userid) {
		
		Long[] orderid = Convert.toLongArray(orderids);
		
		return toAjax(orderService.dispSalesman(orderid, userid));
	}
	
	
	
	
	/**
	 * 根据运单号查询订单信息
	 * @param order
	 * @return
	 */
	@PostMapping("/selectOrderByWaybillNo")
	@ResponseBody
	public Order selectOrderByWaybillNo(String waybillNo) {

		Order order = orderService.selectOrderByWaybillNo(waybillNo);
		
		return order;
	}
	
	
	
	@RequiresPermissions("ex:order:quick")
	@PostMapping("/quickOrder")
	@ResponseBody
	public AjaxResult quickOrder(Long orderid){
		
		Order order = orderService.selectOrderById(orderid);
		
		if(StringUtils.isEmpty(order.getWaybillNo())){
			
			String url = sysConfigService.selectConfigByKey("ex_waybill_no_url");
			String params = sysConfigService.selectConfigByKey("ex_waybill_no_params");
			
			String ecCompanyId = order.getEcCompanyId();
			
			params += "&ecCompanyId=" + ecCompanyId;
			
			String waybillNo = HttpUtils.sendGet(url, params);
			order.setWaybillNo(waybillNo);
		}
		
		orderService.updateOrder(order);
		
		return AjaxResult.sucData(order);
	}
	
	
	@GetMapping("orderReport")
	public String orderReport() {
		
		System.out.println("订单报表");
		
		return "report/order/orderReport";
	}
	
	
	@PostMapping("getOrderMapReportData")
	@ResponseBody
	public MapReport<ReportData> getOrderMapReportData(){
		
		List<ReportData> list = orderService.getOrderMapReportData();
		
		Map<String, float[]> geoCoordMap = new HashMap<String, float[]>();
	
		for(ReportData map : list){
			
			String center = map.getCenter();
			
			if(center != null){
				String[] zb = center.split(",");
				
				float[] fzb = new float[2];
				
				if(zb.length > 1){
					fzb[0] = Float.parseFloat(zb[0]);
					fzb[1] = Float.parseFloat(zb[1]);
				}
				
				geoCoordMap.put(map.getName(), fzb);
			}
			
		}
		
		MapReport<ReportData> res = new MapReport<>();
		
		res.setGeoCoordMap(geoCoordMap);
		
		res.setData(list);
		
		return res;
	}
	
}

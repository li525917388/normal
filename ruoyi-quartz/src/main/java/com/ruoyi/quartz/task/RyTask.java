package com.ruoyi.quartz.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruoyi.common.utils.EmailUtils;
import com.ruoyi.quartz.domain.EmailTask;
import com.ruoyi.quartz.service.ITaskService;

/**
 * 定时任务调度测试
 * 
 * @author ruoyi
 */
@Component("ryTask")
public class RyTask {
	
	private static final Log log = LogFactory.getLog(RyTask.class); 
	
	/**
	 * 邮件任务状态
	 */
	public static boolean emailFlag = false;
	
	@Autowired
	ITaskService taskService;
	
    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
    }
    
    
    /**
     * 邮件发送任务
     */
    public void emailTask(){

    	if(emailFlag) return;	//判断是否在执行中
    	emailFlag = true;		//设置为执行中
    	
    	log.info("开始发送邮件任务");
    	
    	try {
			//执行：查询
			List<EmailTask> list = taskService.queryEmailTask();
			log.info("邮件任务数：" + list.size());
			
			//遍历
			for(EmailTask task : list){
				
				//执行：发邮件
				String res = EmailUtils.sendEmail(task.getEmailUrl(), task.getTitle(), task.getContent());

				// 判断是否成功
				if("ok".equals(res)) {
					task.setStatus(1); 		//成功
					
				} else {
					task.setStatus(2);		//失败
					task.setFailureReason(res);
				}
				
				int updateRes = taskService.updateEmailTaskStatus(task);
				
				log.info(task.getId() + "=>邮件任务更新状态：" + updateRes);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.equals("发邮件任务异常：" + e.getMessage());
			
		}finally{
			emailFlag = false;		//释放任务
		}
    }
}

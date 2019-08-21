package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysEmailTask;

/**
 * 
 * @author Li Dehuan
 * @date 2019年7月18日
 *
 */
public interface AddTaskMapper {

	
	/**
	 * 新增邮发送任务
	 * @param emailTask
	 * @return
	 */
	int insertEmailTask(SysEmailTask emailTask);
}

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('博客项目参数', '3', '1', '/bk/bkConfig', 'C', '0', 'bk:bkConfig:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '博客项目参数菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('博客项目参数查询', @parentId, '1',  '#',  'F', '0', 'bk:bkConfig:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('博客项目参数新增', @parentId, '2',  '#',  'F', '0', 'bk:bkConfig:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('博客项目参数修改', @parentId, '3',  '#',  'F', '0', 'bk:bkConfig:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('博客项目参数删除', @parentId, '4',  '#',  'F', '0', 'bk:bkConfig:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

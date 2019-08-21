-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('我们的服务', '3', '1', '/bk/bkWeService', 'C', '0', 'bk:bkWeService:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '我们的服务菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('我们的服务查询', @parentId, '1',  '#',  'F', '0', 'bk:bkWeService:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('我们的服务新增', @parentId, '2',  '#',  'F', '0', 'bk:bkWeService:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('我们的服务修改', @parentId, '3',  '#',  'F', '0', 'bk:bkWeService:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('我们的服务删除', @parentId, '4',  '#',  'F', '0', 'bk:bkWeService:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户', '3', '1', '/base/customer', 'C', '0', 'base:customer:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '客户菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户查询', @parentId, '1',  '#',  'F', '0', 'base:customer:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户新增', @parentId, '2',  '#',  'F', '0', 'base:customer:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户修改', @parentId, '3',  '#',  'F', '0', 'base:customer:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户删除', @parentId, '4',  '#',  'F', '0', 'base:customer:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

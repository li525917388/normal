-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('申购', '3', '1', '/req/reqRequisition', 'C', '0', 'req:reqRequisition:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '申购菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('申购查询', @parentId, '1',  '#',  'F', '0', 'req:reqRequisition:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('申购新增', @parentId, '2',  '#',  'F', '0', 'req:reqRequisition:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('申购修改', @parentId, '3',  '#',  'F', '0', 'req:reqRequisition:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('申购删除', @parentId, '4',  '#',  'F', '0', 'req:reqRequisition:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单', '3', '1', '/ex/order', 'C', '0', 'ex:order:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '订单菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单查询', @parentId, '1',  '#',  'F', '0', 'ex:order:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单新增', @parentId, '2',  '#',  'F', '0', 'ex:order:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单修改', @parentId, '3',  '#',  'F', '0', 'ex:order:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单删除', @parentId, '4',  '#',  'F', '0', 'ex:order:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

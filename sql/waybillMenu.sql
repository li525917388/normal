-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运单', '3', '1', '/ex/waybill', 'C', '0', 'ex:waybill:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '运单菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运单查询', @parentId, '1',  '#',  'F', '0', 'ex:waybill:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运单新增', @parentId, '2',  '#',  'F', '0', 'ex:waybill:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运单修改', @parentId, '3',  '#',  'F', '0', 'ex:waybill:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运单删除', @parentId, '4',  '#',  'F', '0', 'ex:waybill:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

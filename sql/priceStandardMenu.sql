-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('标准报价', '3', '1', '/fin/priceStandard', 'C', '0', 'fin:priceStandard:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '标准报价菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('标准报价查询', @parentId, '1',  '#',  'F', '0', 'fin:priceStandard:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('标准报价新增', @parentId, '2',  '#',  'F', '0', 'fin:priceStandard:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('标准报价修改', @parentId, '3',  '#',  'F', '0', 'fin:priceStandard:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('标准报价删除', @parentId, '4',  '#',  'F', '0', 'fin:priceStandard:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

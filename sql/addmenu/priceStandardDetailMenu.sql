-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('标准报价明细', '3', '1', '/fin/priceStandardDetail', 'C', '0', 'fin:priceStandardDetail:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '标准报价明细菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('标准报价明细查询', @parentId, '1',  '#',  'F', '0', 'fin:priceStandardDetail:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('标准报价明细新增', @parentId, '2',  '#',  'F', '0', 'fin:priceStandardDetail:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('标准报价明细修改', @parentId, '3',  '#',  'F', '0', 'fin:priceStandardDetail:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('标准报价明细删除', @parentId, '4',  '#',  'F', '0', 'fin:priceStandardDetail:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

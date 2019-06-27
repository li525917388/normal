-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地区码', '3', '1', '/base/area', 'C', '0', 'base:area:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '地区码菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地区码查询', @parentId, '1',  '#',  'F', '0', 'base:area:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地区码新增', @parentId, '2',  '#',  'F', '0', 'base:area:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地区码修改', @parentId, '3',  '#',  'F', '0', 'base:area:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地区码删除', @parentId, '4',  '#',  'F', '0', 'base:area:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

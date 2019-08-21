-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('友情链接', '3', '1', '/other/friendLink', 'C', '0', 'other:friendLink:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '友情链接菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('友情链接查询', @parentId, '1',  '#',  'F', '0', 'other:friendLink:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('友情链接新增', @parentId, '2',  '#',  'F', '0', 'other:friendLink:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('友情链接修改', @parentId, '3',  '#',  'F', '0', 'other:friendLink:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('友情链接删除', @parentId, '4',  '#',  'F', '0', 'other:friendLink:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

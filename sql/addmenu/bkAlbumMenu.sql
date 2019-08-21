-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('影集', '3', '1', '/bk/bkAlbum', 'C', '0', 'bk:bkAlbum:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '影集菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('影集查询', @parentId, '1',  '#',  'F', '0', 'bk:bkAlbum:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('影集新增', @parentId, '2',  '#',  'F', '0', 'bk:bkAlbum:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('影集修改', @parentId, '3',  '#',  'F', '0', 'bk:bkAlbum:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('影集删除', @parentId, '4',  '#',  'F', '0', 'bk:bkAlbum:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

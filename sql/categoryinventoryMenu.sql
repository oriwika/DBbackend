-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('各类别图书库存详情', '2000', '1', 'categoryinventory', 'manage/categoryinventory/index', 1, 0, 'C', '0', '0', 'manage:categoryinventory:list', '#', 'admin', sysdate(), '', null, '各类别图书库存详情菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('各类别图书库存详情查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'manage:categoryinventory:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('各类别图书库存详情新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'manage:categoryinventory:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('各类别图书库存详情修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'manage:categoryinventory:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('各类别图书库存详情删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'manage:categoryinventory:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('各类别图书库存详情导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'manage:categoryinventory:export',       '#', 'admin', sysdate(), '', null, '');
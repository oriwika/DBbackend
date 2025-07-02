-- 菜单SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图书进销存统计', '2000', '2', 'bookstats', 'manage/bookstats/index', 1, 0, 'C', '0', '0', 'manage:bookstats:list', '#', 'admin', sysdate(), '', null, '图书进销存统计菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图书进销存统计查询', @parentId, '1', '#', '', 1, 0, 'F', '0', '0', 'manage:bookstats:list', '#', 'admin', sysdate(), '', null, '');
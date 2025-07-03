-- ----------------------------
-- OpenGauss兼容版本 - 进货订单管理菜单
-- ----------------------------

-- 插入进货订单管理主菜单
DO $$
DECLARE
    parentId bigint;
BEGIN
    -- 插入主菜单并获取ID
    INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
    VALUES('进货订单管理', '2031', '1', 'purchaseorder', 'manage/purchaseorder/index', 1, 0, 'C', '0', '0', 'manage:purchaseorder:list', '#', 'admin', now(), '', null, '进货订单管理菜单')
    RETURNING menu_id INTO parentId;

    -- 插入子菜单按钮
    INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
    VALUES('进货订单管理查询', parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'manage:purchaseorder:query',        '#', 'admin', now(), '', null, '');

    INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
    VALUES('进货订单管理新增', parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'manage:purchaseorder:add',          '#', 'admin', now(), '', null, '');

    INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
    VALUES('进货订单管理修改', parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'manage:purchaseorder:edit',         '#', 'admin', now(), '', null, '');

    INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
    VALUES('进货订单管理删除', parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'manage:purchaseorder:remove',       '#', 'admin', now(), '', null, '');

    INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
    VALUES('进货订单管理导出', parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'manage:purchaseorder:export',       '#', 'admin', now(), '', null, '');
END $$;

-- 主要修改内容：
-- 1. @parentId变量 -> DECLARE parentId bigint
-- 2. LAST_INSERT_ID() -> RETURNING menu_id INTO parentId
-- 3. sysdate() -> now()
-- 4. 使用DO $$...END $$;包装匿名代码块
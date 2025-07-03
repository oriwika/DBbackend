-- ----------------------------
-- OpenGauss兼容版本 - 图书进销存统计菜单
-- ----------------------------

-- 插入图书进销存统计主菜单
DO $$
DECLARE
    parentId bigint;
BEGIN
    -- 插入主菜单并获取ID
    INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
    VALUES('图书进销存统计', '2000', '2', 'bookstats', 'manage/bookstats/index', 1, 0, 'C', '0', '0', 'manage:bookstats:list', '#', 'admin', now(), '', null, '图书进销存统计菜单')
    RETURNING menu_id INTO parentId;

    -- 插入子菜单按钮
    INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
    VALUES('图书进销存统计查询', parentId, '1', '#', '', 1, 0, 'F', '0', '0', 'manage:bookstats:list', '#', 'admin', now(), '', null, '');
END $$;

-- 主要修改内容：
-- 1. @parentId变量 -> DECLARE parentId bigint
-- 2. LAST_INSERT_ID() -> RETURNING menu_id INTO parentId
-- 3. sysdate() -> now()
-- 4. 使用DO $$...END $$;包装匿名代码块
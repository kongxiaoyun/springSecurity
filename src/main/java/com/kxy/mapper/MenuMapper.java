package com.kxy.mapper;


import java.util.List;

import com.kxy.entity.Menu;

/**
 * Created by sang on 2017/12/28.
 */
public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByHrId(String hrId);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);
}

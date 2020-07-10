package com.kxy.service;

import com.kxy.entity.Menu;
import java.util.List;


public interface MenuService {

    public List<Menu> getAllMenu();

    public List<Menu> getMenusByHrId();

    public List<Menu> menuTree();

    public List<Long> getMenusByRid(Long rid);
}

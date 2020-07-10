package com.kxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kxy.entity.Menu;
import com.kxy.mapper.MenuMapper;
import com.kxy.service.MenuService;
import com.kxy.utils.HrUtils;


@Service
@Transactional
public class MenuServiceImpl implements MenuService{
	@Autowired
    MenuMapper menuMapper;
	
	public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
    }

    public List<Menu> menuTree() {
        return menuMapper.menuTree();
    }

    public List<Long> getMenusByRid(Long rid) {
        return menuMapper.getMenusByRid(rid);
    }
}

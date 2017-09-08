package com.citi.dde.achweb.service;

import java.util.List;

import com.citi.dde.achweb.model.MenuDO;

public interface MenuService {

	List<MenuDO> getMenuDetailsList(String userRole);
}

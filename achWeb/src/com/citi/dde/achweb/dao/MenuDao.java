package com.citi.dde.achweb.dao;

import java.util.List;

import com.citi.dde.achweb.model.MenuDO;

public interface MenuDao{

	List<MenuDO> getMenuDetailsList(String userRole);
}

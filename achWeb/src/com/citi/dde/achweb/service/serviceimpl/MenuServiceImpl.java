package com.citi.dde.achweb.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citi.dde.achweb.dao.MenuDao;
import com.citi.dde.achweb.model.MenuDO;
import com.citi.dde.achweb.service.MenuService;


@Service("menuService")
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public List<MenuDO> getMenuDetailsList(String userRole){
		List<MenuDO> menuDoList = menuDao.getMenuDetailsList(userRole);
		return menuDoList;
	}

}

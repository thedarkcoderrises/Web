package com.citi.dde.achweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citi.dde.achweb.model.MenuDO;
import com.citi.dde.achweb.pojo.LogInUserDetails;
import com.citi.dde.achweb.service.MenuService;
import com.citi.dde.common.exception.DFPDAOException;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;

	
	@RequestMapping(value = "/drawMenu", method = RequestMethod.GET,  produces = "application/json")
	@ResponseBody
	public List<MenuDO> getMenuDetails(HttpSession session, HttpServletRequest req) throws DFPDAOException{
		
		List<MenuDO> menuDoList;
		menuDoList = (List<MenuDO>)session.getAttribute("menuList");
		
		LogInUserDetails smUserDetails = (LogInUserDetails) session.getAttribute("userDetails");
		
		if(CollectionUtils.isEmpty(menuDoList)){
			if(smUserDetails!= null){ // to be removed
			menuDoList =menuService.getMenuDetailsList(smUserDetails.getUserRole()) ;
			}
			else{
			menuDoList = new ArrayList<MenuDO>();	
			}
			
			session.setAttribute("menuList", menuDoList);
		}
		return menuDoList; 
	}
}

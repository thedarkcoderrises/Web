package com.citi.dde.achweb.dao.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.citi.dde.achweb.dao.MenuDao;
import com.citi.dde.achweb.model.MenuDO;

@Repository("menuDao")
public class MenuDaoImpl extends GenericDaoImpl<MenuDO, Integer> implements MenuDao{
	/**
	 * Query for DFP_TM_MENU_DETAIL
	 */
//	String tabelName = "SELECT * FROM DFP_ACH_TM_MENU_DETAIL WHERE ROLE like  ";
	
	/**
	 * Appender - order by MENU_ID
	 */
	String orderBy = " order by m.menuId ";

	
	/**
	 * Load the menu details based on condition
	 */
	@Override
	public List<MenuDO> getMenuDetailsList(String userRole){		
		List<MenuDO> finalMenuDOList = new ArrayList<MenuDO>();
     	List<MenuDO> menuDoList;
		
		Session s =getSessionFactory().getCurrentSession();
		Criteria cri =s.createCriteria(MenuDO.class);
		cri.add(Restrictions.like("role", "%"+userRole+"%"));
		cri.addOrder((Order.asc("menuId")));
		menuDoList = cri.list();

			for (MenuDO menu : menuDoList) {
				if (menu.getParentMenuId() == menu.getMenuId()) {
					menu.setSubMenu("/" + menu.getMenuId());
					finalMenuDOList.add(menu);
				} else {
					for (MenuDO parentManu : finalMenuDOList) {
						if (menu.getParentMenuId() == parentManu.getMenuId()) {
							menu.setSubMenu(parentManu.getSubMenu() + "/" + menu.getMenuId());
							break;
						}
					}
					finalMenuDOList.add(menu);
				}
			}
			return finalMenuDOList;
	}

}

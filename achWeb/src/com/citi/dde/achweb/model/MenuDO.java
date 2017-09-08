package com.citi.dde.achweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "DFP_ACH_TM_MENU_DETAIL")
public class MenuDO implements Serializable, Comparable<MenuDO> {

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = 1537695235657875468L;

	@Id
	@Column(name = "MENU_ID", unique = true, nullable = false)
	private Integer menuId;

	@Column(name = "PARENT_MENU_ID", nullable = false)
	private Integer parentMenuId;

	@Column(name = "PROFILE", nullable = false)
	private String profile;

	@Column(name = "COUNTRY_CODE", nullable = false)
	private String country;

	@Column(name = "MAIN_MENU")
	private String mainMenu;

	@Column(name = "SUB_MENU")
	private String subMenu;

	@Column(name = "MENU_URL")
	private String menuURL;

	@Column(name = "ADDL_FIELD01", nullable = true)
	private String additionalField01;

	@Column(name = "ADDL_FIELD02", nullable = true)
	private String additionalField02;

	@Column(name = "ADDL_FIELD03", nullable = true)
	private String additionalField03;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "DISPLAY_NAME")
	private String displayName;

	@Transient
	private String dfpUserDetails;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(int parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(String mainMenu) {
		this.mainMenu = mainMenu;
	}

	public String getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(String subMenu) {
		this.subMenu = subMenu;
	}

	public String getMenuURL() {
		return menuURL;
	}

	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}

	public String getAdditionalField01() {
		return additionalField01;
	}

	public void setAdditionalField01(String additionalField01) {
		this.additionalField01 = additionalField01;
	}

	public String getAdditionalField02() {
		return additionalField02;
	}

	public void setAdditionalField02(String additionalField02) {
		this.additionalField02 = additionalField02;
	}

	public String getAdditionalField03() {
		return additionalField03;
	}

	public void setAdditionalField03(String additionalField03) {
		this.additionalField03 = additionalField03;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int compareTo(MenuDO o) {
		if (o instanceof MenuDO)
			return -1;
		MenuDO t = (MenuDO) o;

		if (this == t) {
			return 0;
		}

		if (this.getMenuId() == t.getMenuId()) {
			return 0;
		} else {
			return -1;
		}

	}

	public String getDfpUserDetails() {
		return dfpUserDetails;
	}

	public void setDfpUserDetails(String dfpUserDetails) {
		this.dfpUserDetails = dfpUserDetails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuDo [menuId=");
		builder.append(menuId);
		builder.append(", parentMenuId=");
		builder.append(parentMenuId);
		builder.append(", profile=");
		builder.append(profile);
		builder.append(", country=");
		builder.append(country);
		builder.append(", mainMenu=");
		builder.append(mainMenu);
		builder.append(", subMenu=");
		builder.append(subMenu);
		builder.append(", menuURL=");
		builder.append(menuURL);
		builder.append(", additionalField01=");
		builder.append(additionalField01);
		builder.append(", additionalField02=");
		builder.append(additionalField02);
		builder.append(", additionalField03=");
		builder.append(additionalField03);
		builder.append(", role=");
		builder.append(role);
		builder.append(", displayName=");
		builder.append(displayName);
		builder.append(", dfpUserDetails=");
		builder.append(dfpUserDetails);
		builder.append("]");
		return builder.toString();
	}

}


/**
 *  WARN -  DO NOT MODIFY  - This file is generated by Witchcraftmda. Change AppRole.java instead
 *  Any changes will be overwritten by the next run of the code generator.
 */

package com.td.bbwp.users;

import javax.persistence.*;
import org.witchcraft.base.entity.FileAttachment;
import org.witchcraft.base.entity.BaseEntity;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.IndexColumn;

import javax.validation.constraints.*;

import java.math.BigDecimal;

import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.witchcraft.base.entity.BaseEntity;

@MappedSuperclass

//@Indexed
//@Analyzer(definition = "entityAnalyzer")

public abstract class AppRoleBase extends BaseEntity {

	//@Unique(entityName = "com.td.bbwp.users.AppRole", fieldName = "NAME")

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "NAME", unique = true)

	protected String name

	;

	@ManyToMany(mappedBy = "appRoles")

	protected List<AppUser> appUsers

			= new ArrayList<AppUser>()

	;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

	public List<AppUser> getAppUsers() {

		return appUsers;
	}

	public AppUser addAppUser(AppUser appUser) {

		if (this.appUsers == null) {
			this.appUsers = new ArrayList<com.td.bbwp.users.AppUser>();
		}

		this.appUsers.add(appUser);

		return appUser;
	}

	public void addAppUsers(List<AppUser> appUsersToAdd) {
		appUsersToAdd.forEach(record -> addAppUser(record));
	}

	@Transient
	public String createListAppUsersAsString() {
		return listAsString(appUsers);
	}

	@Transient
	//Display name
	public String getDisplayName() {
		try {
			return name;
		} catch (Exception e) {
			return "Exception - " + e.getMessage();
		}
	}

	/*
	public List<List<? extends BaseEntity>> getComposites(){
		List lst = new ArrayList();
		
		return lst;
	}
	*/

}

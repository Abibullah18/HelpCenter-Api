package com.Help.Center.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String roleName;
	@Column
	private String description;
	@Column
	private Boolean deleted;


	@Column
	private Boolean isActive;
	@Column
	private UUID uuid=UUID.randomUUID();
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Role_Scope")
	private Collection<Scope> scope=new ArrayList<>();
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Collection<Scope> getScope() {
		return scope;
	}
	public void setScope(Collection<Scope> scope) {
		this.scope = scope;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}




}

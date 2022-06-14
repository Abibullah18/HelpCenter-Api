package com.Help.Center.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Help.Center.Models.Roles;
import com.Help.Center.Models.Scope;
import com.Help.Center.Repository.RolesRepo;
import com.Help.Center.Repository.ScopeRepo;
@RestController
@CrossOrigin(origins = "*")
public class RoleController {
	@Autowired
	public RolesRepo rolesRepo;
	
	@Autowired
	private ScopeRepo scopeRepo;
	
	//ROLE TABLE CONTROLLER
		@PostMapping("/api/v1/roles/create")
		Roles createRoles(@RequestBody Roles roles) {
			return rolesRepo.save(roles);
		}
		@GetMapping("/api/v1/roles")
		List<Roles>getAllRoles(){
			return rolesRepo.findAll();
		}
		@GetMapping("/api/v1/roles/{id}")
		public ResponseEntity<Roles>GetRolesById(@PathVariable (value = "id") Integer rolesId){
			Roles roles=rolesRepo.findById(rolesId).orElseThrow(()->new RuntimeException("Id Does Not Match"));
			return ResponseEntity.ok().body(roles);
			
		}
		@PostMapping("/addScopeToRole")
		Roles addScopeToUSer(@RequestBody SampleRoleScope input) {
			String roleName=input.getRoleName();
			String scopeName=input.getScopeName();
			Roles roles=rolesRepo.findByRoleName(roleName);
			Scope scope=scopeRepo.findByScopeName(scopeName);
			roles.getScope().add(scope);
			return rolesRepo.save(roles);
			
		}

}

class SampleRoleScope{
	public String roleName;
	public String scopeName;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getScopeName() {
		return scopeName;
	}
	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}
	
}


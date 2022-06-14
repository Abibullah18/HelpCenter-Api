package com.Help.Center.Controller;


import java.io.IOException;
import java.util.List;

import com.Help.Center.Models.Company;
import com.Help.Center.Models.UserType;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import com.Help.Center.Models.Roles;
 
import com.Help.Center.Models.Users;
import com.Help.Center.Repository.CompanyRepo;
import com.Help.Center.Repository.RolesRepo;
import com.Help.Center.Repository.ScopeRepo;
import com.Help.Center.Repository.UsersRepo;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class MainController {
	@Autowired
	public UsersRepo usersRepo;
	@Autowired
	public CompanyRepo companyRepo;
	@Autowired
	public RolesRepo rolesRepo;
	@Autowired
	public ScopeRepo scopeRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("api/v1/users/create")
	ResponseEntity<Users> createUsers(@RequestBody Users users, Authentication authentication,@RequestParam String company,String role)  {
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		users.setDeleted(false);
		users.setAdmin(false);
		users.setActive(false);
		Integer roleId=Integer.parseInt(role);
		Roles roles=rolesRepo.findById(roleId).orElseThrow(()->new RuntimeException("id does not match"));
		users.setRoles(roles);
		Integer companyId=Integer.parseInt(company);
		Company companyName=companyRepo.findById(companyId).orElseThrow(()->new RuntimeException("id does not mach for this id"));
		users.setCompany(companyName);
		usersRepo.save(users);
		return ResponseEntity.ok().body(users);
	}
	@GetMapping("api/v1/users")
	 List<Users> getAllUsers(){
		List userData=usersRepo.findAllByDeleted(false);




//
//		UserData userData=new UserData();
		//Pageable pageable
//		Page<Users> usersPage= usersRepo.findAll(pageable);
//		List<Users>users=usersPage.getContent();
//		Pagination paginated=Pagination.createPagination(usersPage);
//		userData.setPagination(paginated);
//		userData.setUsers(users);
	   return userData;
	
	}
	@GetMapping("api/v1/users/{id}")
	public ResponseEntity<Users>getuser(@PathVariable (value = "id") Integer userId){
		Users users=usersRepo.findById(userId).orElseThrow(()->new RuntimeException("user does not match"));
		return ResponseEntity.ok().body(users);
	}
	@PutMapping("api/v1/users/{id}")
	public ResponseEntity<Users>updateUser(@PathVariable (value = "id") Integer userId ,@RequestBody Users userDetail){
		Users users=usersRepo.findById(userId).orElseThrow(()->new RuntimeException("userId does not match"));
		users.setAvatar(userDetail.getAvatar());
		users.setEmail(userDetail.getEmail());
		users.setFirstName(userDetail.getFirstName());
		users.setMiddleName(userDetail.getMiddleName());
		users.setLastName(userDetail.getLastName());
		users.setMobileNo(userDetail.getMobileNo());
		users.setAvatar(userDetail.getAvatar());
		users.setSuffix(userDetail.getSuffix());
		users.setUserType(userDetail.getUserType());
		users.setUserName(userDetail.getUserName());
		users.setPassword(userDetail.getPassword());
		usersRepo.save(users);
		return ResponseEntity.ok().body(users);
				
	}
	@DeleteMapping("api/v1/users/{id}")
	public ResponseEntity<Users>deleteUsers(@PathVariable (value = "id")Integer userId){
		
		Users users=usersRepo.findById(userId).orElseThrow(()->new RuntimeException("userId does not Match"));
		users.setDeleted(true);
		usersRepo.save(users);
		return ResponseEntity.ok().body(users);
	}
//	@PostMapping("/addRoleToUsers")
//	Users addRoleToUsers(@RequestBody sampleInput input) {
//		Users users=usersRepo.findById(input.getId1()).orElseThrow(()->new RuntimeException());
//		Roles roles=rolesRepo.findById(input.getId2()).orElseThrow(()->new RuntimeException());
//		users.setRoles(roles);
//		return usersRepo.save(users);
//
//	}

	@PostMapping("/signup")
	Users signup(@RequestBody Users users)
	{
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		users.setDeleted(false);
		Company company=new Company();
		company.setCompanyName(users.getCompany().getCompanyName());
		companyRepo.save(company);
		users.setCompany(company);
		users.setActive(false);
		users.setAdmin(false);
		users.setUserType(UserType.CUSTOMER);
		return 	usersRepo.save(users);
	}
	@PostMapping("/getUser")
	private ResponseEntity<Users> getUserById(@RequestHeader(name = "Authorization") String token){
		Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
		JWTVerifier verifier = JWT.require(algorithm).build();
		DecodedJWT decodedJWT = verifier.verify(token);
		String[] roles = decodedJWT.getClaim("Roles").asArray(String.class);
		int id = Integer.parseInt(roles[0]);
		Users user  = usersRepo.findById(id).orElseThrow(()-> new RuntimeException("User Not found for this is:"+id));
		return  ResponseEntity.ok().body(user);
	}


	
	
	
	
	
	

}
class sampleInput{
	public int id1;
	public int id2;
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}

}
class UserData{
	private List<Users> users;
//	private Pagination pagination;
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
//	public Pagination getPagination() {
//		return pagination;
//	}
//	public void setPagination(Pagination pagination) {
//		this.pagination = pagination;
//	}
	
}

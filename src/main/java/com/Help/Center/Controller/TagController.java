package com.Help.Center.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.Help.Center.Models.Company;
import com.Help.Center.Models.Tags;
import com.Help.Center.Models.Users;
import com.Help.Center.Repository.CompanyRepo;
import com.Help.Center.Repository.TagRepo;
import com.Help.Center.Repository.UsersRepo;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class TagController {
	
	@Autowired
	public TagRepo tagRepo;
	@Autowired
	public CompanyRepo companyRepo;
	@Autowired
	public UsersRepo usersRepo;
	
	@PostMapping("api/v1/tag/create")
	Tags createTags(@RequestBody Tags tags, Authentication authentication) {
		String users=authentication.getAuthorities().iterator().next().toString();
		Integer userId=Integer.parseInt(users);
		Users uid=usersRepo.findById(userId).orElseThrow(()->new RuntimeException("id does not match"));
		tags.setUsers(uid);
		tags.setCompany(uid.getCompany());
		return tagRepo.save(tags);
	}
	@GetMapping("api/v1/tag")
	List<Tags>getAlltags(){
		return tagRepo.findAll();
	}
	@PostMapping("/addCompanyToTags")
	Tags addCompanyToTags(@RequestBody sampleTag inpuTag) {
		String tagName=inpuTag.getTagName();
		String companyName=inpuTag.getCompanyName();
		Tags tags=tagRepo.findByTagName(tagName);
		Company company=companyRepo.findBycompanyName(companyName);
		tags.setCompany(company);
		return tagRepo.save(tags);
		
	}
	@PostMapping("/addUserToTags")
	Tags addUserToTags(@RequestBody sampleTag inpuTag) {
		String tagName=inpuTag.getTagName();
		String userName=inpuTag.getUserName();
		Tags tags=tagRepo.findByTagName(tagName);
		Users users=usersRepo.findByUserName(userName);
		tags.setUsers(users);
		return tagRepo.save(tags);
		
	}

	
}
class sampleTag{
	public String tagName;
	public String companyName;
	public String userName;
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}

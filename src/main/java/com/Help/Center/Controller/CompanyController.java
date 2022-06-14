package com.Help.Center.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.Help.Center.Models.Company;
import com.Help.Center.Models.Users;
import com.Help.Center.Repository.CompanyRepo;
import com.Help.Center.Repository.UsersRepo;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class CompanyController {
	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//COMPANY_TABLE_CONTROLLER
		@PostMapping("api/v1/company/create")
		Company  createCompany(@RequestBody Company company) {

			return companyRepo.save(company);
		}
		@PostMapping("/CompanyToUser")
		Company AddUsersToCompany(@RequestBody CompanyInput input ) {
			Integer id1=input.getId1();
			Integer id2=input.getId2();
			Company company= companyRepo.findById(id1).orElseThrow(()->new RuntimeException("Company not found for this Id"+id1));
			Users users= usersRepo.findById(id2).orElseThrow(()->new RuntimeException("User not Found for this Id"+id2));
			company.getUsers().add(users);
			return companyRepo.save(company);		
		}
		@GetMapping("api/v1/company")
		List<Company>GetAllCompany(){
			return companyRepo.findAll();
		}
		@GetMapping("api/v1/company/{id}")
		public ResponseEntity<Company>getCompanyById(@PathVariable (value = "id") Integer companyid){
			Company company=companyRepo.findById(companyid).orElseThrow(()->new RuntimeException("Company Does Not Match"));
			log.info("this is getCompanyById Route... ");
			return ResponseEntity.ok().body(company);
		}
		@DeleteMapping("api/v1/company/{id}")
		Company deleteCompany(@PathVariable (value = "id") Integer CompanyId ){
			Company company=companyRepo.findById(CompanyId).orElseThrow(()->new RuntimeException());
			companyRepo.delete(company);
			return company;
		}

		@PutMapping("api/v1/company")
	Company UpadateCompany(@PathVariable (value = "id") Integer CompanyId, @RequestBody Company companyDetails){
			Company company=companyRepo.findById(CompanyId).orElseThrow(()->new RuntimeException());
			company.setCompanyName(companyDetails.getCompanyName());
			company.setCompanyCode(companyDetails.getCompanyCode());
			company.setAddress(companyDetails.getAddress());
			company.setAvatar(companyDetails.getAvatar());
			company.setCity(companyDetails.getCity());
			company.setContactPersonName(companyDetails.getContactPersonName());
			company.setCountry(companyDetails.getCountry());
			company.setDescription(companyDetails.getDescription());
			company.setDomain(companyDetails.getDomain());
			company.setManagedBy(companyDetails.getManagedBy());
			company.setPhoneNo(companyDetails.getPhoneNo());
			company.setUniquId(companyDetails.getUniquId());
			company.setState(companyDetails.getState());
			return companyRepo.save(company);
		}
		

	}
	class CompanyInput{
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




package com.Help.Center.Models;





import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table
public class Articles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column
	private String title;


	@Column
	private String description;
	@Column
	private String keywords;
	@Column
	private Integer viwes=0;
	@Column
	private Integer likes=0;
	@Column
	private Integer dislike=0;
	@Column
	private boolean deleted;

	@Column
	private UUID uuid=UUID.randomUUID();
	
	@Enumerated(EnumType.STRING)
	 private Status status;
	
	
	 @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 @JoinColumn(name = "ar_tg")
	 private Tags tags;
	 
	 @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 @JoinColumn(name = "ar_co")
	 private Company company;
	 
	 @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 @JoinColumn(name = "ar_us")
	 private Users users;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public int getViwes() {
		return viwes;
	}

	public void setViwes(Integer viwes) {
		this.viwes = viwes;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(Integer dislike) {
		this.dislike = dislike;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Tags getTags() {
		return tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

}

//title
//description
//status (Private / Public / Draft)
//tags
//keywords
//views (Number)
//likes  (Number)
//dislikes (Number)
//company
//user
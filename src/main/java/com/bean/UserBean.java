package com.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@CrossOrigin
@Entity
@Table(name = "users")
@Data
public class UserBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer userId;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="email")
	String email;

	@Column(name="password")
	String password;
	
	@Column(name="gender")
	String gender;

	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false)
	RoleBean role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	Set<AccountBean> accounts = new HashSet<>();
	
	@Column(name="auth_token")
	String authToken;
	

}
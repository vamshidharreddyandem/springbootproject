package com.memorystack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.memorystack.model.audit.DateAudit;

@Entity
@Table(name = "students", uniqueConstraints = {
        @UniqueConstraint(columnNames = {	
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class Student extends DateAudit implements Serializable{
	
   
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Long userId;

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String userName;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    //@NotBlank
    @Size(max = 100)
    private String password;
    
    @Enumerated(EnumType.STRING)
    private RoleName roleName;
    private Boolean locked = false;
    private Boolean enabled = false;

    @Column(name = "dept", columnDefinition = "varchar(100)", nullable = true)
	private String dept;
    
    public Student() {

    }

    public Student(String name, String username, String email, String password) {
        this.name = name;
        this.userName = username;
        this.email = email;
        this.password = password;
    }

    public Student(String name,  String username,
			 String email, RoleName roleName) {
		this.name = name;
		this.userName = username;
		this.email = email;
		this.roleName = roleName;
	}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + name + ", username=" + userName + ", email=" + email + ", password="
				+ password + ", roleName=" + roleName + ", locked=" + locked + ", enabled=" + enabled + "]";
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

    
}
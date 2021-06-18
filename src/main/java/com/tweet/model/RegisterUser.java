package com.tweet.model;



import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
@ToString
public class RegisterUser {

	@Id
	@GeneratedValue
    private int id;
	@NotBlank(message = "Please Provide LoginId")
	private Integer loginId;
	@NotBlank(message = "Please Provide First Name")
	private String firstName;
	@NotBlank(message = "Please Provide Last Name")
	private String lastName;
	@NotBlank(message = "Please Provide Email Address")
	@Indexed(name = "username")
	private String email;
	@NotBlank(message = "Please Provide Password")
	private String password;
	@NotBlank(message = "Please Reenter you password")
	private String confirmPassword;
	@NotBlank(message = "Please Provide Contanct Number")
	private String contactNumber;
	private String loginStatus;
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "RegisterUser [loginId=" + loginId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", confirmPassword=" + confirmPassword + ", contactNumber="
				+ contactNumber + "]";
	}
	public RegisterUser(Integer loginId, String firstName, String lastName, String email, String password,
			String confirmPassword, String contactNumber) {
		super();
		this.loginId = loginId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.contactNumber = contactNumber;
	}
	

}

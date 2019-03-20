package cn.changemax.mas.po;

import java.util.Date;

public class User {
	private String userId;

	private String password;

	private String username;

	private String userName;

	private Date userRegistrationTime;

	private String userGender;

	private String userPhone;

	private String userMailbox;

	private String userAvatar;

	private Integer userQuestionNumber;

	private Integer userAnswerNumber;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public Date getUserRegistrationTime() {
		return userRegistrationTime;
	}

	public void setUserRegistrationTime(Date userRegistrationTime) {
		this.userRegistrationTime = userRegistrationTime;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender == null ? null : userGender.trim();
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone == null ? null : userPhone.trim();
	}

	public String getUserMailbox() {
		return userMailbox;
	}

	public void setUserMailbox(String userMailbox) {
		this.userMailbox = userMailbox == null ? null : userMailbox.trim();
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar == null ? null : userAvatar.trim();
	}

	public Integer getUserQuestionNumber() {
		return userQuestionNumber;
	}

	public void setUserQuestionNumber(Integer userQuestionNumber) {
		this.userQuestionNumber = userQuestionNumber;
	}

	public Integer getUserAnswerNumber() {
		return userAnswerNumber;
	}

	public void setUserAnswerNumber(Integer userAnswerNumber) {
		this.userAnswerNumber = userAnswerNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", username=" + username + ", userName=" + userName
				+ ", userRegistrationTime=" + userRegistrationTime + ", userGender=" + userGender + ", userPhone="
				+ userPhone + ", userMailbox=" + userMailbox + ", userAvatar=" + userAvatar + ", userQuestionNumber="
				+ userQuestionNumber + ", userAnswerNumber=" + userAnswerNumber + "]";
	}

}
package sysadmin.entity;

import sysadmin.DAO.UserAccountDAO;
import sysadmin.DAO.UserProfileDAO;


import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

public class UserProfile{
	private int id;
	private String profile;
	private String description;
	private UserProfileDAO userProfileDAO;

	public static List<UserProfile> selectAllUserAccounts(){
		UserProfileDAO myDAO = new UserProfileDAO();
		return  myDAO.selectAllUserProfile();
	}
	
	

	public UserProfile(int id) {
		super();
		this.id = id;
		this.userProfileDAO = new UserProfileDAO();
	}



	public UserProfile(int id, String profile, String description) {
		super();
		this.id = id;
		this.profile = profile;
		this.description = description;
		this.userProfileDAO = new UserProfileDAO();
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public UserProfileDAO getUserProfileDAO() {
		return userProfileDAO;
	}
	public void setUserProfileDAO(UserProfileDAO userProfileDAO) {
		this.userProfileDAO = userProfileDAO;
	}
	
	
}
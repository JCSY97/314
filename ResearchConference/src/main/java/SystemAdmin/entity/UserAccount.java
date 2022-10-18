package sysadmin.entity;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Hashtable;
import java.util.List;

import dbconnection.DbConnection;
import sysadmin.DAO.UserAccountDAO;



public class UserAccount{
	private int id;
	private String name;
	private String username;
	private String password;
	private String status;
	private UserProfile userProfile;
	private UserAccountDAO userAccountDAO;
	

	
	public boolean login() {
		return userAccountDAO.login(username, password, userProfile.getId());	
	}
	
	public static List<UserAccount> selectAllUserAccounts(){
		UserAccountDAO myDAO = new UserAccountDAO();
		return  myDAO.selectAllUserAccounts();
	}
	
	public static List<UserAccount> searchUserAccounts(String name){
		UserAccountDAO myDAO = new UserAccountDAO();
		return  myDAO.searchUserAccount(name);
	}
	
	public void submitNewUser() throws SQLException {
		 userAccountDAO.submitNewUser(username, password, name, status, userProfile) ;
	}
	
	public boolean checkUserNameExist() {
		return userAccountDAO.usernameExist(username, userProfile.getId());
	}

	public  UserAccount getEditInfo(){
		return userAccountDAO.getEditInfo(this.id);
	}
	
	
	
	
	public UserAccount() {
        super();
        this.userAccountDAO = new UserAccountDAO();
    }

    public UserAccount(int profileID) {
		super();
		this.userProfile = new UserProfile(profileID);
		this.userAccountDAO = new UserAccountDAO();
	}
	
	

	public UserAccount(String name, String username, String password, String status, UserProfile userProfile) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.status = status;
		this.userProfile = userProfile;
		this.userAccountDAO = new UserAccountDAO();
	}

	public UserAccount(int id, String name, String username, String password, String status, UserProfile userProfile) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.status = status;
		this.userProfile = userProfile;
		this.userAccountDAO = new UserAccountDAO();
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
}


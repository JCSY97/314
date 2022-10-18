package sysadmin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import sysadmin.entity.*;
import dbconnection.DbConnection;


public class UserAccountDAO{
	//Insert
	private static final String INSERT_USEERACCOUNT = "INSERT INTO `useraccount` (`username`,`password`, `name`, `status` , `userprofile`) VALUES"
			+ "(?, ?, ?, ?, ?)";
	
	//Search
	private static final String SEARCH_USERACCOUNT_BY_NAME = "select * from useraccount inner join userprofile on useraccount.userprofile "
			+ "= userprofile.id where useraccount.name = ?;";

	private static final String SEARCH_USERACCOUNT_BY_ID = "select * from useraccount inner join userprofile on useraccount.userprofile "
		+ "= userprofile.id where useraccount.id = ?;";

	private static final String SELECT_USERACCOUNT_FOR_LOGIN = "select 1 from useraccount where username = ? and password = ? and userprofile = ? and status = 'active';";
	private static final String SELECT_ALL_USERACCOUNTS = "select * from useraccount inner join userprofile on useraccount.userprofile "
			+ "= userprofile.id order by useraccount.id;";
	//private static final String SELECT_ALL_USERACCOUNTS = "select * from useraccount";
	private static final String CHECK_USERNAME_EXIST_ID = "select 1 from useraccount where username = ? and userprofile = ?;";
	
	
	public boolean usernameExist(String username, int profileID) {
		boolean usernameExist = false;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USERNAME_EXIST_ID )) 
		{
			preparedStatement.setString(1, username);
			preparedStatement.setInt(2, profileID);
			ResultSet rs = preparedStatement.executeQuery();
			usernameExist = rs.next();
			
		}catch (SQLException e) {
			printSQLException (e);
		}
		
		return usernameExist;
	}
	
	
	public List<UserAccount> selectAllUserAccounts(){
		List<UserAccount> userAccounts = new ArrayList<>();
		try(Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERACCOUNTS))
		{
			ResultSet rs =preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString("name");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String status = rs.getString("status");
				int profileID = rs.getInt("userprofile");
				String profile = rs.getString("profile");
				String description = rs.getString("description");
				
				 
				UserProfile tempP = new UserProfile (profileID, profile, description);
				UserAccount temp = new UserAccount(id ,name ,username, password, status, tempP);
				userAccounts.add(temp);
				
				
			}
			
		
		}catch(SQLException e) {
			printSQLException(e);
		}
				
		return userAccounts;
	}
	
	public List<UserAccount> searchUserAccount(String searchName){
		List<UserAccount> userAccounts = new ArrayList<>();
		try(Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERACCOUNT_BY_NAME))
		{
			preparedStatement.setString(1, searchName);
			ResultSet rs =preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString("name");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String status = rs.getString("status");
				int profileID = rs.getInt("userprofile");
				String profile = rs.getString("profile");
				String description = rs.getString("description");
				
				 
				UserProfile tempP = new UserProfile (profileID, profile, description);
				UserAccount temp = new UserAccount(id ,name ,username, password, status, tempP);
				userAccounts.add(temp);
				
				
			}
			
		
		}catch(SQLException e) {
			printSQLException(e);
		}
				
		return userAccounts;
	}

	public UserAccount getEditInfo(int tempId){
		
		try(Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERACCOUNT_BY_ID))
		{
			preparedStatement.setInt(1, tempId);
			ResultSet rs =preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString("name");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String status = rs.getString("status");
				int profileID = rs.getInt("userprofile");
				String profile = rs.getString("profile");
				String description = rs.getString("description");
				
				 
				UserProfile tempP = new UserProfile (profileID, profile, description);
				UserAccount temp = new UserAccount(id ,name ,username, password, status, tempP);
				return temp;
				
				
			}
			
		
		}catch(SQLException e) {
			printSQLException(e);
		}
				
		return null;
	}


	
	public boolean login(String username, String password, int userprofile) {
		boolean loginSuccessful = false;
		
		try(Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERACCOUNT_FOR_LOGIN))
		{
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setInt(3, userprofile);
			ResultSet rs = preparedStatement.executeQuery();
			loginSuccessful = rs.next();
		}catch (SQLException e) {
			printSQLException (e);
		}
		
		return loginSuccessful;
		
		
	}
	
	public boolean submitNewUser(String username, String password, String name, String Status, UserProfile userProfile)throws SQLException {
		boolean successAdd = true;
		
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USEERACCOUNT)) 
		{
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, "active");
			preparedStatement.setInt(5, userProfile.getId());
			successAdd = preparedStatement.executeUpdate() > 0;	
		} 
		return successAdd;
		
	}
	
	private void printSQLException(SQLException ex) 
	{
		for (Throwable e : ex) 
		{
			if (e instanceof SQLException) 
			{
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) 
				{
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	
}
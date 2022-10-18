package sysadmin.DAO;

import sysadmin.entity.UserAccount;
import sysadmin.entity.UserProfile;
import dbconnection.DbConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class UserProfileDAO{
	private static final String SELECT_ALL_USERPROFILE= "select * from userprofile";
	
	
	public List<UserProfile> selectAllUserProfile(){
		List<UserProfile> UserProfiles = new ArrayList<>();
		try(Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERPROFILE))
		{
			ResultSet rs =preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String profile = rs.getString("profile");
				String description = rs.getString("description");
				
				UserProfile temp = new UserProfile(id,profile,description );
				

				UserProfiles.add(temp);
				
				
			}
			
		
		}catch(SQLException e) {
			printSQLException(e);
		}
				
		return UserProfiles;
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
package misc;

import java.sql.*;
import java.util.ArrayList;

import Core.Unit;
public class ArmyDataBaseConnector 
{
	private String Path;
	private Connection connectionDB;
	private Statement requestStmt;
	
	
	
	
	public ArmyDataBaseConnector()
	{
		
	}
	
	public void setPath(String path)
	{
		this.Path = path;
	}
	
	public void connectToDB() 
	{
	    try 
	    {
	    	Class.forName("org.sqlite.JDBC");
			connectionDB = DriverManager.getConnection("jdbc:sqlite:"+this.Path);
			requestStmt = connectionDB.createStatement();
		} 
	    catch (Exception e) 
	    {
			e.printStackTrace();
		}
	}
	
	public void retrieveAllRaces(ArrayList<String> races) 
	{
		ResultSet rs;
		try 
		{
			rs = requestStmt.executeQuery("select * from race");
			while(rs.next())
			{
				races.add(rs.getString("race_name"));
			}
		} 
		catch (SQLException e)
		{	
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Unit> getAllTheUnitDescription(String armyRace)
	{
		return null;
	}
}

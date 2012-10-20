package misc;

import java.sql.*;
import java.util.ArrayList;

import Core.Unit;
public class ArmyDataBaseConnector 
{
	private String Path;
	private ArrayList<Unit> armyListing;
	private Connection connectionDB;
	private Statement requestStmt;
	
	private ArrayList<String> allRaces;
	
	
	public ArmyDataBaseConnector()
	{
		
	}
	
	public void setPath(String path)
	{
		this.Path = path;
	}
	
	public void connectToDB() throws ClassNotFoundException
	{
		armyListing = new ArrayList<Unit>();
		Class.forName("org.sqlite.JDBC");
	    Connection connection = null;
	    try {
			connectionDB = DriverManager.getConnection("jdbc:sqlite:"+this.Path);
			requestStmt = connectionDB.createStatement();
		} 
	    catch (SQLException e) 
	    {
			e.printStackTrace();
		}
	    
	   
	}
	
	public ArrayList<String> getAllRaces() 
	{
		if(allRaces == null)
		{
			allRaces = new ArrayList<String>();
			ResultSet rs;
			try 
			{
				rs = requestStmt.executeQuery("select * from race");
				while(rs.next())
				{
					allRaces.add(rs.getString("race_name"));
				}
			} 
			catch (SQLException e)
			{	
				e.printStackTrace();
			}
			
		}
		return allRaces;
	}
	
	
	public ArrayList<Unit> getAllTheUnitDescription(String armyRace)
	{
		return null;
	}
}

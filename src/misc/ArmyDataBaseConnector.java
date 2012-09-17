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
	
	public ArmyDataBaseConnector()
	{
		armyListing = new ArrayList<Unit>();
	}
	
	public void setPath(String path)
	{
		this.Path = path;
	}
	
	public void connectToDB() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.sqlite.JDBC");
		connectionDB = DriverManager.getConnection("jdbc:sqlite:"+this.Path);
		requestStmt = connectionDB.createStatement();
	}
	
	public ArrayList<Unit> getAllTheUnitDescription(String armyRace)
	{
		return null;
	}
	//we have to connect to the database
	//load all units when the race is chosen
	//store all the results in a ArrayList and then provide it to the calling object
}

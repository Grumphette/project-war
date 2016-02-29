package misc;

public class Coord2D 
{
	private int x;
	private int y;
	
	public Coord2D(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void translate(int dx, int dy)
	{
		this.x += dx;
		this.y += dy;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
}

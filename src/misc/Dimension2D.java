package misc;

public class Dimension2D 
{
	private int width;
	private int heigh;
	
	public Dimension2D(int width, int heigh)
	{
		this.width = width;
		this.heigh = heigh;
	}
	
	
	public void expandTo(int width, int heigh)
	{
		assert(width > this.width && heigh > this.heigh);
		this.width = width;
		this.heigh = heigh;
	}
	
	public void shrinkTo (int width, int heigh)
	{
		assert(width < this.width && heigh < this.heigh);
		this.width = width;
		this.heigh = heigh;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeigh()
	{
		return this.heigh;
	}
}

package misc;

import java.awt.Dimension;

public class Dimension2D extends Dimension
{
	
	public Dimension2D(int width, int height)
	{
		super(width,height);
	}
	
	public Dimension2D()
	{
		super();
	}
	
	public void expandTo(int width, int height)
	{
		assert(width > this.getWidth() && height > this.getHeight());
		this.setSize(width, height);
	}
	
	public void shrinkTo (int width, int height)
	{
		assert(width < this.getWidth() && height < this.getHeight());
		this.setSize(width, height);
	}
}

package GUIobjects;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import misc.Dimension2D;


public class BackImage 
{
	private String Name;
	private File ImgFile;
	private Image RealImg;
	private Dimension2D size;
	
	/*TODO take in acount that we have to manipulate SVG images*/
	
	public BackImage(String Name, String Path, int width, int height) 
	{
		this.size = new Dimension2D(width,height);
		this.Name = Name;
		ImgFile = new File(Path);

	}
	
	private void generateImg() throws IOException
	{
		RealImg = ImageIO.read(ImgFile);
	}
	
	public String getName()
	{
		return Name;
	}
	
	public Dimension2D getImgSize()
	{
		return this.size;
	}
	
	public Image getFinalImage()
	{
		return RealImg;
	}
	
	public BackImage getImage() throws IOException
	{
		if(RealImg == null)
		{
			this.generateImg();
		}
		return this;
	}
}
package GUIobjects;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class BackImage 
{
	private String Name;
	private String Path;
	private File ImgFile;
	private Image RealImg;
	
	
	
	public BackImage(String Name, String Path) 
	{
		this.Name = Name;
		this.Path = Path;
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
	
	public Image getImage() throws IOException
	{
		if(RealImg == null)
		{
			this.generateImg();
		}
		return RealImg;
	}
}
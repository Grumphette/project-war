package Core;


public class Battlefield 
{
	private int sizeX,sizeY;
	private Field[][] battlefieldZones;
	
	
	public Battlefield(int sizeX, int sizeY)
	{
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		
		this.battlefieldZones = new Field[this.sizeX][this.sizeY];
	}
}



public class Cuboid implements Solids {

	private double length, width, height;
	private String color, name;
	
	public Cuboid(double length, double width, double height, String name, String color){
		this.length = length;
		this.width = width;
		this.height = height;
		this.name = name;
		this.color = color;
	}
	
	//Volume = length*width*height
	public double getVolume(){
		return length*width*height;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getColor() {
		return this.color;
	}
	
}
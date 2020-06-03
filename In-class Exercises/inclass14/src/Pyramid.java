
public class Pyramid implements Solids {

	private double length, width, height;
	private String color, name;
	
	public Pyramid(double length, double width, double height, String name, String color) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.name = name;
		this.color = color;
	}
	
	//Volume = length*width*height/3
	public double getVolume(){
		return length*width*height/3;
	}
		
	public String getName() {
		return this.name;
	}
	
	public String getColor() {
		return this.color;
	}
}
import java.lang.Math.*;

public class Octahedron implements Solids{
	
	private double edge;
	private String color, name;
	
	public Octahedron(double edge, String name, String color){
		this.edge = edge;
		this.color = color;
		this.name = name;
	}
	
	//Volume sqrt(2)/3 times edge^3
	public double getVolume(){
		return Math.sqrt(2) / 3.0 * Math.pow(edge, 3);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getColor() {
		return this.color;
	}
}
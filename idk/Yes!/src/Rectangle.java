public class Rectangle {
	
	private double length, width;
	
	public Rectangle() {
		length = 1;
		width = 1;
	}
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	
	//write an appropriate toString method, getters and setters
	
	@Override
	public String toString() {
		return "Rectangle [length=" + this.length + ", width=" + this.width + "]";
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
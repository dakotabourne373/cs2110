public class Circle {
	
	private double radius;
	private Point center;
	
	public Circle() {
		radius = 1;
		center = new Point(0,0);
	}
	
	public Circle(double radius, Point center) {
		this.radius = radius;
		//this.center = center;
		this.center = new Point(center);
	}
	
	@Override
	public String toString() {
		return "Center: " + center + " Radius: " + radius;
	}
	
	public boolean contains(Point p) {
		double distance = center.distance(p);
		if(distance <= radius) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		Point p = new Point(3,3);
		Point y = new Point(8,2);
		Circle c = new Circle(3, p);
		Circle v = c;
		Circle b = new Circle(3, p);
		Circle n = new Circle(2, y);
		System.out.println(c);
		p.setX(15);
		System.out.println(c);
		System.out.println(v.equals(c));
		System.out.println(v.equals(b));
		System.out.println(v.equals(n));
		
		

	}
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		
		Circle otherCircle = (Circle) o;
		
		if (this.radius == otherCircle.radius && this.center.equals(otherCircle.center)) {
			return true;
		}else {
			return false;
		}
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius > 0) {
			this.radius = radius;
		}
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	
	

}
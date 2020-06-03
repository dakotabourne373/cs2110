
public class PointsOnAPlane {
	public static double points(double x, double y) {
		if (x >= 0 && y >= 0) {
			return x * y; 
		}
		else if (x < 0 && y >= 0) {
			return x - y;
		}
		else if (x < 0 && y < 0) {
			return x / y;
		} else {
			return x + y;
		}
	}
}

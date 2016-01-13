import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a set of points and a Utility function to find distance from the
 * origin. Find the k nearest distances.
 * 
 * <pre>
 * 1. No points
 * 2. Points less than k
 * 3. Points more than k, but points with unique distance is less than k
 * 4. A lot of repeated points
 * </pre>
 * 
 * @author dprasad
 *
 */
public class KNearestPoints {

	public static void main(String[] args) {
		Point[] points = new Point[] { new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(1, 4), new Point(1, 3), new Point(1, 6),
				new Point(9, 1), new Point(7, 2), new Point(2, 8), new Point(2, 7), new Point(3, 1) };

		System.out.println(nearestDistances(points, 5));
		System.out.println(Arrays.toString(nearestDistanceHeap(points, 5)));
	}

	public static double[] nearestDistanceHeap(Point[] points, int k) {
		
		if (points == null || points.length == 0)
			return null;
		
		MaxHeap H = new MaxHeap(k);
		int insertCount = 0;
		int i = 0;
		do {
			double dist = Util.distFromOriginUtil(points[i++]);
			if (!H.find(dist, 0)) {
				try {
					H.insert(dist);
					insertCount++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} while (insertCount < k && i < points.length);

		for (i = k; i < points.length; i++) {
			double dist = Util.distFromOriginUtil(points[i]);
			if (dist < H.getMax()) {
				if (!H.find(dist, 0)) {
					try {
						H.insert(dist);
						H.extractMax();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return H.A;
	}

	public static List<Double> nearestDistances(Point[] points, int k) {

		if (points == null || points.length == 0)
			return null;

		Set<Point> pointSet = new HashSet<Point>();
		pointSet.addAll(Arrays.asList(points));

		Set<Double> distances = new HashSet<Double>();
		for (Point p : pointSet) {
			distances.add(Util.distFromOriginUtil(p));
		}

		List<Double> distList = new ArrayList<Double>();
		distList.addAll(distances);
		Collections.sort(distList);
		if (distList.size() > k)
			return distList.subList(0, k);
		else
			return distList;
	}

}

class Util {
	public static double distFromOriginUtil(Point p) {
		return (Math.round(100 * Math.sqrt(p.x * p.x + p.y * p.y))/100.0);
	}
}

class DistanceComparator implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		if (Util.distFromOriginUtil(o1) > Util.distFromOriginUtil(o2))
			return 1;
		else if (Util.distFromOriginUtil(o1) < Util.distFromOriginUtil(o2))
			return -1;
		return 0;
	}

}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}

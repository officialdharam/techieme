package com.closestpoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ClosestPoints {

	static Point p1 = null, p2 = null;

	/*
	 * Main method just to test test cases for two approaches, checking all
	 * points in Q and checking selective points in Q
	 */
	public static void main(String[] args) {
		ClosestPoints cp = new ClosestPoints();
		int testPassed = 0;
		List<Integer> failedIndex = new ArrayList<Integer>();
		/*
		 * for (int i = 0; i < 5000; i++) { System.out.println("Test Case " +
		 * i); Point[] randomPoints = cp.generateRandomPoints(30); Point[]
		 * solution = cp.solution(randomPoints, true); Point[] solution1 =
		 * cp.solution(randomPoints, false); if (cp.distance(solution[0],
		 * solution[1]) == cp.distance(solution1[0], solution1[1])) {
		 * testPassed++; } else { failedIndex.add(i); } }
		 */

		long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			System.out.println("Test Case " + i);
			Point[] randomPoints = cp.generateRandomPoints(10000);
			cp.solution(randomPoints, true);
		}
		long end = System.currentTimeMillis();
		long first = end - start;
		start = System.currentTimeMillis();

		for (int i = 0; i < 10; i++) {
			System.out.println("Test Case " + i);
			Point[] randomPoints = cp.generateRandomPoints(10000);
			// cp.solution(randomPoints, false);
			cp.bruteForce(randomPoints);
		}
		end = System.currentTimeMillis();
		long second = end - start;
		System.out.println("First One " + first);
		System.out.println("Second One " + second);

		System.out.println("Test Passed " + testPassed);
		System.out.println("Test Failed " + failedIndex);
	}

	public double bruteForce(Point[] randomPoints) {
		double d = Double.POSITIVE_INFINITY;
		for (int i = 0; i < randomPoints.length; i++) {
			for (int j = 0; j < randomPoints.length; j++) {
				if (i != j) {
					int ds = distance(randomPoints[i], randomPoints[j]);
					d = ds < d ? ds : d;
				}
			}
		}
		
		return Math.sqrt(d);
	}

	public Point[] solution(Point[] randomPoints, boolean efficient) {

		if (randomPoints.length < 2)
			System.out.println("Only one point. Cannot find pairs.");

		// point map, stores points in X sorted and then internally Y sorted.
		// Facilitates O(1) retrieval
		Map<Integer, Map<Integer, Point>> pointMap = new HashMap<Integer, Map<Integer, Point>>();
		Arrays.sort(randomPoints, new XYComparator());

		for (Point pt : randomPoints) {
			Map<Integer, Point> map = pointMap.get(pt.x);
			if (map == null) {
				map = new HashMap<Integer, Point>();
				pointMap.put(pt.x, map);
			}
			map.put(pt.y, pt);
		}

		// check for coincidence
		Point coincident = conincident(randomPoints);
		if (null != coincident) {
			System.out.println("Points are coincident" + coincident);
			return new Point[] { coincident, coincident };
		} else {
			closestPair(randomPoints, 0, randomPoints.length - 1, pointMap, efficient);
			return new Point[] { p1, p2 };
		}
	}

	public int distance(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}

	public Point[] generateRandomPoints(int num) {
		Point[] points = new Point[num];
		Random rand = new Random();
		for (int i = 0; i < num; i++) {
			points[i] = new Point(10 + rand.nextInt(100), 10 + rand.nextInt(65));
			// points[i] = new Point(rand.nextInt(10), rand.nextInt(8));
		}
		return points;
	}

	public double closestPair(Point[] sortedByXY, int p, int q, Map<Integer, Map<Integer, Point>> pointMap, boolean efficient) {
		Point l1 = null, l2 = null, r1 = null, r2 = null;
		if (q <= p) {
			p1 = sortedByXY[p];
			p2 = sortedByXY[q];
			return Double.POSITIVE_INFINITY;
		}

		if (q - p == 1) {
			p1 = sortedByXY[p];
			p2 = sortedByXY[q];
			return Math.sqrt(distance(sortedByXY[p], sortedByXY[q]));
		}

		int mid = p + (q - p) / 2;
		double dp = closestPair(sortedByXY, p, mid, pointMap, efficient);
		l1 = p1;
		l2 = p2;
		double dq = closestPair(sortedByXY, mid + 1, q, pointMap, efficient);
		r1 = p1;
		r2 = p2;
		double d = Math.min(dp, dq);
		if (d == dp) {
			p1 = l1;
			p2 = l2;
		} else {
			p1 = r1;
			p2 = r2;
		}

		Point median = sortedByXY[mid];
		// find all points whose x is greater than median.x - d and less than
		// median.x;
		if (!efficient)
			d = borderMatch(sortedByXY, p, q, mid, d, median);
		else
			d = efficientBorderMatch(sortedByXY, p, q, pointMap, mid, d, median);
		return d;

	}

	private double borderMatch(Point[] sortedByXY, int p, int q, int mid, double d, Point median) {
		List<Point> pointOfInterestInP = new ArrayList<Point>();
		for (int i = p; i <= mid; i++) {
			if (sortedByXY[i].x - median.x < d) {
				pointOfInterestInP.add(sortedByXY[i]);
			}
		}

		for (Point pt : pointOfInterestInP) {
			for (int i = mid + 1; i <= q; i++) {
				double dist = Math.sqrt(distance(pt, sortedByXY[i]));
				if (dist < d) {
					d = dist;
					p1 = pt;
					p2 = sortedByXY[i];
				}
			}
		}
		//System.out.println("          BORDER MIN : " + sortedByXY[p] + " - " + sortedByXY[mid] + " - " + sortedByXY[q] + " = " + d + "[" + p1 + ","
		//		+ p2 + "]");
		return d;
	}

	private double efficientBorderMatch(Point[] sortedByXY, int p, int q, Map<Integer, Map<Integer, Point>> pointMap, int mid, double d, Point median) {
		List<Point> pointOfInterestInP = new ArrayList<Point>();
		int pointer = sortedByXY[mid].x - median.x;

		while (pointer <= median.x) {
			Map<Integer, Point> map = pointMap.get(pointer);
			if (map != null) {
				Collection<Point> values = map.values();
				pointOfInterestInP.addAll(values);
			}
			pointer++;
		}

		for (Point pt : pointOfInterestInP) {
			pointer = median.x;
			// the below loop must not run more than two times
			while (pointer <= median.x + d + 1) {
				Map<Integer, Point> map = pointMap.get(pointer);
				if (map != null) {
					int pointer2 = (int) (pt.y - d - 1);
					// this can be made more efficient if we try to check in
					// both direction instead of starting from one end, then
					// stopping at the first encounter of y in both directions
					// and checking the minimum. At max two y for each x. The
					// next nested loop must run for two times only in an more
					// precise version.

					while (pointer2 < 1 + pt.y + d) {
						Point point = map.get(pointer2);
						if (point == pt) {
							pointer2++;
							continue;
						}
						if (point != null) {
							double dist = Math.sqrt(distance(pt, point));
							if (dist < d) {
								d = dist;
								p1 = pt;
								p2 = point;
							}
						}
						pointer2++;
					}
				}
				pointer++;
			}
		}

	//	System.out.println("EFFICIENT BORDER MIN : " + sortedByXY[p] + " - " + sortedByXY[mid] + " - " + sortedByXY[q] + " = " + d + "[" + p1 + ","
		//		+ p2 + "]");
		return d;
	}

	private double efficientBorderMatch2(Point[] sortedByXY, int p, int q, Map<Integer, Map<Integer, Point>> pointMap, int mid, double d, Point median) {
		List<Point> pointOfInterestInP = new ArrayList<Point>();
		int pointer = sortedByXY[mid].x - median.x;

		while (pointer <= median.x) {
			Map<Integer, Point> map = pointMap.get(pointer);
			if (map != null) {
				Collection<Point> values = map.values();
				pointOfInterestInP.addAll(values);
			}
			pointer++;
		}

		for (Point pt : pointOfInterestInP) {
			pointer = median.x;

			// fetch all 8 points which can be a problem

			// the below loop must not run more than two times
			while (pointer <= median.x + d + 1) {
				Map<Integer, Point> map = pointMap.get(pointer);
				if (map != null) {
					int pointer2 = (int) (pt.y - d - 1);
					// this can be made more efficient if we try to check in
					// both direction instead of starting from one end, then
					// stopping at the first encounter of y in both directions
					// and checking the minimum. At max two y for each x. The
					// next nested loop must run for two times only in an more
					// precise version.

					while (pointer2 < 1 + pt.y + d) {
						Point point = map.get(pointer2);
						if (point == pt) {
							pointer2++;
							continue;
						}
						if (point != null) {
							double dist = Math.sqrt(distance(pt, point));
							if (dist < d) {
								d = dist;
								p1 = pt;
								p2 = point;
							}
						}
						pointer2++;
					}
				}
				pointer++;
			}
		}

		System.out.println("EFFICIENT BORDER MIN : " + sortedByXY[p] + " - " + sortedByXY[mid] + " - " + sortedByXY[q] + " = " + d + "[" + p1 + ","
				+ p2 + "]");
		return d;
	}

	public Point conincident(Point[] sortedPoints) {
		for (int i = 0; i < sortedPoints.length - 1; i++) {
			if (sortedPoints[i].equals(sortedPoints[i + 1]))
				return sortedPoints[i];
		}
		return null;
	}

	public Point[] createCustomPoints() {
		Point[] points = new Point[30];
		points[0] = new Point(11, 11);
		points[1] = new Point(12, 35);
		points[2] = new Point(15, 54);
		points[3] = new Point(18, 25);
		points[4] = new Point(21, 65);
		points[5] = new Point(23, 31);
		points[6] = new Point(27, 31);
		points[7] = new Point(28, 42);
		points[8] = new Point(28, 66);
		points[9] = new Point(31, 56);
		points[10] = new Point(31, 66);
		points[11] = new Point(41, 13);
		points[12] = new Point(41, 41);
		points[13] = new Point(43, 64);
		points[14] = new Point(45, 64);
		points[15] = new Point(47, 38);
		points[16] = new Point(48, 37);
		points[17] = new Point(52, 27);
		points[18] = new Point(53, 14);
		points[19] = new Point(57, 56);
		points[20] = new Point(58, 38);
		points[21] = new Point(71, 58);
		points[22] = new Point(75, 45);
		points[23] = new Point(78, 43);
		points[24] = new Point(85, 68);
		points[25] = new Point(86, 55);
		points[26] = new Point(89, 66);
		points[27] = new Point(89, 67);
		points[28] = new Point(91, 50);
		points[29] = new Point(100, 56);
		return points;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
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

class XYComparator implements Comparator<Point> {
	@Override
	public int compare(Point o1, Point o2) {
		if (o1 == null)
			return -1;

		if (o2 == null)
			return 1;

		return (o1.x < o2.x) ? -1 : ((o1.x == o2.x) ? ((o1.y < o2.y) ? -1 : ((o1.y == o2.y) ? 0 : 1)) : 1);
	}
}

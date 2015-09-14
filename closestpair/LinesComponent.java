package com.closestpoints;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class LinesComponent extends JComponent {

	private static final int NUMBER_OF_POINTS = 20;

	private static class Rectangle {
		final int x1;
		final int y1;
		final int width;
		final int height;
		final Color color;

		public Rectangle(int x1, int y1, int width, int height, Color color) {
			this.x1 = x1;
			this.y1 = y1;
			this.width = width;
			this.height = height;
			this.color = color;
		}
	}

	private final LinkedList<Rectangle> rcts = new LinkedList<Rectangle>();

	public void addLine(int x1, int x2, int x3, int x4) {
		addLine(x1, x2, x3, x4, Color.black);
	}

	public void addLine(int x1, int x2, int x3, int x4, Color color) {
		rcts.add(new Rectangle(x1, x2, x3, x4, color));
		repaint();
	}

	public void clearLines() {
		rcts.clear();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int i;
		for (i = 0; i < rcts.size(); i++) {
			Rectangle line = rcts.get(i);
			g.setColor(line.color);
			if (i == rcts.size() - 1) {

				double sqrt = Math.sqrt(distance(new Point(line.x1 / 10, line.y1 / 10), new Point(line.width / 10, line.height / 10)));
				if(sqrt > 0){
					Graphics2D g2D = (Graphics2D)g;
					g2D.setStroke(new BasicStroke(3));
					g.drawLine(line.x1, line.y1, line.width, line.height);
				}
				else
					g.fillRect(line.x1, line.y1, 5, 5);
				g.drawString("Shortest Distance : " + sqrt, 1000, 10);
				
			} else {
				g.fillRect(line.x1, line.y1, line.width, line.height);
				g.drawString("[" + line.x1 / 10 + ", " + line.y1 / 10 + "]", line.x1, line.y1 - 10);
			}
		}
	}

	private int distance(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		final LinesComponent comp = new LinesComponent();
		comp.setPreferredSize(new Dimension(1200, 800));
		JButton jButton = new JButton("Refresh");
		final ClosestPoints cp = new ClosestPoints();
		jButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				comp.clearLines();
				Point[] points = cp.generateRandomPoints(NUMBER_OF_POINTS);
				//Point[] points = cp.createCustomPoints();
				for (Point p : points) {
					comp.addLine(p.x * 10, p.y * 10, 5, 5);
				}
				Point[] solution = cp.solution(points, true);
				if (solution != null) {
					comp.addLine(solution[0].x * 10, solution[0].y * 10, solution[1].x * 10, solution[1].y * 10, Color.RED);
				}
			}
		});
		
		testFrame.getContentPane().add(comp, BorderLayout.CENTER);
		testFrame.getContentPane().add(jButton, BorderLayout.SOUTH);
		testFrame.pack();
		testFrame.setVisible(true);
	}

}

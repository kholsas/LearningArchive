

package com.psybergate.kholofelo.rectangle.render;

import java.util.List;

import com.psybergate.kholofelo.rectangle.Rectangle;

public class RectangleManager
	{

		public void reStackRectangles ( Rectangle[] rectangles , List<Rectangle> listOfNewRecs , int count ) {
			Rectangle nextMinRec = findNextMinHeigh(rectangles);
			int x1 = Integer.MAX_VALUE , x2 = Integer.MIN_VALUE;
			int y1 = Integer.MAX_VALUE , y2 = Integer.MIN_VALUE;

			
			y2 = nextMinRec.getY2();
			
			if (count == 0) {
 
				int[] baseX1nX2 = getBaseX1nX2(rectangles);
				x1 = baseX1nX2[0];
				x2 = baseX1nX2[1];
				listOfNewRecs.add(new Rectangle(x1, x2, 0, y2));
				reStackRectangles(rectangles, listOfNewRecs, 1); 
			} else {
				
				for (int i = 0; i < rectangles.length -1; i++) {
					y1 = nextMinRec.getY2();
					nextMinRec = findNextMinHeigh(rectangles);
					System.out.println(nextMinRec.getX1() +" " + nextMinRec.getX2() +" : " + nextMinRec.getY1() +" " + nextMinRec.getY2()); 
					y2 = nextMinRec.getY2();
					x1 = nextMinRec.getX1();
					x2 = nextMinRec.getX2();  
				
					listOfNewRecs.add(new Rectangle(x1, x2, y1, y2));
				}
				
			}

			System.out.println(listOfNewRecs.size() +" : " + listOfNewRecs.get(0).getX1() + ", " + listOfNewRecs.get(0).getX2() + " , " + listOfNewRecs.get(0).getY1() + " , " + listOfNewRecs.get(0).getY2());
			draw(listOfNewRecs.toArray(new Rectangle[] {}));
		}

		private int[] getBaseX1nX2 ( Rectangle[] rectangles ) {
			int x1 = Integer.MAX_VALUE , x2 = Integer.MIN_VALUE;

			for (Rectangle rectangle : rectangles) {
				if (rectangle.getX1() < x1)
					x1 = rectangle.getX1();
				if (rectangle.getX2() > x2)
					x2 = rectangle.getX2();
			}

			return new int[] { x1, x2 };
		}

		private Rectangle findNextMinHeigh ( Rectangle[] rectangles ) {
			Rectangle aSmallRecInHeigh = new Rectangle(0, 0, 0, 30); 

			for (Rectangle rectangle : rectangles) {
				System.out.println(rectangle.getY2() +" ----" + aSmallRecInHeigh.getY2() );
				if (rectangle.getY2() < aSmallRecInHeigh.getY2() && rectangle.isProcessed() == false) {
					rectangle.setProcessed(true);
					aSmallRecInHeigh = rectangle;
				}
			}

			return aSmallRecInHeigh;
		}

		public void draw ( Rectangle[] rectangles ) {

			int[] xBoundaries = findXBoundaries(rectangles);
			int[] yBoundaries = findYBoundaries(rectangles);

			boolean isXcoordinateUsed;

			for (int y = yBoundaries[1]; y >= 0; y--) {
				isXcoordinateUsed = false;
				for (int x = 0; x <= xBoundaries[1]; x++) {
					isXcoordinateUsed = false;

					for (Rectangle rectangle : rectangles) {

						if (((x == rectangle.getX1() || x == rectangle.getX2()) && (y <= rectangle.getY2() && y >= rectangle.getY1())) || ((y == rectangle.getY1() || y == rectangle.getY2()) && (x <= rectangle.getX2() && x >= rectangle.getX1()))) {

			 				System.out.print(isXcoordinateUsed?"":"*");
							isXcoordinateUsed = true;
						} else {
							System.out.print(" ");
						}
					}
				}
				System.out.println();

			}
		}

		public int[] findYBoundaries ( Rectangle[] rectangles ) {

			int y1 = Integer.MAX_VALUE;
			int y2 = Integer.MIN_VALUE;

			for (Rectangle rectangle : rectangles) {
				if (rectangle.getY1() < y1)
					y1 = rectangle.getY1();

				if (rectangle.getY2() > y2)
					y2 = rectangle.getY2();
			}

			return new int[] { y1, y2 };
		}

		public int[] findXBoundaries ( Rectangle[] rectangles ) {
			int x1 = Integer.MAX_VALUE;
			int x2 = Integer.MIN_VALUE;
			for (Rectangle rectangle : rectangles) {
				if (rectangle.getX2() > x2)
					x2 = rectangle.getX2();
				if (rectangle.getX1() < x1)
					x1 = rectangle.getX1();
			}

			return new int[] { x1, x2 };
		}

	}

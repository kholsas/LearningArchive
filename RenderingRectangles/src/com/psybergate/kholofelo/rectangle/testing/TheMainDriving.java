

package com.psybergate.kholofelo.rectangle.testing;

import java.util.ArrayList;

import org.w3c.dom.css.Rect;

import com.psybergate.kholofelo.rectangle.Rectangle;
import com.psybergate.kholofelo.rectangle.render.RectangleManager;

public class TheMainDriving
	{

		public static void main ( String[] args ) {
			Rectangle[] rectangles = new Rectangle[] { new Rectangle(0, 5, 0, 20), new Rectangle(5, 10, 0, 15), new Rectangle(10, 20, 0, 18), new Rectangle(20, 23, 0, 5), new Rectangle(23, 30, 0, 8)

			};

			RectangleManager rectangleManager = new RectangleManager();
			rectangleManager.draw(rectangles);
			System.out.println();
			System.out.println();
 
			rectangleManager.reStackRectangles(rectangles , new ArrayList<Rectangle>(), 0);
//			 rectangleManager.draw(rectangles);

		}
	}

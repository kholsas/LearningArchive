

package com.psybergate.magicsquare;

import java.util.Scanner;

public class MagicSquare
	{

		private static int	count	= 0;

		/**
		 * @param args
		 *           time: 50 min.. with some silly indexing mistakes
		 */
		public static void main ( String[] args ) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter magic suare size");
			int size = input.nextInt();
			createSquare(size);
			input.close();

		}

		private static void createSquare ( int size ) {
			if (isOdd(size)) {
				int sqaure[][] = new int[size][size];
				System.out.println("Filling Square with numbers");
				solveMagicSquareRecursive(sqaure, 0, (int) (size / 2), 1);// initial x and y
																			// position, and
																			// initial value
				System.out.println("Finished making square");
				System.out.println("Printing all numbers in the square");
				outputSquare(sqaure);
			}
			else createSquare(size + 1);// Its even, now changing to odd

		}

		private static void solveMagicSquareRecursive ( int[][] square , int y , int x ,
				int currentVal ) {
			if (count >= square.length * square.length) { return; }

			try {
				if (square[y][x] == 0) {
					square[y][x] = currentVal;
					count++;
					solveMagicSquareRecursive(square, y - 1, x + 1, currentVal + 1);
				}
				else {
					solveMagicSquareRecursive(square, y + 2, x - 1, currentVal);
				}
			}
			catch (ArrayIndexOutOfBoundsException e) {
				int x1 = 0 , y1 = 0;
				int size = square[0].length - 1;
				if ((y < 0 && x > size)) {// at the top right corner
					y1 = y + 2;
					x1 = x - 1;

				}
				else if (x > size && (y <= size && y >= 0)) {
					y1 = y;
					x1 = 0;
				}
				else if (y < 0 && (x <= size && x >= 0)) {// on top column
					y1 = size;
					x1 = x;
				}
				solveMagicSquareRecursive(square, y1, x1, currentVal);
			}
		}

		private static void outputSquare ( int[][] sqaure ) {

			for (int y = 0; y < sqaure[0].length; y++) {
				long sum = 0;
				for (int x = 0; x < sqaure.length; x++) {
					sum += sqaure[y][x];
					String line = sqaure[y][x] + "";
					line = String.format("%5s", line);
					System.out.print(line);
				}
				System.out.print("-->" + sum);
				System.out.println();

			}

			for (int i = 0; i < sqaure.length; i++)
				System.out.print(String.format("%5s", "|"));
			System.out.println();
			/*
			 * 
			 * adding the verticals
			 */
			long verticalSum = 0 , negDiagonalSum = 0 , posDiagonalSum = 0;
			for (int y = 0; y < sqaure.length; y++) {
				verticalSum = 0;
				for (int x = 0; x < sqaure.length; x++) {
					verticalSum += sqaure[x][y];
				}
				System.out.print(String.format("%5s", verticalSum));
			}

			/*
			 * adding position slope
			 */
			//System.out.println();

			for (int y = 0; y < sqaure.length; y++) {

				for (int x = 0; x < sqaure.length; x++) {
					if (x == y) posDiagonalSum += sqaure[y][x];
				}
			}
			int x = sqaure.length - 1;
			for (int y = 0; y < sqaure.length; y++) {

				negDiagonalSum += sqaure[y][x--];
			}
			System.out.print("\\ " + posDiagonalSum);
			System.out.print("/" + negDiagonalSum);
		}

		private static boolean isOdd ( int a ) {
			return a % 2 > 0;
		}

	}

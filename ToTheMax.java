package tothemax;

import java.util.*;

public class ToTheMax {
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int[][] matrix = setMatrix();
		int maxSum = findLargestSum(matrix);
		System.out.println(maxSum);
	}
	
	public static int[][] setMatrix() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] matrix = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				matrix[i][j] = scan.nextInt();
			}
		}
		return matrix;
	}
	
	public static int sum(int[][] matrix, int x1, int y1, int x2, int y2) {
		int sum = 0;
		for(int i=x1; i<=x2; i++) {
			for(int j=y1; j<=y2; j++)
				sum += matrix[i][j];
		}
		return sum;
	}
	
	public static int findLargestSum(int[][] matrix) {
		int maxSum = -127*matrix.length*matrix.length;
		int srSum;
		//look at all sums
		for(int w=1; w<=matrix.length+1; w++) {
			for(int h=1; h<=matrix.length+1; h++) {
				for(int wx=0; wx<(matrix.length-w); wx++) {
					for(int hx=0; hx<(matrix.length-h); hx++) {
						srSum = sum(matrix, wx, hx, w+wx, h+hx);
						if(srSum > maxSum)
							maxSum = srSum;
					}
				}
			}
		}
		return maxSum;
	}
	

}

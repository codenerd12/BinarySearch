package com.advance.problem;

import java.util.Arrays;

public class AggressiveCows {
	
	
	private static boolean isPossible(int[] arr, int m, int mid) {
		// TODO Auto-generated method stub
		
		int cowCount = 1;
		int lastPos = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i] - lastPos >= mid) {
				cowCount++;
				
				lastPos = arr[i];
			}
			
			if(cowCount==m)
				return true;
			
			
		}
		
		return false;
	}
	
	private static int aggrassiveCows(int[] arr, int m) {
		int ans = -1;
		int lw = 0;
		int up = Integer.MIN_VALUE;
		
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) 
			up = Math.max(up, arr[i]);
		
		while(lw<=up) {
			
			int mid = lw+(up-lw)/2;
			
			if(isPossible(arr, m, mid)) {
				ans = mid;
				lw = mid+1;
			} else {
				up = mid-1;
			} 
			
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4, 2, 1, 3, 6};
		int m =2;
		
		int ans = aggrassiveCows(arr, m);
		
		System.out.println("Largest Min Distance: "+ans);
	}

	

}

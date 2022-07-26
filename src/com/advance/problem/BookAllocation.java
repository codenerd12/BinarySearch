package com.advance.problem;

public class BookAllocation {
	
	
	private static boolean isPossible(int[] arr, int m, int mid) {
		// TODO Auto-generated method stub
		int noOfStudent = 1;
		int pageSum = 0;
		
		for(int i=0;i<arr.length;i++) {
			
			//if barrier is less than the element then allocation is not possible
			if(arr[i] > mid)
				return false;
			
			if(pageSum+arr[i] <= mid) {
				
				pageSum += arr[i];
				
			} else {
				noOfStudent++;
				
				if(noOfStudent > m)
					return false;
				
				pageSum = arr[i];
			}
			
		}
		
		
		return true;
	}
	
	private static int minAllocation(int[] arr, int m) {

		int n = arr.length;
		int sum = 0;
		int ans = -1;
		
		for(int i=0;i<n;i++)
			sum+=arr[i];
		
		int lw = 0;
		int up = sum;
		
		
		while(lw<=up) {
			
			int mid = lw+(up-lw)/2;
			
			if(isPossible(arr, m, mid)) {
				ans = mid;
				up = mid-1;
			} else {
				lw = mid+1;
			}
		}
		
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 34, 67, 90};
		//int arr[] = {10, 20, 30, 40};
		int m = 2;
		
		int ans = minAllocation(arr, m);
		System.out.println("Min Allocation: "+ans);

	}

}

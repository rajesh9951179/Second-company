package com.alogirthms;


public class BinarySearch {
	
	public static void main(String[] args) {
		
		int a[]= new int[10];
		int targetValue=9;
		
		for(int i=0;i<a.length;i++)
		{
			a[i]=i;
		}
		int index=binarySearch(a,targetValue);
		if(index==-1)
		{
			System.out.println(index+"element not found");
		}
		else
		{
			System.out.println(index+"element found");
		}
	}

	private static int binarySearch(int[] a, int targetValue) {
		int low=0;
		int high=a.length-1;
		while(low<=high)
		{
			int mid=low+(high-low)/2;
			if(a[mid]==targetValue) {
				return mid;
			}
			else if(a[mid]<targetValue)
			{
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		
		}
		return -1;
	}


}

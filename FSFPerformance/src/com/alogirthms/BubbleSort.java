package com.alogirthms;

public class BubbleSort {
	
	public static void main(String[] args) {
		int a[]= {5,2,1,7,9};int temp=0;int size=a.length;
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size-1;j++)
			{
				if(a[j]>a[j+1])
				{
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		
		}
		  for (int i = 0; i < size; i++) {
	            System.out.println(a[i]);
	        }
		
	}

}

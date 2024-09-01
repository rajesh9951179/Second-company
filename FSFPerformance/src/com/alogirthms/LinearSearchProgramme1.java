package com.alogirthms;

public class LinearSearchProgramme1 {
	
	public static int  linearSearch(int a[] ,int element)
	{
		int temp=0;
		for(int i=0;i<=a.length;i++)
		{
			if(a[i]==element)
			{
				 return i;
				
			}
			
		}
		return -1;
	}
	public static void main(String[] args) {
		int a[]= {11,2,4,2,8};
		int element=4;
		int s=linearSearch(a, element);
		
		if(s!= -1)
		{
			System.out.println("it is linear search ");
		
	}
		else
		{
			System.out.println("it is not linear search");
		}
		
		
		
	}

}

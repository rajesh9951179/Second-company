package com.fsf;


public class ConstructorsProgammes11 {
	
	public ConstructorsProgammes11()
	{
		System.out.println("haii");
	}
	
	public void m1()
	{
		System.out.println("hello");
	}
	public void m1(int i, int y)
	{
		System.out.println(i+y);
	}
	
	public static void main(String[] args) {
		ConstructorsProgammes11 progammes11=new ConstructorsProgammes11();
		progammes11.m1();
		
	}

}

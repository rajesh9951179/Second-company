package com.alogirthms;

public class LinkedList {
	private class Node{
		int data;
		Node link;
		public Node(int data)
		{
			this.data=data;
			this.link=null;
		}
	}
	
	Node  head=null;
	Node tail=null;
	int size=0;
	public void addFirst(int data)
	{
		Node temp=new Node(data);
		if(head==null)
		{
			head=temp;
			tail=temp;
		}

	}

}

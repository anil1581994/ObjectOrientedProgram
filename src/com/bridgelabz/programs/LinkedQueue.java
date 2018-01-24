package com.bridgelabz.programs;

import java.util.Date;
import java.util.NoSuchElementException;



public class LinkedQueue{
		Node rear,front;
		public int size;

		private class Node{
			protected Node next;
			protected Date data;
			Node( Date data,Node next)
			{
				this.data=data;
				this.next=next;
			}
			public void setData(Date data) {
				this.data=data;
			}
			
			public Date getData() {
				return data;
			}
			public void setLinks(Node next) {
				this.next=next;
			}
			
			public Node getLinks() {
				return next;
			}
		}

		public LinkedQueue(){
			front=rear=null;
			size=0;
		}
       //maintain  txndate
		public void insert(Date data) {
			Node node = new Node(data, null);
		    if (rear == null)
		    {
		        front = rear = node;
		    }
		    else
		    {
		        rear.setLinks(node);
		        rear = rear.getLinks();
		    }
		size++ ;
		}
		public void display()
		{
			Node node=front;
			while(node!=null)
			{
				System.out.println(node.data);
			}
			System.out.println("   ");
		}
		public int getSize() {
			return size;
		}

		public Date peek()
		{
		    if (isEmpty())
			{
		        throw new NoSuchElementException("Underflow Exception");
			}
		    return front.getData();
		}

		private boolean isEmpty() {
			return (size==0);
	}
}

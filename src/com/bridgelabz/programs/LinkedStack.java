package com.bridgelabz.programs;



public class LinkedStack<T> {
Node top;

public int size;

private class Node{
	protected Node next;
	protected T data;
	Node(T data,Node next){
		this.data=data;
		this.next=next;
	}
	public void setData(T data) {
		this.data=data;
	}
	
	public T getData() {
		return data;
	}
	public void setLinks(Node next) {
		this.next=next;
	}
	
	public Node getLinks() {
		return next;
	}
}

public LinkedStack(){
	top=null;
	size=0;
}
//stcok synbol and company share
public void insert(T data) {
	Node node = new Node(data, null);
    if (top == null)
    {
    	top = node;
    }
    else
    {
    	top.setLinks(node);
        top = top.getLinks();
    }
size++ ;
}
public void display()
{
	Node node=top;
	while(node!=null)
	{
		System.out.println(node.data);
	}
	System.out.println("   ");
}
public int getSize() {
	return size;
}



public void peek()
{
    if (isEmpty())
	{
       System.out.println("Stack is empty.......");
       return;
	}
}

private boolean isEmpty() {
	return (size==0);
}
}

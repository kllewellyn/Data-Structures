package assignment2;

import java.util.Scanner;

public class main {

	
	public static void main(String[] args) {
		
		Queue ArrayListQueue = new Queue(false);
		Queue LinkedListQueue = new Queue(true);
		
		
		
		if (args.length==0) {
		      // there are no command like args
		      System.out.println("mode 1");
		      System.out.println("we will do the interactive test driver");
		    }
		    else {
		      // there are command line args
		      int pri;
		      String assocData;
		      System.out.println("mode 2");
		      System.out.print("here are the args: ");
		      int na = args.length; // our test data will make this even
		      for (int i=0; i < na; i+=2) {
		        assocData = args[i+1];
		        System.out.print(assocData+", ");
		      }
		      System.out.println();     
		    }
		
		
	}
}

interface ListInterface {

	public Object New();
	public void ins(String s, int i);
	public void remove(int i);
	public String get(int i);
	public int size();
	public boolean empty();	
}

	class Queue{

		public ListInterface queue;

		public Queue(boolean k)
		{
			if(k)
				queue = new ListLinked();
			else
				queue = new ListArray();
		}
		
		public Queue()
		{
			this(true);
		}
		
		public void New()
		{
			queue.New();
		}
		
		public int size()
		{
			return queue.size();
		}
		
		public boolean empty()
		{
			return queue.empty();
		}
		
		public String front()
		{
			return queue.get(0);
		}
		
		public void enq(String s)
		{
			queue.ins(s,queue.size());
		}
		
		public ListInterface deq()
		{
			queue.remove(0);
			return queue;
		}

	}

	class Cell {

		String val;
		Cell next = null;

		public Cell(String s) {
			val = s;
		}

		public String getVal()
		{
			return val;
		}
		
		public Cell getNext() {
			return next;
		}
	}
	
	class ListArray implements ListInterface{

		protected String[] list;
		protected int MAX = 200;
		protected int size = 0;
		
		public ListArray(){
			list = new String[MAX];
		}
		
		public ListInterface New()
		{
			return new ListArray();
		}
		
		@Override
		public void ins(String s, int i) {
			for(int p = size+1; p >= i; p--)
			{
				list[p] = list[p-1];
			}
			list[i] = s;
			size++;
		}

		@Override
		public void remove(int i) {
			for(int p = i; i < size; i++)
			{
				list[p] = list[p+1];
			}
			size--;
		}

		@Override
		public String get(int i) {
			return list[i];
		}

		@Override
		public int size() {
			return size;
		}

		@Override
		public boolean empty() {
			if(size == 0)
				return true;
			else
				return false;
		}
		
	}
	
	class ListLinked implements ListInterface{
		
		Cell head;
		Cell temp;
		int size;
		
		public ListLinked()
		{
			head = null;
			size = 0;
		}

		public ListInterface New()
		{
			return new ListLinked();
		}
		
		@Override
		public void ins(String s, int i) {
			if(head == null)
			{
				head = new Cell(s);
				size++;
			}
			else{
				Cell current = getCell(i);
				temp = current.next;
				(current.next).next = temp;
				size++;
			}
		}

		@Override
		public void remove(int i) {
			if(i == 0)
			{
				head = head.next;
				size --;
			}
			else{
				Cell current = getCell(i - 1);
				current.next = (current.next).next;
				size--;
			}
		}

		@Override
		public String get(int i) {
			
			return getCell(i).getVal();
			
		}

		@Override
		public int size() {
			return size;
		}

		@Override
		public boolean empty() {
			if(head == null)
				return true;
			else 
				return false;
		}
		
		public Cell getCell(int i)
		{
			Cell current = head;
			for(int k = 0; k < i; k++){
				current = current.next;
			}
			return current;
		}
		
	}



package main;

public class MinBinHeap implements HeapInterface {

	  // in here go all your data and methods for the heap

	int size, current, end;
	EntryPair root;
	EntryPair[] heap;
	
	  public MinBinHeap ( ) { // default constructor
	    // explicitly include this
	    // we need to have the default constructor
	    // if you then write others, this one will still be there
		  size = 0;
		  end = 1;
		  heap = new EntryPair[1000];
	  }
	  
	public MinBinHeap(EntryPair e){
		root = e;
		size = 1;
		end = 1;
		heap = new EntryPair[100];
	}

	@Override
	public void insert(EntryPair entry) {
		if(size == 0){
			heap[end] = entry;
			size++;
			end++;
		}
		else if (size > 1)
		{
			heap[end] = entry;
			size++;
			end++;
		}
		current = end;
		while((current > 1) && heap[current].getPriority() < heap[current/2].getPriority() ){
			EntryPair temp = new EntryPair();
			temp = heap[end];
			heap[end] = heap[end/2];
			heap[end/2] = temp;
			current = end/2;
			if(heap[1].getPriority() == entry.getPriority()){
				root = entry;
			}
		}
		
	}

	@Override
	public void delMin() {
		heap[1] = null;
		size--;
	}

	@Override
	public EntryPair getMin() {
		return root;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void build(EntryPair[] entries) {
		for(int i = 0; i < entries.length; i++){
			insert(entries[i]);
		}
	}
	
	public void print(){
		for(int i = 1; i <= size(); i++){
			System.out.println(heap[i].getPriority());
		}
	}
	}
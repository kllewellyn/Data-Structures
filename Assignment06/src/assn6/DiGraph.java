package assn6;
import java.util.HashMap;

public class DiGraph implements DiGraphInterface {
	
	HashMap<String, Node> diLabel;
	HashMap<Long, Node> diId;
	private long numNodes, numEdges;
	 
	  // in here go all your data and methods for the graph
	  // and the topo sort operation

	  public DiGraph ( ) { // default constructor
		 diLabel = new HashMap<String, Node>();
		 diId = new HashMap<Long, Node>();
		 numNodes = 0;
		 numEdges = 0;
	  }
	  

	@Override
	public boolean addNode(long idNum, String label) {
		
		
		return false;
	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delNode(String label) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long numNodes() {
		return numNodes;
	}

	@Override
	public long numEdges() {
		return numEdges;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] topoSort() {
		// TODO Auto-generated method stub
		return null;
	}
	  
	  // rest of your code to implement the various operations
	}
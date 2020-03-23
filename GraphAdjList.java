package oop;


import java.util.*; 

public class GraphAdjList extends Graph{

	private Map<Integer, ArrayList<Integer> > adjList = new HashMap<Integer, ArrayList<Integer> >() ;
	
	@Override
	public void implement_add_vertex() {
		// TODO Auto-generated method stub
		int v = get_vertex();
		ArrayList<Integer> neighbors = new ArrayList<Integer>() ;
		adjList.put(v, neighbors);
		
	}

	@Override
	public List<Integer> get_neighbours(int v) {
		// TODO Auto-generated method stub
		return new ArrayList<Integer>(adjList.get(v));
		
	}
			
	public List<Integer> two_hop(int v){
		ArrayList<Integer> two_hop_neigh = new ArrayList<Integer>();
		List<Integer> one_hop_neigh = get_neighbours(v);
		
		int size = one_hop_neigh.size() ;
		if(size == 0){
			return null;
		}
		
		for(int i = 0; i<size; i++){
			two_hop_neigh.addAll(get_neighbours(one_hop_neigh.get(i)));
		}
		
		return removeDuplicates(two_hop_neigh);
	

	}

	@Override
	public void implement_add_edge(int v, int w) {
		// TODO Auto-generated method stub
		(adjList.get(v)).add(w);
		
	}
	
	
	
	public <T> ArrayList<T> removeDuplicates(ArrayList<T> list){
		
		ArrayList<T> newlist = new ArrayList<T>();
		for(T element : list){
			if(! newlist.contains(element) ){
				newlist.add(element);
			}
		}
		
		
		return newlist;
		
	}
	
	


}

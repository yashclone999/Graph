package oop;

import java.util.*;

public class GraphAdjList_undirected extends Graph{
	Map<Integer, ArrayList<Integer> > adjList = new HashMap<Integer, ArrayList<Integer> >() ;
	
//	STORES CONNECTED COMPONENTS
	Map<Integer, ArrayList<Integer> > parents = new HashMap<Integer, ArrayList<Integer> >() ;
	
	
	@Override
	public void implement_add_vertex() {
		// TODO Auto-generated method stub
		int v = get_vertex();
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		adjList.put(v,  list);
		
	}

	@Override
	public void implement_add_edge(int v, int w) {
		// TODO Auto-generated method stub
		(adjList.get(v)).add(w);
		(adjList.get(w)).add(v);
	}

	@Override
	public List<Integer> get_neighbours(int v) {
		// TODO Auto-generated method stub
		ArrayList<Integer> neigh = new ArrayList<Integer>() ;
		neigh = adjList.get(v) ;
		return neigh;
	}

	
//	DFS
	class point{
		int parent;
		boolean visited;
	}
	
//	Sets the original parent
	int go_to_parent(int v, point[] arr){
		if(arr[v].parent == v){
			return v;
		}
		arr[v].parent = go_to_parent(arr[v].parent, arr);
		return arr[v].parent;
	}
	
	
	public void dfs_util(int v, point[] arr){
		arr[v].visited = true;
		for(int n: adjList.get(v)){
			if(arr[n].visited == true){
				continue;
			}
			arr[n].parent = v;
			dfs_util(n, arr);
		}
	}
	
	public void dfs(){
		int v = get_vertex();
		point[] arr = new point[v] ;
		
		
		
		for(int i = 0; i<v; i++){
			arr[i] = new point();
			arr[i].parent = i;
			arr[i].visited = false;
		}
		
		
		for(int i = 0; i<v; i++){
			if(arr[i].visited == true){
				continue;
			}
			parents.put(i, new ArrayList<Integer>());
			dfs_util(i, arr);
		}
		
		for(int i = 0; i<v; i++){
			go_to_parent(i, arr);
		}
		
//		FORM CONNECTED COMPONENTS
		for(int i = 0; i<v; i++){
			(parents.get(arr[i].parent)).add(i);
		}
	}
	
	public void connected_components(){
		
		for(int p : parents.keySet()){
			System.out.print(parents.get(p) + "\n");
		}
		return;
	}
	
}

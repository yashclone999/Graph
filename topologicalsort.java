package Ds_Algo;

import java.util.*;

public class topologicalsort {
	static ArrayList< ArrayList<Integer> > adjList = new ArrayList< ArrayList<Integer> >();
	static ArrayList<Integer> sorted = new ArrayList<Integer>();
	
	void dfs( boolean[] vs, int i){
		vs[i] = true;
		int neigh = 0;
		for(int n = 0; n< adjList.get(i).size(); n++){
			neigh = adjList.get(i).get(n);
			if( !vs[neigh] ){
				dfs(vs, neigh);
			}
		}
		sorted.add(i);
	}
	
	public ArrayList<Integer> tp_sort(){
		int v = adjList.size();
		boolean[] visited = new boolean[v];
		
		
		for(int i = 0; i<v; i++){
			if( !visited[i] ){
				dfs(visited, i);
			}
		}
		return null;
		
	}
	public static void main( String[] args){
		adjList.add(0,new ArrayList<Integer>() );
		adjList.add(1,new ArrayList<Integer>() );
		adjList.add(2,new ArrayList<Integer>( Arrays.asList(3 ) ) );
		adjList.add(3,new ArrayList<Integer>( Arrays.asList(1 ) ) );
		adjList.add(4,new ArrayList<Integer>( Arrays.asList(0,1 ) ) );
		adjList.add(5,new ArrayList<Integer>( Arrays.asList(0,2 ) ) );
		
		topologicalsort obj = new topologicalsort();
		obj.tp_sort();
		System.out.println(sorted);
	}
}

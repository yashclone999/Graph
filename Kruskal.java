package oop;

import java.util.Arrays;

//Finds MST on Kruskal graph

public class Kruskal {
	private Edge[] edges;
	private int vertices ;
	
	public Kruskal(int v, int e){
		vertices = v;
		edges = new Edge[e];
		for(int i = 0; i<e; i++){
			edges[i] = new Edge();
		}
	}
	
	private class Edge implements Comparable<Edge>{
		
		int weight, start, end ;
		@Override
		public int compareTo(Edge otherEdge){
			return this.weight - otherEdge.weight ;
		}
	}
	
	private class subset{
		int rank, parent;
	}
	
	//helper functions
	
	public int find(int x, subset[] arr){
		
		if( arr[x].parent != x){
			arr[x].parent  = find(arr[x].parent , arr);
		}
		
		return arr[x].parent ;
	}
	
	public void union(int a, int b, subset[] arr ){
		int a_root = find(a,arr);
		int b_root = find(b, arr);
		
		if(arr[a_root].rank > arr[b_root].rank){
			arr[b_root].parent = a_root;
		}
		else if(arr[a_root].rank < arr[b_root].rank){
			arr[a_root].parent = b_root;
		}
		else{
			arr[b_root].parent = a_root;
			arr[a_root].rank++ ;
		}
	}
	
	public void Kruskal_MST(){
		
		//initialize helper arrays and result array
		Edge[] result = new Edge[vertices-1];
		for(int i = 0; i< vertices-1; i++){
			result[i] = new Edge();
		}
		
		subset[] subsets = new subset[vertices];
		for(int i = 0; i< vertices; i++){
			subsets[i] = new subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		
		Arrays.sort(edges);
		
		int e = 0;//keep track of resultant edges
		int i = 0;//iterate edges
		
		while( e < vertices - 1){
			Edge ed = edges[i++];
			int a_root = find(ed.start, subsets);
			int b_root = find(ed.end, subsets);
			
			if( a_root != b_root ){
				result[e++] = ed ;
				union(a_root, b_root, subsets);
			}
		}
		
		System.out.println("Following are the edges in " + 
				"the constructed MST"); 
		for (i = 0; i < e; ++i) 
			System.out.println(result[i].start+" -- " + 
					result[i].end+" == " + result[i].weight); 
		
	}
	
	public static void main(String[] args){
		int v = 4;
		int e = 5;
		Kruskal graph = new Kruskal(v, e);
		
				// add edge 0-1 
				graph.edges[0].start = 0;
				graph.edges[0].end = 1; 
				graph.edges[0].weight = 10; 
		
				// add edge 0-2 
				graph.edges[1].start = 0; 
				graph.edges[1].end = 2; 
				graph.edges[1].weight = 6; 

				// add edge 0-3 
				graph.edges[2].start = 0; 
				graph.edges[2].end = 3; 
				graph.edges[2].weight = 5; 

				// add edge 1-3 
				graph.edges[3].start = 1; 
				graph.edges[3].end = 3; 
				graph.edges[3].weight = 15; 

				// add edge 2-3 
				graph.edges[4].start = 2; 
				graph.edges[4].end = 3; 
				graph.edges[4].weight = 4; 

				graph.Kruskal_MST(); 
				
				return ;
	}
	
	
	

}

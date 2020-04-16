package oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
	public static <T> void print_list(List<T> list){
		
		
		for(T element : list){
			System.out.print(element);
		}
	}
	public static void main( String[] args){
		
//		GraphAdjMatrix g = new GraphAdjMatrix();
//		System.out.println("number of v " + g.get_vertex());
//		g.add_vertex();
//		System.out.println("number of v " + g.get_vertex());
//		g.print_matrix();
//		
//		g.add_vertex();
//		System.out.println("number of v " + g.get_vertex());
//		g.print_matrix();
//		
//		g.add_vertex();
//		System.out.println("number of v " + g.get_vertex());
//		g.print_matrix();
		
//		
		
//		Map<Integer, ArrayList<Integer> > map  = new HashMap<Integer, ArrayList<Integer> >() ;
//		
//		
//			ArrayList<Integer> neighbors = new ArrayList<Integer>() ;
//			map.put(0, neighbors);
		
		
		
//		CONNECTED COMPONENT
		
		GraphAdjList_undirected g = new GraphAdjList_undirected();
		
		System.out.println("number of v " + g.get_vertex());
		g.add_vertex();
		g.add_vertex();
		g.add_vertex();
		g.add_vertex();
		g.add_vertex();
		g.add_vertex();
		g.add_vertex();
		g.add_vertex();
	
		g.implement_add_edge(0,1);
		g.implement_add_edge(0,2);
		g.implement_add_edge(3, 4);
		g.implement_add_edge(3,5);
		g.implement_add_edge(5,6);
		g.implement_add_edge(5,7);
		System.out.println("number of v " + g.get_vertex());
		g.dfs();
		g.connected_components();

		
		
	}
}

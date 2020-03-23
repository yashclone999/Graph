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
		
		GraphAdjList g = new GraphAdjList();
		
		System.out.println("number of v " + g.get_vertex());
		g.add_vertex();
		g.add_vertex();
		g.add_vertex();
		g.add_vertex();
	
		g.implement_add_edge(0,1);
		g.implement_add_edge(1,2);
		g.implement_add_edge(1, 3);
		
		print_list(g.two_hop(0));
		
//		Map<Integer, ArrayList<Integer> > map  = new HashMap<Integer, ArrayList<Integer> >() ;
//		
//		
//			ArrayList<Integer> neighbors = new ArrayList<Integer>() ;
//			map.put(0, neighbors);
		
		
		
	}
}

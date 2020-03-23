package oop;

import java.util.*;

public abstract class Graph {
	private int num_vertex;
	private int num_edges ;
	
	public Graph(){
		this.num_vertex = 0;
		this.num_edges = 0;
	}
	
	public int get_vertex(){
		return this.num_vertex;
	}
	
	public int get_edges(){
		return this.num_edges;
	}
	
	public void add_vertex(){
		implement_add_vertex();
		this.num_vertex ++ ;
	}
	
	public abstract void implement_add_vertex();
	public abstract void implement_add_edge(int v, int w);
	public abstract List<Integer> get_neighbours(int v);
	
}

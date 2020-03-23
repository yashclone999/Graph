package oop;

import java.util.*;

public class GraphAdjMatrix extends Graph{

	private int[][] matrix ; 
	
	@Override
	public void implement_add_vertex() {
		int v = get_vertex();
		if( v==0 ){
			matrix = new int[1][1];
			matrix[0][0] = 0;
			return;
		}
		if( v >= matrix.length ){
			
			int[][] temp = new int[v*2][v*2] ;
			
			for(int i = 0; i< matrix.length; i++){
				
				for(int j = 0; j< matrix[0].length; j++){
					
					temp[i][j] = matrix[i][j];
				}
				
				for(int j = matrix[0].length; j< temp[0].length ; j++){
					temp[i][j] = 0;
				}
				
				
			}
			matrix = temp;
		}
		
		for(int i = 0; i<matrix[0].length; i++){
			matrix[v][i] = 0;
		}
		
		return ;
		
	}
	
	public void print_matrix(){
		if( get_vertex() == 0 ){
			System.out.println("Empty");
		}
		int v = get_vertex();
		for(int i = 0; i<v ; i++){
			for(int j = 0; j<v; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println("");
		}
	}

	@Override
	public List<Integer> get_neighbours(int v) {
		// TODO Auto-generated method stub
		List<Integer> neighbors = new ArrayList<Integer>();
		for(int i = 0; i<get_vertex(); i++){
			if(matrix[v][i] != 0){
				neighbors.add(i);
			}
			
		}
		return neighbors;
	}

	@Override
	public void implement_add_edge(int v, int w) {
		// TODO Auto-generated method stub
		int ver = get_vertex();
		if(ver == 0){
			System.out.println("Empty Graph") ;
		}
		
		matrix[v][w] = 1;
		
	}
	
	public List<Integer> two_hop(int v){
		int num_v = get_vertex();
		if(num_v == 0){
			return null;
		}
		ArrayList<Integer> two_hop_neigh = new ArrayList<Integer>();
		
		for(int i = 0; i<num_v; i++){
			if(matrix[v][i] != 0){
				two_hop_neigh.addAll(get_neighbours(i));
			}
		}
		
		return removeDuplicates(two_hop_neigh);
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

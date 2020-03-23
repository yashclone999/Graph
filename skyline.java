class Solution {
   
    
    
	class processingPoint implements Comparable<processingPoint>{
		int x;
		boolean isStart;
		int h;
		
		public processingPoint( int x, boolean isStart, int h  ){
			this.x = x;
			this.isStart = isStart;
			this.h = h;
		}
		
		@Override
		public int compareTo(processingPoint o){
			if( this.x != o.x){
				return this.x - o.x ;
			}
			else{
				return (this.isStart ? -this.h : this.h) - (o.isStart ? -o.h : o.h );
			}
		}
	}
	
	
	public List<List<Integer>> getSkyline(int[][] buildings){
		processingPoint[] points = new processingPoint[(buildings.length)*2];
		int index = 0;
		for( int[] building : buildings ){
			points[index] = new processingPoint(building[0],true,building[2]);
			
			points[index+1] = new processingPoint(building[1],false,building[2]);
			
			index += 2;
			
			
		}
		Arrays.sort(points);
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(0, 1);
		int prev_height = 0;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for( processingPoint p : points){
			
			if( p.isStart ){
				
				map.compute( p.h, ( key, val ) -> {
					if(val != null){
						return val+1 ;
					}
					return 1;
				});
			}
			else{
				map.compute(p.h, (key, val) -> {
					if(val == 1){
						return null;
					}
					return val - 1;
				});
			}
			
			int current_h = map.lastKey();
			
			if( prev_height != current_h){
				List<Integer> a = new ArrayList<Integer>();
                a.add(p.x);
                a.add(current_h);
				result.add(a);
				prev_height = current_h;
			}
			
		}
		return result ;
	}

}
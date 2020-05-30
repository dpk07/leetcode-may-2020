class Solution {
  public int[][] kClosest(int[][] points, int k) {
      int count=k;
      PriorityQueue<Point> queue= new PriorityQueue<>(Collections.reverseOrder());
      for(int i=0;i<points.length;i++){
          int dist = points[i][0]*points[i][0]+points[i][1]*points[i][1];
          Point p = new Point(points[i][0],points[i][1],dist);
          if(count-->0){
              queue.add(p);
          }else{
              if(dist<queue.peek().distance){
                  queue.remove();
                  queue.add(p);
              }
          }
      }
      int[][] res = new int[k][2];
      int ctr = 0;
      while(!queue.isEmpty()){
          Point p = queue.remove();
          res[ctr][0]=p.x;
          res[ctr++][1]=p.y;
      }
      return res;
  }
}
class Point implements Comparable<Point>{
  int x;
  int y;
  int distance;
  public Point(int x,int y,int distance){
      this.x = x;
      this.y = y;
      this.distance = distance;
  }
  public int compareTo(Point b){
      return this.distance>b.distance?1:-1;
  }
}
class Solution {
  public int[][] intervalIntersection(int[][] A, int[][] B) {
      int first = 0;
      int second = 0;
      List<int[]> list = new ArrayList<int[]>();
      while(first<A.length && second<B.length){
          if(A[first][1] < B[second][0]){
              first++;
          }else if(B[second][1] < A[first][0]){
              second++;
          }else{
              if(A[first][1] >= B[second][1]){
                  int start = A[first][0]>B[second][0]?A[first][0]:B[second][0];
                  list.add(new int[]{start,B[second][1]});
                  second++;
              }else{
                  int start = A[first][0]>B[second][0]?A[first][0]:B[second][0];
                  list.add(new int[]{start,A[first][1]});
                  first++;
              }
          }
      }
      return list.toArray(new int[list.size()][2]);
  }
}
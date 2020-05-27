class Solution {
  public boolean possibleBipartition(int N, int[][] dislikes) {
      int graph[][] = new int[N][N], group[]=new int[N];
      for(int i=0;i<dislikes.length;i++){
          graph[dislikes[i][0]-1][dislikes[i][1]-1]=1;
          graph[dislikes[i][1]-1][dislikes[i][0]-1]=1;
      }
      for (int i = 0; i < N; i++) {
          if (group[i] == 0 && !dfs(graph, i, 1,group)) {
              return false;
          }
      }
      return true;
      
  }
  boolean dfs(int[][] graph,int index,int g,int[] groups){
      groups[index]=g;
      for(int i=0;i<graph[index].length;i++){
          if(graph[index][i]==1){
              if(groups[i]==g)return false;
              if(groups[i]==0 && !dfs(graph,i,-g,groups))return false;
          }
      }
      return true;
  }
}
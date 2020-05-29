class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
     List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
      int[] indegree = new int[numCourses];
      for(int i=0;i<numCourses;i++){
          list.add(new ArrayList<Integer>());
      }
      for(int i=0;i<prerequisites.length;i++){
              indegree[prerequisites[i][0]]++;
              list.get(prerequisites[i][1]).add(prerequisites[i][0]);
      }
      Queue<Integer> q = new LinkedList<Integer>();
      for(int i=0;i<numCourses;i++){
          if(indegree[i]==0)q.add(i);
      }
      while(!q.isEmpty()){
          int current = q.remove();
          for(int a:list.get(current)){
              indegree[a]--;
              if(indegree[a]==0)q.add(a);
          }
      }
      for(int i=0;i<numCourses;i++){
          if(indegree[i]>0)return false;
      }
      return true;
  }
}
//Other 
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length==0)return 1;
        int[] count = new int[N+1];
        int[] out = new int[N+1];
        for(int i=0;i<trust.length;i++){
            count[trust[i][1]] = count[trust[i][1]]+1;
            out[trust[i][0]] = out[trust[i][0]]+1;
        }
        for(int i=0;i<trust.length;i++){
            if(count[trust[i][1]]==N-1){
                if(out[trust[i][1]]==0){
                    return trust[i][1];
                }
            }
        }
        return -1;
    }
}

//Other solutions
//1) Used Hashmap gave a time of 16ms
//2) Used HashSet gave a time of 7ms
//3) Using two arrays gave the best time of 3ms
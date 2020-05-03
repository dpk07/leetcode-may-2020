class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> hs = new HashSet<Character>();
        for(char a:J.toCharArray()){
            hs.add(a);
        }
        int count=0;
        for(char a:S.toCharArray()){
            if(hs.contains(a))count++;
        }
        return count;
    }
}
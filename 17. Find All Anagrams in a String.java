class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        int[] rescount = new int[26];
        for(int j=0;j<p.length();j++){
            rescount[p.charAt(j)-'a']+=1;
        }
        int[] count = new int[26];
        int match=p.length();
        for(int i=0;i<s.length();i++){
            if(i>=p.length()){
                if(count[s.charAt(i-p.length())-'a']>0){
                    count[s.charAt(i-p.length())-'a']-=1;
                    match++;
                }
            }
            count[s.charAt(i)-'a']+=1;
            if(count[s.charAt(i)-'a']==rescount[s.charAt(i)-'a'])match--;
            if(match==0){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}


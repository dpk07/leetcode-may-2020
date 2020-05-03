class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.equals(magazine))return true;
        if (ransomNote.length()>magazine.length()) return false;
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(int i=0;i<magazine.length();i++){
            if(hm.containsKey(magazine.charAt(i))){
                int count = hm.get(magazine.charAt(i));
                hm.put(magazine.charAt(i),count+1);
            }else{
                hm.put(magazine.charAt(i),1);
            }
        }
        for(int i=0;i<ransomNote.length();i++){
            if(hm.containsKey(ransomNote.charAt(i))){
                int count = hm.get(ransomNote.charAt(i));
                if(count<=0)return false;
                hm.put(ransomNote.charAt(i),count-1);
            }else{
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        char[] binArray = binary.toCharArray();
        for(int i=0;i<binArray.length;i++){
            if(binArray[i]=='1'){
                binArray[i]='0';
            }else{
                binArray[i]='1';
            }
        }
        binary = new String(binArray);
        return Integer.parseInt(binary,2);
    }
}
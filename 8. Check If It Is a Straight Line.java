class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length==2)return true;
        float slope = (float)(coordinates[1][1]-coordinates[0][1])/(coordinates[1][0]-coordinates[0][0]);
        for(int i=2;i<coordinates.length;i++){
            float ansslope = (float)(coordinates[i][1]-coordinates[i-1][1])
                                /(coordinates[i][0]-coordinates[i-1][0]);
            if(slope!=ansslope){
                return false;
            }
           }
        return true;
    }
}
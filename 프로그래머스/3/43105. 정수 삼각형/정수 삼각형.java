import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int length = triangle.length;
        
        if(length == 1) return triangle[0][0];
        
        for(int i = length - 2; i >= 0; i--) {
            for(int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = Math.max(triangle[i+1][j] + triangle[i][j], triangle[i+1][j+1] + triangle[i][j]);
            }
        }
        
        return triangle[0][0];
    }
}
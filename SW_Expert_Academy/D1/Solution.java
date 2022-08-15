package D1;

public class Solution {
    
    public int solution(int[] tasks) {
        int answer = -1;
        int cnt = 0;
        int min;

        int[] taskSet = new int[tasks.length];

        for(int i=0;i<tasks.length;i++){
            taskSet[tasks[i]]++;
        }

        for(int i=0;i<taskSet.length;i++){
            if(taskSet[i]==0) continue;
            if(taskSet[i]==1) 
                return answer;
            
            min = taskSet[i]/3;
            
            if(taskSet[i]%3 != 0)
                min++;
            
            cnt += min;
            
        }

        return cnt;
    
    }
}

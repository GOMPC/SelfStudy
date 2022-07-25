package Week2;

import java.io.*;

public class ArrayEx1 {

    public static void main(String[] args) throws IOException {
        
        int[] intArr = {1,2,3,4,5,1,2,3,4,5};
        // inputNumber를 찾아라. 있으면 해당 값의 위치를 리턴, 없으면 -1
        // 두개 있으면 한개 두개 다 뽑아

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputN = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i=0;i<intArr.length;i++){
            if(inputN == intArr[i]) {
                cnt++;
                System.out.println("같은 숫자는 " + i + "번째 인덱스에 있습니다.");
            }
        }

        if(cnt == 0) System.out.println("같은 숫자가 없습니다."); 

        //마지막 인덱스만 찾는 경우, cnt>2로 또 한바퀴 돌아야 할까? 
        //아니지 lastIndex로 하나 잡고 lastIndex = i 그것만 뽑아도 될듯 ㅅㅅ 난 천재야
        //몇번째 인덱스를 찾아보려면 cnt=n 해서 n번째 인덱스 ㄱ

    }
    
}

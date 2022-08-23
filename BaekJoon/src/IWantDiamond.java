import java.io.*;

public class IWantDiamond {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int maxnum = 0;
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>maxnum) maxnum = arr[i];
		}
		
		boolean[] prime = new boolean[maxnum+1];
		
		prime[0] = prime[1] = true;
		
		for(int i=2; i*i<=prime.length;i++) {
			if(!prime[i]) {
				for(int j = i*i;j<prime.length;j+=i) {
					prime[j] = true;
				}
			}
		}
		
		int cnt = 0;
		
		for(int i=0;i<n;i++) {
			
			for(int min = arr[i]/2, max = arr[i]/2; min>0; min--, max++) {
				if(!prime[min] && !prime[max]) cnt++;
			}
			
			bw.write(String.valueOf(cnt));
			bw.newLine();
			cnt = 0;
		}
		bw.close();

		
	}

}
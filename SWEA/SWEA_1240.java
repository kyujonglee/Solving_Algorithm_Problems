import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1240 {
	
	static int N;
	static int M;
	static StringTokenizer st;
	static char[][] arr;
	static int[] answer;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] code = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
		
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1;t<=testCase;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			for(int i=0;i<N;i++) {
				String sen = br.readLine();
				for(int j=0;j<M;j++) {
					arr[i][j] = sen.charAt(j);
				}
			}
			answer = new int[8];
			int endX = 0;
			int endY = 0;
			outer:
			for(int i=N-1;i>=0;i--) {
				for(int j=M-1;j>=0;j--) {
					if(arr[i][j]=='1') {
						endX = i;endY = j;
						break outer;
					}
				}
			}
			int count = 0;
			int idx = 0;
			String temp = "";
			for(int j=endY-55;j<=endY;j++) {
				count++;
				temp += arr[endX][j];
				if(count==7) {
					count = 0;
					for(int k=0;k<10;k++) {
						if(temp.equals(code[k])) {
							answer[idx++] = k;temp="";
						}
					}
				}
			}
			int oddSum = 0,evenSum=0;
			for(int i=0;i<answer.length-1;i++) {
				if((i+1)%2==0) {
					evenSum += answer[i];
				}
				else {
					oddSum += answer[i];
				}
			}
			boolean flag = false;
			int sum = oddSum*3+evenSum+answer[answer.length-1];
			if(sum%10==0)flag=true;
			int ans = flag?oddSum+evenSum+answer[answer.length-1]:0;
			System.out.println("#"+t+" "+ans);
		}
	}
}

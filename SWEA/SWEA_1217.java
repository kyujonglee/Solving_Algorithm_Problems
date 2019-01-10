import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1217 {
	
	public static int multi(int a,int n) {
		if(n==0 || a==1)
			return 1;
		else {
			int y = multi(a,n/2);;
			if(n%2==0) {
				return y*y;
			}
			else {
				return a*y*y;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t,i,num,a,n;
		int[] test = new int[10];
		
		for(t=0;t<10;t++) {
			num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			test[t] = multi(a,n);
		}
		for(t=1;t<=10;t++) {
			System.out.println("#" + t + " "+test[t-1]);
		}
	}
}

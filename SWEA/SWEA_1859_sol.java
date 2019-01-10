import java.util.Scanner;
// 배울 점:뒤에서부터 생각해볼 것!!
// 굉장히 자주 쓰이는 아이디어다!!!!!!!!!!
public class SWEA_1859_sol{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();		
		for(int T=1;T<=Tc;T++){
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			long ans = 0;
			int value = arr[n-1];
			for(int i = n-2;i>=0;i--){
				if(value > arr[i]) ans+=(value-arr[i]);
				else{
				value = arr[i];
				}
			}
			System.out.println("#"+T+" "+ans);
		}
	}
}
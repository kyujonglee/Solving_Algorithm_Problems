import java.util.Scanner;
// 난이도 : D2
// 제출 횟수 : 4번
// 얻어가는 것 : 자료형 타입, Recursion 주의할 것!

public class SWEA_1859 {
	
	static long num = 0;
	
	public static void Recursion(long[] vec,int n){
		long max = 0;
		int index = 0;
		for(int i=n;i<vec.length;i++){
			if(vec[i]>max) max = vec[i];
		}
		for(int i=n;i<vec.length;i++){
			if(vec[i]==max) index = i;
		}
		
		if(index==n){
			if(vec.length-1>index+1){
				Recursion(vec,index+1);
			}
		}
		else{
			long sum = 0;
			for(int i=n;i<index;i++){
				sum += vec[i];
			}
			num += vec[index]*(index-n) - sum;
			if(vec.length-1>index+1){
				Recursion(vec,index+1);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		long[] arr = new long[count];
		for(int i=0;i<count;i++){
			int l = s.nextInt();
			long[] vec = new long[l];
			for(int j=0;j<l;j++){
				vec[j] = s.nextInt();
			}
			Recursion(vec,0);
			arr[i] = num;
			num = 0;
		}
		for(int i=0;i<count;i++){
			System.out.println("#"+(i+1)+" "+arr[i]);
		}
		
		s.close();
	}
}

import java.util.Scanner;
// ���̵� : D2
// ���� Ƚ�� : 4��
// ���� �� : �ڷ��� Ÿ��, Recursion ������ ��!

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

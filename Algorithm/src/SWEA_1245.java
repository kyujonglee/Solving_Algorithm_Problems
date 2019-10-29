import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1245 {
	static int length;
	static String[] arr;
	static double[] x;
	static double[] m;
	static StringTokenizer st;
	static double[] result;
	
	public static void swap(int i,int j) {
		double temp;
		temp = x[j];
		x[j] = x[i];
		x[i] = temp;
		temp = m[j];
		m[j] = m[i];
		m[i] = temp;
	}
	
	public static void quickSort(int first,int end) {
		if(first<end) {
			int i = first;
			int pivot = first;
			int j = end;
			
			while(i<j) {
				while(x[i]<=x[pivot] && i<end) {
					i++;
				}
				while(x[j]>x[pivot]) {
					j--;
				}
				if(i<j) {
					swap(i,j);
				}
			}
			swap(j,pivot);
			quickSort(first,j-1);
			quickSort(j+1,end);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1;t<=testCase;t++) {
			length = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			x = new double[length];
			m = new double[length];
			result = new double[length-1];
			for(int i=0;i<length;i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<length;i++) {
				m[i] = Integer.parseInt(st.nextToken());
			}
			// 자성체로부터 물체에 작용하는 인력을 구하는 공식: F = G*m1*m2/(d*d), G는 양의 상수 값, G=1,m1=1로 봐도 무방
			// x좌표를 정렬 자성체가 N개이면 N-1개의 균형점이 생긴다.
			quickSort(0,length-1);
			double error = 1e-12;
			for(int i=0;i<length-1;i++) {
				double first = x[i];
				double end = x[i+1];
				double temp = 0;
				double Sum = 0.0;
				do {
					Sum = 0.0;
					temp = (first + end)/2.0;
					for(int j=0;j<=i;j++) {
						Sum += m[j]/((temp-x[j])*(temp-x[j]));
					}
					for(int j=i+1;j<length;j++) {
						Sum -= m[j]/((temp-x[j])*(temp-x[j]));
					}
					if(Sum < 0.0) {
						end = temp;
					}
					else {
						first = temp;
					}
			}while(Math.abs(first-end)>error && first<end);
				result[i] = temp;
			}
			System.out.print("#"+t+" ");
			for(int i=0;i<result.length;i++) {
				System.out.printf("%.10f ",result[i]);
			}
			System.out.println();
		}
	}
}

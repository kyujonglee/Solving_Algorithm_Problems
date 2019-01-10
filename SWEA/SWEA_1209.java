import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
//import java.util.Queue;
//import java.util.LinkedList;

public class SWEA_1209 {
	
	public static int find_max(int[] arr) {
		int max = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) max = arr[i];
		}
		return max;
	}
	
	public static int check_max(int[][] mat) {
		int i,j;
//		Queue<Integer> queue = new LinkedList<Integer>();
		int[] arr = new int[202];
		int sum = 0;
		
		for(i=0;i<100;i++) {
			sum = 0;
			for(j=0;j<100;j++) {
				sum += mat[i][j];
			}
//			queue.add(sum);
			arr[i] = sum;
			
		}
		
		for(j=0;j<100;j++) {
			sum = 0;
			for(i=0;i<100;i++) {
				sum += mat[i][j];
			}
//			queue.add(sum);
			arr[j+100] = sum;
		}
		
		sum = 0;
		for(i=0;i<100;i++) {
			sum += mat[i][i];
		}
		arr[200] = sum;
		
		sum = 0;
		for(i=0;i<100;i++) {
			sum += mat[i][99-i];
		}
		arr[201] = sum;
		
		return find_max(arr);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i,j;
		
		int[] test = new int[10];
		for(int t=0;t<10;t++) {
			int count = Integer.parseInt(br.readLine());
			int[][] mat = new int[100][100];
			for(i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(j=0;j<100;j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			test[t] = check_max(mat);
		}
		for(i=0;i<10;i++) {
			System.out.println("#"+(i+1)+" "+test[i]);
		}
	}
}

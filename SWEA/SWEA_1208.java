import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA_1208 {
	
	public static int find_max(int[] arr) {
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) max=arr[i];
		}
		return max;
	}
	
	public static int find_min(int[] arr) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) min=arr[i];
		}
		return min;
	}
	
	public static int dump(int[] arr) {
		int max = find_max(arr);
		int min = find_min(arr);
		int max_index=0;
		int min_index=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==max) {max_index=i;}
			if(arr[i]==min) {min_index=i;}
		}
		if(max-min>=2) {
			arr[max_index]-=1;
			arr[min_index]+=1;
			return find_max(arr)-find_min(arr);
		}else if(max-min==1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test[] = new int[10];
		for(int t=0;t<10;t++) {
				
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int arr[] = new int[100];
			for(int i=0;i<100;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int check = -1;
			
			for (int i=1;i<=num;i++) {
				if(check==1 || check==0) {
					break;
				}
				check=dump(arr);
			}
			test[t] = check;
		}
		for(int i=0;i<10;i++){
			System.out.println("#"+(i+1)+" "+test[i]);
		}
		
	}
}

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1206 {
	
	public static int check(int[] arr,int index) {
		int max = 0;
		int i;
		for (i=index-2;i<=index+2;i++) {
			if(arr[i]>max && i!=index)
				max = arr[i];
		}
		if(max<arr[index]) {
			return arr[index]-max;
		}else {
			return 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
		int count=0;
		int[] test = new int[10];
		for(int t=0;t<10;t++) {
			int num = Integer.parseInt(br.readLine());
			int arr[] = new int[num];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(i=0;i<num;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(i=2;i<num-2;i++) {
				count += check(arr,i);
			}
			test[t] = count;
			count = 0;
		}
		for(i=0;i<10;i++){
			System.out.println("#"+(i+1)+" "+test[i]);
		}
	}
}

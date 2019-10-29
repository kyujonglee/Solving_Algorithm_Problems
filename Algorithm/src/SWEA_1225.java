import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1225 {
	public static boolean check(int[] arr) {
		boolean flag = false;
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i]==0) {flag=true;break;}
		}
		return flag;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t,i,j,num,temp;
		int[] arr;
		StringTokenizer st;
		
		for(t=0;t<10;t++) {
			num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[8];
			for(i=0;i<8;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			while(!check(arr)) {
				for(j=0;j<5;j++) {
					if(arr[7]==0) {
						break;
					}
					else {
						temp = arr[0]-(j+1)<0?0:arr[0]-(j+1);
					}
					for(i=0;i<arr.length-1;i++) {
						arr[i] = arr[i+1];
					}
					arr[arr.length-1] = temp;
				}
			}
			System.out.print("#"+(t+1)+" ");
			for(i=0;i<8;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
}

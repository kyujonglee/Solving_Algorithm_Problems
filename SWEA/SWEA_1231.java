import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1231 {
	
	public static void recursion(char[] arr,int index) {
		if(index<arr.length && arr[index]!=0) {
			recursion(arr,index*2);
			System.out.print(arr[index]);
			recursion(arr,index*2+1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len,index;
		char[] arr;char content;
		StringTokenizer st;
		String sen;
		for(int t=0;t<10;t++) {
			len = Integer.parseInt(br.readLine());
			arr = new char[len+1];
			for(int i=0;i<len;i++) {
				st = new StringTokenizer(br.readLine());
				index = Integer.parseInt(st.nextToken());
				content = st.nextToken().charAt(0);
				arr[index] = content;
			}
			System.out.print("#"+(t+1)+" ");
			recursion(arr,1);
			System.out.println();
		}
	}
}

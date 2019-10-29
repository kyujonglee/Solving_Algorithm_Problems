import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233 {
	
	static boolean flag = true;
	
//	public static void check(char arr[]) {
//		int l = arr.length;
//		for(int i=1;i<l;i++) {
//			if(i*2<=l) {
//				if(arr[i]=='*' || arr[i]=='/' || arr[i]=='+' || arr[i]=='-') {}
//				else flag = false;
//			}
//			else {
//				if(arr[i]=='*' || arr[i]=='/' || arr[i]=='+' || arr[i]=='-')flag=false;
//			}
//		}
//	}
	public static boolean checkString(String a) {
		if(a.equals("+") || a.equals("-") || a.equals("/") || a.equals("*")) return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sen;
		int length,index;
		int answer;
		char content;
		StringTokenizer st;
		for(int t=0;t<10;t++) {
			length = Integer.parseInt(br.readLine());
			flag = true;
			for(int i=0;i<length;i++) {
				st = new StringTokenizer(br.readLine());
				if(st.countTokens()==2) {
					st.nextToken();
					if(checkString(st.nextToken()))flag=false;
				}
			}
//			check(arr);
			answer = flag? 1:0;
			System.out.println("#"+(t+1)+" "+answer);
		}
	}
}

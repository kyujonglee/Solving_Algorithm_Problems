import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t,i;
		int[] test = new int[10];
		Stack st = new Stack();
		int length;
		String s;
		char[] array;
		boolean flag = true;
		
		for(t=0;t<10;t++) {
			length = Integer.parseInt(br.readLine());
			array = new char[length];
			s = br.readLine();
			array = s.toCharArray();
			
			flag=true;
			for(i=0;i<length;i++) {
				if(array[i]=='{' || array[i]=='[' || array[i]=='<' || array[i]=='(') st.push(array[i]);
				else {
					char temp = (char)st.pop();
					if(array[i]=='}') {
						if(temp!='{') {flag=false;break;}
					}else if(array[i]==']') {
						if(temp!='[') {flag=false;break;}
					}else if(array[i]=='>') {
						if(temp!='<') {flag=false;break;}
					}else {
						if(temp!='(') {flag=false;break;}
					}
				}
			}
			if(flag) {
				test[t] = 1;
			}else {
				test[t] = 0;
			}
		}
		for(t=0;t<10;t++) {
			System.out.println("#"+ (t+1)+ " " + test[t]);
		}
	}
}

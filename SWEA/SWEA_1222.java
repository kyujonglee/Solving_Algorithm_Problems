import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//http://jslowmove.blogspot.com/2011/06/1_06.html
//중위->후위 참고 코드

public class SWEA_1222 {
	
	public static boolean isOperator(char a) {
		return a=='+'? true:false;
	}
	public static boolean isNumeric(char a) {
		int b = a - '0';
		return b<=9 && b>=0 ? true:false;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack stk;
		int t,i,length,index;
		String org_exp,postfix;
		char temp;
		char sb[];
		int[] test = new int[10];
		
		for(t=0;t<10;t++) {
			//input 받기
			length = Integer.parseInt(br.readLine());
			org_exp = br.readLine();
			stk = new Stack();
			index = 0;
			sb = new char[length];
			
			// 중위표기법 -> 후위표기법
			for(i=0;i<length;i++) {
				temp = org_exp.charAt(i);
				if(isOperator(temp)) {
					stk.push(temp);
				}
				else if(isNumeric(temp)){
					sb[index++] = temp;
					while(!stk.empty()) {
						sb[index++] = (char)stk.pop();
					}
				}
			}
			// 후위표기법 계산
			for(i=0;i<length;i++) {
				if(isNumeric(sb[i])) {
					stk.push(sb[i]-'0');
				}
				else if(sb[i]=='+') {
					stk.push((Integer)stk.pop() + (Integer)stk.pop());
				}	
			}
			test[t] = (int)stk.pop();
		}
		for(t=0;t<10;t++) {
			System.out.println("#"+(t+1)+" "+test[t]);
		}
	}
}

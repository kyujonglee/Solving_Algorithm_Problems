import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1223 {
	
	public static boolean isNumeric(char a) {
		return a>='0' && a<='9';
	}
	public static boolean isOperator(char a) {
		return a=='+' || a=='*';
	}
	public static int operatorPriority(char a) {
		if(a=='+') return 1;
		if(a=='*') return 2;
		return 3;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack stk;
		int t,i,length,index;
		String org_exp;
		char temp;
		char sb[];
		int[] test = new int[10];
		
		for(t=0;t<10;t++) {
			length = Integer.parseInt(br.readLine());
			org_exp = br.readLine();
			stk = new Stack();
			sb = new char[length];
			index = 0;
			// 중위표기법 -> 후기표기법
			for(i=0;i<length;i++) {
				temp = org_exp.charAt(i);
				if(isNumeric(temp)) {
					sb[index++] = temp;
				}
				else if(isOperator(temp)) {
					while(!stk.isEmpty() && operatorPriority((Character)stk.peek())>=operatorPriority(temp)) {
						sb[index++] = (Character)stk.pop();
					}
					stk.push(temp);
				}
			}
			while(!stk.isEmpty()) {
				sb[index++] = (Character)stk.pop();
			}
		
			
			for(i=0;i<length;i++) {
				if(isNumeric(sb[i])) {
					stk.push(sb[i]-'0');
				}
				else if(isOperator(sb[i])) {
					if(sb[i]=='+') {stk.push((Integer)stk.pop() + (Integer)stk.pop());}
					else if(sb[i]=='*') {stk.push((Integer)stk.pop()*(Integer)stk.pop());}
				}
			}
			test[t] =(Integer)stk.pop();
			
		}
		for(t=0;t<10;t++) {
			System.out.println("#"+(t+1)+" "+test[t]);
		}
	}
}

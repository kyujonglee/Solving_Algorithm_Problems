import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1232 {
	
	static int N = 0;
	static String[] arr;
	static StringTokenizer st;
	static Stack<Integer> stk;
	static LinkedList<String> list;
	static int[][] tree;
	
	// 트리를 탐색하는 법이 잘못되었음!!
	public static void postOrder(int ind) {
		if(arr[ind]==null)return;
		postOrder(tree[ind][0]);
		postOrder(tree[ind][1]);
		list.offer(arr[ind]);
	}
	
	public static void cal() {
		int pre = 0;
		while(!list.isEmpty()) {
			String temp = list.poll();
			switch(temp) {
			case "+":
				stk.push(stk.pop()+stk.pop());
				break;
			case "*":
				stk.push(stk.pop()*stk.pop());
				break;
			case "-":
				pre = stk.pop();
				stk.push(stk.pop()-pre);
				break;
			case "/":
				pre = stk.pop();
				stk.push(stk.pop()/pre);
				break;
			default:
				stk.push(Integer.parseInt(temp));
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0;t<10;t++) {
			N = Integer.parseInt(br.readLine());
			arr = new String[N+1]; // 배열 생성
			tree = new int[N+1][2];
			String sen;
			for(int i=0;i<N;i++) { // 트리 만들기(입력값 받기)
				st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				sen = st.nextToken();
				arr[index] = sen;
				
				int j=0;
				while(st.hasMoreTokens()) {
					int ind = Integer.parseInt(st.nextToken());
					tree[index][j++] = ind; 
				}
			}
//			System.out.println(Arrays.toString(arr));
			
			list = new LinkedList<>();
			stk = new Stack<>();
			postOrder(1);
//			for(int i=0;i<N;i++) {
//				System.out.print(list.get(i)+" ");
//			}
			
			cal();
			System.out.println("#"+(t+1)+" "+stk.pop());
		}
	}
}
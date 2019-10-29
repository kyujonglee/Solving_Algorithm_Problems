import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1219 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t,i,x,y,v,w;
		int num;
		int length;
		int[] test = new int[10];
		int[] array;
		int[] array1;
		boolean[] visited;
		Stack stk;
		int temp;boolean flag=true;
		StringTokenizer st,st1;
		
		for(t=0;t<10;t++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			length = Integer.parseInt(st.nextToken());
			array = new int[100];
			array1 = new int[100];
			stk = new Stack();
			visited = new boolean[100];
			
			st1 = new StringTokenizer(br.readLine());
			
			for(i=0;i<length;i++) {
				x = Integer.parseInt(st1.nextToken());
				y = Integer.parseInt(st1.nextToken());
				if(array[x]==0) {
					array[x] = y;
				}
				else {
					array1[x] = y;
				}
			}
			//DFS 알고리즘 확실히 이해할 것(+백트래킹 추가)
			v = 0;flag=false;
			visited[0] = true;
			do {
				if(visited[array[v]]!=true || visited[array1[v]]!=true) {
					w = (visited[array[v]]!=true ? array[v] : array1[v]);
					stk.push(v);
				}else {
					w = -1;
				}
				while(w!=-1) {
					visited[w] = true;
					stk.push(w);
					v = w;
					if(visited[array[v]]!=true || visited[array1[v]]!=true) {
						w = (visited[array[v]]!=true ? array[v] : array1[v]);
						stk.push(v);
					}else {
						w = -1;
					}
				}
				v = (int)stk.pop();
				if(v==99)flag=true;
			}while(v!=0);
			test[t] = (flag ? 1:0);
		}
		for(t=0;t<10;t++) {
			System.out.println("#"+(t+1)+" "+test[t]);
		}
	}
}

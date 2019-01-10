import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {
	
	static StringTokenizer st;
	static int length,start;
	static int[][] arr;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			st = new StringTokenizer(br.readLine());
			length = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[101][101];
			visited = new boolean[101];
			int idx = 0;
			int content = 0;
			for(int i=0;i<length/2;i++) {
				idx = Integer.parseInt(st.nextToken());
				content = Integer.parseInt(st.nextToken());
				arr[idx][content] = 1;
			}
			int v=0;
			int count = 1;
			visited[start] = true;
			v = start;
			q.offer(v);
			int max = 0;
			while(!q.isEmpty()) {
				int qSize = q.size();
				max = 0;
				for(int i=0;i<qSize;i++) {
					v = q.poll();
					if(max<v)max=v;
					for(int j=1;j<101;j++) {
						if(visited[j]==false && arr[v][j]==1) {
							q.offer(j);
							visited[j] = true;
						}
					}
				}
			}
			System.out.println("#"+t+" "+max);
		}
		
	}
}

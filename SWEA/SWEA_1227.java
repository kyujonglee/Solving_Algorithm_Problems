import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1227 {
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int size = 100;
	static int[][] arr = new int[size][size];
	static boolean[][] visited = new boolean[size][size];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// poll : pop, offer : push
		int t,i,j,num,success=0;
		int startX=1,startY=1;
		int nextX,nextY;
		String sen;
		Queue<Dot> q;
		Dot d;
		int[] test = new int[10];
	
		for(t=0;t<10;t++) {
			success = 0;
			q = new LinkedList<Dot>();
			// 값 받기
			num = Integer.parseInt(br.readLine());
			for(i=0;i<size;i++) {
				sen = br.readLine();
				for(j=0;j<size;j++) {
					arr[i][j] = sen.charAt(j)-'0';
					visited[i][j] = false;
					// 시작점과 끝나는 점 찾기
					if(arr[i][j]==2) {
						startX = i;startX = j;
					}
				}
			}
			visited[startX][startX] = true;
			q.offer(new Dot(startX,startY));
			while(!q.isEmpty()) {
				d = q.poll();
				for(i=0;i<4;i++) {
					nextX = d.x+dx[i];
					nextY = d.y+dy[i];
					if(nextX<0 || nextY<0 || nextX>=size || nextY>=size)continue;
					if(arr[nextX][nextY]==1 || visited[nextX][nextY])continue;
					if(arr[nextX][nextY]==3) {
						success=1;break;
					}
					q.offer(new Dot(nextX,nextY));
					visited[nextX][nextY] = true;
				}
				
			}
			test[t] = success;
		}
		for(t=0;t<10;t++) {
			System.out.println("#"+(t+1)+" "+test[t]);
		}
		br.close();
	}
}

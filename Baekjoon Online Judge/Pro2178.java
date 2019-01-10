import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pro2178 {
	
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// poll : pop, offer : push
		int t,i,j,success=0;
		int startX=0,startY=0;
		int nextX,nextY;
		String sen;
		Queue<Dot> q = new LinkedList<Dot>();;
		Dot d;
        
        // 값 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(i=0;i<N;i++) {
            sen = br.readLine();
            for(j=0;j<M;j++) {
                arr[i][j] = sen.charAt(j)-'0';
                visited[i][j] = false;
                // 시작점과 끝나는 점 찾기
            }
        }
        visited[startX][startX] = true;
        q.offer(new Dot(startX,startY));
        while(!q.isEmpty()) {
            d = q.poll();
            for(i=0;i<4;i++) {
                nextX = d.x+dx[i];
                nextY = d.y+dy[i];
                if(nextX<0 || nextY<0 || nextX>=N || nextY>=M)continue;
                if(arr[nextX][nextY]==0 || visited[nextX][nextY])continue;
                
                q.offer(new Dot(nextX,nextY));
                arr[nextX][nextY] = arr[d.x][d.y] + 1;
                visited[nextX][nextY] = true;
            }
        }
        System.out.println(arr[N-1][M-1]);
        	
		br.close();
	}
}
class Dot{
	int x,y;
	Dot(int x,int y){
		this.x = x;
		this.y = y;
	}
}

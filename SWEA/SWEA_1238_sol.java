import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SWEA_1238_sol {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tempStr;
        StringTokenizer st;
        int T, start, R, C, answer = 0, number= 0;
        while((tempStr = br.readLine()) != null) {
            Queue<Integer> q = new LinkedList<>();
            int[][] network = new int[101][101];
            boolean[] isChecked = new boolean[101];
            number++;
            st = new StringTokenizer(tempStr, " ");
            T = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
             
            tempStr = br.readLine();
            st = new StringTokenizer(tempStr, " ");
            for(int i= 0; i< T/2;i++) {
                R = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());
                 
                network[R][C] = 1;//이동가능한곳으로 표시
                if(R == start) {//시작점과 동일할때
                    isChecked[R] = true;//시작점은 방문했다고 표시
                    q.offer(C);//도착지를 큐에 넣음
                }
            }
            while(!q.isEmpty()) {//큐가 비어있을때까지 반복
                int qSize = q.size();//가야할 도착지들의 갯수파악
                answer = 0;//초기화
                for(int i= 0 ; i< qSize; i++) {//가야할 도착지들 개수만큼 반복
                    int tempR = q.poll();//도착지를 임시저장
                    answer = Math.max(answer, tempR);//도착지중 가장 큰 수 파악
                    for(int j = 1;j<101;j++) {//갈수있는 길 조사
                        if(network[tempR][j] == 1 && isChecked[j] == false) {//방문하지않았고 갈수있는 곳일경우
                            isChecked[j] = true;//방문했다고 표시
                            q.offer(j);//도착지를 큐에 삽입
                        }
                    }
                }
            }
            System.out.println("#"+number+ " "+answer);//답안 출력
        }
    }
}
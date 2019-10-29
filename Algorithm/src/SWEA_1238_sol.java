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
                 
                network[R][C] = 1;
                if(R == start) {
                    isChecked[R] = true;
                    q.offer(C);
                }
            }
            while(!q.isEmpty()) {
                int qSize = q.size();
                answer = 0;
                for(int i= 0 ; i< qSize; i++) {
                    int tempR = q.poll();
                    answer = Math.max(answer, tempR);
                    for(int j = 1;j<101;j++) {
                        if(network[tempR][j] == 1 && isChecked[j] == false) {
                            isChecked[j] = true;
                            q.offer(j);
                        }
                    }
                }
            }
            System.out.println("#"+number+ " "+answer);
        }
    }
}
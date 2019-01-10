import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class SWEA_1216_sol {
 
    private static int Max;
 
    public static void check_Max(char[][] arr, int N) {
        int i, j, k, p, q;
 
        for (i = 0; i < 100; i++) {  // 가로, 세로 100번씩 진행.
             
            for(p=0;p<101-N;p++) {
                for(j=0;j<(N/2);j++) 
                    if(arr[i][j+p]!=arr[i][N-1-j+p]) break;
                if(j==(N/2)) {
                    Max = N;
                    return;
                }
            }
            for(q=0;q<101-N;q++) {
                for(k=0;k<(N/2);k++)
                    if(arr[k+q][i] != arr[N-1-k+q][i]) break;           
                if(k==(N/2)) {
                    Max = N;
                    return;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            Max = 0;
            Integer.parseInt(br.readLine());
            char[][] arr = new char[100][100];
            // 배열에 넣기!! (신박한 방법)
            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                arr[i] = str.toCharArray();
            }
            for(int i=100;i>=1;i--) {
                if(Max!=0) break;
                check_Max(arr,i);
            }
            System.out.printf("#%d %d\n", tc, Max);
        }
    }
}
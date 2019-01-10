import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_1209_sol{
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        int tn=10;
        for(int i=1;i<=tn;i++) {
            int t=Integer.parseInt(br.readLine());
            int[][] matrix=new int[100][100];
            int result=0;
             
            for(int j=0;j<100;j++) {
                st=new StringTokenizer(br.readLine());
                for(int k=0;k<100;k++) {
                    matrix[j][k]=Integer.parseInt(st.nextToken());
                }
            }
             
            result=calMax(matrix);
             
            System.out.println("#"+t+" "+result);
        }
    }
    public static int calMax(int[][]input) {
        int[][] matrix=input;
        int max=0;
        int[] diagonalSum=new int[2];
        for(int i=0;i<100;i++) {
            int[] sum=new int[2];
            for(int j=0;j<100;j++) {
                sum[0]+=matrix[i][j];
                sum[1]+=matrix[j][i];
            }
            if(max<=(int)Math.max(sum[0], sum[1]))max=(int)Math.max(sum[0], sum[1]);
            sum=new int[] {0,0};
            diagonalSum[0]+=matrix[i][i];
            diagonalSum[1]+=matrix[i][99-i];
        }
         
        if(max<=(int)Math.max(diagonalSum[0], diagonalSum[1]))max=(int)Math.max(diagonalSum[0], diagonalSum[1]);
 
        return max;
    }
}
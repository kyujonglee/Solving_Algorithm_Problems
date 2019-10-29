import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class SWEA_1228_sol {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
 
        for (int z = 1; z <= T; z++) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            ArrayList<String> lst = new ArrayList<String>(N);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                lst.add(st.nextToken());
            }
             
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String ins = st.nextToken();
                int idx = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                for(int i=0; i<num; i++) {
                    lst.add(idx++, st.nextToken());
                }
            }
            sb.append("#"+z+" ");
            for(int i=0; i<10; i++) {
                sb.append(lst.get(i) +" ");
            }
            System.out.println(sb);
        }
    }
}
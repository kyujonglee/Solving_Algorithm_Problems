import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class SWEA_1204_sol{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= 10; t++) {
            int test = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int arr[] = new int[101];
 
            while (st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[tmp]++;
            }
            int max = 0;
            for (int data : arr)
                if (data >= max)
                    max = data;
 
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= 100; i++)
                if (arr[i] == max)
                    stack.add(i);
 
            System.out.print("#" + t + " ");
            System.out.print(stack.pop() + "\n");
        }
    }
}
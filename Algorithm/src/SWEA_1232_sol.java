import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class SWEA_1232_sol {
    static int N;
    static int tree[][];
    static String node[];
    static LinkedList<String> list;
    static Stack<Integer> stack;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for(int t=1; t<=10; t++) {
            N = Integer.parseInt(br.readLine());
            tree = new int[N+1][2];
            node = new String[N+1];
             
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                 
                int index = Integer.parseInt(st.nextToken());
                String value =st.nextToken();
                node[index] = value;
                 
                int j=0;
                while(st.hasMoreTokens()) {
                    int cIndex = Integer.parseInt(st.nextToken());
                    tree[index][j] = cIndex;
                    j++;
                }
            }
//            System.out.println(Arrays.toString(node));
             
            list = new LinkedList<>();
            stack = new Stack<>();
            postOrder(1);
//            for(int i=0;i<N;i++) {
//            	System.out.print(list.get(i)+" ");
//            }
//            System.out.println();
            sum();
            System.out.println("#"+t+" "+stack.pop());
        }
    }
     
    public static void postOrder(int index) {
        if(index==0) return; //자식 index정보가 0이면 종료
         
        postOrder(tree[index][0]);//왼
        postOrder(tree[index][1]);//오
        list.add(node[index]);
    }
     
    public static void sum() {
         
        while(!list.isEmpty()) {
             
            String token = list.removeFirst();
             
            if(token.equals("+") || token.equals("*")||token.equals("/")||token.equals("-")) {
                int q = stack.pop();
                int p = stack.pop();
                 
                if(token.equals("+")) {
                    stack.push(p+q);
                }else if(token.equals("-")) {
                    stack.push(p-q);
                }else if(token.equals("/")) {
                    stack.push(p/q);
                }else if(token.equals("*")) {
                    stack.push(p*q);
                }
                 
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
    }
}
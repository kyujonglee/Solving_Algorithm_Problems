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
                 
                network[R][C] = 1;//�̵������Ѱ����� ǥ��
                if(R == start) {//�������� �����Ҷ�
                    isChecked[R] = true;//�������� �湮�ߴٰ� ǥ��
                    q.offer(C);//�������� ť�� ����
                }
            }
            while(!q.isEmpty()) {//ť�� ������������� �ݺ�
                int qSize = q.size();//������ ���������� �����ľ�
                answer = 0;//�ʱ�ȭ
                for(int i= 0 ; i< qSize; i++) {//������ �������� ������ŭ �ݺ�
                    int tempR = q.poll();//�������� �ӽ�����
                    answer = Math.max(answer, tempR);//�������� ���� ū �� �ľ�
                    for(int j = 1;j<101;j++) {//�����ִ� �� ����
                        if(network[tempR][j] == 1 && isChecked[j] == false) {//�湮�����ʾҰ� �����ִ� ���ϰ��
                            isChecked[j] = true;//�湮�ߴٰ� ǥ��
                            q.offer(j);//�������� ť�� ����
                        }
                    }
                }
            }
            System.out.println("#"+number+ " "+answer);//��� ���
        }
    }
}
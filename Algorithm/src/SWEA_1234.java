import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1234 {
	
	static StringTokenizer st;
	static LinkedList<Integer> list;
	
	public static void delete(LinkedList<Integer> list) {
		boolean flag = true;
		int idx = 0;
		while(flag) {
			flag = false;
			for(int i=0;i<list.size()-1;i++) {
				if(list.get(i)==list.get(i+1)) {
					idx = i;flag = true;
				}
			}
			if(flag) {
				list.remove(idx);
				list.remove(idx);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sen;
		
		for(int t=1;t<=10;t++) {
			st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			sen = st.nextToken();
			list = new LinkedList<>();
			for(int j=0;j<length;j++) {
				list.add(sen.charAt(j)-'0');
			}
			delete(list);
			System.out.print("#"+t+" ");
			while(!list.isEmpty()) {
				System.out.print(list.poll());
			}
			System.out.println();
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1230 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t,i,count;
		int length,index,len;
		String text;
		StringTokenizer st;
		LinkedList<Integer> list;
		for(t=0;t<10;t++) {
			length = Integer.parseInt(br.readLine());
			list = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(i=0;i<length;i++) {
				list.offer(Integer.parseInt(st.nextToken()));
			}
			
			count = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(i=0;i<count;i++) {
				text = st.nextToken();
				if(text.equals("I")) {
					index = Integer.parseInt(st.nextToken());
					len = Integer.parseInt(st.nextToken());
					for(int j=0;j<len;j++) {
						list.add(index+j,Integer.parseInt(st.nextToken()));
					}
				}
				else if(text.equals("D")){
					index = Integer.parseInt(st.nextToken());
					len = Integer.parseInt(st.nextToken());
					for(int j=0;j<len;j++) {
						list.remove(index);
					}
				}
				else {
					len = Integer.parseInt(st.nextToken());
					for(int j=0;j<len;j++) {
						list.addLast(Integer.parseInt(st.nextToken()));
					}
				}
			}
			System.out.print("#"+(t+1));
			for(i=0;i<10;i++) {
				System.out.print(" "+list.get(i));
			}
			System.out.println();
		}
	}
}

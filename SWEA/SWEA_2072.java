import java.util.Scanner;
//난이도 : D1
//제출 횟수 : 1번
//얻어가는 것 : x
public class SWEA_2072 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		int[] sum = new int[count];
		int ssum = 0;
		int k = 0;
		for(int i=0;i<count;i++){
			ssum = 0;
			for(int j=0;j<10;j++){
				k = s.nextInt();
				if(k%2!=0){
					ssum+=k; 
				}
			}
			sum[i] = ssum;
		}
		
		for(int i=0;i<count;i++){
			System.out.println("#"+(i+1)+" "+sum[i]);
		}
	}
}

import java.util.Scanner;

public class SWEA_1204 {
	
	public static int check_num(int[] arr) {
		//check max number
		int[] counting = new int[101];
		int i;
		int max = 0;
		int num = 0;
		for(i=0;i<arr.length;i++) {
			counting[arr[i]]+=1;
		}
		
		for(i=counting.length-1;i>=0;i--) {
			if(counting[i]>max) {
				max = counting[i];
				num = i;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int i;
		int count = s.nextInt();
		int[] test = new int[count];
		
		for (i=0;i<count;i++) {
			int nn = s.nextInt();
			int[] arr = new int[1000];
			for(int j=0;j<arr.length;j++) {
				arr[j] = s.nextInt();
			}
			test[i] = check_num(arr);
			
		}
		for(i=0;i<count;i++){
			System.out.println("#"+(i+1)+" "+test[i]);
		}
		
		s.close();
	}
}

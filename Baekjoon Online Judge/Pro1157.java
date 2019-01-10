import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro1157 {
	//수정할 것!
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sen = br.readLine().toUpperCase();
		char[] arr = sen.toCharArray();
		int[] word = new int[26];
		for(int i=0;i<arr.length;i++) {
			word[arr[i]-'A'] += 1;
		}
		int maxIndex = 0;
		int max = 0;
		int duplicate = 0;
		boolean flag = true;
		for(int i=0;i<word.length;i++) {
			if(max<word[i]) {
				max = word[i];
				maxIndex = i;
			}
			else if(max==word[i]) {
				duplicate = max;
			}
		}
		if(duplicate == max)flag = false;
		if(flag) {
			System.out.println((char)(maxIndex+65));
		}
		else {
			System.out.println("?");
		}
		
		
		
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SWEA_1215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] test = new int[10];
		int i,j,k,t;
		int count = 0;
		boolean flag1 = false;
		boolean flag2 = false; 
		String sen;
		
		for(t=0;t<10;t++) {
			int num = Integer.parseInt(br.readLine());
			char[][] mat = new char[8][8];	
			count=0;
			for(i=0;i<8;i++) {
				sen = br.readLine();
				for(j=0;j<8;j++) {
					mat[i][j] = sen.charAt(j);
					//'A','B','C'¸¸ ÀÖÀ½!
				}
			}
			
			for(i=0;i<8;i++) {
				for(j=0;j<=8-num;j++) {
					flag1 = true;flag2 = true;
					for(k=0;k<num/2;k++) {
						if(mat[i][j+k]!=mat[i][j+num-1-k])flag1=false;
						if(mat[j+k][i]!=mat[j+num-1-k][i])flag2=false;
					}
					if(flag1)count++;if(flag2)count++;
				}
			}
			test[t] = count;
		}
		for(t=0;t<10;t++) {
			System.out.println("#"+(t+1)+" "+test[t]);
		}
		
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SWEA_1216 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] test = new int[10];
		int i,j,k,t;
		boolean flag1 = false;
		boolean flag2 = false; 
		String sen;
		int leng = 0;
		int max = 1;
		//최고로 긴 회문의 길이 출력
		for(t=0;t<10;t++) {
			int ct = Integer.parseInt(br.readLine());
			char[][] mat = new char[100][100];	
			
			for(i=0;i<100;i++) {
				sen = br.readLine();
				for(j=0;j<100;j++) {
					mat[i][j] = sen.charAt(j);
					//'A','B','C'만 있음!
				}
			}
			max = 1;
			for(i=0;i<100;i++) {
				for(leng=max;leng<100;leng++) {
					for(j=0;j<=100-leng;j++) {
						flag1 = true;flag2 = true;
						for(k=0;k<leng/2;k++) {
							if(mat[i][j+k]!=mat[i][j+leng-1-k])flag1=false;
							if(mat[j+k][i]!=mat[j+leng-1-k][i])flag2=false;
						}
						if(flag1 && leng>max) {max=leng;break;}
						if(flag2 && leng>max) {max=leng;break;}
					}
				}
			}
			test[t] = max;
		}
		for(t=0;t<10;t++) {
			System.out.println("#"+(t+1)+" "+test[t]);
		}
		
	}
}

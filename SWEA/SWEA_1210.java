import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class SWEA_1210 {
	
	public static int ladder(int[][] mat,int x,int y) {
		if(x==0) {
			return y;
		}
		else {
			mat[x][y]=-1;
			if(y==0) {
				if(mat[x][y+1]==1) {return ladder(mat,x,y+1);}
				else {return ladder(mat,x-1,y);}
			}
			else if(y==99) {
				if(mat[x][y-1]==1) {return ladder(mat,x,y-1);}
				else {return ladder(mat,x-1,y);}
			}
			else {
				if(mat[x][y+1]==1) {return ladder(mat,x,y+1);}
				else if(mat[x][y-1]==1) {return ladder(mat,x,y-1);}
				else {return ladder(mat,x-1,y);}
			}
		}
			
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i,j;
		int test[] = new int[10];
		
		for(int t=0;t<10;t++){
			int[][] mat = new int[100][100];
			
			int count = Integer.parseInt(br.readLine());
			for(i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(j=0;j<100;j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int x=0;
			for (i=0;i<100;i++) {
				if(mat[99][i]==2) {x=ladder(mat,99,i);break;}
			}
			test[t]=x;
		}
		for(i=0;i<10;i++) {
			System.out.println("#"+(i+1)+" "+test[i]);
		}
	}
}

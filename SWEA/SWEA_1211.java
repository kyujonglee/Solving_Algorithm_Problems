import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class SWEA_1211 {
	public static int find_min_index(int[] arr) {
		int min = Integer.MAX_VALUE;
		int i;
		int index = 0;
		for(i=arr.length-1;i>=0;i--) {
			if(arr[i]<min && arr[i]!=0) min=arr[i];
		}
		System.out.println("min : " + min);
		for(i=arr.length-1;i>=0;i--) {
			if(arr[i]==min) {index=i;break;}
		}
		return index;
	}
	public static int check_ladder(int[][] mat) {
		int count = 0;
		int i,j;
		for(i=0;i<100;i++) {
			for(j=0;j<100;j++) {
				if(mat[i][j]==-1) {mat[i][j]=1;count++;}
			}
		}
		return count;
	}
	public static int ladder(int[][] mat,int x,int y) {
		mat[x][y]=-1;
		if(x==99) {
			return y;
		}
		else {
			if(y==0) {
				if(mat[x][y+1]==1) {return ladder(mat,x,y+1);}
				else {return ladder(mat,x+1,y);}
			}
			else if(y==99) {
				if(mat[x][y-1]==1) {return ladder(mat,x,y-1);}
				else {return ladder(mat,x+1,y);}
			}
			else {
				if(mat[x][y+1]==1) {return ladder(mat,x,y+1);}
				else if(mat[x][y-1]==1) {return ladder(mat,x,y-1);}
				else {return ladder(mat,x+1,y);}
			}
		}		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i,j;
		int test[] = new int[10];
		
		for(int t=0;t<10;t++){
			int[][] mat = new int[100][100];
			
			int num = Integer.parseInt(br.readLine());
			for(i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(j=0;j<100;j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[] arr = new int[100];
			int check[][] = new int[100][100];
			for(i=0;i<100;i++) {
				check = mat;
				if(check[0][i]==1) {
					ladder(check,0,i);
					arr[i] = check_ladder(check); 
				}
			}
			test[t]=find_min_index(arr);
		}
		for(i=0;i<10;i++) {
			System.out.println("#"+(i+1)+" "+test[i]);
		}
	}
}
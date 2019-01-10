import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SWEA_1213 {
	public static int Search_st(String st,String pt) {
		int l = st.length();
		int m = pt.length();
		int i,j;
		int count = 0;
		int index = 0;
		boolean flag = true;
		boolean flag1 = true;
		
		while(index<=l-m) {
			if(pt.charAt(m-1)==st.charAt(index+m-1)) {
				flag = true;
				for(i=m-2;i>=0;i--) {
					if(pt.charAt(i)!=st.charAt(index+i))flag=false;				
				}
				if(flag)count++;
				index += m;
			}else {
				flag1 = true;
				for(i=m-2;i>=0;i--) {
					if(pt.charAt(i)==st.charAt(index+m-1)) {
						index += m-1-i;
						flag1 = false;
					}
				}
				if(flag1)index+=m;
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
	
		for(int t=0;t<10;t++) {
			int num = Integer.parseInt(br.readLine());
			String pt = br.readLine();
			String st = br.readLine();
			System.out.println("#" + (t+1) + " " + Search_st(st, pt));
		}
		
	}
}

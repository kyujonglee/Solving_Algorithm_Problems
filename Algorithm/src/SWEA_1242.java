import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_1242 {
	
	static int N;
	static int M;
	static StringTokenizer st;
	static String[][] arr;
	static Set<String> set = new HashSet<>(); // 한줄 읽을 때 중복되는 줄 제거
	static HashMap<Integer, Integer> hm;
	static byte digit; // character 하나를 읽어서 byte 변수에 저장
	static boolean start = false; // 처음 시작하는 1을 찾았는지 확인하는 변수
	static int[] count = new int[4]; // 총 3번의 숫자를 셀 것이기 때문에! 하지만 index초과 오류가 발생하지 않기 위해 여유공간 하나 더!
	static int countIdx = 0; // 몇번째를 세고 있는지...
	static int rate = 1; // 가로 길이의 비율을 세는 변수
	static int biCount = 0; // 암호의 가로길이의 bit를 얼마나 세었는지...
	static boolean rateBool = false; // rate 한번 계산했는지
	static int[] result = new int[8]; // 암호 
	static int resultIdx = 8; // 암호 8자리 배열
	static int sum = 0; // 케이스마다 암호문검증을 통과한 암호문의 합을 더하는 변수
	static int currentDigit = 0; // 현재의 비트가 0,1 인지 알려주는 변수
	static Set<String> duplicate; // 케이스마다 암호문 중복으로 읽었는지 확인
	
	public static void init() {
		digit = 0; // character 하나를 읽어서 byte 변수에 저장
		start = false; // 처음 시작하는 1을 찾았는지 확인하는 변수
		count = new int[4]; // 총 3번의 숫자를 셀 것이기 때문에! 하지만 index초과 오류가 발생하지 않기 위해 여유공간 하나 더!
		countIdx = 0; // 몇번째를 세고 있는지...
		rate = 1;
		biCount = 0;
		rateBool = false;
		currentDigit = 0; // 현재 0인지 1인지..
		resultIdx = 8;
	}
	
	public static void main(String[] args)throws IOException {
		hm = new HashMap<>();
        hm.put(3211,0);
        hm.put(2221,1);
        hm.put(2122,2);
        hm.put(1411,3);
        hm.put(1132,4);
        hm.put(1231,5);
        hm.put(1114,6);
        hm.put(1312,7);
        hm.put(1213,8);
        hm.put(3112,9);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = "";
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testCase;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			set = new HashSet<>();
			sum = 0;
			duplicate = new HashSet<>();
			
			for(int i=N-1;i>=0;i--) {	
				temp = br.readLine();
				if(set.contains(temp)) continue; // 중복되는 줄 제거
				set.add(temp);
				init();
				
				for(int j=M-1;j>=0;j--) {
					if(temp.charAt(j)!='0' || start) { // '0'이 아닌 문자부터 읽기 시작, 읽기 시작했으면 암호문이 끝날 때까지 읽게 해줌(start)
//						System.out.println(temp.charAt(j));
						// 16진수 -> 10진수 : byte를 사용한 이유는 4자리이기 때문에
						if(temp.charAt(j)>='0' && temp.charAt(j)<='9') {
							digit = (byte) (temp.charAt(j) - '0');
						}
						else {
							digit = (byte) (temp.charAt(j)-'A'+10);
						}
						// 끝에서부터 1의갯수, 0의 갯수, 1의 갯수를 센다. 사용되는 변수 : zeroOne,currentDigit
						// 1 -> 0 , 0 -> 1 바뀌는 경우들을 세면 된다. 
						// 우리는 암호의 가로길이를 알아야 하는데 0~9까지의 암호코드를 보게 되면
						// 1의 갯수들의 비율이 서로소이고, 이거로부터 암호의 가로길이가 56의 몇배수인지 비율을 알게 된다.
						
						for(int search=0;search<4;search++) {
							int zeroOne = digit >> search & 1;
							if(!start && zeroOne == 1) { // digit의 첫 비트부터 읽는 것이 아니라 최초 1이 나온시점부터 읽기시작
								biCount++;
								count[countIdx]++;
								start = true;
								currentDigit = zeroOne;
							}
							// 암호문을 찾고 나서 그 이후에 읽을 때
							else if(start && biCount <= rate*56){
								biCount++;
//								System.out.println("countIdx : "+countIdx);
								if( zeroOne == currentDigit ) {
									count[countIdx]++;
								}else {
									countIdx++;
									if(countIdx == 4) { // count 배열이 다 차면 읽는다. 즉, 암호문 8자리 중 1자리씩
										countIdx = countIdx%4;
										calc();
									}
									count[countIdx]++;
//									biCount++;
									currentDigit = zeroOne;
								}
								//rate 구하기 // 1의 갯수의 비는 항상 서로소이기 때문에 최대공약수를 구함으로써 비율을 구하고 가로의 길이를 구할 수 있음.
								if(countIdx >=3 && rateBool==false) {
									rate = gcd(count[0],count[2]);
									rateBool = true;
								}
							}
//							System.out.println("biCount"+biCount);
							if(biCount == rate*56) {
								calc();
								checkCipher();
								init();
								break;
							}
						}
					}
				}
			}
			System.out.println("#"+(t)+" "+sum);
		}
	}
	public static void checkCipher() {
		//암호문이 맞는지 확인함.
//		System.out.println(Arrays.toString(result));
		// 중복되는 암호문이 없는지 확인 후 sum에 더해준다.
		String temp = "";
		for(int num:result) {
			temp += num;
		}
		if(duplicate.contains(temp))return;
		duplicate.add(temp);
		int oddSum = 0,evenSum=0;
		for(int i=0;i<result.length-1;i++) {
			if((i+1)%2==0) {
				evenSum += result[i];
			}
			else {
				oddSum += result[i];
			}
		}
		boolean flag = false;
		int summ = oddSum*3+evenSum+result[result.length-1];
		if(summ%10==0)flag=true;
		int ans = flag?oddSum+evenSum+result[result.length-1]:0;
		if(flag)sum+=ans;
		
		
	}
	public static void calc() {
		int sumCal = 0;
//		System.out.println(Arrays.toString(count));
		for(int i=count.length-1;i>=0;i--) {
			sumCal += Math.pow(10,i)*count[i];
		}
//		System.out.println("sumCal : "+sumCal);
		// 8자리 암호문을 저장하는 result 배열에 저장(해당되는 번호를)
		result[--resultIdx] = hm.get(sumCal/rate); // sumCal/rate = 비율만큼 카운트한 0,1의 개수를 나누어준다.
		count = new int[4];
	}
	public static int gcd(int a,int b) {
		if(b==0) {
			return a;
		}else {
			return gcd(b,a%b);
		}
		
	}
}

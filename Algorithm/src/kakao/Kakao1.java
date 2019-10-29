package kakao;

import java.io.IOException;

/*
s의 길이는 1 이상 1,000 이하입니다.
s는 알파벳 소문자로만 이루어져 있습니다.
 */

public class Kakao1 {
	
	public int solution(String s) {
		int length = s.length();
        int answer = length;
        for(int i=1; i <= length/2; i++) {
        	int shortLength = makeShortStringByNum(s,i);
        	if(shortLength < answer)
        		answer = shortLength;
        }
        return answer;
    }
	
	public int makeShortStringByNum(String s, int num) {
		String result = "";
		int length = s.length();
		String term = "";
		int cnt = 1;
		for(int i=0; i < length; i = i+num) {
			if(i+num > length) {
				result = addTerm(result, term, cnt);
				term = s.substring(i, length);
				break;
			} 
			String newTerm = s.substring(i, i+num);
			if(term.equals(newTerm)) {
				cnt += 1;
			} else {
				result = addTerm(result, term, cnt);
				cnt = 1;
				term = newTerm;
			}
		}
		result = addTerm(result, term, cnt);
		System.out.println(result);
		return result.length();
	}
	
	public String addTerm(String result, String term, int cnt) {
		if(cnt == 1) {
			result += term;
		} else {
			result += cnt + term;
		}
		return result;
	}
	
	public static void main(String[] args)throws IOException {
		String s = "abcde";
		Kakao1 test = new Kakao1();
		System.out.println(test.solution(s));
	}
}
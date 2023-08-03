package hk.edu20230803.day09;

public class AntQuiz {
	
	// "11" --> "12" 로 반환해 주는 메서드
	// 연속된 숫자의 개수를 구해서 다음에 나오는 수를 구하는 기능
	public String antMake(String s) {
		char c=s.charAt(0);//문자열의 첫번째 숫자를 가져와서 저장해둔다
		String t="";//최종 만들어지는 수자를 저장할 변수
		int count=1;//연속된 숫자의 개수를 저장할 변수
		//첫번째 숫자와 다음에 오는 숫자들을 비교해서 같으면 count++
		//다르면 카운트는 종료하고 기존 숫자+count, 다음숫자 추출해서 비교~~
		for (int i = 1; i < s.length(); i++) {
			if(c==s.charAt(i)) {
				count++;
			}else {
				t=t+c+count;// ""+1+2 --> "12"
				c=s.charAt(i);// 새로운 값 추출해서 저장
				count=1;//카운트 초기화
			}
		}
		
		t=t+c+count;// 마지막 숫자는 처리가 안되서 한번더 실행해줌
		return t;
	}
	
	public void antPrint(int num) {
		String s="1";
		for (int i = 0; i < num; i++) {
			s=antMake(s);//다음값을 구해서 다시 s에 저장한다.		
			System.out.println(s);
		}
		
	}
	
}











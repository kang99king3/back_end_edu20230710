package hk.edu20230801.day07;

public class D4_StringMethodTest {

	//String 주요메서드
	
	//1.문자 하나를 반환: 
	//문자열:"abc"->String "A" , 문자:'A'->char->65 
	//기능구현: "abc".charAt(int index)
	public String sTest01(String s) {
		char c=s.charAt(0);// 0번째 문자를 추출하여 char타입으로 반환
		String ss=c+"";// String <-- char
		String ss2=String.valueOf(c);//String <--char 변환 메서드
		int i = Integer.parseInt("150");//int <--String 변환(wrapper class)
		
		return ss;
	}
	
	//2.문자열의 인덱스를 반환: indexOf(String s)
	// "ABCD"
	//  0123  "ABCD".indexOf("A") --> 0
	//        "ABCD".indexOf("E") --> -1 존재하지 않으면 -1 반환
	//        "ABCD".indexOf("BC") --> 1 문자열의 첫번째 인덱스를 반환
	// 종류: indexOf(): 앞에서 부터 검색, lastIndexOf(): 끝에서 부터 검색
	public String sTest2() {
		String s="경이로운 소문2";
		int num1=s.indexOf("경");
		int num2=s.indexOf("소문");
		int num3=s.lastIndexOf("2");//성능고려 : 끝에서 부터 찾는게 유리하다면..
		
		//존재한다면? 을 많이 사용한다. -1을 아래와 같이 활용
		if(s.indexOf("경이")!=-1) {
			System.out.println("경이라는 단어가 존재함");
		}

		return num1
			  +","
			  +num2
			  +","
			  +num3;
	}
	
	//3.문자열의 길이 반환: length()
	public int sTest03(String s) {
		return s.length();
	}
	
	//4.문자열의 내용을 바꾸는 기능: replace("원본","새로운내용")
	public void sTest4() {
		String s="자바프로그래밍";
		       s.replace("자바", "파이썬");//immutable하기 때문에 원본이 안바뀜
		       s=s.replace("자바", "파이썬");//새로 대입을 해야 한다.    
		System.out.println(s);
	}
	
	//5.문자열에서 원하는 내용만 추출하는 기능: substring()
	//substring(int sIndex,int eIndex): (0,5)---> 0~(5-1)번째 추출
	//substring(int sIndex);  (2) --> 2번째부터 끝까지 추출
	public String sTest5(String s) {
		String ss=s.substring(2);//문자열의 2번째 인덱스부터 끝까지 추출
		String sss=s.substring(0, 3);//0~2번째 인덱스까지 추출
		
		return ss+":"+sss;
	}
	
	//문자열에서 해당 검색어가 존재하는지 판단하여 존재한다면 해당 검색어를 추출하여
	//출력하고, "###"으로 변경하여 처리하고, 계속 검색어가 존재하는지 확인하여
	//앞에 작업을 진행한다.
	// 
	//1.해당 검색어가 존재하는 여부 판단해보기,해당검색어가 없으면 "검색어가 존재하지 않습니다."출력
	//2.해당 검색어의 인덱스를 구해보기: 검색어 인덱스 출력하기
	//3.해당 검색어를 추출해서 출력해보기: substring()을 사용해서 추출한뒤  출력하기
	//4.해당 검색어를 문자열에서 ###으로 바꿔주기
	//5.해당 검색어의 검색된 개수 출력하기[indexOf(idx,검색시작인덱스)]
	
	public void search(String str) {
//		String s="부산";
		String txt="삼성전자가 부산 수영구 광안리해수욕장에서 "
				 +"'드론 라이트쇼(Drone Light Show)'를 진행했다고 부산 1일 밝혔다."
				 +"지난 28일 열린 이번 행사는 부산 갤럭시 신제품을 체험할 수 있는 삼성전자 갤럭시 "
				 +"스튜디오 '부산 광안리' 오픈을 기념해 열렸다.";
		
		if(txt.indexOf(str)!=-1) {// 검색어가 존재한다면
			System.out.println("검색어가 존재합니다.");
			
			System.out.println("검색어 인덱스:"+txt.indexOf(str));
			//substring(s,e) --> e(종료인덱스) = 첫번째 인덱스 + 문자열의 길이
			System.out.println("검색어 출력:"
						+txt.substring(txt.indexOf(str),txt.indexOf(str)+str.length()));
			
			String txtAfter = txt.replace(str, "###");
			System.out.println(txtAfter);
			
			indexCount(txt, str);
			
		}else {
			//해당 검색어가 존재하지 않을 경우
			System.out.println("검색어가 존재하지 않습니다.");
		}
	}
	
	//2,3,5번 기능은 메서드에 따로 txt와 검색어를 받아서 처리
	public void indexCount(String txt, String str) {
		
		int count=0;
		int idx=0;//검색을 시작할 인덱스 
		while(txt.indexOf(str,idx)!=-1) {
			count++;//count의 값을 1씩 증가시킨다.
			System.out.println("검색된 인덱스:"+txt.indexOf(str,idx));
			
			System.out.println("검색어 추출:"
			    +txt.substring(txt.indexOf(str,idx), txt.indexOf(str,idx)+str.length()));
			
			idx=txt.indexOf(str,idx)+str.length();// "String" -> 첫글자의 인덱스는 0 + 길이는 6 = 6 (다음 검색어 검색 시작 인덱스) 
			System.out.println("--------------------------");
		}
		
		System.out.println(str+"의 검색된 개수는 "+count+"개 입니다.");
	}
	
	public void searchTest(String str) {
		String s="SK텔레콤이 싱가포르 1위 통신사 싱텔(Singtel)과 차세대 통신 네트워크 기술 협력을 위한 양해각서(MOU)를 체결했다고 8일 밝혔다.\\r\\n\"\r\n"
				+ "두 통신사는 글로벌 주요 통신사들의 인공지능(AI) 연합인 '글로벌 텔코 AI 얼라이언스'의 창립 회원사로서 협력을 약속했다.\\r\\n\"\r\n"
				+ "양사는 4G·5G 기술 노하우를 바탕으로 고객 경험 향상과 네트워크 안정성·효율성을 동시에 개선할 계획이다. 이를 위해 이동통신 네트워크 엔지니어링·구축·운용·설루션 등 다양한 상용망 분야에서 기술 논의와 인력 교류를 추진한다."
				+ "아울러 에지 AI 인프라 적용과 코어망 운용 기술 연구, 네트워크 슬라이싱(맞춤형 서비스를 위해 코어네트워크를 독립된 여러 가상 네트워크로 분리하는 기술) 등 5G 유무선 이동통신망 진화 기술 전략, 6G 적용 사례 개발 등 분야에서 협력할 예정이다.";
		
	
		if(s.indexOf(str)!=-1) {
			int count=0;//검색된 개수
			int idx=0;//검색 시작 인덱스
			while(s.indexOf(str,idx)!=-1) {
				String ss=s.substring(s.indexOf(str,idx),s.indexOf(str,idx)+str.length());//검색어 추출
				System.out.println("검색어"+(++count)+":"+ss);//검색어 추출 출력
				System.out.println("검색어index:"+s.indexOf(str,idx));//검색어 인덱스 출력
				idx=s.indexOf(str,idx)+str.length();//검색할 다음 시작 인덱스 구하기
				System.out.println("======================\n");
			}
			System.out.println("검색어가 더이상 존재하지 않습니다.");
			System.out.println("검색된 총 개수는 "+count+"입니다.");
			System.out.println(s.replace("str", "###"));
		}else {
			System.out.println("검색어가 존재하지 않습니다.");
		}

	}
}


















package hk.edu20230804.day10;

public class Calendar {

	//leap, plain 값들은 고정적이므로, 주소값 변경 금지
	private static final int[] leap= {31,29,31,30,31,30,31,31,30,31,30,31};//윤년
	private static final int[] plain= {31,28,31,30,31,30,31,31,30,31,30,31};//평년
	
	//윤년을 판단하는 메서드 : true/false
	public static boolean isLeapYear(int year) {
		boolean isS=false;
		if((year%4==0&&year%100!=0)||year%400==0) {
			isS=true;
		}
		return isS;
	}
	
	//2023-08-01까지의 경과일을 구한다면
	//1년도부터 2022년도까지의 경과일 부터 구함--> 월별로 합 --> 일별로 합
	
	//해당 월의 전년도까지의 경과일을 구하자(1년~2022년도까지)
	public int dates(int year) {
		int tot=0;
		for (int i = 1; i < year; i++) {// 변수 i값은 년도를 의미함
			if(isLeapYear(i)) {
				tot+=366;
			}else {
				tot+=365;
			}
		}
		return tot;
	}
	
	//전년도까지의 경과일 + 이번년도에 전월까지 경과일 구하기
	public int dates(int year, int month) {
		//전년도까지 경과일을 초기값 설정
		int tot=dates(year);
		
		for (int i = 1; i < month; i++) {
			if(isLeapYear(year)) {
				tot+=leap[i-1];// 1월, 2월... 인덱스는 0부터 시작 
			}else {
				tot+=plain[i-1];
			}
		}
		
		return tot;
	}
	
	//전년도까지의 경과일 + 이번년도에 전월까지 경과일 구하기+해당달의 1일
	public int dates(int year, int month, int day) {
		return dates(year, month)+day;
	}
	
	//구하고자 하는 달의 마지막 날을 구하는 기능
	public int lastDay(int year, int month) {
		int last=0;
		if(isLeapYear(year)) {
			last=leap[month-1];
		}else {
			last=plain[month-1];
		}
		return last;
	}
	
	//한달을 출력하는 메서드
	public void calendarPrint(int year, int month) {
		System.out.println("\t\t\t"+year+"년 "+month+"월" );
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int dayOfWeek=dates(year, month, 1)%7;//공백수
		for (int i = 0; i < dayOfWeek; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= lastDay(year, month); i++) {
			System.out.print(i+"\t");//날짜 출력
			if((dayOfWeek+i)%7==0) {//토요일이냐?, 참고로 일요일은 나머지가 1임
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		Calendar cal=new Calendar();
		
		for (int i = 1; i <= 12; i++) {
			cal.calendarPrint(2023, i);
			System.out.println("\n");
		}
		
		
		
	}
}























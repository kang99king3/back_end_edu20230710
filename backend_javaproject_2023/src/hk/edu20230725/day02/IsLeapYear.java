package hk.edu20230725.day02;

public class IsLeapYear {

	public static void main(String[] args) {
		
		//윤년을 판단하는 기능 : 1년 365일 --> 366일(윤년) 2월달이 28이냐 29일이냐?
		//윤년인지를 판단하는 조건식이 존재(참..다행이도)
		// 년도가 4의 배수이면서 100으로는 나누어 떨어지지 않는 수 
		// 또는 400으로 나누어 떨어지는 수
        // 2023년도가 윤년인지 아닌지 확인해서 출력해보기 : "2023년은 윤년이다"
		
//		if((2023%4==0&&2023%100!=0)||2023%400==0) {
//			System.out.println(2023+"년은 윤년이다");
//		}else {
//			System.out.println(2023+"년은 평년이다.");
//		}
		
//		int year=2023;
//		if((year%4==0&&year%100!=0)||year%400==0) {
//			System.out.println(year+"년은 윤년이다");
//		}else {
//			System.out.println(year+"년은 평년이다.");
//		}
		
//		2000~2030년 기간중에 윤년을 출력하시오
//		for (int year = 2000; year <= 2030; year++) {
//			if((year%4==0&&year%100!=0)||year%400==0) {
//				System.out.println(year+"년은 윤년이다");
//			}else {
//				System.out.println(year+"년은 평년이다.");
//			}
//		}
		
		for (int year = 2000; year <= 2030; year++) {
			if(isLeapYear(year)) {
				System.out.println(year+"년은 윤년이다");
			}else {
				System.out.println(year+"년은 평년이다.");
			}
		}
	}
	
	//윤년을 판단하는 메서드 : true/false
	public static boolean isLeapYear(int year) {
		boolean isS=false;
		if((year%4==0&&year%100!=0)||year%400==0) {
			isS=true;
		}
		return isS;
	}

}





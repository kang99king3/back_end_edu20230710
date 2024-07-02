package hk.edu20230808.day13;

public class UserException extends Exception{
	
	public UserException() {
		this("UserExcetion 오류입니다.");
	}
	
	public UserException(String msg) {
		super(msg);//부모의 생성자: Exception클래스 생성자 호출
	}
	
	
}

package hk.edu20230803.day09;
//로또 한장을 가지고 있는 객체
public class Lotto {

	//6개번호를 저장할 배열선언
	private int [] lots;//배열선언
	
	public int[] getLots() {
		return lots;
	}

	//생성자: 클래스의 맴버필드를 초기화
	public Lotto() {
		lots=new int[6];
		makeLotto();
	}
	
	//생성자 오버로딩
	public Lotto(int n) {
		lots=new int[n];
		makeLotto();
	}
	
	//1~45까지 숫자 중에 랜덤 숫자 생성하는 메서드
	public int makeBall() {
		//0.0000000.... ~ 0.9999999... 사이에 값중에 랜덤하게 실수를 리턴 : Math.random()
		//Math.random()*45
		//   1보다 작기때문에 45와 곱하면 최대 45미만이다 --> (int)Math.random()*45 -> 0~44
		// 그래서 +1을 해준다.
		return (int)(Math.random()*45)+1;
	}
	
	//1~45사이의 랜덤숫자을 배열에 넣어주는 메서드
	public void makeLotto() {
//		for (int i = 0; i < lots.length; i++) {
//			lots[i]=makeBall();// 중복된 숫자가 포함되는 문제 발생
//		}
		
		int count=0;
		while(count<lots.length) {
			int b=makeBall();
			if(!isSame(lots, b)) { //중복되는 숫자가 없다면
				lots[count++]=b;//숫자를 배열에 추가
			}
		}
	}
	
	//중복 숫자가 있는지 여부 판별하는 메서드
	public boolean isSame(int [] a, int b) {
		boolean isS=false;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==b) {
				isS=true;
				break;//여러번 중복확인할 필요는 없으므로 for문을 빠져나간다
			}
		}
		return isS;
	}
}














package hk.edu20230803.day09;

import java.util.Arrays;

//구매한 로또를 당첨번호와 비교해서 결과를 보여주는 클래스
public class LottoCompare {
	//당첨번호를 저장할 맴버필드
	public static Lotto lottoBall=new Lotto();//static으로 선언하면 객체들이 하나를 공유하게 됨
	//사용자 번호를 저장할 맴버필드
	public LottoStore userBall;
	
	public LottoCompare() {
//		this.lottoBall=new Lotto();
		this.userBall=new LottoStore();//기본 5장구매
	}
	
	public LottoCompare(int n) {
//		this.lottoBall=new Lotto();
		this.userBall=new LottoStore(n);//원하는 만큼 구매
	}
	
	//당첨번호 비교하는 메서드
	public void comapreBall() {
		//당첨번호 출력
		System.out.println("1회 당첨번호");
		int [] lots=lottoBall.getLots();//은닉화: 메서드 통해 가져옴
		Arrays.sort(lots);
		System.out.println(Arrays.toString(lots));
		
		//사용자 구매번호 출력
		System.out.println("사용자 구매번호");
		Lotto[] userLots=userBall.lottoObj;//사용자가 구매한 로또들
		for (int i = 0; i < userLots.length; i++) {
			Arrays.sort(userLots[i].getLots());
			System.out.println(Arrays.toString(userLots[i].getLots()));
		}
		
		System.out.println("당첨번호 맞추기");
		for (int i = 0; i < userLots.length; i++) {
			int count=0;
			System.out.println(Arrays.toString(userLots[i].getLots()));//사용자로또 한장출력
			for (int j = 0; j < lots.length; j++) {
				if(isSame(userLots[i].getLots(), lots[j])) {
					System.out.print(lots[j]+" ");//당첨번호 출력
					count++;
				}
			}
			System.out.println("당첨번호 개수:"+count);
			lottoResult(count);
			System.out.println("\n-------------------------------");
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
	
	//당첨 개수에 대한 등수를 출력하기
	//6개면 "1등", 5개면 "2등"... 4개면 "3등"... 출력 
	public void lottoResult(int count) {
		switch (count) {
			case 6:System.out.println("1등");break;
			case 5:System.out.println("2등");break;
			case 4:System.out.println("3등");break;
			case 3:System.out.println("4등");break;
			case 2:System.out.println("5등");break;
			default:System.out.println("다음기회에!!");break;
		}
	}
	
	
}







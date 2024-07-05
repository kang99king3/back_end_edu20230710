package hk.edu20230803.day09_2;

public class BaseBallGame {
	public int [] pit;
	public int [] bat;
	public BaseBallGame() {
		create();
	}
	public void create(){
		Pitcher p=new Pitcher();
		p.make();
		pit=p.pBall;
		p.pPrint();
	}
	
	//게임 실행하는 메서드
	public void play(){
		Hitter h=new Hitter();
		int count=0;
		while(count<10){
			bat=h.make();
			if(!isInt(bat)){//1~9까지의 숫자인지 확인
				h.Bprint();
				if(compare()==3){// 3이면 strike3개로 게임 종료
					break;
				}
				count++;
				if(count==10){
					System.out.println("10회를 초과 하여 투수가 승리하였습니다!!");
					break;
				}
			}else{
				System.out.println("숫자만 입력하세요");
			}
			
		}
	}
	
	//타자와 투수의 숫자3개를 비교하는 메서드: 결과를 3또는 1로 반환시켜준다.
	public int compare(){
		int strike=0;
		int ball=0;
		for (int i = 0; i < pit.length; i++) {
			for (int j = 0; j < pit.length; j++) {
				if(pit[i]==bat[j]&&i==j){
					strike++;
				}else if(pit[i]==bat[j]&&i!=j){
					ball++;
				}
			}
		}
		return winPrint(strike, ball);
	}
	
	//strike와 ball의 개수를 판단해서 결과를 알려주는 기능
	public int winPrint(int s,int b){
		if(s==0&&b==0){
			System.out.println("OUT!!!");
		}else if(s==3){
			System.out.println("strike: "+s+" 숫자를 모두 맞추셨습니다.");
			System.out.println("타자 승리 !!");
			return 3;
		}else{
			System.out.println("strike: "+s+",ball: "+b);
		}
		return 1;
	}
	
	//입력받은 숫자가 1~9사이에 숫자인지 판별하는 메서드
	public boolean isInt(int [] a){
		boolean isC=false;
		for (int i = 0; i < a.length; i++) {
			if(!(a[i]>0&&a[i]<10)){
				isC=true;
				break;
			}
		}
		return isC;
	}
}

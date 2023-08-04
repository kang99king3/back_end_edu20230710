package hk.edu20230803.day09;

public class LottoStore {

	//Lotto객체 여러개를 담아줄 배열 선언
	public Lotto [] lottoObj;// {lotto, lotto, lotto....},      {int,int..} {{},{}..}
	
	//2차원 배열로 구현한다면...이 코드에서는 사용안함. 
	public int [][] lotsInt;
	public LottoStore(int m, int n) {
		lotsInt=new int [m][n];
	}

	public LottoStore() {
		lottoObj=new Lotto[5];
		makeLotto();
	}
	
	public LottoStore(int n) {
		//       new int []
		lottoObj=new Lotto[n];
		makeLotto();
	}
	
	//Lotto객체를 생성해서 배열에 저장하는 메서드
	public void makeLotto() {
		for (int i = 0; i < lottoObj.length; i++) {
			lottoObj[i]=new Lotto();
		}
	}
	
}








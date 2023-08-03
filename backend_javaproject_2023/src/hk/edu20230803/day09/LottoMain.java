package hk.edu20230803.day09;

import java.util.Arrays;

public class LottoMain {

	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			Lotto lotto=new Lotto();
//			lotto.makeLotto();
//			
//			System.out.println(Arrays.toString(lotto.lots));
//			
//		}
		
		LottoStore lottoStore=new LottoStore(20);
		Lotto[] lottoObj=lottoStore.lottoObj;
		for (int i = 0; i < lottoObj.length; i++) {
			Lotto lotto=lottoObj[i];
			System.out.println(Arrays.toString(lotto.getLots())); 
		}
	}

}






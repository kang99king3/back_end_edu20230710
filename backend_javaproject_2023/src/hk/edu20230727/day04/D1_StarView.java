package hk.edu20230727.day04;

public class D1_StarView {

	public static void main(String[] args) {
		/*   1  2 3 4 5 6 ..... ?        
             0	1 2             40 	 	
	 		0★
	        1★★
	        2★★★
	        3★★★★             an+(n)*d -> 1+n*1 -> 1+n -> 1+i
	        4★★★★★    
	        
	             ★                1+n*2 --> 1+2*i
	            ★★★             
	           ★★★★★
	          ★★★★★★★    
		*/
		
		//for문에서 변수i는 위치를 나타냄
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		/* 2번모양
		  0     ★
		  1    ★★
		  2   ★★★
		  3  ★★★★
		  4 ★★★★★
		 
		 */
		for (int i = 0; i < args.length; i++) {
			for (int j = 0; j < args.length; j++) {
				//공백출력
			}
			for (int j = 0; j < args.length; j++) {
				//별출력
			}
		}
		
		//3번모양
		/*        ★
		 *       ★★★
		 *      ★★★★★
		 *     ★★★★★★★
		 */
		
		//4번모양
		/*      ★★★★★★★
		 *       ★★★★★
		 *        ★★★ 
		 *         ★
		 */
	}
	
}




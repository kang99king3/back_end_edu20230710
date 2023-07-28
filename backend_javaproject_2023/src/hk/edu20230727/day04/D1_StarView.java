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
		
		/* 2번모양                       an+(n-1)*d
		  0 ☆☆☆☆★          4 3 2 1      4 + i*-1 =4-i
		  1 ☆☆☆★★          0 1 2 3
		  2 ☆☆★★★
		  3 ☆★★★★
		  4 ★★★★★
		 
		 */
		System.out.println("============================");
		int num=10;//값을 변경해서 실행해보기
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num-1-i; j++) {
				//공백출력
				System.out.print("☆");
			}
			for (int j = 0; j < i+1; j++) {
				//별출력
				System.out.print("★");
			}
			System.out.println();
		}
		
		//3번모양
		/*     ☆☆☆☆★            4+i*-1= 4-i
		 *     ☆☆☆★★★
		 *     ☆☆★★★★★          1 3 5 7 9...     1+i*2 = 2*i+1
		 *     ☆★★★★★★★
		 *     ★★★★★★★★★
		 */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4-i; j++) {
				System.out.print("☆");
			}
			for (int j = 0; j < 2*i+1; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		//4번모양
		/*    ★★★★★★★★★         0 1 2 3 4 5    0+i*1= i
		 *     ★★★★★★★
		 *      ★★★★★            9 7 5 3 1      9+i*-2 
		 *       ★★★ 
		 *        ★
		 */
		
		int num2=10;
		for (int i = 0; i < num2; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("☆");
			}
			for (int j = 0; j < (num2*2-1)+i*-2; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}
	
}













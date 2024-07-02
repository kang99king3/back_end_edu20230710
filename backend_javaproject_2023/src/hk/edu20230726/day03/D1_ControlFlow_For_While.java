package hk.edu20230726.day03;

import java.util.Iterator;

public class D1_ControlFlow_For_While {

	public static void main(String[] args) {
		
		//for문 : 기본for문(index) , 향상된 for문 
		//기본 형태: 범위를 설정하고, 그 범위를 벗어나지 않는 상태에서 반복 실행
		for (int i = 0; i < 10; i++) {
			//실행코드작성
			if(i==3) {
//				break;// 이 코드가 실행되는 순간 반복문을 빠져나간다(종료시킴)
				continue;// 가장 가까운 반복문으로 돌아간다
			}
			System.out.println(i+1);
		}
		
		System.out.println("===향상된 for문");
		//향상된 for문
		int[] i= {1,2,3,4,5};
		for (int val : i) {
			System.out.println(val);
		}
		
		for (int j = 0; j < i.length; j++) {
			int val=i[j];//기본for문에 경우는 배열에 index를 통해 접근하는 코드 추가
			System.out.println(val);
		}
		
		//중첩for문
		for (int j = 0; j < 5; j++) {
			for (int j2 = 0; j2 < 5; j2++) {
				System.out.println(j2);
			}
			System.out.println("---------------");
		}
		
		System.out.println("=======while문=======");
		//while문
		int w=0;
		while(true) {
			System.out.println("while문 실행");
			
			if(w>5) {
				break;//while문을 종료시킬 코드를 작성해야 한다.
			}
			w++;
		}
		
		do {
			//실행코드작성
			System.out.println("do~while: 최소 한번은 실행한다.");
		} while (10<5);

		System.out.println("======================");

		  for(int ii = 0; ii < 10; ii++) {
            aa: {
                // 라벨 브레이크는 { } 을 사용하여 만든다. aa:는 시작하는 라벨이다.
                // break aa; 위치에서 aa:로 옮겨서 시작한다.
                System.out.println("i ==> " + ii);
                for (int j = 0; j < 2; j++) {
                     if((ii % 5 == 1) || (ii % 5 == 2)) {
                          System.out.println("i : "+ ii + " j : "+ j);
                     }else 
                          break aa;
                } // for
                System.out.println("라벨aa종료");
            } // aa:
       } // for
	}

}






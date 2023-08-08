package hk.edu20230808.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hk.edu20230803.day09.Lotto;

public class ListTest {

	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("가");//값을 저장하면 자동으로 인덱스 생성되면서 저장.
		list.add("나");
		list.add(1);
		
		//값을 꺼내려면 다운캐스팅 작업을 해야 한다.
		String s=(String)list.get(0);// String <---Object
		int i=(int)list.get(2);// int <---Object
		
//		class ArrayList{
//			
//			private Object value;
//			public void add(Object s) {
//				value=s;
//			}
//		}
		
		//제네릭을 사용하면.
		List<String> list2=new ArrayList<>();
		list2.add("다");
		list2.add("라");
		String ss=list2.get(0);//다운캐스팅을 할 필요가 없다.
		
		list2.remove(0);//삭제
		list2.clear();//값을 모두 삭제
		System.out.println("list2의 길이값:"+list2.size());
		
		//Lotto객체를 list에 저장해보자
		List<Lotto> lottoList=new ArrayList<>();
		for (int j = 0; j < 5; j++) {
			lottoList.add(new Lotto());
		}
		for (Lotto lotto : lottoList) {
			System.out.println(Arrays.toString(lotto.getLots()));
		}
	}
}














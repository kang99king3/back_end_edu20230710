package hk.edu20230808.day12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		
		Set<String> set=new HashSet<>();
		set.add("한");
		set.add("경");
		set.add("닷");
		set.add("컴");
		set.add("컴");//중복된 값 저장X
		
		//값을 꺼내야 하는데....   인덱스도 없고, 순서도 없고...key도 없고.
		//Iterator 인터페이스를 구현해서 꺼내야함
		//기능: 있으면 아무거나 꺼내고, 없으면 종료
		//set에 구현되어 있는 iterator()를 통해 Iterator객체를 받는다
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {//값이 존재하는지 여부 확인
			String str=iter.next();//값을 가져온다
			System.out.println("set값:"+str);
		}
		
	}
}













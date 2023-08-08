package hk.edu20230808.day12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		//Json 객체의 형태와 유사
		//myBatis 프레임워크에서 쿼리작성 xml <--- Map이 사용됨
		
		Map<String, String> map = new HashMap<>();
		map.put("하나", "한경");
		map.put("둘", "닷컴");
		map.put("셋", "IT");
		System.out.println("Map의 값:"+map.get("하나")
									 +map.get("둘")
									 +map.get("셋"));
		
		Set<String> setKeyMap=map.keySet();//Set객체를 반환(key값이 담김)
		Iterator<String> iterKeyMap=setKeyMap.iterator();//Iterator객체로 반환
		while(iterKeyMap.hasNext()) {
			String str=iterKeyMap.next();//key값을 하나 꺼냄
			System.out.println(map.get(str));
		}
	}
}



















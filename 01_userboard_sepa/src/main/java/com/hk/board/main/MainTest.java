package com.hk.board.main;

import java.util.List;
import com.hk.board.daos.UserDao;
import com.hk.board.dtos.UserDto;

public class MainTest {

	public static void main(String[] args) {
		UserDao dao=new UserDao();//객체생성을 하면 드라이버 로딩 실행
		
		//회원목록조회기능
		List<UserDto> list = dao.getAllUser();
		System.out.println();
		System.out.println("==회원목록==");
		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
			System.out.println(list.get(i).getUserID()+"|"
					          +list.get(i).getName()+"|"
					          +list.get(i).getmDate());
		}
		
		//회원정보 등록하기
		UserDto dto=new UserDto();
		dto.setUserID("KKP");
		dto.setName("김경호");
		dto.setBirthYear(1971);
		dto.setAddr("전남");
		dto.setMobile1("019");
		dto.setMobile2("33333333");
		dto.setHeight(177);
		
//		boolean isS=dao.insertUser(dto);
	}
	
	

	
	
}











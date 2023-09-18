package com.hk.board.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hk.board.dtos.UserDto;

public class UserDao {

	//1단계: 드라이버 로딩
	public UserDao() {
		//강제 객체 생성: 예외처리를 해야 함
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("1단계:드라이버로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("1단계:드라이버로딩 실패");
		}
	}
	
	//회원목록 조회기능
	public List<UserDto> getAllUser(){
		List<UserDto> list=new ArrayList<>();
		
		//DB연결을 위한 정보 정의
		String url="jdbc:mariadb://localhost:3306/hkedu";
		String user="root";
		String password="manager";
		Connection conn=null;
		
		// java.sql, java.io, java.net : 무조건 예외처리 해줘야 함
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("2단계:DB연결성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("2단계:DB연결실패");
		}
	
		return list;
	}
}















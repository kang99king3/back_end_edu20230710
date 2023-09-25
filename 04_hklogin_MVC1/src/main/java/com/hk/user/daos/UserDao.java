package com.hk.user.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hk.datasource.DataBase;
import com.hk.user.dtos.RoleStatus;
import com.hk.user.dtos.UserDto;

//외부에서 메서드를 호출하는 방법
// 객체생성해서 객체명.메서드()
// Static선언 클래스명.메서드()

public class UserDao extends DataBase{

	//싱글톤 패턴 : 객체를 한번만 생성하자
	private static UserDao userDao;//생성된 객체를 저장
	private UserDao() {}// new LoginDao() X : 외부접근금지
	public static UserDao getUserDao() {//메서드를 통해 접근 가능
		if(userDao==null) {
			userDao=new UserDao();//내부에서 객체생성
		}
		return userDao;
	}
	
	//사용자 기능
	
	//1. 회원가입 기능(enabled:'Y', role:'USER', regDate:현재날짜)
	// insert문 작성
	public boolean insertUser(UserDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" INSERT INTO userinfo "
				 + " VALUES (NULL,?,?,?,?,?,'Y',?,SYSDATE())";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getPassword());
			psmt.setString(4, dto.getAddress());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, String.valueOf(RoleStatus.USER));
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
	
	//2. 아이디 중복 체크하기
	//   select문 실행
	public String idCheck(String id) {
		String resultId=null;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql=" SELECT id FROM userinfo WHERE id=? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				resultId=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		return resultId;
	}
	
	//3. 로그인 기능 : ID와 password를 통해 회원정보 조회
	// 로그인 기능 만들어보기
	// main 메서드에 지금 만든 메서드 실행해 보기
	
	
}


















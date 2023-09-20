package com.hk.board.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hk.board.dtos.HkDto;
import com.hk.datasource.DataBase;

public class HkDao extends DataBase{

	public HkDao() { // 생략가능
		super();//생략가능 --> 부모의 생성자 호출--> 객체 생성
	}
	
	//글목록 조회 기능 : 반환값 List<HkDto> --> 여러개의 행일 경우
	public List<HkDto> getAllList(){
		List<HkDto> list=new ArrayList<>();
		Connection conn=null;// DB연결된 객체
//		Statement --> ? 파리미터를 제공X
		PreparedStatement psmt=null;//쿼리준비를 위한 객체 : ? 파리미터를 제공함
		ResultSet rs=null;//쿼리실행결과를 받아줄 객체
		
		String sql=" SELECT seq, id, title, content, regdate "
				 + " FROM hkboard ORDER BY regdate DESC ";
		
		try {
			conn=getConnection();//2단계:DB연결하기
			psmt=conn.prepareStatement(sql);//3단계:쿼리 준비하기
			rs=psmt.executeQuery();//4단계:쿼리실행하기
			//5단계:쿼리결과 받기-> 자바에서 사용할 수 있게 처리
			while(rs.next()) {//rs객체안에 데이터가 있는지 여부를 확인
				HkDto dto=new HkDto();//행단위로 저장
				dto.setSeq(rs.getInt(1));//DB에서 인덱스 체계는 1부터 시작 
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegDate(rs.getDate(5));
				list.add(dto);
				System.out.println(dto);
			}
		} catch (SQLException e) {
			System.out.println("JDBC실패:"+getClass()+":"+"getAllList()");
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);//6단계:쿼리결과닫기
		}
		return list;
	}
}









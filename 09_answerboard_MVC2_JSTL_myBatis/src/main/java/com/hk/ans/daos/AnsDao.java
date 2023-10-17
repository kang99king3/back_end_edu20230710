package com.hk.ans.daos;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hk.ans.config.SqlMapConfig;
import com.hk.ans.dtos.AnsDto;

public class AnsDao extends SqlMapConfig{

	private String namespace="com.hk.ans.";
	
	//1.글목록 조회하기
	public List<AnsDto> getAllList(){
		List<AnsDto> list=new ArrayList<>();
		SqlSession sqlSession=null;//쿼리를 실행시켜주는 객체
		try {
			//sqlSessionFactory객체의 openSession()를 통해 
			//sqlSession객체를 구한다 (true:autocommit설정)
			sqlSession=getSqlSessionFactory().openSession(true);
			
			//sqlSession객체에 쿼리 실행 메서드를 통해 쿼리실행
			// 쿼리실행메서드(쿼리이름,파라미터)
			list=sqlSession.selectList(namespace+"boardList");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	//2.새글추가하기
	public boolean insertBoard(AnsDto dto) {
		int count=0;
		SqlSession sqlSession=null;
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			//파리미터 타입: DTO,Array,Map(파라미터 기본 타입)
			//            값한개(int,String해당타입으로 정의)
			count=sqlSession.insert(namespace+"insertBoard",dto);
		} catch (Exception e) {
			e.printStackTrace();// <--이게 없으면 오류 출력안됨
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
	
	
	public void test() {
		//쿼리를 실행시킬 수 있는 객체 : sqlSession객체를 구함
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		//쿼리를 실행한다.--> sqlMapper.xml에 있는 쿼리를 실행한거임
		List<AnsDto>list= sqlSession.selectList("boardList");
	}
}






package com.hk.ans.daos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hk.ans.config.SqlMapConfig;
import com.hk.ans.dtos.AnsDto;

public class AnsDao extends SqlMapConfig{

	public void test() {
		//쿼리를 실행시킬 수 있는 객체 : sqlSession객체를 구함
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		//쿼리를 실행한다.--> sqlMapper.xml에 있는 쿼리를 실행한거임
		List<AnsDto>list= sqlSession.selectList("boardList");
	}
}







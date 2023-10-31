package com.hk.ansboard.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.ansboard.dtos.AnsDto;

@Repository
public class AnsDaoImp implements IAnsDao{

	private String namespace="com.hk.ansboard.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<AnsDto> getAllList(String pnum) {
		Map<String,String>map=new HashMap<>();
		map.put("pnum", pnum);
		return sqlSession.selectList(namespace+"getAllList", map) ;
	}

	@Override
	public int getPCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertBoard(AnsDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AnsDto getBoard(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBoard(AnsDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readCount(int seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mulDel(String[] seqs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replyBoard(AnsDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

}

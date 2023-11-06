package com.hk.calboard.service;

import java.util.List;
import java.util.Map;

import com.hk.calboard.dtos.CalDto;

public class CalServiceImp implements ICalService{

	//Validated 유효값처리 라이브러리 사용
	// - Command 클래스를 생성하여 유효값 확인
	// 화면 --> command --> 컨트롤러/서비스 (command-> dto)--> Mapper로 전달
   	//         command에 저장된 값을 확인하여 오류가 있으면 화면으로 보내고 
	//         오류가 없으면 서비스로 보냄
	@Override
	public int insertCalBoard(CalDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CalDto> calBoardList(String id, String yyyyMMdd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalDto calBoardDetail(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean calBoardUpdate(CalDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean calMulDel(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CalDto> calViewList(String id, String yyyyMM) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calBoardCount(String id, String yyyyMMdd) {
		// TODO Auto-generated method stub
		return 0;
	}

}

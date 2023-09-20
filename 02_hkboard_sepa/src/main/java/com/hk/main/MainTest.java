package com.hk.main;

import java.util.List;
import java.util.Scanner;

import com.hk.board.daos.HkDao;
import com.hk.board.dtos.HkDto;

public class MainTest {

	public static void main(String[] args) {
		
		HkDao dao=new HkDao();
		
		Scanner scan=new Scanner(System.in);
		System.out.println("1.글목록 2.글추가 3.글상세조회 4.글수정하기 5.글삭제하기");
		
		
		//글목록 가져오는 기능
		System.out.println("==글목록==");
		List<HkDto> list=dao.getAllList();
		
		//글 추가
		
		//상세 조회
		
		//글 수정
		
		//글 삭제

	}

}

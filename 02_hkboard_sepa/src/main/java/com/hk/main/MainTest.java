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
		
		int num=scan.nextInt();
		
		if(num==1) {
			//글목록 가져오는 기능
			System.out.println("==글목록==");
			List<HkDto> list=dao.getAllList();			
		}else if(num==2) {
			//글 추가
			System.out.println("==글추가==");
			System.out.println("아이디를 입력하세요:");
			String id=scan.next();
			System.out.println("제목을 입력하세요:");
			String title=scan.next();
			System.out.println("내용을 입력하세요:");
			String content=scan.next();
			dao.insertBoard(new HkDto(id,title,content));			
		}else if(num==3) {
			//상세 조회
			
		}else if(num==4) {
			//글 수정
			
		}else if(num==5) {
			//글 삭제
			
		}
		
		
		

	}

}

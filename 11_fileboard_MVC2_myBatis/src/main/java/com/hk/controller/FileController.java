package com.hk.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.daos.FileDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("*.file")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String command=request.getRequestURI()
					.substring(request.getContextPath().length());
		System.out.println("command값:"+command);
		
		FileDao dao=new FileDao();
		
		if(command.equals("/fileUploadForm.file")) {
			response.sendRedirect("uploadForm.jsp");
		}else if(command.equals("/fileUpload.file")) {
			MultipartRequest multi=null;
			
			//1.경로 정의(상대경로, 절대경로)
			//- 절대경로지정
			String saveDirectory
					="C:/Users/user/git/back_end_edu20230710_web/"
				   + "11_fileboard_MVC2_myBatis/src/main/webapp/upload";
			
			//2.file 업로드 사이즈: 1b->1024b->1kb->1024kb->1MB * 10 = 10MB
			int maxPostSize=1*1024*1024*10;//10MB
			
			try {
				//MultipartRequest객체가 생성되면 업로드가 실행된다.
				//파라미터내용(요청객체,저장경로,최대업로드 사이즈, 인코딩, 중복파일명 재정의)
				multi=new MultipartRequest(request, saveDirectory, maxPostSize, 
										  "utf-8", new DefaultFileRenamePolicy());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//DB에 파일정보 추가하기	
			// 1.원본파일명 구하기
			// "filename"은 페이지에서 전달될때 정의했던 이름 name="filename"
			String origin_name=multi.getOriginalFileName("filename");
			System.out.println("원본파일명:"+origin_name);
			// 2.저장 파일명 구하기: UUID객체 ---> 32자리 값을 구해서 저장
			// "12345678-12345678-12345678-12345678"
			String random32=UUID.randomUUID().toString().replace("-", "");//"-"제거
			String stored_name=random32   //abc.jpg -> random32+.jpg 추출
					+(origin_name.substring(origin_name.lastIndexOf(".")));
			
			System.out.println("저장파일명:"+stored_name);
			// 3.파일사이즈 구하기: length()는 long타입으로 반환 --> int로 형변환 필요
			int file_size=(int)multi.getFile("filename").length();
			// 4.DB에 정보 추가하기
			
			// 5.저장된 파일명 변경하기(old이름 --> stored이름)
			
			response.sendRedirect("uploadForm.jsp");
		}
		
	}

}








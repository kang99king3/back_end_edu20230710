package com.hk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.daos.FileDao;

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
			
		}
		
	}

}








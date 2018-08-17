package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import command.Carrier;
import command.Receiver;
import command.SearchCommand;
import domain.*;
import enums.Action;
import enums.Term;
import service.*;

@WebServlet({"/member.do"}) //ServeltPath 
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MemberController() {
		super();
	}
	//doget+dopost = service
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("멤버컨트롤 입력");
		System.out.println("액션: "+Receiver.cmd.getAction());
		Receiver.init(request);
/*		String action = request.getParameter("action");
		String page = request.getParameter("page");*/
		MemberBean mem = null;
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		
		case ADD: 
			Carrier.redirect(request, response,"/member.do?action=move&page=userLoginForm");
			//도메인 response는 jsp에 사는애. 스크립트립. 멤버컨트롤러로 다시 진입시켜?
			System.out.println(mem);
			break;
		case MODIFY : 
			System.out.println("컨트롤러-업데이트 진입");
			Carrier.redirect(request, response, "/member.do?action=retrieve&page=retrieve");
			break;
		 case FILEUPLOAD : 
				System.out.println("--1--");
				if(!ServletFileUpload.isMultipartContent(request)){
					System.out.println("업로드파일이 없습니다.");
					return;
				}
				System.out.println("--2 업로드 파일이 존재함 --");
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setFileSizeMax(1024*1024*40); //3메가 
				upload.setSizeMax(1024*1024*50); //50메가
				List<FileItem> items = null;
				try {
					System.out.println("--3 트라이내부진입 --");
					File file = null;
					items = upload.parseRequest(
							new ServletRequestContext(request));
					System.out.println("--4 아이템생성  --");
					Iterator<FileItem> iter = items.iterator();
					/*FileReader fr = new FileReader(file);
					BufferedReader reader = new BufferedReader(fr);*/
							while(iter.hasNext()) {
								System.out.println("--5 와일진입  --");
									FileItem item = (FileItem) iter.next();
									if(!item.isFormField()) {
								System.out.println("--6 이프진입  --");
									/*String fieldName = item.getFieldName();*/
									/*boolean isINMemory = item.isInMemory();
									long sizeInBytes = item.getSize();*/
									String fileName = item.getName();
									file = new File(Term.UPLOAD_PATH+fileName);
									item.write(file);
									Map<String, Object> param = new HashMap<>();
									param.put("table", "IMAGE");
									param.put("value1", fileName.substring(0,(fileName.indexOf("."))));		
									param.put("value2", fileName.substring((fileName.indexOf(".")+1),fileName.length()));	
									System.out.println("6.5 파일네임 "+fileName.substring(0,(fileName.indexOf(".")-1)));
									param.put("value3", ((MemberBean) request.getSession().getAttribute("user")).getMemId());		
								System.out.println("7. 파일업로드 성공입니다 확장자: "+param.get("value2"));
									ImageServiceImpl.getInstance().add(param);
									// 이미지테이블에 ID, IMAGE NAME, EXT 확장자 저장 
								}else {
									System.out.println("파일업로드 실패 ");
								}
							}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //boolean이 true면 이어쓰기한다는거
				
				System.out.println("--10--");
				//Carrier.foward(request, response);
				Carrier.redirect(request, response, "/member.do?action=retrieve&page=retrieve");
				break;
		case REMOVE : 
		
			Carrier.redirect(request, response, "/member.do?action=move&page=login");
		
			break;
/*		case SEARCH : 
			Carrier.redirect(request, response, "/member.do?action=move&page=searchTeamResult");
			break;*/
		case RETRIEVE : //하나만 가져오는s거 
			Carrier.foward(request, response);
			break;
		case MOVE : 
			/*	request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp")
				.forward(request, response);*/
				System.out.println("므브");
				Carrier.foward(request, response);
				break;
	/*	case COUNT : 
			System.out.println(
					MemberServiceImpl.getInstance().countMember()
					);
			break;*/
		case LOGIN : 
			System.out.println("로그인진입");
			if(request.getAttribute("match").equals("TRUE")) {
				/*request.getSession()
				.setAttribute("user", request.getAttribute("user"));*/ //반복제거
				/*Carrier.foward(request,response);*/
				Carrier.redirect(request, response, "/member.do?action=move&page=retrieve");
				//왜 로그인커맨드에서 안하고 여기서 하는걸까? 
			}else {
				Carrier.redirect(request, response, "/member.do?action=move&page=login");
			}
			break;
		
		default: break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

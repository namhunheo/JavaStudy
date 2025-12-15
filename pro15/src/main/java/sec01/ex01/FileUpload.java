package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		File currentDirPath = new File("D:\\fhile_repo");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath); //첨부파일 저장할 경로
		factory.setSizeThreshold(1024*1024); // 용량제한
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List items = upload.parseRequest(request);
			for (int i=0; i<items.size(); i++) {
                FileItem fileItem = (FileItem) items.get(i);
                if (fileItem.isFormField()) { // 파라미터면
                    System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
                } else { //첨부파일
                    System.out.println("매개변수이름:" + fileItem.getFieldName());
                    System.out.println("파일이름:" + fileItem.getName());
                    System.out.println("파일크기:" + fileItem.getSize() + "bytes");
                    
                    if (fileItem.getSize() > 0) {
                        int idx = fileItem.getName().lastIndexOf("\\"); //윈도우
                        if (idx == -1) { // 윈도우 제외
                            idx = fileItem.getName().lastIndexOf("/");
                        }
                        // idx 기준으로 파일명
                        // D:\java\workspace\abc.jpg
                        String fileName = fileItem.getName().substring(idx + 1);
                        File uploadFile = new File(currentDirPath + "\\" + fileName);
                        fileItem.write(uploadFile); // 디스크에 저장
                    }
                }
			}
        } catch (Exception e) {
            e.printStackTrace();
		}
	}
}

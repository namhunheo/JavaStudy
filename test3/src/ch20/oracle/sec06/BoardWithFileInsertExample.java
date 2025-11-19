package ch20.oracle.sec06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWithFileInsertExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 커넥션객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
			System.out.println("연결 성공");
			
			// PreparedStatement
			String sql = "INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) ";
			sql += " VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, sysdate, ?, ?)";
			pstmt = conn.prepareStatement(sql, new String[] {"bno"}); // 미리 준비
			// ? 자리에 값을 대입
			pstmt.setString(1, "눈 오는 날3");
			pstmt.setString(2, "함박눈이 내려요.");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "snow.jpg");
			pstmt.setBlob(5, BoardWithFileInsertExample.class.getResourceAsStream("test.png"));
			int result = pstmt.executeUpdate(); // 실행(등록한 개수 리턴)
			System.out.println("result:"+result);
			
			if (result == 1) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int bno = rs.getInt(1);
					System.out.println("저장된 bno: "+bno);
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();}catch(Exception e) {}
			try {pstmt.close();}catch(Exception e) {}
			if (conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (Exception e) {}
			}
		}
	}

}
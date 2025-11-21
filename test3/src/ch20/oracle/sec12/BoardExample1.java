package ch20.oracle.sec12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BoardExample1 {
	
	// 필드
	private Scanner scanner = new Scanner(System.in);
	private Connection conn;
	
	// 생성자
	BoardExample1() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
	}
	
	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("-----------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-----------------------------------------------------------");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM boards ORDER BY bno DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Board b = new Board();
				b.setBno(rs.getInt("bno"));
				b.setBtitle(rs.getString("btitle"));
				b.setBcontent(rs.getString("bcontent"));
				b.setBwriter(rs.getString("bwriter"));
				b.setBdate(rs.getDate("bdate"));
				
				System.out.printf("%-6s%-12s%-16s%-40s\n",
						b.getBno(), b.getBwriter(), b.getBdate(), b.getBtitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();}catch(Exception e) {}
			try {pstmt.close();}catch(Exception e) {}
		}
		mainMenu();
	}
	
	public void mainMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		System.out.println();
		
		switch(menuNo) {
		case "1" -> create();
		case "2" -> read();
		case "3" -> clear();
		case "4" -> exit();
		}
	}
	
	public void create() {
		Board b = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목: ");
		b.setBtitle(scanner.nextLine());
		System.out.print("내용: ");
		b.setBcontent(scanner.nextLine());
		System.out.print("작성자: ");
		b.setBwriter(scanner.nextLine());
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if ("1".equals(menuNo)) {
			PreparedStatement pstmt = null;
			try {
				String sql = "INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate)" +
						" VALUES (SEQ_BNO.NEXTVAL, ?, ?, ? , SYSDATE)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,  b.getBtitle());
				pstmt.setString(2,  b.getBcontent());
				pstmt.setString(3,  b.getBwriter());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			} finally {
				try {pstmt.close();}catch(Exception e) {}
			}
		}
		
		
		list();
	}
	
	public void read() {
		System.out.println("[게시물 읽기]");
		System.out.print("bno: ");
		int bno = Integer.parseInt(scanner.nextLine());
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM boards WHERE bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Board b = new Board();
				b.setBno(rs.getInt("bno"));
				b.setBtitle(rs.getString("btitle"));
				b.setBcontent(rs.getString("bcontent"));
				b.setBwriter(rs.getString("bwriter"));
				b.setBdate(rs.getDate("bdate"));
				System.out.println("############");
				System.out.println("번호: " + b.getBno());
				System.out.println("제목: " + b.getBtitle());
				System.out.println("내용: " + b.getBcontent());
				System.out.println("작성자: " + b.getBwriter());
				System.out.println("날짜: " + b.getBdate());
				System.out.println("----------------------");
				System.out.println("보조 메뉴 : 1.Update | 2.Delete | 3.List");
				System.out.print("메뉴 선택: ");
				String menuNo = scanner.nextLine();
				System.out.println();
				
				if ("1".equals(menuNo)) {
					update(b);
				} else if ("2".equals(menuNo)) {
					delete(b);
				}
				
				System.out.println("############");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		} finally {
			try {rs.close();}catch(Exception e) {}
			try {pstmt.close();}catch(Exception e) {}
		}
		
		list();
	}
	
	public void update(Board b) {
		System.out.println("[수정 내용 입력]");
		System.out.print("제목: ");
		b.setBtitle(scanner.nextLine());
		System.out.print("내용: ");
		b.setBcontent(scanner.nextLine());
		System.out.print("작성자: ");
		b.setBwriter(scanner.nextLine());
		
		System.out.println("--------------------------------------");
		System.out.println("보조 메뉴 : 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if ("1".equals(menuNo)) {
			PreparedStatement pstmt = null;
			try {
				String sql = "UPDATE boards SET btitle=?, bcontent=?, bwriter=? WHERE bno=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, b.getBtitle());
				pstmt.setString(2, b.getBcontent());
				pstmt.setString(3, b.getBwriter());
				pstmt.setInt(4, b.getBno());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			} finally {
				try {pstmt.close(); }catch(Exception e) {}
			}
		}
	}
	
	public void delete(Board b) {
		
		PreparedStatement pstmt = null;
		try {
			String sql = "DELETE FROM boards WHERE bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBno());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		} finally {
			try {pstmt.close(); }catch(Exception e) {}
		}
	}
	
	public void clear() {
		System.out.println("[게시물 전체 삭제]");
		System.out.println("--------------------------------------");
		System.out.println("보조 메뉴 : 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if ("1".equals(menuNo)) {
			PreparedStatement pstmt = null;
			try {
				String sql = "TRUNCATE TABLE boards";
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			} finally {
				try {pstmt.close(); }catch(Exception e) {}
			}
		}
		list();
	}
	
	public void exit() {
		if (conn != null) {
			try { conn.close(); }catch(Exception e) {}
		}
		System.out.println("** 게시판 종료 **");
		System.exit(0);
	}

	public static void main(String[] args) {
		BoardExample1 be = new BoardExample1();
		be.list();
	}

}
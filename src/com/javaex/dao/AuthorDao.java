package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.AuthorVo;

public class AuthorDao {
	
	public int insert(AuthorVo authorVo) {//클래스불르고 별명지음
		int count=-1;//insert실패하면 -1줘
		String name=authorVo.getAuthorName();//작가명
		String desc=authorVo.getAuthorDesc();//작가정보
		//0. import java.sql.*;
				Connection conn=null;
				PreparedStatement pstmt=null;

				try {
					//1. JDBC 드라이버 (Oracle) 로딩
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//2. Connection 얻어오기
					String url="jdbc:oracle:thin:@localhost:1521:xe";
					conn=DriverManager.getConnection(url,"webdb","webdb"); //연결정보갖고있음
					System.out.println("접속성공");
					
					//3. SQL문 준비 / 바인딩 / 실행
					String query= "INSERT INTO author VALUES(seq_author_id.nextval,?,?)";
					pstmt=conn.prepareStatement(query);//커리정보 날릴수 있는애
					
					pstmt.setString(1,name);
					pstmt.setString(2,desc);
					count=pstmt.executeUpdate();
					
					// 4.결과처리
					System.out.println(count+"건 정리");
				}catch(ClassNotFoundException e){
					System.out.println("error: 드라이버 로딩 실패-"+ e );
				}catch(SQLException e) {
					System.out.println("error:"+e);
				}finally {
					//5. 자원정리
					try {
						if(pstmt != null) {
							pstmt.close();
						}
						if(conn != null) {
							conn.close();
						}
					}catch(SQLException e) {
						System.out.println("error:"+e);
					}
					
				}
				
		
		return count;
	}

	public List<AuthorVo> select(){//AuthorVo에 오는 항목들 배열 +별명
		
		// 0. import java.sql.*;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				List<AuthorVo> authorlist=new ArrayList<AuthorVo>();
				
				try {
					// 1. JDBC 드라이버 (Oracle) 로딩
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					// 2. Connection 얻어오기
					String url="jdbc:oracle:thin:@localhost:1521:xe";//db가있는 주소@주소:포트:
					conn=DriverManager.getConnection(url,"webdb","webdb"); //연결정보갖고있음
					System.out.println("접속성공");
					
					// 3. SQL문 준비 / 바인딩 / 실행
					String query="select author_id"
							+ ",author_name"
							+ ",author_desc"
							+ " from author";
					pstmt=conn.prepareStatement(query);
					pstmt=conn.prepareStatement(query);
					rs=pstmt.executeQuery(query);
					// 4.결과처리  잘내려가면 T마지막줄이면 F
					while(rs.next()) {
						int authorId=rs.getInt("author_id");//1번째로우에서 컴럼
						String authorName=rs.getString("author_name");
						String authorDesc=rs.getString("author_desc");
						
						AuthorVo vo=new AuthorVo(authorId,authorName,authorDesc);//세개들어가있는팩
						authorlist.add(vo);//아파트한칸에 넣어줘
					}

				} catch (ClassNotFoundException e) {
					System.out.println("error: 드라이버 로딩 실패 - " + e);
				} catch (SQLException e) {
					System.out.println("error:" + e);
				} finally {

					// 5. 자원정리

					try {
						if (pstmt != null) {
							pstmt.close();
						}
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						System.out.println("error:" + e);

					}

				}
		
		return authorlist;//아파트에 모여있는거 뿌려줘
	}

	public void update(AuthorVo authorVo) {
		int authorid=authorVo.getAuthorId();
		String name=authorVo.getAuthorName();
		String desc=authorVo.getAuthorDesc();
		
		//0. import java.sql.*;
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			//1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 얻어오기
			String url="jdbc:oracle:thin:@localhost:1521:xe";//db가있는 주소@주소:포트:
			conn=DriverManager.getConnection(url,"webdb","webdb"); //연결정보갖고있음
			System.out.println("접속성공");
			
			//3. SQL문 준비 / 바인딩 / 실행
			
			//String query= "UPDATE author set author_name='한씨', author_desc='서울' where author_id=2";
			String query= "UPDATE author set author_name=?, author_desc=? where author_id=?";
			
			pstmt=conn.prepareStatement(query);//커리정보 날릴수 있는애
			
			pstmt.setString(1,name);//?,?자리
			pstmt.setString(2,desc);
			pstmt.setInt(3,authorid);
			int count=pstmt.executeUpdate();
			
			// 4.결과처리
			System.out.println(count+"건 정리");
		}catch(ClassNotFoundException e){
			System.out.println("error: 드라이버 로딩 실패-"+ e );
		}catch(SQLException e) {
			System.out.println("error:"+e);
		}finally {
			//5. 자원정리
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("error:"+e);
			}
			
		}
		
	
}

	public void delete(AuthorVo authorVo) {
		int authorid=authorVo.getAuthorId();
		
		//0. import java.sql.*;
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			//1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 얻어오기
			String url="jdbc:oracle:thin:@localhost:1521:xe";//db가있는 주소@주소:포트:
			conn=DriverManager.getConnection(url,"webdb","webdb"); //연결정보갖고있음
			System.out.println("접속성공");
			
			//3. SQL문 준비 / 바인딩 / 실행
			String query= "DELETE FROM author where author_id=?";
			pstmt=conn.prepareStatement(query);//커리정보 날릴수 있는애
			
			pstmt.setInt(1, authorid);
			int count=pstmt.executeUpdate();
			
			// 4.결과처리
			System.out.println(count+"건 정리");
		}catch(ClassNotFoundException e){
			System.out.println("error: 드라이버 로딩 실패-"+ e );
		}catch(SQLException e) {
			System.out.println("error:"+e);
		}finally {
			//5. 자원정리
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("error:"+e);
			}
			
		}
		
	}
}

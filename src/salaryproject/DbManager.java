package salaryproject;

import java.util.Scanner;

import javax.print.attribute.standard.PresentationDirection;

import java.lang.classfile.instruction.ReturnInstruction;
import java.sql.Connection; //데이터베이스와의 연결 클래스
import java.sql.DriverManager;//데이터베이스 드라이버 관리, 연결 설정
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;//sql쿼리를 저장함
import java.sql.Statement;//sql문 실행시 사용됨
import java.text.SimpleDateFormat;

import com.mysql.cj.xdevapi.Result;

import java.sql.SQLException;//오류를 처리하는 클래스

import java.sql.PreparedStatement;//sql쿼리를 컴파일링

public class DbManager {

	private static final String String = null;
	private static final Date Date = null;
	static private String driver = "com.mysql.cj.jdbc.Driver";
	// driver: MySQL JDBC 드라이버의 클래스 이름 저장 변수
	static private String url = "jdbc:mysql://127.0.0.1:3306/Salary?serverTimeZone=UTC";
	// 데이터베이스에 연결하기 위한 주소값
	static private String id = "root";
	// 내가설정한 아이디 비번
	static private String pw = "jys0917@";

	static private Connection conn = null; // 데이터베이스와의 연결을 뜻하는 객체, null로 초기화


	public static Connection getDBConnect() { // 데이터베이스와 연결하여 객체를 생성하는 메서드
		try {
			Class.forName(driver);// 위에 선언한 드라이버
			conn = DriverManager.getConnection(url, id, pw);
			// 설정한 아이디 비번으로 데이터베이스 연결을 실행하는 객

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} // 오류 출력문
		return conn;
	}

}

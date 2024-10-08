package salaryproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalaryRepository {

	static private Connection conn = null; // 데이터베이스와의 연결을 뜻하는 객체, null로 초기화
	static private Statement stmt = null;

	public int recordCount() {

		String sql = "select count(*) as cnt from Salary_List";
		int count = 0;
		try {
			conn = DbManager.getDBConnect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count; // 총 알바생 수
	}

	public List<Salary> searchSalary(String sname) {
		// sql 이름 검색기능 구현
		List<Salary> salaryList = new ArrayList<>();// List : 리스트로 만들어주는 클래스
		// 메서드 타입도 리스트<내가 만든 객체 클래스명 > 로 바꿔주기
		// List<객체 클래스명> 변수이름 = new ArrayList<>(); 리스 선언
		String sql = "select * from Salary_List where name = ?";
		try {
			conn = DbManager.getDBConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sname);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String Name = rs.getString("name");
				String BirthDay = rs.getString("birth");
				int salary = rs.getInt("Salary");
				int workTimes = rs.getInt("worktime");

				int totalSalary = salary * workTimes;

				salaryList.add(new Salary(Name, BirthDay, salary, workTimes, totalSalary));

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salaryList;

	}

	public void amendSalary(String sname, int salary) { // 이름과 시급 동시에 업데이트
		String sql = "update Salary_List set salary = ? where name = ?";
		String sql2 = "update duty_salary set salary = ? where name = ?";

		try {
			conn = DbManager.getDBConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, salary);
			ps.setString(2, sname);

			int editsal = ps.executeUpdate();
			if (editsal > 0) {
				System.out.println(sname + "님의 시급이 " + salary + "원 으로 수정 되었습니다. ");

			} else {
				System.out.println("올바르지 않은 값입니다. ");
			}

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void signUpSalary(String name, int worktime) { // 샐러리 테이블만 업데이트
		String sql = "update Salary_List set worktime = ? where name = ?";

		try {
			conn = DbManager.getDBConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, worktime);
			ps.setString(2, name);

			int times = ps.executeUpdate();
			if (times > 0) {
				System.out.println(name + "님의 일한 시간이 " + worktime + "으로 변경/등록되었습니다. ");
			} else {
				System.out.println("정확한 시간을 입력해주세요");
			}

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addSalary(String name, String birth, int salary) { // 샐러리 테이블
		String sql = "insert into Salary_List (name,birth,Salary) values (?,?,?)";
		try {
			conn = DbManager.getDBConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, birth);
			ps.setInt(3, salary);

			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 알바생 두 테이블에서 동시 삭제
	public void resignSalary(String name) {
		String sql = "DELETE from Salary_List where name = ? ";

		try {
			conn = DbManager.getDBConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);

			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/// tax 메뉴 //
	public List<taxSalary> taxSalary(String name) { // 알바생 별 세금 떼는 정보 조회
		List<taxSalary> taxList = new ArrayList<>();
		String sql = "select * from duty_salary where name =? ";
		try {
			conn = DbManager.getDBConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String Name = rs.getString("name"); // 이름
				String insurance = rs.getString("insurance"); // 세금 떼는 정보 , 현금, 특이사항
				double tax = rs.getDouble("duty"); // 세금 뗴는 퍼센트
				int salary = rs.getInt("Salary"); // 원래 시급
				
				double sum = tax/100;
				
				int afterSalary = (int) (salary - (salary *sum)); // 세금을 뗀 순수 시급

				taxList.add(new taxSalary(Name, insurance, tax, salary, afterSalary));

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taxList;
	}

	public void amendTax(String tname, double tax) {
		String sql = "update duty_salary set duty = ? where name = ?";
		try {
			conn = DbManager.getDBConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, tax);
			ps.setString(2, tname);

			int editduty = ps.executeUpdate();
			if (editduty > 0) {
				System.out.println(tname + "님의 세율이 " + tax + "% 으로 수정 되었습니다. ");

			} else {
				System.out.println("올바르지 않은 값입니다. ");
			}

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addSalaryTax(String tname, String insura, double tax, int salary) {
		String sql = "insert into duty_salary (name,insurance,duty,Salary) values (?,?,?,?)";
		try {
			conn = DbManager.getDBConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tname);
			ps.setString(2, insura);
			ps.setDouble(3, tax);
			ps.setInt(4, salary);

			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void afterTaxSalary(String name) {
		String sql = "select * from duty_salary as d left join Salary_List as s on d.name = s.name where d.name = ?";
		try {
			conn = DbManager.getDBConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String sname = rs.getString("name");
				double stax = rs.getDouble("duty");// 3.3
				int ssalary = rs.getInt("Salary");
				int sworktime = rs.getInt("worktime");

				double sum = stax / 100;// 0.033
				int afterTotal = (int) (ssalary * (1 - sum)) * sworktime;

				System.out.println(sname + "님의 이번주 입금 예정 금액은 " + afterTotal + "(" + stax + "%" + ")" + "원 입니다.");
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("세금 설정이 되지 않은 직원입니다. ");
			e.printStackTrace();
		}

	}

	public void allfecthSalary() {
		String sql = "select * from duty_salary as d left join Salary_List as s on d.name = s.name";
		try {
			conn = DbManager.getDBConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String sname = rs.getString("name");// 이름
				String birth = rs.getString("birth");// 생년월일
				String insura = rs.getString("insurance");// 세금 특이사항
				double stax = rs.getDouble("duty");// 떼는 세율
				int ssalary = rs.getInt("Salary");// 시급

				System.out.println("1. 이름 : " + sname + "\n" + "2. 생년월일 : " + birth + "\n" + "3. 세금 특이사항 :" + insura
						+ "\n" + "4. 떼는 세율 : " + stax + "\n" + "5. 시급 : " + ssalary + "\n" + "   ");
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

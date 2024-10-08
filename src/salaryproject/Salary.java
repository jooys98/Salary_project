package salaryproject;

import java.util.Date;

import javax.management.loading.PrivateMLet;

public class Salary {

	private String name; // 이름
	private String birth; // 생년월일
	private int salary; // 시급
	private int worktime; // 일한 시간
	private int totalSalary;

	public Salary(String pname, String pbirth, int psalary, int pworktime, int ptotalSalary) {
		this.name = pname;
		this.birth = pbirth;
		this.salary = psalary;
		this.worktime = pworktime;
		this.totalSalary = ptotalSalary;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDate() {
		return birth;
	}

	public void setString(String date) {
		this.birth = date;
	}

	public int getworktime() {
		return worktime;
	}

	public void setworktime(int worktime) {
		this.worktime = worktime;
	}

	public int getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}

	@Override
	public String toString() {
		return "이름 :" + name + "\n" + "생년월일 :" + birth + "\n" + "시급 :" + salary + "\n" + "일한시간 :" + worktime + "시간"
				+ "\n" + "이번주 주급 :" + totalSalary + "원";
	} // 객체를 출력하고 싶을떄 쓰는 메서드

}

package salaryproject;

import java.security.PublicKey;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class menuManager { // 메뉴 1번 직원 검색하여 주급 확인하기
	SalaryRepository salaryRepository = new SalaryRepository();

	public void receipt(String name) {

		System.out.println("<<" + name + "님의 근무 기록을 조회중입니다." + ">>");
		List<Salary> salist = salaryRepository.searchSalary(name);
		if (salist.isEmpty()) {
			System.out.println("(ノ；Д；)ノ" + name + "님의 근무 기록을 확인 할 수 없습니다.");
		} else {
			for (int i = 0; i < salist.size(); i++) {
				System.out.println("ヽ⎝⍢⎠" + name + "님의 이번주 근무 기록");
				System.out.println(salist.get(i));
			}
		}
	}

	public  void editSalary(String name, int salary) {
		List<Salary> salist = salaryRepository.searchSalary(name);
		if (salist.isEmpty()) {
			System.out.println("(ノ；Д；)ノ" + "존재하지 않는 이름입니다.");
		} else {
			salaryRepository.amendSalary(name, salary);
		}
	}

	public  void registrationSalary(String name, int worktime) {
		List<Salary> salist = salaryRepository.searchSalary(name);
		if (salist.isEmpty()) {
			System.out.println("(ノ；Д；)ノ" + "존재하지 않는 이름입니다.");
		} else {
			salaryRepository.signUpSalary(name, worktime);
		}
	}

	public  void addsalary(String name, String birth, int salary) {
		salaryRepository.addSalary(name, birth, salary);
	}

	public void deteleSalary(String name) {
		List<Salary> salist = salaryRepository.searchSalary(name);
		if (salist.isEmpty()) {
			System.out.println("(ノ；Д；)ノ" + "존재하지 않는 이름입니다.");
		} else {
			salaryRepository.resignSalary(name);
			System.out.println(name + "님 퇴사 완료 ");
			System.out.println("         ヽ(ノ；Д；)ノ bye ");
			System.out.println("               .       ");
			System.out.println("               .       ");
			System.out.println("               .       ");
			System.out.println("          ");
			System.out.println(".                       |");
			System.out.println("　╲　　　　　　　　　　         　╱");
			System.out.println("　　　　　　　　　         /");
			System.out.println("　　　╲　　　　　　　　      ╱");
			System.out.println("　　╲　　   good bye...　╱");
			System.out.println(" - - " + "      " + name + "      " + "- - - ");
			System.out.println("　　╱　   　　         ╲");
			System.out.println("　╱　　/                 . ");
			System.out.println("　　╱　　　　　　　　     ╲");
			System.out.println("　　　　　/　    |　　　");
			System.out.println("　　　　　　　 .");
		}
	}

	public  void lookSalary() {
		System.out.println(" ヽ⎝⍢⎠ " + " 직원 리스트를 출력 중입니다 . . .");
		salaryRepository.allfecthSalary();
	}
}
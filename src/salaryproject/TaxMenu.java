package salaryproject;

import java.util.List;

public class TaxMenu {

	SalaryRepository repository = new SalaryRepository();
	
	public void taxSalary(String name) { // 직원의 세금 정보 검색 조회

		List<taxSalary> list = repository.taxSalary(name);
		if (list.isEmpty()) {
			System.out.println("(ノ；Д；)ノ" + "존재하지 않는 이름입니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("ヽ⎝⍢⎠" + name + "님의 세후 금액 정보 ");
				System.out.println(list.get(i));
			}
	}
	}

	public void addTexSalary(String name, String insura, double tax, int salary) {
		// 직원 세금정보 새로입력
		repository.addSalaryTax(name, insura, tax, salary);
		System.out.println("ヽ⎝⍢⎠" + name + "님의 정보가 추가 되었습니다");
	}
	
	public void totalTaxSalary(String name) {
		List<taxSalary> list = repository.taxSalary(name);
		if (list.isEmpty()) {
			System.out.println("(ノ；Д；)ノ" + "존재하지 않는 이름입니다.");
		} else {
			repository.afterTaxSalary(name);
		}
	}
}

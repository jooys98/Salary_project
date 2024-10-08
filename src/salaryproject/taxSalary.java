package salaryproject;

public class taxSalary {

	private String tname;
	private String insura;
	private double tax; // 세금
	private int salary; // 시급
	private int afterTax; // 세후 시급

	public taxSalary(String pname, String pinsura, double ptax, int psalary, int pafterTax) {
		this.tname = pname;
		this.insura = pinsura;
		this.afterTax = pafterTax;
		this.salary = psalary;
		this.tax = ptax;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getInsura() {
		return insura;
	}

	public void setInsura(String insura) {
		this.insura = insura;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public int getAfterTax() {
		return afterTax;
	}

	public void setAfterTax(int afterTax) {
		this.afterTax = afterTax;
	}

	@Override
	public String toString() {
		return "1. 이름 : " + tname + "\n" + "2. 세금 특이사항 :" + insura + "\n" + "3. 세율 : " + tax + " % " + "\n" + "4. 시급 : "
				+ salary + "원 " + "\n" + "5. 세후 시급 : " + afterTax + "원 ";
	}

}

package salaryproject;

import java.util.Scanner;
import java.util.List;

public class TaxSalaryManager {
	DbManager manager = new DbManager();
	SalaryRepository repository = new SalaryRepository();
	TaxMenu taxMenu = new TaxMenu();
	
	public void TaxSalaryManager() {
		while (true) {
			System.out.println("                      ");
			System.out.println("         ______               __            ");
			System.out.println("  ____ _/ __/ /____  _____   / /_____ __  __");
			System.out.println(" / __ `/ /_/ __/ _ \\/ ___/  / __/ __ `/ |/_/");
			System.out.println("/ /_/ / __/ /_/  __/ /     / /_/ /_/ />  <  ");
			System.out.println("\\__,_/_/  \\__/\\___/_/      \\__/\\__,_/_/|_| ");
			System.out.println(" ");
			System.out.println("        ヽ₍ ᐢ๑-˔-ᐢ₎ ♡    ");
			System.out.println("                      ");
			System.out.println("1. 직원별 세금 설정 " + "\n" + "2. 직원별 세금 정보 / 세후 시급 조회 " +"\n" + "3. 직원 별 세후 입금 예정 금액 조회 " + "\n" + "4. 메인 메뉴로 돌아가기");

			Scanner s = new Scanner(System.in);
			int choice = s.nextInt();

			switch (choice) {
			case 1:
				Scanner s1 = new Scanner(System.in);
				System.out.println("1. 직원별 세금 설정 " + "ヽ⎝⍢⎠");
				System.out.println(" ");
				String art = "       .--.\n" + "     .'_\\/_'.\n" + "     '. /\\ .'\n" + "       \"||\"\n"
						+ "         ||\n" + "     .--.||.--.\n" + "    /  _     _  \\\n" + "   |  (_)   (_)  |\n"
						+ "   |      |      |\n" + "    \\  \\_____/  /\n" + "     '._     _.'\n" + "        '---'";

				System.out.println(art);
				System.out.println("                      ");
				System.out.println("        ヽ₍ ᐢ๑-˔-ᐢ₎ ♡    ");
				System.out.println("                      ");
				System.out.println("ヽ⎝⍢⎠" + "직원의 이름을 입력하세요 : ");
				String name1 = s1.nextLine();
				List<Salary> salist = repository.searchSalary(name1);
				if (salist.isEmpty()) {
					System.out.println("(ノ；Д；)ノ" + "존재하지 않는 이름입니다.");
				} else {
					System.out.println("ヽ⎝⍢⎠" + name1 + "님의 세액정보 , 특이사항 을 입력하세요 ");
					String ins = s1.nextLine();
					System.out.println("ヽ⎝⍢⎠" + name1 + "님의 세율을 입력하세요 ");
					double tax = s1.nextDouble();
					System.out.println("ヽ⎝⍢⎠" + name1 + "님의 시급을 입력하세요 ");
					int sal = s1.nextInt();
					taxMenu.addTexSalary(name1, ins, tax, sal);

				}
				break;

			case 2:

				Scanner s2 = new Scanner(System.in);
				System.out.println("2. 직원별 세금 정보 / 세후 시급 조회" + "ヽ⎝⍢⎠");
				System.out.println(" ");
				String art1 = "        .------.\n" + "      .'        '.\n" + "     /   $ 100    \\\n"
						+ "    |   (•‿•)     |\n" + "     \\            /\n" + "      '._      _.'\n"
						+ "         '----'";

				System.out.println(art1);
				System.out.println("                      ");
				System.out.println("        ヽ₍ ᐢ๑-˔-ᐢ₎ ♡    ");
				System.out.println("                      ");
				System.out.println("ヽ⎝⍢⎠" + "조회할 직원의 이름을 입력하세요 : ");
				String name2 = s2.nextLine();
				System.out.println("ヽ⎝⍢⎠" + name2 + " 님의 세후 시급 정보를 조회합니다 . . . ");
				System.out.println(" ");
				taxMenu.taxSalary(name2);
				break;
				
				
			case 3 : 
				Scanner s3 = new Scanner(System.in);
				System.out.println("3. 직원 별 세후 입금 예정 금액 조회 ");
				System.out.println(" ");
				String art2 = "        .------.\n" + "      .'        '.\n" + "     /   $ 100    \\\n"
						+ "    |   (•‿•)     |\n" + "     \\            /\n" + "      '._      _.'\n"
						+ "         '----'";

				System.out.println(art2);
				System.out.println("                      ");
				System.out.println("        ヽ₍ ᐢ๑-˔-ᐢ₎ ♡    ");
				System.out.println("                      ");
				System.out.println("ヽ⎝⍢⎠" + "조회할 직원의 이름을 입력하세요 : ");
				String name3 = s3.nextLine();
				System.out.println("ヽ⎝⍢⎠" + name3 + " 님의 이번주 입금 예정 금액을 조회합니다 . . . ");
				System.out.println(" ");
				taxMenu.totalTaxSalary(name3);
				break;
				
				
				
			case 4 : 
				System.out.println("4. 메인 메뉴로 돌아가기 ");
				System.out.println(" ");
				String art3 = "        .------.\n" + "      .'        '.\n" + "     /   $ 100    \\\n"
						+ "    |   (•‿•)     |\n" + "     \\            /\n" + "      '._      _.'\n"
						+ "         '----'";
		        System.out.println(art3);
		        System.out.println( " 로딩중 입니다 . . .");
		        System.out.println(" ");
		        SalaryApp.salaryApp();
			}

		}
	}


	
}

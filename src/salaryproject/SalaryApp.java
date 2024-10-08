package salaryproject;

import java.util.Date;
import java.util.Scanner;

public class SalaryApp {

	public static void salaryApp() {
		// TODO 주급,월급 계산 앱 _사장님 ver
		// 알바생 별로 시급 , 일한 시간 다르게 설정 가능

//		DbManager.initDBConnect();
		menuManager manager = new menuManager();
		TaxSalaryManager taxSalaryManager = new TaxSalaryManager();

		System.out.println("          두다다다다다다다");
		System.out.println("          두다다다다다다다");
		System.out.println("         알바생 돈주러 가즈아");
		System.out.println("　           (∩`・ω・)");
		System.out.println("           ＿/_ミつ/￣￣￣/");
		System.out.println("　　           ＼/＿＿＿/ ");
		System.out.println("              .       ");
		System.out.println("              .       ");
		System.out.println("              .       ");
		System.out.println("      ");
		System.out.println("    __          __     _        ");
		System.out.println("   / /   ___   / /_   ( )  _____");
		System.out.println("  / /   / _ \\/ __/    |/  / ___/");
		System.out.println(" / /___/  __/  /_        (__  ) ");
		System.out.println("/_____/_\\___/__/        /____/  ");
		System.out.println("                               ");

		System.out.println("               __                ");
		System.out.println("   _________ _/ /___ ________  __");
		System.out.println("  / ___/ __ `/ / __ `/ ___/ / / /");
		System.out.println(" (__  ) /_/ / / /_/ / /  / /_/ / ");
		System.out.println("/____/\\__,_/_/\\__,_/_ \\__,  / /  ");
		System.out.println("                        /____/   ");

		System.out.println("、ヽ｀、ヽ｀｀、ヽ｀、ヽ｀ヽ｀、、ヽ｀ヽ｀、ヽ｀、ヽ｀");
		System.out.println("｀、ヽ｀ヽ｀ヽ｀、 ｀、、ヽ｀ヽ｀、ヽ｀｀、");
		System.out.println("｀ヽ｀、｀｀、ヽ｀、ヽ｀ヽ｀、、ヽ｀ヽヽ｀、ヽ｀｀、ヽ｀ ");
		System.out.println("、ヽ｀、ヽ、｀｀사장님 환영합니다!、ヽ｀、ヽ｀｀、ヽ｀、｀");
		System.out.println("、ヽ｀、ヽ｀｀、ヽ｀、ヽ｀ヽ｀、、ヽ｀ヽ｀、ヽ｀、ヽ｀");
		System.out.println("、ヽ｀、ヽ｀｀、ヽ｀、ヽ｀ヽ｀、、ヽ｀ヽ｀、ヽ｀、ヽ｀");
		while (true) {
			System.out.println("              .       ");
			System.out.println("              .       ");
			System.out.println("              .       ");
			System.out.println("                     ");
			System.out.println("‌ ₍ ᐢ๑-˔-ᐢ₎ ♡ 한주도 고생하셨습니다‌ ₍ ᐢ๑-˔-ᐢ₎ ♡ " + "\n" + "｀、ヽ｀｀、ヽ메뉴를 선택해주세요!♡｀、ヽ｀｀、ヽ");
			System.out.println("、ヽ｀、ヽ｀｀、ヽ｀｀、ヽ｀、ヽ｀ヽ｀、、ヽ｀ヽ｀、ヽ");
			System.out.println("、ヽ｀、ヽ｀｀、ヽ｀｀、ヽ｀、ヽ｀ヽ｀、、ヽ｀ヽ｀、ヽ");
			System.out.println("1.이번주 주급 / 근무기록 확인하기 " + "\n" + "2. 직원별 시급 설정 / 편집" + "\n" + "3. 직원별 일한 시간 등록/편집 하기 "
					+ "\n" + "4. 새 직원 등록하기/수정" + "\n" + "5. 직원 퇴사" + "\n" + "6. 세금 메뉴" + "\n" + "7. 직원 리스트 전체보기");
			Scanner s = new Scanner(System.in);
			int select = s.nextInt();

			switch (select) {
			case 1:
				Scanner s1 = new Scanner(System.in);
				String s_name = null;
				System.out.println("1 .직원별 주급 / 근무기록 확인하기" + "ヽ⎝⍢⎠");
				System.out.println("                      ");
				System.out.println("   ________              __      _____       __                    ");
				System.out.println("  / ____/ /_  ___  _____/ /__   / ___/____ _/ /___ ________  __    ");
				System.out.println(" / /   / __ \\/ _ \\/ ___/ //_/   \\__ \\/ __ `/ / __ \\/ ___/ / / /    ");
				System.out.println("/ /___/ / / /  __/ /__/ ,<     ___/ / /_/ / / /_/ / /  / /_/ /     ");
				System.out.println("\\____/_/ /_/\\___/\\___/_/|_|   /____/\\__,_/_/\\__,_/_/   \\__, /      ");
				System.out.println("                                                      /____/  ");
				System.out.println("                      ");
				System.out.println("        ヽ₍ ᐢ๑-˔-ᐢ₎ ♡    ");
				System.out.println("                      ");
				System.out.println("ヽ⎝⍢⎠" + "확인하실 직원의 이름을 입력하시오 :");
				s_name = s1.nextLine();

				System.out.println("                      ");
				manager.receipt(s_name);
				break;

			case 2:
				Scanner s2 = new Scanner(System.in);
				String s_name2 = null;
				int editSal = 0;
				System.out.println("2. 직원별 시급 설정/편집" + "ヽ⎝⍢⎠");
				System.out.println("                      ");
				System.out.println("   _____      __  __  _                _____       __                    ");
				System.out.println("  / ___/___  / /_/ /_(_)___  ____ _   / ___/____ _/ /___ ________  __    ");
				System.out.println("  \\__ \\/ _ \\/ __/ __/ / __ \\/ __ `/   \\__ \\/ __ `/ / __ \\/ ___/ / / /    ");
				System.out.println(" ___/ /  __/ /_/ /_/ / / / / /_/ /   ___/ / /_/ / / /_/ / /  / /_/ /     ");
				System.out.println("/____/\\___/\\__/\\__/_/_/ /_/\\__, /   /____/\\__,_/_/\\__,_/_/   \\__, /      ");
				System.out.println("                          /____/                            /____/  ");
				System.out.println("                      ");
				System.out.println("        ヽ₍ ᐢ๑-˔-ᐢ₎ ♡    ");
				System.out.println("                      ");
				System.out.println("ヽ⎝⍢⎠" + "편집하실 직원의 이름을 입력하시오 :");
				s_name2 = s2.nextLine();
				System.out.println("ヽ⎝⍢⎠" + "편집할 시급을 입력하세요 :");
				editSal = s2.nextInt();
				manager.editSalary(s_name2, editSal);
				break;

			case 3:
				Scanner s3 = new Scanner(System.in);
				String s_name3 = null;
				int s_time = 0;
				System.out.println("3. 직원별 일한 시간 등록/편집 하기");
				System.out.println("                      ");
				System.out.println(" _       __           __      _______                    ");
				System.out.println("| |     / /___  _____/ /__   /_  __(_)___ ___  ___  _____");
				System.out.println("| | /| / / __ \\/ ___/ //_/    / / / / __ `__ \\/ _ \\/ ___/");
				System.out.println("| |/ |/ / /_/ / /  / ,<      / / / / / / / / /  __(__  ) ");
				System.out.println("|__/|__/\\____/_/  /_/|_|    /_/ /_/\\_/_/ /_/ /\\___/____/  ");
				System.out.println("                      ");
				System.out.println("        ヽ₍ ᐢ๑-˔-ᐢ₎ ♡    ");
				System.out.println("                      ");
				System.out.println("ヽ⎝⍢⎠" + "등록하실 직원의 이름을 입력해주세요.");
				s_name3 = s3.nextLine();
				System.out.println("ヽ⎝⍢⎠" + "등록/편집할 시간을 입력해주세요.");
				s_time = s3.nextInt();
				manager.registrationSalary(s_name3, s_time);

				break;

			case 4:
				Scanner s4 = new Scanner(System.in);
				String s_name4 = null;
				String birthday = null;
				int newSalary = 0;

				System.out.println("4. 새 직원 등록하기/수정" + "ヽ⎝⍢⎠");
				System.out.println(" _       __     __                        ");
				System.out.println("| |     / /__  / /________  ____ ___  ___ ");
				System.out.println("| | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\");
				System.out.println("| |/ |/ /  __/ / /__/ /_/ / / / / / /  __/");
				System.out.println("|__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/ ");
				System.out.println(" ");
				System.out.println("               __                ");
				System.out.println("   _________ _/ /___ ________  __");
				System.out.println("  / ___/ __ `/ / __ `/ ___/ / / /");
				System.out.println(" (__  ) /_/ / / /_/ / /  / /_/ / ");
				System.out.println("/____/\\__,_/_/\\__,_/_ \\__,  / /  ");
				System.out.println("                        /____/   ");
				System.out.println(" ");
				System.out.println("        ヽ₍ ᐢ๑-˔-ᐢ₎ ♡    ");
				System.out.println("                      ");
				System.out.println("ヽ⎝⍢⎠" + "새로 등록하실 직원의 이름을 입력해주세요 :");
				s_name4 = s4.nextLine();
				System.out.println("ヽ⎝⍢⎠" + "생일을 입력해주세요 :");
				birthday = s4.nextLine();
				System.out.println("ヽ⎝⍢⎠" + "시급을 입력해주세요 :");
				newSalary = s4.nextInt();

				manager.addsalary(s_name4, birthday, newSalary);
				System.out.println(s_name4 + "님이 새로운 근무자로 추가되었습니다.");
				System.out.println("      ┌───────────────┐");
				System.out.println("       Welcome, new Salary !");
				System.out.println("      |  " + "   " + s_name4 + "     |");
				System.out.println("      └───────────────┘");
				System.out.println("　　ᕱ ᕱ ||");
				System.out.println("　 ( ･ω･ ||" + "환영해 ヽ₍ ᐢ๑-˔-ᐢ₎ ♡ ");
				System.out.println("　 /　つΦ");
				break;

			case 5:
				Scanner s5 = new Scanner(System.in);

				System.out.println("5. 직원 퇴사");
				System.out.println("、ヽ｀、ヽ｀｀、ヽ｀｀、ヽ｀、ヽ｀ヽ｀、、ヽ｀ヽ｀、ヽ｀、ヽ｀");
				System.out.println("｀、ヽ｀ヽ｀、、ヽ｀ヽ｀、ヽ(ノ；Д；)ノ ｀、、ヽ｀ヽ｀、ヽ｀｀、");
				System.out.println("｀ヽ｀、ヽ｀、ヽ｀｀、ヽ｀、ヽ｀ヽ｀、、ヽ｀ヽヽ｀、ヽ｀｀、ヽ｀ ");
				System.out.println("   ______                ______           ");
				System.out.println("  / ____/___  ____  ____/ / __ )__  _____ ");
				System.out.println(" / / __/ __ \\/ __ \\/ __  / __  / / / / _ \\");
				System.out.println("/ /_/ / /_/ / /_/ / /_/ / /_/ / /_/ /  __/");
				System.out.println("\\____/\\____/\\____/\\__,_/_____/_\\__, /\\___/ ");
				System.out.println("                             /____/       ");
				System.out.println("(ノ；Д；)ノ" + "퇴사하는 직원 이름을 입력해주세요");

				String s_name5 = s5.nextLine();
				manager.deteleSalary(s_name5);

				break;

			case 6:
				Scanner s6 = new Scanner(System.in);
				System.out.println(" ヽ₍ ᐢ๑-˔-ᐢ₎ ♡ " + "세금 설정/세후 금액 조회 메뉴로 이동합니다. . .");

				taxSalaryManager.TaxSalaryManager();
				// 세금 메뉴 따로 만들어서 호출하기

			case 7:
				System.out.println("7. 직원 리스트 전체보기" + "ヽ⎝⍢⎠");
				System.out.println("    __                __      _____       __                    ");
				System.out.println("   / /   ____  ____  / /__   / ___/____ _/ /___ ________  __    ");
				System.out.println("  / /   / __ \\/ __ \\/ //_/   \\__ \\/ __ `/ / __ `/ ___/ / / /    ");
				System.out.println(" / /___/ /_/ / /_/ / ,<     ___/ / /_/ / / /_/ / /  / /_/ /     ");
				System.out.println("/_____\\/____/\\____/_/|_|   /____/\\__,_/_/\\__,_/_/   \\__, /      ");
				System.out.println("                                                   /____/      ");
				System.out.println(" ");
				System.out.println("        ヽ₍ ᐢ๑-˔-ᐢ₎ ♡    ");
				System.out.println("                      ");
				manager.lookSalary();
			}
		}
	}

}

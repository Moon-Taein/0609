import java.util.Scanner;

public class Main15 {

	public static void main(String[] args) {
		ReadWriteCSV rwCSV = new ReadWriteCSV();
		rwCSV.readCSV();

		boolean condition = true;
		while (condition) {
			Scanner scan = new Scanner(System.in);
			System.out.println(("1. 읽기\n2. 수정\n3. 삭제\n4. 추가\n5. 종료"));
			int number = scan.nextInt();
			scan.nextLine();

			switch (number) {
			case 1:
				// 읽기
				rwCSV.readList();
				break;
			case 2:
				// 수정
				rwCSV.modifyRow();
				break;
			case 3:
				// 삭제
				rwCSV.deleteRow();
				break;
			case 4:
				// 추가
				rwCSV.appendRow();
				break;
			case 5:
				// 종료
				rwCSV.writeCSV();
				condition = false;
				break;
			}
		}
	}
}
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class ReadWriteCSV {
	private List<List> list; // csv파일이 저장된 리스트
	private final static Scanner SCAN = new Scanner(System.in);

	// csv 파일 불러와서 읽기
	public void readCSV() {
		Path p = Paths.get("d:\\filetest\\country.csv");
		File file = new File(p.toUri());

		list = new ArrayList<>();
		try (Reader in = new FileReader(file)) {
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);
			for (CSVRecord record : records) {
				list.add(record.toList());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 읽기
	public void readList() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	// 수정
	public void modifyRow() {
		System.out.println("수정을 원하는 Code를 입력하세요");
		String code = SCAN.nextLine();
		int target = FindRowInList(code);
		System.out.println("1. Area\n2. capital\n3. population");
		int modTarget = SCAN.nextInt();
		SCAN.nextLine();
		System.out.println("바꿀 내용을 입력하세요");
		String modContent = SCAN.nextLine();
		list.get(target).set(modTarget + 1, modContent);

	}

	// 수정할 Row 찾기
	public int FindRowInList(String str) {
		int target = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get(0).equals(str.toUpperCase())) {
				target = i;
				return target;
			}
		}
		return 0;
	}

	// 삭제
	public void deleteRow() {
		System.out.println("삭제할 코드를 입력하세요");
		String target = SCAN.nextLine();
		int delTarget = FindRowInList(target);
		list.remove(delTarget);
	}

	// 추가
	public void appendRow() {
		List<String> tempList = new ArrayList<>();
		System.out.println("추가할 코드를 입력하세요(입력예: \"code, country, area, capital, population\"");
		String code = SCAN.nextLine();
		String[] codeList = code.split(", ");
		for (int i = 0; i < codeList.length; i++) {
			tempList.add(codeList[i]);
		}
		list.add(tempList);
	}

	// 저장
	public void writeCSV() {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("d:\\filetest\\country.csv"));
				CSVPrinter csvPrinter = new CSVPrinter(writer,
						CSVFormat.DEFAULT.withHeader("code", "country", "area", "capital", "population"));) {

			for (int i = 0; i < list.size(); i++) {
				csvPrinter.printRecord(list.get(i));
			}
			csvPrinter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

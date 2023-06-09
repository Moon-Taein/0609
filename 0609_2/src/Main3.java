import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main3 {
	// 학생 한 명의 정보를 파일에 기록하는 메소드
	public static void writeToFile(Student s) {
		URL url = Main3.class.getClassLoader().getResource("student.txt");
		PrintWriter pw = null;
		try {
			File file = new File(url.toURI());
			pw = new PrintWriter(new FileWriter(file, true));

			pw.printf("%s,%d,%d,%d\n", s.getName(), s.getKor(), s.getMath(), s.getEng());

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}

	public static List<Student> readAll() {
		InputStream is = Main3.class.getClassLoader().getResourceAsStream("student.txt");
		BufferedReader br = null;
		List<Student> stList = new ArrayList<>();
		try {
			br = new BufferedReader(new InputStreamReader(is));
			// 모든 줄 읽기
			String line;
			while ((line = br.readLine()) != null) {
				// 한 줄의 문자열 정보를 -> 학생 정보로 변환하기 콤마를 구분자로
				Student s = parseStudent(line);
				// 리스트에 추가
				stList.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// 리스트 반환
		return stList;

	}

	private static Student parseStudent(String line) {
		String[] arr = line.split(",");
		String name = arr[0];
		int kor = Integer.parseInt(arr[1]);
		int math = Integer.parseInt(arr[2]);
		int eng = Integer.parseInt(arr[3]);
		return new Student(name, kor, math, eng);
	}

	public static void main(String[] args) {
		Student s1 = new Student("길동", 30, 40, 50);
		Student s2 = new Student("둘리", 60, 70, 80);

		writeToFile(s1);
		writeToFile(s2);

		System.out.println(readAll());
	}
}
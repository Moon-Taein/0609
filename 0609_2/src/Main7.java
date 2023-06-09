import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main7 {
	public static void main(String[] args) {
		// 자바는 파일들을 객체의 형태로 저장을 많이한다.
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("d:\\filetest\\student.ser")));

			// java.io.NotSerializableException: Student - 직렬화 가능하지 않음
			oos.writeObject(new Student("길동", 30, 40, 50));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}

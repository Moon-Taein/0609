import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

// JAVA 시스템 에서만 사용할수있는 Object*Stream; 객체를 쓰고 읽고
// 클래스의 필드가 추가되거나 삭제, 수정될 경우 제대로 작동을 안함
public class Main8 {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(new File("d:\\filetest\\student.ser")));

			Student s = (Student) ois.readObject();
			System.out.println(s);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

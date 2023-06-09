import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main9 {
	public static void main(String[] args) {
		// try-with-resource
		// try ( 사용할 자원 생성 )
		// 읽고 쓰는 구문을 줄이는 방법
		// 자동으로 InputStream 이 close() 된다
		// FileInputStream fis = null; 하고 괄호 안에 쓰는거 java se8 에서는 불가능
		try (FileInputStream fis = new FileInputStream(new File("d:\\filetest\\testoutput.txt"))) {
			fis.read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
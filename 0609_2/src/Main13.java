import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main13 {
	public static void main(String[] args) {
		Path p = Paths.get("d:\\filetest\\niotest\\hello.txt");

		try (BufferedReader br = Files.newBufferedReader(p);) {

		} catch (Exception e) {
			e.printStackTrace();
		}

//		// 파일과 경로 서로 상호에 바꿀수있다.
//		File f = p.toFile();
//		Path p2 = f.toPath();

//		try {
//			// 삭제 완료 -> true, 실패 -> false
//			System.out.println(Files.deleteIfExists(p));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}

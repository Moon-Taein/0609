import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main11 {
	public static void main(String[] args) {
		Path p = Paths.get("d:\\filetest\\niotest\\newfilename.txt");

		try {
			// path 경로를 가져와서 파일을 읽기
			// readAllLines -> 한줄씩 전부 읽어줌
			List<String> lines = Files.readAllLines(p);
			System.out.println(lines);

			byte[] bytes = Files.readAllBytes(p);
			System.out.println(new String(bytes));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
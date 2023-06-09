import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main12 {
	public static void main(String[] args) {
		Path p = Paths.get("d:\\filetest\\niotest\\hello.txt");

		List<String> list = Arrays.asList("안", "녕", "세", "상", "아");

		try {
			Files.write(p, list);
		} catch (IOException e) {
			e.printStackTrace();
		}

//		try {
//			Files.write(p, "안녕세상아ASDASDASD".getBytes());
//			Files.write(p, "HelloWorld".getBytes(), StandardOpenOption.APPEND);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main10 {
	public static void main(String[] args) {
		Path p = Paths.get("d:\\filetest\\origin.txt");
		Path p2 = Paths.get("d:\\", "filetest", "origin.txt");

		Path drive = Paths.get("d:\\");
		Path folder = drive.resolve("filetest");
		Path file = folder.resolve("origin.txt");

		System.out.println(p);
		System.out.println(p2);
		System.out.println(file);

		System.out.println(Files.exists(p));

		Path newFolder = folder.resolve("niotest");
		System.out.println(newFolder);
		System.out.println(Files.exists(newFolder));

//		try {
//			Files.createDirectories(newFolder);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try {
			// Files.copy ( 원본경로, 새경로 );
			Files.copy(p, newFolder.resolve("newfilename.txt"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("복사에 실패하였습니다.");
		}

	}
}
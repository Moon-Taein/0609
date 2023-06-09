import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class Main1 {
	public static void main(String[] args) {
		// ClassLoader
		URL url = Main1.class.getClassLoader().getResource("classroot.txt");
		File file;
		try {
			file = new File(url.toURI());
			System.out.println(file.exists());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main2 {
	public static void main(String[] args) {
		// ClassLoader
		InputStream input = Main1.class.getClassLoader().getResourceAsStream("classroot.txt");

		BufferedReader br = null;
		// inputStream 을 InputStreamReader 로 감싸서 BufferedReader 사용
		try {
			br = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
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
	}
}
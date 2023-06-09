import java.util.Properties;

public class Main4 {
	public static void main(String[] args) {
		// 사용자 폴더 접근
		String userFolder = System.getProperty("user.home");
		System.out.println(userFolder);

		Properties props = System.getProperties();
		System.out.println(props);
	}
}

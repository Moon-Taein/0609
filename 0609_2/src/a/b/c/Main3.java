package a.b.c;

import java.net.URL;

public class Main3 {
	public static void main(String[] args) {
		// url 경로구분자는 /
//		URL url = Main3.class.getClassLoader().getResource("a/a.txt");

		// 현재경로에서 최상위로 이동후 아래로 한계단씩 / 최상위
//		URL url = Main3.class.getResource("/a/a.txt");

		// 현재경로에서 위로 한계단씩 .. 상위, . 현재
		URL url = Main3.class.getResource("../../a.txt");

		System.out.println(url);
	}
}
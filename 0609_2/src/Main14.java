import com.google.gson.Gson;

public class Main14 {
	public static void main(String[] args) {
		Student s = new Student("길동", 30, 40, 50);

		// json 데이터 포맷
		// { "name" : "길동", "kor" : 30, "math" : 40, "eng" : 50 }

		Gson gson = new Gson();

		// Student 객체를 json 형태의 String으로
		String json = gson.toJson(s);
		System.out.println(json);

		String line = "{\"name\":\"길동\",\"kor\":30,\"math\":40,\"eng\":50}";
		// json 형태의 String을 Student 객체 형태로
		Student from = gson.fromJson(line, Student.class);
		System.out.println(from);

//		String json = String.format("{\"name\" : \"%s\"" + ", \"kor\" : %d" + ", \"math\" : %d" + ", \"eng\" : %d}",
//				s.getName(), s.getKor(), s.getMath(), s.getEng());
//
//		System.out.println(json);

		// deserialize 역직렬화
		// json 처리를 위한 외부 라이브러리 사용해보기

	}
}
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Country {
	private String code;
	private String country;
	private int area;
	private String capital;
	private int population;

	public Country(String code, String country, int area, String capital, int population) {
		super();
		this.code = code;
		this.country = country;
		this.area = area;
		this.capital = capital;
		this.population = population;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", country=" + country + ", area=" + area + ", capital=" + capital
				+ ", population=" + population + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + area;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + population;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (area != other.area)
			return false;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (population != other.population)
			return false;
		return true;
	}
}

class CountryManager {
	private CountryCsvFileRepository repo;

	public CountryManager() {
		repo = new CountryCsvFileRepository();
	}

	// 국가 목록 조회
	public void showAll() {
		// 파일 모든 행 읽기
		List<Country> list = repo.getAll();
		for (Country c : list) {
			System.out.println(c);
		}
	}

	// 하나의 국가 추가
	public void add(Country c) {
		// 파일 행 추가

//		list.add(c);
	}
}

class CountryCsvFileRepository {
	private final Path csvFile = Paths.get("country.csv");

	// 파일 모든 행 읽어서 국가 목록으로 변환하여 반환하기
	public List<Country> getAll() {
		// 컨트리 객체 배열 반환
		List<Country> countries = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(csvFile);
			for (int i = 1; i < lines.size(); i++) {
				countries.add(parse(lines.get(i)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return countries;
	}

	private Country parse(String line) {
		String[] split = line.split(",");
		String code = split[0];
		String country = split[1];
		int area = Integer.parseInt(split[2]);
		String capital = split[3];
		int population = Integer.parseInt(split[4]);
		return new Country(code, country, area, capital, population);
	}

	// 하나의 국가를 변환하여 파일에 행으로 추가하기
}

public class CountryApp {
	public static void main(String[] args) {
		CountryManager m = new CountryManager();
		m.showAll();
//		m.add(new Country("테스트코드", "테스트국가", 2000, "테스트수도", 200000));
		m.showAll();
	}
}

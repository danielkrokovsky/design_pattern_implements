package pattern.virtualthreads;

public class Data {

	private String year;
	private String age;
	private String ethnic;
	private String sex;
	private String area;
	private String count;

	public String getYear() {
		return year;
	}

	public String getAge() {
		return age;
	}

	public String getEthnic() {
		return ethnic;
	}

	public String getSex() {
		return sex;
	}

	public String getArea() {
		return area;
	}

	public String getCount() {
		return count;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Data(Builder builder) {

		this.year = builder.year;
		this.age = builder.age;
		this.ethnic = builder.ethnic;
		this.sex = builder.sex;
		this.area = builder.area;
		this.count = builder.count;
	}

	@Override
	public String toString() {
		return "Data [year=" + year + ", age=" + age + ", ethnic=" + ethnic + ", sex=" + sex + ", area=" + area
				+ ", count=" + count + "]";
	}

	public static class Builder {

		private String year;
		private String age;
		private String ethnic;
		private String sex;
		private String area;
		private String count;

		public Builder(String year, String age, String ethnic, String sex, String area, String count) {
			super();
			this.year = year;
			this.age = age;
			this.ethnic = ethnic;
			this.sex = sex;
			this.area = area;
			this.count = count;
		}

		public Builder year(String year) {
			this.year = year;
			return this; // Retorna o próprio Builder para encadeamento
		}

		public Builder age(String age) {
			this.age = age;
			return this; // Retorna o próprio Builder para encadeamento
		}

		public Builder ethnic(String ethnic) {
			this.ethnic = ethnic;
			return this; // Retorna o próprio Builder para encadeamento
		}

		public Builder sex(String sex) {
			this.sex = sex;
			return this; // Retorna o próprio Builder para encadeamento
		}

		public Builder area(String area) {
			this.area = area;
			return this; // Retorna o próprio Builder para encadeamento
		}

		public Builder count(String count) {
			this.count = count;
			return this; // Retorna o próprio Builder para encadeamento
		}

		public Data build() { // Método para construir o objeto
			return new Data(this);
		}

	}
}

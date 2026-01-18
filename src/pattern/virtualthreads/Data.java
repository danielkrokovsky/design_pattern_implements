package pattern.virtualthreads;


public class Data {
	
	private String Year,Age,Ethnic,Sex,Area,count;
	
	public Data(Builder builder) {

		Year = builder.year;
		Age = builder.age;
		Ethnic = builder.ethnic;
		Sex = builder.sex;
		Area = builder.area;
	}

	public String getEthnic() {
		return Ethnic;
	}

	public void setEthnic(String ethnic) {
		Ethnic = ethnic;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Data(String year,String Age) {
		super();
		this.Year = year;
		this.Age = Age;
		
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
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


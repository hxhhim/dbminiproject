package vo;

public class Member {
	private String grade;
	private String name;
	private String phone;
	private int reserve = 0;
	private int mno;
	private int mileage;
	
	
	public Member(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	public Member(String name, String phone, int mno) {
		this.name = name;
		this.phone = phone;
		this.mno = mno;
	}
	public Member(String name, 
			String phone, int reserve, int mno) {
		super();
		this.name = name;
		this.phone = phone;
		this.reserve = reserve;
		this.mno = mno;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getReserve() {
		return reserve;
	}
	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}
	@Override
	public String toString() {
		return "Memer [name=" + name + ", phone=" + phone + 
				", reserve=" + reserve + ", mno=" + mno
				+ "]";
	}
	
}

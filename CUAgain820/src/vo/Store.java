package vo;

public class Store
{
	private String sno;
	private String sname;
	private String address;
	private String admin;
	
	public Store(String sno, String sname, String address, String admin)
	{
		super();
		this.sno = sno;
		this.sname = sname;
		this.address = address;
		this.admin = admin;
	}

	public Store(String sname, String address, String admin) {
		super();
		this.sname = sname;
		this.address = address;
		this.admin = admin;
	}

	public String getSno()
	{
		return sno;
	}

	public void setSno(String sno)
	{
		this.sno = sno;
	}

	public String getSname()
	{
		return sname;
	}

	public void setStore_name(String sname)
	{
		this.sname = sname;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getAdmin()
	{
		return admin;
	}

	public void setAdmin(String admin)
	{
		this.admin = admin;
	}

	@Override
	public String toString()
	{
		return "Store [sno=" + sno + ", sname=" + sname + ", address="
				+ address + ", admin=" + admin + "]";
	}
}

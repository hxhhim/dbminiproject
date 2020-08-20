package vo;

import java.sql.Date;

public class Product
{
	private String pno;
	private String category;
	private String comp;
	private String pname;
	private int price;
	private String shelflife;
	private int event;
	
	public Product(String pno, String category, String comp, String pname, int price, String shelflife, int event)
	{
		super();
		this.pno = pno;
		this.category = category;
		this.comp = comp;
		this.pname = pname;
		this.price = price;
		this.shelflife = shelflife;
		this.event = event;
	}
	
	

	public Product(String category, String comp, String pname, int price, String shelflife, int event)
	{
		super();
		this.category = category;
		this.comp = comp;
		this.pname = pname;
		this.price = price;
		this.shelflife = shelflife;
		this.event = event;
	}



	public String getPno()
	{
		return pno;
	}
	
	public void setPno(String pno)
	{
		this.pno = pno;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public String getComp()
	{
		return comp;
	}
	
	public void setComp(String comp)
	{
		this.comp = comp;
	}
	
	public String getPname()
	{
		return pname;
	}
	
	public void setPname(String pname)
	{
		this.pname = pname;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public String getShelflife()
	{
		return shelflife;
	}
	
	public void setShelflife(String shelflife)
	{
		this.shelflife = shelflife;
	}
	
	public int getEvent()
	{
		return event;
	}
	
	public void setEvent(int event)
	{
		this.event = event;
	}

	@Override
	public String toString()
	{
		return "Product [pno=" + pno + ", category=" + category + ", comp=" + comp + ", pname=" + pname + ", price="
				+ price + ", shelflife=" + shelflife + ", event=" + event + "]";
	}
}

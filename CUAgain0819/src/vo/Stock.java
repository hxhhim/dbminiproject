package vo;

public class Stock
{
	private String sno;
	private String pno;
	private int stock;
	
	public Stock(String sno, String pno, int stock)
	{
		super();
		this.sno = sno;
		this.pno = pno;
		this.stock = stock;
	}
	
	public Stock(String pno, int stock)
	{
		super();
		this.pno = pno;
		this.stock = stock;
	}

	public String getSno()
	{
		return sno;
	}

	public void setSno(String sno)
	{
		this.sno = sno;
	}

	public String getPno()
	{
		return pno;
	}

	public void setPno(String pno)
	{
		this.pno = pno;
	}

	public int getStock()
	{
		return stock;
	}

	public void setStock(int stock)
	{
		this.stock = stock;
	}

	@Override
	public String toString()
	{
		return "Stock [sno=" + sno + ", pno=" + pno + ", stock=" + stock + "]";
	}
}

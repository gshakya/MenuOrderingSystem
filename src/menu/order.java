package menu;

public class order {
	int orderID;
	int count;
  
	public order()
	{
		
	}
	public order(int orderID,int count)
	{
		this.orderID=orderID;
		this.count=count;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
}

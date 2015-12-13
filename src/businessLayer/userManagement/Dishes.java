package businessLayer.userManagement;

public class Dishes {
	private String name;
	private boolean selected;
	private int dishID;
  
	public Dishes()
	{
		
	}
	public Dishes(int dishId,String name, boolean selected)
	{
	
		this.name=name;
		this.selected=selected;
	    this.dishID=dishId;
	}
	
	public int getDishID() {
		return dishID;
	}

	public void setDishID(int dishID) {
		this.dishID = dishID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	

}

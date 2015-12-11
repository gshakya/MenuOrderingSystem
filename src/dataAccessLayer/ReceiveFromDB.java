package dataAccessLayer;

import java.util.ArrayList;

public interface ReceiveFromDB extends ConnectToDB{
	public ArrayList runSelectQuery(String query);
	
}

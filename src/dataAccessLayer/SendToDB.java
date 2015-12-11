package dataAccessLayer;

public interface SendToDB extends ConnectToDB{

	public void runInsertQuery(String query);
}

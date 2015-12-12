package dataAccessLayer.dbInterface;

public interface SendToDB extends ConnectToDB{

	public int runInsertQuery(String query);
}

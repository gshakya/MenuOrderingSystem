package dataAccessLayer;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import businessLayer.userManagement.User;


public class UserFileReader {
/**
 * The class is created to File operation in files 
 * 
 * 	
 */
	
	private User usr=new User(); 

	
	private final static String FILE_PATH="//Users//ahmedamin//Desktop//users.txt";
	
	public UserFileReader () {
		
	}
	
	public boolean insertUser(User usr  )throws IOException{
		/**
		 * Accepts User Object and Insert the user data into a file
		 */
		if (usr.getId() <= 0 || usr.getPassword() == null || usr.getFirstName() == null || usr.getLastName() == null )
			return false;
		
		boolean success=false;
		String content =  usr.getId() + ","+ usr.getPassword() + "," + usr.getFirstName() + "," +usr.getLastName() ;
		
		try {
			File file = new File(FILE_PATH);
	
//			if (!file.exists()) {
//				file.createNewFile();
//			}

		    FileWriter fw = new FileWriter(FILE_PATH,true); //the true will append the new data
		    fw.write("line\n");
		    fw.write(content);
		    fw.close();
			
			System.out.println("Done");
			success=true;

		} catch (IOException e) {
			e.printStackTrace();
			success=false;
			
		}
		
		return success;
	}
	
	
//	public boolean CheckUser(int id, String password) throws IOException{
//	    String [][] USERS;
//		BufferedReader buffer=new BufferedReader(new FileReader(FILE_PATH));
//		int counter =1;
//		String currentLine="";
//		while (buffer.readLine() != null) counter++;
//		buffer.close();
//		USERS=new String [counter-1][4];
//		System.out.println(counter);
//		buffer=new BufferedReader(new FileReader(FILE_PATH));
//		counter=0;
//		
//		while ( (currentLine=buffer.readLine()) != null){
//			if (currentLine!=null && !currentLine.equals("")) {
//				if (currentLine!=null && !currentLine.equals("")) {
//					USERS[counter] = currentLine.split(",");
//					counter++;
//				}
//			}
//		}
//		
//		buffer.close();
//		for (int i=0; i< USERS.length; i++){
//			if (USERS[i][0].equals(String.valueOf(id)) ){
//				if (!USERS[i][1].equals(password) )
//					return false;
//				else
//					return true;
//			}
//		}
//		
//		return false;
//	}
	
	public static ArrayList<User> getUsers() throws IOException{
		/**
		 * Reads all the available datas of the user. and Returns it as an ArrayList of User
		 */
	    String [][] USERS;
		BufferedReader buffer=new BufferedReader(new FileReader(FILE_PATH));
		int counter =1;
		String currentLine="";
		while (buffer.readLine() != null) counter++;
		buffer.close();
		USERS=new String [counter-1][5];
		System.out.println(counter);
		buffer=new BufferedReader(new FileReader(FILE_PATH));
		counter=0;
		
		while ( (currentLine=buffer.readLine()) != null){
			if (currentLine!=null && !currentLine.equals("")) {
				if (currentLine!=null && !currentLine.equals("")) {
					USERS[counter] = currentLine.split(",");
					counter++;
				}
			}
		}
		
		buffer.close();
		ArrayList<User> userList = new ArrayList<User>();
		
		for (int i=0; i< USERS.length; i++){
			 userList.set(i,new User(Integer.valueOf(USERS[i][0]) , USERS[i][1],   USERS[i][2],  USERS[i][3]));
		}
		
		return userList;
	}
}

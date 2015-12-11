package view;

import businessLayer.userManagement.UsersOperation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsersOperation uo = new UsersOperation();
		System.out.println(uo.checkPassword(1, "123456"));
	}

}

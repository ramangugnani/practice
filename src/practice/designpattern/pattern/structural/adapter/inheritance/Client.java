package practice.designpattern.pattern.structural.adapter.inheritance;

public class Client {
	public static void main(String  [] args){
		Socket socket = new ExpansionAdapter();
		System.out.println(socket.getInput());
	}
}

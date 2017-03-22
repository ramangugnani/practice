package practice.designpattern.pattern.structural.adapter.composition;

public class Client {
	public static void main(String  [] args){
		Socket socket = new ExpansionAdapter(new Plug());
		System.out.println(socket.getInput());
	}
}

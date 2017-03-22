package practice.designpattern.pattern.structural.adapter.inheritance;


public class ExpansionAdapter  extends Plug implements Socket {

	@Override
	public String getInput() {
		String input = super.getInput();
		input = input + "Converted to 2-pin";
		return input;
	}

}

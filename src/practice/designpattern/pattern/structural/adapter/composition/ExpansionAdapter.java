package practice.designpattern.pattern.structural.adapter.composition;


public class ExpansionAdapter   implements Socket {
	private Plug plug;
	
	ExpansionAdapter(Plug p){
		plug = p;
	}

	@Override
	public String getInput() {
		String input = plug.getInput();
		input = input + "Converted to 2-pin";
		return input;
	}

}

package practice.designpattern.pattern.structural.adapter.composition;

public class Plug implements Socket{
	private String specification;
	public String getInput(){
		return specification;
	}
	public Plug(){
		specification = "3-Pin";
	}
}

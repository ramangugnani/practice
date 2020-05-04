package practice.designpattern.pattern.creational.abstractfactory;

public class Parts {
	private String specification;
	Parts(String specification){
		this.specification = specification;
	}
	public String getSpecification(){
		return specification;
	}
}

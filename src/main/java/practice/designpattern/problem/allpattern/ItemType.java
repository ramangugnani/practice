package practice.designpattern.problem.allpattern;

public enum ItemType {
	BOOK("book"),
	CD("cd"),
	COSMETICS("cosmetics"),
	CD_IMPORTED("cd_imported");

	private String name = null;
	
	ItemType(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

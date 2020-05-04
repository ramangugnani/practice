package practice.designpattern.pattern.structural.composite;

public class LeafFile implements FileComponent{
	private String fileName;
	public LeafFile(String name){
		fileName = name;
	}
	@Override
	public void printName() {
		System.out.println("File Name: "+fileName);
	}
}

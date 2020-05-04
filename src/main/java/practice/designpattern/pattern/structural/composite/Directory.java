package practice.designpattern.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileComponent{
	private String directoryName;
	private List<FileComponent> files = new ArrayList<>();
	public Directory(String name){
		directoryName = name;
	}
	public void add(FileComponent obj){
		files.add(obj);
	}
	@Override
	public void printName() {
		System.out.println("Directory Name: "+directoryName);
		for(FileComponent file : files){
			file.printName();
		}
	}
}

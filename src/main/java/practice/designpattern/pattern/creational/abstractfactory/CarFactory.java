package practice.designpattern.pattern.creational.abstractfactory;

public class CarFactory {

	public Car getCar(String carType){
		if(null == carType){
			return null;
		}
		if("BMW".equals(carType)){
			return new BMW(); 
		}else if("BenY".equals(carType)){
			return new BenQ(); 
		}else if("GM".equals(carType)){
			return new GM(); 
		}
		else{
			return null;
		}
	}
}

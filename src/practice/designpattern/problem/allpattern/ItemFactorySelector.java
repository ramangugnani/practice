package practice.designpattern.problem.allpattern;

/**
 * Abstract factory class which creates a singleton ItemFactory dynamically based on factory name
 * supplied.
 * Benefits of singleton: -- single instance of the ItemFactory -- single point of access (global
 * access within the JVM and the class loader)
 */ 
public class ItemFactorySelector {
	private static ItemFactory objectFactorySingleInstance = null;
	private static final String FACTORY_NAME = "practice.designpattern.problem.allpattern.GoodsFactory";

	public static ItemFactory getItemFactory(){
		if(objectFactorySingleInstance == null){
			//Dynamically instantiate factory and factory name can also be read from a properties
			//file. in future if we need a CachedGoodsFactory which caches Items to improve memory
			//usage then we can modify the FACTORY_NAME to "com.item.CachedGoodsFactory" or
			//conditionally select one of many factories. 
			try {
				Class klassFcatory = Class.forName(FACTORY_NAME);
				objectFactorySingleInstance = (ItemFactory) klassFcatory.newInstance();
			} catch (ClassNotFoundException cnf) {
				throw new RuntimeException("Cannot create the ItemFactory "+ cnf.getMessage());
			}catch (IllegalAccessException iae){
				throw new RuntimeException("Cannot create the ItemFactory "+ iae.getMessage());
			}catch(InstantiationException ie){
				throw new RuntimeException("Cannot create the ItemFactory "+ ie.getMessage());
			}
		}
		return objectFactorySingleInstance;
	}
}

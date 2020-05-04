package practice.designpattern.problem.allpattern;

public class GoodsFactory extends ItemFactory{
	
	protected GoodsFactory() {
	}
	
	@Override
	public Item getItem(int itemType, String description, int qty, double price) throws ItemException {
		Item item = null;
		if(itemType == Item.TYPE_BOOK){
			item = new  Books(description, qty, price);
		}else if(itemType == Item.TYPE_CD){
			item = new  Books(description, qty, price);
		}else if(itemType == Item.TYPE_CD_IMPORTED){
			item = new  Books(description, qty, price);
		}else if(itemType == Item.TYPE_COSMETICS){
			item = new  Books(description, qty, price);
		}else {
			throw new ItemException("Invalid Item Type="+itemType);
		}
		return item;
	}

}

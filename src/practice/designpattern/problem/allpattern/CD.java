package practice.designpattern.problem.allpattern;

public class CD extends Goods{
	private boolean isTaxed = true;
	private boolean isImported = false;

	public CD(String description, int qty, double price) {
		super(description, qty, price);
	}
	@Override
	public void setImported(boolean b) {
		isImported = b;
	}

	@Override
	protected boolean isTaxed() {
		return isTaxed;
	}

	@Override
	protected boolean isImported() {
		return isImported;
	}
}

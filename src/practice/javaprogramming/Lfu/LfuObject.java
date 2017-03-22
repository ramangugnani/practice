package practice.javaprogramming.Lfu;

public class LfuObject {

	private Integer data;

	private Integer frequency;
	
	private Integer index;

	public LfuObject(Integer data, Integer frequency,Integer index) {
		super();
		this.data = data;
		this.frequency = frequency;
		this.index = index;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void increaseFrequency() {
		frequency++;
	}

	@Override
	public String toString() {
		return "LfuObject [data=" + data + ", frequency=" + frequency + ", index=" + index + "]";
	}
}

package serrano.newmap;

public class Tuple2 {

	private final String key;
	private final String value;
	
	public Tuple2(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Tuple2 [key=" + key + ", value=" + value + "]";
	}
	
}

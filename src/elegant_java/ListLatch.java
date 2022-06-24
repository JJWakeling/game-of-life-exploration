package elegant_java;

import java.util.*;

public class ListLatch<T> implements Latch<T> {
	
	private final List<T> latchedValue;

	public ListLatch() {
		latchedValue = new ArrayList<T>(1);
	}

	@Override
	public void set(T value) throws Exception {
		if (!isSet()) {
			latchedValue.add(value);
		}
		else {
			throw new Exception("Value has already been set");
		}
		
	}

	@Override
	public T value() throws Exception {
		if (isSet()) {
			return latchedValue.get(0);
		}
		else {
			throw new Exception("Value has not been set");
		}
	}

	@Override
	public boolean isSet() {
		return latchedValue.size() > 0;
	}

}

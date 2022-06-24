package elegant_java;

public interface Latch<T> {
	boolean isSet();
	void set(T value) throws Exception;
	T value() throws Exception;
}

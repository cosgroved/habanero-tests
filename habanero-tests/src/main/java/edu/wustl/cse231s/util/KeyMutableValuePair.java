package edu.wustl.cse231s.util;

import java.util.Objects;
import java.util.Map.Entry;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class KeyMutableValuePair<K,V> implements Entry<K, V> {
	public KeyMutableValuePair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	@Override
	public K getKey() {
		return this.key;
	}
	@Override
	public V getValue() {
		return this.value;
	}
	
	@Override
	public V setValue(V value) {
		V prevValue = this.value;
		this.value = value;
		return prevValue;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if (obj instanceof KeyMutableValuePair) {
			KeyMutableValuePair<K,V> other = (KeyMutableValuePair<K,V>) obj;
			return Objects.equals(this.key, other.key) && Objects.equals(this.value, other.value);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.key) ^ Objects.hashCode(this.value);
	}
	
	private final K key;
	private V value;
}

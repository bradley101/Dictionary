
package com.bradley101.dictionary;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
	private Map<Object, Dictionary> subDict;
	private Object value;
	private Object parentKey;

	public Dictionary() {
	}

	private Dictionary(Object parentKey) {
		this();
		this.parentKey = parentKey;
	}

	public Dictionary of(Object key) {
		if (value != null) {
			value = null;
		}
		if (subDict == null) {
			subDict = new HashMap<>();
		}
		if (subDict.containsKey(key)) {
			return subDict.get(key);
		}
		subDict.put(key, new Dictionary(key));
		return subDict.get(key);
	}

	public Object val() {
		return value;
	}

	public void setTo(Object val) {
		value = val;
	}
}

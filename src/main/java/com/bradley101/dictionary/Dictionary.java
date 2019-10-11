package com.bradley101.dictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * Don't confuse with java.util.Dictionary. The original source code for <b>Dictionary</b> class
 * that performs the task for storing a value for
 * multiple keys (one or more)
 * Dictionary is a Map that can store a value corresponding
 * to multiple keys just like the Python dict(). See here <a href="https://docs.python.org/3/tutorial/datastructures.html#dictionaries">Python Dictionary</a>
 * For usage see the methods below.
 *
 * <p>
 * @author Shantanu Banerjee
 * @email hi@shantanubanerjee.com
 * @date 09 Oct 2019
 * </p>
 */

public class Dictionary {
	private Map<Object, Dictionary> subDict;
	private Object value;
	private Object parentKey;

	// A default constructor, just scaffold stuff.
	public Dictionary() {
	}

	/**
	 * Suppress parameterized constructor for more clear implementation
	 * Suppose we are in a particular sub-dictionary then
	 * It is useful to store the key that was above this level.
	 * It can be used to backtrack and many more implementations.
	 * Just added for simplicity of library implementation and usefulness.
	 *
	 * @param parentKey of the sub-dictionary
 	 */
	private Dictionary(Object parentKey) {
		this();
		this.parentKey = parentKey;
	}

	/**
	 * Used to go lower into the key hierarchy and creates the sub-dictionary
	 * Or if a sub-dict with a key is already in that level, it just returns that.
	 *
	 * Usage:
	 * <code>
	 * Dictionary dict = new Dictionary();
	 * dict.of("john").of("mobile").setTo(1234);
	 * </code>
	 *
	 * For more info see the setTo() method.
	 *
	 * @param key for the corresponding level
	 * @return Dictionary object corresponding to the sub-dict
	 */
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

	/**
	 * <p>Returns the value of the sub-dictionary iff the sub-dictionary does not contain
	 * another level of sub-dict i.e. it is the last level of Dictionary and contains the actual Value
	 * associated with the keys</p>
	 *
	 * <p>You can typecast the value in your own class type you need</p>
	 *
	 * @return Object value of the sub-dict
	 */
	public Object val() {
		return value;
	}

	/**
	 * <p>Sets the value of the sub-dict. Use it if you have used reached the leaf of your key-chain.
	 * If you create a sub-dict in the same level, the value gets changed to null.</p>
	 * @param val for the corresponding sub-dict
	 */
	public void setTo(Object val) {
		value = val;
	}
}

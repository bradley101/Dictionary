# Dictionary ![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fdl.bintray.com%2Fbradley101%2FDictionary%2Fcom%2Fbradley101%2Fdictionary%2Fdictionary%2Fmaven-metadata.xml&style=for-the-badge)
Dictionary is a Java library for creating multiple-key to single value pair. Classical `Map` only stores single key to single value pairs, making it difficult to be used in situations where multiple keys correspond to a single value.

Like Python `dict()` can store data in such manner.

    myDict = dict()
    myDict['name']['first_name'] = 'John'
    myDict['name']['last_name'] = 'Doe'
In Java you cannot do such things. This is where this library comes into picture.

    Dictionary myDict = new Dictionary();
    myDict.of("name").of("first_name").setTo("John");
    myDict.of("name").of("last_name").setTo("Doe");
You can use any number of keys to structure your data. Though it is recommended that you design your structure properly for efficient usage.
## Getting Started
### Installation
For Maven: Add the following snippet to your `pom.xml`

    <dependency>
		<groupId>com.bradley101.dictionary</groupId>
		<artifactId>dictionary</artifactId>
		<version>1.0</version>
		<type>pom</type>
	</dependency>
For Gradle: Add the following

    dependencies {
	    ..
	    compile 'com.bradley101.dictionary:dictionary:1.0'
	}
Download Jar from [here](https://dl.bintray.com/bradley101/Dictionary/com/bradley101/dictionary/dictionary/1.0/dictionary-1.0.jar).
For more information on installation, see the Bintray package page [here](https://bintray.com/bradley101/Dictionary/Dictionary).
### Usage

 - Create an object of the `Dictionary` class.
  `Dictionary mDict = new Dictionary();`
  
 - Use the `of()` method on the dictionary object to create a sub-dictionary under the parent one.
	 ```
	 Dictionary subDict = mDict.of(1);
	 Dictionary subSubDict = subDict.of("trial"); // Or just anything you want
	```
	
 - Use the `setTo()` on any dictionary object to set its value corresponding to the keys you have used.
	  ```
	  subDict.setTo(true);
	  mDict.of(1).setTo(true); // Same as above
	  // You can create multiple levels of key hierarchy
	  mDict.of(2).of(2).setTo("Shantanu");
	  ```
 - Use the `val()` method on the sub-dict to get the value set by `setTo()` on that key.
	 ```
	System.out.println(mDict.of(1).val()); // prints "true"
	System.out.println(mDict.of(2).of(2)).val()); // prints "Shantanu" 
	 ```
	 If you use the `val()` on a sub-dict that has not been assigned a value by `setTo()` or is not a value node (leaf node of tree), it will return `null`.

## Contribute
You are truly most welcome. Please read the CONTRIBUTING.md file for more information.
## License
This project is licensed under the Apache License - see the LICENSE.md file for details.

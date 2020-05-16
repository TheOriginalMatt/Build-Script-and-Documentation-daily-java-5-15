# Build Files and Generating Documentation
## Daily Java Project for: 5/13/2020

### Description:

I created a super simple String class, that was used entierly so I could experiment with javadoc and ant

### Daily Java Projects
I'm creating a small Java project each day to help me learn Java. These aren't rigorously tested, but instead exist just so I can get a better understanding of some portion of Java.

### Points of Interest

+ HOLY COW! is Javadoc cool, I've seen stuff like `@param` in code before but the website it generates is amazing! It can even make me look like I know what I'm doing

+ Ant, is cool as well, and I'm sure once I work on projects larger than 3 files it'll be instrumental, but for right now it seems a bit convoluted.

+ I learned while developing the `SimpleString` class that apparently you can't override operators in Java. This is ridiculous and I expect someone to fix it immeidiately.

### Compiling

There is a build file using ant, which can be run by `$ant`, or you can go into `./src` and compile it by hand

### Using `SimpleStrings`
Example - create two `SimpleStrings`, concatenate, and use substring

```
public class Parent {
	public static void main(String args[]) {
		char[] arr = {'H', 'e', 'l', 'l', 'o'};

		SimpleString sStrArr = new SimpleString(arr);
		SimpleString sStrStr = new SimpleString(" World");


		sStrArr.concatenate(sStrStr);

		System.out.println(sStrArr);
		System.out.println(sStrArr.subString(4, 7));
	}
}

```

### Documentation

No more handwritten documentation for me!

[SimpleString](https://theoriginalmatt.github.io/Build-Script-and-Documentation-daily-java-5-15/SimpleString.html)
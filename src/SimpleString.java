/**
*<h1> SimpleString </h1>
* A simple string class to show off I can generate documentation and
* write build files
*
* @author TheOriginalMatt
* @version 1.0
*/

import java.util.Arrays;

public class SimpleString {

	public static final int SIZE_LIMIT = 50;
	private int length = 0;
	private char[] charArr = new char[this.SIZE_LIMIT];

	/**
	* char[] version of the constructor
	*
	*@param  charArr array of char to be stored 
	*/
	SimpleString(char[] charArr) {
		this.setValue(charArr);
	}

	/**
	* String version of the constructor
	*
	*@param str String to be stored
	*@return Nothing 
	*@throws Nothing 
	*
	*/
	SimpleString(String str) {
		this.setValue(str.toCharArray());
	}

	/**
	* Sets the value of the string to the given char array, and sets the length to that of the given array
	*
	*@param charArr  
	*@throws IllegalArgumentException If the length of the string is greater than SIZE_LIMIT
	*
	*/
	public void setValue(char[] charArr) throws IllegalArgumentException{
		this.clearArr();
		System.arraycopy(charArr, 0, this.charArr, 0, charArr.length);

		try {
			this.setLength(charArr.length);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Length of given char[] is greater than "+this.SIZE_LIMIT);
		}
	}

	/**
	* Returns the char array stored in the class
	*
	*@param Nothing 
	*@return char[] stored in the class
	*@throws Nothing 
	*
	*/
	private char[] getCharArr() {
		return this.charArr;
	}

	/**
	* Clears the contents of the array, setting each element to \u0000 and sets the length to 0
	*
	*/
	private void clearArr() {
		for (int i = 0; i < this.SIZE_LIMIT; i++) {
			this.charArr[i] = '\u0000';
		}
		this.setLength(0);
	}

	/**
	* Returns the contents in the form of a String, specifically for printing
	*
	*@return String version of the stored contents 
	*@see {@link docs.oracle.com/javase/7/docs/api/java/lang/Object.html#toString() Object.toString()}
	*/
	public String toString() {
		return new String(this.getCharArr());
	}

	/**
	* Concatenates the given SimpleString instance to the end of the current string
	*
	*@param suffix the SimpleString instance to be appended to the end of the current instance
	*@throws IllegalArgumentException if the length of both strings put together is greater than SIZE_LIMIT 
	*
	*/
	public void concatenate(SimpleString suffix) throws IllegalArgumentException{
		try {
			System.arraycopy(suffix.getCharArr(), 0, this.charArr, this.length(), suffix.length);
			this.setLength(this.length()+suffix.length());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Total length of the strings is greater than "+this.SIZE_LIMIT);
		}
	}

	/**
	* Sets this.length to the given integer, used to keep track of how much of the array stores values
	*
	*@param length how long the stored string is, length-1 should be the last element with contents
	*@throws IllegalArgumentException If the length is less than 0 or greater than SIZE_LIMIT
	*
	*/
	private void setLength(int length) throws IllegalArgumentException{
		if (length >= 0 && length <= this.SIZE_LIMIT) {
			this.length = length;
		} else {
			throw new IllegalArgumentException("SimpleString.size must be between 0 and "+this.SIZE_LIMIT+" inclusively");
		}
	}

	/**
	* Returns the size of the stored string
	*
	*@return the length of the stored string 
	*
	*/
	public int length() {
		return this.length;
	}

	/**
	* Returns a substring of the current isntance between the current bounds
	*
	*@param min the first character, starting at 0, to be displayed
	*@param max the last character, less than SIZE_LIMIT to be displayed
	*@return SimpleString containing the substring
	*@throws IllegalArgumentException if the given bounds don't fit within {@literal 0 <= min < max <= this.length()}
	*
	*/
	public SimpleString subString(int min, int max) throws IllegalArgumentException{
		if (min >= 0 && max <= this.length() && min < max) {
			return new SimpleString(Arrays.copyOfRange(this.getCharArr(), min, max));
		} else {
			throw new IllegalArgumentException("Arguments must follow 0 <= min < max <="+this.length());
		}
	}
}
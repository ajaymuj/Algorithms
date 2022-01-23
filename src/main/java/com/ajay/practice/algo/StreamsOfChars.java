package com.ajay.practice.algo;

/*
Q2.
a. There's a stream reader of characters, each being '0' or '1'.  
c. A output streamWriter of chars.
b. You have been given a list of pairs of pattern and a output char. example:
   [
     {pattern: "0110", output: "1"},
     {pattern: "1010", output: "01"},
     ...
    ] 

c. write a function that processes the stream and keeps finding longest possible pattern match & writes the corresponding output in the StreamWriter.

Input: 00101101010
Output: 101

01101010
101
001101010

*/
public class StreamsOfChars {
	
	public static void main(String [] args) {
		String input = FileUtil.getInput();
		Long maxPatternKey = FileUtil.getMaxSize();
	}
	
}
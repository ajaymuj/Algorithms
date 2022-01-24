package com.ajay.practice.algo;

import java.util.Collections;
import java.util.List;

/*
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
*/
public class StreamsOfChars extends PatternManager {
	
	public static void main(String [] args) {
		StreamsOfChars soc = new StreamsOfChars();
		String output = soc.traverse();
		System.out.println("output :: \n" + output);
	}

	private String traverse() {
		StringBuilder out = new StringBuilder();
		int maxPatternKey = getMaxSize();
		int sI = 0;
		int eI = maxPatternKey-1;
		char [] inputArr = getInput();
		System.out.println("input length :: \n" + inputArr.length);
		try {
			for (int i = sI; i < inputArr.length; i++) {
				char[] sub = new char[getMaxSize()];
				for (int j = 0; j < getMaxSize(); j++) {
					sub[j] = inputArr[j + i];
				}
				out.append(iterate(sub, sI, eI));
				if (eI < inputArr.length - 1)
					eI++;
			}
		} catch(Exception e) {
			return out.toString();
		}
		return out.toString();
	}

	private String iterate(char [] sub, int sI, int eI) {
		String match = "";
		for(int i=sub.length; i>=0; i--) {
			String str = new String(sub, 0, i);
			match = search(str);
			if(!"".equals(match)) {
				break;
			}
		}
		return match;
	}

	private String search(String str) {
		String match = "";
		int size = str.length();
		List <KeyValuePair> kvPairList= getPatternMap(size);
		if(kvPairList!=null) {
			for (KeyValuePair kvPair : kvPairList) {
				if (kvPair.getKey().equals(str)) {
					match = kvPair.getValue();
					break;
				}
			}
		}
		return match;
	}
	
}
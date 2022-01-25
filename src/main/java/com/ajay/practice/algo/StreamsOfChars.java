package com.ajay.practice.algo;

import java.util.ArrayList;
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
//		char [] inputArr = "1001011001101001".toCharArray();
		if(inputArr.length<maxPatternKey) {
			eI=inputArr.length;
		}
		System.out.println("input length :: \n" + inputArr.length);
		try {
			int i =sI;
			while (i < inputArr.length) {
				char[] sub = new char[((inputArr.length-i)<maxPatternKey?(inputArr.length-i):maxPatternKey)];
				for (int j = 0; j < sub.length; j++) {
					sub[j] = inputArr[j + i];
				}
				KeyValuePair match = iterate(sub, sI, eI);
				if(match!=null) {
					out.append(match.getValue());
					i = i + match.getKey().length();
					if (eI < inputArr.length - 1) {
						eI = (eI + match.getKey().length())>(inputArr.length - 1)
								?(inputArr.length - 1):(eI + match.getKey().length());
					}
				} else {
					i++;
					if(eI < inputArr.length - 1) {
						eI++;
					} else {
						eI = inputArr.length - 1;
					}
				}
			}
		} catch(Exception e) {
			return out.toString();
		}
		return out.toString();
	}

	private KeyValuePair iterate(char [] sub, int sI, int eI) {
		KeyValuePair match = null;
		for(int i=sub.length; i>=0; i--) {
			String str = new String(sub, 0, i);
			match = search(str);
			if(match!=null) {
				break;
			}
		}
		return match;
	}

	private KeyValuePair search(String str) {
		KeyValuePair match = null;
		try {
			int size = str.length();
//		List<KeyValuePair> kvPairList = new ArrayList <>();
//		kvPairList.add(new KeyValuePair("1001","10"));
//		kvPairList.add(new KeyValuePair("0110","1"));
			List < KeyValuePair > kvPairList = getPatternMap(size);
			if (kvPairList != null) {
				for (KeyValuePair kvPair : kvPairList) {
					if (kvPair.getKey().equals(str)) {
						match = kvPair;
						break;
					}
				}
			}
		} catch(Exception e) {

		}
		return match;
	}
	
}
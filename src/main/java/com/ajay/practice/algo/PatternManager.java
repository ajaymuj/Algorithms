package com.ajay.practice.algo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PatternManager {


	private static ConcurrentHashMap<Integer, List<KeyValuePair>> patternMap = new ConcurrentHashMap<>();
	private static String INPUT_FILE_PATH = "D:\\my_projects\\Algorithms\\src\\main\\resources\\binary_stream_input.txt";
	private static String PATTERN_FILE_PATH = "D:\\my_projects\\Algorithms\\src\\main\\resources\\binary_stream_pattern.json";
	private static String input = "";
	private static String patternStr = "";
	
	static ObjectMapper om = new ObjectMapper();
	
	static {
		File pFile = new File(PATTERN_FILE_PATH);
		try {
			patternStr = readFile(pFile);			
			List<LinkedHashMap> keyValueList  = om.readValue(patternStr, LinkedList.class);
			for(LinkedHashMap kvPair : keyValueList) {
				Set<String> keySet = kvPair.keySet();
				for(String key: keySet) {
					if(!patternMap.containsKey(key.length())) {
						patternMap.put(key.length(), new LinkedList<>());
					}
					KeyValuePair pair = new KeyValuePair(key, (String) kvPair.get(key));
					patternMap.get(key.length()).add(pair);
				}
			}
			System.out.println("patterns available:: \n" + patternMap);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File iFile = new File(INPUT_FILE_PATH);
		try {
			input = readFile(iFile);
			System.out.println("input stream :: \n" + input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String readFile(File file) throws IOException {
		try (FileReader fr = new FileReader(file)) {			
			char[] chars  = new char[(int)file.length()];
			int offset = 0;
            while (offset < chars.length)
            {
                int result = fr.read(chars, offset, chars.length - offset);
                if (result == -1) {
                    break;
                }
                offset += result;
            }
            return new String(chars);
		}
	}

	public static List<KeyValuePair> getPatternMap(int key) {
		return patternMap.get(key);
	}
	
	public char [] getInput() {
		return input.toCharArray();
	}

	public Integer getMaxSize() {
		Set<Integer> keySet = patternMap.keySet();
		List<Integer> list = new ArrayList<>(keySet);
		Collections.sort(list);
		return list.get(list.size()-1);
	}

}

package com.ajay.practice.algo;

/**
 * N cars where N=0-100000
 * M features for each car where M=0-15
 * {"100", "110", "010", "011", "100"} = [2,3,2,1,2] - feature matching - 3 features for each car
 * {"1010", "1110", "1010", "0011", "0100"} = [2,3,2,1,2] - feature matching - 4 features for each car
 */
public class CarFeatures {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String [] cars = {"100", "110", "010", "011", "100"};
        CarFeatures cf = new CarFeatures();
        int [] out = cf.solution(cars);
        for(int i=0; i<out.length; i++) {
            System.out.println(out[i]);
        }
    }

    public int[] solution(String[] cars) {
        // write your code in Java SE 8
        int [] output = new int [cars.length];
        for(int m=0; m<cars.length; m++) {
            output[m] = 0;
        }
        for(int i=0; i<cars.length; i++) {
            char[] carArr = cars[i].toCharArray();
            int count=0;
            boolean isSimilar = true;
            for(int j=(i==0)?(i+1):0; j<cars.length; j++) {
                if(i!=j) {
                    char[] comCarArr = cars[j].toCharArray();
                    for (int k = 0; k < carArr.length; k++) {
                        if (carArr[k] != comCarArr[k]) {
                            count++;
                        }
                    }
                    if (count > 1) {
                        isSimilar = false;
                    }
                    count = 0;
                    if (isSimilar) {
                        output[i]++;
                    }
                    isSimilar = true;
                }
            }
        }
        return output;
    }


}

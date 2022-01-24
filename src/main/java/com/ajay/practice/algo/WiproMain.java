package com.ajay.practice.algo;

public class WiproMain {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            int [] input = {2,7,9,3,6,8};

            int len = input.length/2;
            int [] left = new int[len];
            for(int i=0; i<len; i++) {
                left[i] = input[i];
            }
            int [] right = new int[len];
            int count=0;
            for(int i=len; i<input.length; i++) {
                right[count] = input[i];
                count++;
            }
            sort(left, right);
        }

        public static int [] sort(int [] left, int [] right) {

            int [] output = new int [left.length + right.length];
            int i=0; int j=0; int k=0;
            while(k>=(left.length+right.length-1)) {
                if(left[i]>right[j]) {
                    output[k]=left[i];
                    i++; k++;
                }
                else if (right[j] >= left[i]) {
                    output[k]=right[j];
                    j++; k++;
                }
            }

            while(i < left.length) {
                output[k] = left[i];
                k++; i++;
            }
            while(j < right.length) {
                output[k] = right[j];
                k++; j++;
            }
            if(left.length>2) {
                int c = left.length/2;
                int [] l = new int[c];
                int c1=0;
                for(int m=c; m<left.length; m++) {
                    l[c1] = left[m];
                    c1++;
                }
                int [] r = new int[c];
                int c2=0;
                for(int n=c; n<right.length; n++) {
                    r[c2] = right[n];
                    c2++;
                }
                sort(l, r);
            }
            return output;
        }
}

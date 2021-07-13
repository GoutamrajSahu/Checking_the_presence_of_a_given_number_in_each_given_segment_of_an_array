package com.company;
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int length = Sc.nextInt();
        int arr[] = new int[length];
        System.out.printf("Enter %d numbers:\n",length);
        for(int i=0; i<length; i++){
            arr[i] = Sc.nextInt();
        }

        System.out.println("Enter the number to check the presence of it in each segment:");
        int num = Sc.nextInt();
        System.out.println("Enter the size of each segment: ");
        int segmentSize = Sc.nextInt();
        int segmentSizeCopy = segmentSize;
        int numberOfSegments = arr.length/segmentSize;
        System.out.println("Number Of fullSegments:"+numberOfSegments);
        int sizeOfLeftSegment = arr.length%segmentSize;
        System.out.println("Size of remain one Segment:"+sizeOfLeftSegment);
        int count = 0;
        int nextStart = 0;
        int numberOfRepeat = 0;
        for(int i=0; i<numberOfSegments; i++){
            for(int j = nextStart; j<segmentSize; j++){
                if(arr[j] == num){
                    numberOfRepeat++;
                }
            }
            if(numberOfRepeat>0){
                count++;
//                System.out.println(numberOfRepeat);
                numberOfRepeat = 0;
            }
            nextStart = nextStart + segmentSizeCopy;
            segmentSize = segmentSize + segmentSizeCopy;
        }

        if(sizeOfLeftSegment>0){
            numberOfSegments = numberOfSegments+1;
            numberOfRepeat = 0;
            for(int i=nextStart; i<arr.length; i++){
                if(arr[i]==num){
                    numberOfRepeat++;
                }
            }
            if(numberOfRepeat>0){
                count++;
//                System.out.println(numberOfRepeat);
            }
        }

        if(count == numberOfSegments){
            System.out.println("\nIs "+num+" present in each segment?: Yes");
        }else {
            System.out.println("\nIs "+num+" present in each segment: No");
        }
    }
}
package Binary_Search;

import java.util.Random;

public class binarySearch {
    private int[] arr;

    public binarySearch(){
    }

    public binarySearch(int size){
        setSize(size);
        generateArray();
        sort();
    }

    public int[] getBinarySearch(){
        return arr;
    }

    public void setSize(int size){
        if(size <= 0){
            throw new IllegalArgumentException("Size > 0");
        }
        arr = new int[size];
    }


    public void generateArray(){
        Random rd = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i] = rd.nextInt(198) - 99;
        }
    }

    public void sort(){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public int search(int searchValue){
        int l = 0;
        int r = arr.length - 1;

        while(l < r){
            int mid = (l + r) / 2;
            if(arr[mid] == searchValue){
                return mid;
            }

            if(arr[mid] < searchValue){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }

    public void display(){
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            if(i < arr.length){
                System.out.print(arr[i]);
            }
            if(i < arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}

package Bubble_Sort;
import java.util.Random;

public class bubbleSort {
    private int[] arr;

    public bubbleSort(int size){
        setSize(size);
        generateArray();
    }

    public void setSize(int size){
        if(size <= 0){
            throw new IllegalArgumentException("Size > 0");
        }
        arr = new int[size];
    }

    public int[] getBubbleSort(){
        return arr;
    }

    public void generateArray(){
        Random rd = new Random();

        for(int i = 0; i < arr.length; i++){
            arr[i] = rd.nextInt(100);
        }
        
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

    public void sort(){ 
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
package Fibonacci;

public class fibonacci{
    private int[] arr;
    
    public fibonacci(int size){
        setSize(size);
        calculate();
    }

    public void setSize(int size){
        if(size <= 0){
            throw new IllegalArgumentException("n must > 0");
        }
        arr = new int[size];
    }

    public int[] getfibonacci(){
        return arr;
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

    public void calculate(){
        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                arr[i] = 0;
            }else if(i == 1){
                arr[i] = 1;
            }else {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
    }
}
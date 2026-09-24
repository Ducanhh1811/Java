/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

/**
 *
 * @author Admin
 */
public class EmptyQueueException extends RuntimeException{
    public EmptyQueueException(){
        super("Empty Queue Exception");
    }
    public EmptyQueueException(String message){
        super(message);
    }
    
}

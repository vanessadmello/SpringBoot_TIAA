package com.api.Exception;

public class HnDBankException extends Exception{
    String message;
    public HnDBankException(String mesg){
        this.message = mesg;
    }
    public HnDBankException(){

    }
    public String getMessage(){
        return this.message;
    }

}

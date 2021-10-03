package com.ugurhmz.exception;




public class ResourceNotFoundException  extends RuntimeException{

    private static final long serialVersionUID  = 1L;


    // CONSTRUCTOR
    public ResourceNotFoundException(String message){
        super(message);
    }


}

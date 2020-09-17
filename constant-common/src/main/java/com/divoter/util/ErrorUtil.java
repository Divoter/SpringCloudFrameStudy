package com.divoter.util;

import org.springframework.validation.ObjectError;

import java.util.List;

public class ErrorUtil {

    public static String getAllErrorMessages(List<ObjectError> errorList){
        String message = "";
        if(errorList==null&&errorList.size()==0){
            return message;
        }
        for(int i = 0;i<errorList.size();i++){
            if(i==0){
                message = errorList.get(i).getDefaultMessage();
            }else{
                message = message + "," + errorList.get(i).getDefaultMessage();
            }
        }
        return message;
    }
}

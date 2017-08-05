package com.promotion.action.annotation;

import java.util.List;

/**
 * Created by shifeifei on 2017/5/1.
 */
public class PasswordUtil {

    @UseCase(id=47,description = "password must contain at least one numeric")
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id=48)
    public String encryptPassword(String password){
        return new StringBuffer(password).reverse().toString();
    }

    @UseCase(id=49,description = "new password can't contain previous password")
    public boolean checkForNewPassword(List<String> prePasswords,String password){
        return prePasswords.contains(password);
    }

}

package main.com.myApp;

import main.com.myApp.annotations.Confirm;
import main.com.myApp.model.UserModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmValidator implements ConstraintValidator<Confirm, Object> {
    @Override
    public boolean isValid( final Object value,final ConstraintValidatorContext context) {

         UserModel userModel=(UserModel) value;
        if (userModel.getPassword() == null || userModel.getConfirmrpassword() == null) {
            return false; //
        }

        else if(userModel.getPassword().equals(userModel.getConfirmrpassword()))
             return true;
         else {


            return false;


         }


    }
}

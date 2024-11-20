package main.com.myApp.annotations;

import main.com.myApp.ConfirmValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ConfirmValidator.class) // رابط بالـ Validator
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Confirm {
    String message()default "Passwords do not match!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
 String first();
 String second();
}

package main.com.myApp.controller;

import main.com.myApp.model.UserModel;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Contended;

import javax.validation.Valid;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showHomePage(Model model)
    {
       model.addAttribute("userModel",new UserModel());// send object

        return"homePage";
    }
    @RequestMapping("/processForm")
    public String processForm(@Valid@ModelAttribute("userModel")UserModel userModel , BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
            return "homePage";
        model.addAttribute("userModel",userModel);
        return "resultPage";
    }
    @InitBinder
    public void removeSpaces(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor trimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,trimmerEditor);

    }
}

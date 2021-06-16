package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerServiceORM;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView("/home");

        return mav;
    }


    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView mav = new ModelAndView("/create");
        mav.addObject("c", new Customer());
        return mav;
    }
    @PostMapping("/create")
    public  String create(Customer customer){
        CustomerServiceORM customerServiceORM = new CustomerServiceORM();
        customerServiceORM.findAll();

        return "redirect:/customers";
    }


}

package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerServiceORM;
import service.ICustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
//CustomerServiceORM serviceORM = new CustomerServiceORM();
    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView("/home");
        mav.addObject("c", customerService.findAll());
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

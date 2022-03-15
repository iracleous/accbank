package gr.codehub.eshop.controler;

import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccController {
    private CustomerService customerService;


    @RequestMapping (value={"/ping"}, method = RequestMethod.GET)
    public String ping(){
        return "Working";
    }


    @RequestMapping (value={"/register"}, method = RequestMethod.POST)
    public int register(@RequestBody Customer customer){
        try{
            return customerService.register(customer);
        }
        catch(Exception e)
        {
            return -1;
        }
     }


}

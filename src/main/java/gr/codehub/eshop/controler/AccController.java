package gr.codehub.eshop.controler;

import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping (value={"/login/{customerId}"}, method = RequestMethod.GET)
    public Customer login(@PathVariable("customerId") int customerId){
        try{
            return customerService.login(customerId);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    @RequestMapping (value={"/customer"}, method = RequestMethod.GET)
    public List<Customer> customer(){
        return customerService.customerList();
    }

    @RequestMapping (value={"/customer/{customerId}"}, method = RequestMethod.PUT)
    public Customer update(@PathVariable("customerId") int customerId, @RequestBody Customer customer){
        return customerService.update(customerId, customer);
    }


    @RequestMapping (value={"/customer/{customerId}"}, method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("customerId") int customerId){
        return customerService.delete(customerId );
    }

}

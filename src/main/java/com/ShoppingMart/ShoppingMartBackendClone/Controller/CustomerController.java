package com.ShoppingMart.ShoppingMartBackendClone.Controller;

import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.CustomerRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.CustomerResponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        CustomerResponseDto customerResponseDto;
        try {
            customerResponseDto = customerService.addCustomer(customerRequestDto);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(customerResponseDto,HttpStatus.ACCEPTED);
    }


    @GetMapping("/get/id")
    public CustomerResponseDto getCustomerById(@RequestParam("id") int id){
        CustomerResponseDto customerResponseDto;
        try {
            customerResponseDto = customerService.getCustomerById(id);
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return customerResponseDto;
    }

    @GetMapping("/get/email")
    public CustomerResponseDto getCustomerByEmail(@RequestParam String email){
        CustomerResponseDto customerResponseDto;
        try {
            customerResponseDto = customerService.findByEmail(email);
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return customerResponseDto;
    }


}

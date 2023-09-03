package com.springbootacademybatch4.pointofsalebatch4.service.impl;

import com.springbootacademybatch4.pointofsalebatch4.dto.CustomerDTO;
import com.springbootacademybatch4.pointofsalebatch4.entity.Customer;
import com.springbootacademybatch4.pointofsalebatch4.repo.CustomerRepo;
import com.springbootacademybatch4.pointofsalebatch4.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumbers(),
                customerDTO.getNic(),
                customerDTO.isActiveState()
        );

        if(!customerRepo.existsById(customer.getCustomerId())){
            customerRepo.save(customer);
        }
        else {
            System.out.println("customer is already exists.");
        }

    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        if(customerRepo.existsById(customerDTO.getCustomerId())){
            Customer customer = customerRepo.getById(customerDTO.getCustomerId());

            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerSalary(customerDTO.getCustomerSalary());
            customer.setAddress(customerDTO.getAddress());

            customerRepo.save(customer);
            return "updated";
        }else {
            System.out.println("customer id is not found");
            return "customer id is not found";
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {

        // 1st method

        /* Customer customer = customerRepo.getById(customerId);
        if(customer != null){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.isActiveState()
            );
            return customerDTO;
        }else {
            return null;
        }*/

        // 2nd method

        /* Optional<Customer> customer = customerRepo.findById(customerId);
        if(customer.isPresent()){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.get().getCustomerId(),
                    customer.get().getCustomerName(),
                    customer.get().getAddress(),
                    customer.get().getCustomerSalary(),
                    customer.get().getContactNumbers(),
                    customer.get().getNic(),
                    customer.get().isActiveState()
            );
            return customerDTO;
        }else {
            return null;
        } */

        // 3rd method

        Customer customer = customerRepo.getById(customerId);
        CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class); // convert one object to another object type
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> getCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer: getCustomers){
            customerDTOList.add(modelMapper.map(customer,CustomerDTO.class));
        }

        // 2nd method

        /*
        if(customerDTOList!=null){
            customerDTOList = modelMapper.map(getCustomers, new TypeToken<List<CustomerDTO>>(){}.getType());
        }
         */
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "deleted";
        }else {
            return "No customer found for that id";
        }
    }
}

package com.api.service.customer;



import com.api.Exception.HnDBankException;
import com.api.dto.customer.CustomerDTO;

import java.util.List;

public interface CustomerService {
    int addCustomer(CustomerDTO customer) throws HnDBankException;
    CustomerDTO getCustomer(Integer customerId) throws HnDBankException;
    List<CustomerDTO> findAll() throws HnDBankException;
    void updateCustomer(Integer customerId, CustomerDTO customerDTO) throws HnDBankException;
    void deleteCustomer(Integer customerId)throws HnDBankException;
}

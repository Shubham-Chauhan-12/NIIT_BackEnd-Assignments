package com.customerpc1.ControllerTest;

import com.customerpc1.Controller.CustomerController;
import com.customerpc1.Domain.Customer;
import com.customerpc1.Domain.Product;
import com.customerpc1.Exception.CustomerNotExists;
import com.customerpc1.Repository.CustomerRepository;
import com.customerpc1.Services.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private Customer customer;
    private Product product;

    @BeforeEach
    public void setUp(){
        product = new Product(98,"i5 12th gen","Intel Processor");
        customer = new Customer(110,"Vaibhav",78541236,product);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @AfterEach
    public void tearDown(){
        product = null;
        customer = null;
    }

    @Test
    public void giveCustomerDetailsToSaveAndReturningSuccessCode() throws Exception {
        when(customerService.saveAllCustomerDetails(any())).thenReturn(customer);
        mockMvc.perform(post("/customer/v1/save-details")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsBytes(customer)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

        verify(customerService,times(1)).saveAllCustomerDetails(any());
    }

    @Test
    public void fetchCustomerDetailsFromGetAndReturnSuccessCode() throws Exception {
        List<Customer> customerList = new ArrayList<>();
        product = new Product(98,"i5 12th gen","Intel Processor");
        customer = new Customer(110,"Vaibhav",78541236,product);
        customerList.add(customer);


        when(customerService.fetchCustomerDetails()).thenReturn(customerList);
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/v1/get-details")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$",hasSize(1))).andExpect(jsonPath("$[0].customerName", Matchers.is("Vaibhav")));
    }


    /*@Test
    public void deleteCustomerByIdAndReturnSuccessCode() throws Exception{


    }*/

    // get by id


    /*@Test
public void getPatientById_success() throws Exception {
    Mockito.when(patientRecordRepository.findById(RECORD_1.getPatientId())).thenReturn(java.util.Optional.of(RECORD_1));

    mockMvc.perform(MockMvcRequestBuilders
            .get("/patient/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", notNullValue()))
            .andExpect(jsonPath("$.name", is("Rayven Yor")));
}*/
}

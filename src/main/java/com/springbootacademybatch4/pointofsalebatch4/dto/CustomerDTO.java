package com.springbootacademybatch4.pointofsalebatch4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {

    private int customerId;
    private String customerName;
    private String address;
    private double customerSalary;
    private ArrayList contactNumbers;
    private String nic;
    private boolean activeState;

}

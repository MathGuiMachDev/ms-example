package com.mathguimachdev.hrpayroll.services;

import com.mathguimachdev.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){
        //Mock
        return new Payment("Bob",200.0,days);
    }
}

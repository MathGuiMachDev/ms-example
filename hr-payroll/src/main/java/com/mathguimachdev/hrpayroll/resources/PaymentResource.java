package com.mathguimachdev.hrpayroll.resources;

import com.mathguimachdev.hrpayroll.entities.Payment;
import com.mathguimachdev.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService serv;

    @HystrixCommand(fallbackMethod = "getPaymentAlt")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable long workerId, @PathVariable int days){
        Payment p = serv.getPayment(workerId,days);
        return ResponseEntity.ok().body(p);
    }

    public ResponseEntity<Payment> getPaymentAlt(long workerId, int days){
        Payment p = new Payment("Alt",400.0,days);
        return ResponseEntity.ok().body(p);
    }
}

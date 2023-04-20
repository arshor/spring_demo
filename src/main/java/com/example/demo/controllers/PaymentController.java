package com.example.demo.controllers;

import com.example.demo.model.Payment;
import com.example.demo.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    //    @PostMapping("/payment")
//    public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails) {
//
//        //PaymentDetails paymentDetails = paymentService.processPayment();
//        logger.info("Received payment " + paymentDetails.getAmount());
//
//        return ResponseEntity
//                .status(HttpStatus.ACCEPTED)
//                .body(paymentDetails);
//
//    }
    @PostMapping("/payment")
    public ResponseEntity<Payment> creatPayment(@RequestHeader String requestId, @RequestBody Payment payment) {

        logger.info("Received request with ID " + requestId + " :Payment Amount: " + payment.getAmount());

        payment.setId(UUID.randomUUID().toString());

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(payment);

    }
}

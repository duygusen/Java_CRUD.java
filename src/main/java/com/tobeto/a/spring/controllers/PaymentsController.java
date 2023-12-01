package com.tobeto.a.spring.controllers;

import com.tobeto.a.spring.services.abstracts.PaymentService;
import com.tobeto.a.spring.services.dtos.customer.responses.GetListCustomerAdress;
import com.tobeto.a.spring.services.dtos.employee.responses.GetListEmployeeAge;
import com.tobeto.a.spring.services.dtos.employee.responses.GetListEmployeeNameAndSurname;
import com.tobeto.a.spring.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.a.spring.services.dtos.payment.requests.DeletePaymentRequest;
import com.tobeto.a.spring.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.a.spring.services.dtos.payment.responses.GetListPaymentDiscount;
import com.tobeto.a.spring.services.dtos.payment.responses.GetListPaymentMethod;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {

    private final PaymentService paymentService;

    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public void add(@RequestBody AddPaymentRequest request){
        paymentService.add(request);
    }

    @PutMapping("{id}")
    public void update (@RequestBody UpdatePaymentRequest request){
        paymentService.update(request);
    }

    @DeleteMapping("{id}")
    public void delete (@RequestBody DeletePaymentRequest request){
        paymentService.delete(request);
    }

    @GetMapping("dto/payments/discount")
    public List<GetListPaymentDiscount> getByPaymentDiscountDto(@RequestParam double discount){
        return  paymentService.getByPaymentDiscountDto(discount);
    }

    @GetMapping("dto/payments/paymentMethod")
    public List<GetListPaymentMethod> getByPaymentMethodDto(@RequestParam String paymentMethod){
        return  paymentService.getByPaymentMethodDto(paymentMethod);
    }
}
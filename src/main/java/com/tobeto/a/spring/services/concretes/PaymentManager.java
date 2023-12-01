package com.tobeto.a.spring.services.concretes;

import com.tobeto.a.spring.entities.Payment;
import com.tobeto.a.spring.repositories.PaymentRepository;
import com.tobeto.a.spring.services.abstracts.PaymentService;
import com.tobeto.a.spring.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.a.spring.services.dtos.payment.requests.DeletePaymentRequest;
import com.tobeto.a.spring.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.a.spring.services.dtos.payment.responses.GetListPaymentDiscount;
import com.tobeto.a.spring.services.dtos.payment.responses.GetListPaymentMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentManager implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentManager(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void add(AddPaymentRequest request) {
        Payment payment = new Payment();
        payment.setAmount(request.getAmount());
        payment.setDiscount(request.getDiscount());
        payment.setPaymentMethod(request.getPaymentMethod());
        paymentRepository.save(payment);
    }

    @Override
    public void update(UpdatePaymentRequest request) {
        Payment paymentToUpdate = paymentRepository.findById(request.getId()).orElseThrow();
        paymentToUpdate.setAmount(request.getAmount());
        paymentToUpdate.setDiscount(request.getDiscount());
        paymentToUpdate.setPaymentMethod(request.getPaymentMethod());
        paymentRepository.save(paymentToUpdate);
    }

    @Override
    public void delete(DeletePaymentRequest request) {
        Payment paymentToDelete = paymentRepository.findById(request.getId()).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }

    @Override
    public List<GetListPaymentDiscount> getByPaymentDiscountDto(double discount) {
        return paymentRepository.findByPaymentDiscount(discount);
    }

    @Override
    public List<GetListPaymentMethod> getByPaymentMethodDto(String paymentMethod) {
        return paymentRepository.findByPaymentMethod(paymentMethod);
    }
}
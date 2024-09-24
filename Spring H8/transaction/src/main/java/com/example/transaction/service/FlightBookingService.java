package com.example.transaction.service;

import com.example.transaction.dto.FlightBookingAcknowledgement;
import com.example.transaction.dto.FlightBookingRequest;
import com.example.transaction.entity.PassengerInfo;
import com.example.transaction.entity.PaymentInfo;
import com.example.transaction.repo.PassengerInfoRepository;
import com.example.transaction.repo.PaymentInfoRepository;
import com.example.transaction.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    public FlightBookingAcknowledgement bookflightTicket(FlightBookingRequest request){

        PassengerInfo passengerInfo=request.getPassengerInfo();
        passengerInfo=passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return  new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);


    }
}

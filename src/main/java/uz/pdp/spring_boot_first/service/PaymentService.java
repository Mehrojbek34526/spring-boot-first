package uz.pdp.spring_boot_first.service;

import uz.pdp.spring_boot_first.payload.BankCardDTO;

public interface PaymentService {
    BankCardDTO topUpClick(Long cardId, Long amount);

    BankCardDTO topUpPayme(Long cardId, Long amount);
}

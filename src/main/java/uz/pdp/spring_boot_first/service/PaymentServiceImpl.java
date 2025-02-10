package uz.pdp.spring_boot_first.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot_first.entity.BankCard;
import uz.pdp.spring_boot_first.exception.RestException;
import uz.pdp.spring_boot_first.payload.BankCardDTO;
import uz.pdp.spring_boot_first.repository.BankCardRepository;

/**
 Created by: Mehrojbek
 DateTime: 07/02/25 19:55
 **/
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final BankCardRepository bankCardRepository;

    //id:1 100_000
    @Transactional
    @Override
    public BankCardDTO topUpClick(Long cardId, Long amount) {

        //balance: 0 version: 0
        try {
            BankCard bankCard = bankCardRepository.findById(cardId).orElseThrow(() -> RestException.notFound("card", cardId));

            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //balance: 100_000 original balance in db : 200_000
            bankCard.setBalance(bankCard.getBalance() + amount);

            bankCardRepository.save(bankCard);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //id:1 200_000
    @Transactional
    @Override
    public BankCardDTO topUpPayme(Long cardId, Long amount) {

        //balance: 0 version: 0

        BankCard bankCard = bankCardRepository.findById(cardId).orElseThrow(() -> RestException.notFound("card", cardId));

        bankCard.setBalance(bankCard.getBalance() + amount);

        //balance: 100_000 version: 1
        bankCardRepository.save(bankCard);

        return null;
    }
}

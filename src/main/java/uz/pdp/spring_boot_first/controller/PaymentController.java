package uz.pdp.spring_boot_first.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.spring_boot_first.payload.BankCardDTO;
import uz.pdp.spring_boot_first.service.PaymentService;

/**
 Created by: Mehrojbek
 DateTime: 07/02/25 19:51
 **/
@RestController
@RequestMapping("/api/bank-card")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;


    /**
     * Hisobni to'ldirish
     * @return
     */
    @PostMapping("/top-up-click")
    public BankCardDTO topUpClick(@RequestParam Long cardId,
                                  @RequestParam Long amount){
        return paymentService.topUpClick(cardId,amount);
    }

    /**
     * Hisobni to'ldirish
     * @return
     */
    @PostMapping("/top-up-payme")
    public BankCardDTO topUpPayme(@RequestParam Long cardId,
                                  @RequestParam Long amount){
        return paymentService.topUpPayme(cardId,amount);
    }

}

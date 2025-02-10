package uz.pdp.spring_boot_first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.spring_boot_first.entity.BankCard;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Long> {
}
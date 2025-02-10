package uz.pdp.spring_boot_first.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import uz.pdp.spring_boot_first.entity.User;

import java.util.Optional;
import java.util.UUID;

/**
 Created by: Mehrojbek
 DateTime: 07/02/25 21:08
 **/
@Configuration
@EnableJpaAuditing
public class AuditConfig {

    @Bean
    public AuditorAware<UUID> auditorProvider() {
        return () -> Optional.of(UUID.fromString("19ba1844-bd66-4922-946d-3b33f3e93abe"));
    }
//
//    public static class JpaAudit implements AuditorAware<UUID> {
//
//        @Override
//        public Optional<UUID> getCurrentAuditor() {
//
////            Principle principle = SecurityContextHolder.getAuthentication().getPrinciple();
////
////            if(principle.toString().equals("anonymousUser"))
////                return Optional.empty();
////
////            User user = (User) principle;
////
////            return Optional.of(user.getId());
//
//            return Optional.of(UUID.fromString("59bd2fbb-1def-440d-9e96-6a566b2436be"));
//        }
//    }

}

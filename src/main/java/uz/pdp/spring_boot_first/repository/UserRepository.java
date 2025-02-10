package uz.pdp.spring_boot_first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.spring_boot_first.entity.User;
import uz.pdp.spring_boot_first.enums.RoleEnum;
import uz.pdp.spring_boot_first.payload.UserShortInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    //method query
    Optional<User> findByUsername(String username);

    List<User> findAllByRoleOrderByBirthDateDesc(RoleEnum role);

    //country falonchaga teng bo'lgan userlar
    //select u.* from users u join address a on u.address_id=a.id where a.country=:country
    List<User> findAllByAddress_Country(String country);

    //jpql query
    @Query(value = "select u from users u where u.address.country = :country")
    List<User> getMyCountryUsers(String country);

    //native query
    @Query(value = "select users from users where users.address.country=:country", nativeQuery = true)
    List<User> getMyCountryUsersNative(String country);

    @Query(value = """
            select u.id              as id,
                   u.firstName       as firstName,
                   u.lastName        as lastName,
                   u.address.country as country,
                   u.address.city    as city
            from users u
            """)
    List<UserShortInfo> getUserShortInfo();

}

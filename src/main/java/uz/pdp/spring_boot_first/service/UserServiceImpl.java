package uz.pdp.spring_boot_first.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot_first.entity.Address;
import uz.pdp.spring_boot_first.entity.User;
import uz.pdp.spring_boot_first.enums.RoleEnum;
import uz.pdp.spring_boot_first.exception.RestException;
import uz.pdp.spring_boot_first.mapper.UserMapper;
import uz.pdp.spring_boot_first.payload.UserDTO;
import uz.pdp.spring_boot_first.payload.UserFilterDTO;
import uz.pdp.spring_boot_first.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 Created by: Mehrojbek
 DateTime: 03/02/25 19:45
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EntityManager entityManager;

    @Override
    public UserDTO me(String username) {

        User user = userRepository.findByUsername(username).orElseThrow(() -> RestException.notFound("User", username));

        UserDTO userDTO = userMapper.toDTO(user);

        return userDTO;
    }

    @Override
    public List<UserDTO> byRole(RoleEnum role) {
        List<User> users = userRepository.findAllByRoleOrderByBirthDateDesc(role);
        List<UserDTO> userDTOList = userMapper.toDTO(users);
        return userDTOList;
    }


    @Override
    public List<UserDTO> filter(UserFilterDTO filterDTO) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> root = criteriaQuery.from(User.class);

        // Prepare predicates for filtering
        List<Predicate> predicates = new ArrayList<>();

        //firstname
        if (Objects.nonNull(filterDTO.getFirstName())) {

            Path<String> path = root.get(User.Fields.firstName);

            Predicate predicate = criteriaBuilder
                    .like(
                            path,
                            "%" + filterDTO.getFirstName() + "%"
                    );

            predicates.add(predicate);
        }

        //lastname
        if (Objects.nonNull(filterDTO.getLastName())) {

            Path<String> path = root.get(User.Fields.lastName);

            Predicate predicate = criteriaBuilder
                    .like(
                            path,
                            "%" + filterDTO.getLastName() + "%"
                    );

            predicates.add(predicate);
        }

        //birthdate
        if (Objects.nonNull(filterDTO.getBirthDateFrom()) && Objects.nonNull(filterDTO.getBirthDateTo())) {

            Expression<LocalDate> path = root.get(User.Fields.birthDate);

            Predicate predicate = criteriaBuilder
                    .between(
                            path,
                            filterDTO.getBirthDateFrom(),
                            filterDTO.getBirthDateTo()
                    );

            predicates.add(predicate);
        }

        //country
        if (Objects.nonNull(filterDTO.getCountry())) {

            //user.addres
            Join<Object, Object> address = root.join("address");

            //user.addres.country
            Path<String> path = address.get(Address.Fields.country);

            Predicate predicate = criteriaBuilder
                    .like(
                            path,
                            "%" + filterDTO.getCountry() + "%"
                    );

            predicates.add(predicate);
        }

        if (Objects.nonNull(filterDTO.getCity())) {

            //user.addres
            Join<Object, Object> address = root.join("address");

            //user.addres.country
            Path<String> path = address.get(Address.Fields.city);

            Predicate predicate = criteriaBuilder
                    .like(
                            path,
                            "%" + filterDTO.getCity() + "%"
                    );

            predicates.add(predicate);
        }

        Order usernameAscOrder = criteriaBuilder.asc(root.get(User.Fields.username));

        criteriaQuery.orderBy(usernameAscOrder);

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        List<User> users = entityManager.createQuery(criteriaQuery).getResultList();

        return userMapper.toDTO(users);
    }
}

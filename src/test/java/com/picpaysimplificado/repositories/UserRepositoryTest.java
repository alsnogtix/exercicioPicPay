package com.picpaysimplificado.repositories;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("Deve retornar um usuário do DB")
    void findUserByDocumentCase1() {
        String document = "999999999909";
        UserDTO userDTO = new UserDTO("Alisson", "Teixeira", document, new BigDecimal(10), "email@example.com", "123", UserType.COMMON);
        this.createUser(userDTO);

        Optional<User> result = this.userRepository.findUserByDocument(document);
        assertThat(result.isPresent()).isTrue();
    }


    @Test
    @DisplayName("Não deve retornar um usuário do DB quando não existir")
    void findUserByDocumentCase2() {
        String document = "999999999909";
        Optional<User> result = this.userRepository.findUserByDocument(document);
        assertThat(result.isEmpty()).isTrue();
    }

    private User createUser(UserDTO userDTO){
        User user = new User(userDTO);
        this.em.persist(user);
        return user;
    }



}
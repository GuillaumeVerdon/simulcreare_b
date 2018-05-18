package com.simulcreare.respository;

import com.simulcreare.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByMail(String mail);
}

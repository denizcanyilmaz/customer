package com.yilmazdenizcan.customer.repositories;

import com.yilmazdenizcan.customer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/*
 *
 * Author: Denizcan Yilmaz,2018 November
 * Mail: yilmazdenizcan@gmail.com
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT t FROM User t WHERE t.username = ?1 AND t.password = ?2")
    User findByUsernameAndPassword(String fooIn, String bar);
}

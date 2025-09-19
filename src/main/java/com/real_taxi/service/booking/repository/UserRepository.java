package com.real_taxi.service.booking.repository;

import com.real_taxi.service.booking.constant.UserQ;
import com.real_taxi.service.booking.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Query(value = UserQ.DoesEmailExistsQ, nativeQuery = true)
    boolean existsByUserEmail(@Param("user_email") String email);

    @Transactional
    @Query(value = UserQ.GetAllUsersQ, nativeQuery = true)
    List<Map<String, Object>> getAllUsers();

    @Transactional
    @Query(value = UserQ.GetUserByEmailQ, nativeQuery = true)
    Map<String, Object> getUserByEmail(@Param("user_email") String email);

    @Transactional
    @Query(value = UserQ.GetUserByIdQ, nativeQuery = true)
    Map<String, Object> getUserById(@Param("user_id") Long id);

}

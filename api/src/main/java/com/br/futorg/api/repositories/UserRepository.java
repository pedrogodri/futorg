package com.br.futorg.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.futorg.api.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}

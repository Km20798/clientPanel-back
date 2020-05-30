package com.karim.repository;

import com.karim.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepoistory extends JpaRepository<Client , Long> {

}

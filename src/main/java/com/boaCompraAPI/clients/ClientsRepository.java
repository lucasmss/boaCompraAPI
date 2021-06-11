package com.boaCompraAPI.clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {

    Clients findByid(long id);
}

package com.boaCompraAPI.bought;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtRepository extends JpaRepository<Bought, Long>{

}

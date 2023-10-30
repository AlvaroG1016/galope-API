package com.galope.pedidos.models.meseros;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMeseroRepository extends JpaRepository<Mesero, Long> {
}

package br.com.heserproject.imobiliaria.repository;

import br.com.heserproject.imobiliaria.domain.entity.Imobiliaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImobiliariaRepository extends JpaRepository<Imobiliaria, Integer> {
}

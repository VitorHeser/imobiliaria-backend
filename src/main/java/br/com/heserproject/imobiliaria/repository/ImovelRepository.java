package br.com.heserproject.imobiliaria.repository;

import br.com.heserproject.imobiliaria.domain.entity.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer> {
}

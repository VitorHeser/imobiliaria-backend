package br.com.heserproject.imobiliaria.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @Column(name = "cd_cep")
    private Long cep;

    @Column(name = "ds_rua")
    private String rua;

    @Column(name = "ds_cidade")
    private String cidade;

    @Column(name = "ds_estado")
    private String estado;

    @Column(name = "ds_pais")
    private String pais;

}

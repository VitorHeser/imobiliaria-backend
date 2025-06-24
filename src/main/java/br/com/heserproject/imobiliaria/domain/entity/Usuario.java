package br.com.heserproject.imobiliaria.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @Column(name = "cd_cpf")
    private Long cpf;

    @Column(name = "nm_nome")
    private String nome;

    @Column(name = "ds_email")
    private String email;

}

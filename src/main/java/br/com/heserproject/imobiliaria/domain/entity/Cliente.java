package br.com.heserproject.imobiliaria.domain.entity;

import br.com.heserproject.imobiliaria.domain.enums.EstadoCivilEnum;
import br.com.heserproject.imobiliaria.domain.enums.SexoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @Column(name = "cd_id")
    private Long id;

    @Column(name = "ds_nome")
    private String nome;

    @Column(name = "ds_cpf")
    private Long cpf;

    @Column(name = "ds_nascimento")
    private LocalDate dataNacimento;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_telefone")
    private Long telefone;

    @Column(name = "ds_endereco")
    private String endereco;

    @Column(name = "ds_cep")
    private Long cep;

    @Column(name = "ds_genero")
    private SexoEnum genero;

    @Column(name = "ds_estadoCivil")
    private EstadoCivilEnum estadoCivil;

    @Column(name = "ds_proficao")
    private String proficao;

    @Column(name = "ds_dataCadastro")
    private LocalDate dataCadastro;
}

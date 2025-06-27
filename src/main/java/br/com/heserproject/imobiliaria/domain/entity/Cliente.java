package br.com.heserproject.imobiliaria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @Column(name = "cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Column(name = "nm_nome")
    private String nome;

    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "ds_telefone")
    private String telefone;

    @Column(name = "dt_cadastro")
    private LocalDate dataCadastro;
}

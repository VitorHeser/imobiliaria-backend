package br.com.heserproject.imobiliaria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_imobiliaria")
public class Imobiliaria {

    @Id
    @Column(name = "cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco", foreignKey = @ForeignKey(name = "fk_endereco_imobiliaria"))
    private Endereco endereco;

    @Column(name = "nm_nome")
    private String nome;

    @Column(name = "ds_descricao")
    private String descricao;

    @Column(name = "cd_cep")
    private String cep;

    @Column(name = "dt_cadastro")
    private LocalDate dataCadastro;
}

package br.com.heserproject.imobiliaria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_imovel")
public class Imovel {

    @Id
    @Column(name = "cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ds_descricao", length = 100)
    private String descricao;

    @Column(name = "vl_locacao")
    private Double valorLocacao;

    @JoinColumn(name = "id_endereco")
    @ManyToOne(fetch = FetchType.LAZY)
    private Endereco endereco;

}

package br.com.heserproject.imobiliaria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_imovel")
public class Imovel {

    @Id
    @Column(name = "cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco", foreignKey = @ForeignKey(name = "fk_endereco_imovel"))
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_imobiliaria", foreignKey = @ForeignKey(name = "fk_imobiliaria_imovel"))
    private Imobiliaria imobiliaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "nm_nomeimovel")
    private String nomeImovel;

    @Column(name = "ds_descricao")
    private String descricao;

    @Column(name = "dt_cadastro")
    private LocalDate dataCadastro;

}

package br.com.heserproject.imobiliaria.domain.entity;

import br.com.heserproject.imobiliaria.domain.enums.FuncaoEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

    @Id
    @Column(name = "cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_imobiliaria", foreignKey = @ForeignKey(name = "fk_imobiliaria_funcionario"))
    private Imobiliaria imobiliaria;

    @Column(name = "nm_nome")
    private String nome;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ds_funcao")
    private FuncaoEnum funcao;
}

package br.com.heserproject.imobiliaria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Data
@Entity
@Comment("Tabela de cliente")
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @Column(name = "cd_id")
    @Comment("Identificador do usuário")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("id da tabela de endereço")
    @JoinColumn(name = "id_endereco", foreignKey = @ForeignKey(name = "fk_endereco_cliente"))
    private Endereco endereco;

    @Column(name = "nm_nome")
    @Comment("Nome do usuário")
    private String nome;

    @Column(name = "dt_nascimento")
    @Comment("Data de nascimento do cliente")
    private LocalDate dataNascimento;

    @Column(name = "ds_telefone")
    @Comment("Telefone do cliente")
    private String telefone;

    @Column(name = "dt_cadastro")
    @Comment("Data do cadastro")
    private LocalDate dataCadastro;
}

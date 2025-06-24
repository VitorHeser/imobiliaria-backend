package br.com.heserproject.imobiliaria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_locacao")
public class Locacao {

    @Id
    @Column(name = "cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_referencia")
    private LocalDate mesReferencia;

    @Column(name = "vl_valor")
    private Double valor;

    @JoinColumn(name = "id_imovel")
    @ManyToOne(fetch = FetchType.LAZY)
    private Imovel imovel;
}

package br.com.senai.Entregas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

//Lombok
@Getter
@Setter
//Obrigatrorio para o JPA funcionar
@NoArgsConstructor
@AllArgsConstructor

//JPA
//INFORMA QUE ESSA CLASSE E UMA TABELA
@Entity
//Table-Permite que voce configure a tabela
@Table(name = "entregas")
public class Entregas {
    //ID-define que a chave primaria
    @Id
    //Generate value-define que a chave e gerenciuada pelo BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //column- configura a coluna
    //name-nome da coluna
    //nullable- se pode ser nulo ou nao

    @Column(name ="entrega_id",nullable = false)
    private Integer entregaId;

    @Column(name = "descricao_produto", nullable = false, columnDefinition = "text")
    private String descricaoProduto;

    @Column(name = "status", nullable = false,columnDefinition = "text")
    private String status;


    @Column(name = "data_pedido", nullable = false)
    private OffsetDateTime dataPedido;



    //muitos Usuarios para um Tipo Usuario
    //Fetchtyper.Eager - carreha od dados Juntos
    //Optional - se e obrigatorio ou nao

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    //Avisar para o java, qual coluna do tipo usuario que vou relacionar

    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;







}

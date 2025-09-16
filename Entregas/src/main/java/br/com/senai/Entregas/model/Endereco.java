package br.com.senai.Entregas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Lombok
@Getter
@Setter

//Obrigatorio para o JPA Funcionar
@NoArgsConstructor
@AllArgsConstructor

//JPA
//INFORMAR QUE ESSA CLASSE E UMA TABELA

@Entity

//Table-Permite que voce configure a tabela
@Table(name = "endereco")

public class Endereco {
    //ID-  define que a chave primaria
    @Id

    //GENERATE VALUE- DEFINE QUE A CHAVE E GERENCIADA PELO BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //column - configura a coluna
    //name - nome da coluna
    //nullable - se poide ser nulo ou nao

    @Column(name = "endereco_id", nullable = false)
    private Integer enderecoId;


    //Muitos Usuarios para um Tipo Usuario
    //FetchTyper.Eager - carrega os dados Juntos
    //Optional - se e obrigatorio ou nao
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    //Avisar para o Java, qual coluna do tipo usuario que vou relacionar
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "lorgadouro" ,  nullable = false ,columnDefinition = "text")
    private String lorgadouro;

    @Column(name = "numero" , nullable = false , length = 10)
    private String numero;

    @Column(name = "cidade", nullable = false , columnDefinition = "text")
    private String cidade;

    @Column(name = "cep" , nullable = false , length = 10)
    private String cep;





}

package br.com.senai.Entregas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Lombok
@Getter
@Setter

//Obrigatorio para o JPA funcionar
@NoArgsConstructor
@AllArgsConstructor

//JPA
//INFORMA QUE ESSA CLASSE E UMA TABELA
@Entity
//Table-Permite que voce configure a tabela
@Table(name = "tipo_usuario")
public class TipoUsuario {

    //ID-define que e chave primaria
    @Id
    //Generate value-define que a chave  e gerencuada pelo BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //column - configura a coluna
    //name- nome da coluna
    //nullable- se pode ser nulo ou nao
    @Column(name = "tipo_usuario_id", nullable = false)
    private Integer tipoUsuarioId;

    @Column(name="descricao", nullable = false, columnDefinition = "text")
    private String descricao;

}

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
@Table(name = "usuario")

public class Usuario {

    //ID-define que e chave primaria
    @Id
    //Generate value-define que a chave  e gerenciada pelo BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //column - configura a coluna
    //name- nome da coluna
    //nullable- se pode ser nulo ou nao
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "email", nullable = false,unique = true)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;


    //Muitos Usuarios para um Tipo Usuario
    //FetchType.Eager - carrega os dados juntos
    //Optional - Se e obrigatorio ou nao
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    // Avisar para o Java , qual coluna do tipo usuario  que vou relacionar

    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario tipoUsuario;




}

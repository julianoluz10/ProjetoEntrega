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
//INFORMAR QUE ESSA CLASSE E UMA TABELA

@Entity
//Table-Permite que voce configure a tabela
@Table(name = "veiculo")

public class Veiculos {
    //ID- define que a chave primaria

    @Id
    // generate value-define que a chave  e gerenciada pelo BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //colum - configura a colluna
    //name- nome da coluna
    //nullable se pode ser nulo ou nao

    @Column(name= "identificador_unico", nullable = false)
    private Integer identificadorUnico;

    @Column(name = "placa", nullable = false, unique = true , length = 10)
    private String placa;

    @Column(name = "modelo", nullable = false, columnDefinition = "text")
    private String modelo;

    @Column(name = "tipo", nullable = false,columnDefinition = "text")
    private String tipo;

    //Muitos Usuarios para um Tipo Usuario
    //FetchTyper - carrega os dados Juntos
    //Optional- se e obrigatorio ou nao

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    //Avisar para o jave, qual coluna do tipo que vou relacionar

    @JoinColumn(name= "entregador_id")
    private Usuario entregador;





}

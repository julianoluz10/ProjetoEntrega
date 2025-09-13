package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    //Controller-> Service
    private final ClienteService clienteService;
    public ClienteController(ClienteService service) {

        clienteService = service;
    }
    //Listar Todos
    @GetMapping
    public ResponseEntity<List<Cliente>> ListarClientes(){
        //1.Pegar a lista de clientes

        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> CadastrarCliente(
           @RequestBody Cliente cliente
    ){
        //1. TENTAR CADASTRAR O CLIENTE
        clienteService.CadastrarCliente(cliente);
        //codigo 200-04
        //return ResponseEntity.ok(cliente);
        //codigo 201-create
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
    //Buscar cliente por ID
    //GET,POST ,PUT,DELETE
    @GetMapping("/{id}")
    //path variable--> recebe um valor no link
    // request body -->
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id){
        //1.Procurar o cliente
        Cliente cliente = clienteService.buscarPorId(id);


        //2. Se nao encontrar, retorno um erro
        if(cliente == null){
            //MaisSimples:
            //return ResponseEntity.notFound().build();
            //Mais detalhe:
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body(" Cliente " + id + "Nao encontrado");

        }


        //3. se encontrar,retorna o Cliente
        return ResponseEntity.ok(cliente);
    }
    // get,post,put,delete

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarClientePorId(@PathVariable Integer id){
        //1.verifico se o cliente existe
        Cliente cliente = clienteService.deletarCliente(id);

        //2. se nao existir retorno o erro
        if(cliente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body(" Cliente " + id + "Nao encontrado");
        }


        //3.se existir,retorna ok
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(
            @PathVariable Integer id, @RequestBody Cliente clienteNovo){
        //1.Tento atualizar o cliente
        Cliente cliente = clienteService.atualizarCliente(id, clienteNovo);

        //2.Se nao achar o Cliente, mostro o erro
        if(cliente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" Cliente " + id + "Nao encontrado");
        }

        //3.Se achar retorno ok
        return ResponseEntity.ok(cliente);

    }




}

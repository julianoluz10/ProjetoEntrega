package br.com.ecommerce.api.controller;



import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoControler {
    //Controler-->Service
    private final PedidoService pedidoService;

    public PedidoControler(PedidoService pedido) {
        pedidoService = pedido;
    }
    //Listar Todos
    @GetMapping
    public ResponseEntity<List<Pedido>> ListarPedido(){
        //1.Pegar a lista de pedido
        List<Pedido> pedido = pedidoService.listarTodos();
        return ResponseEntity.ok(pedido);
    }
    @PostMapping
    public ResponseEntity<Pedido> CadastrarPedido(
            @RequestBody Pedido pedido
    ){
        //1. TENTAR CADASTRAR O PEDIDO
        pedidoService.CadastrarPedido(pedido);
        //codigo 200-04
        //return ResponseEntity.ok(pedido);
        //codigo 201-create
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
    //Buscar pedido por ID
    //GET,POST,PUT,DELETE
    @GetMapping("/{id}")
    //path variable--> recebe um valor no link
    //request body-->
    public ResponseEntity<?> buscarPedido(@PathVariable Integer id){
        //1.Procurar o pedido
        Pedido pedido = pedidoService.buscarPedidoPorId(id);

        //2. Se nao encontrar, retorna um erro
        if(pedido == null){
            //Mais Simples:
            //return ResponseEntity.notFound().build();
            //Mais detalhe:
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body(" pedido " + id + " Nao encontrado");
        }
        //3. se encontrar, retorna o Pedido
        return ResponseEntity.ok(pedido);

    }
    //get,post,put,delete

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido(@PathVariable Integer id){
        //1.verifico se o pedido existe
        Pedido pedido = pedidoService.deletarPedido(id);

        //2.se nao existir retorna o erro
        if(pedido == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body(" pedido " + id + " Nao encontrado");
        }
        //3.se existir, retorna ok
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPedido(
            @PathVariable Integer id, @RequestBody Pedido pedidoNovo) {


        //1.tento atualizar o pedido
        Pedido pedido = pedidoService.atualizarPedido(id, pedidoNovo);

        //2.Se nao achar o Pedido, mostre o erro
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido " + id + "Nao encontrado");
        }


        //3.Se achar retorna ok
        return ResponseEntity.ok(pedido);

    }

}

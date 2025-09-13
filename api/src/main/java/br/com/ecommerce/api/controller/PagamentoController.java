package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {
    //Controler->Service
    private final PagamentoService pagamentoService;
    public  PagamentoController(PagamentoService pagamento) {
        pagamentoService = pagamento;
    }
    //Listar Todos
    @GetMapping
    public ResponseEntity<List<Pagamento>> ListarPagamentos(){
        //1.Pegar a lista de pagamentos
        List<Pagamento> pagamentos = pagamentoService.listarTodos();
        return ResponseEntity.ok(pagamentos);
    }
    @PostMapping
    public ResponseEntity<Pagamento> CadastrarPagamento(
            @RequestBody Pagamento pagamento
    ){
        //1.TENTAR CADASTRAR O CLIENTE
        pagamentoService.CadastrarPagamento(pagamento);
        //CODIGO 201-CREATE
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }
    //Buscar pagamento por ID
    //GET, POST,PUT,DELETE
    @GetMapping("/{id}")
    //path variable-->recebe um valor no link
    //request body-->
    public ResponseEntity<?>buscarPagamentoPorId(@PathVariable Integer id){
        //1. Procurar o cliente
        Pagamento pagamento = pagamentoService.buscarPorId(id);

        //2. Se nao encontrar, retorno um erro
        if(pagamento == null){
            //Mais Simples:
            //return ResponseEntity.notFound().build();
            //Mais detalhe:
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("Pagamento " + id + "Nao encontrado");
        }
        //3. se encontrar, retorna o Pagamento
        return ResponseEntity.ok(pagamento);
    }
    //get,post,put,delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPagamentoPorId(@PathVariable Integer id){
        //1.verifico se o cliente existe
        Pagamento pagamento = pagamentoService.buscarPorId(id);

        //2. se nao existir retorna o erro
        if(pagamento == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("Pagamento " + id + "NaoEncontrado");
        }
        //3.se existir, retorna ok
        return ResponseEntity.ok(pagamento);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPagamento(
            @PathVariable Integer id,@RequestBody Pagamento pagamentoNovo){
        //1. tento atualizar o pagamento
        Pagamento Pagamento = pagamentoService.atualizarPagamento(id,pagamentoNovo);

        //2.Se nao achar o Cliente, mostra o erro
        if(Pagamento == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pagamento " + id + "NaoEncontrado");
        }
        //3.Se achar retorno ok
        return ResponseEntity.ok(Pagamento);
    }

}

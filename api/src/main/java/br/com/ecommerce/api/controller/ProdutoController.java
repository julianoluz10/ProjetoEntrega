package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    //Controler->Service
    private final ProdutoService produtoService;
    public ProdutoController(ProdutoService produto) {
        produtoService = produto;
    }
    //Listar Todos
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        //1.Pegar a lista de produtos

        List<Produto> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }
   @PostMapping
    public ResponseEntity<Produto> CadastrarProduto(
            @RequestBody Produto produto
    ){
        //.TENTAR CADASTRA O Produto
        produtoService.CadastrarProduto(produto);
        //codigo-201-create
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }
    //Buscar cliente por ID
    //GET,POST,PUT,DELETE
    @GetMapping("/{id}")
    //path variable-->recebe uma valor no link
    //request body-->
    public ResponseEntity<?>buscarProdutoPorId(@PathVariable Integer id){
        //1.Procurar o Produto
        Produto produto = produtoService.buscarPorId(id);
        
        //2.Se nao encontrar, retorno um erro
        if(produto == null){
            //MaisSimples:
            //retun ResponseEntity.notFound().build()
            //Mais detalhe
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto "+ id + "Nao encontrado");
        }
        //3. se existir, retorna ok
        return ResponseEntity.ok(produto);
    }
    //get, post, put, delete

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProdutoPorId(@PathVariable Integer id){
        //1. verifico se o cliente existe
        Produto produto = produtoService.buscarPorId(id);

        //2. se nao existir retorna o erro
        if(produto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("Produto "+ id + "Nao encontrado");
        }
        //3. se existir, retorna ok
        return ResponseEntity.ok(produto);

    }

}

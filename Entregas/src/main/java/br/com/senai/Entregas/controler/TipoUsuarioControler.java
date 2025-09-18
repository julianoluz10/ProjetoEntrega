package br.com.senai.Entregas.controler;




import br.com.senai.Entregas.model.TipoUsuario;
import br.com.senai.Entregas.service.TipoUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos")

public class TipoUsuarioControler {

    private final TipoUsuarioService tipoUsuarioService;

    public  TipoUsuarioControler(TipoUsuarioService service){
        this.tipoUsuarioService = service;
    }
    //Listar Todos

    @GetMapping()
    public ResponseEntity<List<TipoUsuario>> listarTiposUsuarios(){
        List<TipoUsuario> tipoUsuario= tipoUsuarioService.listarTodos();
        return ResponseEntity.ok(tipoUsuario);
    }

    //Buscar por ID
    @GetMapping("/id")
    public ResponseEntity<?> buscarTipoUsuarioPorId(@PathVariable Integer id){
        TipoUsuario tipoUsuario = tipoUsuarioService.buscarPorId(id);

        if(tipoUsuario == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("Tipos de usuario nao encontrados");
        }
        return ResponseEntity.ok(tipoUsuario);
    }

    //Inserir Novo
    @PostMapping


    public ResponseEntity<TipoUsuario> inserirTipoUsuario(@RequestBody TipoUsuario tipoUsuario){
        TipoUsuario novoTipoUsuario = tipoUsuarioService.cadastrar(tipoUsuario);
        if(novoTipoUsuario == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTipoUsuario);
    }
    //Atualizar
    @PutMapping

    public ResponseEntity<?> atualizarTipoUsuario(@PathVariable Integer id, @RequestBody TipoUsuario tipoUsuario){
        TipoUsuario tipoUsuarioAtualizado = tipoUsuarioService.atualizar(id, tipoUsuario);

        if(tipoUsuarioAtualizado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("Tipos de usuario nao encontrados");
        }
        return ResponseEntity.ok(tipoUsuarioAtualizado);

       
    }



}

package br.com.senai.Entregas.controler;


import br.com.senai.Entregas.model.Usuario;
import br.com.senai.Entregas.repository.UsuarioRepository;
import br.com.senai.Entregas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioControler {
    private final UsuarioService usuarioService;
    public UsuarioControler(UsuarioService service) {
        this.usuarioService = service ;

    }
    //Listar Todos

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }
    //Inserir Novo

    @PostMapping
    public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario usuario){
        Usuario UsuarioNovo = usuarioService.cadastrar(usuario);

        if(UsuarioNovo == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioNovo);

    }

}

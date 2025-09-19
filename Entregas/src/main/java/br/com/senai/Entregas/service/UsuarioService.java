package br.com.senai.Entregas.service;


import br.com.senai.Entregas.model.Usuario;
import br.com.senai.Entregas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    //Injecao de Dependencia
    //Falar que service depende de alguem
    //Final constante

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    //Listar todos os Usuarios
    public List<Usuario> listarTodos(){

        return usuarioRepository.findAll();
    }



    public  Usuario buscarPorId(Integer id){
        return usuarioRepository.findById(id).orElse(null);}

    public Usuario cadastrar(Usuario usuario){
        return usuarioRepository.save(usuario);}

    public Usuario atualizar(Integer id, Usuario usuarioNovo){
        Usuario usuarioAntigo = buscarPorId(id);

        if(usuarioAntigo == null){
            return null;
        }
        usuarioAntigo.setUsuarioId(usuarioNovo.getUsuarioId());
        return usuarioRepository.save(usuarioAntigo);
    }
    public Usuario deletar(Integer id){
        Usuario usuarioAntigo = buscarPorId(id);

        if(usuarioAntigo == null){
            return null;
        }
        usuarioRepository.delete(usuarioAntigo);
        return usuarioAntigo;
    }
}

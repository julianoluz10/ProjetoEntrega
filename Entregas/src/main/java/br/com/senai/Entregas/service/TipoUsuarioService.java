package br.com.senai.Entregas.service;


import br.com.senai.Entregas.model.TipoUsuario;
import br.com.senai.Entregas.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TipoUsuarioService {
    //Injecao de Dependencia
    //Falar que service depende de alguem
    //final constante
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }
    //Listar todos os Usuarios
    public List<TipoUsuario> listarTodos(){
        return tipoUsuarioRepository.findAll();
    }



    public TipoUsuario buscarPorId(Integer id){
        return tipoUsuarioRepository.findById(id).orElse(null);
    }

    public TipoUsuario cadastrar(TipoUsuario tipoUsuario){
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public TipoUsuario atualizar(Integer id, TipoUsuario tipoUsuarioNovo){
        TipoUsuario tipoUsuarioAntigo =  buscarPorId(id);

        if(tipoUsuarioAntigo == null){
            return null;
        }
        tipoUsuarioAntigo.setDescricao(tipoUsuarioNovo.getDescricao());
        return TipoUsuarioRepository.save(tipoUsuarioAntigo);
    }
    public TipoUsuarioRepository deletePorId(Integer id){
        TipoUsuario Tipo = buscarPorId(id);

        if(tipoUsuarioAntigo == null){
            return null;
        }
        TipoUsuarioRepository.delete(tipoUsuarioAntigo);
        return tipoUsuarioAntigo;
    }


}

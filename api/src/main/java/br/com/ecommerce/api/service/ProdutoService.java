package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    //Injecao de Dependencia
    //Falar que Service depende de  alguem
    // final constante
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository prod) {

        produtoRepository = prod;
    }

    //Listar todos os Produtos

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
    //Insert Into
    public Produto CadastrarProduto(Produto produto){
        return produtoRepository.save(produto);
    }
    public Produto buscarPorId(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }
    public Produto deletarProduto(Integer id){
        //1.verifico se o cliente existe
        Produto produto = buscarPorId(id);

        //2. se nao existir, retorno nulo
        if(produto == null){
            return null;
        }
        //3. se existir, excluo
        produtoRepository.delete(produto);
        return produto;
    }
}

package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    //Injecao de Dependecia
    //Falar que Service depende de alguem
    //final constante
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedido){
        pedidoRepository = pedido;
    }

    //Listar todos os Clientes
    public List<Pedido> buscarTodos(){
        return pedidoRepository.findAll();
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
    //INSERT INTO blabla
    public Pedido CadastrarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    public Pedido buscarPedidoPorId(Integer id){
        return pedidoRepository.findById(id).orElse(null);
    }
    public Pedido deletarPedido(Integer id){
        //1.verifico se o cliente existe
        Pedido pedido = buscarPedidoPorId(id);

        //2. se nao existir, retorno nulo

        if(pedido == null){
            return null;
        }
        //3. se existir, excluo
        pedidoRepository.delete(pedido);
        return pedido;
    }
    public Pedido atualizarPedido(Integer id, Pedido pedidoNovo){
        //1.Procurar quem eu quero atualizar
        Pedido pedidoAntigo = buscarPedidoPorId(id);

        //2.Se eu nao achar o retorno null
        if(pedidoAntigo == null){
            return null;
        }
        //3.Se eu achar o cliente e atualizo
        pedidoAntigo.setStatus(pedidoNovo.getStatus());
        pedidoAntigo.setDataPedido(pedidoNovo.getDataPedido());
        pedidoAntigo.setIdCliente(pedidoNovo.getIdCliente());
        return pedidoRepository.save(pedidoAntigo);
    }
}

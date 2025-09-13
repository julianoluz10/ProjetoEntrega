package br.com.ecommerce.api.service;


import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    //Injecao de Dependecia
    //Falar que Service depende de alguem
    //final constante
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamento) {
        pagamentoRepository = pagamento;
    }
    //Listar todos os Clientes
    public List<Pagamento> listarTodos(){
        return pagamentoRepository.findAll();
    }
    //INSERT INTO
    public Pagamento CadastrarPagamento(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }
    public Pagamento buscarPorId(Integer id){
        return pagamentoRepository.findById(id).orElse(null);
    }
    public Pagamento deletarPagamento(Integer id){
        //1.verificar se o pagamento existe
        Pagamento pagamento = buscarPorId(id);

        //2. se nao existir, retorna nulo
        if(pagamento==null){
            return null;
        }
        //3. se existir, excluo
        pagamentoRepository.delete(pagamento);
        return pagamento;

    }
    public Pagamento atualizarPagamento(Integer id, Pagamento pagamentoNovo) {
        //1.Procurar quem eu quero atualizar
        Pagamento pagamentoAntigo = buscarPorId(id);

        //2.sE EU NAO ACHAR RETORNO NULL
        if (pagamentoAntigo == null) {
            return null;
        }

            //3.Se eu achar o cliente eu atualizo
            pagamentoAntigo.setIdPedido(pagamentoNovo.getIdPedido());
            pagamentoAntigo.setDataPagamento(pagamentoNovo.getDataPagamento());
            pagamentoAntigo.setFormaPagamento(pagamentoNovo.getFormaPagamento());
            return pagamentoRepository.save(pagamentoAntigo);




    }
}

package Controller;

import Entity.Alocacao;

import Service.AlocacaoService;

public class AlocacaoController {
    AlocacaoService service = new AlocacaoService();
    public boolean comprarTicket(Alocacao alocacao){
        return service.comprarTicket(alocacao);
    }
}

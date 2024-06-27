package one.digitalinovation.gof.facade;

import subsistema1.crm.CrmService;
import subsistema2.cep.CepAPI;

public class Facade {
	public void migrarCliente(String nome, String cep) {
		CrmService.graverCliente(nome, cep, CepAPI.getInstancia().recuperarCidade(cep), CepAPI.getInstancia().recuperarEstado(cep));
	}
}

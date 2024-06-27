package one.digitalinovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinovation.gof.model.Cliente;
import one.digitalinovation.gof.model.ClienteRepository;
import one.digitalinovation.gof.model.Endereco;
import one.digitalinovation.gof.model.EnderecoRepository;
import one.digitalinovation.gof.service.ClienteService;
import one.digitalinovation.gof.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService{
	// TODO Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	// TODO Strategy: Implementar os métodos definidos na interface.
	// TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples
	
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		// TODO Auto-generated method stub
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> { 
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco; 
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		Optional<Cliente> clienteBD = clienteRepository.findById(id);
		if(clienteBD.isPresent()) {
			inserir(cliente);
		}
		
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}
	
}

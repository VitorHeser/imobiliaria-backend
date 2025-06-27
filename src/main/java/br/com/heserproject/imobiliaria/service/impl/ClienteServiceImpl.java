package br.com.heserproject.imobiliaria.service.impl;

import br.com.heserproject.imobiliaria.domain.entity.Cliente;
import br.com.heserproject.imobiliaria.repository.ClienteRepository;
import br.com.heserproject.imobiliaria.service.ClienteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.saveAndFlush(endereco);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado."));
    }

    @Override
    @Transactional
    public Cliente atualizar(Integer id, Cliente cliente) {
        cliente.setId(id);
        return salvar(cliente);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        clienteRepository.deleteById(id);
    }

}

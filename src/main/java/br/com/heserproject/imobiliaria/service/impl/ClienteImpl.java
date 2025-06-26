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
public class ClienteImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.saveAndFlush(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado."));
    }

    @Override
    @Transactional
    public Cliente atualizar(Long id, Cliente cliente) {
        cliente.setId(id);
        return salvar(cliente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}

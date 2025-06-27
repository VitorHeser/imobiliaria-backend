package br.com.heserproject.imobiliaria.service.impl;

import br.com.heserproject.imobiliaria.domain.entity.Imobiliaria;
import br.com.heserproject.imobiliaria.repository.ImobiliariaRepository;
import br.com.heserproject.imobiliaria.service.ImobiliariaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImobiliariaServiceImpl implements ImobiliariaService {

    private final ImobiliariaRepository imobiliariaRepository;

    @Override
    @Transactional
    public Imobiliaria salvar(Imobiliaria imobiliaria) {
        return imobiliariaRepository.saveAndFlush(imobiliaria);
    }

    @Override
    public List<Imobiliaria> findAll() {
        return imobiliariaRepository.findAll();
    }

    @Override
    public Imobiliaria findById(Integer id) {
        return imobiliariaRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado."));
    }

    @Override
    @Transactional
    public Imobiliaria atualizar(Integer id, Imobiliaria imobiliaria) {
        imobiliaria.setId(id);
        return salvar(imobiliaria);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        imobiliariaRepository.deleteById(id);
    }
}

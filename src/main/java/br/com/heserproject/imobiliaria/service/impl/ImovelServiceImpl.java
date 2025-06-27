package br.com.heserproject.imobiliaria.service.impl;

import br.com.heserproject.imobiliaria.domain.entity.Imovel;
import br.com.heserproject.imobiliaria.repository.ImovelRepository;
import br.com.heserproject.imobiliaria.service.ImovelService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImovelServiceImpl implements ImovelService {

    private final ImovelRepository imovelRepository;

    @Override
    @Transactional
    public Imovel salvar(Imovel imovel) {
        return imovelRepository.saveAndFlush(imovel);
    }

    @Override
    public List<Imovel> findAll() {
        return imovelRepository.findAll();
    }

    @Override
    public Imovel findById(Integer id) {
        return imovelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado."));
    }

    @Override
    @Transactional
    public Imovel atualizar(Integer id, Imovel imovel) {
        imovel.setId(id);
        return salvar(imovel);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        imovelRepository.deleteById(id);
    }

}

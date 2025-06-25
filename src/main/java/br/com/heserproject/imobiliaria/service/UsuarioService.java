package br.com.heserproject.imobiliaria.service;

import br.com.heserproject.imobiliaria.domain.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario salvar(Usuario usuario);

    List<Usuario> findAll();

    Usuario findById(Long idCpf);

    Usuario atualizar(Long idCpf, Usuario usuario);

    void deleteById(Long id);
}

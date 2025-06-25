package br.com.heserproject.imobiliaria.service.impl;

import br.com.heserproject.imobiliaria.domain.entity.Usuario;
import br.com.heserproject.imobiliaria.repository.UsuarioRepository;
import br.com.heserproject.imobiliaria.service.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.saveAndFlush(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado."));
    }

    @Override
    @Transactional
    public Usuario atualizar(Long id_Cpf, Usuario usuario) {
        usuario.SetCpf(id_Cpf);
        return salvar(usuario);
    }

    @Override
    @Transactional
    public void deleteById(Long id_Cpf) {
        usuarioRepository.deleteById(id_Cpf);
    }
}

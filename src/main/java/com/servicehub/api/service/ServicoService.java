package com.servicehub.api.service;

import com.servicehub.api.entity.Servico;
import com.servicehub.api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public List<Servico> listarTodos() {
        return repository.findAll();
    }

    public Optional<Servico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Servico salvar(Servico servico) {
        return repository.save(servico);
    }

    public Optional<Servico> atualizar(Long id, Servico servicoAtualizado) {
        return repository.findById(id).map(servico -> {
            servico.setNome(servicoAtualizado.getNome());
            servico.setDescricao(servicoAtualizado.getDescricao());
            servico.setPreco(servicoAtualizado.getPreco());
            return repository.save(servico);
        });
    }

    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
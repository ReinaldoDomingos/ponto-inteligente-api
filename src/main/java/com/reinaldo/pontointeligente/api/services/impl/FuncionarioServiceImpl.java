package com.reinaldo.pontointeligente.api.services.impl;


import com.reinaldo.pontointeligente.api.entities.Funcionario;
import com.reinaldo.pontointeligente.api.repositories.FuncionarioRepository;
import com.reinaldo.pontointeligente.api.services.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario persistir(Funcionario funcionario) {
        log.info("\nPersistindo funcionario: {}\n", funcionario);
        return this.funcionarioRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> buscarPorCpf(String cpf) {
        log.info("\nBuscando funcionario pelo CPF {}\n", cpf);
        return Optional.ofNullable(funcionarioRepository.findByCpf(cpf));
    }

    @Override
    public Optional<Funcionario> buscarPorEmail(String email) {
        log.info("\nBuscando funcionario pelo email {}\n", email);
        return Optional.ofNullable(funcionarioRepository.findByEmail(email));
    }


    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        log.info("\nBuscando funcionario pelo ID {}\n", id);
        return funcionarioRepository.findById(id);
    }


}

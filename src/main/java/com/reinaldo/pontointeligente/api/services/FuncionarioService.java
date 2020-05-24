package com.reinaldo.pontointeligente.api.services;

import com.reinaldo.pontointeligente.api.entities.Empresa;
import com.reinaldo.pontointeligente.api.entities.Funcionario;

import java.util.Optional;

public interface FuncionarioService {
    /**
     * Persiste um funcionario na base de dados
     *
     * @param funcionario
     * @return Funcionario
     */
    Funcionario persistir(Funcionario funcionario);

    /**
     * Busca e retorna um funcionario dado um CPF.
     *
     * @param cpf
     * @return Optional<Funcionario>
     */
    Optional<Funcionario> buscarPorCpf(String cpf);

    /**
     * Busca e retorna um funcionario dado um email.
     *
     * @param email
     * @return Optional<Funcionario>
     */
    Optional<Funcionario> buscarPorEmail(String email);

    /**
     * Busca e retorna um funcionario dado um ID.
     *
     * @param id
     * @return Optional<Funcionario>
     */
    Optional<Funcionario> buscarPorId(Long id);

}

package com.reinaldo.pontointeligente.api.repositories;

import com.reinaldo.pontointeligente.api.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByCpf(String cṕf);

    Funcionario findByEmail(String email);

    Funcionario findByCpfOrEmail(String cpf, String email);
}

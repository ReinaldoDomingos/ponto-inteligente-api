package com.reinaldo.pontointeligente.api.services.impl;


import com.reinaldo.pontointeligente.api.entities.Empresa;
import com.reinaldo.pontointeligente.api.repositories.EmpresaRepository;
import com.reinaldo.pontointeligente.api.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Optional<Empresa> buscarPorCnpj(String cnpj) {
        log.info("\nBuscando uma empresa para o CNPJ {}\n", cnpj);
        return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
    }

    @Override
    public Empresa persistir(Empresa empresa) {
        log.info("\nPersistindo empresa: {}\n", empresa);
        return this.empresaRepository.save(empresa);
    }
}

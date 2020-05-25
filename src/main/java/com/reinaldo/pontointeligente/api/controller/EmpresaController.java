package com.reinaldo.pontointeligente.api.controller;

import com.reinaldo.pontointeligente.api.dtos.CadastroPFDto;
import com.reinaldo.pontointeligente.api.dtos.EmpresaDto;
import com.reinaldo.pontointeligente.api.entities.Empresa;
import com.reinaldo.pontointeligente.api.entities.Funcionario;
import com.reinaldo.pontointeligente.api.enums.PerfilEnum;
import com.reinaldo.pontointeligente.api.response.Response;
import com.reinaldo.pontointeligente.api.services.EmpresaService;
import com.reinaldo.pontointeligente.api.services.FuncionarioService;
import com.reinaldo.pontointeligente.api.utils.PasswordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "*")
public class EmpresaController {
    private static final Logger log = LoggerFactory.getLogger(EmpresaController.class);

    @Autowired
    private EmpresaService empresaService;

    public EmpresaController() {
    }

    /**
     * Retorna uma empresa dado um CNPJ
     *
     * @param cnpj
     * @return ResponseEntity<Response < EmpresaDto>>
     */
    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Response<EmpresaDto>> buscarPorCnpj(@PathVariable("cnpj") String cnpj) {
        log.info("Buscando empresa por CNPJ: {}", cnpj);
        Response<EmpresaDto> response = new Response<EmpresaDto>();
        Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(cnpj);

        if (!empresa.isPresent()) {
            log.info("Empresa não encontrada para o CNPJ {}", cnpj);
            response.getErrors().add("Empresa não encontrada para o CNPJ " + cnpj);
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(this.converterEmpresaDto(empresa.get()));
        return ResponseEntity.ok(response);
    }

    /**
     * Popula  um DTO com os dados de uma empresa.
     *
     * @param empresa
     * @return EmpresaDto
     */
    private EmpresaDto converterEmpresaDto(Empresa empresa) {
        EmpresaDto empresaDto = new EmpresaDto();
        empresaDto.setId(empresa.getId());
        empresaDto.setCnpj(empresa.getCnpj());
        empresaDto.setRazaoSocial(empresa.getRazaoSocial());

        return empresaDto;
    }
}

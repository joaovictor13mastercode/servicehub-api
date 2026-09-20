package com.servicehub.api.controller;

import com.servicehub.api.entity.Servico;
import com.servicehub.api.service.ServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@Tag(name = "Serviços", description = "Endpoints para gerenciamento do catálogo de serviços")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @PostMapping
    @Operation(summary = "Criar um novo serviço")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Serviço criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<Servico> criar(@RequestBody Servico servico) {
        Servico novoServico = service.salvar(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }

    @GetMapping
    @Operation(summary = "Listar todos os serviços")
    public ResponseEntity<List<Servico>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar serviço por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Serviço encontrado"),
        @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
    })
    public ResponseEntity<Servico> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um serviço existente")
    public ResponseEntity<Servico> atualizar(@PathVariable Long id, @RequestBody Servico servico) {
        return service.atualizar(id, servico)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um serviço")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
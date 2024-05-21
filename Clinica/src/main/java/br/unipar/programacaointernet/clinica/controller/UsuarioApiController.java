package br.unipar.programacaointernet.clinica.controller;

import br.unipar.programacaointernet.clinica.model.Usuario;
import br.unipar.programacaointernet.clinica.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioApiController {
  private final UsuarioService usuarioService;

  public UsuarioApiController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @GetMapping(path = "/api/usuarios")
  @Operation(summary = "Obter todos os usuários", description = "Retorna uma lista")
  public ResponseEntity<List<Usuario>> getAll() {
    return ResponseEntity.ok(this.usuarioService.getAll());
  }

  @PostMapping(path = "/api/usuarios")
  @Operation(summary = "Salvar usuário", description = "Salva um novo usuário")
  public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
    return ResponseEntity.ok(this.usuarioService.save(usuario));
  }
}

package br.unipar.programacaointernet.clinica.controller;

import br.unipar.programacaointernet.clinica.model.Usuario;
import br.unipar.programacaointernet.clinica.service.UsuarioService;
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
  public ResponseEntity<List<Usuario>> getAll() {
    return ResponseEntity.ok(this.usuarioService.getAll());
  }

  @PostMapping(path = "/api/usuarios")
  public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
    return ResponseEntity.ok(this.usuarioService.save(usuario));
  }
}

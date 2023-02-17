package com.example.LojaGames.Controller;

import com.example.LojaGames.model.Categoria;
import com.example.LojaGames.model.Usuario;
import com.example.LojaGames.repository.CategoriaRepository;
import com.example.LojaGames.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;



    @RestController
    @RequestMapping("/usuario")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public class UsuarioController {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @GetMapping
        public ResponseEntity<List<Usuario>> getAll() {
            return ResponseEntity.ok(usuarioRepository.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Usuario> getById(@PathVariable Long id) {
            return usuarioRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        }

        @GetMapping("nome/{nome}")
        public ResponseEntity<List<Usuario>> getByTipo(@PathVariable String nome) {
            return ResponseEntity.ok(usuarioRepository.findAllByNomeContainingIgnoreCase(nome));
        }


        @PostMapping("/cadastrar")
        public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario usuario){
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
        }

        @PutMapping("/atualizar")
        public ResponseEntity<Usuario> put(@Valid @RequestBody Usuario usuario){
            return usuarioRepository.findById(usuario.getId()).map(resposta -> ResponseEntity.status(HttpStatus.OK)
                    .body(usuarioRepository.save(usuario)))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

        }
}

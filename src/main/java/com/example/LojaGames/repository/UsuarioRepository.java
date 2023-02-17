package com.example.LojaGames.repository;

import com.example.LojaGames.model.Produto;
import com.example.LojaGames.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public List<Usuario> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}

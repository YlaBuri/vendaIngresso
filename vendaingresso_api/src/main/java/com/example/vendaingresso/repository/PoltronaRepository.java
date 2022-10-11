package com.example.vendaingresso.repository;

import com.example.vendaingresso.model.Poltrona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PoltronaRepository extends JpaRepository<Poltrona, Long> {

    @Query(value = "SELECT * FROM poltrona WHERE poltrona.poltrona_id not IN (SELECT poltrona.poltrona_id FROM poltrona  INNER JOIN evento_poltrona ep ON ep.poltrona_id = poltrona.poltrona_id WHERE ep.evento_id = :idEvento) ORDER BY poltrona.poltrona_id;", nativeQuery = true)
    List<Poltrona> buscarPoltronasLivres(Long idEvento);

}

package cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.domain.Player;

@RepositoryRestResource
public interface PlayerRepository extends JpaRepository<Player, Long> {

}

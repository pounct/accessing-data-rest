package cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Game {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Byte dice1;
	private Byte dice2;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Player player;
	
	public Boolean won() {
		return (dice1+dice2==7);
	}
	
}

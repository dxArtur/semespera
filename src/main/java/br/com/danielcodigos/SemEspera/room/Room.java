package br.com.danielcodigos.SemEspera.room;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="rooms")
@Entity(name="rooms")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Room {

	@Id @GeneratedValue(strategy= GenerationType.UUID)
	private String id;
	private String name;
	private String email;
	private String password;
	
	
	public Room(RoomRequestDTO data) {
		this.name = data.name();
		this.email = data.email();
		this.password = data.password();
	}
}

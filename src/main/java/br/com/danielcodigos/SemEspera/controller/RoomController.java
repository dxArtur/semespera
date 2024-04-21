package br.com.danielcodigos.SemEspera.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielcodigos.SemEspera.room.Room;
import br.com.danielcodigos.SemEspera.room.RoomRepository;
import br.com.danielcodigos.SemEspera.room.RoomRequestDTO;
import br.com.danielcodigos.SemEspera.room.RoomResponseDTO;

@RestController
@RequestMapping("room")
public class RoomController {

	@Autowired
	private RoomRepository repository;
	
	@GetMapping
	public List<RoomResponseDTO> getAll() {
		List<RoomResponseDTO> allRooms = repository.findAll().stream().map(RoomResponseDTO::new).toList();
		return allRooms;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RoomResponseDTO> getById(@PathVariable String id) {
		Optional<RoomResponseDTO> response = repository.findById(id).map(RoomResponseDTO::new);
		if (response.isPresent()) {
			return ResponseEntity.ok(response.get());
		} else {
			return ResponseEntity.notFound().build(); 
		}
	}
	
	@PostMapping
	public void saveRoom(@RequestBody RoomRequestDTO data) {
		Room roomData = new Room(data);
		repository.save(roomData);
	}
	
}

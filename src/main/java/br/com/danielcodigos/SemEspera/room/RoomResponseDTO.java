package br.com.danielcodigos.SemEspera.room;

public record RoomResponseDTO(String id, String name, String email, String password) {
	public RoomResponseDTO(Room room) {
		this(room.getId(), room.getName(), room.getEmail(), room.getPassword());
	}
}

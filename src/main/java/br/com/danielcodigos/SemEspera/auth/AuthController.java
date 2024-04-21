package br.com.danielcodigos.SemEspera.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthController {
	
	
	@PostMapping("/signin")
	public void signin(@RequestBody SigninDTO form){
		
	}
	
	@PostMapping("/signup")
	public void signup(@RequestBody SignupDTO form){
		
	}
}

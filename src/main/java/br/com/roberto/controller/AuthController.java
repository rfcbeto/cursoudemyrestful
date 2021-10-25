package br.com.roberto.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.repository.UserRepository;
import br.com.roberto.security.AccountCredentialsVO;
import br.com.roberto.security.jwt.JwtTokenProvider;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	@Autowired
	UserRepository repository;
	
	@ApiOperation(value="Autentica um usuário de acordo com as credenciais")
	@PostMapping(value="/signin", produces = {"application/json", "application/xml", "application/x-yaml"}, 
								  consumes = {"application/json", "application/xml", "application/x-yaml"})
	public ResponseEntity signin(@RequestBody AccountCredentialsVO data){
		try {
			var username = data.getUsername();
			var password = data.getPassword();
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			var user = repository.findByUserName(username);
			var token = "";
			if (user != null ) {
				token = tokenProvider.creatToken(username, user.getRoles());
			} else {
				throw new UsernameNotFoundException("Username: "+ username + " Não encontrado!");
			}
			
			Map<Object, Object> model = new HashMap<>();
			model.put("username", user);
			model.put("token", token);
			
			return ok(model);
		} catch (Exception e) {
			throw new BadCredentialsException("Usuario inválido");
		}
	}
}

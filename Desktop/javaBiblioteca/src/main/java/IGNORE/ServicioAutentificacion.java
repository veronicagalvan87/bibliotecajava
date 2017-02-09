package IGNORE;

import org.empleodigital.domain.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ServicioAutentificacion implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@Autowired private UsuarioRepositorio usuarioRepositorio;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		
		return usuarioRepositorio.findOneByLogin(usuario);
		
	}*/

}

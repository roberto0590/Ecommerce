package com.auth.repo;

import com.auth.model.Usuario;

public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer>  {

	//select * from usuario where username = ?
	Usuario findOneByUsername(String username);	
}

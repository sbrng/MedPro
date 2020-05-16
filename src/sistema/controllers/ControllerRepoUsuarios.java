package sistema.controllers;

import sistema.beans.Usuario;
import sistema.repo.RepoUsuarios;

public class ControllerRepoUsuarios {
	private RepoUsuarios repositorio = null;
	private static ControllerRepoUsuarios controlador = null;
	
	private ControllerRepoUsuarios() {
		repositorio = new RepoUsuarios();
	}
	
	public ControllerRepoUsuarios getInstance() {
		if(controlador == null) {
			controlador = new ControllerRepoUsuarios();
		}
		return controlador;
	}
	
	public boolean adicionarUsuario(Usuario u) {
		if(u == null)
			return false;
		if(u.getDataNascimento() == null)
			return false;
		if(u.getEmail() == null)
			return false;
		if(u.getLogin() == null)
			return false;
		if(u.getNome() == null)
			return false;
		if(u.getSenha() == null)
			return false;
		if(u.getSexo() == ' ')
			return false;
		return repositorio.addUsuario(u);
	}
	
	public void deletarUsuario(Usuario u) {
		if(u == null)
			return;
		if(u.getLogin() == null)
			return;
		repositorio.deleteUsuario(u);
	}
	public void atualizarUsuario(Usuario u) {
		if(u == null)
			return;
		if(u.getDataNascimento() == null)
			return;
		if(u.getEmail() == null)
			return;
		if(u.getLogin() == null)
			return;
		if(u.getNome() == null)
			return;
		if(u.getSenha() == null)
			return;
		if(u.getSexo() == ' ')
			return;
		repositorio.attUsuario(u);
	}
	public void pegarLista() {
		repositorio.getLista();
	}

}

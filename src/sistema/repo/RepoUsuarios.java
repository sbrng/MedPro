package sistema.repo;

import java.util.List;

import sistema.beans.UsuarioDAO;

public class RepoUsuarios {
	private UsuarioDAO usuarioPadrao = UsuarioDAO.getInstance();
	private String usuarioGuardado = null;
	private String senhaGuardada = null;
	
	public String getUsuarioGuardado() {
		return usuarioGuardado;
	}
	public void setUsuarioGuardado(String usuarioGuardado) {
		this.usuarioGuardado = usuarioGuardado;
	}
	public String getSenhaGuardada() {
		return senhaGuardada;
	}
	public void setSenhaGuardada(String senhaGuardada) {
		this.senhaGuardada = senhaGuardada;
	}
	public boolean addUsuario(Usuario u) {
		return usuarioPadrao.create(u);
	}
	public void deleteUsuario(Usuario u) {
		usuarioPadrao.delete(u);
	}
	public void attUsuario(Usuario u) {
		usuarioPadrao.update(u);
	}
	public List<Usuario> getLista(){
		return usuarioPadrao.read();
	}
	
	
	

	public UsuarioDAO getUsuarioPadrao() {
		return usuarioPadrao;
	}

	public void setUsuarioPadrao(UsuarioDAO usuarioPadrao) {
		this.usuarioPadrao = usuarioPadrao;
	}
	
	
	
	
	
}

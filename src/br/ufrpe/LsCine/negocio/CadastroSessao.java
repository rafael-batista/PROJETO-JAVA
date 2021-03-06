package br.ufrpe.LsCine.negocio;
import java.util.ArrayList;

import br.ufrpe.LsCine.dados.RepositorioSessao;
import br.ufrpe.LsCine.exceptions.IDSalaInvalidoException;
import br.ufrpe.LsCine.exceptions.NaoExisteException;
import br.ufrpe.LsCine.exceptions.SessaoException;
import br.ufrpe.LsCine.interfaces.IRepositorioSessao;
import br.ufrpe.LsCine.negocio.beans.Sessao;


public class CadastroSessao {

	private IRepositorioSessao repositorioSessao;
	
	public CadastroSessao() {
		this.repositorioSessao = RepositorioSessao.getInstance();
	}
	
	public boolean adicionarSessao(Sessao sessao) throws SessaoException{
		
		Sessao sessaoExiste = this.procurarID(sessao.getId());
		if(sessaoExiste != null){
			throw new SessaoException();
		}
		
		if (sessao != null) {
			return this.repositorioSessao.adicionar(sessao);
		}
		
		throw new SessaoException();
		
		
	}
	
	public boolean removerSessao(int id) throws NaoExisteException{
		if(this.repositorioSessao.procurar(id)!=null){
			return this.repositorioSessao.remover(id);
		}
		throw new NaoExisteException();
	}
	public boolean conferirHorario(){
		return true;
	}
	
	public void buscarPorFilme(String nome){
			if(this.repositorioSessao.buscarNome(nome) != null){
				this.repositorioSessao.listarNome(nome);
			}		
	}
	
	public boolean editarSessao(Sessao sessao) throws SessaoException{
		if(this.repositorioSessao.procurar(sessao.getId())!=null){
			return this.repositorioSessao.alterar(sessao);
		}
		throw new SessaoException();
	}
	
	public Sessao procurarID(int codigo){
			return this.repositorioSessao.procurar(codigo);			
	}
	
	/*public void buscarPorSala(int sala){
			if(this.repositorioSessao.buscar(sala) != null){
				this.repositorioSessao.listarSala(sala);
			}		
	}		*/
	
	public IRepositorioSessao getRepositorioSessao() {
		return repositorioSessao;
	}

	public void setRepositorioSessao(RepositorioSessao repositorioSessao) {
		this.repositorioSessao = repositorioSessao;
	}
	
	public ArrayList<Sessao> listar(){
		return this.repositorioSessao.listar();
	}

}
package br.ufrpe.LsCine.interfaces;

import br.ufrpe.LsCine.negocio.beans.Ingresso;
import java.util.ArrayList;

public interface IRepositorioIngresso {

	public boolean inserir(Ingresso ingresso);
	
	public Ingresso buscar(int id);
	
	public boolean remover(int id);
	
	public float financeiroIngresso();
	
	public ArrayList<Ingresso> listaVendas();
	
}

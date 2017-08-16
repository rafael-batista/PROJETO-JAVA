package br.ufrpe.LsCine.gui;

import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Filme;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Alert;

public class AdicionarFilmeController{
	
	private Fachada fachada = Fachada.getInstancia();
	
	@FXML JFXTextField tfNome, tfDuracao;
	@FXML JFXComboBox <String> cbClassificacao; 
	@FXML ObservableList<String> list = FXCollections.observableArrayList("Livre","+10","+12","+14","+16","+18");	
	
	@FXML
	public void initialize() {
		cbClassificacao.setItems(list);
		cbIdioma.setItems(list2);
	}
	
	public void inserir(){
		try{
			Filme f = new Filme();
			f.setNome(tfNome.getText());
			f.setDuracao(Integer.valueOf(tfDuracao.getText()));
			f.setClassificacao(cbClassificacao.getValue());
			Fachada.getInstancia().getCadastroF().cadastrar(f);
			//fachada.getInstancia().getCadastroF().cadastrar(f);
			
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
	        	dialogoInfo.setTitle("Filme adicionado com sucesso!");
	        	dialogoInfo.setHeaderText(null);
	        	dialogoInfo.setContentText(f.toString());
	        	dialogoInfo.showAndWait();
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void voltar(){
		try{
			Telas.getInstance().getMenu();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}

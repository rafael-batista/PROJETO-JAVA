package br.ufrpe.LsCine.gui;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import br.ufrpe.LsCine.exceptions.NaoExisteException;
import br.ufrpe.LsCine.negocio.Fachada;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RemoverFilmeController implements Initializable{

	private Fachada fachada = Fachada.getInstancia();
	@FXML JFXTextField tfNome;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void remover() throws NaoExisteException{
		try{
			Fachada.getInstancia().getCadastroF().remover(tfNome.getText());
		}catch(Exception NaoExisteException){
			//System.out.println(e.getMessage());
			throw new NaoExisteException();
		}
	}
	
	public void removerb() throws NaoExisteException{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(this.getClass().getResource("/br/ufrpe/LsCine/imagens/Logo.png").toString()));
		alert.setTitle("Confirmar exclus�o");
		alert.setHeaderText("Voc� tem certeza de que quer excluir?");
		alert.setContentText(Fachada.getInstancia().getCadastroF().buscar(tfNome.getText()).toString());

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    this.remover();
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
	
	public void filme(){
		try{
			Telas.getInstance().getTelaFilmes();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void sala(){
		try{
			Telas.getInstance().getTelaSalas();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void sessao(){
		try{
			Telas.getInstance().getTelaSessao();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void financeiro(){
		try{
			Telas.getInstance().getFinanceiro();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

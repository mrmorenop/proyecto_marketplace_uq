package co.edu.uniquindio.marketplace.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.Aplicacion;
import co.edu.uniquindio.marketplace.persistencia.ArchivoUtil;
import co.edu.uniquindio.marketplace.persistencia.Persistencia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable{

	Stage stage;
	Aplicacion aplicacion;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtUsuarioLogin;

    @FXML
    private PasswordField passTxtContraseñaLogin;

    @FXML
    private Button btnEntrarLogin;

    @FXML
    void entrarLoginAction(ActionEvent event) throws Exception{
    	entrarLogin();
    }
	
	private void entrarLogin() throws Exception {
		
		//Verificamos inicio sesion del usaurio y contraseña ingresados
		if(Persistencia.verificarUsuarioLogin(txtUsuarioLogin.getText(), passTxtContraseñaLogin.getText())){
//		if(txtUsuarioLogin.getText().equals("") && passTxtContraseñaLogin.getText().equals("")){
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/MarketplaceView.fxml"));

			AnchorPane rootLayout = (AnchorPane) loader.load();

			MarketplaceViewController marketplaceViewController = loader.getController();
			marketplaceViewController.setAplicacion(aplicacion, txtUsuarioLogin.getText());

			Scene scene = new Scene(rootLayout);
			Stage stage = new Stage();

			stage.setScene(scene);
			stage.show();
			stage.setTitle("Marketplace UQ");
			
			marketplaceViewController.setStage(stage, this);

			this.stage.close();
			System.out.println("Sesion Iniciada Usuario con identificacion: "+txtUsuarioLogin.getText());
			Persistencia.guardaRegistroLog("Sesion iniciada por el usuario con identificacion "+txtUsuarioLogin.getText(), 1, "Sesion Iniciada");
			

		}
		else{
			mostrarMensaje("Notificacion Inicio de Sesion", "Inicio de Sesion Invalidado", "El usuario y/o contraseña no estan registrados en el sistema", AlertType.ERROR);
			Persistencia.guardaRegistroLog("Intento de inicio de sesion", 1, "Inicio de sesion fallido");
		}
		
	}
	
	/**
	 * Metodo para mostrar la ventana login
	 */
	public void show(){
		stage.show();
	}
	
	/**
	 * Metodo usado para mostrar un mensaje
	 * @param titulo
	 * @param header
	 * @param contenido
	 * @param alertType
	 */
	private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert aler = new Alert(alertType);
		aler.setTitle(titulo);
		aler.setHeaderText(header);
		aler.setContentText(contenido);
		aler.showAndWait();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtUsuarioLogin.setPromptText("Usuario");
		passTxtContraseñaLogin.setPromptText("Contraseña");
		
	}

	public void setStage (Stage primaryStage) {
		this.stage = primaryStage;
	}

}

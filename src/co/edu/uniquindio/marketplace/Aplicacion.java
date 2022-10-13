package co.edu.uniquindio.marketplace;

import java.io.IOException;

import co.edu.uniquindio.marketplace.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Aplicacion extends Application {

	private Stage primaryStage;


	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Login");
		mostrarVentanaPrincipal();
	}

	public static void main(String[] args) {
		launch(args);
	}


	/** * Initializes the root layout. */
	public void mostrarVentanaPrincipal() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/LoginView.fxml"));
			
			AnchorPane rootLayout = (AnchorPane) loader.load();
			LoginController loginController = loader.getController();

			loginController.setStage(primaryStage);

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			//scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}

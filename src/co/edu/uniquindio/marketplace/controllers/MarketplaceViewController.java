package co.edu.uniquindio.marketplace.controllers;

import java.awt.peer.LabelPeer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.TabableView;

import co.edu.uniquindio.marketplace.Aplicacion;
import co.edu.uniquindio.marketplace.model.Categoria;
import co.edu.uniquindio.marketplace.model.Empleado;
import co.edu.uniquindio.marketplace.model.Estado;
import co.edu.uniquindio.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.persistencia.ArchivoUtil;
import co.edu.uniquindio.marketplace.persistencia.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class MarketplaceViewController {

	LoginController loginController;
	Stage stage;
	
	CrudVendedorViewController crudVendedorViewController;
	CrudProductoViewController crudProductoViewController;
	CrudPublicacionViewController crudPublicacionViewController;
	CrudContactosViewController crudContactosViewController;
	ModelFactoryController modelFactoryController;
	
	Vendedor vendedorSeleccionado;
	Producto productoSeleccionado;
	Publicacion publicacionSeleccionada;
	Vendedor contactoSeleccionado;
	Vendedor contactoSugeridoSeleccionado;
	Vendedor vendedorBuscadoSeleccionado;
	
	ObservableList<Vendedor> listaVendedoresData = FXCollections.observableArrayList();
	
	//Listas vendedor 1 data
	ObservableList<Producto> listaProductosVendedor1Data = FXCollections.observableArrayList();
	ObservableList<Publicacion> listaPublicacionesVendedor1Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosVendedor1Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaSugeridosVendedor1Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosEncontradosVendedor1Data = FXCollections.observableArrayList();
	
	//Listas vendedor 2 data
	ObservableList<Producto> listaProductosVendedor2Data = FXCollections.observableArrayList();
	ObservableList<Publicacion> listaPublicacionesVendedor2Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosVendedor2Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaSugeridosVendedor2Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosEncontradosVendedor2Data = FXCollections.observableArrayList();
	
	//Listas vendedor 3 data
	ObservableList<Producto> listaProductosVendedor3Data = FXCollections.observableArrayList();
	ObservableList<Publicacion> listaPublicacionesVendedor3Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosVendedor3Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaSugeridosVendedor3Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosEncontradosVendedor3Data = FXCollections.observableArrayList();

	//Listas vendedor 4 data
	ObservableList<Producto> listaProductosVendedor4Data = FXCollections.observableArrayList();
	ObservableList<Publicacion> listaPublicacionesVendedor4Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosVendedor4Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaSugeridosVendedor4Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosEncontradosVendedor4Data = FXCollections.observableArrayList();
	
	//Listas vendedor 5 data
	ObservableList<Producto> listaProductosVendedor5Data = FXCollections.observableArrayList();
	ObservableList<Publicacion> listaPublicacionesVendedor5Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosVendedor5Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaSugeridosVendedor5Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosEncontradosVendedor5Data = FXCollections.observableArrayList();
	
	//Listas vendedor 6 data
	ObservableList<Producto> listaProductosVendedor6Data = FXCollections.observableArrayList();
	ObservableList<Publicacion> listaPublicacionesVendedor6Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosVendedor6Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaSugeridosVendedor6Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosEncontradosVendedor6Data = FXCollections.observableArrayList();

	//Listas vendedor 7 data
	ObservableList<Producto> listaProductosVendedor7Data = FXCollections.observableArrayList();
	ObservableList<Publicacion> listaPublicacionesVendedor7Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosVendedor7Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaSugeridosVendedor7Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosEncontradosVendedor7Data = FXCollections.observableArrayList();

	//Listas vendedor 8 data
	ObservableList<Producto> listaProductosVendedor8Data = FXCollections.observableArrayList();
	ObservableList<Publicacion> listaPublicacionesVendedor8Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosVendedor8Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaSugeridosVendedor8Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosEncontradosVendedor8Data = FXCollections.observableArrayList();

	//Listas vendedor 9 data
	ObservableList<Producto> listaProductosVendedor9Data = FXCollections.observableArrayList();
	ObservableList<Publicacion> listaPublicacionesVendedor9Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosVendedor9Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaSugeridosVendedor9Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosEncontradosVendedor9Data = FXCollections.observableArrayList();

	//Listas vendedor 10 data
	ObservableList<Producto> listaProductosVendedor10Data = FXCollections.observableArrayList();
	ObservableList<Publicacion> listaPublicacionesVendedor10Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosVendedor10Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaSugeridosVendedor10Data = FXCollections.observableArrayList();
	ObservableList<Vendedor> listaContactosEncontradosVendedor10Data = FXCollections.observableArrayList();

	Aplicacion aplicacion;
	Tab tab;
	String codigoUsuario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //--------------------------------------------------Tables--------------------------------------------------------------------
    
    //Table de admin
    @FXML
    private TableView<Vendedor> tableVendedoresAdmin;
    
    @FXML
    private TableColumn<Vendedor, String> columnCedulaVendedoresAdmin;

    @FXML
    private TableColumn<Vendedor, String> columnApellidoVendedoresAdmin;
    
    @FXML
    private TableColumn<Vendedor, String> columnDireccionVendedoresAdmin;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreVendedoresAdmin;
    
    
    //Tables de vendedor 1
    @FXML
    private TableView<Producto> tableProductosVendedor1;
    
    @FXML
    private TableColumn<Producto, String> columnNombreProductoVendedor1;
    
    @FXML
    private TableColumn<Producto, String> columnPrecioProductoVendedor1;
    
    @FXML
    private TableColumn<Producto, String> columnCategoriaProductoVendedor1;
    
    @FXML
    private TableColumn<Producto, String> columnEstadoProductoVendedor1;
    
    @FXML
    private TableColumn<Producto, String> columnFechaProductoVendedor1;
    
    
    @FXML
    private TableView<Publicacion> tablePublicacionesVendedor1;
    
    @FXML
    private TableColumn<Publicacion, String> columnFechaPublicacionVendedor1;
    
    @FXML
    private TableColumn<Publicacion, String> columnNombreProductoPublicacionVendedor1;
    
    @FXML
    private TableColumn<Publicacion, String> columnPrecioProductoPublicacionVendedor1;
    
    @FXML
    private TableColumn<Publicacion, String> columnLikesVendedor1;
    
    
    @FXML
    private TableView<Vendedor> tableContactosVendedor1;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactosVendedor1;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactosVendedor1;
    
    
    @FXML
    private TableView<Vendedor> tableSugeridosVendedor1;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreSugeridosVendedor1;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoSugeridosVendedor1;
    
    
    @FXML
    private TableView<Vendedor> tableBusquedaContactos1;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactoBusqueda1;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactoBusqueda1;
    
    
    //Tables de vendedor 2
    @FXML
    private TableView<Producto> tableProductosVendedor2;
    
    @FXML
    private TableColumn<Producto, String> columnNombreProductoVendedor2;
    
    @FXML
    private TableColumn<Producto, String> columnPrecioProductoVendedor2;
    
    @FXML
    private TableColumn<Producto, String> columnCategoriaProductoVendedor2;
    
    @FXML
    private TableColumn<Producto, String> columnEstadoProductoVendedor2;
    
    @FXML
    private TableColumn<Producto, String> columnFechaProductoVendedor2;
    
    
    @FXML
    private TableView<Publicacion> tablePublicacionesVendedor2;
    
    @FXML
    private TableColumn<Publicacion, String> columnFechaPublicacionVendedor2;
    
    @FXML
    private TableColumn<Publicacion, String> columnNombreProductoPublicacionVendedor2;
    
    @FXML
    private TableColumn<Publicacion, String> columnPrecioProductoPublicacionVendedor2;
    
    @FXML
    private TableColumn<Publicacion, String> columnLikesVendedor2;
    
    
    @FXML
    private TableView<Vendedor> tableContactosVendedor2;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactosVendedor2;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactosVendedor2;
    
    
    @FXML
    private TableView<Vendedor> tableSugeridosVendedor2;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreSugeridosVendedor2;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoSugeridosVendedor2;
    
    
    @FXML
    private TableView<Vendedor> tableBusquedaContactos2;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactoBusqueda2;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactoBusqueda2;
    
    
    //Tables de vendedor 3
    @FXML
    private TableView<Producto> tableProductosVendedor3;
    
    @FXML
    private TableColumn<Producto, String> columnNombreProductoVendedor3;
    
    @FXML
    private TableColumn<Producto, String> columnPrecioProductoVendedor3;
    
    @FXML
    private TableColumn<Producto, String> columnCategoriaProductoVendedor3;
    
    @FXML
    private TableColumn<Producto, String> columnEstadoProductoVendedor3;
    
    @FXML
    private TableColumn<Producto, String> columnFechaProductoVendedor3;
    
    
    @FXML
    private TableView<Publicacion> tablePublicacionesVendedor3;
    
    @FXML
    private TableColumn<Publicacion, String> columnFechaPublicacionVendedor3;
    
    @FXML
    private TableColumn<Publicacion, String> columnNombreProductoPublicacionVendedor3;
    
    @FXML
    private TableColumn<Publicacion, String> columnPrecioProductoPublicacionVendedor3;
    
    @FXML
    private TableColumn<Publicacion, String> columnLikesVendedor3;
    
    
    @FXML
    private TableView<Vendedor> tableContactosVendedor3;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactosVendedor3;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactosVendedor3;
    
    
    @FXML
    private TableView<Vendedor> tableSugeridosVendedor3;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreSugeridosVendedor3;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoSugeridosVendedor3;
    
    
    @FXML
    private TableView<Vendedor> tableBusquedaContactos3;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactoBusqueda3;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactoBusqueda3;
    
    
    //Tables de vendedor 4
    @FXML
    private TableView<Producto> tableProductosVendedor4;
    
    @FXML
    private TableColumn<Producto, String> columnNombreProductoVendedor4;
    
    @FXML
    private TableColumn<Producto, String> columnPrecioProductoVendedor4;
    
    @FXML
    private TableColumn<Producto, String> columnCategoriaProductoVendedor4;
    
    @FXML
    private TableColumn<Producto, String> columnEstadoProductoVendedor4;
    
    @FXML
    private TableColumn<Producto, String> columnFechaProductoVendedor4;
    
    
    @FXML
    private TableView<Publicacion> tablePublicacionesVendedor4;
    
    @FXML
    private TableColumn<Publicacion, String> columnFechaPublicacionVendedor4;
    
    @FXML
    private TableColumn<Publicacion, String> columnNombreProductoPublicacionVendedor4;
    
    @FXML
    private TableColumn<Publicacion, String> columnPrecioProductoPublicacionVendedor4;
    
    @FXML
    private TableColumn<Publicacion, String> columnLikesVendedor4;
    
    
    @FXML
    private TableView<Vendedor> tableContactosVendedor4;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactosVendedor4;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactosVendedor4;
    
    
    @FXML
    private TableView<Vendedor> tableSugeridosVendedor4;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreSugeridosVendedor4;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoSugeridosVendedor4;
    
    
    @FXML
    private TableView<Vendedor> tableBusquedaContactos4;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactoBusqueda4;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactoBusqueda4;
    
    
  //Tables de vendedor 5
    @FXML
    private TableView<Producto> tableProductosVendedor5;
    
    @FXML
    private TableColumn<Producto, String> columnNombreProductoVendedor5;
    
    @FXML
    private TableColumn<Producto, String> columnPrecioProductoVendedor5;
    
    @FXML
    private TableColumn<Producto, String> columnCategoriaProductoVendedor5;
    
    @FXML
    private TableColumn<Producto, String> columnEstadoProductoVendedor5;
    
    @FXML
    private TableColumn<Producto, String> columnFechaProductoVendedor5;
    
    
    @FXML
    private TableView<Publicacion> tablePublicacionesVendedor5;
    
    @FXML
    private TableColumn<Publicacion, String> columnFechaPublicacionVendedor5;
    
    @FXML
    private TableColumn<Publicacion, String> columnNombreProductoPublicacionVendedor5;
    
    @FXML
    private TableColumn<Publicacion, String> columnPrecioProductoPublicacionVendedor5;
    
    @FXML
    private TableColumn<Publicacion, String> columnLikesVendedor5;
    
    
    @FXML
    private TableView<Vendedor> tableContactosVendedor5;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactosVendedor5;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactosVendedor5;
    
    
    @FXML
    private TableView<Vendedor> tableSugeridosVendedor5;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreSugeridosVendedor5;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoSugeridosVendedor5;
    
    
    @FXML
    private TableView<Vendedor> tableBusquedaContactos5;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactoBusqueda5;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactoBusqueda5;
    
    
  //Tables de vendedor 6
    @FXML
    private TableView<Producto> tableProductosVendedor6;
    
    @FXML
    private TableColumn<Producto, String> columnNombreProductoVendedor6;
    
    @FXML
    private TableColumn<Producto, String> columnPrecioProductoVendedor6;
    
    @FXML
    private TableColumn<Producto, String> columnCategoriaProductoVendedor6;
    
    @FXML
    private TableColumn<Producto, String> columnEstadoProductoVendedor6;
    
    @FXML
    private TableColumn<Producto, String> columnFechaProductoVendedor6;
    
    
    @FXML
    private TableView<Publicacion> tablePublicacionesVendedor6;
    
    @FXML
    private TableColumn<Publicacion, String> columnFechaPublicacionVendedor6;
    
    @FXML
    private TableColumn<Publicacion, String> columnNombreProductoPublicacionVendedor6;
    
    @FXML
    private TableColumn<Publicacion, String> columnPrecioProductoPublicacionVendedor6;
    
    @FXML
    private TableColumn<Publicacion, String> columnLikesVendedor6;
    
    
    @FXML
    private TableView<Vendedor> tableContactosVendedor6;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactosVendedor6;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactosVendedor6;
    
    
    @FXML
    private TableView<Vendedor> tableSugeridosVendedor6;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreSugeridosVendedor6;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoSugeridosVendedor6;
    
    
    @FXML
    private TableView<Vendedor> tableBusquedaContactos6;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactoBusqueda6;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactoBusqueda6;
    
    
    //Tables de vendedor 7
    @FXML
    private TableView<Producto> tableProductosVendedor7;
    
    @FXML
    private TableColumn<Producto, String> columnNombreProductoVendedor7;
    
    @FXML
    private TableColumn<Producto, String> columnPrecioProductoVendedor7;
    
    @FXML
    private TableColumn<Producto, String> columnCategoriaProductoVendedor7;
    
    @FXML
    private TableColumn<Producto, String> columnEstadoProductoVendedor7;
    
    @FXML
    private TableColumn<Producto, String> columnFechaProductoVendedor7;
    
    
    @FXML
    private TableView<Publicacion> tablePublicacionesVendedor7;
    
    @FXML
    private TableColumn<Publicacion, String> columnFechaPublicacionVendedor7;
    
    @FXML
    private TableColumn<Publicacion, String> columnNombreProductoPublicacionVendedor7;
    
    @FXML
    private TableColumn<Publicacion, String> columnPrecioProductoPublicacionVendedor7;
    
    @FXML
    private TableColumn<Publicacion, String> columnLikesVendedor7;
    
    
    @FXML
    private TableView<Vendedor> tableContactosVendedor7;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactosVendedor7;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactosVendedor7;
    
    
    @FXML
    private TableView<Vendedor> tableSugeridosVendedor7;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreSugeridosVendedor7;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoSugeridosVendedor7;
    
    
    @FXML
    private TableView<Vendedor> tableBusquedaContactos7;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactoBusqueda7;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactoBusqueda7;
    
    
    //Tables de vendedor 8
    @FXML
    private TableView<Producto> tableProductosVendedor8;
    
    @FXML
    private TableColumn<Producto, String> columnNombreProductoVendedor8;
    
    @FXML
    private TableColumn<Producto, String> columnPrecioProductoVendedor8;
    
    @FXML
    private TableColumn<Producto, String> columnCategoriaProductoVendedor8;
    
    @FXML
    private TableColumn<Producto, String> columnEstadoProductoVendedor8;
    
    @FXML
    private TableColumn<Producto, String> columnFechaProductoVendedor8;
    
    
    @FXML
    private TableView<Publicacion> tablePublicacionesVendedor8;
    
    @FXML
    private TableColumn<Publicacion, String> columnFechaPublicacionVendedor8;
    
    @FXML
    private TableColumn<Publicacion, String> columnNombreProductoPublicacionVendedor8;
    
    @FXML
    private TableColumn<Publicacion, String> columnPrecioProductoPublicacionVendedor8;
    
    @FXML
    private TableColumn<Publicacion, String> columnLikesVendedor8;
    
    
    @FXML
    private TableView<Vendedor> tableContactosVendedor8;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactosVendedor8;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactosVendedor8;
    
    
    @FXML
    private TableView<Vendedor> tableSugeridosVendedor8;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreSugeridosVendedor8;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoSugeridosVendedor8;
    
    
    @FXML
    private TableView<Vendedor> tableBusquedaContactos8;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactoBusqueda8;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactoBusqueda8;
    
    
    //Tables de vendedor 9
    @FXML
    private TableView<Producto> tableProductosVendedor9;
    
    @FXML
    private TableColumn<Producto, String> columnNombreProductoVendedor9;
    
    @FXML
    private TableColumn<Producto, String> columnPrecioProductoVendedor9;
    
    @FXML
    private TableColumn<Producto, String> columnCategoriaProductoVendedor9;
    
    @FXML
    private TableColumn<Producto, String> columnEstadoProductoVendedor9;
    
    @FXML
    private TableColumn<Producto, String> columnFechaProductoVendedor9;
    
    
    @FXML
    private TableView<Publicacion> tablePublicacionesVendedor9;
    
    @FXML
    private TableColumn<Publicacion, String> columnFechaPublicacionVendedor9;
    
    @FXML
    private TableColumn<Publicacion, String> columnNombreProductoPublicacionVendedor9;
    
    @FXML
    private TableColumn<Publicacion, String> columnPrecioProductoPublicacionVendedor9;
    
    @FXML
    private TableColumn<Publicacion, String> columnLikesVendedor9;
    
    
    @FXML
    private TableView<Vendedor> tableContactosVendedor9;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactosVendedor9;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactosVendedor9;
    
    
    @FXML
    private TableView<Vendedor> tableSugeridosVendedor9;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreSugeridosVendedor9;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoSugeridosVendedor9;
    
    
    @FXML
    private TableView<Vendedor> tableBusquedaContactos9;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactoBusqueda9;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactoBusqueda9;
    
    
  //Tables de vendedor 10
    @FXML
    private TableView<Producto> tableProductosVendedor10;
    
    @FXML
    private TableColumn<Producto, String> columnNombreProductoVendedor10;
    
    @FXML
    private TableColumn<Producto, String> columnPrecioProductoVendedor10;
    
    @FXML
    private TableColumn<Producto, String> columnCategoriaProductoVendedor10;
    
    @FXML
    private TableColumn<Producto, String> columnEstadoProductoVendedor10;
    
    @FXML
    private TableColumn<Producto, String> columnFechaProductoVendedor10;
    
    
    @FXML
    private TableView<Publicacion> tablePublicacionesVendedor10;
    
    @FXML
    private TableColumn<Publicacion, String> columnFechaPublicacionVendedor10;
    
    @FXML
    private TableColumn<Publicacion, String> columnNombreProductoPublicacionVendedor10;
    
    @FXML
    private TableColumn<Publicacion, String> columnPrecioProductoPublicacionVendedor10;
    
    @FXML
    private TableColumn<Publicacion, String> columnLikesVendedor10;
    
    
    @FXML
    private TableView<Vendedor> tableContactosVendedor10;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactosVendedor10;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactosVendedor10;
    
    
    @FXML
    private TableView<Vendedor> tableSugeridosVendedor10;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreSugeridosVendedor10;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoSugeridosVendedor10;
    
    
    @FXML
    private TableView<Vendedor> tableBusquedaContactos10;
    
    @FXML
    private TableColumn<Vendedor, String> columnNombreContactoBusqueda10;
    
    @FXML
    private TableColumn<Vendedor, String> columnApellidoContactoBusqueda10;
    
    
    
    //-------------------------------------------------------------Button Cerrar Sesion--------------------------------------------------------------
    @FXML
    private Button btnCerrarSesion;
    
    //---------------------------------------------------------------Buttons Admin-------------------------------------------------------------------

    @FXML
    private Button btnNuevoVendedor;

    @FXML
    private Button btnActualizarVendedor;
    
    @FXML
    private Button btnEliminarVendedor;
    
    @FXML
    private Button btnAgregarVendedor;
    
    @FXML
    private Button btnExportarCantidadProductosPublicados;
    
    @FXML
    private Button btnExportarCantidadContactosVendedor;
    
    @FXML
    private Button btnExportarTop10ProductosMasLikeados;
    
    @FXML
    private Button btnActualizarEstadisticasAdmin;
    
    //------------------------------------------------------------Buttons vendedores--------------------------------------------------------------
    
    //Buttons vendedor 1
    @FXML
    private Button btnAgregarProductoVendedor1;
    
    @FXML
    private Button btnPublicarProductoVendedor1;
    
    @FXML
    private Button btnActualizarProductoVendedor1;
    
    @FXML
    private Button btnEliminarProductoVendedor1;
    
    @FXML
    private Button btnActualizarPublicacionVendedor1;
    
    @FXML
    private Button btnEliminarPublicacionVendedor1;
    
    @FXML
    private Button btnLikePublicacionVendedor1;
    
    @FXML
    private Button btnAgregarComentarioPublicacionVendedor1;
    
    @FXML
    private Button btnEliminarContactoVendedor1;
    
    @FXML
    private Button btnAgregarContactoSugerido1;
    
    @FXML
    private Button btnAgregarContactoBusqueda1;
    
    @FXML
    private Button btnBuscarVendedor1;
    
    @FXML
    private Button btnEnviarMensajeVendedor1;
    
    
  //Buttons vendedor 2
    @FXML
    private Button btnAgregarProductoVendedor2;
    
    @FXML
    private Button btnPublicarProductoVendedor2;
    
    @FXML
    private Button btnActualizarProductoVendedor2;
    
    @FXML
    private Button btnEliminarProductoVendedor2;
    
    @FXML
    private Button btnActualizarPublicacionVendedor2;
    
    @FXML
    private Button btnEliminarPublicacionVendedor2;
    
    @FXML
    private Button btnLikePublicacionVendedor2;
    
    @FXML
    private Button btnAgregarComentarioPublicacionVendedor2;
    
    @FXML
    private Button btnEliminarContactoVendedor2;
    
    @FXML
    private Button btnAgregarContactoSugerido2;
    
    @FXML
    private Button btnAgregarContactoBusqueda2;
    
    @FXML
    private Button btnBuscarVendedor2;
    
    @FXML
    private Button btnEnviarMensajeVendedor2;
    
    
    
  //Buttons vendedor 3
    @FXML
    private Button btnAgregarProductoVendedor3;
    
    @FXML
    private Button btnPublicarProductoVendedor3;
    
    @FXML
    private Button btnActualizarProductoVendedor3;
    
    @FXML
    private Button btnEliminarProductoVendedor3;
    
    @FXML
    private Button btnActualizarPublicacionVendedor3;
    
    @FXML
    private Button btnEliminarPublicacionVendedor3;
    
    @FXML
    private Button btnLikePublicacionVendedor3;
    
    @FXML
    private Button btnAgregarComentarioPublicacionVendedor3;
    
    @FXML
    private Button btnEliminarContactoVendedor3;
    
    @FXML
    private Button btnAgregarContactoSugerido3;
    
    @FXML
    private Button btnAgregarContactoBusqueda3;
    
    @FXML
    private Button btnBuscarVendedor3;
    
    @FXML
    private Button btnEnviarMensajeVendedor3;
    
    
  //Buttons vendedor 4
    @FXML
    private Button btnAgregarProductoVendedor4;
    
    @FXML
    private Button btnPublicarProductoVendedor4;
    
    @FXML
    private Button btnActualizarProductoVendedor4;
    
    @FXML
    private Button btnEliminarProductoVendedor4;
    
    @FXML
    private Button btnActualizarPublicacionVendedor4;
    
    @FXML
    private Button btnEliminarPublicacionVendedor4;
    
    @FXML
    private Button btnLikePublicacionVendedor4;
    
    @FXML
    private Button btnAgregarComentarioPublicacionVendedor4;
    
    @FXML
    private Button btnEliminarContactoVendedor4;
    
    @FXML
    private Button btnAgregarContactoSugerido4;
    
    @FXML
    private Button btnAgregarContactoBusqueda4;
    
    @FXML
    private Button btnBuscarVendedor4;
    
    @FXML
    private Button btnEnviarMensajeVendedor4;
    
    
  //Buttons vendedor 5
    @FXML
    private Button btnAgregarProductoVendedor5;
    
    @FXML
    private Button btnPublicarProductoVendedor5;
    
    @FXML
    private Button btnActualizarProductoVendedor5;
    
    @FXML
    private Button btnEliminarProductoVendedor5;
    
    @FXML
    private Button btnActualizarPublicacionVendedor5;
    
    @FXML
    private Button btnEliminarPublicacionVendedor5;
    
    @FXML
    private Button btnLikePublicacionVendedor5;
    
    @FXML
    private Button btnAgregarComentarioPublicacionVendedor5;
    
    @FXML
    private Button btnEliminarContactoVendedor5;
    
    @FXML
    private Button btnAgregarContactoSugerido5;
    
    @FXML
    private Button btnAgregarContactoBusqueda5;
    
    @FXML
    private Button btnBuscarVendedor5;
    
    @FXML
    private Button btnEnviarMensajeVendedor5;
    
    
    //Buttons vendedor 6
    @FXML
    private Button btnAgregarProductoVendedor6;
    
    @FXML
    private Button btnPublicarProductoVendedor6;
    
    @FXML
    private Button btnActualizarProductoVendedor6;
    
    @FXML
    private Button btnEliminarProductoVendedor6;
    
    @FXML
    private Button btnActualizarPublicacionVendedor6;
    
    @FXML
    private Button btnEliminarPublicacionVendedor6;
    
    @FXML
    private Button btnLikePublicacionVendedor6;
    
    @FXML
    private Button btnAgregarComentarioPublicacionVendedor6;
    
    @FXML
    private Button btnEliminarContactoVendedor6;
    
    @FXML
    private Button btnAgregarContactoSugerido6;
    
    @FXML
    private Button btnAgregarContactoBusqueda6;
    
    @FXML
    private Button btnBuscarVendedor6;
    
    @FXML
    private Button btnEnviarMensajeVendedor6;
    
    
  //Buttons vendedor 7
    @FXML
    private Button btnAgregarProductoVendedor7;
    
    @FXML
    private Button btnPublicarProductoVendedor7;
    
    @FXML
    private Button btnActualizarProductoVendedor7;
    
    @FXML
    private Button btnEliminarProductoVendedor7;
    
    @FXML
    private Button btnActualizarPublicacionVendedor7;
    
    @FXML
    private Button btnEliminarPublicacionVendedor7;
    
    @FXML
    private Button btnLikePublicacionVendedor7;
    
    @FXML
    private Button btnAgregarComentarioPublicacionVendedor7;
    
    @FXML
    private Button btnEliminarContactoVendedor7;
    
    @FXML
    private Button btnAgregarContactoSugerido7;
    
    @FXML
    private Button btnAgregarContactoBusqueda7;
    
    @FXML
    private Button btnBuscarVendedor7;
    
    @FXML
    private Button btnEnviarMensajeVendedor7;
    
    
    
  //Buttons vendedor 8
    @FXML
    private Button btnAgregarProductoVendedor8;
    
    @FXML
    private Button btnPublicarProductoVendedor8;
    
    @FXML
    private Button btnActualizarProductoVendedor8;
    
    @FXML
    private Button btnEliminarProductoVendedor8;
    
    @FXML
    private Button btnActualizarPublicacionVendedor8;
    
    @FXML
    private Button btnEliminarPublicacionVendedor8;
    
    @FXML
    private Button btnLikePublicacionVendedor8;
    
    @FXML
    private Button btnAgregarComentarioPublicacionVendedor8;
    
    @FXML
    private Button btnEliminarContactoVendedor8;
    
    @FXML
    private Button btnAgregarContactoSugerido8;
    
    @FXML
    private Button btnAgregarContactoBusqueda8;
    
    @FXML
    private Button btnBuscarVendedor8;
    
    @FXML
    private Button btnEnviarMensajeVendedor8;
    
    
  //Buttons vendedor 9
    @FXML
    private Button btnAgregarProductoVendedor9;
    
    @FXML
    private Button btnPublicarProductoVendedor9;
    
    @FXML
    private Button btnActualizarProductoVendedor9;
    
    @FXML
    private Button btnEliminarProductoVendedor9;
    
    @FXML
    private Button btnActualizarPublicacionVendedor9;
    
    @FXML
    private Button btnEliminarPublicacionVendedor9;
    
    @FXML
    private Button btnLikePublicacionVendedor9;
    
    @FXML
    private Button btnAgregarComentarioPublicacionVendedor9;
    
    @FXML
    private Button btnEliminarContactoVendedor9;
    
    @FXML
    private Button btnAgregarContactoSugerido9;
    
    @FXML
    private Button btnAgregarContactoBusqueda9;
    
    @FXML
    private Button btnBuscarVendedor9;
    
    @FXML
    private Button btnEnviarMensajeVendedor9;
    
    
  //Buttons vendedor 10
    @FXML
    private Button btnAgregarProductoVendedor10;
    
    @FXML
    private Button btnPublicarProductoVendedor10;
    
    @FXML
    private Button btnActualizarProductoVendedor10;
    
    @FXML
    private Button btnEliminarProductoVendedor10;
    
    @FXML
    private Button btnActualizarPublicacionVendedor10;
    
    @FXML
    private Button btnEliminarPublicacionVendedor10;
    
    @FXML
    private Button btnLikePublicacionVendedor10;
    
    @FXML
    private Button btnAgregarComentarioPublicacionVendedor10;
    
    @FXML
    private Button btnEliminarContactoVendedor10;
    
    @FXML
    private Button btnAgregarContactoSugerido10;
    
    @FXML
    private Button btnAgregarContactoBusqueda10;
    
    @FXML
    private Button btnBuscarVendedor10;
    
    @FXML
    private Button btnEnviarMensajeVendedor10;
    
    //----------------------------------------------------------------Textfields------------------------------------------------------------------
    
    //Textfields admin
    @FXML
    private TextField txtNombreVendedorAdmin;
    
    @FXML
    private TextField txtCedulaVendedorAdmin;

    @FXML
    private TextField txtApellidoVendedorAdmin;

    @FXML
    private TextField txtDireccionVendedorAdmin;

    @FXML
    private PasswordField passTxtContraseñaVendedorAdmin;
    
    
    //Textfields vendedor pestaña 1
    @FXML
    private TextField txtNombreProductoVendedor1;
    
    @FXML
    private TextField txtPrecioProductoVendedor1;
    
    @FXML
    private TextField txtComentarioPublicacionVendedor1;
    
    @FXML
    private TextField txtBuscarVendedor1;
    
    @FXML
    private TextField txtMensajesVendedor1;
    
    
  //Textfields vendedor pestaña 2
    @FXML
    private TextField txtNombreProductoVendedor2;
    
    @FXML
    private TextField txtPrecioProductoVendedor2;
    
    @FXML
    private TextField txtComentarioPublicacionVendedor2;
    
    @FXML
    private TextField txtBuscarVendedor2;
    
    @FXML
    private TextField txtMensajesVendedor2;
    
    
  //Textfields vendedor pestaña 3
    @FXML
    private TextField txtNombreProductoVendedor3;
    
    @FXML
    private TextField txtPrecioProductoVendedor3;
    
    @FXML
    private TextField txtComentarioPublicacionVendedor3;
    
    @FXML
    private TextField txtBuscarVendedor3;
    
    @FXML
    private TextField txtMensajesVendedor3;
    
    
  //Textfields vendedor pestaña 4
    @FXML
    private TextField txtNombreProductoVendedor4;
    
    @FXML
    private TextField txtPrecioProductoVendedor4;
    
    @FXML
    private TextField txtComentarioPublicacionVendedor4;
    
    @FXML
    private TextField txtBuscarVendedor4;
    
    @FXML
    private TextField txtMensajesVendedor4;
    
    
  //Textfields vendedor pestaña 5
    @FXML
    private TextField txtNombreProductoVendedor5;
    
    @FXML
    private TextField txtPrecioProductoVendedor5;
    
    @FXML
    private TextField txtComentarioPublicacionVendedor5;
    
    @FXML
    private TextField txtBuscarVendedor5;
    
    @FXML
    private TextField txtMensajesVendedor5;
    
    
  //Textfields vendedor pestaña 6
    @FXML
    private TextField txtNombreProductoVendedor6;
    
    @FXML
    private TextField txtPrecioProductoVendedor6;
    
    @FXML
    private TextField txtComentarioPublicacionVendedor6;
    
    @FXML
    private TextField txtBuscarVendedor6;
    
    @FXML
    private TextField txtMensajesVendedor6;
    
    
  //Textfields vendedor pestaña 7
    @FXML
    private TextField txtNombreProductoVendedor7;
    
    @FXML
    private TextField txtPrecioProductoVendedor7;
    
    @FXML
    private TextField txtComentarioPublicacionVendedor7;
    
    @FXML
    private TextField txtBuscarVendedor7;
    
    @FXML
    private TextField txtMensajesVendedor7;
    
    
  //Textfields vendedor pestaña 8
    @FXML
    private TextField txtNombreProductoVendedor8;
    
    @FXML
    private TextField txtPrecioProductoVendedor8;
    
    @FXML
    private TextField txtComentarioPublicacionVendedor8;
    
    @FXML
    private TextField txtBuscarVendedor8;
    
    @FXML
    private TextField txtMensajesVendedor8;
    
    
  //Textfields vendedor pestaña 9
    @FXML
    private TextField txtNombreProductoVendedor9;
    
    @FXML
    private TextField txtPrecioProductoVendedor9;
    
    @FXML
    private TextField txtComentarioPublicacionVendedor9;
    
    @FXML
    private TextField txtBuscarVendedor9;
    
    @FXML
    private TextField txtMensajesVendedor9;
    
    
  //Textfields vendedor pestaña 10
    @FXML
    private TextField txtNombreProductoVendedor10;
    
    @FXML
    private TextField txtPrecioProductoVendedor10;
    
    @FXML
    private TextField txtComentarioPublicacionVendedor10;
    
    @FXML
    private TextField txtBuscarVendedor10;
    
    @FXML
    private TextField txtMensajesVendedor10;
    
    
    //-------------------------------------------------------------------ComboBox-----------------------------------------------------------------
    
    //Comboboxes de vendedor 1
    @FXML
    private ComboBox<String> comboBoxCategoriaVendedor1;
    
    @FXML
    private ComboBox<String> comboBoxEstadoVendedor1;
    
    
  //Comboboxes de vendedor 2
    @FXML
    private ComboBox<String> comboBoxCategoriaVendedor2;
    
    @FXML
    private ComboBox<String> comboBoxEstadoVendedor2;
    
  //Comboboxes de vendedor 3
    @FXML
    private ComboBox<String> comboBoxCategoriaVendedor3;
    
    @FXML
    private ComboBox<String> comboBoxEstadoVendedor3;
    
    
  //Comboboxes de vendedor 4
    @FXML
    private ComboBox<String> comboBoxCategoriaVendedor4;
    
    @FXML
    private ComboBox<String> comboBoxEstadoVendedor4;
    
    
  //Comboboxes de vendedor 5
    @FXML
    private ComboBox<String> comboBoxCategoriaVendedor5;
    
    @FXML
    private ComboBox<String> comboBoxEstadoVendedor5;
    
    
  //Comboboxes de vendedor 6
    @FXML
    private ComboBox<String> comboBoxCategoriaVendedor6;
    
    @FXML
    private ComboBox<String> comboBoxEstadoVendedor6;
    
    
  //Comboboxes de vendedor 7
    @FXML
    private ComboBox<String> comboBoxCategoriaVendedor7;
    
    @FXML
    private ComboBox<String> comboBoxEstadoVendedor7;
    
  //Comboboxes de vendedor 8
    @FXML
    private ComboBox<String> comboBoxCategoriaVendedor8;
    
    @FXML
    private ComboBox<String> comboBoxEstadoVendedor8;
    
    
  //Comboboxes de vendedor 9
    @FXML
    private ComboBox<String> comboBoxCategoriaVendedor9;
    
    @FXML
    private ComboBox<String> comboBoxEstadoVendedor9;
    
    
  //Comboboxes de vendedor 10
    @FXML
    private ComboBox<String> comboBoxCategoriaVendedor10;
    
    @FXML
    private ComboBox<String> comboBoxEstadoVendedor10;
    
    //--------------------------------------------------------------------TabPane--------------------------------------------------------------------------------
    
    @FXML
    private TabPane tabPaneGeneral;
    
    //---------------------------------------------------------------------Labels---------------------------------------------------------------------------------
    
    //Labels de reportes en la pestaña de administracion
    
    @FXML
    private Label labelCantidadProductosPublicadosVendedores;
    
    @FXML
    private Label labelCantidadContactosVendedores;
    
    @FXML
    private Label labelTop10ProductosMasLikeados;
    
    
    //Label de comentarios de publicaciones, notificaciones de likes y mensajes de vendedor 1
    @FXML
    private Label labelComentariosPublicacionVendedor1;
    
    @FXML
    private Label labelLikesPublicacionVendedor1;
    
    @FXML
    private Label labelMensajesVendedor1;
    
    
  //Label de comentarios de publicaciones, notificaciones de likes y mensajes de vendedor 2
    @FXML
    private Label labelComentariosPublicacionVendedor2;
    
    @FXML
    private Label labelLikesPublicacionVendedor2;
    
    @FXML
    private Label labelMensajesVendedor2;
    
    
    //Label de comentarios de publicaciones, notificaciones de likes y mensajes de vendedor 3
    @FXML
    private Label labelComentariosPublicacionVendedor3;
    
    @FXML
    private Label labelLikesPublicacionVendedor3;
    
    @FXML
    private Label labelMensajesVendedor3;
    
    
  //Label de comentarios de publicaciones, notificaciones de likes y mensajes de vendedor 4
    @FXML
    private Label labelComentariosPublicacionVendedor4;
    
    @FXML
    private Label labelLikesPublicacionVendedor4;
    
    @FXML
    private Label labelMensajesVendedor4;
    
    
  //Label de comentarios de publicaciones, notificaciones de likes y mensajes de vendedor 5
    @FXML
    private Label labelComentariosPublicacionVendedor5;
    
    @FXML
    private Label labelLikesPublicacionVendedor5;
    
    @FXML
    private Label labelMensajesVendedor5;
    
  //Label de comentarios de publicaciones, notificaciones de likes y mensajes de vendedor 6
    @FXML
    private Label labelComentariosPublicacionVendedor6;
    
    @FXML
    private Label labelLikesPublicacionVendedor6;
    
    @FXML
    private Label labelMensajesVendedor6;
    
    
  //Label de comentarios de publicaciones, notificaciones de likes y mensajes de vendedor 7
    @FXML
    private Label labelComentariosPublicacionVendedor7;
    
    @FXML
    private Label labelLikesPublicacionVendedor7;
    
    @FXML
    private Label labelMensajesVendedor7;
    
    
    //Label de comentarios de publicaciones, notificaciones de likes y mensajes de vendedor 8
    @FXML
    private Label labelComentariosPublicacionVendedor8;
    
    @FXML
    private Label labelLikesPublicacionVendedor8;
    
    @FXML
    private Label labelMensajesVendedor8;
    
    
  //Label de comentarios de publicaciones, notificaciones de likes y mensajes de vendedor 9
    @FXML
    private Label labelComentariosPublicacionVendedor9;
    
    @FXML
    private Label labelLikesPublicacionVendedor9;
    
    @FXML
    private Label labelMensajesVendedor9;
    
    
  //Label de comentarios de publicaciones, notificaciones de likes y mensajes de vendedor 10
    @FXML
    private Label labelComentariosPublicacionVendedor10;
    
    @FXML
    private Label labelLikesPublicacionVendedor10;
    
    @FXML
    private Label labelMensajesVendedor10;
    
    //-----------------------------------------------------------Action cierre de sesion-----------------------------------------------------------------------------
    
    @FXML
    void cerrarSesionAction(ActionEvent event) {
    	modelFactoryController.registrarAccionesSistema("Cierre de sesion por usuario con codigo "+codigoUsuario, 1, "Cierre de sesion");
    	cerrarSesion();
    }
    
   //------------------------------------------------------------Actions Administrador-------------------------------------------------------------------------------

    @FXML
    void nuevoVendedorAction(ActionEvent event) {
    	modelFactoryController.registrarAccionesSistema("Boton de nuevo vendedor seleccionado, por usuario con codigo "+codigoUsuario, 1, "Boton");
    	nuevoVendedor();
    }

    @FXML
    void agregarVendedorAction(ActionEvent event) {
    	modelFactoryController.registrarAccionesSistema("Boton de crear vendedor seleccionado, por usuario con codigo"+codigoUsuario, 1, "Boton");
    	crearVendedor();
    }

    @FXML
    void actualizarVendedorAction(ActionEvent event) {
    	modelFactoryController.registrarAccionesSistema("Boton de actualizar vendedor, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
    	actualizarVendedor();
    }
    
    @FXML
    void eliminarVendedorAction(ActionEvent event) {
    	modelFactoryController.registrarAccionesSistema("Boton de eliminar vendedor, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
    	eliminarVendedor();
    }
    
    @FXML
    void exportarCantidadProductosPublicadosAction(ActionEvent event) {
    	modelFactoryController.registrarAccionesSistema("Boton de exportar reporte de cantidad de productos publicados, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
    	exportar("Numero de productos publicados por los vendedores", labelCantidadProductosPublicadosVendedores.getText());
    }
    
    @FXML
    void exportarCantidadContactosVendedorAction(ActionEvent event) {
    	modelFactoryController.registrarAccionesSistema("Boton de exportar reporte de cantidad de contactos de los vendedores, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
    	exportar("Numero de contactos de los vendedores", labelCantidadContactosVendedores.getText());
    }
    
    @FXML
    void exportarTop10ProductosMasLikeadosAction(ActionEvent event) {
    	modelFactoryController.registrarAccionesSistema("Boton de exportar reporte de top 10 de los productos mas likeados, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
    	exportar("Top 10 productos mas likeados", labelTop10ProductosMasLikeados.getText());
    }
    
    @FXML
    void actualizarEstadisticasAdminAction(ActionEvent event) {
    	modelFactoryController.registrarAccionesSistema("Boton de actualizar estadisticas en administracion, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
    	setReportesAdmin();
    	mostrarMensaje("Notificacion Reportes", "Pestaña de reportes", "Pestaña de reportes actualizada", AlertType.INFORMATION);
    }
    
    //------------------------------------------------------------Actions Vendedor 1-------------------------------------------------------------------------------
    
	@FXML
    void publicarProductoVendedor1Action(ActionEvent event) {
    	modelFactoryController.registrarAccionesSistema("Boton de publicar producto vendedor 1, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
    	publicarProductoVendedor1();
    }

	@FXML
    void agregarProductoVendedor1Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de agregar producto vendedor 1, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
    	agregarProductoVendedor1();
    }
	
	@FXML
    void actualizarProductoVendedor1Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar producto vendedor 1, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarProductoVendedor1();
    }
	
	@FXML
    void eliminarProductoVendedor1Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar producto vendedor 1, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarProductoVendedor1();
    }
	
	@FXML
    void actualizarPublicacionVendedor1Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar publicacion vendedor 1, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarPublicacionVendedor1();
    }
	
	@FXML
    void eliminarPublicacionVendedor1Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar publicacion vendedor 1, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarPublicacionVendedor1();
    }
	
	@FXML
    void likePublicacionVendedor1Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de dar like en publicacion vendedor 1, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		darLikePublicacionVendedor1();
    }
	
	@FXML
    void agregarComentarioPublicacionVendedor1(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de comentar en publicacion vendedor 1, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarComentarioPublicacionVendedor1();
    }
	
	@FXML
    void eliminarContactoVendedor1Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Eliminar contacto en vendedor 1, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		eliminarContactoVendedor1();
    }
	
	@FXML
    void agregarContactoSugeridoAction1(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto sugerido en vendedor 1, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarContactoSugerido1();
    }
	
	@FXML
    void agregarContactoBusquedaAction1(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto en la busqueda de contactos en vendedor 1, seleccionado por un usuario con codigo" + codigoUsuario, 1, "Boton");
		agregarContactoBusqueda1();
	}
	
	@FXML
    void buscarVendedor1Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Buscar contacto en vendedor 1, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		buscarVendedores1();
    }
	
	@FXML
    void enviarMensajeVendedor1Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Enviar mensaje en vendedor 1, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		enviarMensajeVendedor1();
    }
	
	
	//------------------------------------------------------------Actions Vendedor 2-------------------------------------------------------------------------------
    
	@FXML
	void publicarProductoVendedor2Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de publicar producto vendedor 2, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		publicarProductoVendedor2();
	}

	@FXML
	void agregarProductoVendedor2Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de agregar producto vendedor 2, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		agregarProductoVendedor2();
	}

	@FXML
	void actualizarProductoVendedor2Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar producto vendedor 2, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarProductoVendedor2();
	}

	@FXML
	void eliminarProductoVendedor2Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar producto vendedor 2, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarProductoVendedor2();
	}

	@FXML
	void actualizarPublicacionVendedor2Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar publicacion vendedor 2, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarPublicacionVendedor2();
	}

	@FXML
	void eliminarPublicacionVendedor2Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar publicacion vendedor 2, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarPublicacionVendedor2();
	}

	@FXML
	void likePublicacionVendedor2Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de dar like en publicacion vendedor 2, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		darLikePublicacionVendedor2();
	}

	@FXML
	void agregarComentarioPublicacionVendedor2(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de comentar en publicacion vendedor 2, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarComentarioPublicacionVendedor2();
	}

	@FXML
	void eliminarContactoVendedor2Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Eliminar contacto en vendedor 2, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		eliminarContactoVendedor2();
	}

	@FXML
	void agregarContactoSugeridoAction2(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto sugerido en vendedor 2, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarContactoSugerido2();
	}

	@FXML
	void agregarContactoBusquedaAction2(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto en la busqueda de contactos en vendedor 2, seleccionado por un usuario con codigo" + codigoUsuario, 1, "Boton");
		agregarContactoBusqueda2();
	}

	@FXML
	void buscarVendedor2Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Buscar contacto en vendedor 2, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		buscarVendedores2();
	}

	@FXML
	void enviarMensajeVendedor2Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Enviar mensaje en vendedor 2, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		enviarMensajeVendedor2();
	}


	//------------------------------------------------------------Actions Vendedor 3-------------------------------------------------------------------------------

	@FXML
	void publicarProductoVendedor3Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de publicar producto vendedor 3, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		publicarProductoVendedor3();
	}

	@FXML
	void agregarProductoVendedor3Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de agregar producto vendedor 3, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		agregarProductoVendedor3();
	}

	@FXML
	void actualizarProductoVendedor3Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar producto vendedor 3, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarProductoVendedor3();
	}

	@FXML
	void eliminarProductoVendedor3Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar producto vendedor 3, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarProductoVendedor3();
	}

	@FXML
	void actualizarPublicacionVendedor3Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar publicacion vendedor 3, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarPublicacionVendedor3();
	}

	@FXML
	void eliminarPublicacionVendedor3Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar publicacion vendedor 3, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarPublicacionVendedor3();
	}

	@FXML
	void likePublicacionVendedor3Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de dar like en publicacion vendedor 3, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		darLikePublicacionVendedor3();
	}

	@FXML
	void agregarComentarioPublicacionVendedor3(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de comentar en publicacion vendedor 3, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarComentarioPublicacionVendedor3();
	}

	@FXML
	void eliminarContactoVendedor3Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Eliminar contacto en vendedor 3, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		eliminarContactoVendedor3();
	}

	@FXML
	void agregarContactoSugeridoAction3(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto sugerido en vendedor 3, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarContactoSugerido3();
	}

	@FXML
	void agregarContactoBusquedaAction3(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto en la busqueda de contactos en vendedor 3, seleccionado por un usuario con codigo" + codigoUsuario, 1, "Boton");
		agregarContactoBusqueda3();
	}

	@FXML
	void buscarVendedor3Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Buscar contacto en vendedor 3, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		buscarVendedores3();
	}

	@FXML
	void enviarMensajeVendedor3Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Enviar mensaje en vendedor 3, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		enviarMensajeVendedor3();
	}


	//------------------------------------------------------------Actions Vendedor 4-------------------------------------------------------------------------------

	@FXML
	void publicarProductoVendedor4Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de publicar producto vendedor 4, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		publicarProductoVendedor4();
	}

	@FXML
	void agregarProductoVendedor4Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de agregar producto vendedor 4, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		agregarProductoVendedor4();
	}

	@FXML
	void actualizarProductoVendedor4Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar producto vendedor 4, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarProductoVendedor4();
	}

	@FXML
	void eliminarProductoVendedor4Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar producto vendedor 4, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarProductoVendedor4();
	}

	@FXML
	void actualizarPublicacionVendedor4Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar publicacion vendedor 4, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarPublicacionVendedor4();
	}

	@FXML
	void eliminarPublicacionVendedor4Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar publicacion vendedor 4, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarPublicacionVendedor4();
	}

	@FXML
	void likePublicacionVendedor4Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de dar like en publicacion vendedor 4, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		darLikePublicacionVendedor4();
	}

	@FXML
	void agregarComentarioPublicacionVendedor4(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de comentar en publicacion vendedor 4, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarComentarioPublicacionVendedor4();
	}

	@FXML
	void eliminarContactoVendedor4Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Eliminar contacto en vendedor 4, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		eliminarContactoVendedor4();
	}

	@FXML
	void agregarContactoSugeridoAction4(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto sugerido en vendedor 4, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarContactoSugerido4();
	}

	@FXML
	void agregarContactoBusquedaAction4(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto en la busqueda de contactos en vendedor 4, seleccionado por un usuario con codigo" + codigoUsuario, 1, "Boton");
		agregarContactoBusqueda4();
	}

	@FXML
	void buscarVendedor4Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Buscar contacto en vendedor 4, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		buscarVendedores4();
	}

	@FXML
	void enviarMensajeVendedor4Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Enviar mensaje en vendedor 4, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		enviarMensajeVendedor4();
	}
	
	
	//------------------------------------------------------------Actions Vendedor 5-------------------------------------------------------------------------------

	@FXML
	void publicarProductoVendedor5Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de publicar producto vendedor 5, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		publicarProductoVendedor5();
	}

	@FXML
	void agregarProductoVendedor5Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de agregar producto vendedor 5, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		agregarProductoVendedor5();
	}

	@FXML
	void actualizarProductoVendedor5Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar producto vendedor 5, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarProductoVendedor5();
	}

	@FXML
	void eliminarProductoVendedor5Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar producto vendedor 5, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarProductoVendedor5();
	}

	@FXML
	void actualizarPublicacionVendedor5Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar publicacion vendedor 5, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarPublicacionVendedor5();
	}

	@FXML
	void eliminarPublicacionVendedor5Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar publicacion vendedor 5, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarPublicacionVendedor5();
	}

	@FXML
	void likePublicacionVendedor5Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de dar like en publicacion vendedor 5, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		darLikePublicacionVendedor5();
	}

	@FXML
	void agregarComentarioPublicacionVendedor5(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de comentar en publicacion vendedor 5, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarComentarioPublicacionVendedor5();
	}

	@FXML
	void eliminarContactoVendedor5Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Eliminar contacto en vendedor 5, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		eliminarContactoVendedor5();
	}

	@FXML
	void agregarContactoSugeridoAction5(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto sugerido en vendedor 5, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarContactoSugerido5();
	}

	@FXML
	void agregarContactoBusquedaAction5(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto en la busqueda de contactos en vendedor 5, seleccionado por un usuario con codigo" + codigoUsuario, 1, "Boton");
		agregarContactoBusqueda5();
	}

	@FXML
	void buscarVendedor5Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Buscar contacto en vendedor 5, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		buscarVendedores5();
	}

	@FXML
	void enviarMensajeVendedor5Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Enviar mensaje en vendedor 5, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		enviarMensajeVendedor5();
	}
	
	
	
	//------------------------------------------------------------Actions Vendedor 6-------------------------------------------------------------------------------
    
	@FXML
	void publicarProductoVendedor6Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de publicar producto vendedor 6, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		publicarProductoVendedor6();
	}

	@FXML
	void agregarProductoVendedor6Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de agregar producto vendedor 6, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		agregarProductoVendedor6();
	}

	@FXML
	void actualizarProductoVendedor6Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar producto vendedor 6, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarProductoVendedor6();
	}

	@FXML
	void eliminarProductoVendedor6Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar producto vendedor 6, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarProductoVendedor6();
	}

	@FXML
	void actualizarPublicacionVendedor6Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar publicacion vendedor 6, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarPublicacionVendedor6();
	}

	@FXML
	void eliminarPublicacionVendedor6Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar publicacion vendedor 6, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarPublicacionVendedor6();
	}

	@FXML
	void likePublicacionVendedor6Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de dar like en publicacion vendedor 6, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		darLikePublicacionVendedor6();
	}

	@FXML
	void agregarComentarioPublicacionVendedor6(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de comentar en publicacion vendedor 6, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarComentarioPublicacionVendedor6();
	}

	@FXML
	void eliminarContactoVendedor6Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Eliminar contacto en vendedor 6, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		eliminarContactoVendedor6();
	}

	@FXML
	void agregarContactoSugeridoAction6(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto sugerido en vendedor 6, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarContactoSugerido6();
	}

	@FXML
	void agregarContactoBusquedaAction6(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto en la busqueda de contactos en vendedor 6, seleccionado por un usuario con codigo" + codigoUsuario, 1, "Boton");
		agregarContactoBusqueda6();
	}

	@FXML
	void buscarVendedor6Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Buscar contacto en vendedor 6, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		buscarVendedores6();
	}

	@FXML
	void enviarMensajeVendedor6Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Enviar mensaje en vendedor 6, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		enviarMensajeVendedor6();
	}
		
		
	//------------------------------------------------------------Actions Vendedor 7-------------------------------------------------------------------------------
	    
	@FXML
	void publicarProductoVendedor7Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de publicar producto vendedor 7, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		publicarProductoVendedor7();
	}

	@FXML
	void agregarProductoVendedor7Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de agregar producto vendedor 7, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		agregarProductoVendedor7();
	}

	@FXML
	void actualizarProductoVendedor7Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar producto vendedor 7, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarProductoVendedor7();
	}

	@FXML
	void eliminarProductoVendedor7Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar producto vendedor 7, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarProductoVendedor7();
	}

	@FXML
	void actualizarPublicacionVendedor7Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar publicacion vendedor 7, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarPublicacionVendedor7();
	}

	@FXML
	void eliminarPublicacionVendedor7Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar publicacion vendedor 7, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarPublicacionVendedor7();
	}

	@FXML
	void likePublicacionVendedor7Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de dar like en publicacion vendedor 7, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		darLikePublicacionVendedor7();
	}

	@FXML
	void agregarComentarioPublicacionVendedor7(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de comentar en publicacion vendedor 7, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarComentarioPublicacionVendedor7();
	}

	@FXML
	void eliminarContactoVendedor7Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Eliminar contacto en vendedor 7, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		eliminarContactoVendedor7();
	}

	@FXML
	void agregarContactoSugeridoAction7(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto sugerido en vendedor 7, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarContactoSugerido7();
	}

	@FXML
	void agregarContactoBusquedaAction7(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto en la busqueda de contactos en vendedor 7, seleccionado por un usuario con codigo" + codigoUsuario, 1, "Boton");
		agregarContactoBusqueda7();
	}

	@FXML
	void buscarVendedor7Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Buscar contacto en vendedor 7, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		buscarVendedores7();
	}

	@FXML
	void enviarMensajeVendedor7Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Enviar mensaje en vendedor 7, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		enviarMensajeVendedor7();
	}


	//------------------------------------------------------------Actions Vendedor 8-------------------------------------------------------------------------------

	@FXML
	void publicarProductoVendedor8Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de publicar producto vendedor 8, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		publicarProductoVendedor8();
	}

	@FXML
	void agregarProductoVendedor8Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de agregar producto vendedor 8, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		agregarProductoVendedor8();
	}

	@FXML
	void actualizarProductoVendedor8Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar producto vendedor 8, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarProductoVendedor8();
	}

	@FXML
	void eliminarProductoVendedor8Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar producto vendedor 8, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarProductoVendedor8();
	}

	@FXML
	void actualizarPublicacionVendedor8Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar publicacion vendedor 8, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarPublicacionVendedor8();
	}

	@FXML
	void eliminarPublicacionVendedor8Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar publicacion vendedor 8, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarPublicacionVendedor8();
	}

	@FXML
	void likePublicacionVendedor8Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de dar like en publicacion vendedor 8, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		darLikePublicacionVendedor8();
	}

	@FXML
	void agregarComentarioPublicacionVendedor8(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de comentar en publicacion vendedor 8, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarComentarioPublicacionVendedor8();
	}

	@FXML
	void eliminarContactoVendedor8Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Eliminar contacto en vendedor 8, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		eliminarContactoVendedor8();
	}

	@FXML
	void agregarContactoSugeridoAction8(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto sugerido en vendedor 8, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarContactoSugerido8();
	}

	@FXML
	void agregarContactoBusquedaAction8(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto en la busqueda de contactos en vendedor 8, seleccionado por un usuario con codigo" + codigoUsuario, 1, "Boton");
		agregarContactoBusqueda8();
	}

	@FXML
	void buscarVendedor8Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Buscar contacto en vendedor 8, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		buscarVendedores8();
	}

	@FXML
	void enviarMensajeVendedor8Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Enviar mensaje en vendedor 8, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		enviarMensajeVendedor8();
	}


	//------------------------------------------------------------Actions Vendedor 9-------------------------------------------------------------------------------

	@FXML
	void publicarProductoVendedor9Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de publicar producto vendedor 9, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		publicarProductoVendedor9();
	}

	@FXML
	void agregarProductoVendedor9Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de agregar producto vendedor 9, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		agregarProductoVendedor9();
	}

	@FXML
	void actualizarProductoVendedor9Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar producto vendedor 9, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarProductoVendedor9();
	}

	@FXML
	void eliminarProductoVendedor9Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar producto vendedor 9, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarProductoVendedor9();
	}

	@FXML
	void actualizarPublicacionVendedor9Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar publicacion vendedor 9, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarPublicacionVendedor9();
	}

	@FXML
	void eliminarPublicacionVendedor9Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar publicacion vendedor 9, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarPublicacionVendedor9();
	}

	@FXML
	void likePublicacionVendedor9Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de dar like en publicacion vendedor 9, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		darLikePublicacionVendedor9();
	}

	@FXML
	void agregarComentarioPublicacionVendedor9(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de comentar en publicacion vendedor 9, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarComentarioPublicacionVendedor9();
	}

	@FXML
	void eliminarContactoVendedor9Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Eliminar contacto en vendedor 9, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		eliminarContactoVendedor9();
	}

	@FXML
	void agregarContactoSugeridoAction9(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto sugerido en vendedor 9, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarContactoSugerido9();
	}

	@FXML
	void agregarContactoBusquedaAction9(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto en la busqueda de contactos en vendedor 9, seleccionado por un usuario con codigo" + codigoUsuario, 1, "Boton");
		agregarContactoBusqueda9();
	}

	@FXML
	void buscarVendedor9Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Buscar contacto en vendedor 9, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		buscarVendedores9();
	}

	@FXML
	void enviarMensajeVendedor9Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Enviar mensaje en vendedor 9, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		enviarMensajeVendedor9();
	}
		
		
	//------------------------------------------------------------Actions Vendedor 10-------------------------------------------------------------------------------

	@FXML
	void publicarProductoVendedor10Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de publicar producto vendedor 10, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		publicarProductoVendedor10();
	}

	@FXML
	void agregarProductoVendedor10Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de agregar producto vendedor 10, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		agregarProductoVendedor10();
	}

	@FXML
	void actualizarProductoVendedor10Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar producto vendedor 10, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarProductoVendedor10();
	}

	@FXML
	void eliminarProductoVendedor10Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar producto vendedor 10, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarProductoVendedor10();
	}

	@FXML
	void actualizarPublicacionVendedor10Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de actualizar publicacion vendedor 10, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		actualizarPublicacionVendedor10();
	}

	@FXML
	void eliminarPublicacionVendedor10Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de eliminar publicacion vendedor 10, seleccionado por usuario con codigo "+codigoUsuario, 2, "Boton");
		eliminarPublicacionVendedor10();
	}

	@FXML
	void likePublicacionVendedor10Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de dar like en publicacion vendedor 10, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		darLikePublicacionVendedor10();
	}

	@FXML
	void agregarComentarioPublicacionVendedor10(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de comentar en publicacion vendedor 10, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarComentarioPublicacionVendedor10();
	}

	@FXML
	void eliminarContactoVendedor10Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Eliminar contacto en vendedor 10, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		eliminarContactoVendedor10();
	}

	@FXML
	void agregarContactoSugeridoAction10(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto sugerido en vendedor 10, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		agregarContactoSugerido10();
	}

	@FXML
	void agregarContactoBusquedaAction10(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Agregar contacto en la busqueda de contactos en vendedor 10, seleccionado por un usuario con codigo" + codigoUsuario, 1, "Boton");
		agregarContactoBusqueda10();
	}

	@FXML
	void buscarVendedor10Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Buscar contacto en vendedor 10, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		buscarVendedores10();
	}

	@FXML
	void enviarMensajeVendedor10Action(ActionEvent event) {
		modelFactoryController.registrarAccionesSistema("Boton de Enviar mensaje en vendedor 10, seleccionado por usuario con codigo "+codigoUsuario, 1, "Boton");
		enviarMensajeVendedor10();
	}
	
		
    
    //-------------------------------------------------------------Initialize------------------------------------------------------------

	/**
     * Metodo inicializador
     */
    @FXML
    void initialize() {
    	modelFactoryController        = modelFactoryController.getInstance();
    	crudVendedorViewController    = new CrudVendedorViewController(modelFactoryController);
    	crudProductoViewController    = new CrudProductoViewController(modelFactoryController);
    	crudPublicacionViewController = new CrudPublicacionViewController(modelFactoryController);
    	crudContactosViewController   = new CrudContactosViewController(modelFactoryController);
    	
    	//Inicializa los vendedores actuales del marketplace en admin
    	inicializarVendedorView();
    	
    	//Inicializa tables de la pestaña de vendedor 1
    	inicializarProductos1();
    	inicializarPublicaciones1();
    	inicializarContactos1();
    	inicializarSugerencias1();
    	inicializarContactosBusqueda1();
    	
    	//Inicializa tables de la pestaña de vendedor 2
    	inicializarProductos2();
    	inicializarPublicaciones2();
    	inicializarContactos2();
    	inicializarSugerencias2();
    	inicializarContactosBusqueda2();
    	
    	//Inicializa tables de la pestaña de vendedor 3
    	inicializarProductos3();
    	inicializarPublicaciones3();
    	inicializarContactos3();
    	inicializarSugerencias3();
    	inicializarContactosBusqueda3();
    	
    	//Inicializa tables de la pestaña de vendedor 4
    	inicializarProductos4();
    	inicializarPublicaciones4();
    	inicializarContactos4();
    	inicializarSugerencias4();
    	inicializarContactosBusqueda4();
    	
    	//Inicializa tables de la pestaña de vendedor 5
    	inicializarProductos5();
    	inicializarPublicaciones5();
    	inicializarContactos5();
    	inicializarSugerencias5();
    	inicializarContactosBusqueda5();
    	
    	//Inicializa tables de la pestaña de vendedor 6
    	inicializarProductos6();
    	inicializarPublicaciones6();
    	inicializarContactos6();
    	inicializarSugerencias6();
    	inicializarContactosBusqueda6();
    	
    	//Inicializa tables de la pestaña de vendedor 7
    	inicializarProductos7();
    	inicializarPublicaciones7();
    	inicializarContactos7();
    	inicializarSugerencias7();
    	inicializarContactosBusqueda7();
    	
    	//Inicializa tables de la pestaña de vendedor 8
    	inicializarProductos8();
    	inicializarPublicaciones8();
    	inicializarContactos8();
    	inicializarSugerencias8();
    	inicializarContactosBusqueda8();
    	
    	//Inicializa tables de la pestaña de vendedor 9
    	inicializarProductos9();
    	inicializarPublicaciones9();
    	inicializarContactos9();
    	inicializarSugerencias9();
    	inicializarContactosBusqueda9();
    	
    	//Inicializa tables de la pestaña de vendedor 10
    	inicializarProductos10();
    	inicializarPublicaciones10();
    	inicializarContactos10();
    	inicializarSugerencias10();
    	inicializarContactosBusqueda10();
    	
    	
    	//Set comboboxes y tabs
    	setComboBoxes();
    	setTabs();
    	
    }
    
    //-------------------------------------------------------Inicializar para vendedores----------------------------------------------------------------------

    //Vendedor 1

	private void inicializarPublicaciones1() {
		inicializarPublicaciones(columnFechaPublicacionVendedor1, columnNombreProductoPublicacionVendedor1, columnPrecioProductoPublicacionVendedor1,
				columnLikesVendedor1, tablePublicacionesVendedor1, 1);
	}

	private void inicializarProductos1() {
		inicializarProductos(columnNombreProductoVendedor1, columnPrecioProductoVendedor1, columnEstadoProductoVendedor1, columnCategoriaProductoVendedor1,
				columnFechaProductoVendedor1, tableProductosVendedor1, 1);
	}
	
	private void inicializarContactos1() {
		inicializarContactos(columnNombreContactosVendedor1, columnApellidoContactosVendedor1, tableContactosVendedor1);
	}
	
	private void inicializarSugerencias1() {
		inicializarSugeridos(columnNombreSugeridosVendedor1, columnApellidoSugeridosVendedor1, tableSugeridosVendedor1);
		
	}
	
	private void inicializarContactosBusqueda1() {
		inicializarContactosBusqueda(columnNombreContactoBusqueda1, columnApellidoContactoBusqueda1, tableBusquedaContactos1);
		
	}
	
	//Vendedor 2
	
	private void inicializarPublicaciones2() {
		inicializarPublicaciones(columnFechaPublicacionVendedor2, columnNombreProductoPublicacionVendedor2, columnPrecioProductoPublicacionVendedor2,
				columnLikesVendedor2, tablePublicacionesVendedor2, 2);
	}

	private void inicializarProductos2() {
		inicializarProductos(columnNombreProductoVendedor2, columnPrecioProductoVendedor2, columnEstadoProductoVendedor2, columnCategoriaProductoVendedor2,
				columnFechaProductoVendedor2, tableProductosVendedor2, 2);
	}
	
	private void inicializarContactos2() {
		inicializarContactos(columnNombreContactosVendedor2, columnApellidoContactosVendedor2, tableContactosVendedor2);
	}
	
	private void inicializarSugerencias2() {
		inicializarSugeridos(columnNombreSugeridosVendedor2, columnApellidoSugeridosVendedor2, tableSugeridosVendedor2);
		
	}
	
	private void inicializarContactosBusqueda2() {
		inicializarContactosBusqueda(columnNombreContactoBusqueda2, columnApellidoContactoBusqueda2, tableBusquedaContactos2);
		
	}
	
	//Vendedor 3

	private void inicializarPublicaciones3() {
		inicializarPublicaciones(columnFechaPublicacionVendedor3, columnNombreProductoPublicacionVendedor3, columnPrecioProductoPublicacionVendedor3,
				columnLikesVendedor3, tablePublicacionesVendedor3, 3);
	}

	private void inicializarProductos3() {
		inicializarProductos(columnNombreProductoVendedor3, columnPrecioProductoVendedor3, columnEstadoProductoVendedor3, columnCategoriaProductoVendedor3,
				columnFechaProductoVendedor3, tableProductosVendedor3, 3);
	}

	private void inicializarContactos3() {
		inicializarContactos(columnNombreContactosVendedor3, columnApellidoContactosVendedor3, tableContactosVendedor3);
	}

	private void inicializarSugerencias3() {
		inicializarSugeridos(columnNombreSugeridosVendedor3, columnApellidoSugeridosVendedor3, tableSugeridosVendedor3);

	}

	private void inicializarContactosBusqueda3() {
		inicializarContactosBusqueda(columnNombreContactoBusqueda3, columnApellidoContactoBusqueda3, tableBusquedaContactos3);

	}

	//Vendedor 4

	private void inicializarPublicaciones4() {
		inicializarPublicaciones(columnFechaPublicacionVendedor4, columnNombreProductoPublicacionVendedor4, columnPrecioProductoPublicacionVendedor4,
				columnLikesVendedor4, tablePublicacionesVendedor4, 4);
	}

	private void inicializarProductos4() {
		inicializarProductos(columnNombreProductoVendedor4, columnPrecioProductoVendedor4, columnEstadoProductoVendedor4, columnCategoriaProductoVendedor4,
				columnFechaProductoVendedor4, tableProductosVendedor4, 4);
	}

	private void inicializarContactos4() {
		inicializarContactos(columnNombreContactosVendedor4, columnApellidoContactosVendedor4, tableContactosVendedor4);
	}

	private void inicializarSugerencias4() {
		inicializarSugeridos(columnNombreSugeridosVendedor4, columnApellidoSugeridosVendedor4, tableSugeridosVendedor4);

	}

	private void inicializarContactosBusqueda4() {
		inicializarContactosBusqueda(columnNombreContactoBusqueda4, columnApellidoContactoBusqueda4, tableBusquedaContactos4);

	}
	
	//Vendedor 5

	private void inicializarPublicaciones5() {
		inicializarPublicaciones(columnFechaPublicacionVendedor5, columnNombreProductoPublicacionVendedor5, columnPrecioProductoPublicacionVendedor5,
				columnLikesVendedor5, tablePublicacionesVendedor5, 5);
	}

	private void inicializarProductos5() {
		inicializarProductos(columnNombreProductoVendedor5, columnPrecioProductoVendedor5, columnEstadoProductoVendedor5, columnCategoriaProductoVendedor5,
				columnFechaProductoVendedor5, tableProductosVendedor5, 5);
	}

	private void inicializarContactos5() {
		inicializarContactos(columnNombreContactosVendedor5, columnApellidoContactosVendedor5, tableContactosVendedor5);
	}

	private void inicializarSugerencias5() {
		inicializarSugeridos(columnNombreSugeridosVendedor5, columnApellidoSugeridosVendedor5, tableSugeridosVendedor5);

	}

	private void inicializarContactosBusqueda5() {
		inicializarContactosBusqueda(columnNombreContactoBusqueda5, columnApellidoContactoBusqueda5, tableBusquedaContactos5);

	}
	
	
	//Vendedor 6

	private void inicializarPublicaciones6() {
		inicializarPublicaciones(columnFechaPublicacionVendedor6, columnNombreProductoPublicacionVendedor6, columnPrecioProductoPublicacionVendedor6,
				columnLikesVendedor6, tablePublicacionesVendedor6, 6);
	}

	private void inicializarProductos6() {
		inicializarProductos(columnNombreProductoVendedor6, columnPrecioProductoVendedor6, columnEstadoProductoVendedor6, columnCategoriaProductoVendedor6,
				columnFechaProductoVendedor6, tableProductosVendedor6, 6);
	}

	private void inicializarContactos6() {
		inicializarContactos(columnNombreContactosVendedor6, columnApellidoContactosVendedor6, tableContactosVendedor6);
	}

	private void inicializarSugerencias6() {
		inicializarSugeridos(columnNombreSugeridosVendedor6, columnApellidoSugeridosVendedor6, tableSugeridosVendedor6);

	}

	private void inicializarContactosBusqueda6() {
		inicializarContactosBusqueda(columnNombreContactoBusqueda6, columnApellidoContactoBusqueda6, tableBusquedaContactos6);

	}

	//Vendedor 7

	private void inicializarPublicaciones7() {
		inicializarPublicaciones(columnFechaPublicacionVendedor7, columnNombreProductoPublicacionVendedor7, columnPrecioProductoPublicacionVendedor7,
				columnLikesVendedor7, tablePublicacionesVendedor7, 7);
	}

	private void inicializarProductos7() {
		inicializarProductos(columnNombreProductoVendedor7, columnPrecioProductoVendedor7, columnEstadoProductoVendedor7, columnCategoriaProductoVendedor7,
				columnFechaProductoVendedor7, tableProductosVendedor7, 7);
	}

	private void inicializarContactos7() {
		inicializarContactos(columnNombreContactosVendedor7, columnApellidoContactosVendedor7, tableContactosVendedor7);
	}

	private void inicializarSugerencias7() {
		inicializarSugeridos(columnNombreSugeridosVendedor7, columnApellidoSugeridosVendedor7, tableSugeridosVendedor7);

	}

	private void inicializarContactosBusqueda7() {
		inicializarContactosBusqueda(columnNombreContactoBusqueda7, columnApellidoContactoBusqueda7, tableBusquedaContactos7);

	}

	//Vendedor 8

	private void inicializarPublicaciones8() {
		inicializarPublicaciones(columnFechaPublicacionVendedor8, columnNombreProductoPublicacionVendedor8, columnPrecioProductoPublicacionVendedor8,
				columnLikesVendedor8, tablePublicacionesVendedor8, 8);
	}

	private void inicializarProductos8() {
		inicializarProductos(columnNombreProductoVendedor8, columnPrecioProductoVendedor8, columnEstadoProductoVendedor8, columnCategoriaProductoVendedor8,
				columnFechaProductoVendedor8, tableProductosVendedor8, 8);
	}

	private void inicializarContactos8() {
		inicializarContactos(columnNombreContactosVendedor8, columnApellidoContactosVendedor8, tableContactosVendedor8);
	}

	private void inicializarSugerencias8() {
		inicializarSugeridos(columnNombreSugeridosVendedor8, columnApellidoSugeridosVendedor8, tableSugeridosVendedor8);

	}

	private void inicializarContactosBusqueda8() {
		inicializarContactosBusqueda(columnNombreContactoBusqueda8, columnApellidoContactoBusqueda8, tableBusquedaContactos8);

	}

	//Vendedor 9

	private void inicializarPublicaciones9() {
		inicializarPublicaciones(columnFechaPublicacionVendedor9, columnNombreProductoPublicacionVendedor9, columnPrecioProductoPublicacionVendedor9,
				columnLikesVendedor9, tablePublicacionesVendedor9, 9);
	}

	private void inicializarProductos9() {
		inicializarProductos(columnNombreProductoVendedor9, columnPrecioProductoVendedor9, columnEstadoProductoVendedor9, columnCategoriaProductoVendedor9,
				columnFechaProductoVendedor9, tableProductosVendedor9, 9);
	}

	private void inicializarContactos9() {
		inicializarContactos(columnNombreContactosVendedor9, columnApellidoContactosVendedor9, tableContactosVendedor9);
	}

	private void inicializarSugerencias9() {
		inicializarSugeridos(columnNombreSugeridosVendedor9, columnApellidoSugeridosVendedor9, tableSugeridosVendedor9);

	}

	private void inicializarContactosBusqueda9() {
		inicializarContactosBusqueda(columnNombreContactoBusqueda9, columnApellidoContactoBusqueda9, tableBusquedaContactos9);

	}

	//Vendedor 10

	private void inicializarPublicaciones10() {
		inicializarPublicaciones(columnFechaPublicacionVendedor10, columnNombreProductoPublicacionVendedor10, columnPrecioProductoPublicacionVendedor10,
				columnLikesVendedor10, tablePublicacionesVendedor10, 10);
	}

	private void inicializarProductos10() {
		inicializarProductos(columnNombreProductoVendedor10, columnPrecioProductoVendedor10, columnEstadoProductoVendedor10, columnCategoriaProductoVendedor10,
				columnFechaProductoVendedor10, tableProductosVendedor10, 10);
	}

	private void inicializarContactos10() {
		inicializarContactos(columnNombreContactosVendedor10, columnApellidoContactosVendedor10, tableContactosVendedor10);
	}

	private void inicializarSugerencias10() {
		inicializarSugeridos(columnNombreSugeridosVendedor10, columnApellidoSugeridosVendedor10, tableSugeridosVendedor10);

	}

	private void inicializarContactosBusqueda10() {
		inicializarContactosBusqueda(columnNombreContactoBusqueda10, columnApellidoContactoBusqueda10, tableBusquedaContactos10);

	}
	
	//----------------------------------------------------Metodos inicializar Genericos----------------------------------------------------------------------
	
	private void inicializarContactosBusqueda(TableColumn<Vendedor, String> columnNombreContactoBusqueda,
			TableColumn<Vendedor, String> columnApellidoContactoBusqueda,
			TableView<Vendedor> tableBusquedaContactos) {
		
		columnNombreContactoBusqueda.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnApellidoContactoBusqueda.setCellValueFactory(new PropertyValueFactory<>("apellido"));

		tableBusquedaContactos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{

			vendedorBuscadoSeleccionado = newSelection;
		});
		
	}
	
	private void inicializarSugeridos(TableColumn<Vendedor, String> columnNombreSugeridosVendedor,
			TableColumn<Vendedor, String> columnApellidoSugeridosVendedor,
			TableView<Vendedor> tableSugeridosVendedor) {
		
		columnNombreSugeridosVendedor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnApellidoSugeridosVendedor.setCellValueFactory(new PropertyValueFactory<>("apellido"));

		tableSugeridosVendedor.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{

			contactoSugeridoSeleccionado = newSelection;
		});
		
	}

	private void inicializarPublicaciones(TableColumn<Publicacion, String> columnFechaPublicacionVendedor,
			TableColumn<Publicacion, String> columnNombreProductoPublicacionVendedor,
			TableColumn<Publicacion, String> columnPrecioProductoPublicacionVendedor,
			TableColumn<Publicacion, String> columnLikesVendedor,
			TableView<Publicacion> tablePublicacionesVendedor, int i) {
		
		columnFechaPublicacionVendedor.setCellValueFactory(new PropertyValueFactory<>("fechaPublicacion"));
		columnNombreProductoPublicacionVendedor.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
		columnPrecioProductoPublicacionVendedor.setCellValueFactory(new PropertyValueFactory<>("precioProducto"));
		columnLikesVendedor.setCellValueFactory(new PropertyValueFactory<>("like"));
		
		tablePublicacionesVendedor.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{

    		publicacionSeleccionada = newSelection;
    		mostrarInformacionProductoPublicacion(publicacionSeleccionada, i);
    		mostrarComentariosPublicacion(publicacionSeleccionada, i);
    	});
		
	}

	private void inicializarProductos(TableColumn<Producto, String> columnNombreProductoVendedor,
			TableColumn<Producto, String> columnPrecioProductoVendedor,
			TableColumn<Producto, String> columnEstadoProductoVendedor,
			TableColumn<Producto, String> columnCategoriaProductoVendedor,
			TableColumn<Producto, String> columnFechaProductoVendedor, TableView<Producto> tableProductosVendedor, int i) {

		columnNombreProductoVendedor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnPrecioProductoVendedor.setCellValueFactory(new PropertyValueFactory<>("precio"));
		columnEstadoProductoVendedor.setCellValueFactory(new PropertyValueFactory<>("estado"));
		columnCategoriaProductoVendedor.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		columnFechaProductoVendedor.setCellValueFactory(new PropertyValueFactory<>("fecha"));

		tableProductosVendedor.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{

			productoSeleccionado = newSelection;
			mostrarInformacionProductos(productoSeleccionado, i);
		});
		
	}
	
	private void inicializarContactos(TableColumn<Vendedor, String> columnNombreContactosVendedor,
			TableColumn<Vendedor, String> columnApellidoContactosVendedor,
			TableView<Vendedor> tableContactosVendedor) {

		columnNombreContactosVendedor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnApellidoContactosVendedor.setCellValueFactory(new PropertyValueFactory<>("apellido"));

		tableContactosVendedor.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{

			contactoSeleccionado = newSelection;
		});

	}
	
	private void mostrarInformacionProductoPublicacion(Publicacion publicacionSeleccionada, int i) {
		switch (i) {
		case 1:
			mostrarInformacionProductoPublicacion1(publicacionSeleccionada);
			break;

		case 2:
			mostrarInformacionProductoPublicacion2(publicacionSeleccionada);
			break;

		case 3:
			mostrarInformacionProductoPublicacion3(publicacionSeleccionada);
			break;
			
		case 4:
			mostrarInformacionProductoPublicacion4(publicacionSeleccionada);
			break;

		case 5:
			mostrarInformacionProductoPublicacion5(publicacionSeleccionada);
			break;
			
		case 6:
			mostrarInformacionProductoPublicacion6(publicacionSeleccionada);
			break;

		case 7:
			mostrarInformacionProductoPublicacion7(publicacionSeleccionada);
			break;
			
		case 8:
			mostrarInformacionProductoPublicacion8(publicacionSeleccionada);
			break;

		case 9:
			mostrarInformacionProductoPublicacion9(publicacionSeleccionada);
			break;
			
		case 10:
			mostrarInformacionProductoPublicacion10(publicacionSeleccionada);
			break;

		default:
			break;
		}
	}
	
	private void mostrarComentariosPublicacion(Publicacion publicacionSeleccionada, int i) {
		switch (i) {
		case 1:
			mostrarComentariosPublicacion1(publicacionSeleccionada);
			break;

		case 2:
			mostrarComentariosPublicacion2(publicacionSeleccionada);
			break;

		case 3:
			mostrarComentariosPublicacion3(publicacionSeleccionada);
			break;
			
		case 4:
			mostrarComentariosPublicacion4(publicacionSeleccionada);
			break;

		case 5:
			mostrarComentariosPublicacion5(publicacionSeleccionada);
			break;
			
		case 6:
			mostrarComentariosPublicacion6(publicacionSeleccionada);
			break;

		case 7:
			mostrarComentariosPublicacion7(publicacionSeleccionada);
			break;
			
		case 8:
			mostrarComentariosPublicacion8(publicacionSeleccionada);
			break;
			
		case 9:
			mostrarComentariosPublicacion9(publicacionSeleccionada);
			break;
			
		case 10:
			mostrarComentariosPublicacion10(publicacionSeleccionada);
			break;

		default:
			break;
		}
	}
	
	private void mostrarInformacionProductos(Producto productoSeleccionado, int i) {
		switch (i) {
		case 1:
			mostrarInformacionProductos1(productoSeleccionado);
			break;

		case 2:
			mostrarInformacionProductos2(productoSeleccionado);
			break;

		case 3:
			mostrarInformacionProductos3(productoSeleccionado);
			break;
			
		case 4:
			mostrarInformacionProductos4(productoSeleccionado);
			break;
			
		case 5:
			mostrarInformacionProductos5(productoSeleccionado);
			break;
			
		case 6:
			mostrarInformacionProductos6(productoSeleccionado);
			break;
			
		case 7:
			mostrarInformacionProductos7(productoSeleccionado);
			break;
			
		case 8:
			mostrarInformacionProductos8(productoSeleccionado);
			break;
			
		case 9:
			mostrarInformacionProductos9(productoSeleccionado);
			break;
			
		case 10:
			mostrarInformacionProductos10(productoSeleccionado);
			break;

		default:
			break;
		}
	}
	
	//----------------------------------------------------Inicializar para vendedores en la pestaña admin-------------------------------------------

	/**
     * Metodo que inicializa los datos de los vendedores en la tableview
     */
	private void inicializarVendedorView() {

    	this.columnNombreVendedoresAdmin.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.columnApellidoVendedoresAdmin.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    	this.columnCedulaVendedoresAdmin.setCellValueFactory(new PropertyValueFactory<>("cedula"));
    	this.columnDireccionVendedoresAdmin.setCellValueFactory(new PropertyValueFactory<>("direccion"));

    	tableVendedoresAdmin.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{

    		vendedorSeleccionado = newSelection;

    		mostrarInformacionVendedor(vendedorSeleccionado);

    	});

	}
	
	//---------------------------------------------Mostrar info de las tablas a textfields de cada uno de los vendedores-------------------------------------------

	/**
	 * Metodo para mostra la info de los vendedores en los campos de texto cuando son seleccionados
	 * @param vendedorSeleccionado
	 */
	 private void mostrarInformacionVendedor(Vendedor vendedorSeleccionado) {
		 if(vendedorSeleccionado != null){
			 txtNombreVendedorAdmin.setText(vendedorSeleccionado.getNombre());
			 txtApellidoVendedorAdmin.setText(vendedorSeleccionado.getApellido());
			 txtCedulaVendedorAdmin.setText(vendedorSeleccionado.getCedula());
			 txtDireccionVendedorAdmin.setText(vendedorSeleccionado.getDireccion());
			 passTxtContraseñaVendedorAdmin.setPromptText((vendedorSeleccionado.getContraseña()));

		 }
	 }
	 
	 //Mostrar info vendedor 1

	 private void mostrarInformacionProductos1(Producto productoSeleccionado) {
		 motrarInformacionProductosGenerico(productoSeleccionado, txtNombreProductoVendedor1, txtPrecioProductoVendedor1, comboBoxCategoriaVendedor1, comboBoxEstadoVendedor1);
	 }

	 private void mostrarInformacionProductoPublicacion1(Publicacion publicacionSeleccionada) {
		 motrarInformacionProductoPublicacionGenerico(publicacionSeleccionada,  txtNombreProductoVendedor1,  txtPrecioProductoVendedor1,  comboBoxCategoriaVendedor1, comboBoxEstadoVendedor1);
	 }

	 //Mostrar info vendedor 2

	 private void mostrarInformacionProductos2(Producto productoSeleccionado) {
		 motrarInformacionProductosGenerico(productoSeleccionado, txtNombreProductoVendedor2, txtPrecioProductoVendedor2, comboBoxCategoriaVendedor2, comboBoxEstadoVendedor2);
	 }

	 private void mostrarInformacionProductoPublicacion2(Publicacion publicacionSeleccionada) {
		 motrarInformacionProductoPublicacionGenerico(publicacionSeleccionada,  txtNombreProductoVendedor2,  txtPrecioProductoVendedor2,  comboBoxCategoriaVendedor2, comboBoxEstadoVendedor2);
	 }

	 //Mostrar info vendedor 3

	 private void mostrarInformacionProductos3(Producto productoSeleccionado) {
		 motrarInformacionProductosGenerico(productoSeleccionado, txtNombreProductoVendedor3, txtPrecioProductoVendedor3, comboBoxCategoriaVendedor3, comboBoxEstadoVendedor3);
	 }

	 private void mostrarInformacionProductoPublicacion3(Publicacion publicacionSeleccionada) {
		 motrarInformacionProductoPublicacionGenerico(publicacionSeleccionada,  txtNombreProductoVendedor3,  txtPrecioProductoVendedor3,  comboBoxCategoriaVendedor3, comboBoxEstadoVendedor3);
	 }

	 //Mostrar info vendedor 4

	 private void mostrarInformacionProductos4(Producto productoSeleccionado) {
		 motrarInformacionProductosGenerico(productoSeleccionado, txtNombreProductoVendedor4, txtPrecioProductoVendedor4, comboBoxCategoriaVendedor4, comboBoxEstadoVendedor4);
	 }

	 private void mostrarInformacionProductoPublicacion4(Publicacion publicacionSeleccionada) {
		 motrarInformacionProductoPublicacionGenerico(publicacionSeleccionada,  txtNombreProductoVendedor4,  txtPrecioProductoVendedor4,  comboBoxCategoriaVendedor4, comboBoxEstadoVendedor4);
	 }
	 
	//Mostrar info vendedor 5

	 private void mostrarInformacionProductos5(Producto productoSeleccionado) {
		 motrarInformacionProductosGenerico(productoSeleccionado, txtNombreProductoVendedor5, txtPrecioProductoVendedor5, comboBoxCategoriaVendedor5, comboBoxEstadoVendedor5);
	 }

	 private void mostrarInformacionProductoPublicacion5(Publicacion publicacionSeleccionada) {
		 motrarInformacionProductoPublicacionGenerico(publicacionSeleccionada,  txtNombreProductoVendedor5,  txtPrecioProductoVendedor5,  comboBoxCategoriaVendedor5, comboBoxEstadoVendedor5);
	 }
	 
	 
	//Mostrar info vendedor 6

	 private void mostrarInformacionProductos6(Producto productoSeleccionado) {
		 motrarInformacionProductosGenerico(productoSeleccionado, txtNombreProductoVendedor6, txtPrecioProductoVendedor6, comboBoxCategoriaVendedor6, comboBoxEstadoVendedor6);
	 }

	 private void mostrarInformacionProductoPublicacion6(Publicacion publicacionSeleccionada) {
		 motrarInformacionProductoPublicacionGenerico(publicacionSeleccionada,  txtNombreProductoVendedor6,  txtPrecioProductoVendedor6,  comboBoxCategoriaVendedor6, comboBoxEstadoVendedor6);
	 }

	 //Mostrar info vendedor 7

	 private void mostrarInformacionProductos7(Producto productoSeleccionado) {
		 motrarInformacionProductosGenerico(productoSeleccionado, txtNombreProductoVendedor7, txtPrecioProductoVendedor7, comboBoxCategoriaVendedor7, comboBoxEstadoVendedor7);
	 }

	 private void mostrarInformacionProductoPublicacion7(Publicacion publicacionSeleccionada) {
		 motrarInformacionProductoPublicacionGenerico(publicacionSeleccionada,  txtNombreProductoVendedor7,  txtPrecioProductoVendedor7,  comboBoxCategoriaVendedor7, comboBoxEstadoVendedor7);
	 }

	 //Mostrar info vendedor 8

	 private void mostrarInformacionProductos8(Producto productoSeleccionado) {
		 motrarInformacionProductosGenerico(productoSeleccionado, txtNombreProductoVendedor8, txtPrecioProductoVendedor8, comboBoxCategoriaVendedor8, comboBoxEstadoVendedor8);
	 }

	 private void mostrarInformacionProductoPublicacion8(Publicacion publicacionSeleccionada) {
		 motrarInformacionProductoPublicacionGenerico(publicacionSeleccionada,  txtNombreProductoVendedor8,  txtPrecioProductoVendedor8,  comboBoxCategoriaVendedor8, comboBoxEstadoVendedor8);
	 }

	 //Mostrar info vendedor 9

	 private void mostrarInformacionProductos9(Producto productoSeleccionado) {
		 motrarInformacionProductosGenerico(productoSeleccionado, txtNombreProductoVendedor9, txtPrecioProductoVendedor9, comboBoxCategoriaVendedor9, comboBoxEstadoVendedor9);
	 }

	 private void mostrarInformacionProductoPublicacion9(Publicacion publicacionSeleccionada) {
		 motrarInformacionProductoPublicacionGenerico(publicacionSeleccionada,  txtNombreProductoVendedor9,  txtPrecioProductoVendedor9,  comboBoxCategoriaVendedor9, comboBoxEstadoVendedor9);
	 }

	 //Mostrar info vendedor 10

	 private void mostrarInformacionProductos10(Producto productoSeleccionado) {
		 motrarInformacionProductosGenerico(productoSeleccionado, txtNombreProductoVendedor10, txtPrecioProductoVendedor10, comboBoxCategoriaVendedor10, comboBoxEstadoVendedor10);
	 }

	 private void mostrarInformacionProductoPublicacion10(Publicacion publicacionSeleccionada) {
		 motrarInformacionProductoPublicacionGenerico(publicacionSeleccionada,  txtNombreProductoVendedor10,  txtPrecioProductoVendedor10,  comboBoxCategoriaVendedor10, comboBoxEstadoVendedor10);
	 }
	 
	 
	
	//---------------------------------------------------Mostrar info de las tablas a textfields Genericos----------------------------------------------------------
	
	private void motrarInformacionProductosGenerico(Producto productoSeleccionado,
			TextField txtNombreProductoVendedor, TextField txtPrecioProductoVendedor,
			ComboBox<String> comboBoxCategoriaVendedor, ComboBox<String> comboBoxEstadoVendedor) {
		 
		 if(productoSeleccionado != null){
			 txtNombreProductoVendedor.setText(productoSeleccionado.getNombre());
			 txtPrecioProductoVendedor.setText(String.valueOf(productoSeleccionado.getPrecio()));
			 comboBoxCategoriaVendedor.setValue(obtenerTextoCategoriaProducto(productoSeleccionado.getCategoria()));
			 comboBoxEstadoVendedor.setValue(obtenerTextoEstadoProducto(productoSeleccionado.getEstado()));
			 
		 }
		
	}
	
	private void motrarInformacionProductoPublicacionGenerico(Publicacion publicacionSeleccionada,
			TextField txtNombreProductoVendedor, TextField txtPrecioProductoVendedor,
			ComboBox<String> comboBoxCategoriaVendedor, ComboBox<String> comboBoxEstadoVendedor) {

		if(publicacionSeleccionada != null){
			 txtNombreProductoVendedor.setText(publicacionSeleccionada.getProducto().getNombre());
			 txtPrecioProductoVendedor.setText(String.valueOf(publicacionSeleccionada.getProducto().getPrecio()));
			 comboBoxCategoriaVendedor.setValue(obtenerTextoCategoriaProducto(publicacionSeleccionada.getProducto().getCategoria()));
			 comboBoxEstadoVendedor.setValue(obtenerTextoEstadoProducto(publicacionSeleccionada.getProducto().getEstado()));
		 }
		
	}
	
	private void mostrarComentariosPublicacionGenerico(Publicacion publicacionSeleccionada, Label labelComentariosPublicacionVendedor) {
		if(publicacionSeleccionada != null){
			String tipoUsuario = modelFactoryController.obtenerTipoUsuario(codigoUsuario);

			if(tipoUsuario.equalsIgnoreCase("Vendedor")){
				if(modelFactoryController.verificarEsContacto(publicacionSeleccionada, codigoUsuario) == true ||
						modelFactoryController.verificarPosesionPublicacion(publicacionSeleccionada, codigoUsuario) == true){
					
//					String comentario = labelComentariosPublicacionVendedor.getText();
					labelComentariosPublicacionVendedor.setText(publicacionSeleccionada.getComentario());
				}
			}
			if(tipoUsuario.equalsIgnoreCase("Administrador")){
//				String comentario = labelComentariosPublicacionVendedor.getText();
				labelComentariosPublicacionVendedor.setText(publicacionSeleccionada.getComentario());
			}
		}
	}
	
	 //---------------------------------------------------Mostrar datos de las publicaciones al label de comentarios--------------------------------------
	 
	//Vendedor 1
	private void mostrarComentariosPublicacion1(Publicacion publicacionSeleccionada) {
		mostrarComentariosPublicacionGenerico(publicacionSeleccionada, labelComentariosPublicacionVendedor1);
	}
	
	//Vendedor 2
	private void mostrarComentariosPublicacion2(Publicacion publicacionSeleccionada) {
		mostrarComentariosPublicacionGenerico(publicacionSeleccionada, labelComentariosPublicacionVendedor2);
	}
	
	//Vendedor 3
	private void mostrarComentariosPublicacion3(Publicacion publicacionSeleccionada) {
		mostrarComentariosPublicacionGenerico(publicacionSeleccionada, labelComentariosPublicacionVendedor3);
	}
	
	//Vendedor 4
	private void mostrarComentariosPublicacion4(Publicacion publicacionSeleccionada) {
		mostrarComentariosPublicacionGenerico(publicacionSeleccionada, labelComentariosPublicacionVendedor4);
	}
	
	//Vendedor 5
	private void mostrarComentariosPublicacion5(Publicacion publicacionSeleccionada) {
		mostrarComentariosPublicacionGenerico(publicacionSeleccionada, labelComentariosPublicacionVendedor5);
	}
	
	//Vendedor 6
	private void mostrarComentariosPublicacion6(Publicacion publicacionSeleccionada) {
		mostrarComentariosPublicacionGenerico(publicacionSeleccionada, labelComentariosPublicacionVendedor6);
	}

	//Vendedor 7
	private void mostrarComentariosPublicacion7(Publicacion publicacionSeleccionada) {
		mostrarComentariosPublicacionGenerico(publicacionSeleccionada, labelComentariosPublicacionVendedor7);
	}

	//Vendedor 8
	private void mostrarComentariosPublicacion8(Publicacion publicacionSeleccionada) {
		mostrarComentariosPublicacionGenerico(publicacionSeleccionada, labelComentariosPublicacionVendedor8);
	}

	//Vendedor 9
	private void mostrarComentariosPublicacion9(Publicacion publicacionSeleccionada) {
		mostrarComentariosPublicacionGenerico(publicacionSeleccionada, labelComentariosPublicacionVendedor9);
	}

	//Vendedor 10
	private void mostrarComentariosPublicacion10(Publicacion publicacionSeleccionada) {
		mostrarComentariosPublicacionGenerico(publicacionSeleccionada, labelComentariosPublicacionVendedor10);
	}
	 
	
	//-------------------------------------------------------------INHABILITACION FUNCIONES----------------------------------------------------------------
	 
	 /**
	  * Metodo para inhabiliar las funciones de la GUI dependiendo de qué usuario entró
	  */
	 private void inhabilitarFunciones() {
		 String tipoUsuario = modelFactoryController.obtenerTipoUsuario(codigoUsuario);
		 SingleSelectionModel<Tab> selectionModel = tabPaneGeneral.getSelectionModel(); //Seleccion de tab
		 
		 if(tipoUsuario.equalsIgnoreCase("vendedor")){
			 int posicion = obtenerPosicion();
			 
			 if(posicion != -1){
				 inhabilitarParaVendedores(posicion);
				 
				 //Redirigimos al vendedor a su tab
				 selectionModel.select(posicion);
			 }
		 }
		 else{
			 if(tipoUsuario.equalsIgnoreCase("usuario")){
				 inhabilitarParaUsuarios();
				 selectionModel.select(1);
			 }
		 }
		 
	 }
	 
	 /**
	  * metodo el cual inhabilita las funciones para los vendedores
	  * @param posicion
	  */
	 private void inhabilitarParaVendedores(int posicion) {
		 inhabilitarTabAdmin();
		 
		 switch (posicion) {
		 case 1:
			 inhabilitarFuncionesParaVendedor1();
			 break;

		 case 2:
			 inhabilitarFuncionesParaVendedor2();
			 break;

		 case 3:
			 inhabilitarFuncionesParaVendedor3();
			 break;

		 case 4:
			 inhabilitarFuncionesParaVendedor4();
			 break;

		 case 5:
			 inhabilitarFuncionesParaVendedor5();
			 break;

		 case 6:
			 inhabilitarFuncionesParaVendedor6();
			 break;

		 case 7:
			 inhabilitarFuncionesParaVendedor7();
			 break;

		 case 8:
			 inhabilitarFuncionesParaVendedor8();
			 break;

		 case 9:
			 inhabilitarFuncionesParaVendedor9();
			 break;

		 case 10:
			 inhabilitarFuncionesParaVendedor10();
			 break;

		 default:
			 break;
		 }

	 }

	//Inhabilitacion botones para vendedor 1
	private void inhabilitarFuncionesParaVendedor1() {
		inhabilitarTabAdmin();
		btnAgregarProductoVendedor2.setDisable(true);
		btnPublicarProductoVendedor2.setDisable(true);
		btnActualizarProductoVendedor2.setDisable(true);
		btnEliminarProductoVendedor2.setDisable(true);
		btnActualizarPublicacionVendedor2.setDisable(true);
		btnEliminarPublicacionVendedor2.setDisable(true);
		btnEliminarContactoVendedor2.setDisable(true);
		btnAgregarContactoSugerido2.setDisable(true);
		btnAgregarContactoBusqueda2.setDisable(true);
		btnBuscarVendedor2.setDisable(true);
		
		btnAgregarProductoVendedor3.setDisable(true);
		btnPublicarProductoVendedor3.setDisable(true);
		btnActualizarProductoVendedor3.setDisable(true);
		btnEliminarProductoVendedor3.setDisable(true);
		btnActualizarPublicacionVendedor3.setDisable(true);
		btnEliminarPublicacionVendedor3.setDisable(true);
		btnEliminarContactoVendedor3.setDisable(true);
		btnAgregarContactoSugerido3.setDisable(true);
		btnAgregarContactoBusqueda3.setDisable(true);
		btnBuscarVendedor3.setDisable(true);
		
		btnAgregarProductoVendedor4.setDisable(true);
		btnPublicarProductoVendedor4.setDisable(true);
		btnActualizarProductoVendedor4.setDisable(true);
		btnEliminarProductoVendedor4.setDisable(true);
		btnActualizarPublicacionVendedor4.setDisable(true);
		btnEliminarPublicacionVendedor4.setDisable(true);
		btnEliminarContactoVendedor4.setDisable(true);
		btnAgregarContactoSugerido4.setDisable(true);
		btnAgregarContactoBusqueda4.setDisable(true);
		btnBuscarVendedor4.setDisable(true);
		
		btnAgregarProductoVendedor5.setDisable(true);
		btnPublicarProductoVendedor5.setDisable(true);
		btnActualizarProductoVendedor5.setDisable(true);
		btnEliminarProductoVendedor5.setDisable(true);
		btnActualizarPublicacionVendedor5.setDisable(true);
		btnEliminarPublicacionVendedor5.setDisable(true);
		btnEliminarContactoVendedor5.setDisable(true);
		btnAgregarContactoSugerido5.setDisable(true);
		btnAgregarContactoBusqueda5.setDisable(true);
		btnBuscarVendedor5.setDisable(true);
		
		btnAgregarProductoVendedor6.setDisable(true);
		btnPublicarProductoVendedor6.setDisable(true);
		btnActualizarProductoVendedor6.setDisable(true);
		btnEliminarProductoVendedor6.setDisable(true);
		btnActualizarPublicacionVendedor6.setDisable(true);
		btnEliminarPublicacionVendedor6.setDisable(true);
		btnEliminarContactoVendedor6.setDisable(true);
		btnAgregarContactoSugerido6.setDisable(true);
		btnAgregarContactoBusqueda6.setDisable(true);
		btnBuscarVendedor6.setDisable(true);
		
		btnAgregarProductoVendedor7.setDisable(true);
		btnPublicarProductoVendedor7.setDisable(true);
		btnActualizarProductoVendedor7.setDisable(true);
		btnEliminarProductoVendedor7.setDisable(true);
		btnActualizarPublicacionVendedor7.setDisable(true);
		btnEliminarPublicacionVendedor7.setDisable(true);
		btnEliminarContactoVendedor7.setDisable(true);
		btnAgregarContactoSugerido7.setDisable(true);
		btnAgregarContactoBusqueda7.setDisable(true);
		btnBuscarVendedor7.setDisable(true);
		
		btnAgregarProductoVendedor8.setDisable(true);
		btnPublicarProductoVendedor8.setDisable(true);
		btnActualizarProductoVendedor8.setDisable(true);
		btnEliminarProductoVendedor8.setDisable(true);
		btnActualizarPublicacionVendedor8.setDisable(true);
		btnEliminarPublicacionVendedor8.setDisable(true);
		btnEliminarContactoVendedor8.setDisable(true);
		btnAgregarContactoSugerido8.setDisable(true);
		btnAgregarContactoBusqueda8.setDisable(true);
		btnBuscarVendedor8.setDisable(true);
		
		btnAgregarProductoVendedor9.setDisable(true);
		btnPublicarProductoVendedor9.setDisable(true);
		btnActualizarProductoVendedor9.setDisable(true);
		btnEliminarProductoVendedor9.setDisable(true);
		btnActualizarPublicacionVendedor9.setDisable(true);
		btnEliminarPublicacionVendedor9.setDisable(true);
		btnEliminarContactoVendedor9.setDisable(true);
		btnAgregarContactoSugerido9.setDisable(true);
		btnAgregarContactoBusqueda9.setDisable(true);
		btnBuscarVendedor9.setDisable(true);
		
		btnAgregarProductoVendedor10.setDisable(true);
		btnPublicarProductoVendedor10.setDisable(true);
		btnActualizarProductoVendedor10.setDisable(true);
		btnEliminarProductoVendedor10.setDisable(true);
		btnActualizarPublicacionVendedor10.setDisable(true);
		btnEliminarPublicacionVendedor10.setDisable(true);
		btnEliminarContactoVendedor10.setDisable(true);
		btnAgregarContactoSugerido10.setDisable(true);
		btnAgregarContactoBusqueda10.setDisable(true);
		btnBuscarVendedor10.setDisable(true);
		
	}
	
	//Inhabilitacion botones para vendedor 2
	private void inhabilitarFuncionesParaVendedor2() {
		inhabilitarTabAdmin();
		btnAgregarProductoVendedor1.setDisable(true);
		btnPublicarProductoVendedor1.setDisable(true);
		btnActualizarProductoVendedor1.setDisable(true);
		btnEliminarProductoVendedor1.setDisable(true);
		btnActualizarPublicacionVendedor1.setDisable(true);
		btnEliminarPublicacionVendedor1.setDisable(true);
		btnEliminarContactoVendedor1.setDisable(true);
		btnAgregarContactoSugerido1.setDisable(true);
		btnAgregarContactoBusqueda1.setDisable(true);
		btnBuscarVendedor1.setDisable(true);
		
		btnAgregarProductoVendedor3.setDisable(true);
		btnPublicarProductoVendedor3.setDisable(true);
		btnActualizarProductoVendedor3.setDisable(true);
		btnEliminarProductoVendedor3.setDisable(true);
		btnActualizarPublicacionVendedor3.setDisable(true);
		btnEliminarPublicacionVendedor3.setDisable(true);
		btnEliminarContactoVendedor3.setDisable(true);
		btnAgregarContactoSugerido3.setDisable(true);
		btnAgregarContactoBusqueda3.setDisable(true);
		btnBuscarVendedor3.setDisable(true);
		
		btnAgregarProductoVendedor4.setDisable(true);
		btnPublicarProductoVendedor4.setDisable(true);
		btnActualizarProductoVendedor4.setDisable(true);
		btnEliminarProductoVendedor4.setDisable(true);
		btnActualizarPublicacionVendedor4.setDisable(true);
		btnEliminarPublicacionVendedor4.setDisable(true);
		btnEliminarContactoVendedor4.setDisable(true);
		btnAgregarContactoSugerido4.setDisable(true);
		btnAgregarContactoBusqueda4.setDisable(true);
		btnBuscarVendedor4.setDisable(true);
		
		btnAgregarProductoVendedor5.setDisable(true);
		btnPublicarProductoVendedor5.setDisable(true);
		btnActualizarProductoVendedor5.setDisable(true);
		btnEliminarProductoVendedor5.setDisable(true);
		btnActualizarPublicacionVendedor5.setDisable(true);
		btnEliminarPublicacionVendedor5.setDisable(true);
		btnEliminarContactoVendedor5.setDisable(true);
		btnAgregarContactoSugerido5.setDisable(true);
		btnAgregarContactoBusqueda5.setDisable(true);
		btnBuscarVendedor5.setDisable(true);
		
		btnAgregarProductoVendedor6.setDisable(true);
		btnPublicarProductoVendedor6.setDisable(true);
		btnActualizarProductoVendedor6.setDisable(true);
		btnEliminarProductoVendedor6.setDisable(true);
		btnActualizarPublicacionVendedor6.setDisable(true);
		btnEliminarPublicacionVendedor6.setDisable(true);
		btnEliminarContactoVendedor6.setDisable(true);
		btnAgregarContactoSugerido6.setDisable(true);
		btnAgregarContactoBusqueda6.setDisable(true);
		btnBuscarVendedor6.setDisable(true);
		
		btnAgregarProductoVendedor7.setDisable(true);
		btnPublicarProductoVendedor7.setDisable(true);
		btnActualizarProductoVendedor7.setDisable(true);
		btnEliminarProductoVendedor7.setDisable(true);
		btnActualizarPublicacionVendedor7.setDisable(true);
		btnEliminarPublicacionVendedor7.setDisable(true);
		btnEliminarContactoVendedor7.setDisable(true);
		btnAgregarContactoSugerido7.setDisable(true);
		btnAgregarContactoBusqueda7.setDisable(true);
		btnBuscarVendedor7.setDisable(true);
		
		btnAgregarProductoVendedor8.setDisable(true);
		btnPublicarProductoVendedor8.setDisable(true);
		btnActualizarProductoVendedor8.setDisable(true);
		btnEliminarProductoVendedor8.setDisable(true);
		btnActualizarPublicacionVendedor8.setDisable(true);
		btnEliminarPublicacionVendedor8.setDisable(true);
		btnEliminarContactoVendedor8.setDisable(true);
		btnAgregarContactoSugerido8.setDisable(true);
		btnAgregarContactoBusqueda8.setDisable(true);
		btnBuscarVendedor8.setDisable(true);
		
		btnAgregarProductoVendedor9.setDisable(true);
		btnPublicarProductoVendedor9.setDisable(true);
		btnActualizarProductoVendedor9.setDisable(true);
		btnEliminarProductoVendedor9.setDisable(true);
		btnActualizarPublicacionVendedor9.setDisable(true);
		btnEliminarPublicacionVendedor9.setDisable(true);
		btnEliminarContactoVendedor9.setDisable(true);
		btnAgregarContactoSugerido9.setDisable(true);
		btnAgregarContactoBusqueda9.setDisable(true);
		btnBuscarVendedor9.setDisable(true);
		
		btnAgregarProductoVendedor10.setDisable(true);
		btnPublicarProductoVendedor10.setDisable(true);
		btnActualizarProductoVendedor10.setDisable(true);
		btnEliminarProductoVendedor10.setDisable(true);
		btnActualizarPublicacionVendedor10.setDisable(true);
		btnEliminarPublicacionVendedor10.setDisable(true);
		btnEliminarContactoVendedor10.setDisable(true);
		btnAgregarContactoSugerido10.setDisable(true);
		btnAgregarContactoBusqueda10.setDisable(true);
		btnBuscarVendedor10.setDisable(true);
	}
	
	//Inhabilitacion botones para vendedor 3
	private void inhabilitarFuncionesParaVendedor3() {
		inhabilitarTabAdmin();
		btnAgregarProductoVendedor1.setDisable(true);
		btnPublicarProductoVendedor1.setDisable(true);
		btnActualizarProductoVendedor1.setDisable(true);
		btnEliminarProductoVendedor1.setDisable(true);
		btnActualizarPublicacionVendedor1.setDisable(true);
		btnEliminarPublicacionVendedor1.setDisable(true);
		btnEliminarContactoVendedor1.setDisable(true);
		btnAgregarContactoSugerido1.setDisable(true);
		btnAgregarContactoBusqueda1.setDisable(true);
		btnBuscarVendedor1.setDisable(true);
		
		btnAgregarProductoVendedor2.setDisable(true);
		btnPublicarProductoVendedor2.setDisable(true);
		btnActualizarProductoVendedor2.setDisable(true);
		btnEliminarProductoVendedor2.setDisable(true);
		btnActualizarPublicacionVendedor2.setDisable(true);
		btnEliminarPublicacionVendedor2.setDisable(true);
		btnEliminarContactoVendedor2.setDisable(true);
		btnAgregarContactoSugerido2.setDisable(true);
		btnAgregarContactoBusqueda2.setDisable(true);
		btnBuscarVendedor2.setDisable(true);
		
		btnAgregarProductoVendedor4.setDisable(true);
		btnPublicarProductoVendedor4.setDisable(true);
		btnActualizarProductoVendedor4.setDisable(true);
		btnEliminarProductoVendedor4.setDisable(true);
		btnActualizarPublicacionVendedor4.setDisable(true);
		btnEliminarPublicacionVendedor4.setDisable(true);
		btnEliminarContactoVendedor4.setDisable(true);
		btnAgregarContactoSugerido4.setDisable(true);
		btnAgregarContactoBusqueda4.setDisable(true);
		btnBuscarVendedor4.setDisable(true);
		
		btnAgregarProductoVendedor5.setDisable(true);
		btnPublicarProductoVendedor5.setDisable(true);
		btnActualizarProductoVendedor5.setDisable(true);
		btnEliminarProductoVendedor5.setDisable(true);
		btnActualizarPublicacionVendedor5.setDisable(true);
		btnEliminarPublicacionVendedor5.setDisable(true);
		btnEliminarContactoVendedor5.setDisable(true);
		btnAgregarContactoSugerido5.setDisable(true);
		btnAgregarContactoBusqueda5.setDisable(true);
		btnBuscarVendedor5.setDisable(true);
		
		btnAgregarProductoVendedor6.setDisable(true);
		btnPublicarProductoVendedor6.setDisable(true);
		btnActualizarProductoVendedor6.setDisable(true);
		btnEliminarProductoVendedor6.setDisable(true);
		btnActualizarPublicacionVendedor6.setDisable(true);
		btnEliminarPublicacionVendedor6.setDisable(true);
		btnEliminarContactoVendedor6.setDisable(true);
		btnAgregarContactoSugerido6.setDisable(true);
		btnAgregarContactoBusqueda6.setDisable(true);
		btnBuscarVendedor6.setDisable(true);
		
		btnAgregarProductoVendedor7.setDisable(true);
		btnPublicarProductoVendedor7.setDisable(true);
		btnActualizarProductoVendedor7.setDisable(true);
		btnEliminarProductoVendedor7.setDisable(true);
		btnActualizarPublicacionVendedor7.setDisable(true);
		btnEliminarPublicacionVendedor7.setDisable(true);
		btnEliminarContactoVendedor7.setDisable(true);
		btnAgregarContactoSugerido7.setDisable(true);
		btnAgregarContactoBusqueda7.setDisable(true);
		btnBuscarVendedor7.setDisable(true);
		
		btnAgregarProductoVendedor8.setDisable(true);
		btnPublicarProductoVendedor8.setDisable(true);
		btnActualizarProductoVendedor8.setDisable(true);
		btnEliminarProductoVendedor8.setDisable(true);
		btnActualizarPublicacionVendedor8.setDisable(true);
		btnEliminarPublicacionVendedor8.setDisable(true);
		btnEliminarContactoVendedor8.setDisable(true);
		btnAgregarContactoSugerido8.setDisable(true);
		btnAgregarContactoBusqueda8.setDisable(true);
		btnBuscarVendedor8.setDisable(true);
		
		btnAgregarProductoVendedor9.setDisable(true);
		btnPublicarProductoVendedor9.setDisable(true);
		btnActualizarProductoVendedor9.setDisable(true);
		btnEliminarProductoVendedor9.setDisable(true);
		btnActualizarPublicacionVendedor9.setDisable(true);
		btnEliminarPublicacionVendedor9.setDisable(true);
		btnEliminarContactoVendedor9.setDisable(true);
		btnAgregarContactoSugerido9.setDisable(true);
		btnAgregarContactoBusqueda9.setDisable(true);
		btnBuscarVendedor9.setDisable(true);
		
		btnAgregarProductoVendedor10.setDisable(true);
		btnPublicarProductoVendedor10.setDisable(true);
		btnActualizarProductoVendedor10.setDisable(true);
		btnEliminarProductoVendedor10.setDisable(true);
		btnActualizarPublicacionVendedor10.setDisable(true);
		btnEliminarPublicacionVendedor10.setDisable(true);
		btnEliminarContactoVendedor10.setDisable(true);
		btnAgregarContactoSugerido10.setDisable(true);
		btnAgregarContactoBusqueda10.setDisable(true);
		btnBuscarVendedor10.setDisable(true);
	}

	//Inhabilitacion botones para vendedor 4
	private void inhabilitarFuncionesParaVendedor4() {
		inhabilitarTabAdmin();
		btnAgregarProductoVendedor1.setDisable(true);
		btnPublicarProductoVendedor1.setDisable(true);
		btnActualizarProductoVendedor1.setDisable(true);
		btnEliminarProductoVendedor1.setDisable(true);
		btnActualizarPublicacionVendedor1.setDisable(true);
		btnEliminarPublicacionVendedor1.setDisable(true);
		btnEliminarContactoVendedor1.setDisable(true);
		btnAgregarContactoSugerido1.setDisable(true);
		btnAgregarContactoBusqueda1.setDisable(true);
		btnBuscarVendedor1.setDisable(true);
		
		btnAgregarProductoVendedor2.setDisable(true);
		btnPublicarProductoVendedor2.setDisable(true);
		btnActualizarProductoVendedor2.setDisable(true);
		btnEliminarProductoVendedor2.setDisable(true);
		btnActualizarPublicacionVendedor2.setDisable(true);
		btnEliminarPublicacionVendedor2.setDisable(true);
		btnEliminarContactoVendedor2.setDisable(true);
		btnAgregarContactoSugerido2.setDisable(true);
		btnAgregarContactoBusqueda2.setDisable(true);
		btnBuscarVendedor2.setDisable(true);
		
		btnAgregarProductoVendedor3.setDisable(true);
		btnPublicarProductoVendedor3.setDisable(true);
		btnActualizarProductoVendedor3.setDisable(true);
		btnEliminarProductoVendedor3.setDisable(true);
		btnActualizarPublicacionVendedor3.setDisable(true);
		btnEliminarPublicacionVendedor3.setDisable(true);
		btnEliminarContactoVendedor3.setDisable(true);
		btnAgregarContactoSugerido3.setDisable(true);
		btnAgregarContactoBusqueda3.setDisable(true);
		btnBuscarVendedor3.setDisable(true);
		
		btnAgregarProductoVendedor5.setDisable(true);
		btnPublicarProductoVendedor5.setDisable(true);
		btnActualizarProductoVendedor5.setDisable(true);
		btnEliminarProductoVendedor5.setDisable(true);
		btnActualizarPublicacionVendedor5.setDisable(true);
		btnEliminarPublicacionVendedor5.setDisable(true);
		btnEliminarContactoVendedor5.setDisable(true);
		btnAgregarContactoSugerido5.setDisable(true);
		btnAgregarContactoBusqueda5.setDisable(true);
		btnBuscarVendedor5.setDisable(true);
		
		btnAgregarProductoVendedor6.setDisable(true);
		btnPublicarProductoVendedor6.setDisable(true);
		btnActualizarProductoVendedor6.setDisable(true);
		btnEliminarProductoVendedor6.setDisable(true);
		btnActualizarPublicacionVendedor6.setDisable(true);
		btnEliminarPublicacionVendedor6.setDisable(true);
		btnEliminarContactoVendedor6.setDisable(true);
		btnAgregarContactoSugerido6.setDisable(true);
		btnAgregarContactoBusqueda6.setDisable(true);
		btnBuscarVendedor6.setDisable(true);
		
		btnAgregarProductoVendedor7.setDisable(true);
		btnPublicarProductoVendedor7.setDisable(true);
		btnActualizarProductoVendedor7.setDisable(true);
		btnEliminarProductoVendedor7.setDisable(true);
		btnActualizarPublicacionVendedor7.setDisable(true);
		btnEliminarPublicacionVendedor7.setDisable(true);
		btnEliminarContactoVendedor7.setDisable(true);
		btnAgregarContactoSugerido7.setDisable(true);
		btnAgregarContactoBusqueda7.setDisable(true);
		btnBuscarVendedor7.setDisable(true);
		
		btnAgregarProductoVendedor8.setDisable(true);
		btnPublicarProductoVendedor8.setDisable(true);
		btnActualizarProductoVendedor8.setDisable(true);
		btnEliminarProductoVendedor8.setDisable(true);
		btnActualizarPublicacionVendedor8.setDisable(true);
		btnEliminarPublicacionVendedor8.setDisable(true);
		btnEliminarContactoVendedor8.setDisable(true);
		btnAgregarContactoSugerido8.setDisable(true);
		btnAgregarContactoBusqueda8.setDisable(true);
		btnBuscarVendedor8.setDisable(true);
		
		btnAgregarProductoVendedor9.setDisable(true);
		btnPublicarProductoVendedor9.setDisable(true);
		btnActualizarProductoVendedor9.setDisable(true);
		btnEliminarProductoVendedor9.setDisable(true);
		btnActualizarPublicacionVendedor9.setDisable(true);
		btnEliminarPublicacionVendedor9.setDisable(true);
		btnEliminarContactoVendedor9.setDisable(true);
		btnAgregarContactoSugerido9.setDisable(true);
		btnAgregarContactoBusqueda9.setDisable(true);
		btnBuscarVendedor9.setDisable(true);
		
		btnAgregarProductoVendedor10.setDisable(true);
		btnPublicarProductoVendedor10.setDisable(true);
		btnActualizarProductoVendedor10.setDisable(true);
		btnEliminarProductoVendedor10.setDisable(true);
		btnActualizarPublicacionVendedor10.setDisable(true);
		btnEliminarPublicacionVendedor10.setDisable(true);
		btnEliminarContactoVendedor10.setDisable(true);
		btnAgregarContactoSugerido10.setDisable(true);
		btnAgregarContactoBusqueda10.setDisable(true);
		btnBuscarVendedor10.setDisable(true);
	}
	
	//Inhabilitacion botones para vendedor 5
	private void inhabilitarFuncionesParaVendedor5() {
		inhabilitarTabAdmin();
		btnAgregarProductoVendedor1.setDisable(true);
		btnPublicarProductoVendedor1.setDisable(true);
		btnActualizarProductoVendedor1.setDisable(true);
		btnEliminarProductoVendedor1.setDisable(true);
		btnActualizarPublicacionVendedor1.setDisable(true);
		btnEliminarPublicacionVendedor1.setDisable(true);
		btnEliminarContactoVendedor1.setDisable(true);
		btnAgregarContactoSugerido1.setDisable(true);
		btnAgregarContactoBusqueda1.setDisable(true);
		btnBuscarVendedor1.setDisable(true);
		
		btnAgregarProductoVendedor2.setDisable(true);
		btnPublicarProductoVendedor2.setDisable(true);
		btnActualizarProductoVendedor2.setDisable(true);
		btnEliminarProductoVendedor2.setDisable(true);
		btnActualizarPublicacionVendedor2.setDisable(true);
		btnEliminarPublicacionVendedor2.setDisable(true);
		btnEliminarContactoVendedor2.setDisable(true);
		btnAgregarContactoSugerido2.setDisable(true);
		btnAgregarContactoBusqueda2.setDisable(true);
		btnBuscarVendedor2.setDisable(true);
		
		btnAgregarProductoVendedor3.setDisable(true);
		btnPublicarProductoVendedor3.setDisable(true);
		btnActualizarProductoVendedor3.setDisable(true);
		btnEliminarProductoVendedor3.setDisable(true);
		btnActualizarPublicacionVendedor3.setDisable(true);
		btnEliminarPublicacionVendedor3.setDisable(true);
		btnEliminarContactoVendedor3.setDisable(true);
		btnAgregarContactoSugerido3.setDisable(true);
		btnAgregarContactoBusqueda3.setDisable(true);
		btnBuscarVendedor3.setDisable(true);
		
		btnAgregarProductoVendedor4.setDisable(true);
		btnPublicarProductoVendedor4.setDisable(true);
		btnActualizarProductoVendedor4.setDisable(true);
		btnEliminarProductoVendedor4.setDisable(true);
		btnActualizarPublicacionVendedor4.setDisable(true);
		btnEliminarPublicacionVendedor4.setDisable(true);
		btnEliminarContactoVendedor4.setDisable(true);
		btnAgregarContactoSugerido4.setDisable(true);
		btnAgregarContactoBusqueda4.setDisable(true);
		btnBuscarVendedor4.setDisable(true);
		
		btnAgregarProductoVendedor6.setDisable(true);
		btnPublicarProductoVendedor6.setDisable(true);
		btnActualizarProductoVendedor6.setDisable(true);
		btnEliminarProductoVendedor6.setDisable(true);
		btnActualizarPublicacionVendedor6.setDisable(true);
		btnEliminarPublicacionVendedor6.setDisable(true);
		btnEliminarContactoVendedor6.setDisable(true);
		btnAgregarContactoSugerido6.setDisable(true);
		btnAgregarContactoBusqueda6.setDisable(true);
		btnBuscarVendedor6.setDisable(true);
		
		btnAgregarProductoVendedor7.setDisable(true);
		btnPublicarProductoVendedor7.setDisable(true);
		btnActualizarProductoVendedor7.setDisable(true);
		btnEliminarProductoVendedor7.setDisable(true);
		btnActualizarPublicacionVendedor7.setDisable(true);
		btnEliminarPublicacionVendedor7.setDisable(true);
		btnEliminarContactoVendedor7.setDisable(true);
		btnAgregarContactoSugerido7.setDisable(true);
		btnAgregarContactoBusqueda7.setDisable(true);
		btnBuscarVendedor7.setDisable(true);
		
		btnAgregarProductoVendedor8.setDisable(true);
		btnPublicarProductoVendedor8.setDisable(true);
		btnActualizarProductoVendedor8.setDisable(true);
		btnEliminarProductoVendedor8.setDisable(true);
		btnActualizarPublicacionVendedor8.setDisable(true);
		btnEliminarPublicacionVendedor8.setDisable(true);
		btnEliminarContactoVendedor8.setDisable(true);
		btnAgregarContactoSugerido8.setDisable(true);
		btnAgregarContactoBusqueda8.setDisable(true);
		btnBuscarVendedor8.setDisable(true);
		
		btnAgregarProductoVendedor9.setDisable(true);
		btnPublicarProductoVendedor9.setDisable(true);
		btnActualizarProductoVendedor9.setDisable(true);
		btnEliminarProductoVendedor9.setDisable(true);
		btnActualizarPublicacionVendedor9.setDisable(true);
		btnEliminarPublicacionVendedor9.setDisable(true);
		btnEliminarContactoVendedor9.setDisable(true);
		btnAgregarContactoSugerido9.setDisable(true);
		btnAgregarContactoBusqueda9.setDisable(true);
		btnBuscarVendedor9.setDisable(true);
		
		btnAgregarProductoVendedor10.setDisable(true);
		btnPublicarProductoVendedor10.setDisable(true);
		btnActualizarProductoVendedor10.setDisable(true);
		btnEliminarProductoVendedor10.setDisable(true);
		btnActualizarPublicacionVendedor10.setDisable(true);
		btnEliminarPublicacionVendedor10.setDisable(true);
		btnEliminarContactoVendedor10.setDisable(true);
		btnAgregarContactoSugerido10.setDisable(true);
		btnAgregarContactoBusqueda10.setDisable(true);
		btnBuscarVendedor10.setDisable(true);
	}
	
	//Inhabilitacion botones para vendedor 6
	private void inhabilitarFuncionesParaVendedor6() {
		inhabilitarTabAdmin();
		btnAgregarProductoVendedor1.setDisable(true);
		btnPublicarProductoVendedor1.setDisable(true);
		btnActualizarProductoVendedor1.setDisable(true);
		btnEliminarProductoVendedor1.setDisable(true);
		btnActualizarPublicacionVendedor1.setDisable(true);
		btnEliminarPublicacionVendedor1.setDisable(true);
		btnEliminarContactoVendedor1.setDisable(true);
		btnAgregarContactoSugerido1.setDisable(true);
		btnAgregarContactoBusqueda1.setDisable(true);
		btnBuscarVendedor1.setDisable(true);
		
		btnAgregarProductoVendedor2.setDisable(true);
		btnPublicarProductoVendedor2.setDisable(true);
		btnActualizarProductoVendedor2.setDisable(true);
		btnEliminarProductoVendedor2.setDisable(true);
		btnActualizarPublicacionVendedor2.setDisable(true);
		btnEliminarPublicacionVendedor2.setDisable(true);
		btnEliminarContactoVendedor2.setDisable(true);
		btnAgregarContactoSugerido2.setDisable(true);
		btnAgregarContactoBusqueda2.setDisable(true);
		btnBuscarVendedor2.setDisable(true);
		
		btnAgregarProductoVendedor3.setDisable(true);
		btnPublicarProductoVendedor3.setDisable(true);
		btnActualizarProductoVendedor3.setDisable(true);
		btnEliminarProductoVendedor3.setDisable(true);
		btnActualizarPublicacionVendedor3.setDisable(true);
		btnEliminarPublicacionVendedor3.setDisable(true);
		btnEliminarContactoVendedor3.setDisable(true);
		btnAgregarContactoSugerido3.setDisable(true);
		btnAgregarContactoBusqueda3.setDisable(true);
		btnBuscarVendedor3.setDisable(true);
		
		btnAgregarProductoVendedor4.setDisable(true);
		btnPublicarProductoVendedor4.setDisable(true);
		btnActualizarProductoVendedor4.setDisable(true);
		btnEliminarProductoVendedor4.setDisable(true);
		btnActualizarPublicacionVendedor4.setDisable(true);
		btnEliminarPublicacionVendedor4.setDisable(true);
		btnEliminarContactoVendedor4.setDisable(true);
		btnAgregarContactoSugerido4.setDisable(true);
		btnAgregarContactoBusqueda4.setDisable(true);
		btnBuscarVendedor4.setDisable(true);
		
		btnAgregarProductoVendedor5.setDisable(true);
		btnPublicarProductoVendedor5.setDisable(true);
		btnActualizarProductoVendedor5.setDisable(true);
		btnEliminarProductoVendedor5.setDisable(true);
		btnActualizarPublicacionVendedor5.setDisable(true);
		btnEliminarPublicacionVendedor5.setDisable(true);
		btnEliminarContactoVendedor5.setDisable(true);
		btnAgregarContactoSugerido5.setDisable(true);
		btnAgregarContactoBusqueda5.setDisable(true);
		btnBuscarVendedor5.setDisable(true);
		
		btnAgregarProductoVendedor7.setDisable(true);
		btnPublicarProductoVendedor7.setDisable(true);
		btnActualizarProductoVendedor7.setDisable(true);
		btnEliminarProductoVendedor7.setDisable(true);
		btnActualizarPublicacionVendedor7.setDisable(true);
		btnEliminarPublicacionVendedor7.setDisable(true);
		btnEliminarContactoVendedor7.setDisable(true);
		btnAgregarContactoSugerido7.setDisable(true);
		btnAgregarContactoBusqueda7.setDisable(true);
		btnBuscarVendedor7.setDisable(true);
		
		btnAgregarProductoVendedor8.setDisable(true);
		btnPublicarProductoVendedor8.setDisable(true);
		btnActualizarProductoVendedor8.setDisable(true);
		btnEliminarProductoVendedor8.setDisable(true);
		btnActualizarPublicacionVendedor8.setDisable(true);
		btnEliminarPublicacionVendedor8.setDisable(true);
		btnEliminarContactoVendedor8.setDisable(true);
		btnAgregarContactoSugerido8.setDisable(true);
		btnAgregarContactoBusqueda8.setDisable(true);
		btnBuscarVendedor8.setDisable(true);
		
		btnAgregarProductoVendedor9.setDisable(true);
		btnPublicarProductoVendedor9.setDisable(true);
		btnActualizarProductoVendedor9.setDisable(true);
		btnEliminarProductoVendedor9.setDisable(true);
		btnActualizarPublicacionVendedor9.setDisable(true);
		btnEliminarPublicacionVendedor9.setDisable(true);
		btnEliminarContactoVendedor9.setDisable(true);
		btnAgregarContactoSugerido9.setDisable(true);
		btnAgregarContactoBusqueda9.setDisable(true);
		btnBuscarVendedor9.setDisable(true);
		
		btnAgregarProductoVendedor10.setDisable(true);
		btnPublicarProductoVendedor10.setDisable(true);
		btnActualizarProductoVendedor10.setDisable(true);
		btnEliminarProductoVendedor10.setDisable(true);
		btnActualizarPublicacionVendedor10.setDisable(true);
		btnEliminarPublicacionVendedor10.setDisable(true);
		btnEliminarContactoVendedor10.setDisable(true);
		btnAgregarContactoSugerido10.setDisable(true);
		btnAgregarContactoBusqueda10.setDisable(true);
		btnBuscarVendedor10.setDisable(true);
	}

	//Inhabilitacion botones para vendedor 7
	private void inhabilitarFuncionesParaVendedor7() {
		inhabilitarTabAdmin();
		btnAgregarProductoVendedor1.setDisable(true);
		btnPublicarProductoVendedor1.setDisable(true);
		btnActualizarProductoVendedor1.setDisable(true);
		btnEliminarProductoVendedor1.setDisable(true);
		btnActualizarPublicacionVendedor1.setDisable(true);
		btnEliminarPublicacionVendedor1.setDisable(true);
		btnEliminarContactoVendedor1.setDisable(true);
		btnAgregarContactoSugerido1.setDisable(true);
		btnAgregarContactoBusqueda1.setDisable(true);
		btnBuscarVendedor1.setDisable(true);
		
		btnAgregarProductoVendedor2.setDisable(true);
		btnPublicarProductoVendedor2.setDisable(true);
		btnActualizarProductoVendedor2.setDisable(true);
		btnEliminarProductoVendedor2.setDisable(true);
		btnActualizarPublicacionVendedor2.setDisable(true);
		btnEliminarPublicacionVendedor2.setDisable(true);
		btnEliminarContactoVendedor2.setDisable(true);
		btnAgregarContactoSugerido2.setDisable(true);
		btnAgregarContactoBusqueda2.setDisable(true);
		btnBuscarVendedor2.setDisable(true);
		
		btnAgregarProductoVendedor3.setDisable(true);
		btnPublicarProductoVendedor3.setDisable(true);
		btnActualizarProductoVendedor3.setDisable(true);
		btnEliminarProductoVendedor3.setDisable(true);
		btnActualizarPublicacionVendedor3.setDisable(true);
		btnEliminarPublicacionVendedor3.setDisable(true);
		btnEliminarContactoVendedor3.setDisable(true);
		btnAgregarContactoSugerido3.setDisable(true);
		btnAgregarContactoBusqueda3.setDisable(true);
		btnBuscarVendedor3.setDisable(true);
		
		btnAgregarProductoVendedor4.setDisable(true);
		btnPublicarProductoVendedor4.setDisable(true);
		btnActualizarProductoVendedor4.setDisable(true);
		btnEliminarProductoVendedor4.setDisable(true);
		btnActualizarPublicacionVendedor4.setDisable(true);
		btnEliminarPublicacionVendedor4.setDisable(true);
		btnEliminarContactoVendedor4.setDisable(true);
		btnAgregarContactoSugerido4.setDisable(true);
		btnAgregarContactoBusqueda4.setDisable(true);
		btnBuscarVendedor4.setDisable(true);
		
		btnAgregarProductoVendedor5.setDisable(true);
		btnPublicarProductoVendedor5.setDisable(true);
		btnActualizarProductoVendedor5.setDisable(true);
		btnEliminarProductoVendedor5.setDisable(true);
		btnActualizarPublicacionVendedor5.setDisable(true);
		btnEliminarPublicacionVendedor5.setDisable(true);
		btnEliminarContactoVendedor5.setDisable(true);
		btnAgregarContactoSugerido5.setDisable(true);
		btnAgregarContactoBusqueda5.setDisable(true);
		btnBuscarVendedor5.setDisable(true);
		
		btnAgregarProductoVendedor6.setDisable(true);
		btnPublicarProductoVendedor6.setDisable(true);
		btnActualizarProductoVendedor6.setDisable(true);
		btnEliminarProductoVendedor6.setDisable(true);
		btnActualizarPublicacionVendedor6.setDisable(true);
		btnEliminarPublicacionVendedor6.setDisable(true);
		btnEliminarContactoVendedor6.setDisable(true);
		btnAgregarContactoSugerido6.setDisable(true);
		btnAgregarContactoBusqueda6.setDisable(true);
		btnBuscarVendedor6.setDisable(true);
		
		btnAgregarProductoVendedor8.setDisable(true);
		btnPublicarProductoVendedor8.setDisable(true);
		btnActualizarProductoVendedor8.setDisable(true);
		btnEliminarProductoVendedor8.setDisable(true);
		btnActualizarPublicacionVendedor8.setDisable(true);
		btnEliminarPublicacionVendedor8.setDisable(true);
		btnEliminarContactoVendedor8.setDisable(true);
		btnAgregarContactoSugerido8.setDisable(true);
		btnAgregarContactoBusqueda8.setDisable(true);
		btnBuscarVendedor8.setDisable(true);
		
		btnAgregarProductoVendedor9.setDisable(true);
		btnPublicarProductoVendedor9.setDisable(true);
		btnActualizarProductoVendedor9.setDisable(true);
		btnEliminarProductoVendedor9.setDisable(true);
		btnActualizarPublicacionVendedor9.setDisable(true);
		btnEliminarPublicacionVendedor9.setDisable(true);
		btnEliminarContactoVendedor9.setDisable(true);
		btnAgregarContactoSugerido9.setDisable(true);
		btnAgregarContactoBusqueda9.setDisable(true);
		btnBuscarVendedor9.setDisable(true);
		
		btnAgregarProductoVendedor10.setDisable(true);
		btnPublicarProductoVendedor10.setDisable(true);
		btnActualizarProductoVendedor10.setDisable(true);
		btnEliminarProductoVendedor10.setDisable(true);
		btnActualizarPublicacionVendedor10.setDisable(true);
		btnEliminarPublicacionVendedor10.setDisable(true);
		btnEliminarContactoVendedor10.setDisable(true);
		btnAgregarContactoSugerido10.setDisable(true);
		btnAgregarContactoBusqueda10.setDisable(true);
		btnBuscarVendedor10.setDisable(true);
	}

	//Inhabilitacion botones para vendedor 8
	private void inhabilitarFuncionesParaVendedor8() {
		inhabilitarTabAdmin();
		btnAgregarProductoVendedor1.setDisable(true);
		btnPublicarProductoVendedor1.setDisable(true);
		btnActualizarProductoVendedor1.setDisable(true);
		btnEliminarProductoVendedor1.setDisable(true);
		btnActualizarPublicacionVendedor1.setDisable(true);
		btnEliminarPublicacionVendedor1.setDisable(true);
		btnEliminarContactoVendedor1.setDisable(true);
		btnAgregarContactoSugerido1.setDisable(true);
		btnAgregarContactoBusqueda1.setDisable(true);
		btnBuscarVendedor1.setDisable(true);
		
		btnAgregarProductoVendedor2.setDisable(true);
		btnPublicarProductoVendedor2.setDisable(true);
		btnActualizarProductoVendedor2.setDisable(true);
		btnEliminarProductoVendedor2.setDisable(true);
		btnActualizarPublicacionVendedor2.setDisable(true);
		btnEliminarPublicacionVendedor2.setDisable(true);
		btnEliminarContactoVendedor2.setDisable(true);
		btnAgregarContactoSugerido2.setDisable(true);
		btnAgregarContactoBusqueda2.setDisable(true);
		btnBuscarVendedor2.setDisable(true);
		
		btnAgregarProductoVendedor3.setDisable(true);
		btnPublicarProductoVendedor3.setDisable(true);
		btnActualizarProductoVendedor3.setDisable(true);
		btnEliminarProductoVendedor3.setDisable(true);
		btnActualizarPublicacionVendedor3.setDisable(true);
		btnEliminarPublicacionVendedor3.setDisable(true);
		btnEliminarContactoVendedor3.setDisable(true);
		btnAgregarContactoSugerido3.setDisable(true);
		btnAgregarContactoBusqueda3.setDisable(true);
		btnBuscarVendedor3.setDisable(true);
		
		btnAgregarProductoVendedor4.setDisable(true);
		btnPublicarProductoVendedor4.setDisable(true);
		btnActualizarProductoVendedor4.setDisable(true);
		btnEliminarProductoVendedor4.setDisable(true);
		btnActualizarPublicacionVendedor4.setDisable(true);
		btnEliminarPublicacionVendedor4.setDisable(true);
		btnEliminarContactoVendedor4.setDisable(true);
		btnAgregarContactoSugerido4.setDisable(true);
		btnAgregarContactoBusqueda4.setDisable(true);
		btnBuscarVendedor4.setDisable(true);
		
		btnAgregarProductoVendedor5.setDisable(true);
		btnPublicarProductoVendedor5.setDisable(true);
		btnActualizarProductoVendedor5.setDisable(true);
		btnEliminarProductoVendedor5.setDisable(true);
		btnActualizarPublicacionVendedor5.setDisable(true);
		btnEliminarPublicacionVendedor5.setDisable(true);
		btnEliminarContactoVendedor5.setDisable(true);
		btnAgregarContactoSugerido5.setDisable(true);
		btnAgregarContactoBusqueda5.setDisable(true);
		btnBuscarVendedor5.setDisable(true);
		
		btnAgregarProductoVendedor6.setDisable(true);
		btnPublicarProductoVendedor6.setDisable(true);
		btnActualizarProductoVendedor6.setDisable(true);
		btnEliminarProductoVendedor6.setDisable(true);
		btnActualizarPublicacionVendedor6.setDisable(true);
		btnEliminarPublicacionVendedor6.setDisable(true);
		btnEliminarContactoVendedor6.setDisable(true);
		btnAgregarContactoSugerido6.setDisable(true);
		btnAgregarContactoBusqueda6.setDisable(true);
		btnBuscarVendedor6.setDisable(true);
		
		btnAgregarProductoVendedor7.setDisable(true);
		btnPublicarProductoVendedor7.setDisable(true);
		btnActualizarProductoVendedor7.setDisable(true);
		btnEliminarProductoVendedor7.setDisable(true);
		btnActualizarPublicacionVendedor7.setDisable(true);
		btnEliminarPublicacionVendedor7.setDisable(true);
		btnEliminarContactoVendedor7.setDisable(true);
		btnAgregarContactoSugerido7.setDisable(true);
		btnAgregarContactoBusqueda7.setDisable(true);
		btnBuscarVendedor7.setDisable(true);
		
		btnAgregarProductoVendedor9.setDisable(true);
		btnPublicarProductoVendedor9.setDisable(true);
		btnActualizarProductoVendedor9.setDisable(true);
		btnEliminarProductoVendedor9.setDisable(true);
		btnActualizarPublicacionVendedor9.setDisable(true);
		btnEliminarPublicacionVendedor9.setDisable(true);
		btnEliminarContactoVendedor9.setDisable(true);
		btnAgregarContactoSugerido9.setDisable(true);
		btnAgregarContactoBusqueda9.setDisable(true);
		btnBuscarVendedor9.setDisable(true);
		
		btnAgregarProductoVendedor10.setDisable(true);
		btnPublicarProductoVendedor10.setDisable(true);
		btnActualizarProductoVendedor10.setDisable(true);
		btnEliminarProductoVendedor10.setDisable(true);
		btnActualizarPublicacionVendedor10.setDisable(true);
		btnEliminarPublicacionVendedor10.setDisable(true);
		btnEliminarContactoVendedor10.setDisable(true);
		btnAgregarContactoSugerido10.setDisable(true);
		btnAgregarContactoBusqueda10.setDisable(true);
		btnBuscarVendedor10.setDisable(true);
	}

	//Inhabilitacion botones para vendedor 9
	private void inhabilitarFuncionesParaVendedor9() {
		inhabilitarTabAdmin();
		btnAgregarProductoVendedor1.setDisable(true);
		btnPublicarProductoVendedor1.setDisable(true);
		btnActualizarProductoVendedor1.setDisable(true);
		btnEliminarProductoVendedor1.setDisable(true);
		btnActualizarPublicacionVendedor1.setDisable(true);
		btnEliminarPublicacionVendedor1.setDisable(true);
		btnEliminarContactoVendedor1.setDisable(true);
		btnAgregarContactoSugerido1.setDisable(true);
		btnAgregarContactoBusqueda1.setDisable(true);
		btnBuscarVendedor1.setDisable(true);
		
		btnAgregarProductoVendedor2.setDisable(true);
		btnPublicarProductoVendedor2.setDisable(true);
		btnActualizarProductoVendedor2.setDisable(true);
		btnEliminarProductoVendedor2.setDisable(true);
		btnActualizarPublicacionVendedor2.setDisable(true);
		btnEliminarPublicacionVendedor2.setDisable(true);
		btnEliminarContactoVendedor2.setDisable(true);
		btnAgregarContactoSugerido2.setDisable(true);
		btnAgregarContactoBusqueda2.setDisable(true);
		btnBuscarVendedor2.setDisable(true);
		
		btnAgregarProductoVendedor3.setDisable(true);
		btnPublicarProductoVendedor3.setDisable(true);
		btnActualizarProductoVendedor3.setDisable(true);
		btnEliminarProductoVendedor3.setDisable(true);
		btnActualizarPublicacionVendedor3.setDisable(true);
		btnEliminarPublicacionVendedor3.setDisable(true);
		btnEliminarContactoVendedor3.setDisable(true);
		btnAgregarContactoSugerido3.setDisable(true);
		btnAgregarContactoBusqueda3.setDisable(true);
		btnBuscarVendedor3.setDisable(true);
		
		btnAgregarProductoVendedor4.setDisable(true);
		btnPublicarProductoVendedor4.setDisable(true);
		btnActualizarProductoVendedor4.setDisable(true);
		btnEliminarProductoVendedor4.setDisable(true);
		btnActualizarPublicacionVendedor4.setDisable(true);
		btnEliminarPublicacionVendedor4.setDisable(true);
		btnEliminarContactoVendedor4.setDisable(true);
		btnAgregarContactoSugerido4.setDisable(true);
		btnAgregarContactoBusqueda4.setDisable(true);
		btnBuscarVendedor4.setDisable(true);
		
		btnAgregarProductoVendedor5.setDisable(true);
		btnPublicarProductoVendedor5.setDisable(true);
		btnActualizarProductoVendedor5.setDisable(true);
		btnEliminarProductoVendedor5.setDisable(true);
		btnActualizarPublicacionVendedor5.setDisable(true);
		btnEliminarPublicacionVendedor5.setDisable(true);
		btnEliminarContactoVendedor5.setDisable(true);
		btnAgregarContactoSugerido5.setDisable(true);
		btnAgregarContactoBusqueda5.setDisable(true);
		btnBuscarVendedor5.setDisable(true);
		
		btnAgregarProductoVendedor6.setDisable(true);
		btnPublicarProductoVendedor6.setDisable(true);
		btnActualizarProductoVendedor6.setDisable(true);
		btnEliminarProductoVendedor6.setDisable(true);
		btnActualizarPublicacionVendedor6.setDisable(true);
		btnEliminarPublicacionVendedor6.setDisable(true);
		btnEliminarContactoVendedor6.setDisable(true);
		btnAgregarContactoSugerido6.setDisable(true);
		btnAgregarContactoBusqueda6.setDisable(true);
		btnBuscarVendedor6.setDisable(true);
		
		btnAgregarProductoVendedor7.setDisable(true);
		btnPublicarProductoVendedor7.setDisable(true);
		btnActualizarProductoVendedor7.setDisable(true);
		btnEliminarProductoVendedor7.setDisable(true);
		btnActualizarPublicacionVendedor7.setDisable(true);
		btnEliminarPublicacionVendedor7.setDisable(true);
		btnEliminarContactoVendedor7.setDisable(true);
		btnAgregarContactoSugerido7.setDisable(true);
		btnAgregarContactoBusqueda7.setDisable(true);
		btnBuscarVendedor7.setDisable(true);
		
		btnAgregarProductoVendedor8.setDisable(true);
		btnPublicarProductoVendedor8.setDisable(true);
		btnActualizarProductoVendedor8.setDisable(true);
		btnEliminarProductoVendedor8.setDisable(true);
		btnActualizarPublicacionVendedor8.setDisable(true);
		btnEliminarPublicacionVendedor8.setDisable(true);
		btnEliminarContactoVendedor8.setDisable(true);
		btnAgregarContactoSugerido8.setDisable(true);
		btnAgregarContactoBusqueda8.setDisable(true);
		btnBuscarVendedor8.setDisable(true);
		
		btnAgregarProductoVendedor10.setDisable(true);
		btnPublicarProductoVendedor10.setDisable(true);
		btnActualizarProductoVendedor10.setDisable(true);
		btnEliminarProductoVendedor10.setDisable(true);
		btnActualizarPublicacionVendedor10.setDisable(true);
		btnEliminarPublicacionVendedor10.setDisable(true);
		btnEliminarContactoVendedor10.setDisable(true);
		btnAgregarContactoSugerido10.setDisable(true);
		btnAgregarContactoBusqueda10.setDisable(true);
		btnBuscarVendedor10.setDisable(true);
	}

	//Inhabilitacion botones para vendedor 10
	private void inhabilitarFuncionesParaVendedor10() {
		inhabilitarTabAdmin();
		btnAgregarProductoVendedor1.setDisable(true);
		btnPublicarProductoVendedor1.setDisable(true);
		btnActualizarProductoVendedor1.setDisable(true);
		btnEliminarProductoVendedor1.setDisable(true);
		btnActualizarPublicacionVendedor1.setDisable(true);
		btnEliminarPublicacionVendedor1.setDisable(true);
		btnEliminarContactoVendedor1.setDisable(true);
		btnAgregarContactoSugerido1.setDisable(true);
		btnAgregarContactoBusqueda1.setDisable(true);
		btnBuscarVendedor1.setDisable(true);
		
		btnAgregarProductoVendedor2.setDisable(true);
		btnPublicarProductoVendedor2.setDisable(true);
		btnActualizarProductoVendedor2.setDisable(true);
		btnEliminarProductoVendedor2.setDisable(true);
		btnActualizarPublicacionVendedor2.setDisable(true);
		btnEliminarPublicacionVendedor2.setDisable(true);
		btnEliminarContactoVendedor2.setDisable(true);
		btnAgregarContactoSugerido2.setDisable(true);
		btnAgregarContactoBusqueda2.setDisable(true);
		btnBuscarVendedor2.setDisable(true);
		
		btnAgregarProductoVendedor3.setDisable(true);
		btnPublicarProductoVendedor3.setDisable(true);
		btnActualizarProductoVendedor3.setDisable(true);
		btnEliminarProductoVendedor3.setDisable(true);
		btnActualizarPublicacionVendedor3.setDisable(true);
		btnEliminarPublicacionVendedor3.setDisable(true);
		btnEliminarContactoVendedor3.setDisable(true);
		btnAgregarContactoSugerido3.setDisable(true);
		btnAgregarContactoBusqueda3.setDisable(true);
		btnBuscarVendedor3.setDisable(true);
		
		btnAgregarProductoVendedor4.setDisable(true);
		btnPublicarProductoVendedor4.setDisable(true);
		btnActualizarProductoVendedor4.setDisable(true);
		btnEliminarProductoVendedor4.setDisable(true);
		btnActualizarPublicacionVendedor4.setDisable(true);
		btnEliminarPublicacionVendedor4.setDisable(true);
		btnEliminarContactoVendedor4.setDisable(true);
		btnAgregarContactoSugerido4.setDisable(true);
		btnAgregarContactoBusqueda4.setDisable(true);
		btnBuscarVendedor4.setDisable(true);
		
		btnAgregarProductoVendedor5.setDisable(true);
		btnPublicarProductoVendedor5.setDisable(true);
		btnActualizarProductoVendedor5.setDisable(true);
		btnEliminarProductoVendedor5.setDisable(true);
		btnActualizarPublicacionVendedor5.setDisable(true);
		btnEliminarPublicacionVendedor5.setDisable(true);
		btnEliminarContactoVendedor5.setDisable(true);
		btnAgregarContactoSugerido5.setDisable(true);
		btnAgregarContactoBusqueda5.setDisable(true);
		btnBuscarVendedor5.setDisable(true);
		
		btnAgregarProductoVendedor6.setDisable(true);
		btnPublicarProductoVendedor6.setDisable(true);
		btnActualizarProductoVendedor6.setDisable(true);
		btnEliminarProductoVendedor6.setDisable(true);
		btnActualizarPublicacionVendedor6.setDisable(true);
		btnEliminarPublicacionVendedor6.setDisable(true);
		btnEliminarContactoVendedor6.setDisable(true);
		btnAgregarContactoSugerido6.setDisable(true);
		btnAgregarContactoBusqueda6.setDisable(true);
		btnBuscarVendedor6.setDisable(true);
		
		btnAgregarProductoVendedor7.setDisable(true);
		btnPublicarProductoVendedor7.setDisable(true);
		btnActualizarProductoVendedor7.setDisable(true);
		btnEliminarProductoVendedor7.setDisable(true);
		btnActualizarPublicacionVendedor7.setDisable(true);
		btnEliminarPublicacionVendedor7.setDisable(true);
		btnEliminarContactoVendedor7.setDisable(true);
		btnAgregarContactoSugerido7.setDisable(true);
		btnAgregarContactoBusqueda7.setDisable(true);
		btnBuscarVendedor7.setDisable(true);
		
		btnAgregarProductoVendedor8.setDisable(true);
		btnPublicarProductoVendedor8.setDisable(true);
		btnActualizarProductoVendedor8.setDisable(true);
		btnEliminarProductoVendedor8.setDisable(true);
		btnActualizarPublicacionVendedor8.setDisable(true);
		btnEliminarPublicacionVendedor8.setDisable(true);
		btnEliminarContactoVendedor8.setDisable(true);
		btnAgregarContactoSugerido8.setDisable(true);
		btnAgregarContactoBusqueda8.setDisable(true);
		btnBuscarVendedor8.setDisable(true);
		
		btnAgregarProductoVendedor9.setDisable(true);
		btnPublicarProductoVendedor9.setDisable(true);
		btnActualizarProductoVendedor9.setDisable(true);
		btnEliminarProductoVendedor9.setDisable(true);
		btnActualizarPublicacionVendedor9.setDisable(true);
		btnEliminarPublicacionVendedor9.setDisable(true);
		btnEliminarContactoVendedor9.setDisable(true);
		btnAgregarContactoSugerido9.setDisable(true);
		btnAgregarContactoBusqueda9.setDisable(true);
		btnBuscarVendedor9.setDisable(true);
	}
	
	/**
	 * Metodo para inhabilitar las funciones de la interfaz para los usuarios
	 */
	private void inhabilitarParaUsuarios() {
		inhabilitarTabAdmin();
		btnAgregarProductoVendedor1.setDisable(true);
		btnPublicarProductoVendedor1.setDisable(true);
		btnActualizarProductoVendedor1.setDisable(true);
		btnEliminarProductoVendedor1.setDisable(true);
		btnActualizarPublicacionVendedor1.setDisable(true);
		btnEliminarPublicacionVendedor1.setDisable(true);
		btnEliminarContactoVendedor1.setDisable(true);
		btnAgregarContactoSugerido1.setDisable(true);
		btnAgregarContactoBusqueda1.setDisable(true);
		btnBuscarVendedor1.setDisable(true);
		
		btnAgregarProductoVendedor2.setDisable(true);
		btnPublicarProductoVendedor2.setDisable(true);
		btnActualizarProductoVendedor2.setDisable(true);
		btnEliminarProductoVendedor2.setDisable(true);
		btnActualizarPublicacionVendedor2.setDisable(true);
		btnEliminarPublicacionVendedor2.setDisable(true);
		btnEliminarContactoVendedor2.setDisable(true);
		btnAgregarContactoSugerido2.setDisable(true);
		btnAgregarContactoBusqueda2.setDisable(true);
		btnBuscarVendedor2.setDisable(true);
		
		btnAgregarProductoVendedor3.setDisable(true);
		btnPublicarProductoVendedor3.setDisable(true);
		btnActualizarProductoVendedor3.setDisable(true);
		btnEliminarProductoVendedor3.setDisable(true);
		btnActualizarPublicacionVendedor3.setDisable(true);
		btnEliminarPublicacionVendedor3.setDisable(true);
		btnEliminarContactoVendedor3.setDisable(true);
		btnAgregarContactoSugerido3.setDisable(true);
		btnAgregarContactoBusqueda3.setDisable(true);
		btnBuscarVendedor3.setDisable(true);
		
		btnAgregarProductoVendedor4.setDisable(true);
		btnPublicarProductoVendedor4.setDisable(true);
		btnActualizarProductoVendedor4.setDisable(true);
		btnEliminarProductoVendedor4.setDisable(true);
		btnActualizarPublicacionVendedor4.setDisable(true);
		btnEliminarPublicacionVendedor4.setDisable(true);
		btnEliminarContactoVendedor4.setDisable(true);
		btnAgregarContactoSugerido4.setDisable(true);
		btnAgregarContactoBusqueda4.setDisable(true);
		btnBuscarVendedor4.setDisable(true);
		
		btnAgregarProductoVendedor5.setDisable(true);
		btnPublicarProductoVendedor5.setDisable(true);
		btnActualizarProductoVendedor5.setDisable(true);
		btnEliminarProductoVendedor5.setDisable(true);
		btnActualizarPublicacionVendedor5.setDisable(true);
		btnEliminarPublicacionVendedor5.setDisable(true);
		btnEliminarContactoVendedor5.setDisable(true);
		btnAgregarContactoSugerido5.setDisable(true);
		btnAgregarContactoBusqueda5.setDisable(true);
		btnBuscarVendedor5.setDisable(true);
		
		btnAgregarProductoVendedor6.setDisable(true);
		btnPublicarProductoVendedor6.setDisable(true);
		btnActualizarProductoVendedor6.setDisable(true);
		btnEliminarProductoVendedor6.setDisable(true);
		btnActualizarPublicacionVendedor6.setDisable(true);
		btnEliminarPublicacionVendedor6.setDisable(true);
		btnEliminarContactoVendedor6.setDisable(true);
		btnAgregarContactoSugerido6.setDisable(true);
		btnAgregarContactoBusqueda6.setDisable(true);
		btnBuscarVendedor6.setDisable(true);
		
		btnAgregarProductoVendedor7.setDisable(true);
		btnPublicarProductoVendedor7.setDisable(true);
		btnActualizarProductoVendedor7.setDisable(true);
		btnEliminarProductoVendedor7.setDisable(true);
		btnActualizarPublicacionVendedor7.setDisable(true);
		btnEliminarPublicacionVendedor7.setDisable(true);
		btnEliminarContactoVendedor7.setDisable(true);
		btnAgregarContactoSugerido7.setDisable(true);
		btnAgregarContactoBusqueda7.setDisable(true);
		btnBuscarVendedor7.setDisable(true);
		
		btnAgregarProductoVendedor8.setDisable(true);
		btnPublicarProductoVendedor8.setDisable(true);
		btnActualizarProductoVendedor8.setDisable(true);
		btnEliminarProductoVendedor8.setDisable(true);
		btnActualizarPublicacionVendedor8.setDisable(true);
		btnEliminarPublicacionVendedor8.setDisable(true);
		btnEliminarContactoVendedor8.setDisable(true);
		btnAgregarContactoSugerido8.setDisable(true);
		btnAgregarContactoBusqueda8.setDisable(true);
		btnBuscarVendedor8.setDisable(true);
		
		btnAgregarProductoVendedor9.setDisable(true);
		btnPublicarProductoVendedor9.setDisable(true);
		btnActualizarProductoVendedor9.setDisable(true);
		btnEliminarProductoVendedor9.setDisable(true);
		btnActualizarPublicacionVendedor9.setDisable(true);
		btnEliminarPublicacionVendedor9.setDisable(true);
		btnEliminarContactoVendedor9.setDisable(true);
		btnAgregarContactoSugerido9.setDisable(true);
		btnAgregarContactoBusqueda9.setDisable(true);
		btnBuscarVendedor9.setDisable(true);
		
		btnAgregarProductoVendedor10.setDisable(true);
		btnPublicarProductoVendedor10.setDisable(true);
		btnActualizarProductoVendedor10.setDisable(true);
		btnEliminarProductoVendedor10.setDisable(true);
		btnActualizarPublicacionVendedor10.setDisable(true);
		btnEliminarPublicacionVendedor10.setDisable(true);
		btnEliminarContactoVendedor10.setDisable(true);
		btnAgregarContactoSugerido10.setDisable(true);
		btnAgregarContactoBusqueda10.setDisable(true);
		btnBuscarVendedor10.setDisable(true);
	}
	
	/**
	 * Metodo para obtener la posicion del vendedor que inicio sesion en el tabPane general
	 * @return
	 */
	private int obtenerPosicion() {
		String cedulaTab = "";
		Tab tabAux;

		for (int i = 1; i < tabPaneGeneral.getTabs().size(); i++) {
			tabAux = tabPaneGeneral.getTabs().get(i);
			cedulaTab = tabAux.getText().split(":")[1];

			if(cedulaTab.equals(codigoUsuario)){
				return i;
			}
		}
		return -1;
	}
	
	//-------------------------------------------------------Set ComboBoxes--------------------------------------------------------------------------------
	
	/**
	 * Metodo para setear el texto en los comboBox
	 */
	private void setComboBoxes() {
		//Para vendedor 1
		comboBoxCategoriaVendedor1.getItems().add("Mueble");
		comboBoxCategoriaVendedor1.getItems().add("Electrodomestico");
		comboBoxCategoriaVendedor1.getItems().add("Construccion");
		comboBoxEstadoVendedor1.getItems().add("Vendido");
		comboBoxEstadoVendedor1.getItems().add("Cancelado");
		
		//Para vendedor 2
		comboBoxCategoriaVendedor2.getItems().add("Mueble");
		comboBoxCategoriaVendedor2.getItems().add("Electrodomestico");
		comboBoxCategoriaVendedor2.getItems().add("Construccion");
		comboBoxEstadoVendedor2.getItems().add("Vendido");
		comboBoxEstadoVendedor2.getItems().add("Cancelado");
		
		//Para vendedor 3
		comboBoxCategoriaVendedor3.getItems().add("Mueble");
		comboBoxCategoriaVendedor3.getItems().add("Electrodomestico");
		comboBoxCategoriaVendedor3.getItems().add("Construccion");
		comboBoxEstadoVendedor3.getItems().add("Vendido");
		comboBoxEstadoVendedor3.getItems().add("Cancelado");

		//Para vendedor 4
		comboBoxCategoriaVendedor4.getItems().add("Mueble");
		comboBoxCategoriaVendedor4.getItems().add("Electrodomestico");
		comboBoxCategoriaVendedor4.getItems().add("Construccion");
		comboBoxEstadoVendedor4.getItems().add("Vendido");
		comboBoxEstadoVendedor4.getItems().add("Cancelado");
		
		//Para vendedor 5
		comboBoxCategoriaVendedor5.getItems().add("Mueble");
		comboBoxCategoriaVendedor5.getItems().add("Electrodomestico");
		comboBoxCategoriaVendedor5.getItems().add("Construccion");
		comboBoxEstadoVendedor5.getItems().add("Vendido");
		comboBoxEstadoVendedor5.getItems().add("Cancelado");
		
		//Para vendedor 6
		comboBoxCategoriaVendedor6.getItems().add("Mueble");
		comboBoxCategoriaVendedor6.getItems().add("Electrodomestico");
		comboBoxCategoriaVendedor6.getItems().add("Construccion");
		comboBoxEstadoVendedor6.getItems().add("Vendido");
		comboBoxEstadoVendedor6.getItems().add("Cancelado");

		//Para vendedor 7
		comboBoxCategoriaVendedor7.getItems().add("Mueble");
		comboBoxCategoriaVendedor7.getItems().add("Electrodomestico");
		comboBoxCategoriaVendedor7.getItems().add("Construccion");
		comboBoxEstadoVendedor7.getItems().add("Vendido");
		comboBoxEstadoVendedor7.getItems().add("Cancelado");

		//Para vendedor 8
		comboBoxCategoriaVendedor8.getItems().add("Mueble");
		comboBoxCategoriaVendedor8.getItems().add("Electrodomestico");
		comboBoxCategoriaVendedor8.getItems().add("Construccion");
		comboBoxEstadoVendedor8.getItems().add("Vendido");
		comboBoxEstadoVendedor8.getItems().add("Cancelado");

		//Para vendedor 9
		comboBoxCategoriaVendedor9.getItems().add("Mueble");
		comboBoxCategoriaVendedor9.getItems().add("Electrodomestico");
		comboBoxCategoriaVendedor9.getItems().add("Construccion");
		comboBoxEstadoVendedor9.getItems().add("Vendido");
		comboBoxEstadoVendedor9.getItems().add("Cancelado");

		//Para vendedor 10
		comboBoxCategoriaVendedor10.getItems().add("Mueble");
		comboBoxCategoriaVendedor10.getItems().add("Electrodomestico");
		comboBoxCategoriaVendedor10.getItems().add("Construccion");
		comboBoxEstadoVendedor10.getItems().add("Vendido");
		comboBoxEstadoVendedor10.getItems().add("Cancelado");
	}

	 //---------------------------------------------------------CRUD de vendedor en administracion-----------------------------------------------------------------
	 

	/**
	  * Metodo que restablece los campos de texto en la pestaña clientes para crear un nuevo vendedor
	  */
	 private void nuevoVendedor() {
		 
		 //Mostrar en los campos de texto la orden al usuario
		 txtNombreVendedorAdmin.setText("Ingrese el nombre del vendedor");
		 txtApellidoVendedorAdmin.setText("Ingrese el apellido del vendedor");
		 txtCedulaVendedorAdmin.setText("Ingrese la cedula del vendedor");
		 txtDireccionVendedorAdmin.setText("Ingrese la direccion del vendedor");
		 
	 }

	 /**
	  * Metodo el cual crea un vendedor nuevo
	  */
	private void crearVendedor() {
		
		//1. Capturar los datos
		String nombre     = txtNombreVendedorAdmin.getText();
		String apellido   = txtApellidoVendedorAdmin.getText();
		String cedula     = txtCedulaVendedorAdmin.getText();
		String direccion  = txtDireccionVendedorAdmin.getText();
		String contraseña = passTxtContraseñaVendedorAdmin.getText();

		//2. Validar la informacion capturada
		if(datosValidosVendedor(nombre, apellido, cedula, direccion, contraseña)){
			boolean centinela = false;

			centinela = crudVendedorViewController.crearVendedor(nombre, apellido, cedula, direccion, contraseña);

			if(centinela == true){
				limpiarCamposTextoAdmin();
//				tableVendedoresAdmin.refresh();
				tableVendedoresAdmin.getItems().clear();
				tableVendedoresAdmin.setItems(getListaVendedoresData());
				setTabs();
				actualizarTables();
				
				//Persistencia para vendedor
				modelFactoryController.guardarArchivos();
				modelFactoryController.guardarResourceXML();
//				modelFactoryController.guardarResourceBinario();
				
				//Registramos actividad
				modelFactoryController.registrarAccionesSistema("Vendedor con cedula "+cedula+" creado por el usuario con codigo "+codigoUsuario, 1, "Creacion");

				mostrarMensaje("Notificacion Vendedor", "Vendedor creado", "El vendedor fue creado con exito", AlertType.INFORMATION);
			}
		}

	}

	/**
	 * Metodo que permite actualizar los datos del vendedor
	 */
	private void actualizarVendedor() {
		
		//1. Capturar los datos
		String nombre     = txtNombreVendedorAdmin.getText();
		String apellido   = txtApellidoVendedorAdmin.getText();
		String cedula     = txtCedulaVendedorAdmin.getText();
		String direccion  = txtDireccionVendedorAdmin.getText();
		String contraseña = passTxtContraseñaVendedorAdmin.getText();

		boolean flagVendedorActualizado = false;

		//2. Validacion de la informacion capturada
		if(vendedorSeleccionado != null){
			if(datosValidosVendedor(nombre, apellido, cedula, direccion, contraseña) == true){
				String cedulaAux        = vendedorSeleccionado.getCedula();
				flagVendedorActualizado = crudVendedorViewController.actualizarVendedor(nombre, apellido, cedula, cedulaAux, direccion, contraseña);
				
				if(flagVendedorActualizado == true){
					limpiarCamposTextoAdmin();
//					tableVendedoresAdmin.refresh();
					tableVendedoresAdmin.getItems().clear();
					tableVendedoresAdmin.setItems(getListaVendedoresData());
					setTabs();
					
					//Persistencia para vendedor
					modelFactoryController.guardarArchivos();
					modelFactoryController.guardarResourceXML();
					modelFactoryController.guardarResourceBinario();
					
					
					//Registramos actividad
					modelFactoryController.registrarAccionesSistema("Vendedor con codigo "+cedulaAux+" actualizado por el usuario con codigo "+codigoUsuario, 1, "Actualizacion");
					
					mostrarMensaje("Notificación vendedor", "Vendedor actualizado", "El vendedor se ha actualizado con éxito", AlertType.INFORMATION);
				}
				else{
					mostrarMensaje("Notificación vendedor","Vendedor no actualizado","El vendedor no se puede actualizar", AlertType.ERROR);
				}
			}
		}
		else{
			mostrarMensaje("Notificación vendedor","Vendedor no seleccionado","Debe seleccionar un vendedor", AlertType.WARNING);
		}
	}
	

	/**
	 * Metodo que permite eliminar un vendedor
	 */
	private void eliminarVendedor(){
		
		if(vendedorSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el vendedor?")){
				boolean centinela = false;
				String cedula = vendedorSeleccionado.getCedula();
				centinela = crudVendedorViewController.eliminarVendedor(cedula);
				
				if(centinela == true){
					limpiarCamposTextoAdmin();
					tableVendedoresAdmin.getItems().clear();
					tableVendedoresAdmin.setItems(getListaVendedoresData());
					setTabs();
					actualizarTables();
					limpiarCamposComentarios();
					
					//Persistencia para vendedor
					modelFactoryController.guardarArchivos();
					modelFactoryController.guardarResourceXML();
					modelFactoryController.guardarResourceBinario();
					
					
					//Registramos actividad
					modelFactoryController.registrarAccionesSistema("Vendedor con codigo "+cedula+" eliminado por el usuario con codigo "+codigoUsuario, 2, "Eliminacion");
					
					mostrarMensaje("Notificación vendedor", "Vendedor eliminado", "El vendedor se ha eliminado con éxito", AlertType.INFORMATION);
				}
				else{
					mostrarMensaje("Notificación vendedor","Vendedor no eliminado","El vendedor no se puede eliminar", AlertType.ERROR);
				}
			}
		}
		else{
			mostrarMensaje("Notificación vendedor","Vendedor no seleccionado","Debe seleccionar un vendedor", AlertType.WARNING);
		}
	}
	
	//-----------------------------------------------Administracion de acciones para la pestaña de Vendedor 1-----------------------------------------------

	/**
	 * Metodo para agregar un producto para el vendedor 1
	 */
	private void agregarProductoVendedor1() {
		String nombre = txtNombreProductoVendedor1.getText();
		String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor1.getValue());
		String precio = txtPrecioProductoVendedor1.getText();
		String estado = obtenerEstadoProducto(comboBoxEstadoVendedor1.getValue());

		agregarProductoVendedorGenerico(nombre, categoria, precio, estado);
		tableProductosVendedor1.getItems().clear();
		tableProductosVendedor1.setItems(getListaProductosVendedor1Data());
		limpiarCamposTextoVendedor(txtNombreProductoVendedor1, txtPrecioProductoVendedor1);

	}

	private void actualizarProductoVendedor1() {
		if(productoSeleccionado != null){
			String nombre = txtNombreProductoVendedor1.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor1.getValue());
			String precio = txtPrecioProductoVendedor1.getText();
			String estado = obtenerEstadoProducto(comboBoxEstadoVendedor1.getValue());
			String cedulaVendedor = obtenerCedulaVendedorTabActivo();

			actualizarProductoVendedorGenerico(productoSeleccionado, cedulaVendedor, nombre, categoria, precio, estado);
			tableProductosVendedor1.getItems().clear();
			tableProductosVendedor1.setItems(getListaProductosVendedor1Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor1, txtPrecioProductoVendedor1);
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No actualizado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void publicarProductoVendedor1(){
		if(productoSeleccionado != null){
			publicarProductoVendedorGenerico(productoSeleccionado);

			tablePublicacionesVendedor1.getItems().clear();
			tablePublicacionesVendedor1.setItems(getListaPublicacionesVendedor1Data());
			tableProductosVendedor1.getItems().clear();
			tableProductosVendedor1.setItems(getListaProductosVendedor1Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No realizada", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void actualizarPublicacionVendedor1(){
		if(publicacionSeleccionada != null){
			String nombre = txtNombreProductoVendedor1.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor1.getValue());
			String precio = txtPrecioProductoVendedor1.getText();
			String estado = obtenerEstadoProducto("Publicado");

			actualizarPublicacionGenerico(publicacionSeleccionada, nombre, categoria, precio, estado);
			tablePublicacionesVendedor1.getItems().clear();
			tablePublicacionesVendedor1.setItems(getListaPublicacionesVendedor1Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor1, txtPrecioProductoVendedor1);
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No eliminada", "Seleccione una publicacion", AlertType.INFORMATION);
		}
	}

	private void eliminarPublicacionVendedor1() {
		if(publicacionSeleccionada != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar la publicacion?")){
				eliminarPublicacionGenerico(publicacionSeleccionada);

				tablePublicacionesVendedor1.getItems().clear();
				tablePublicacionesVendedor1.setItems(getListaPublicacionesVendedor1Data());
				limpiarCamposTextoVendedor(txtNombreProductoVendedor1, txtPrecioProductoVendedor1);
			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void eliminarProductoVendedor1() {
		if(productoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el producto?")){

				eliminarProductoVendedorGenerico(productoSeleccionado);

				tableProductosVendedor1.getItems().clear();
				tableProductosVendedor1.setItems(getListaProductosVendedor1Data());

			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}

	}

	private void darLikePublicacionVendedor1() {
		if(publicacionSeleccionada != null){
			darLikePublicacionVendedorGenerico(publicacionSeleccionada, labelLikesPublicacionVendedor1, 0);

			tablePublicacionesVendedor1.getItems().clear();
			tablePublicacionesVendedor1.setItems(getListaPublicacionesVendedor1Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No likeada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	private void agregarComentarioPublicacionVendedor1() {
		if(publicacionSeleccionada != null){
			String comentario = txtComentarioPublicacionVendedor1.getText();

			if(comentario == null || comentario == ""){
				mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Agregue un comentario en el campo de texto de agregar comentario", AlertType.INFORMATION);
			}
			else{
				agregarComentarioPublicacionVendedorGenerico(publicacionSeleccionada, comentario, codigoUsuario, txtComentarioPublicacionVendedor1);

				tablePublicacionesVendedor1.getItems().clear();
				tablePublicacionesVendedor1.setItems(getListaPublicacionesVendedor1Data());
			}
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	//CRUD Contactos

	private void eliminarContactoVendedor1() {
		if(contactoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el contacto?")){
				eliminarContactoGenerico();
				tableContactosVendedor1.getItems().clear();
				tableContactosVendedor1.setItems(getListaContactosVendedor1Data());
				actualizarTablesSugeridos();
			}
		}
		else{
			mostrarMensaje("Notificacion Contacto", "Contacto No eliminado", "Seleccione un contacto", AlertType.INFORMATION);
		}

	}

	private void agregarContactoSugerido1() {
		if(contactoSugeridoSeleccionado != null){
			agregarContactoGenerico(contactoSugeridoSeleccionado);

			tableContactosVendedor1.getItems().clear();
			tableContactosVendedor1.setItems(getListaContactosVendedor1Data());

			actualizarTablesSugeridos();
		}
	}

	/**
	 * Metodo que permite agregar un contacto buscado por medio de la seleccion de la tabla
	 */
	private void agregarContactoBusqueda1() {
		if(vendedorBuscadoSeleccionado != null){
			agregarContactoGenerico(vendedorBuscadoSeleccionado);


			tableContactosVendedor1.getItems().clear();
			tableContactosVendedor1.setItems(getListaContactosVendedor1Data());

			actualizarTablesSugeridos();
		}

	}

	//Busqueda vendedores
	private void buscarVendedores1() {
		String nombre = txtBuscarVendedor1.getText();

		if(nombre != null && nombre != ""){
			ArrayList<Vendedor> listaVendedoresEncontrados = new ArrayList<Vendedor>();
			listaVendedoresEncontrados = buscarVendedoresGenerico(nombre, listaVendedoresEncontrados);

			listaContactosEncontradosVendedor1Data.clear();
			listaContactosEncontradosVendedor1Data.addAll(listaVendedoresEncontrados);

			tableBusquedaContactos1.setItems(listaContactosEncontradosVendedor1Data);
		}
		else{
			mostrarMensaje("Notificacion Busqueda", "Busqueda no realizada", "Criterio de busqueda incorrecto", AlertType.INFORMATION);
		}

	}

	private void enviarMensajeVendedor1() {
		String mensaje = txtMensajesVendedor1.getText();

		if(mensaje != null && mensaje != ""){
			enviarMensajeVendedorGenerico(mensaje, codigoUsuario);
			txtMensajesVendedor1.setText("");
			setLabelsMensajes(codigoUsuario);
		}
		else{
			mostrarMensaje("Notificacion Envio Mensajes", "Mensaje no enviado", "Escriba un mensaje", AlertType.INFORMATION);
		}
	}
	
	
	//-----------------------------------------------Administracion de acciones para la pestaña de Vendedor 2-----------------------------------------------
	
	/**
	 * Metodo para agregar un producto para el vendedor 1
	 */
	private void agregarProductoVendedor2() {
		String nombre = txtNombreProductoVendedor2.getText();
		String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor2.getValue());
		String precio = txtPrecioProductoVendedor2.getText();
		String estado = obtenerEstadoProducto(comboBoxEstadoVendedor2.getValue());
		
		agregarProductoVendedorGenerico(nombre, categoria, precio, estado);
		tableProductosVendedor2.getItems().clear();
		tableProductosVendedor2.setItems(getListaProductosVendedor2Data());
		limpiarCamposTextoVendedor(txtNombreProductoVendedor2, txtPrecioProductoVendedor2);
		
	}
	
	private void actualizarProductoVendedor2() {
		if(productoSeleccionado != null){
			String nombre = txtNombreProductoVendedor2.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor2.getValue());
			String precio = txtPrecioProductoVendedor2.getText();
			String estado = obtenerEstadoProducto(comboBoxEstadoVendedor2.getValue());
			String cedulaVendedor = obtenerCedulaVendedorTabActivo();
			
			actualizarProductoVendedorGenerico(productoSeleccionado, cedulaVendedor, nombre, categoria, precio, estado);
			tableProductosVendedor2.getItems().clear();
			tableProductosVendedor2.setItems(getListaProductosVendedor2Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor2, txtPrecioProductoVendedor2);
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No actualizado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}
	
	private void publicarProductoVendedor2(){
		if(productoSeleccionado != null){
			publicarProductoVendedorGenerico(productoSeleccionado);
			
			tablePublicacionesVendedor2.getItems().clear();
			tablePublicacionesVendedor2.setItems(getListaPublicacionesVendedor2Data());
			tableProductosVendedor2.getItems().clear();
			tableProductosVendedor2.setItems(getListaProductosVendedor2Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No realizada", "Seleccione un producto", AlertType.INFORMATION);
		}
	}
	
	private void actualizarPublicacionVendedor2(){
		if(publicacionSeleccionada != null){
			String nombre = txtNombreProductoVendedor2.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor2.getValue());
			String precio = txtPrecioProductoVendedor2.getText();
			String estado = obtenerEstadoProducto("Publicado");
			
			actualizarPublicacionGenerico(publicacionSeleccionada, nombre, categoria, precio, estado);
			tablePublicacionesVendedor2.getItems().clear();
			tablePublicacionesVendedor2.setItems(getListaPublicacionesVendedor2Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor2, txtPrecioProductoVendedor2);
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No eliminada", "Seleccione una publicacion", AlertType.INFORMATION);
		}
	}
	
	private void eliminarPublicacionVendedor2() {
		if(publicacionSeleccionada != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar la publicacion?")){
				eliminarPublicacionGenerico(publicacionSeleccionada);
				
				tablePublicacionesVendedor2.getItems().clear();
				tablePublicacionesVendedor2.setItems(getListaPublicacionesVendedor2Data());
				limpiarCamposTextoVendedor(txtNombreProductoVendedor2, txtPrecioProductoVendedor2);
			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}
	
	private void eliminarProductoVendedor2() {
		if(productoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el producto?")){
	
				eliminarProductoVendedorGenerico(productoSeleccionado);
				
				tableProductosVendedor2.getItems().clear();
				tableProductosVendedor2.setItems(getListaProductosVendedor2Data());

			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}
		
	}
	
	private void darLikePublicacionVendedor2() {
		if(publicacionSeleccionada != null){
			darLikePublicacionVendedorGenerico(publicacionSeleccionada, labelLikesPublicacionVendedor2, 1);
			
			tablePublicacionesVendedor2.getItems().clear();
			tablePublicacionesVendedor2.setItems(getListaPublicacionesVendedor2Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No likeada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}
		
	}
	
	private void agregarComentarioPublicacionVendedor2() {
		if(publicacionSeleccionada != null){
			String comentario = txtComentarioPublicacionVendedor2.getText();
			
			if(comentario == null || comentario == ""){
				mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Agregue un comentario en el campo de texto de agregar comentario", AlertType.INFORMATION);
			}
			else{
				agregarComentarioPublicacionVendedorGenerico(publicacionSeleccionada, comentario, codigoUsuario, txtComentarioPublicacionVendedor2);
				
				tablePublicacionesVendedor2.getItems().clear();
				tablePublicacionesVendedor2.setItems(getListaPublicacionesVendedor2Data());
			}
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}
		
	}
	
	//CRUD Contactos
	
	private void eliminarContactoVendedor2() {
		if(contactoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el contacto?")){
				eliminarContactoGenerico();
				tableContactosVendedor2.getItems().clear();
				tableContactosVendedor2.setItems(getListaContactosVendedor2Data());
				actualizarTablesSugeridos();
				
			}
		}
		else{
			mostrarMensaje("Notificacion Contacto", "Contacto No eliminado", "Seleccione un contacto", AlertType.INFORMATION);
		}
		
	}
	
	private void agregarContactoSugerido2() {
		if(contactoSugeridoSeleccionado != null){
			agregarContactoGenerico(contactoSugeridoSeleccionado);
			
			tableContactosVendedor2.getItems().clear();
			tableContactosVendedor2.setItems(getListaContactosVendedor2Data());
			
			actualizarTablesSugeridos();
		}
	}
	
	/**
	 * Metodo que permite agregar un contacto buscado por medio de la seleccion de la tabla
	 */
	private void agregarContactoBusqueda2() {
		if(vendedorBuscadoSeleccionado != null){
			agregarContactoGenerico(vendedorBuscadoSeleccionado);


			tableContactosVendedor2.getItems().clear();
			tableContactosVendedor2.setItems(getListaContactosVendedor2Data());

			actualizarTablesSugeridos();
		}

	}
	
	//Busqueda vendedores
	private void buscarVendedores2() {
		String nombre = txtBuscarVendedor2.getText();
		
		if(nombre != null && nombre != ""){
			ArrayList<Vendedor> listaVendedoresEncontrados = new ArrayList<Vendedor>();
			listaVendedoresEncontrados = buscarVendedoresGenerico(nombre, listaVendedoresEncontrados);
			
			listaContactosEncontradosVendedor2Data.clear();
			listaContactosEncontradosVendedor2Data.addAll(listaVendedoresEncontrados);
			
			tableBusquedaContactos2.setItems(listaContactosEncontradosVendedor2Data);
		}
		else{
			mostrarMensaje("Notificacion Busqueda", "Busqueda no realizada", "Criterio de busqueda incorrecto", AlertType.INFORMATION);
		}
		
	}
	
	private void enviarMensajeVendedor2() {
		String mensaje = txtMensajesVendedor2.getText();
		
		if(mensaje != null && mensaje != ""){
			enviarMensajeVendedorGenerico(mensaje, codigoUsuario);
			txtMensajesVendedor2.setText("");
			setLabelsMensajes(codigoUsuario);
		}
		else{
			mostrarMensaje("Notificacion Envio Mensajes", "Mensaje no enviado", "Escriba un mensaje", AlertType.INFORMATION);
		}
	}
	
	
	
	//-----------------------------------------------Administracion de acciones para la pestaña de Vendedor 3-----------------------------------------------

	/**
	 * Metodo para agregar un producto para el vendedor 1
	 */
	private void agregarProductoVendedor3() {
		String nombre = txtNombreProductoVendedor3.getText();
		String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor3.getValue());
		String precio = txtPrecioProductoVendedor3.getText();
		String estado = obtenerEstadoProducto(comboBoxEstadoVendedor3.getValue());

		agregarProductoVendedorGenerico(nombre, categoria, precio, estado);
		tableProductosVendedor3.getItems().clear();
		tableProductosVendedor3.setItems(getListaProductosVendedor3Data());
		limpiarCamposTextoVendedor(txtNombreProductoVendedor3, txtPrecioProductoVendedor3);

	}

	private void actualizarProductoVendedor3() {
		if(productoSeleccionado != null){
			String nombre = txtNombreProductoVendedor3.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor3.getValue());
			String precio = txtPrecioProductoVendedor3.getText();
			String estado = obtenerEstadoProducto(comboBoxEstadoVendedor3.getValue());
			String cedulaVendedor = obtenerCedulaVendedorTabActivo();

			actualizarProductoVendedorGenerico(productoSeleccionado, cedulaVendedor, nombre, categoria, precio, estado);
			tableProductosVendedor3.getItems().clear();
			tableProductosVendedor3.setItems(getListaProductosVendedor3Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor3, txtPrecioProductoVendedor3);
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No actualizado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void publicarProductoVendedor3(){
		if(productoSeleccionado != null){
			publicarProductoVendedorGenerico(productoSeleccionado);

			tablePublicacionesVendedor3.getItems().clear();
			tablePublicacionesVendedor3.setItems(getListaPublicacionesVendedor3Data());
			tableProductosVendedor3.getItems().clear();
			tableProductosVendedor3.setItems(getListaProductosVendedor3Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No realizada", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void actualizarPublicacionVendedor3(){
		if(publicacionSeleccionada != null){
			String nombre = txtNombreProductoVendedor3.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor3.getValue());
			String precio = txtPrecioProductoVendedor3.getText();
			String estado = obtenerEstadoProducto("Publicado");

			actualizarPublicacionGenerico(publicacionSeleccionada, nombre, categoria, precio, estado);
			tablePublicacionesVendedor3.getItems().clear();
			tablePublicacionesVendedor3.setItems(getListaPublicacionesVendedor3Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor3, txtPrecioProductoVendedor3);
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No eliminada", "Seleccione una publicacion", AlertType.INFORMATION);
		}
	}

	private void eliminarPublicacionVendedor3() {
		if(publicacionSeleccionada != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar la publicacion?")){
				eliminarPublicacionGenerico(publicacionSeleccionada);

				tablePublicacionesVendedor3.getItems().clear();
				tablePublicacionesVendedor3.setItems(getListaPublicacionesVendedor3Data());
				limpiarCamposTextoVendedor(txtNombreProductoVendedor3, txtPrecioProductoVendedor3);
			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void eliminarProductoVendedor3() {
		if(productoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el producto?")){

				eliminarProductoVendedorGenerico(productoSeleccionado);

				tableProductosVendedor3.getItems().clear();
				tableProductosVendedor3.setItems(getListaProductosVendedor3Data());

			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}

	}

	private void darLikePublicacionVendedor3() {
		if(publicacionSeleccionada != null){
			darLikePublicacionVendedorGenerico(publicacionSeleccionada, labelLikesPublicacionVendedor3, 2);

			tablePublicacionesVendedor3.getItems().clear();
			tablePublicacionesVendedor3.setItems(getListaPublicacionesVendedor3Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No likeada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	private void agregarComentarioPublicacionVendedor3() {
		if(publicacionSeleccionada != null){
			String comentario = txtComentarioPublicacionVendedor3.getText();

			if(comentario == null || comentario == ""){
				mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Agregue un comentario en el campo de texto de agregar comentario", AlertType.INFORMATION);
			}
			else{
				agregarComentarioPublicacionVendedorGenerico(publicacionSeleccionada, comentario, codigoUsuario, txtComentarioPublicacionVendedor3);

				tablePublicacionesVendedor3.getItems().clear();
				tablePublicacionesVendedor3.setItems(getListaPublicacionesVendedor3Data());
			}
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	//CRUD Contactos

	private void eliminarContactoVendedor3() {
		if(contactoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el contacto?")){
				eliminarContactoGenerico();
				tableContactosVendedor3.getItems().clear();
				tableContactosVendedor3.setItems(getListaContactosVendedor3Data());
				actualizarTablesSugeridos();

			}
		}
		else{
			mostrarMensaje("Notificacion Contacto", "Contacto No eliminado", "Seleccione un contacto", AlertType.INFORMATION);
		}

	}

	private void agregarContactoSugerido3() {
		if(contactoSugeridoSeleccionado != null){
			agregarContactoGenerico(contactoSugeridoSeleccionado);

			tableContactosVendedor3.getItems().clear();
			tableContactosVendedor3.setItems(getListaContactosVendedor3Data());

			actualizarTablesSugeridos();
		}
	}

	/**
	 * Metodo que permite agregar un contacto buscado por medio de la seleccion de la tabla
	 */
	private void agregarContactoBusqueda3() {
		if(vendedorBuscadoSeleccionado != null){
			agregarContactoGenerico(vendedorBuscadoSeleccionado);


			tableContactosVendedor3.getItems().clear();
			tableContactosVendedor3.setItems(getListaContactosVendedor3Data());

			actualizarTablesSugeridos();
		}

	}

	//Busqueda vendedores
	private void buscarVendedores3() {
		String nombre = txtBuscarVendedor3.getText();

		if(nombre != null && nombre != ""){
			ArrayList<Vendedor> listaVendedoresEncontrados = new ArrayList<Vendedor>();
			listaVendedoresEncontrados = buscarVendedoresGenerico(nombre, listaVendedoresEncontrados);

			listaContactosEncontradosVendedor3Data.clear();
			listaContactosEncontradosVendedor3Data.addAll(listaVendedoresEncontrados);

			tableBusquedaContactos3.setItems(listaContactosEncontradosVendedor3Data);
		}
		else{
			mostrarMensaje("Notificacion Busqueda", "Busqueda no realizada", "Criterio de busqueda incorrecto", AlertType.INFORMATION);
		}

	}

	private void enviarMensajeVendedor3() {
		String mensaje = txtMensajesVendedor3.getText();

		if(mensaje != null && mensaje != ""){
			enviarMensajeVendedorGenerico(mensaje, codigoUsuario);
			txtMensajesVendedor3.setText("");
			setLabelsMensajes(codigoUsuario);
		}
		else{
			mostrarMensaje("Notificacion Envio Mensajes", "Mensaje no enviado", "Escriba un mensaje", AlertType.INFORMATION);
		}
	}
		
		
	//-----------------------------------------------Administracion de acciones para la pestaña de Vendedor 4-----------------------------------------------
		
	/**
	 * Metodo para agregar un producto para el vendedor 1
	 */
	private void agregarProductoVendedor4() {
		String nombre = txtNombreProductoVendedor4.getText();
		String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor4.getValue());
		String precio = txtPrecioProductoVendedor4.getText();
		String estado = obtenerEstadoProducto(comboBoxEstadoVendedor4.getValue());

		agregarProductoVendedorGenerico(nombre, categoria, precio, estado);
		tableProductosVendedor4.getItems().clear();
		tableProductosVendedor4.setItems(getListaProductosVendedor4Data());
		limpiarCamposTextoVendedor(txtNombreProductoVendedor4, txtPrecioProductoVendedor4);

	}

	private void actualizarProductoVendedor4() {
		if(productoSeleccionado != null){
			String nombre = txtNombreProductoVendedor4.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor4.getValue());
			String precio = txtPrecioProductoVendedor4.getText();
			String estado = obtenerEstadoProducto(comboBoxEstadoVendedor4.getValue());
			String cedulaVendedor = obtenerCedulaVendedorTabActivo();

			actualizarProductoVendedorGenerico(productoSeleccionado, cedulaVendedor, nombre, categoria, precio, estado);
			tableProductosVendedor4.getItems().clear();
			tableProductosVendedor4.setItems(getListaProductosVendedor4Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor4, txtPrecioProductoVendedor4);
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No actualizado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void publicarProductoVendedor4(){
		if(productoSeleccionado != null){
			publicarProductoVendedorGenerico(productoSeleccionado);

			tablePublicacionesVendedor4.getItems().clear();
			tablePublicacionesVendedor4.setItems(getListaPublicacionesVendedor4Data());
			tableProductosVendedor4.getItems().clear();
			tableProductosVendedor4.setItems(getListaProductosVendedor4Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No realizada", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void actualizarPublicacionVendedor4(){
		if(publicacionSeleccionada != null){
			String nombre = txtNombreProductoVendedor4.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor4.getValue());
			String precio = txtPrecioProductoVendedor4.getText();
			String estado = obtenerEstadoProducto("Publicado");

			actualizarPublicacionGenerico(publicacionSeleccionada, nombre, categoria, precio, estado);
			tablePublicacionesVendedor4.getItems().clear();
			tablePublicacionesVendedor4.setItems(getListaPublicacionesVendedor4Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor4, txtPrecioProductoVendedor4);
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No eliminada", "Seleccione una publicacion", AlertType.INFORMATION);
		}
	}

	private void eliminarPublicacionVendedor4() {
		if(publicacionSeleccionada != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar la publicacion?")){
				eliminarPublicacionGenerico(publicacionSeleccionada);

				tablePublicacionesVendedor4.getItems().clear();
				tablePublicacionesVendedor4.setItems(getListaPublicacionesVendedor4Data());
				limpiarCamposTextoVendedor(txtNombreProductoVendedor4, txtPrecioProductoVendedor4);
			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void eliminarProductoVendedor4() {
		if(productoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el producto?")){

				eliminarProductoVendedorGenerico(productoSeleccionado);

				tableProductosVendedor4.getItems().clear();
				tableProductosVendedor4.setItems(getListaProductosVendedor4Data());

			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}

	}

	private void darLikePublicacionVendedor4() {
		if(publicacionSeleccionada != null){
			darLikePublicacionVendedorGenerico(publicacionSeleccionada, labelLikesPublicacionVendedor4, 3);

			tablePublicacionesVendedor4.getItems().clear();
			tablePublicacionesVendedor4.setItems(getListaPublicacionesVendedor4Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No likeada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	private void agregarComentarioPublicacionVendedor4() {
		if(publicacionSeleccionada != null){
			String comentario = txtComentarioPublicacionVendedor4.getText();

			if(comentario == null || comentario == ""){
				mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Agregue un comentario en el campo de texto de agregar comentario", AlertType.INFORMATION);
			}
			else{
				agregarComentarioPublicacionVendedorGenerico(publicacionSeleccionada, comentario, codigoUsuario, txtComentarioPublicacionVendedor4);

				tablePublicacionesVendedor4.getItems().clear();
				tablePublicacionesVendedor4.setItems(getListaPublicacionesVendedor4Data());
			}
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	//CRUD Contactos

	private void eliminarContactoVendedor4() {
		if(contactoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el contacto?")){
				eliminarContactoGenerico();
				tableContactosVendedor4.getItems().clear();
				tableContactosVendedor4.setItems(getListaContactosVendedor4Data());
				actualizarTablesSugeridos();

			}
		}
		else{
			mostrarMensaje("Notificacion Contacto", "Contacto No eliminado", "Seleccione un contacto", AlertType.INFORMATION);
		}

	}

	private void agregarContactoSugerido4() {
		if(contactoSugeridoSeleccionado != null){
			agregarContactoGenerico(contactoSugeridoSeleccionado);

			tableContactosVendedor4.getItems().clear();
			tableContactosVendedor4.setItems(getListaContactosVendedor4Data());

			actualizarTablesSugeridos();
		}
	}

	/**
	 * Metodo que permite agregar un contacto buscado por medio de la seleccion de la tabla
	 */
	private void agregarContactoBusqueda4() {
		if(vendedorBuscadoSeleccionado != null){
			agregarContactoGenerico(vendedorBuscadoSeleccionado);


			tableContactosVendedor4.getItems().clear();
			tableContactosVendedor4.setItems(getListaContactosVendedor4Data());

			actualizarTablesSugeridos();
		}

	}

	//Busqueda vendedores
	private void buscarVendedores4() {
		String nombre = txtBuscarVendedor4.getText();

		if(nombre != null && nombre != ""){
			ArrayList<Vendedor> listaVendedoresEncontrados = new ArrayList<Vendedor>();
			listaVendedoresEncontrados = buscarVendedoresGenerico(nombre, listaVendedoresEncontrados);

			listaContactosEncontradosVendedor4Data.clear();
			listaContactosEncontradosVendedor4Data.addAll(listaVendedoresEncontrados);

			tableBusquedaContactos4.setItems(listaContactosEncontradosVendedor4Data);
		}
		else{
			mostrarMensaje("Notificacion Busqueda", "Busqueda no realizada", "Criterio de busqueda incorrecto", AlertType.INFORMATION);
		}

	}

	private void enviarMensajeVendedor4() {
		String mensaje = txtMensajesVendedor4.getText();

		if(mensaje != null && mensaje != ""){
			enviarMensajeVendedorGenerico(mensaje, codigoUsuario);
			txtMensajesVendedor4.setText("");
			setLabelsMensajes(codigoUsuario);
		}
		else{
			mostrarMensaje("Notificacion Envio Mensajes", "Mensaje no enviado", "Escriba un mensaje", AlertType.INFORMATION);
		}
	}
	
	
	//-----------------------------------------------Administracion de acciones para la pestaña de Vendedor 5-----------------------------------------------
	
	/**
	 * Metodo para agregar un producto para el vendedor 1
	 */
	private void agregarProductoVendedor5() {
		String nombre = txtNombreProductoVendedor5.getText();
		String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor5.getValue());
		String precio = txtPrecioProductoVendedor5.getText();
		String estado = obtenerEstadoProducto(comboBoxEstadoVendedor5.getValue());

		agregarProductoVendedorGenerico(nombre, categoria, precio, estado);
		tableProductosVendedor5.getItems().clear();
		tableProductosVendedor5.setItems(getListaProductosVendedor5Data());
		limpiarCamposTextoVendedor(txtNombreProductoVendedor5, txtPrecioProductoVendedor5);

	}

	private void actualizarProductoVendedor5() {
		if(productoSeleccionado != null){
			String nombre = txtNombreProductoVendedor5.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor5.getValue());
			String precio = txtPrecioProductoVendedor5.getText();
			String estado = obtenerEstadoProducto(comboBoxEstadoVendedor5.getValue());
			String cedulaVendedor = obtenerCedulaVendedorTabActivo();

			actualizarProductoVendedorGenerico(productoSeleccionado, cedulaVendedor, nombre, categoria, precio, estado);
			tableProductosVendedor5.getItems().clear();
			tableProductosVendedor5.setItems(getListaProductosVendedor5Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor5, txtPrecioProductoVendedor5);
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No actualizado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void publicarProductoVendedor5(){
		if(productoSeleccionado != null){
			publicarProductoVendedorGenerico(productoSeleccionado);

			tablePublicacionesVendedor5.getItems().clear();
			tablePublicacionesVendedor5.setItems(getListaPublicacionesVendedor5Data());
			tableProductosVendedor5.getItems().clear();
			tableProductosVendedor5.setItems(getListaProductosVendedor5Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No realizada", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void actualizarPublicacionVendedor5(){
		if(publicacionSeleccionada != null){
			String nombre = txtNombreProductoVendedor5.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor5.getValue());
			String precio = txtPrecioProductoVendedor5.getText();
			String estado = obtenerEstadoProducto("Publicado");

			actualizarPublicacionGenerico(publicacionSeleccionada, nombre, categoria, precio, estado);
			tablePublicacionesVendedor5.getItems().clear();
			tablePublicacionesVendedor5.setItems(getListaPublicacionesVendedor5Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor5, txtPrecioProductoVendedor5);
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No eliminada", "Seleccione una publicacion", AlertType.INFORMATION);
		}
	}

	private void eliminarPublicacionVendedor5() {
		if(publicacionSeleccionada != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar la publicacion?")){
				eliminarPublicacionGenerico(publicacionSeleccionada);

				tablePublicacionesVendedor5.getItems().clear();
				tablePublicacionesVendedor5.setItems(getListaPublicacionesVendedor5Data());
				limpiarCamposTextoVendedor(txtNombreProductoVendedor5, txtPrecioProductoVendedor5);
			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void eliminarProductoVendedor5() {
		if(productoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el producto?")){

				eliminarProductoVendedorGenerico(productoSeleccionado);

				tableProductosVendedor5.getItems().clear();
				tableProductosVendedor5.setItems(getListaProductosVendedor5Data());

			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}

	}

	private void darLikePublicacionVendedor5() {
		if(publicacionSeleccionada != null){
			darLikePublicacionVendedorGenerico(publicacionSeleccionada, labelLikesPublicacionVendedor5, 4);

			tablePublicacionesVendedor5.getItems().clear();
			tablePublicacionesVendedor5.setItems(getListaPublicacionesVendedor5Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No likeada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	private void agregarComentarioPublicacionVendedor5() {
		if(publicacionSeleccionada != null){
			String comentario = txtComentarioPublicacionVendedor5.getText();

			if(comentario == null || comentario == ""){
				mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Agregue un comentario en el campo de texto de agregar comentario", AlertType.INFORMATION);
			}
			else{
				agregarComentarioPublicacionVendedorGenerico(publicacionSeleccionada, comentario, codigoUsuario, txtComentarioPublicacionVendedor5);

				tablePublicacionesVendedor5.getItems().clear();
				tablePublicacionesVendedor5.setItems(getListaPublicacionesVendedor5Data());
			}
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	//CRUD Contactos

	private void eliminarContactoVendedor5() {
		if(contactoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el contacto?")){
				eliminarContactoGenerico();
				tableContactosVendedor5.getItems().clear();
				tableContactosVendedor5.setItems(getListaContactosVendedor5Data());
				actualizarTablesSugeridos();

			}
		}
		else{
			mostrarMensaje("Notificacion Contacto", "Contacto No eliminado", "Seleccione un contacto", AlertType.INFORMATION);
		}

	}

	private void agregarContactoSugerido5() {
		if(contactoSugeridoSeleccionado != null){
			agregarContactoGenerico(contactoSugeridoSeleccionado);

			tableContactosVendedor5.getItems().clear();
			tableContactosVendedor5.setItems(getListaContactosVendedor5Data());

			actualizarTablesSugeridos();
		}
	}

	/**
	 * Metodo que permite agregar un contacto buscado por medio de la seleccion de la tabla
	 */
	private void agregarContactoBusqueda5() {
		if(vendedorBuscadoSeleccionado != null){
			agregarContactoGenerico(vendedorBuscadoSeleccionado);


			tableContactosVendedor5.getItems().clear();
			tableContactosVendedor5.setItems(getListaContactosVendedor5Data());

			actualizarTablesSugeridos();
		}

	}

	//Busqueda vendedores
	private void buscarVendedores5() {
		String nombre = txtBuscarVendedor5.getText();

		if(nombre != null && nombre != ""){
			ArrayList<Vendedor> listaVendedoresEncontrados = new ArrayList<Vendedor>();
			listaVendedoresEncontrados = buscarVendedoresGenerico(nombre, listaVendedoresEncontrados);

			listaContactosEncontradosVendedor5Data.clear();
			listaContactosEncontradosVendedor5Data.addAll(listaVendedoresEncontrados);

			tableBusquedaContactos5.setItems(listaContactosEncontradosVendedor5Data);
		}
		else{
			mostrarMensaje("Notificacion Busqueda", "Busqueda no realizada", "Criterio de busqueda incorrecto", AlertType.INFORMATION);
		}

	}

	private void enviarMensajeVendedor5() {
		String mensaje = txtMensajesVendedor5.getText();

		if(mensaje != null && mensaje != ""){
			enviarMensajeVendedorGenerico(mensaje, codigoUsuario);
			txtMensajesVendedor5.setText("");
			setLabelsMensajes(codigoUsuario);
		}
		else{
			mostrarMensaje("Notificacion Envio Mensajes", "Mensaje no enviado", "Escriba un mensaje", AlertType.INFORMATION);
		}
	}
	
	
	//-----------------------------------------------Administracion de acciones para la pestaña de Vendedor 6-----------------------------------------------

	/**
	 * Metodo para agregar un producto para el vendedor 1
	 */
	private void agregarProductoVendedor6() {
		String nombre = txtNombreProductoVendedor6.getText();
		String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor6.getValue());
		String precio = txtPrecioProductoVendedor6.getText();
		String estado = obtenerEstadoProducto(comboBoxEstadoVendedor6.getValue());

		agregarProductoVendedorGenerico(nombre, categoria, precio, estado);
		tableProductosVendedor6.getItems().clear();
		tableProductosVendedor6.setItems(getListaProductosVendedor6Data());
		limpiarCamposTextoVendedor(txtNombreProductoVendedor6, txtPrecioProductoVendedor6);

	}

	private void actualizarProductoVendedor6() {
		if(productoSeleccionado != null){
			String nombre = txtNombreProductoVendedor6.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor6.getValue());
			String precio = txtPrecioProductoVendedor6.getText();
			String estado = obtenerEstadoProducto(comboBoxEstadoVendedor6.getValue());
			String cedulaVendedor = obtenerCedulaVendedorTabActivo();

			actualizarProductoVendedorGenerico(productoSeleccionado, cedulaVendedor, nombre, categoria, precio, estado);
			tableProductosVendedor6.getItems().clear();
			tableProductosVendedor6.setItems(getListaProductosVendedor6Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor6, txtPrecioProductoVendedor6);
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No actualizado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void publicarProductoVendedor6(){
		if(productoSeleccionado != null){
			publicarProductoVendedorGenerico(productoSeleccionado);

			tablePublicacionesVendedor6.getItems().clear();
			tablePublicacionesVendedor6.setItems(getListaPublicacionesVendedor6Data());
			tableProductosVendedor6.getItems().clear();
			tableProductosVendedor6.setItems(getListaProductosVendedor6Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No realizada", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void actualizarPublicacionVendedor6(){
		if(publicacionSeleccionada != null){
			String nombre = txtNombreProductoVendedor6.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor6.getValue());
			String precio = txtPrecioProductoVendedor6.getText();
			String estado = obtenerEstadoProducto("Publicado");

			actualizarPublicacionGenerico(publicacionSeleccionada, nombre, categoria, precio, estado);
			tablePublicacionesVendedor6.getItems().clear();
			tablePublicacionesVendedor6.setItems(getListaPublicacionesVendedor6Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor6, txtPrecioProductoVendedor6);
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No eliminada", "Seleccione una publicacion", AlertType.INFORMATION);
		}
	}

	private void eliminarPublicacionVendedor6() {
		if(publicacionSeleccionada != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar la publicacion?")){
				eliminarPublicacionGenerico(publicacionSeleccionada);

				tablePublicacionesVendedor6.getItems().clear();
				tablePublicacionesVendedor6.setItems(getListaPublicacionesVendedor6Data());
				limpiarCamposTextoVendedor(txtNombreProductoVendedor6, txtPrecioProductoVendedor6);
			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void eliminarProductoVendedor6() {
		if(productoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el producto?")){

				eliminarProductoVendedorGenerico(productoSeleccionado);

				tableProductosVendedor6.getItems().clear();
				tableProductosVendedor6.setItems(getListaProductosVendedor6Data());

			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}

	}

	private void darLikePublicacionVendedor6() {
		if(publicacionSeleccionada != null){
			darLikePublicacionVendedorGenerico(publicacionSeleccionada, labelLikesPublicacionVendedor6, 5);

			tablePublicacionesVendedor6.getItems().clear();
			tablePublicacionesVendedor6.setItems(getListaPublicacionesVendedor6Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No likeada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	private void agregarComentarioPublicacionVendedor6() {
		if(publicacionSeleccionada != null){
			String comentario = txtComentarioPublicacionVendedor6.getText();

			if(comentario == null || comentario == ""){
				mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Agregue un comentario en el campo de texto de agregar comentario", AlertType.INFORMATION);
			}
			else{
				agregarComentarioPublicacionVendedorGenerico(publicacionSeleccionada, comentario, codigoUsuario, txtComentarioPublicacionVendedor6);

				tablePublicacionesVendedor6.getItems().clear();
				tablePublicacionesVendedor6.setItems(getListaPublicacionesVendedor6Data());
			}
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	//CRUD Contactos

	private void eliminarContactoVendedor6() {
		if(contactoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el contacto?")){
				eliminarContactoGenerico();
				tableContactosVendedor6.getItems().clear();
				tableContactosVendedor6.setItems(getListaContactosVendedor6Data());
				actualizarTablesSugeridos();
			}
		}
		else{
			mostrarMensaje("Notificacion Contacto", "Contacto No eliminado", "Seleccione un contacto", AlertType.INFORMATION);
		}

	}

	private void agregarContactoSugerido6() {
		if(contactoSugeridoSeleccionado != null){
			agregarContactoGenerico(contactoSugeridoSeleccionado);

			tableContactosVendedor6.getItems().clear();
			tableContactosVendedor6.setItems(getListaContactosVendedor6Data());

			actualizarTablesSugeridos();
		}
	}

	/**
	 * Metodo que permite agregar un contacto buscado por medio de la seleccion de la tabla
	 */
	private void agregarContactoBusqueda6() {
		if(vendedorBuscadoSeleccionado != null){
			agregarContactoGenerico(vendedorBuscadoSeleccionado);


			tableContactosVendedor6.getItems().clear();
			tableContactosVendedor6.setItems(getListaContactosVendedor6Data());

			actualizarTablesSugeridos();
		}

	}

	//Busqueda vendedores
	private void buscarVendedores6() {
		String nombre = txtBuscarVendedor6.getText();

		if(nombre != null && nombre != ""){
			ArrayList<Vendedor> listaVendedoresEncontrados = new ArrayList<Vendedor>();
			listaVendedoresEncontrados = buscarVendedoresGenerico(nombre, listaVendedoresEncontrados);

			listaContactosEncontradosVendedor6Data.clear();
			listaContactosEncontradosVendedor6Data.addAll(listaVendedoresEncontrados);

			tableBusquedaContactos6.setItems(listaContactosEncontradosVendedor6Data);
		}
		else{
			mostrarMensaje("Notificacion Busqueda", "Busqueda no realizada", "Criterio de busqueda incorrecto", AlertType.INFORMATION);
		}

	}

	private void enviarMensajeVendedor6() {
		String mensaje = txtMensajesVendedor6.getText();

		if(mensaje != null && mensaje != ""){
			enviarMensajeVendedorGenerico(mensaje, codigoUsuario);
			txtMensajesVendedor6.setText("");
			setLabelsMensajes(codigoUsuario);
		}
		else{
			mostrarMensaje("Notificacion Envio Mensajes", "Mensaje no enviado", "Escriba un mensaje", AlertType.INFORMATION);
		}
	}


	//-----------------------------------------------Administracion de acciones para la pestaña de Vendedor 7-----------------------------------------------

	/**
	 * Metodo para agregar un producto para el vendedor 7
	 */
	private void agregarProductoVendedor7() {
		String nombre = txtNombreProductoVendedor7.getText();
		String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor7.getValue());
		String precio = txtPrecioProductoVendedor7.getText();
		String estado = obtenerEstadoProducto(comboBoxEstadoVendedor7.getValue());

		agregarProductoVendedorGenerico(nombre, categoria, precio, estado);
		tableProductosVendedor7.getItems().clear();
		tableProductosVendedor7.setItems(getListaProductosVendedor7Data());
		limpiarCamposTextoVendedor(txtNombreProductoVendedor7, txtPrecioProductoVendedor7);

	}

	private void actualizarProductoVendedor7() {
		if(productoSeleccionado != null){
			String nombre = txtNombreProductoVendedor7.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor7.getValue());
			String precio = txtPrecioProductoVendedor7.getText();
			String estado = obtenerEstadoProducto(comboBoxEstadoVendedor7.getValue());
			String cedulaVendedor = obtenerCedulaVendedorTabActivo();

			actualizarProductoVendedorGenerico(productoSeleccionado, cedulaVendedor, nombre, categoria, precio, estado);
			tableProductosVendedor7.getItems().clear();
			tableProductosVendedor7.setItems(getListaProductosVendedor7Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor7, txtPrecioProductoVendedor7);
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No actualizado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void publicarProductoVendedor7(){
		if(productoSeleccionado != null){
			publicarProductoVendedorGenerico(productoSeleccionado);

			tablePublicacionesVendedor7.getItems().clear();
			tablePublicacionesVendedor7.setItems(getListaPublicacionesVendedor7Data());
			tableProductosVendedor7.getItems().clear();
			tableProductosVendedor7.setItems(getListaProductosVendedor7Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No realizada", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void actualizarPublicacionVendedor7(){
		if(publicacionSeleccionada != null){
			String nombre = txtNombreProductoVendedor7.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor7.getValue());
			String precio = txtPrecioProductoVendedor7.getText();
			String estado = obtenerEstadoProducto("Publicado");

			actualizarPublicacionGenerico(publicacionSeleccionada, nombre, categoria, precio, estado);
			tablePublicacionesVendedor7.getItems().clear();
			tablePublicacionesVendedor7.setItems(getListaPublicacionesVendedor7Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor7, txtPrecioProductoVendedor7);
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No eliminada", "Seleccione una publicacion", AlertType.INFORMATION);
		}
	}

	private void eliminarPublicacionVendedor7() {
		if(publicacionSeleccionada != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar la publicacion?")){
				eliminarPublicacionGenerico(publicacionSeleccionada);

				tablePublicacionesVendedor7.getItems().clear();
				tablePublicacionesVendedor7.setItems(getListaPublicacionesVendedor7Data());
				limpiarCamposTextoVendedor(txtNombreProductoVendedor7, txtPrecioProductoVendedor7);
			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void eliminarProductoVendedor7() {
		if(productoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el producto?")){

				eliminarProductoVendedorGenerico(productoSeleccionado);

				tableProductosVendedor7.getItems().clear();
				tableProductosVendedor7.setItems(getListaProductosVendedor7Data());

			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}

	}

	private void darLikePublicacionVendedor7() {
		if(publicacionSeleccionada != null){
			darLikePublicacionVendedorGenerico(publicacionSeleccionada, labelLikesPublicacionVendedor7, 6);

			tablePublicacionesVendedor7.getItems().clear();
			tablePublicacionesVendedor7.setItems(getListaPublicacionesVendedor7Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No likeada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	private void agregarComentarioPublicacionVendedor7() {
		if(publicacionSeleccionada != null){
			String comentario = txtComentarioPublicacionVendedor7.getText();

			if(comentario == null || comentario == ""){
				mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Agregue un comentario en el campo de texto de agregar comentario", AlertType.INFORMATION);
			}
			else{
				agregarComentarioPublicacionVendedorGenerico(publicacionSeleccionada, comentario, codigoUsuario, txtComentarioPublicacionVendedor7);

				tablePublicacionesVendedor7.getItems().clear();
				tablePublicacionesVendedor7.setItems(getListaPublicacionesVendedor7Data());
			}
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	//CRUD Contactos

	private void eliminarContactoVendedor7() {
		if(contactoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el contacto?")){
				eliminarContactoGenerico();
				tableContactosVendedor7.getItems().clear();
				tableContactosVendedor7.setItems(getListaContactosVendedor7Data());
				actualizarTablesSugeridos();

			}
		}
		else{
			mostrarMensaje("Notificacion Contacto", "Contacto No eliminado", "Seleccione un contacto", AlertType.INFORMATION);
		}

	}

	private void agregarContactoSugerido7() {
		if(contactoSugeridoSeleccionado != null){
			agregarContactoGenerico(contactoSugeridoSeleccionado);

			tableContactosVendedor7.getItems().clear();
			tableContactosVendedor7.setItems(getListaContactosVendedor7Data());

			actualizarTablesSugeridos();
		}
	}

	/**
	 * Metodo que permite agregar un contacto buscado por medio de la seleccion de la tabla
	 */
	private void agregarContactoBusqueda7() {
		if(vendedorBuscadoSeleccionado != null){
			agregarContactoGenerico(vendedorBuscadoSeleccionado);


			tableContactosVendedor7.getItems().clear();
			tableContactosVendedor7.setItems(getListaContactosVendedor7Data());

			actualizarTablesSugeridos();
		}

	}

	//Busqueda vendedores
	private void buscarVendedores7() {
		String nombre = txtBuscarVendedor7.getText();

		if(nombre != null && nombre != ""){
			ArrayList<Vendedor> listaVendedoresEncontrados = new ArrayList<Vendedor>();
			listaVendedoresEncontrados = buscarVendedoresGenerico(nombre, listaVendedoresEncontrados);

			listaContactosEncontradosVendedor7Data.clear();
			listaContactosEncontradosVendedor7Data.addAll(listaVendedoresEncontrados);

			tableBusquedaContactos7.setItems(listaContactosEncontradosVendedor7Data);
		}
		else{
			mostrarMensaje("Notificacion Busqueda", "Busqueda no realizada", "Criterio de busqueda incorrecto", AlertType.INFORMATION);
		}

	}

	private void enviarMensajeVendedor7() {
		String mensaje = txtMensajesVendedor7.getText();

		if(mensaje != null && mensaje != ""){
			enviarMensajeVendedorGenerico(mensaje, codigoUsuario);
			txtMensajesVendedor7.setText("");
			setLabelsMensajes(codigoUsuario);
		}
		else{
			mostrarMensaje("Notificacion Envio Mensajes", "Mensaje no enviado", "Escriba un mensaje", AlertType.INFORMATION);
		}
	}



	//-----------------------------------------------Administracion de acciones para la pestaña de Vendedor 8-----------------------------------------------

	/**
	 * Metodo para agregar un producto para el vendedor 8
	 */
	private void agregarProductoVendedor8() {
		String nombre = txtNombreProductoVendedor8.getText();
		String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor8.getValue());
		String precio = txtPrecioProductoVendedor8.getText();
		String estado = obtenerEstadoProducto(comboBoxEstadoVendedor8.getValue());

		agregarProductoVendedorGenerico(nombre, categoria, precio, estado);
		tableProductosVendedor8.getItems().clear();
		tableProductosVendedor8.setItems(getListaProductosVendedor8Data());
		limpiarCamposTextoVendedor(txtNombreProductoVendedor8, txtPrecioProductoVendedor8);

	}

	private void actualizarProductoVendedor8() {
		if(productoSeleccionado != null){
			String nombre = txtNombreProductoVendedor8.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor8.getValue());
			String precio = txtPrecioProductoVendedor8.getText();
			String estado = obtenerEstadoProducto(comboBoxEstadoVendedor8.getValue());
			String cedulaVendedor = obtenerCedulaVendedorTabActivo();

			actualizarProductoVendedorGenerico(productoSeleccionado, cedulaVendedor, nombre, categoria, precio, estado);
			tableProductosVendedor8.getItems().clear();
			tableProductosVendedor8.setItems(getListaProductosVendedor8Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor8, txtPrecioProductoVendedor8);
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No actualizado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void publicarProductoVendedor8(){
		if(productoSeleccionado != null){
			publicarProductoVendedorGenerico(productoSeleccionado);

			tablePublicacionesVendedor8.getItems().clear();
			tablePublicacionesVendedor8.setItems(getListaPublicacionesVendedor8Data());
			tableProductosVendedor8.getItems().clear();
			tableProductosVendedor8.setItems(getListaProductosVendedor8Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No realizada", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void actualizarPublicacionVendedor8(){
		if(publicacionSeleccionada != null){
			String nombre = txtNombreProductoVendedor8.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor8.getValue());
			String precio = txtPrecioProductoVendedor8.getText();
			String estado = obtenerEstadoProducto("Publicado");

			actualizarPublicacionGenerico(publicacionSeleccionada, nombre, categoria, precio, estado);
			tablePublicacionesVendedor8.getItems().clear();
			tablePublicacionesVendedor8.setItems(getListaPublicacionesVendedor8Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor8, txtPrecioProductoVendedor8);
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No eliminada", "Seleccione una publicacion", AlertType.INFORMATION);
		}
	}

	private void eliminarPublicacionVendedor8() {
		if(publicacionSeleccionada != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar la publicacion?")){
				eliminarPublicacionGenerico(publicacionSeleccionada);

				tablePublicacionesVendedor8.getItems().clear();
				tablePublicacionesVendedor8.setItems(getListaPublicacionesVendedor8Data());
				limpiarCamposTextoVendedor(txtNombreProductoVendedor8, txtPrecioProductoVendedor8);
			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void eliminarProductoVendedor8() {
		if(productoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el producto?")){

				eliminarProductoVendedorGenerico(productoSeleccionado);

				tableProductosVendedor8.getItems().clear();
				tableProductosVendedor8.setItems(getListaProductosVendedor8Data());

			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}

	}

	private void darLikePublicacionVendedor8() {
		if(publicacionSeleccionada != null){
			darLikePublicacionVendedorGenerico(publicacionSeleccionada, labelLikesPublicacionVendedor8, 7);

			tablePublicacionesVendedor8.getItems().clear();
			tablePublicacionesVendedor8.setItems(getListaPublicacionesVendedor8Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No likeada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	private void agregarComentarioPublicacionVendedor8() {
		if(publicacionSeleccionada != null){
			String comentario = txtComentarioPublicacionVendedor8.getText();

			if(comentario == null || comentario == ""){
				mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Agregue un comentario en el campo de texto de agregar comentario", AlertType.INFORMATION);
			}
			else{
				agregarComentarioPublicacionVendedorGenerico(publicacionSeleccionada, comentario, codigoUsuario, txtComentarioPublicacionVendedor8);

				tablePublicacionesVendedor8.getItems().clear();
				tablePublicacionesVendedor8.setItems(getListaPublicacionesVendedor8Data());
			}
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	//CRUD Contactos

	private void eliminarContactoVendedor8() {
		if(contactoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el contacto?")){
				eliminarContactoGenerico();
				tableContactosVendedor8.getItems().clear();
				tableContactosVendedor8.setItems(getListaContactosVendedor8Data());
				actualizarTablesSugeridos();

			}
		}
		else{
			mostrarMensaje("Notificacion Contacto", "Contacto No eliminado", "Seleccione un contacto", AlertType.INFORMATION);
		}

	}

	private void agregarContactoSugerido8() {
		if(contactoSugeridoSeleccionado != null){
			agregarContactoGenerico(contactoSugeridoSeleccionado);

			tableContactosVendedor8.getItems().clear();
			tableContactosVendedor8.setItems(getListaContactosVendedor8Data());

			actualizarTablesSugeridos();
		}
	}

	/**
	 * Metodo que permite agregar un contacto buscado por medio de la seleccion de la tabla
	 */
	private void agregarContactoBusqueda8() {
		if(vendedorBuscadoSeleccionado != null){
			agregarContactoGenerico(vendedorBuscadoSeleccionado);


			tableContactosVendedor8.getItems().clear();
			tableContactosVendedor8.setItems(getListaContactosVendedor8Data());

			actualizarTablesSugeridos();
		}

	}

	//Busqueda vendedores
	private void buscarVendedores8() {
		String nombre = txtBuscarVendedor8.getText();

		if(nombre != null && nombre != ""){
			ArrayList<Vendedor> listaVendedoresEncontrados = new ArrayList<Vendedor>();
			listaVendedoresEncontrados = buscarVendedoresGenerico(nombre, listaVendedoresEncontrados);

			listaContactosEncontradosVendedor8Data.clear();
			listaContactosEncontradosVendedor8Data.addAll(listaVendedoresEncontrados);

			tableBusquedaContactos8.setItems(listaContactosEncontradosVendedor8Data);
		}
		else{
			mostrarMensaje("Notificacion Busqueda", "Busqueda no realizada", "Criterio de busqueda incorrecto", AlertType.INFORMATION);
		}

	}

	private void enviarMensajeVendedor8() {
		String mensaje = txtMensajesVendedor8.getText();

		if(mensaje != null && mensaje != ""){
			enviarMensajeVendedorGenerico(mensaje, codigoUsuario);
			txtMensajesVendedor8.setText("");
			setLabelsMensajes(codigoUsuario);
		}
		else{
			mostrarMensaje("Notificacion Envio Mensajes", "Mensaje no enviado", "Escriba un mensaje", AlertType.INFORMATION);
		}
	}


	//-----------------------------------------------Administracion de acciones para la pestaña de Vendedor 9-----------------------------------------------

	/**
	 * Metodo para agregar un producto para el vendedor 9
	 */
	private void agregarProductoVendedor9() {
		String nombre = txtNombreProductoVendedor9.getText();
		String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor9.getValue());
		String precio = txtPrecioProductoVendedor9.getText();
		String estado = obtenerEstadoProducto(comboBoxEstadoVendedor9.getValue());

		agregarProductoVendedorGenerico(nombre, categoria, precio, estado);
		tableProductosVendedor9.getItems().clear();
		tableProductosVendedor9.setItems(getListaProductosVendedor9Data());
		limpiarCamposTextoVendedor(txtNombreProductoVendedor9, txtPrecioProductoVendedor9);

	}

	private void actualizarProductoVendedor9() {
		if(productoSeleccionado != null){
			String nombre = txtNombreProductoVendedor9.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor9.getValue());
			String precio = txtPrecioProductoVendedor9.getText();
			String estado = obtenerEstadoProducto(comboBoxEstadoVendedor9.getValue());
			String cedulaVendedor = obtenerCedulaVendedorTabActivo();

			actualizarProductoVendedorGenerico(productoSeleccionado, cedulaVendedor, nombre, categoria, precio, estado);
			tableProductosVendedor9.getItems().clear();
			tableProductosVendedor9.setItems(getListaProductosVendedor9Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor9, txtPrecioProductoVendedor9);
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No actualizado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void publicarProductoVendedor9(){
		if(productoSeleccionado != null){
			publicarProductoVendedorGenerico(productoSeleccionado);

			tablePublicacionesVendedor9.getItems().clear();
			tablePublicacionesVendedor9.setItems(getListaPublicacionesVendedor9Data());
			tableProductosVendedor9.getItems().clear();
			tableProductosVendedor9.setItems(getListaProductosVendedor9Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No realizada", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void actualizarPublicacionVendedor9(){
		if(publicacionSeleccionada != null){
			String nombre = txtNombreProductoVendedor9.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor9.getValue());
			String precio = txtPrecioProductoVendedor9.getText();
			String estado = obtenerEstadoProducto("Publicado");

			actualizarPublicacionGenerico(publicacionSeleccionada, nombre, categoria, precio, estado);
			tablePublicacionesVendedor9.getItems().clear();
			tablePublicacionesVendedor9.setItems(getListaPublicacionesVendedor9Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor9, txtPrecioProductoVendedor9);
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No eliminada", "Seleccione una publicacion", AlertType.INFORMATION);
		}
	}

	private void eliminarPublicacionVendedor9() {
		if(publicacionSeleccionada != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar la publicacion?")){
				eliminarPublicacionGenerico(publicacionSeleccionada);

				tablePublicacionesVendedor9.getItems().clear();
				tablePublicacionesVendedor9.setItems(getListaPublicacionesVendedor9Data());
				limpiarCamposTextoVendedor(txtNombreProductoVendedor9, txtPrecioProductoVendedor9);
			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void eliminarProductoVendedor9() {
		if(productoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el producto?")){

				eliminarProductoVendedorGenerico(productoSeleccionado);

				tableProductosVendedor9.getItems().clear();
				tableProductosVendedor9.setItems(getListaProductosVendedor9Data());

			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}

	}

	private void darLikePublicacionVendedor9() {
		if(publicacionSeleccionada != null){
			darLikePublicacionVendedorGenerico(publicacionSeleccionada, labelLikesPublicacionVendedor9, 8);

			tablePublicacionesVendedor9.getItems().clear();
			tablePublicacionesVendedor9.setItems(getListaPublicacionesVendedor9Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No likeada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	private void agregarComentarioPublicacionVendedor9() {
		if(publicacionSeleccionada != null){
			String comentario = txtComentarioPublicacionVendedor9.getText();

			if(comentario == null || comentario == ""){
				mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Agregue un comentario en el campo de texto de agregar comentario", AlertType.INFORMATION);
			}
			else{
				agregarComentarioPublicacionVendedorGenerico(publicacionSeleccionada, comentario, codigoUsuario, txtComentarioPublicacionVendedor9);

				tablePublicacionesVendedor9.getItems().clear();
				tablePublicacionesVendedor9.setItems(getListaPublicacionesVendedor9Data());
			}
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	//CRUD Contactos

	private void eliminarContactoVendedor9() {
		if(contactoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el contacto?")){
				eliminarContactoGenerico();
				tableContactosVendedor9.getItems().clear();
				tableContactosVendedor9.setItems(getListaContactosVendedor9Data());
				actualizarTablesSugeridos();

			}
		}
		else{
			mostrarMensaje("Notificacion Contacto", "Contacto No eliminado", "Seleccione un contacto", AlertType.INFORMATION);
		}

	}

	private void agregarContactoSugerido9() {
		if(contactoSugeridoSeleccionado != null){
			agregarContactoGenerico(contactoSugeridoSeleccionado);

			tableContactosVendedor9.getItems().clear();
			tableContactosVendedor9.setItems(getListaContactosVendedor9Data());

			actualizarTablesSugeridos();
		}
	}

	/**
	 * Metodo que permite agregar un contacto buscado por medio de la seleccion de la tabla
	 */
	private void agregarContactoBusqueda9() {
		if(vendedorBuscadoSeleccionado != null){
			agregarContactoGenerico(vendedorBuscadoSeleccionado);


			tableContactosVendedor9.getItems().clear();
			tableContactosVendedor9.setItems(getListaContactosVendedor9Data());

			actualizarTablesSugeridos();
		}

	}

	//Busqueda vendedores
	private void buscarVendedores9() {
		String nombre = txtBuscarVendedor9.getText();

		if(nombre != null && nombre != ""){
			ArrayList<Vendedor> listaVendedoresEncontrados = new ArrayList<Vendedor>();
			listaVendedoresEncontrados = buscarVendedoresGenerico(nombre, listaVendedoresEncontrados);

			listaContactosEncontradosVendedor9Data.clear();
			listaContactosEncontradosVendedor9Data.addAll(listaVendedoresEncontrados);

			tableBusquedaContactos9.setItems(listaContactosEncontradosVendedor9Data);
		}
		else{
			mostrarMensaje("Notificacion Busqueda", "Busqueda no realizada", "Criterio de busqueda incorrecto", AlertType.INFORMATION);
		}

	}

	private void enviarMensajeVendedor9() {
		String mensaje = txtMensajesVendedor9.getText();

		if(mensaje != null && mensaje != ""){
			enviarMensajeVendedorGenerico(mensaje, codigoUsuario);
			txtMensajesVendedor9.setText("");
			setLabelsMensajes(codigoUsuario);
		}
		else{
			mostrarMensaje("Notificacion Envio Mensajes", "Mensaje no enviado", "Escriba un mensaje", AlertType.INFORMATION);
		}
	}


	//-----------------------------------------------Administracion de acciones para la pestaña de Vendedor 10-----------------------------------------------

	/**
	 * Metodo para agregar un producto para el vendedor 10
	 */
	private void agregarProductoVendedor10() {
		String nombre = txtNombreProductoVendedor10.getText();
		String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor10.getValue());
		String precio = txtPrecioProductoVendedor10.getText();
		String estado = obtenerEstadoProducto(comboBoxEstadoVendedor10.getValue());

		agregarProductoVendedorGenerico(nombre, categoria, precio, estado);
		tableProductosVendedor10.getItems().clear();
		tableProductosVendedor10.setItems(getListaProductosVendedor10Data());
		limpiarCamposTextoVendedor(txtNombreProductoVendedor10, txtPrecioProductoVendedor10);

	}

	private void actualizarProductoVendedor10() {
		if(productoSeleccionado != null){
			String nombre = txtNombreProductoVendedor10.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor10.getValue());
			String precio = txtPrecioProductoVendedor10.getText();
			String estado = obtenerEstadoProducto(comboBoxEstadoVendedor10.getValue());
			String cedulaVendedor = obtenerCedulaVendedorTabActivo();

			actualizarProductoVendedorGenerico(productoSeleccionado, cedulaVendedor, nombre, categoria, precio, estado);
			tableProductosVendedor10.getItems().clear();
			tableProductosVendedor10.setItems(getListaProductosVendedor10Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor10, txtPrecioProductoVendedor10);
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No actualizado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void publicarProductoVendedor10(){
		if(productoSeleccionado != null){
			publicarProductoVendedorGenerico(productoSeleccionado);

			tablePublicacionesVendedor10.getItems().clear();
			tablePublicacionesVendedor10.setItems(getListaPublicacionesVendedor10Data());
			tableProductosVendedor10.getItems().clear();
			tableProductosVendedor10.setItems(getListaProductosVendedor10Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No realizada", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void actualizarPublicacionVendedor10(){
		if(publicacionSeleccionada != null){
			String nombre = txtNombreProductoVendedor10.getText();
			String categoria = obtenerCategoriaProducto(comboBoxCategoriaVendedor10.getValue());
			String precio = txtPrecioProductoVendedor10.getText();
			String estado = obtenerEstadoProducto("Publicado");

			actualizarPublicacionGenerico(publicacionSeleccionada, nombre, categoria, precio, estado);
			tablePublicacionesVendedor10.getItems().clear();
			tablePublicacionesVendedor10.setItems(getListaPublicacionesVendedor10Data());
			limpiarCamposTextoVendedor(txtNombreProductoVendedor10, txtPrecioProductoVendedor10);
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No eliminada", "Seleccione una publicacion", AlertType.INFORMATION);
		}
	}

	private void eliminarPublicacionVendedor10() {
		if(publicacionSeleccionada != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar la publicacion?")){
				eliminarPublicacionGenerico(publicacionSeleccionada);

				tablePublicacionesVendedor10.getItems().clear();
				tablePublicacionesVendedor10.setItems(getListaPublicacionesVendedor10Data());
				limpiarCamposTextoVendedor(txtNombreProductoVendedor10, txtPrecioProductoVendedor10);
			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}
	}

	private void eliminarProductoVendedor10() {
		if(productoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el producto?")){

				eliminarProductoVendedorGenerico(productoSeleccionado);

				tableProductosVendedor10.getItems().clear();
				tableProductosVendedor10.setItems(getListaProductosVendedor10Data());

			}
		}
		else{
			mostrarMensaje("Notificacion Producto", "Producto No eliminado", "Seleccione un producto", AlertType.INFORMATION);
		}

	}

	private void darLikePublicacionVendedor10() {
		if(publicacionSeleccionada != null){
			darLikePublicacionVendedorGenerico(publicacionSeleccionada, labelLikesPublicacionVendedor10, 9);

			tablePublicacionesVendedor10.getItems().clear();
			tablePublicacionesVendedor10.setItems(getListaPublicacionesVendedor10Data());
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No likeada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	private void agregarComentarioPublicacionVendedor10() {
		if(publicacionSeleccionada != null){
			String comentario = txtComentarioPublicacionVendedor10.getText();

			if(comentario == null || comentario == ""){
				mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Agregue un comentario en el campo de texto de agregar comentario", AlertType.INFORMATION);
			}
			else{
				agregarComentarioPublicacionVendedorGenerico(publicacionSeleccionada, comentario, codigoUsuario, txtComentarioPublicacionVendedor10);

				tablePublicacionesVendedor10.getItems().clear();
				tablePublicacionesVendedor10.setItems(getListaPublicacionesVendedor10Data());
			}
		}
		else{
			mostrarMensaje("Notificacion Publicacion", "Publicacion No comentada", "Seleccione una Publicacion", AlertType.INFORMATION);
		}

	}

	//CRUD Contactos

	private void eliminarContactoVendedor10() {
		if(contactoSeleccionado != null){
			if(mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el contacto?")){
				eliminarContactoGenerico();
				tableContactosVendedor10.getItems().clear();
				tableContactosVendedor10.setItems(getListaContactosVendedor10Data());
				actualizarTablesSugeridos();

			}
		}
		else{
			mostrarMensaje("Notificacion Contacto", "Contacto No eliminado", "Seleccione un contacto", AlertType.INFORMATION);
		}

	}

	private void agregarContactoSugerido10() {
		if(contactoSugeridoSeleccionado != null){
			agregarContactoGenerico(contactoSugeridoSeleccionado);

			tableContactosVendedor10.getItems().clear();
			tableContactosVendedor10.setItems(getListaContactosVendedor10Data());

			actualizarTablesSugeridos();
		}
	}

	/**
	 * Metodo que permite agregar un contacto buscado por medio de la seleccion de la tabla
	 */
	private void agregarContactoBusqueda10() {
		if(vendedorBuscadoSeleccionado != null){
			agregarContactoGenerico(vendedorBuscadoSeleccionado);


			tableContactosVendedor10.getItems().clear();
			tableContactosVendedor10.setItems(getListaContactosVendedor10Data());

			actualizarTablesSugeridos();
		}

	}

	//Busqueda vendedores
	private void buscarVendedores10() {
		String nombre = txtBuscarVendedor10.getText();

		if(nombre != null && nombre != ""){
			ArrayList<Vendedor> listaVendedoresEncontrados = new ArrayList<Vendedor>();
			listaVendedoresEncontrados = buscarVendedoresGenerico(nombre, listaVendedoresEncontrados);

			listaContactosEncontradosVendedor10Data.clear();
			listaContactosEncontradosVendedor10Data.addAll(listaVendedoresEncontrados);

			tableBusquedaContactos10.setItems(listaContactosEncontradosVendedor10Data);
		}
		else{
			mostrarMensaje("Notificacion Busqueda", "Busqueda no realizada", "Criterio de busqueda incorrecto", AlertType.INFORMATION);
		}

	}

	private void enviarMensajeVendedor10() {
		String mensaje = txtMensajesVendedor10.getText();

		if(mensaje != null && mensaje != ""){
			enviarMensajeVendedorGenerico(mensaje, codigoUsuario);
			txtMensajesVendedor10.setText("");
			setLabelsMensajes(codigoUsuario);
		}
		else{
			mostrarMensaje("Notificacion Envio Mensajes", "Mensaje no enviado", "Escriba un mensaje", AlertType.INFORMATION);
		}
	}


	
	//----------------------------------------------------------CRUD de producto y publicacion Genericos----------------------------------------------------------

	/**
	 * Metodo generico para agregar un producto a la lista de productos de cualquier vendedor
	 * @param nombre
	 * @param categoria
	 * @param precio
	 * @param estado
	 */
	private void agregarProductoVendedorGenerico(String nombre, String categoria, String precio, String estado) {

		if(datosValidosProducto(nombre, categoria, precio, estado)){
			String cedulaVendedor = obtenerCedulaVendedorTabActivo();
			boolean centinela     = crudProductoViewController.agregarProducto(cedulaVendedor, nombre, categoria, precio, estado, Date.valueOf(LocalDate.now()));
			
			if(centinela == true){
				modelFactoryController.guardarResourceXML();
				modelFactoryController.guardarArchivos();
				
				modelFactoryController.registrarAccionesSistema("Se creo un producto por el usuario con codigo "+codigoUsuario, 1, "Creacion");
				
				mostrarMensaje("Notificacion Producto", "Producto creado", "El Producto fue creado con exito", AlertType.INFORMATION);
			}
		}
		
	}

	/**
	 * Metodo para publicar un producto del vendedor
	 * @param productoSeleccionado 
	 */
	private void publicarProductoVendedorGenerico(Producto productoSeleccionado) {
		Date fechaPublicacion = Date.valueOf(LocalDate.now());
		String cedulaVendedor = obtenerCedulaVendedorTabActivo();
		boolean centinela     = crudPublicacionViewController.agregarPublicacion(cedulaVendedor, productoSeleccionado, fechaPublicacion, 0, "");

		if(centinela == true){
			modelFactoryController.guardarResourceXML();
			modelFactoryController.guardarArchivos();

			modelFactoryController.registrarAccionesSistema("Se realizo una publicacion por el usuario con codigo "+codigoUsuario, 1, "Publicacion");

			mostrarMensaje("Notificacion Publicacion", "Publicacion realizada", "Publicacion realizada con exito", AlertType.INFORMATION);
		}
		
	}
	
	private void actualizarProductoVendedorGenerico(Producto productoSeleccionado, String codigoUsuario, String nombre, String categoria, String precio, String estado) {
		if(datosValidosProducto(nombre, categoria, precio, estado)){
			boolean centinela = crudProductoViewController.actualizarProductoVendedor(productoSeleccionado, codigoUsuario, nombre, categoria, precio, estado, Date.valueOf(LocalDate.now()));
			
			if(centinela == true){
				modelFactoryController.guardarResourceXML();
				modelFactoryController.guardarArchivos();
				
				modelFactoryController.registrarAccionesSistema("Se realizo una actualizacion de un producto con codigo "+productoSeleccionado.getCodigo()+" por el usuario con codigo "+codigoUsuario, 1, "Actualizacion");
				
				mostrarMensaje("Notificacion Producto", "Producto Actualizado", "Producto actualizado con exito", AlertType.INFORMATION);
			}
			
		}
	}
	
	private void actualizarPublicacionGenerico(Publicacion publicacionSeleccionada, String nombre, String categoria, String precio, String estado) {
		if(datosValidosProducto(nombre, categoria, precio, estado)){
			String cedulaVendedor = obtenerCedulaVendedorTabActivo();
			boolean centinela     = crudPublicacionViewController.actualizarPublicacion(cedulaVendedor, publicacionSeleccionada, nombre, categoria, precio, estado, Date.valueOf(LocalDate.now()));
			
			if(centinela == true){
				modelFactoryController.guardarResourceXML();

				modelFactoryController.registrarAccionesSistema("Se realizo una actualizacion de una publicacion por el usuario con codigo "+codigoUsuario, 1, "Actualizacion");
				
				mostrarMensaje("Notificacion Publicacion", "Publicacion Actualizada", "Publicacion actualizada con exito", AlertType.INFORMATION);
				
			}
		}
	}
	
	private void eliminarPublicacionGenerico(Publicacion publicacionSeleccionada) {
		String cedulaVendedor = obtenerCedulaVendedorTabActivo();
		boolean centinela     = crudPublicacionViewController.eliminarPublicacion(cedulaVendedor, publicacionSeleccionada);
		
		if(centinela == true){
			modelFactoryController.guardarResourceXML();
			modelFactoryController.guardarArchivos();
			
			modelFactoryController.registrarAccionesSistema("Publicacion eliminada por el usuario con codigo "+codigoUsuario, 2, "Eliminacion");

			mostrarMensaje("Notificación Publicacion", "Publicacion eliminada", "La publicacion se ha eliminado con éxito", AlertType.INFORMATION);
		}
	}
	
	private void eliminarProductoVendedorGenerico(Producto productoSeleccionado) {
		String cedulaVendedor = obtenerCedulaVendedorTabActivo();
		String nombreProducto = productoSeleccionado.getNombre();
		boolean centinela     = crudProductoViewController.eliminarProducto(cedulaVendedor, productoSeleccionado);
		
		if(centinela == true){
			modelFactoryController.guardarResourceXML();
			modelFactoryController.guardarArchivos();
			
			modelFactoryController.registrarAccionesSistema("Producto "+nombreProducto+" eliminado por el usuario con codigo "+codigoUsuario, 2, "Eliminacion");

			mostrarMensaje("Notificación Producto", "Producto eliminado", "El producto se ha eliminado con éxito", AlertType.INFORMATION);
		}
	}
	
	private void darLikePublicacionVendedorGenerico(Publicacion publicacionSeleccionada, Label labelLikesPublicacionVendedor, int i) {
		boolean centinela = crudPublicacionViewController.darLikePublicacion(codigoUsuario, publicacionSeleccionada);
		
		if(centinela == true){
			modelFactoryController.guardarResourceXML();
			modelFactoryController.guardarArchivos();

			modelFactoryController.registrarAccionesSistema("Publicacion con codigo "+publicacionSeleccionada.getCodigo()+" likeada por el usuario con codigo "+codigoUsuario, 1, "Like");

			labelLikesPublicacionVendedor.setText(modelFactoryController.getNotificacionesLikesVendedor(i));

			mostrarMensaje("Notificación Publicacion", "Like", "Gracias por tu like", AlertType.INFORMATION);
		}
	}
	
	private void agregarComentarioPublicacionVendedorGenerico(Publicacion publicacionSeleccionada, String comentario,
			String codigoUsuario, TextField txtComentarioPublicacionVendedor) {
		
		crudPublicacionViewController.agregarComentarioPublicacion(publicacionSeleccionada, comentario, codigoUsuario);
		txtComentarioPublicacionVendedor.setText("");
		modelFactoryController.guardarResourceXML();
		modelFactoryController.guardarArchivos();
		
		modelFactoryController.registrarAccionesSistema("Publicacion con codigo "+publicacionSeleccionada.getCodigo()+" comentada por el usuario con codigo "+codigoUsuario, 1, "Creacion de comentario");
		
		mostrarMensaje("Notificación Publicacion", "Comentario agregado", "El comentario se ha agregado con éxito", AlertType.INFORMATION);
	}
	
	private void enviarMensajeVendedorGenerico(String mensaje, String codigoUsuario) {
		String cedulaReceptor = obtenerCedulaVendedorTabActivo();
		
		crudVendedorViewController.enviarMensajeVendedor(mensaje, codigoUsuario, cedulaReceptor);
		
		modelFactoryController.guardarResourceXML();
		
		modelFactoryController.registrarAccionesSistema("Mensaje enviado por el usuario con codigo "+codigoUsuario, 1, "Envio de mensajes");
		
		mostrarMensaje("Notificación Mensajes", "Mensaje enviado", "El mensaje se ha enviado con éxito", AlertType.INFORMATION);
	}
	
	//---------------------------------------------------------------CRUD Contactos Genericos-----------------------------------------------------------------------------
	
	private void eliminarContactoGenerico() {
		String nombreContacto = contactoSeleccionado.getNombre();
		String cedulaVendedor = obtenerCedulaVendedorTabActivo();
		boolean centinela     = crudContactosViewController.eliminarContactoVendedor(contactoSeleccionado, cedulaVendedor);
		
		if(centinela == true){
			modelFactoryController.guardarResourceXML();
			modelFactoryController.guardarArchivos();
			
			modelFactoryController.registrarAccionesSistema("Contacto "+nombreContacto+" eliminado por el usuario con codigo "+codigoUsuario, 2, "Eliminacion");
			
			mostrarMensaje("Notificación Contacto", "Contacto eliminado", "El contacto se eliminó con éxito", AlertType.WARNING);
		}
		
	}
	
	private void agregarContactoGenerico(Vendedor contactoSeleccionado) {
		String cedulaVendedor = obtenerCedulaVendedorTabActivo();
		boolean centinela     = crudContactosViewController.agregarContacto(contactoSeleccionado, cedulaVendedor);
		
		if(centinela == true){
			modelFactoryController.guardarResourceXML();
			modelFactoryController.guardarArchivos();
			
			modelFactoryController.registrarAccionesSistema("Contacto con codigo "+contactoSeleccionado.getCedula()+" agregado por el usuario con codigo "+codigoUsuario, 1, "Agregacion de contacto");
			
			mostrarMensaje("Notificación Contacto", "Contacto agregado", "El Contacto se ha agregado con éxito", AlertType.INFORMATION);
		}
		
	}
	
	//--------------------------------------------------------------Busqueda de vendedores----------------------------------------------------------------------
	
	private ArrayList<Vendedor> buscarVendedoresGenerico(String nombre, ArrayList<Vendedor> listaVendedoresEncontrados) {
		String cedulaVendedor = obtenerCedulaVendedorTabActivo();
		listaVendedoresEncontrados = crudContactosViewController.buscarVendedores(nombre, cedulaVendedor, listaVendedoresEncontrados);
		
		modelFactoryController.registrarAccionesSistema("Contacto "+nombre+" buscado por el usuario con codigo "+codigoUsuario, 1, "Busqueda");
		
		return listaVendedoresEncontrados;
	}
	
	//---------------------------------------------------------------Validacion de datos-------------------------------------------------------------------------

	/**
	 * Metodo para validar los datos ingresados por la interfaz para vendedor
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param direccion
	 * @param contraseña
	 * @return true si los datos son validos, false de otra manera
	 */
	private boolean datosValidosVendedor(String nombre, String apellido, String cedula,  String direccion, String contraseña) {

		String mensaje = "";

		if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n" ;

		if(apellido == null || apellido.equals(""))
			mensaje += "El apellido es invalido \n" ;

		if(cedula == null || cedula.equals(""))
			mensaje += "El documento es invalido \n" ;

		if(direccion == null || direccion.equals(""))
			mensaje += "La direccion es invalida \n" ;

		if(contraseña == null || contraseña.equals(""))
			mensaje += "La contraseña es invalida \n" ;

		if(mensaje.equals("")){
			return true;
		}
		else{
			mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, AlertType.WARNING);
			return false;
		}
	}
	
	/**
	 * Metodo para validar los datos de un producto
	 * @param nombre
	 * @param categoria
	 * @param precio
	 * @param estado
	 * @return true si los datos son validos, false de otra manera
	 */
	private boolean datosValidosProducto(String nombre, String categoria, String precio,  String estado) {

		String mensaje = "";

		if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n" ;

		if(categoria == null || categoria.equals(""))
			mensaje += "La categoria es invalida \n" ;

		if(precio == null || precio.equals(""))
			mensaje += "El precio es invalido \n" ;

		if(estado == null || estado.equals(""))
			mensaje += "El estado es invalido \n" ;

		if(mensaje.equals("")){
			return true;
		}
		else{
			mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, AlertType.WARNING);
			return false;
		}
	}
	
	//-------------------------------------------------------------Obtencion categoria y estado------------------------------------------------------------
	
	/**
	 * Metodo el cual obtiene la categoria de un producto para la utilizacion del comboBox
	 * @param categoria
	 * @return string categoria
	 */
	private String obtenerCategoriaProducto(String categoria) {
		if(categoria != null){
			if(categoria.equalsIgnoreCase("Mueble")){
				return "0";
			}
			else{
				if(categoria.equalsIgnoreCase("Electrodomestico")){
					return "1";
				}
				else{
					return "2";
				}
			}
		}
		else{
			return null;
		}
	}
	
	/**
	 * Metodo el cual obtiene el estado de un producto para la utilizacion del comboBox
	 * @param estado
	 * @return string estado
	 */
	private String obtenerEstadoProducto(String estado) {
		if(estado != null){
			if(estado.equalsIgnoreCase("Vendido")){
				return "0";
			}
			else{
				if(estado.equalsIgnoreCase("Publicado")){
					return "1";
				}
				else{
					return "2";
				}
			}
		}
		else{
			return null;
		}
	}
	
	private String obtenerTextoCategoriaProducto(Categoria categoria){
		return modelFactoryController.obtenerTextoCategoriaProducto(categoria);
	}
	
	private String obtenerTextoEstadoProducto(Estado estado){
		return modelFactoryController.obtenerTextoEstadoProducto(estado);
	}
	
	

	//--------------------------------------------------------------Utilidades---------------------------------------------------------------------------

	/**
	 * Metodo para mostrar un mensaje de confirmacion
	 * @param mensaje
	 * @return
	 */
	private boolean mostrarMensajeConfirmacion(String mensaje) {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Confirmación");
		alert.setContentText(mensaje);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
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

	/**
	 * Metodo invocado para que Limpie los campos de texto en los campos de deposito
	 */
	private void limpiarCamposTextoAdmin() {

		txtNombreVendedorAdmin.setText("");
		txtApellidoVendedorAdmin.setText("");
		txtCedulaVendedorAdmin.setText("");
		txtDireccionVendedorAdmin.setText("");
		passTxtContraseñaVendedorAdmin.setText("");

	}
	
	private void limpiarCamposTextoVendedor(TextField txtNombreProductoVendedor, TextField txtPrecioProductoVendedor) {
		txtNombreProductoVendedor.setText("");
		txtPrecioProductoVendedor.setText("");
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Setea la aplicacion, codigo del usuario y los items de las tablas
	 * @param aplicacion
	 * @param codigoUsuario 
	 */
	public void setAplicacion(Aplicacion aplicacion, String codigoUsuario) {
		this.aplicacion = aplicacion;
		this.codigoUsuario = codigoUsuario;
		
		setItemsTables();
		setLabelsNotificaciones();
		setLabelsMensajes(codigoUsuario);
		setReportesAdmin();
		inhabilitarFunciones();
	}
	
	//-----------------------------------------------
	
	private void setReportesAdmin() {
		labelCantidadProductosPublicadosVendedores.setText(modelFactoryController.obtenerCantidadProductosPublicadosVendedores());
		labelCantidadContactosVendedores.setText(modelFactoryController.obtenerCantidadContactosVendedores());
		labelTop10ProductosMasLikeados.setText(modelFactoryController.obtenerTopProductosMasLikeados());
	}

	private void setItemsTables() {
		//table vendedores en admin
		tableVendedoresAdmin.setItems(getListaVendedoresData());
		
		//tables de la pestaña de vendedor 1
		tableProductosVendedor1.setItems(getListaProductosVendedor1Data());
		tablePublicacionesVendedor1.setItems(getListaPublicacionesVendedor1Data());
		tableContactosVendedor1.setItems(getListaContactosVendedor1Data());
		tableSugeridosVendedor1.setItems(getListaSugeridosVendedor1Data());
		
		//tables de la pestaña de vendedor 2
		tableProductosVendedor2.setItems(getListaProductosVendedor2Data());
		tablePublicacionesVendedor2.setItems(getListaPublicacionesVendedor2Data());
		tableContactosVendedor2.setItems(getListaContactosVendedor2Data());
		tableSugeridosVendedor2.setItems(getListaSugeridosVendedor2Data());
		
		//tables de la pestaña de vendedor 3
		tableProductosVendedor3.setItems(getListaProductosVendedor3Data());
		tablePublicacionesVendedor3.setItems(getListaPublicacionesVendedor3Data());
		tableContactosVendedor3.setItems(getListaContactosVendedor3Data());
		tableSugeridosVendedor3.setItems(getListaSugeridosVendedor3Data());

		//tables de la pestaña de vendedor 4
		tableProductosVendedor4.setItems(getListaProductosVendedor4Data());
		tablePublicacionesVendedor4.setItems(getListaPublicacionesVendedor4Data());
		tableContactosVendedor4.setItems(getListaContactosVendedor4Data());
		tableSugeridosVendedor4.setItems(getListaSugeridosVendedor4Data());
		
		//tables de la pestaña de vendedor 5
		tableProductosVendedor5.setItems(getListaProductosVendedor5Data());
		tablePublicacionesVendedor5.setItems(getListaPublicacionesVendedor5Data());
		tableContactosVendedor5.setItems(getListaContactosVendedor5Data());
		tableSugeridosVendedor5.setItems(getListaSugeridosVendedor5Data());
		
		//tables de la pestaña de vendedor 6
		tableProductosVendedor6.setItems(getListaProductosVendedor6Data());
		tablePublicacionesVendedor6.setItems(getListaPublicacionesVendedor6Data());
		tableContactosVendedor6.setItems(getListaContactosVendedor6Data());
		tableSugeridosVendedor6.setItems(getListaSugeridosVendedor6Data());

		//tables de la pestaña de vendedor 7
		tableProductosVendedor7.setItems(getListaProductosVendedor7Data());
		tablePublicacionesVendedor7.setItems(getListaPublicacionesVendedor7Data());
		tableContactosVendedor7.setItems(getListaContactosVendedor7Data());
		tableSugeridosVendedor7.setItems(getListaSugeridosVendedor7Data());

		//tables de la pestaña de vendedor 8
		tableProductosVendedor8.setItems(getListaProductosVendedor8Data());
		tablePublicacionesVendedor8.setItems(getListaPublicacionesVendedor8Data());
		tableContactosVendedor8.setItems(getListaContactosVendedor8Data());
		tableSugeridosVendedor8.setItems(getListaSugeridosVendedor8Data());

		//tables de la pestaña de vendedor 9
		tableProductosVendedor9.setItems(getListaProductosVendedor9Data());
		tablePublicacionesVendedor9.setItems(getListaPublicacionesVendedor9Data());
		tableContactosVendedor9.setItems(getListaContactosVendedor9Data());
		tableSugeridosVendedor9.setItems(getListaSugeridosVendedor9Data());

		//tables de la pestaña de vendedor 10
		tableProductosVendedor10.setItems(getListaProductosVendedor10Data());
		tablePublicacionesVendedor10.setItems(getListaPublicacionesVendedor10Data());
		tableContactosVendedor10.setItems(getListaContactosVendedor10Data());
		tableSugeridosVendedor10.setItems(getListaSugeridosVendedor10Data());
		
	}
	

	//-----------------------------------------------Set texto en los labels de notificaciones de likes--------------------------------
	
	private void setLabelsNotificaciones() {
		//Vendedor 1
		labelLikesPublicacionVendedor1.setText(getNotificacionesLikesVendedor(0));

		//Vendedor 2
		labelLikesPublicacionVendedor2.setText(getNotificacionesLikesVendedor(1));
		
		//Vendedor 3
		labelLikesPublicacionVendedor3.setText(getNotificacionesLikesVendedor(2));

		//Vendedor 4
		labelLikesPublicacionVendedor4.setText(getNotificacionesLikesVendedor(3));
		
		//Vendedor 5
		labelLikesPublicacionVendedor5.setText(getNotificacionesLikesVendedor(4));
		
		//Vendedor 6
		labelLikesPublicacionVendedor6.setText(getNotificacionesLikesVendedor(5));

		//Vendedor 7
		labelLikesPublicacionVendedor7.setText(getNotificacionesLikesVendedor(6));

		//Vendedor 8
		labelLikesPublicacionVendedor8.setText(getNotificacionesLikesVendedor(7));

		//Vendedor 9
		labelLikesPublicacionVendedor9.setText(getNotificacionesLikesVendedor(8));

		//Vendedor 10
		labelLikesPublicacionVendedor10.setText(getNotificacionesLikesVendedor(9));
	}
	
	private void setLabelsMensajes(String codigoUsuario) {
		String tipoUsuario = modelFactoryController.obtenerTipoUsuario(codigoUsuario);
		
		if(tipoUsuario.equalsIgnoreCase("Vendedor")){
			int i = obtenerPosicion();
			setLabelMensajesVendedor(i);
		}
		else{
			if(tipoUsuario.equalsIgnoreCase("Administrador")){
				setLabelMensajesVendedores();
			}
		}

	}
	
	private void setLabelMensajesVendedor(int i) {
		switch (i) {
		case 1:
			labelMensajesVendedor1.setText(getMensajesVendedor(0));
			break;
			
		case 2:
			labelMensajesVendedor2.setText(getMensajesVendedor(1));
			break;
			
		case 3:
			labelMensajesVendedor3.setText(getMensajesVendedor(2));
			break;
			
		case 4:
			labelMensajesVendedor4.setText(getMensajesVendedor(3));
			break;
			
		case 5:
			labelMensajesVendedor5.setText(getMensajesVendedor(4));
			break;
			
		case 6:
			labelMensajesVendedor6.setText(getMensajesVendedor(5));
			break;
			
		case 7:
			labelMensajesVendedor7.setText(getMensajesVendedor(6));
			break;
			
		case 8:
			labelMensajesVendedor8.setText(getMensajesVendedor(7));
			break;
			
		case 9:
			labelMensajesVendedor9.setText(getMensajesVendedor(8));
			break;
			
		case 10:
			labelMensajesVendedor10.setText(getMensajesVendedor(9));
			break;

		default:
			break;
		}
		
	}

	private void setLabelMensajesVendedores() {
		//Vendedor 1
		labelMensajesVendedor1.setText(getMensajesVendedor(0));
		//Vendedor 2
		labelMensajesVendedor2.setText(getMensajesVendedor(1));
		//Vendedor 3
		labelMensajesVendedor3.setText(getMensajesVendedor(2));
		//Vendedor 4
		labelMensajesVendedor4.setText(getMensajesVendedor(3));
		//Vendedor 5
		labelMensajesVendedor5.setText(getMensajesVendedor(4));
		//Vendedor 6
		labelMensajesVendedor6.setText(getMensajesVendedor(5));
		//Vendedor 7
		labelMensajesVendedor7.setText(getMensajesVendedor(6));
		//Vendedor 8
		labelMensajesVendedor8.setText(getMensajesVendedor(7));
		//Vendedor 9
		labelMensajesVendedor9.setText(getMensajesVendedor(8));
		//Vendedor 10
		labelMensajesVendedor10.setText(getMensajesVendedor(9));
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	private String getNotificacionesLikesVendedor(int i) {
		return modelFactoryController.getNotificacionesLikesVendedor(i);
	}
	
	private String getMensajesVendedor(int i) {
		return modelFactoryController.getMensajesVendedor(i);
	}
	
	private void limpiarCamposComentarios(){
		labelComentariosPublicacionVendedor1.setText("");
		labelComentariosPublicacionVendedor2.setText("");
		labelComentariosPublicacionVendedor3.setText("");
		labelComentariosPublicacionVendedor4.setText("");
		labelComentariosPublicacionVendedor5.setText("");
		labelComentariosPublicacionVendedor6.setText("");
		labelComentariosPublicacionVendedor7.setText("");
		labelComentariosPublicacionVendedor8.setText("");
		labelComentariosPublicacionVendedor9.setText("");
		labelComentariosPublicacionVendedor10.setText("");
	}
	
	//-----------------------------------------------------------Actualizar Tables------------------------------------------------------------------

	/**
	 * actualiza todos los tables de la GUI
	 */
	private void actualizarTables() {
		
		//Vendedor 1
		tableProductosVendedor1.getItems().clear();
		tableProductosVendedor1.setItems(getListaProductosVendedor1Data());
		
		tablePublicacionesVendedor1.getItems().clear();
		tablePublicacionesVendedor1.setItems(getListaPublicacionesVendedor1Data());
		
		tableContactosVendedor1.getItems().clear();
		tableContactosVendedor1.setItems(getListaContactosVendedor1Data());
		
		tableSugeridosVendedor1.getItems().clear();
		tableSugeridosVendedor1.setItems(getListaSugeridosVendedor1Data());
		
		labelLikesPublicacionVendedor1.setText(getNotificacionesLikesVendedor(0));
		labelMensajesVendedor1.setText(getMensajesVendedor(0));
		
		//Vendedor 2
		tableProductosVendedor2.getItems().clear();
		tableProductosVendedor2.setItems(getListaProductosVendedor2Data());
		
		tablePublicacionesVendedor2.getItems().clear();
		tablePublicacionesVendedor2.setItems(getListaPublicacionesVendedor2Data());
		
		tableContactosVendedor2.getItems().clear();
		tableContactosVendedor2.setItems(getListaContactosVendedor2Data());
		
		tableSugeridosVendedor2.getItems().clear();
		tableSugeridosVendedor2.setItems(getListaSugeridosVendedor2Data());
		
		labelLikesPublicacionVendedor2.setText(getNotificacionesLikesVendedor(1));
		labelMensajesVendedor2.setText(getMensajesVendedor(1));
		
		//Vendedor 3
		tableProductosVendedor3.getItems().clear();
		tableProductosVendedor3.setItems(getListaProductosVendedor3Data());

		tablePublicacionesVendedor3.getItems().clear();
		tablePublicacionesVendedor3.setItems(getListaPublicacionesVendedor3Data());

		tableContactosVendedor3.getItems().clear();
		tableContactosVendedor3.setItems(getListaContactosVendedor3Data());

		tableSugeridosVendedor3.getItems().clear();
		tableSugeridosVendedor3.setItems(getListaSugeridosVendedor3Data());

		labelLikesPublicacionVendedor3.setText(getNotificacionesLikesVendedor(2));
		labelMensajesVendedor3.setText(getMensajesVendedor(2));

		//Vendedor 4
		tableProductosVendedor4.getItems().clear();
		tableProductosVendedor4.setItems(getListaProductosVendedor4Data());

		tablePublicacionesVendedor4.getItems().clear();
		tablePublicacionesVendedor4.setItems(getListaPublicacionesVendedor4Data());

		tableContactosVendedor4.getItems().clear();
		tableContactosVendedor4.setItems(getListaContactosVendedor4Data());

		tableSugeridosVendedor4.getItems().clear();
		tableSugeridosVendedor4.setItems(getListaSugeridosVendedor4Data());

		labelLikesPublicacionVendedor4.setText(getNotificacionesLikesVendedor(3));
		labelMensajesVendedor4.setText(getMensajesVendedor(3));
		
		//Vendedor 5
		tableProductosVendedor5.getItems().clear();
		tableProductosVendedor5.setItems(getListaProductosVendedor5Data());

		tablePublicacionesVendedor5.getItems().clear();
		tablePublicacionesVendedor5.setItems(getListaPublicacionesVendedor5Data());

		tableContactosVendedor5.getItems().clear();
		tableContactosVendedor5.setItems(getListaContactosVendedor5Data());

		tableSugeridosVendedor5.getItems().clear();
		tableSugeridosVendedor5.setItems(getListaSugeridosVendedor5Data());

		labelLikesPublicacionVendedor5.setText(getNotificacionesLikesVendedor(4));
		labelMensajesVendedor5.setText(getMensajesVendedor(4));
		
		//Vendedor 6
		tableProductosVendedor6.getItems().clear();
		tableProductosVendedor6.setItems(getListaProductosVendedor6Data());

		tablePublicacionesVendedor6.getItems().clear();
		tablePublicacionesVendedor6.setItems(getListaPublicacionesVendedor6Data());

		tableContactosVendedor6.getItems().clear();
		tableContactosVendedor6.setItems(getListaContactosVendedor6Data());

		tableSugeridosVendedor6.getItems().clear();
		tableSugeridosVendedor6.setItems(getListaSugeridosVendedor6Data());

		labelLikesPublicacionVendedor6.setText(getNotificacionesLikesVendedor(5));
		labelMensajesVendedor6.setText(getMensajesVendedor(5));

		//Vendedor 7
		tableProductosVendedor7.getItems().clear();
		tableProductosVendedor7.setItems(getListaProductosVendedor7Data());

		tablePublicacionesVendedor7.getItems().clear();
		tablePublicacionesVendedor7.setItems(getListaPublicacionesVendedor7Data());

		tableContactosVendedor7.getItems().clear();
		tableContactosVendedor7.setItems(getListaContactosVendedor7Data());

		tableSugeridosVendedor7.getItems().clear();
		tableSugeridosVendedor7.setItems(getListaSugeridosVendedor7Data());

		labelLikesPublicacionVendedor7.setText(getNotificacionesLikesVendedor(6));
		labelMensajesVendedor7.setText(getMensajesVendedor(6));

		//Vendedor 8
		tableProductosVendedor8.getItems().clear();
		tableProductosVendedor8.setItems(getListaProductosVendedor8Data());

		tablePublicacionesVendedor8.getItems().clear();
		tablePublicacionesVendedor8.setItems(getListaPublicacionesVendedor8Data());

		tableContactosVendedor8.getItems().clear();
		tableContactosVendedor8.setItems(getListaContactosVendedor8Data());

		tableSugeridosVendedor8.getItems().clear();
		tableSugeridosVendedor8.setItems(getListaSugeridosVendedor8Data());

		labelLikesPublicacionVendedor8.setText(getNotificacionesLikesVendedor(7));
		labelMensajesVendedor8.setText(getMensajesVendedor(7));

		//Vendedor 9
		tableProductosVendedor9.getItems().clear();
		tableProductosVendedor9.setItems(getListaProductosVendedor9Data());

		tablePublicacionesVendedor9.getItems().clear();
		tablePublicacionesVendedor9.setItems(getListaPublicacionesVendedor9Data());

		tableContactosVendedor9.getItems().clear();
		tableContactosVendedor9.setItems(getListaContactosVendedor9Data());

		tableSugeridosVendedor9.getItems().clear();
		tableSugeridosVendedor9.setItems(getListaSugeridosVendedor9Data());

		labelLikesPublicacionVendedor9.setText(getNotificacionesLikesVendedor(8));
		labelMensajesVendedor9.setText(getMensajesVendedor(8));

		//Vendedor 10
		tableProductosVendedor10.getItems().clear();
		tableProductosVendedor10.setItems(getListaProductosVendedor10Data());

		tablePublicacionesVendedor10.getItems().clear();
		tablePublicacionesVendedor10.setItems(getListaPublicacionesVendedor10Data());

		tableContactosVendedor10.getItems().clear();
		tableContactosVendedor10.setItems(getListaContactosVendedor10Data());

		tableSugeridosVendedor10.getItems().clear();
		tableSugeridosVendedor10.setItems(getListaSugeridosVendedor10Data());

		labelLikesPublicacionVendedor10.setText(getNotificacionesLikesVendedor(9));
		labelMensajesVendedor10.setText(getMensajesVendedor(9));
		
	}
	
	private void actualizarTablesSugeridos(){
		//Vendedor 1
		tableSugeridosVendedor1.getItems().clear();
		tableSugeridosVendedor1.setItems(getListaSugeridosVendedor1Data());
		//Vendedor 2
		tableSugeridosVendedor2.getItems().clear();
		tableSugeridosVendedor2.setItems(getListaSugeridosVendedor2Data());
		//Vendedor 3
		tableSugeridosVendedor3.getItems().clear();
		tableSugeridosVendedor3.setItems(getListaSugeridosVendedor3Data());
		//Vendedor 4
		tableSugeridosVendedor4.getItems().clear();
		tableSugeridosVendedor4.setItems(getListaSugeridosVendedor4Data());
		//Vendedor 5
		tableSugeridosVendedor5.getItems().clear();
		tableSugeridosVendedor5.setItems(getListaSugeridosVendedor5Data());
		//Vendedor 6
		tableSugeridosVendedor6.getItems().clear();
		tableSugeridosVendedor6.setItems(getListaSugeridosVendedor6Data());
		//Vendedor 7
		tableSugeridosVendedor7.getItems().clear();
		tableSugeridosVendedor7.setItems(getListaSugeridosVendedor7Data());
		//Vendedor 8
		tableSugeridosVendedor8.getItems().clear();
		tableSugeridosVendedor8.setItems(getListaSugeridosVendedor8Data());
		//Vendedor 9
		tableSugeridosVendedor9.getItems().clear();
		tableSugeridosVendedor9.setItems(getListaSugeridosVendedor9Data());
		//Vendedor 5
		tableSugeridosVendedor10.getItems().clear();
		tableSugeridosVendedor10.setItems(getListaSugeridosVendedor10Data());
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Setea el stage (ventana del marketplace)
	 * @param primaryStage
	 * @param loginController
	 */
	public void setStage (Stage primaryStage, LoginController loginController) {
		this.loginController = loginController;
		this.stage = primaryStage;
	}
	
	/**
	 * Metodo para ejecutar el cierre de sesion del usuario actual de la aplicacion
	 */
	private void cerrarSesion(){
		loginController.stage.show();
		this.stage.close();
	}
	
	//-------------------------------------------------------------Obtencion de listas Data-------------------------------------------------------------------

	/**
	 * Obtiene la lista de vendedores data
	 * @return listVendedoresData
	 */
	public ObservableList<Vendedor> getListaVendedoresData(){
		listaVendedoresData.addAll(modelFactoryController.obtenerListaVendedores());
		return listaVendedoresData;
	}
	
	//Listas data vendedor 1
	
	private ObservableList<Producto> getListaProductosVendedor1Data() {
		listaProductosVendedor1Data.addAll(modelFactoryController.getListaProductosVendedor(0));
		return listaProductosVendedor1Data;
	}
	
	private ObservableList<Publicacion> getListaPublicacionesVendedor1Data() {
		listaPublicacionesVendedor1Data.addAll(modelFactoryController.getListaPublicacionesVendedor(0));
		return listaPublicacionesVendedor1Data;
	}
	
	private ObservableList<Vendedor> getListaContactosVendedor1Data() {
		listaContactosVendedor1Data.addAll(modelFactoryController.getListaContactosVendedor(0));
		return listaContactosVendedor1Data;
	}
	
	private ObservableList<Vendedor> getListaSugeridosVendedor1Data() {
		listaSugeridosVendedor1Data.addAll(modelFactoryController.getListaContactosSugeridosVendedor(0));
		return listaSugeridosVendedor1Data;
	}
	
	
	//Listas data vendedor 2
	
	private ObservableList<Producto> getListaProductosVendedor2Data() {
		listaProductosVendedor2Data.addAll(modelFactoryController.getListaProductosVendedor(1));
		return listaProductosVendedor2Data;
	}
	
	private ObservableList<Publicacion> getListaPublicacionesVendedor2Data() {
		listaPublicacionesVendedor2Data.addAll(modelFactoryController.getListaPublicacionesVendedor(1));
		return listaPublicacionesVendedor2Data;
	}
	
	private ObservableList<Vendedor> getListaContactosVendedor2Data() {
		listaContactosVendedor2Data.addAll(modelFactoryController.getListaContactosVendedor(1));
		return listaContactosVendedor2Data;
	}
	
	private ObservableList<Vendedor> getListaSugeridosVendedor2Data() {
		listaSugeridosVendedor2Data.addAll(modelFactoryController.getListaContactosSugeridosVendedor(1));
		return listaSugeridosVendedor2Data;
	}
	
	
	//Listas data vendedor 3

	private ObservableList<Producto> getListaProductosVendedor3Data() {
		listaProductosVendedor3Data.addAll(modelFactoryController.getListaProductosVendedor(2));
		return listaProductosVendedor3Data;
	}

	private ObservableList<Publicacion> getListaPublicacionesVendedor3Data() {
		listaPublicacionesVendedor3Data.addAll(modelFactoryController.getListaPublicacionesVendedor(2));
		return listaPublicacionesVendedor3Data;
	}

	private ObservableList<Vendedor> getListaContactosVendedor3Data() {
		listaContactosVendedor3Data.addAll(modelFactoryController.getListaContactosVendedor(2));
		return listaContactosVendedor3Data;
	}

	private ObservableList<Vendedor> getListaSugeridosVendedor3Data() {
		listaSugeridosVendedor3Data.addAll(modelFactoryController.getListaContactosSugeridosVendedor(2));
		return listaSugeridosVendedor3Data;
	}


	//Listas data vendedor 4

	private ObservableList<Producto> getListaProductosVendedor4Data() {
		listaProductosVendedor4Data.addAll(modelFactoryController.getListaProductosVendedor(3));
		return listaProductosVendedor4Data;
	}

	private ObservableList<Publicacion> getListaPublicacionesVendedor4Data() {
		listaPublicacionesVendedor4Data.addAll(modelFactoryController.getListaPublicacionesVendedor(3));
		return listaPublicacionesVendedor4Data;
	}

	private ObservableList<Vendedor> getListaContactosVendedor4Data() {
		listaContactosVendedor4Data.addAll(modelFactoryController.getListaContactosVendedor(3));
		return listaContactosVendedor4Data;
	}

	private ObservableList<Vendedor> getListaSugeridosVendedor4Data() {
		listaSugeridosVendedor4Data.addAll(modelFactoryController.getListaContactosSugeridosVendedor(3));
		return listaSugeridosVendedor4Data;
	}
	
	
	//Listas data vendedor 5

	private ObservableList<Producto> getListaProductosVendedor5Data() {
		listaProductosVendedor5Data.addAll(modelFactoryController.getListaProductosVendedor(4));
		return listaProductosVendedor5Data;
	}

	private ObservableList<Publicacion> getListaPublicacionesVendedor5Data() {
		listaPublicacionesVendedor5Data.addAll(modelFactoryController.getListaPublicacionesVendedor(4));
		return listaPublicacionesVendedor5Data;
	}

	private ObservableList<Vendedor> getListaContactosVendedor5Data() {
		listaContactosVendedor5Data.addAll(modelFactoryController.getListaContactosVendedor(4));
		return listaContactosVendedor5Data;
	}

	private ObservableList<Vendedor> getListaSugeridosVendedor5Data() {
		listaSugeridosVendedor5Data.addAll(modelFactoryController.getListaContactosSugeridosVendedor(4));
		return listaSugeridosVendedor5Data;
	}
	
	//Listas data vendedor 6
	
	private ObservableList<Producto> getListaProductosVendedor6Data() {
		listaProductosVendedor6Data.addAll(modelFactoryController.getListaProductosVendedor(5));
		return listaProductosVendedor6Data;
	}

	private ObservableList<Publicacion> getListaPublicacionesVendedor6Data() {
		listaPublicacionesVendedor6Data.addAll(modelFactoryController.getListaPublicacionesVendedor(5));
		return listaPublicacionesVendedor6Data;
	}

	private ObservableList<Vendedor> getListaContactosVendedor6Data() {
		listaContactosVendedor6Data.addAll(modelFactoryController.getListaContactosVendedor(5));
		return listaContactosVendedor6Data;
	}

	private ObservableList<Vendedor> getListaSugeridosVendedor6Data() {
		listaSugeridosVendedor6Data.addAll(modelFactoryController.getListaContactosSugeridosVendedor(5));
		return listaSugeridosVendedor6Data;
	}


	//Listas data vendedor 7

	private ObservableList<Producto> getListaProductosVendedor7Data() {
		listaProductosVendedor7Data.addAll(modelFactoryController.getListaProductosVendedor(6));
		return listaProductosVendedor7Data;
	}

	private ObservableList<Publicacion> getListaPublicacionesVendedor7Data() {
		listaPublicacionesVendedor7Data.addAll(modelFactoryController.getListaPublicacionesVendedor(6));
		return listaPublicacionesVendedor7Data;
	}

	private ObservableList<Vendedor> getListaContactosVendedor7Data() {
		listaContactosVendedor7Data.addAll(modelFactoryController.getListaContactosVendedor(6));
		return listaContactosVendedor7Data;
	}

	private ObservableList<Vendedor> getListaSugeridosVendedor7Data() {
		listaSugeridosVendedor7Data.addAll(modelFactoryController.getListaContactosSugeridosVendedor(6));
		return listaSugeridosVendedor7Data;
	}


	//Listas data vendedor 8

	private ObservableList<Producto> getListaProductosVendedor8Data() {
		listaProductosVendedor8Data.addAll(modelFactoryController.getListaProductosVendedor(7));
		return listaProductosVendedor8Data;
	}

	private ObservableList<Publicacion> getListaPublicacionesVendedor8Data() {
		listaPublicacionesVendedor8Data.addAll(modelFactoryController.getListaPublicacionesVendedor(7));
		return listaPublicacionesVendedor8Data;
	}

	private ObservableList<Vendedor> getListaContactosVendedor8Data() {
		listaContactosVendedor8Data.addAll(modelFactoryController.getListaContactosVendedor(7));
		return listaContactosVendedor8Data;
	}

	private ObservableList<Vendedor> getListaSugeridosVendedor8Data() {
		listaSugeridosVendedor8Data.addAll(modelFactoryController.getListaContactosSugeridosVendedor(7));
		return listaSugeridosVendedor8Data;
	}


	//Listas data vendedor 9

	private ObservableList<Producto> getListaProductosVendedor9Data() {
		listaProductosVendedor9Data.addAll(modelFactoryController.getListaProductosVendedor(8));
		return listaProductosVendedor9Data;
	}

	private ObservableList<Publicacion> getListaPublicacionesVendedor9Data() {
		listaPublicacionesVendedor9Data.addAll(modelFactoryController.getListaPublicacionesVendedor(8));
		return listaPublicacionesVendedor9Data;
	}

	private ObservableList<Vendedor> getListaContactosVendedor9Data() {
		listaContactosVendedor9Data.addAll(modelFactoryController.getListaContactosVendedor(8));
		return listaContactosVendedor9Data;
	}

	private ObservableList<Vendedor> getListaSugeridosVendedor9Data() {
		listaSugeridosVendedor9Data.addAll(modelFactoryController.getListaContactosSugeridosVendedor(8));
		return listaSugeridosVendedor9Data;
	}


	//Listas data vendedor 10

	private ObservableList<Producto> getListaProductosVendedor10Data() {
		listaProductosVendedor10Data.addAll(modelFactoryController.getListaProductosVendedor(9));
		return listaProductosVendedor10Data;
	}

	private ObservableList<Publicacion> getListaPublicacionesVendedor10Data() {
		listaPublicacionesVendedor10Data.addAll(modelFactoryController.getListaPublicacionesVendedor(9));
		return listaPublicacionesVendedor10Data;
	}

	private ObservableList<Vendedor> getListaContactosVendedor10Data() {
		listaContactosVendedor10Data.addAll(modelFactoryController.getListaContactosVendedor(9));
		return listaContactosVendedor10Data;
	}

	private ObservableList<Vendedor> getListaSugeridosVendedor10Data() {
		listaSugeridosVendedor10Data.addAll(modelFactoryController.getListaContactosSugeridosVendedor(9));
		return listaSugeridosVendedor10Data;
	}
	
	//----------------------------------------------------------Actions de reportes en administracion-----------------------------------------------
	
	/**
	 * Exporta archivos a la ruta elegida, tiene un tema y un contenido
	 * @param tema
	 * @param infoReporte 
	 */
	private void exportar(String tema, String infoReporte) {

		JFileChooser guardar = new JFileChooser();
		guardar.showSaveDialog(null);
		guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		File archivo     = guardar.getSelectedFile();
		String contenido = modelFactoryController.establecerPlantillaReporte(tema)+infoReporte;

		//Excepcion por si el usuario no selecciona un archivo
		try{
			modelFactoryController.guardarReportes(archivo.getPath(), contenido, false);
			mostrarMensaje("Notificacion Reporte", "Reporte exportado", "El reporte se ha exportado con exito", AlertType.INFORMATION);
		} catch (Exception e) {
			//Captura excepcion
			JOptionPane.showMessageDialog(null, "Archivo no seleccionado");
		}


	}
	
	// <--------------------------------------------------------Administracion de Tabs-------------------------------------------------------------->
	
	private void setTabs() {
		 String text = "";
		 setTabsPredeterminado();
		 
		 for (int i = 0; i < modelFactoryController.obtenerListaVendedores().size(); i++) {
			 
			 if(tabPaneGeneral.getTabs().size() > (i+1)){
				 text = modelFactoryController.getNombreVendedor(i)+":"+modelFactoryController.getCedulaVendedor(i);
				 tabPaneGeneral.getTabs().get(i+1).setText(text);
			 }

		 }
	 }

	private void setTabsPredeterminado() {
		for (int i = 1; i < tabPaneGeneral.getTabs().size(); i++) {
			Tab tabAux = tabPaneGeneral.getTabs().get(i);
			tabAux.setText("Vendedor "+i);
		}
		tabPaneGeneral.getTabs().get(0).setText("admin");
	}
	
	private void inhabilitarTabAdmin(){
		tabPaneGeneral.getTabs().get(0).setDisable(true);
	}
	 
	private String obtenerCedulaVendedorTabActivo() {
		//Obtiene la posicion del arraylist del tabPane general para así, obtener
		//la cedula o el codigo de la persona receptora del mensaje
		SingleSelectionModel<Tab> selectionModel = tabPaneGeneral.getSelectionModel();
		int i                                    = selectionModel.getSelectedIndex();
		Tab tab                                  = tabPaneGeneral.getTabs().get(i);
		String cedulaVendedor                    = tab.getText().split(":")[1];
		
		return cedulaVendedor;
	}

}

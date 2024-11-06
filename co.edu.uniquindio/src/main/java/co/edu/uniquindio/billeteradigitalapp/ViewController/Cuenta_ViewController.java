package co.edu.uniquindio.billeteradigitalapp.ViewController;

import co.edu.uniquindio.billeteradigitalapp.Controller.CuentaController;
import co.edu.uniquindio.billeteradigitalapp.Model.Cuenta;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Cuenta_ViewController {
    CuentaController cuentaController;
    Cuenta cuentaSelecionada;
    ObservableList<Cuenta> cuentasList = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnCrear;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableView<Cuenta> tableGestionCuenta;

    @FXML
    private TableColumn<Cuenta,String> tcIdCuenta;

    @FXML
    private TableColumn<Cuenta,String> tcNombreBanco;

    @FXML
    private TableColumn<Cuenta,String> tcNumeroCuenta;

    @FXML
    private TableColumn<Cuenta,String> tcTipoCuenta;

    @FXML
    private TextField txtIdCuenta;

    @FXML
    private TextField txtNombreBanco;

    @FXML
    private TextField txtNumeroCuenta;

    @FXML
    private TextField txtTipoCuenta;

    @FXML
    void OnbtnActualizar(ActionEvent event) {
        actualizarUsuario();
    }

    @FXML
    void OnbtnCrear(ActionEvent event) {
        crearCuenta();

    }

    @FXML
    void OnbtnEliminar(ActionEvent event) {
        eliminarCuenta(txtIdCuenta.getText());
    }

    @FXML
    void initialize() {
        cuentaController = new CuentaController();
        initView();
    }
    private void eliminarCuenta(String idCuenta) {
        if(cuentaSelecionada!=null){
            if(cuentaController.eliminarCuenta(idCuenta)){
                cuentasList.remove(cuentaSelecionada);
                limpiarCamposCuenta();
                mostrarMensaje("Información Cuenta", "Cuenta Eliminada", "La cuenta se ha eliminado correctamente", Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje("Información Cuenta", "Cuenta No Eliminada", "La cuenta no se  ha eliminado", Alert.AlertType.ERROR);
            }
        }else {
            mostrarMensaje("Información Cuenta", "Seleccione una cuenta", "Porfavor seleccione una cuenta para eliminar", Alert.AlertType.ERROR);
        }
    }

    private void limpiarCamposCuenta() {
        txtIdCuenta.clear();
        txtNombreBanco.clear();
        txtNumeroCuenta.clear();
        txtTipoCuenta.clear();
    }

    private void actualizarUsuario() {
        if(cuentaSelecionada != null) {
            if (validarFormulario()){
                if(txtIdCuenta.getText().equals(String.valueOf(cuentaSelecionada.getIdCuenta()))){
                    Cuenta cuenta=construirDatosCuenta();
                    if(cuentaController.actualizarCuenta(cuenta)){
                        mostrarMensaje("Información Cuenta", "Cuenta Actualizada", "La cuenta se actualizo correctamente.", Alert.AlertType.INFORMATION);
                        cuentaSelecionada.setNumeroCuenta(Integer.parseInt(txtNumeroCuenta.getText()));
                        cuentaSelecionada.setTipoCuenta(txtTipoCuenta.getText());
                        cuentaSelecionada.setNombreBanco(txtNombreBanco.getText());
                        tableGestionCuenta.refresh();
                    }else {
                        mostrarMensaje("Información Cuenta", "Problema Al Actualizar", "Ocurrio un problema al intentar actualizar la cuenta.", Alert.AlertType.ERROR);
                    }
                }else {
                    mostrarMensaje("Información Cuenta", "Dato No Modificable", "El idCuenta de la cuenta no se puede modificar.", Alert.AlertType.ERROR);
                }
            }else {
                mostrarMensaje("Información Cuenta", "Campos Vacíos", "Porfavor rellene los campos.", Alert.AlertType.ERROR);
            }
        }else {
            mostrarMensaje("Información Cuenta", "Seleccione una cuenta", "Porfavor seleccione la cuenta que desea actualizar.", Alert.AlertType.ERROR);
        }
    }

    private Cuenta construirDatosCuenta() {
        Cuenta cuenta=new Cuenta();
        cuenta.setIdCuenta(Integer.parseInt(txtIdCuenta.getText()));
        cuenta.setNombreBanco(txtNombreBanco.getText());
        cuenta.setNumeroCuenta(Integer.parseInt(txtNumeroCuenta.getText()));
        cuenta.setTipoCuenta(txtTipoCuenta.getText());
        return cuenta;
    }

    private boolean validarFormulario() {
        if(txtNombreBanco.getText().isEmpty()||txtNumeroCuenta.getText().isEmpty()||txtTipoCuenta.getText().isEmpty()||txtIdCuenta.getText().isEmpty()) {
            return false;
        }
        return true;
    }


    private void initView() {
        initDataBinding();
        obtenerCuentas();
        tableGestionCuenta.setItems(cuentasList);
        listenerSelection();
    }

    private void listenerSelection() {
        tableGestionCuenta.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            cuentaSelecionada= newSelection;
            mostrarInformacionCuenta(cuentaSelecionada);
        });
    }

    private void mostrarInformacionCuenta(Cuenta usuario) {
        if(cuentaSelecionada!=null){
            txtIdCuenta.setText(String.valueOf(cuentaSelecionada.getIdCuenta()));
            txtNombreBanco.setText(cuentaSelecionada.getNombreBanco());
            txtTipoCuenta.setText(cuentaSelecionada.getTipoCuenta());
            txtNumeroCuenta.setText(String.valueOf(cuentaSelecionada.getNumeroCuenta()));
        }
    }

    private void obtenerCuentas() {
        cuentasList.addAll(cuentaController.obtenerCuentas());
    }

    private void initDataBinding() {
        tcIdCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdCuenta())));
        tcNumeroCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumeroCuenta())));
        tcTipoCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoCuenta()));
        tcNombreBanco.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreBanco()));
    }

    private void crearCuenta() {
        if(validarDatos()){
            Cuenta cuenta= ConstrirCuenta();
            if(cuentaController.crearcuenta(cuenta)){
                cuentasList.add(cuenta);
                tableGestionCuenta.refresh();
                mostrarMensaje("Cuenta", "Cuenta agregada", "La cuenta se agrego correctamente", Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje("Error", "Error de Cuenta", "la cuenta ya Existe", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Error", "Error de Cuenta", "Ingrese todos los datos", Alert.AlertType.ERROR);
        }

    }

    private Cuenta ConstrirCuenta() {
        Cuenta cuenta= new Cuenta();
        cuenta.setNumeroCuenta(Integer.parseInt(txtNumeroCuenta.getText()));
        cuenta.setNombreBanco(txtNombreBanco.getText());
        cuenta.setTipoCuenta(txtTipoCuenta.getText());
        cuenta.setIdCuenta(Integer.parseInt(txtIdCuenta.getText()));
        return cuenta;
    }

    private boolean validarDatos() {
        if(txtIdCuenta.getText().isEmpty()||txtNombreBanco.getText().isEmpty()||txtNumeroCuenta.getText().isEmpty()||txtTipoCuenta.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.show();
    }

}




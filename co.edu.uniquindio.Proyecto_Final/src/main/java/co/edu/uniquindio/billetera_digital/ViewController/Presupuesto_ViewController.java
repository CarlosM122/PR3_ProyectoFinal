package co.edu.uniquindio.billetera_digital.ViewController;

import co.edu.uniquindio.billetera_digital.Controller.Presupuesto_Controller;
import co.edu.uniquindio.billetera_digital.Model.Presupuesto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Presupuesto_ViewController {
    Presupuesto seleccionarPresupuesto;
    Presupuesto_Controller presupuestoController;
    ObservableList<Presupuesto> presupuestosList= FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Presupuesto> TableGestionPresupuesto;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnCrear;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<Presupuesto, String> tcIdPresupuesto;

    @FXML
    private TableColumn<Presupuesto, String> tcMontoAsignado;

    @FXML
    private TableColumn<Presupuesto, String> tcMontoGastado;

    @FXML
    private TableColumn<Presupuesto, String> tcNombre;

    @FXML
    private TableColumn<Presupuesto, String> tcNumeroPresupuesto;

    @FXML
    private TextField txtIdPresupuesto;

    @FXML
    private TextField txtMontoAsignado;

    @FXML
    private TextField txtMontoGastado;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumeroPresupuesto;

    @FXML
    void OnbtnActualizar(ActionEvent event) {
        actualizarPresupuesto();
    }

    @FXML
    void OnbtnCrear(ActionEvent event) {
        crearPresupuesto();
    }

    @FXML
    void OnbtnEliminar(ActionEvent event) {
        eliminarPresupuesto(txtIdPresupuesto.getText());

    }

    @FXML
    void initialize() {
        presupuestoController= new Presupuesto_Controller();
        initView();
    }
    private void eliminarPresupuesto(String idPresupuesto) {
        if(seleccionarPresupuesto != null){
            if(presupuestoController.eliminarPresupuesto(idPresupuesto)){
                presupuestosList.remove(seleccionarPresupuesto);
                limpiarCamposPresupuesto();
                TableGestionPresupuesto.refresh();
                mostrarMensaje("Información Presupuesto", "Presupuesto Eliminado", "El Presupuesto se ha eliminado correctamente", Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje("Información Presupuesto", "Presupuesto No Eliminado", "El Presupuesto no se  ha eliminado", Alert.AlertType.ERROR);
            }
        }else {
            mostrarMensaje("Información Presupuesto", "Seleccione un Presupuesto", "Porfavor seleccione un Presupuesto para eliminar", Alert.AlertType.ERROR);
        }
    }

    private void actualizarPresupuesto() {
        if (seleccionarPresupuesto != null) {
            if (validarFormulario()) {
                if (txtIdPresupuesto.getText().equals(String.valueOf(seleccionarPresupuesto.getIdPresupuesto()))){
                    Presupuesto presupuesto = construirDatosPresupuesto();
                    if(presupuesto != null){
                        if(Presupuesto_Controller.actualizarPresupuesto(presupuesto)){
                            mostrarMensaje("Información Presupuesto", "Presupuesto Actualizado", "El presupuesto se actualizo correctamente.", Alert.AlertType.INFORMATION);
                            seleccionarPresupuesto.setMontoGastado(Double.parseDouble(txtMontoGastado.getText()));
                            seleccionarPresupuesto.setIdPresupuesto(Integer.parseInt(txtIdPresupuesto.getText()));
                            seleccionarPresupuesto.setNombre(txtNombre.getText());
                            seleccionarPresupuesto.setMontoTotalAsignado(Double.parseDouble(txtMontoAsignado.getText()));
                            TableGestionPresupuesto.refresh();
                    }else{
                            mostrarMensaje("Información Presupuesto", "Problema Al Actualizar", "Ocurrio un problema al intentar actualizar el Presupuesto.", Alert.AlertType.ERROR);
                        }
                    }else {
                        mostrarMensaje("Información Presupuesto", "Problema Al Crear", "Ocurrio un problema al intentar actualizar el Presupuesto.", Alert.AlertType.ERROR);
                    }
                }else {
                    mostrarMensaje("Información Presupuesto", "Dato No Modificable", "La cedula del Presupuesto no se puede modificar.", Alert.AlertType.ERROR);
                }
            }else {
                mostrarMensaje("Información Presupuesto", "Campos Vacíos", "Porfavor rellene los campos.", Alert.AlertType.ERROR);
            }
        }else {
            mostrarMensaje("Información Presupuesto", "Seleccione un Presupuesto", "Porfavor seleccione el Presupuesto que desea actualizar.", Alert.AlertType.ERROR);
        }
    }
    private void crearPresupuesto() {
        if (validarFormulario()) {
            Presupuesto presupuesto = construirDatosPresupuesto();
            if (presupuesto != null) {
                if (presupuestoController.crearPresupuesto(presupuesto)) {
                    presupuestosList.add(presupuesto);
                    mostrarMensaje("Información Presupuesto", "Presupuesto Creado", "El presupuesto se creó correctamente", Alert.AlertType.INFORMATION);
                    limpiarCamposPresupuesto();
                } else {
                    mostrarMensaje("Información Presupuesto", "Presupuesto No Creado", "Hubo un problema al crear el presupuesto", Alert.AlertType.ERROR);
                }
            } else {
                mostrarMensaje("Información Presupuesto", "Datos Inválidos", "Por favor ingrese datos válidos para el presupuesto", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Información Presupuesto", "Campos Vacíos", "Por favor complete todos los campos obligatorios", Alert.AlertType.ERROR);
        }
    }

    private void limpiarCamposPresupuesto() {
        txtIdPresupuesto.clear();
        txtMontoAsignado.clear();
        txtMontoGastado.clear();
        txtNombre.clear();

    }

    private Presupuesto construirDatosPresupuesto() {
        Presupuesto presupuesto = new Presupuesto();
        presupuesto.setNombre(txtNombre.getText());
        try {
            presupuesto.setIdPresupuesto(Integer.parseInt(txtIdPresupuesto.getText()));
            presupuesto.setMontoTotalAsignado(Double.parseDouble(txtMontoAsignado.getText()));
            presupuesto.setMontoGastado(Double.parseDouble(txtMontoGastado.getText()));
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingresa números válidos.");
            return null;
        }
        return presupuesto;
    }

    private boolean validarFormulario() {
        if(txtNombre.getText().isEmpty()||txtIdPresupuesto.getText().isEmpty()||txtMontoAsignado.getText().isEmpty()||txtMontoGastado.getText().isEmpty()){
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

    private void initView() {
        obtenerPresupuestos();
        TableGestionPresupuesto.setItems(presupuestosList);
        initDataBinding();
        listenerSelection();
    }

    private void listenerSelection() {
        TableGestionPresupuesto.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            seleccionarPresupuesto = newSelection;
            mostrarInformacionUsuario(seleccionarPresupuesto);
        });
    }

    private void mostrarInformacionUsuario(Presupuesto seleccionarPresupuesto) {
        if(seleccionarPresupuesto!=null){
            txtNombre.setText(seleccionarPresupuesto.getNombre());
            txtMontoAsignado.setText(Double.toString(seleccionarPresupuesto.getMontoTotalAsignado()));
            txtMontoGastado.setText(Double.toString(seleccionarPresupuesto.getMontoGastado()));
            txtIdPresupuesto.setText(String.valueOf(seleccionarPresupuesto.getIdPresupuesto()));

        }
    }

    private void obtenerPresupuestos() {
        presupuestosList.addAll(presupuestoController.obtenerPresupuestos());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcIdPresupuesto.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdPresupuesto())));
        tcMontoAsignado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getMontoTotalAsignado())));
        tcMontoGastado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getMontoGastado())));
    }
}

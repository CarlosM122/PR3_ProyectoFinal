package co.edu.uniquindio.billetera_digital.Utils;

import co.edu.uniquindio.billetera_digital.Model.BilleteraDigital;
import co.edu.uniquindio.billetera_digital.Model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Persistencia {


    //bancoUq/src/main/resources/persistencia/archivoClientes.txt
    public static final String RUTA_ARCHIVO_USUARIOS = "C:\\Users\\ASUS\\Desktop\\Programacion 2024-2\\ProyectoFinal\\PR3_ProyectoFinal\\co.edu.uniquindio.Proyecto_Final\\src\\main\\resources\\persistencia\\archivos\\archivoUsuarios.txt";
    public static final String RUTA_ARCHIVO_EMPLEADOS = "src/main/resources/persistencia/archivoEmpleados.txt";
    public static final String RUTA_ARCHIVO_CUENTAS = "/src/main/resources/persistencia/archivoUsuarios.txt.txt";
    public static final String RUTA_ARCHIVO_LOG = "C:\\Users\\ASUS\\Desktop\\Programacion 2024-2\\ProyectoFinal\\PR3_ProyectoFinal\\co.edu.uniquindio.Proyecto_Final\\src\\main\\resources\\persistencia\\log\\BilleteraLog.txt";
    public static final String RUTA_ARCHIVO_OBJETOS = "co.edu.uniquindio.programacion3/src/main/resources/persistencia/archivoObjetos.txt";
    public static final String RUTA_ARCHIVO_MODELO_BILLETERADIGITAL_BINARIO = "C:\\Users\\ASUS\\Desktop\\Programacion 2024-2\\ProyectoFinal\\PR3_ProyectoFinal\\co.edu.uniquindio.Proyecto_Final\\src\\main\\resources\\persistencia\\model.dat";
    public static final String RUTA_ARCHIVO_MODELO_BILLETERA_DIGITAL_XML = "C:\\Users\\ASUS\\Desktop\\Programacion 2024-2\\ProyectoFinal\\PR3_ProyectoFinal\\co.edu.uniquindio.Proyecto_Final\\src\\main\\resources\\persistencia\\model.xml";
//	C:\td\persistencia


    public static void cargarDatosArchivos(BilleteraDigital billeteraDigital) throws FileNotFoundException, IOException {
        ArrayList<Usuario> usuariosCargados = cargarUsuarios();
        if (usuariosCargados.size() > 0)
            billeteraDigital.getUsuarios().addAll(usuariosCargados);

//        //cargar archivos empleados
//        ArrayList<Empleado> empleadosCargados = cargarEmpleados();
//        if (empleadosCargados.size() > 0)
//            billeteraDigital.getListaEmpleados().addAll(empleadosCargados);

        //cargar archivo transcciones

        //cargar archivo empleados

        //cargar archivo prestamo

    }

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     *
     * @param
     * @param
     * @throws IOException
     */
    public static void guardarUsuarios(ArrayList<Usuario> listaUsuario) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for (Usuario usuario : listaUsuario) {
            contenido += usuario.getNombre() + "@@" + usuario.getIdUsuario() + "@@" + usuario.getTelefono() + "@@" + usuario.getDireccion()
                    + "@@" + usuario.getCorreo() + "@@" + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, false);
    }


//    public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {
//        String contenido = "";
//        for(Empleado empleado:listaEmpleados)
//        {
//            contenido+= empleado.getNombre()+
//                    ","+empleado.getApellido()+
//                    ","+empleado.getCedula()+
//                    ","+empleado.getFechaNacimiento()+"\n";
//        }
//        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
//    }


//	----------------------LOADS------------------------

    /**
     * @param
     * @param
     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<Usuario> cargarUsuarios() throws FileNotFoundException, IOException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_USUARIOS);
        String linea = "";
        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Usuario usuario = new Usuario();
            usuario.setNombre(linea.split("@@")[0]);
            usuario.setIdUsuario(linea.split("@@")[1]);
            usuario.setTelefono(linea.split("@@")[2]);
            usuario.setDireccion(linea.split("@@")[3]);
            usuario.setCorreo(linea.split("@@")[4]);
            usuarios.add(usuario);
        }
        return usuarios;
    }


//    public static ArrayList<Empleado> cargarEmpleados() throws FileNotFoundException, IOException {
//        ArrayList<Empleado> empleados =new ArrayList<Empleado>();
//        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADOS);
//        String linea="";
//        for (int i = 0; i < contenido.size(); i++)
//        {
//            linea = contenido.get(i);
//            Empleado empleado = new Empleado();
//            empleado.setNombre(linea.split(",")[0]);
//            empleado.setApellido(linea.split(",")[1]);
//            empleado.setCedula(linea.split(",")[2]);
//            empleado.setFechaNacimiento(linea.split(",")[3]);
//            empleados.add(empleado);
//        }
//        return empleados;
//    }


    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion) {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }


//    public static boolean iniciarSesion(String usuario, String contrasenia) throws FileNotFoundException, IOException, UsuarioException {
//
//        if (validarUsuario(usuario, contrasenia)) {
//            return true;
//        } else {
//            throw new UsuarioException("Usuario no existe");
//        }
//
//    }

//    private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException {
//        ArrayList<Usuario> usuarios = Persistencia.cargarUsuarios(RUTA_ARCHIVO_USUARIOS);
//
//        for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++) {
//            Usuario usuarioAux = usuarios.get(indiceUsuario);
//            if (usuarioAux.getUsuario().equalsIgnoreCase(usuario) && usuarioAux.getContrasenia().equalsIgnoreCase(contrasenia)) {
//                return true;
//            }
//        }
//        return false;
//    }

//    public static ArrayList<Usuario> cargarUsuarios(String ruta) throws FileNotFoundException, IOException {
//        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//
//        ArrayList<String> contenido = ArchivoUtil.leerArchivo(ruta);
//        String linea = "";
//
//        for (int i = 0; i < contenido.size(); i++) {
//            linea = contenido.get(i);
//
//            Usuario usuario = new Usuario();
//            usuario.setUsuario(linea.split(",")[0]);
//            usuario.setContrasenia(linea.split(",")[1]);
//
//            usuarios.add(usuario);
//        }
//        return usuarios;
//    }


//	----------------------SAVES------------------------

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     *
     * @param
     * @param ruta
     * @throws IOException
     */

    public static void guardarObjetos(ArrayList<Usuario> listaUsuarios, String ruta) throws IOException {
        String contenido = "";

        for (Usuario usuarioAux : listaUsuarios) {
            contenido += usuarioAux.getNombre() + "," + usuarioAux.getIdUsuario() + "," + usuarioAux.getTelefono() + usuarioAux.getDireccion()
                    + "," + usuarioAux.getCorreo() + "," + "\n";
        }
        ArchivoUtil.guardarArchivo(ruta, contenido, true);
    }


    //------------------------------------SERIALIZACIÓN  y XML


    public static BilleteraDigital cargarRecursoBancoBinario() {

        BilleteraDigital billeteraDigital = null;

        try {
            billeteraDigital = (BilleteraDigital) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_BILLETERADIGITAL_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return billeteraDigital;
    }

    public static void guardarRecursoBancoBinario(BilleteraDigital billeteraDigital) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_BILLETERADIGITAL_BINARIO, billeteraDigital);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static BilleteraDigital cargarRecursoBancoXML() {

        BilleteraDigital billeteraDigital = null;

        try {
            billeteraDigital = (BilleteraDigital)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BILLETERA_DIGITAL_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return billeteraDigital;

    }


    public static void guardarRecursoBancoXML(BilleteraDigital billeteraDigital) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BILLETERA_DIGITAL_XML, billeteraDigital);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
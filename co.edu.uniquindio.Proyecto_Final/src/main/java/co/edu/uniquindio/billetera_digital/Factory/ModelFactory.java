    package co.edu.uniquindio.billetera_digital.Factory;

    import co.edu.uniquindio.billetera_digital.Exceptions.LoginException;
    import co.edu.uniquindio.billetera_digital.Exceptions.UsuarioException;
    import co.edu.uniquindio.billetera_digital.Model.BilleteraDigital;
    import co.edu.uniquindio.billetera_digital.Model.Usuario;
    import co.edu.uniquindio.billetera_digital.Utils.BilleteraUtils;
    import co.edu.uniquindio.billetera_digital.Utils.Persistencia;

    import java.io.IOException;
    import java.util.List;

    public class ModelFactory {

        private static ModelFactory instance;
        BilleteraDigital billeteraDigital;

        private static class SingletonHolder {
            private final static ModelFactory eINSTANCE = new ModelFactory();
        }

        public static ModelFactory getInstance() {
            return SingletonHolder.eINSTANCE;
        }

        private ModelFactory() {
                billeteraDigital = new BilleteraDigital();

              //inicializarDatosBase();
//            salvarDatosBase();
//
//            cargarDatosDesdeArchivos();
//
              //guardarRecursosBinario();
              cargarRecursosBinario();
//
//            cargarRecursosXML();
//            guardarRecursosXML();

            Persistencia.guardaRegistroLog("Inicio de sesión ", 1, "inicio Sesión");
        }

        private BilleteraDigital getBilleteraDigital() {
            return billeteraDigital;
        }

        private void cargarDatosDesdeArchivos() {
            try {
                Persistencia.cargarDatosArchivos(billeteraDigital);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void salvarDatosBase() {
            try {
                Persistencia.guardarUsuarios(getBilleteraDigital().getUsuarios());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void inicializarDatosBase() {
            billeteraDigital = BilleteraUtils.inicializarDatos();
        }

        private void guardarRecursosBinario() {
            Persistencia.guardarRecursoBancoBinario(billeteraDigital);
        }

        private void cargarRecursosBinario() {
            billeteraDigital = Persistencia.cargarRecursoBancoBinario();
        }

        private void guardarRecursosXML() {
            Persistencia.guardarRecursoBancoXML(getBilleteraDigital());
        }

        private void cargarRecursosXML() {
            billeteraDigital = Persistencia.cargarRecursoBancoXML();
        }

        public boolean iniciarSesion(String user, String password) {
            boolean respuesta = false;
            try {
                respuesta = Persistencia.iniciarSesion(user, password);
                Persistencia.guardaRegistroLog("Inicio Sesion: "+user,1,"Inicio De Sesion");
                return respuesta;
            }catch (LoginException e){
                Persistencia.guardaRegistroLog(e.getMessage(), 2, "Iniciar Sesion");
                return respuesta;
            }
        }

        public boolean registrarUsuario(String user, String password) {
            boolean respuesta = false;
            try {
                respuesta = Persistencia.registroUsuario(user, password);
                Persistencia.guardaRegistroLog("Registro De Usuario: "+user,1,"Registro");
                return respuesta;
            }catch (LoginException e){
                Persistencia.guardaRegistroLog(e.getMessage(), 2, "Registro usuario");
                return respuesta;
            }

        }

        public List<Usuario> obtenerUsuarios() {
            return billeteraDigital.getUsuarios();
        }

        public boolean crearUsuario(Usuario usuario) {
            boolean creacion = false;
            try {
                creacion = billeteraDigital.crearUsuario(usuario);
                Persistencia.guardaRegistroLog("Se creo el usuario: " + usuario.getIdUsuario(), 1, "Crear Usuario");
                Persistencia.guardarUsuarios(billeteraDigital.getUsuarios());
                Persistencia.guardarRecursoBancoXML(billeteraDigital);
                Persistencia.guardarRecursoBancoBinario(billeteraDigital);
                return creacion;
            } catch (UsuarioException e) {
                Persistencia.guardaRegistroLog(e.getMessage(), 2, "Crear Usuario");
                return creacion;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean eliminarUsuario(String cedula) {
            boolean eliminado;
            try {
                eliminado =  billeteraDigital.eliminarUsuario(cedula);
                Persistencia.guardaRegistroLog("Se elimino el usuario: " + cedula, 1, "Eliminar Usuario");
                Persistencia.guardarRecursoBancoXML(billeteraDigital);
                Persistencia.guardarUsuarios(getBilleteraDigital().getUsuarios());
                Persistencia.guardarRecursoBancoBinario(billeteraDigital);
            } catch (UsuarioException e) {
                Persistencia.guardaRegistroLog(e.getMessage(), 2, "Eliminar Usuario");
                return false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return eliminado;
        }

        public boolean actualizarUsuario(Usuario usuario) {
            boolean actualizado;
            try {
                actualizado = billeteraDigital.actualizarUsuario(usuario);
                Persistencia.guardaRegistroLog("Se actualizo el usuario: "+usuario.getIdUsuario(), 1, "Actualiza Usuario");
                Persistencia.guardarRecursoBancoXML(billeteraDigital);
                Persistencia.guardarUsuarios(billeteraDigital.getUsuarios());
                Persistencia.guardarRecursoBancoBinario(billeteraDigital);
            } catch (UsuarioException e) {
                Persistencia.guardaRegistroLog(e.getMessage(), 2, "Actualizar Usuario");
                return false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return actualizado;
        }
    }
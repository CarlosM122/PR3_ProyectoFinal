package co.edu.uniquindio.billetera_digital.Mappings;


import co.edu.uniquindio.billetera_digital.Mappings.Dto.UsuarioDto;
import co.edu.uniquindio.billetera_digital.Model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BilleteraMapper {

    BilleteraMapper INSTANCE = Mappers.getMapper(BilleteraMapper.class);

    @Named("usuarioDtoToUsuario")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "correo", source = "correo")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "direccion" , source = "direccion")
    @Mapping(target = "idUsuario" , source = "idUsuario")
    Usuario UsuarioDtoToUsuario(UsuarioDto usuarioDto);
}

package es.fiandeira.usuario.mapper;

import java.util.ArrayList;
import java.util.List;

import es.fiandeira.rangos.models.Rangos;
import es.fiandeira.usuario.models.Usuario;
import es.fiandeira.usuario.vo.RangoVO;
import es.fiandeira.usuario.vo.UsuarioVO;

public class UsuarioMapper {

	/**
	 * Mappear Usuario DB to Usuario VO
	 *
	 * @param user
	 * @param listaRango
	 * @return UsuarioVO
	 */
	public static UsuarioVO mapperUsuarioToUsuarioVO (final Usuario user, final List<Rangos> listaRango) {
		
		List<RangoVO> listaRangosVO = new ArrayList<>();
		for (Rangos rango: listaRango) {
			listaRangosVO.add(mapperRangoToRangoVO(rango));
		}
		
		return new UsuarioVO(
				user.getId(),
				user.getCorreo(),
				user.getNombre(),
				user.getApellidos(),
				listaRangosVO);
	}
	
	/**
	 * Mappear Rango DB to Rango VO
	 *
	 * @param rango
	 * @return UsuarioVO
	 */
	public static RangoVO mapperRangoToRangoVO (final Rangos rango) {
		return new RangoVO(
				rango.getMaestroRangos().getId(),
				rango.getMaestroRangos().getNombre(),
				rango.getMaestroRangos().getDescripcion());
	}
	
}

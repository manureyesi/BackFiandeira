package es.fiandeira.configuration.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HeaderFilterHandlerIntercentor extends HandlerInterceptorAdapter {

	private static final Logger LOG = Logger.getLogger(HeaderFilterHandlerIntercentor.class);
	
	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {
		
		boolean respuesta = true;

		if (handler instanceof HandlerMethod) {

			HandlerMethod handlerMethod = (HandlerMethod) handler;
			//Comprueba si tienen la anotacion
			HeaderFilterCustom headerFilter = handlerMethod.getMethod().getAnnotation(HeaderFilterCustom.class);
			
			if (headerFilter != null) {
				
				String appConsumidor = request.getHeader("app-consumidor");
				
				if (StringUtils.isBlank(appConsumidor)) {
					LOG.error("Error en la validación del appConsumidor");
					respuesta = false;
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				}
				
				LOG.info("Validando appConsumidora ".concat(appConsumidor));
				
			}
		
		}
	
		return respuesta;
	}

}

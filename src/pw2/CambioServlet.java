package pw2;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class CambioServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;
		HttpSession session = req.getSession();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Usuario.class);
			String rest=req.getParameter("rest");
			q.setFilter("email == emailParam");
			q.declareParameters("String emailParam");
			List<Usuario> cliente= (List<Usuario>)q.execute(session.getAttribute("email"));
			String id, email, paterno, materno, nombre, descripcion, tipo,idParam;
			String precio;
			Query qa;
			List<Usuario> users;
			
			switch (rest){
			
			
				
			case "cambiarMaterno":
				materno = req.getParameter("materno");
				cliente.get(0).setMaterno(materno);
				session.setAttribute("materno", materno);
				cliente.get(0).getHistorial().add(new Historial("Cambio Materno", req.getRemoteAddr(), req.getRemoteHost()));
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				break;
			
			case "cambiarNombre":
				nombre = req.getParameter("nombre");
				cliente.get(0).setNombre(nombre);
				session.setAttribute("nombre", nombre);
				cliente.get(0).getHistorial().add(new Historial("Cambio Nombre", req.getRemoteAddr(), req.getRemoteHost()));
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				break;
				
			case "cambiarPaterno":
				paterno = req.getParameter("paterno");
				cliente.get(0).setPaterno(paterno);
				session.setAttribute("paterno", paterno);
				cliente.get(0).getHistorial().add(new Historial("Cambio Paterno", req.getRemoteAddr(), req.getRemoteHost()));
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				break;
			/*	
			case "misReservas":
				req.setAttribute("lista", cliente.get(0).getReservas());
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/mostrarReservas.jsp");
				break;
				
			case "eliminarReserva":
				String idReserva = req.getParameter("idReserva");
				String correct;
				for(Reserva p : cliente.get(0).getReservas()){
					correct = "" + p.getKey().getId();
					if(correct.equals(idReserva)){
						cliente.get(0).getReservas().remove(p);
						cliente.get(0).getHistorial().add(new Historial("Elimino Reserva", req.getRemoteAddr(), req.getRemoteHost()));
						mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
						req.setAttribute("lista", cliente.get(0).getReservas());
						mandar.forward(req, resp);
						return;
					}
				}
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/noExisteReserva.jsp");
				break;
				*/
			case "bloquearCiudad":
				Query l2 = pm.newQuery(Ciudad.class);
				List<Ciudad> ciudad = (List<Ciudad>) l2.execute();
				req.setAttribute("lista", ciudad);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/bloquearCiudades.jsp");
				break;
				
			case "bloquearPaquete":
				Query p2 = pm.newQuery(Paquete.class);
				List<Paquete> paquetes = (List<Paquete>) p2.execute();
				req.setAttribute("lista", paquetes);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/bloquearPaquete.jsp");
				break;
				
			case "bloquearCliente":
				Query c1 = pm.newQuery(Usuario.class);
				c1.setFilter("admin == adminParam");
				c1.declareParameters("Integer adminParam");
				List<Usuario> clientes = (List<Usuario>) c1.execute(0);
				req.setAttribute("lista", clientes);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/bloquearCliente.jsp");
				break;
			
			case "borrarCliente":
				Query c2 = pm.newQuery(Usuario.class);
				c2.setFilter("admin == adminParam");
				c2.declareParameters("Integer adminParam");
				List<Usuario> borrados = (List<Usuario>) c2.execute(0);
				req.setAttribute("lista", borrados);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/eliminarCliente.jsp");
				break;
				
			case "listarCliente":
				Query q2=pm.newQuery(Usuario.class);
				List<Usuario> listarCliente=(List<Usuario>)q2.execute();
				req.setAttribute("lista", listarCliente);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/mostrarCliente.jsp");
				break;
			
			case "historialCliente":
				Query q3=pm.newQuery(Usuario.class);
				List<Usuario> historialCliente=(List<Usuario>)q3.execute();
				req.setAttribute("lista", historialCliente);
				System.out.println("hgf");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/historialClientes.jsp");
				break;	
				
			case "agregarCiudad":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/agregarCiudad.jsp");
				break;	
				
			case "listarCiudad":
				Query qb2=pm.newQuery(Ciudad.class);
				@SuppressWarnings("unchecked")
				List<Ciudad> listarCiudad=(List<Ciudad>)qb2.execute();
				req.setAttribute("lista", listarCiudad);
				System.out.println("agregar ciudad");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/listarCiudad.jsp");
				break;	
			case "agregarPaquete":
				
				Query qb4=pm.newQuery(Ciudad.class);
				@SuppressWarnings("unchecked")
				List<Ciudad> listaCiudad=(List<Ciudad>)qb4.execute();
				req.setAttribute("lista", listaCiudad);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/agregarPaquete.jsp");
				break;	
			
			case "listarPaquete":
				Query qp2=pm.newQuery(Paquete.class);
				List<Paquete> listarPaquete=(List<Paquete>)qp2.execute();
				req.setAttribute("lista", listarPaquete);
				System.out.println("listarPaquete");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/listarPaquete.jsp");
				break;
				
			case "editarPaquete":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/buscarPaquete.jsp");
				break;
				
			case "editarHospedaje":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/buscarHospedaje.jsp");
				break;
			//error aca ...xsiaca
			case "buscarPaquete":
				id = req.getParameter("id");
				Query qp3 = pm.newQuery(Paquete.class);
				qp3.setFilter("id == idParam"); 
				qp3.declareParameters("Long idParam");
				List<Paquete> paquetes2 = (List<Paquete>) qp3.execute(Long.parseLong(id));
				if(paquetes2.size() != 0){
					req.setAttribute("paquetes", paquetes2.get(0));
					session.setAttribute("idPlato", paquetes2.get(0).getId().getId());
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/editarPaquete.jsp");
				} else {
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;
				
			case "buscarHospedaje":
				System.out.println("BuscarHospedaje");
				id = req.getParameter("id");
				System.out.println(id);
				Query qb1 = pm.newQuery(Hospedaje.class);
				qb1.setFilter("id == idParam"); 
				qb1.declareParameters("Long idParam");
				List<Hospedaje> hospedaje = (List<Hospedaje>) qb1.execute(Long.parseLong(id));
				if(hospedaje.size() != 0){
					req.setAttribute("hospedaje", hospedaje.get(0));
					session.setAttribute("idHospedaje", hospedaje.get(0).getId().getId());
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/editarHospedaje.jsp");
				} else {
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;
				
			case "editarHospedajeAccion":
				System.out.println("ssss");
				nombre = req.getParameter("nombre");
				precio = req.getParameter("precio");
				tipo = req.getParameter("tipo");
				descripcion = req.getParameter("descripcion");
				Query qb3 = pm.newQuery(Hospedaje.class);
				qb3.setFilter("id == idParam");
				qb3.declareParameters("Long idParam");
				List<Hospedaje> cambioHospedaje = (List<Hospedaje>) qb3.execute(Long.parseLong("" + session.getAttribute("id")));
				if(cambioHospedaje.size() != 0){
					cambioHospedaje.get(0).setNombre(nombre);
					cambioHospedaje.get(0).setPrecio(precio);
					cambioHospedaje.get(0).setTipo(tipo);
					cambioHospedaje.get(0).setDescripcion(descripcion);
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				} else {
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;	
			/*	
			case "editarPlatoAccion":
				nombre = req.getParameter("nombre");
				precio = req.getParameter("precio");
				tipo = req.getParameter("tipo");
				descripcion = req.getParameter("descripcion");
				Query qp4 = pm.newQuery(Plato.class);
				qp4.setFilter("id == idParam"); 
				qp4.declareParameters("Long idParam");
				List<Plato> cambioPlatos = (List<Plato>) qp4.execute(Long.parseLong("" + session.getAttribute("idPlato")));
				if(cambioPlatos.size() != 0){
					cambioPlatos.get(0).setNombre(nombre);
					cambioPlatos.get(0).setPrecio(precio);
					cambioPlatos.get(0).setTipo(tipo);
					cambioPlatos.get(0).setDescripcion(descripcion);
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				} else {
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;
			*/
			case "buscarAdministrador":
				email = req.getParameter("email");
				qa = pm.newQuery(Usuario.class);
				qa.setFilter("email == emailParam"); 
				qa.declareParameters("String emailParam");
				users = (List<Usuario>) qa.execute(email);
				if(users.size() != 0){
					req.setAttribute("user", users.get(0));
					session.setAttribute("emailBuscado", email);
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/editarAdministrador.jsp");
				} else {
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;
			
			case "editarAdministradorAccion":
				System.out.println("11111");
				nombre = req.getParameter("nombre");
				paterno = req.getParameter("paterno");
				materno = req.getParameter("materno");
				int dni = Integer.parseInt(req.getParameter("dni"));
				qa = pm.newQuery(Usuario.class);
				System.out.println("11111");
				qa.setFilter("email == idParam");
				qa.declareParameters("String idParam");
				users = (List<Usuario>) qa.execute(session.getAttribute("emailBuscado"));
				if(users.size() != 0){
					users.get(0).setNombre(nombre);
					users.get(0).setPaterno(paterno);
					users.get(0).setMaterno(materno);;
					users.get(0).setDni(dni);
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				} else {
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;
			/*	
			case "imagenPlato":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/anadirImagenPlato.jsp");
				System.out.println("dasdasdsad");
				break;
				*/
			case "agregarHospedaje":
				Query q5=pm.newQuery(Hospedaje.class);
				List<Hospedaje> agregarHosp=(List<Hospedaje>)q5.execute();
				req.setAttribute("lista", agregarHosp);
				System.out.println("hgf");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/agregarHospedaje.jsp");
				break;	
				
			case "listarHospedaje":
				Query qb21=pm.newQuery(Hospedaje.class);
				@SuppressWarnings("unchecked")
				List<Hospedaje> listarHospedaje=(List<Hospedaje>)qb21.execute();
				req.setAttribute("lista", listarHospedaje);
			//	System.out.println("hghfghfghfhgf");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/listarHospedaje.jsp");
				break;	
				
			case "imagenHospedaje":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/anadirImagenHospedaje.jsp");
				break;	
				/*
			case "listarReserva":
				Query qr3=pm.newQuery(Reserva.class);
				@SuppressWarnings("unchecked")
				List<Reserva> reservas=(List<Reserva>)qr3.execute();
				req.setAttribute("lista", reservas);
				System.out.println("jhjhjh");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/listarReservas.jsp");
				break;
			case "borrarPlato":
				Query qp=pm.newQuery(Plato.class);
				List<Plato> platos1 = (List<Plato>) qp.execute();
				req.setAttribute("lista", platos1);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/borrarPlato.jsp");
			break;
			*/
			case "borrarHospedaje":
				Query qb=pm.newQuery(Hospedaje.class);
				List<Hospedaje> hospedaje1 = (List<Hospedaje>) qb.execute();
				req.setAttribute("lista", hospedaje1);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/borrarHospedaje.jsp");
			break;
				
			default :
			 	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");	
			break;
			}
			mandar.forward(req, resp);
	}
}
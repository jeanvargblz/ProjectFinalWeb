package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Controller extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null;
			
			String adm = req.getParameter("adm");
			switch (adm){
			
			case "INICIO":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
				break;
				
			case "INICIOadm":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/panelDeControl.jsp");
				break;
				
			case "Login":
				mandar=getServletContext().getRequestDispatcher("/login");
				break;
		
			case "Editar Perfil":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/Editables/editarPerfil.jsp");
				break;
				
			case "Administradores":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/Admins.jsp");
				break;
				
			case "Usuarios":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/usuarios.jsp");
				break;
				
			case "Matriculas":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/matriculados.jsp");
				break;
				
			case "Matricula":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/matriculas.jsp");
				break;
				
			case "Noticias":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/noticias.jsp");
				break;
				
			case "Mensajes":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/mensajes.jsp");
				break;
				
			case "Cerrar Sesion":
				mandar=getServletContext().getRequestDispatcher("/cerrar");
				break;

			case "Registrar Admin":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/registrarAdmin.jsp");
				break;

			case "Crear Noticias":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/crearNoticia.jsp");
				break;
				
			case "Enviar Mensaje":
				mandar=getServletContext().getRequestDispatcher("/crearMensaje");
				break;
				
			case "Matricular":
				mandar=getServletContext().getRequestDispatcher("/matriculasBryce");
				break;
				
			case "Contacto":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/contacto.jsp");
				break;
				
				
			case "Nosotros":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/Estaticos/nosotros.jsp");	
				break;
				
			case "Psicologia":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/Estaticos/psicologia.jsp");
				break;
				
			case "Biblioteca":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/Estaticos/biblioteca.jsp");
				break;		
				
			default :
			 	mandar=getServletContext().getRequestDispatcher("index.html");	
			break;
			}
			mandar.forward(req, resp);
			
		
	}
}
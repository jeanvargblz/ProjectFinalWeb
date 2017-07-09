package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controladores.*;

@SuppressWarnings("serial")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		String usuario = req.getParameter("usuario");
		String pass = req.getParameter("pass");
		
		
		//Query es la BD de javaAPI(jdo)
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query us = pm.newQuery(Usuario.class);
		Query ad = pm.newQuery(Administrador.class);
		
		@SuppressWarnings("unchecked")
		List<Administrador> admin = (List<Administrador>) ad.execute();
		
		RequestDispatcher rd = null;
		
		if(admin.size() < 1){
			String a = "Admin";
			String correo = a+"@"+a;
			Administrador adm = new Administrador(a, a, usuario, a, correo, pass);
			pm.makePersistent(adm);
			rd = getServletContext().getRequestDispatcher("/");
			rd.forward(req, resp);
		}
		
		ad.setFilter("(user == '"+usuario+"')&&(pass =='"+pass+"')");
		us.setFilter("(usuario == '"+usuario+"')&&(contras =='"+pass+"')");
		
		if(usuario != null){
			
			try{
				@SuppressWarnings("unchecked")
				List<Usuario> users = (List<Usuario>) us.execute();
				
				@SuppressWarnings("unchecked")
				List<Administrador> admins = (List<Administrador>) ad.execute();
				
				if(users.size()==1){
					Usuario u = users.get(0);
					HttpSession sesion= req.getSession(true);
					sesion.setAttribute("usuario",u.getUsuario());
					sesion.setAttribute("nombre", u.getNombre() + " " + u.getApellido());
					rd=getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
					rd.forward(req, resp);
					
				}else if(admins.size()==1){
					Administrador a = admins.get(0);
					
					if(a.getCargo().equals("Admin")){
						HttpSession sesion= req.getSession(true);
						sesion.setAttribute("usuario",a.getUser());
						sesion.setAttribute("nombre", a.getName() + " " + a.getLastname());
						sesion.setAttribute("tipo", "Admin");
					}					
					if(a.getCargo().equals("CDC")){
						HttpSession sesion= req.getSession(true);
						sesion.setAttribute("usuario",a.getUser());
						sesion.setAttribute("nombre", a.getName() + " " + a.getLastname());
						sesion.setAttribute("tipo", "CDC");
					}
					rd = getServletContext().getRequestDispatcher("/WEB-INF/panelDeControl.jsp");
					rd.forward(req, resp);
					
				}else{
					rd = getServletContext().getRequestDispatcher("/");
					rd.forward(req, resp);
				}
		
			}catch (Exception e) {
				out.println("Error" + e);			
			
			}finally{
				pm.close();
			}
		}
		
	}
}
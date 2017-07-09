package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class GmailServlet extends HttpServlet {
 public void doPost(HttpServletRequest req, HttpServletResponse resp)
 throws IOException {
	 resp.setContentType("text/html");
 
	 PrintWriter out = resp.getWriter();
 
	 UserService us = UserServiceFactory.getUserService();
	 User user = us.getCurrentUser();
 	
	 if(user == null){
		 resp.sendRedirect(us.createLoginURL(req.getRequestURI()));
 	}else{
		 out.println("<!DOCTYPE html>"	 
		 + "<html>"
		 + "<head><title>Informaci�n de la cuenta</title>"
		 + "<meta charset=utf-8;>"
		 + "<body>"
		 + "<h1>Informaci�n de la Cuenta Google</h1>"
		 + "<br><a href='../'>Regresar...</a>"
		 +"<br/><b>User :</b>"
		 +"<br/>getNickname retorn� : "+user.getNickname()
		 +"<br/>getAuthDomain retorn� : "+user.getAuthDomain()
		 +"<br/>getEmail retorn� : "+user.getEmail()
		 +"<br/>getUserId retorn� : "+user.getUserId()
		 +"<br/>getFederatedIdentity retorn� : "+user.getFederatedIdentity()
		 +"<br/>"
		 +"<br/><b>UserService :</b>"
		 +"<br/>isUserAdmin retorn� : "+us.isUserAdmin() 
		 +"<br/>isUserLoggedIn retorn� : "+us.isUserLoggedIn()
		 +"<br/>getCurrentUser retorn� : "+us.getCurrentUser()
		 +"<br/>"
		 +"<a href='"+ us.createLogoutURL(req.getRequestURI())+"'> Cerrar sesi�n </a>"
		 + "</body></html>");
 	}
 }
}
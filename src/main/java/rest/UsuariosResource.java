package rest;

import javax.persistence.RollbackException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;
import daos.*;
import model.Usuario;


import jakarta.ws.rs.Consumes; 
import jakarta.ws.rs.GET; 
import jakarta.ws.rs.Path; 
import jakarta.ws.rs.Produces; 
import jakarta.ws.rs.core.MediaType; 
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder; 


@Path("/usuarios")

@Consumes(MediaType.APPLICATION_JSON)


public class UsuariosResource {
	
	
	
	@Context
	       UriInfo uriInfo;
	@Context
	       Request request;
			
			UsuarioDAO uDAO = new UsuarioDAO();
	       private String mensaje;
	       @GET
	       @Produces(MediaType.APPLICATION_JSON)
	       public List<Usuario> getUsuarios() throws Exception{
	             return uDAO.getAllFields();
	}
	
       @GET
       @Path("{id}")
       @Produces(MediaType.APPLICATION_JSON)
       public Response encontrar(@PathParam("id") Long id){
              Usuario usu = uDAO.findById(id);
              if (usu != null){
return Response .ok()
                                  .entity(usu)
                                  .build();
} else {
	mensaje="No se encontró el usuario"; 
	return Response
			.status(Response.Status.NOT_FOUND) .entity(mensaje)
.build();
}
       }
       
      
       
       @POST
       @Produces(MediaType.APPLICATION_JSON)
       @Consumes(MediaType.APPLICATION_JSON)
       public Response crear(Usuario usuario) throws Exception{ 
    	   Boolean aux = uDAO.findByEmail(usuario.getEmail());
    	   if (aux){
  	     		uDAO.agregar(usuario);//podría validar si ya existe el usuario udao.create(usuario);
  	     		return Response.status(Response.Status.CREATED).build();}else {
  	    		   return Response.status(Response.Status.NOT_FOUND) .entity("[]").build();
  	    	   } }

    	   
    	   
       
       
    	   @PUT
    	   @Produces(MediaType.APPLICATION_JSON)
    	   @Consumes(MediaType.APPLICATION_JSON)
    	   public Response editar(Usuario usuario){
    	     Usuario aux = uDAO.findById(usuario.getId());
    	     if (aux != null){
    	          uDAO.update(usuario);
    	   return Response.ok().entity(usuario).build(); } else {
    		   return Response.status(Response.Status.NOT_FOUND) .entity("[]").build();
    	   } }
    	   
    	
    	   @DELETE
    	   @Path("{id}")
    	   @Produces(MediaType.TEXT_PLAIN)
  
    	   public Response borrar(@PathParam("id") Long id){
    	     Usuario aux = uDAO.findById(id);
    	     if (aux != null){
    	         uDAO.delete(aux);
    	   return Response.noContent().build(); } else {
    	   mensaje = "No existe el usuario con ese id"; 
    	   return Response.status(Response.Status.CONFLICT).build();
    	   } }
}
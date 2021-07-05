package br.com.qrksCrud.resources;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.qrksCrud.model.Produto;
import br.com.qrksCrud.model.builders.ProdutoBuilder;
import br.com.qrksCrud.resources.dto.ProdutoDTO;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> buscarTodosProdutos() {
        return Produto.listAll();
    }
    
    @POST
    @Transactional
    public Response salvar(ProdutoDTO dto) {
    	Produto.persist(ProdutoBuilder.builder(dto.nome, dto.valor).build());
    	return Response.status(Status.CREATED).build();
    }
    
    @PUT
    @Path("{id}")
    @Transactional
    public Response atualizar(@PathParam("id") Long id, ProdutoDTO dto) {
    	Optional<Produto> p = Produto.findByIdOptional(id);
    	if (p.isPresent()) {
			var produto = p.get();
			produto.setNome(dto.nome);
			produto.setValor(dto.valor);
			Produto.persist(produto);
			return Response.status(Status.NO_CONTENT).build();
		}else {
			throw new NotFoundException("Produto não encontrado");
		}
    }
    
    @DELETE
    @Path("{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
    	Optional<Produto> p = Produto.findByIdOptional(id);
    	p.ifPresentOrElse(Produto::delete, () -> {throw new NotFoundException("Produto não encontrado");});
    	return Response.status(Status.OK).build();
    }
    
}
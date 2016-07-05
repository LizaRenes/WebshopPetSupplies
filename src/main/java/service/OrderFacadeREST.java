/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import orders.Orders;

/**
 *
 * @author lrenes
 */
@Stateless
@Path("orders")
public class OrderFacadeREST extends AbstractFacade<Orders> {

    @PersistenceContext(unitName = "com.sogeti_Webshop_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public OrderFacadeREST() {
        super(Orders.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Orders entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Orders entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Orders find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Orders> findAll() {
        return super.findAll();
//        String cart = "1~3*4~1*7~2";
//        Orders order = new Orders();
//        String [] cartsplit1 = cart.split(", ");
//        cartsplit1[0] = "1~3";
//        cartsplit1[1] = "4~1";
//        cartsplit1[2] = "7~2";
//        for(String str : cartsplit1){
//            String [] cartsplit2 = str.split("~");
//            order.setOrder(cartsplit2[0], cartsplit2[1]);
//        }
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Orders> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

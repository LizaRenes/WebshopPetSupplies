/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import product.Product;
import orders.Orders;

/**
 *
 * @author lrenes
 */
@Singleton
@Startup
public class DbFiller {
    
    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void onPostConstruct(){
        LOG.info("Db filler started");
        this.databaseFiller();
    }
    
    public void databaseFiller(){
        Product kattenvoer = new Product("Kattenvoer","Heerlijk en zeer voedzaam", 2.99);
        Product hondenvoer = new Product("Hondenvoer", "Speciaal voor uw hond het allerbeste", 4.99);
        Product kattenmand = new Product("Kattenmand", "Speciaal voor uw kat het allerbeste", 9.99);
//        Orders klant1 = new Orders("prodAmount: 1~2, name: LizaRenes, adress: Goudsbloemstraat10, zipcode: 9853RB, city: Munnekezijl, email: lizarenes@hotmail.com");
        //je kan niet een collection object persisten!
        
        
        entityManager.persist(kattenvoer);
        LOG.info("product in DB");
        
        entityManager.persist(hondenvoer);
        LOG.info("product in DB");
        
        entityManager.persist(kattenmand);
        LOG.info("product in DB");
    
//        entityManager.persist(klant1);
//        LOG.info("order in DB");
        //TODO: maken voor Order als test    
    }
    
    public DbFiller() {
    }
    
    public static DbFiller getInstance() {
        return DbFillerHolder.INSTANCE;
    }
    
    private static class DbFillerHolder {

        private static final DbFiller INSTANCE = new DbFiller();
    }
    
    private static final Logger LOG = Logger.getLogger(DbFiller.class.getName());
}

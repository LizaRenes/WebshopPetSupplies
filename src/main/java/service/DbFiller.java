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
        Product kattenvoer = new Product("Kattenvoer","Smakelijk kattenvoer van Gourmet Gold, exquise en mals pastei-kattenvoer in praktische portieblikjes.", 2.99, "kat");
        Product hondenvoer = new Product("Hondenvoer", "Royal Canin Medium Adult hondenvoer voor volgroeide honden van middelgrote rassen (11 - 25 kg) vanaf 12 maanden tot het 7e levensjaar, voor sterke afweerkrachten en optimale verteringszekerheid. ", 4.99, "hond");
        Product kattenmand = new Product("Kattenmand", "Happy Pet Hugs Snuggle - Kattenslaapzak - 50 x 50 cm", 9.99, "kat");
        Product hondenbotten = new Product("Hondenbot", "Barkoo kauwbotten maken iedere hond, groot of klein, blij! Gemaakt uit 100% geperste runderhuid met verscheidene groottes om de tanden te reinigen & het gebit te versterken. Barkoo – Snacks met passie", 4.99, "hond");
        Product hamstervoer = new Product("Hamstervoer", "Witte Molen Country is een compleet hamstervoer voor zowel de Dwerghamster al de Hamster. Dit uitgebalanceerde hamstervoer bevat alles wat een Hamster nodig heeft om gezond en actief te blijven. Het voer bestaat uit een mix van o.a. zaden, groenten, ...", 19.99, "hamster");
        Product hamsterkooi = new Product("Hamsterkooi", "De Combi 1 Fun is een vernieuwde en uitgebreide versie van de Combi 1. Ferplast heeft de Combi 1 omgetoverd in een schitterende Fun Kooi voor Hamsters. De Combi 1 Fun is compleet ingericht met alle accessoires die uw kleine knager nodig heeft.", 99.99, "hamster");
        Product vissenvoer = new Product("Visservoer", "Tetra Visvoer goldfish vlokken, 100 ml. Vlokkenvoeder met BioActive® formule voor alle goudvissen.", 2.50, "vis");
        Product aquarium = new Product("Aquarium", "Juwel Meubel Vision Sb 260 Zwart", 199.99, "vis");
//        Orders klant1 = new Orders("prodAmount: 1~2, name: LizaRenes, adress: Goudsbloemstraat10, zipcode: 9853RB, city: Munnekezijl, email: lizarenes@hotmail.com");
        //je kan niet een collection object persisten!
        
        
        entityManager.persist(kattenvoer);
        LOG.info("product in DB");
        
        entityManager.persist(hondenvoer);
        LOG.info("product in DB");
        
        entityManager.persist(kattenmand);
        LOG.info("product in DB");
        
        entityManager.persist(hondenbotten);
        LOG.info("product in DB");
        
        entityManager.persist(hamstervoer);
        LOG.info("product in DB");
        
        entityManager.persist(hamsterkooi);
        LOG.info("product in DB");
        
        entityManager.persist(vissenvoer);
        LOG.info("product in DB");
    
        entityManager.persist(aquarium);
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

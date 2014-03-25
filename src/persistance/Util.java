/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Brent
 */
public class Util {

    private static Util instance;
    private EntityManagerFactory fac;
    private EntityManager manager;

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }
    
    public EntityManager getEntitymanager(){
        fac = Persistence.createEntityManagerFactory("bachelorproef");
        manager = fac.createEntityManager();
        return manager;
    }
    
   public void closeFactory(){
       fac.close();
   }

     
}

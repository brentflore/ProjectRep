/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistance;

import domein.domein.Presentatie;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brent
 */
public class PresentatieMapper extends Mapper<Presentatie>
{
	@Override
	public List<Presentatie> geefLijst() 
        {
		List<Presentatie> lijstPresentaties = new ArrayList<>();
              Util util = Util.getInstance();
      EntityManager em = util.getEntitymanager();
      em.getTransaction().begin();
      TypedQuery<Presentatie> queryD = em.createNamedQuery("Presentatie.findAll", Presentatie.class);
      lijstPresentaties=queryD.getResultList();
      em.close();
      util.closeFactory();
            System.out.println(lijstPresentaties);
		return lijstPresentaties;
	}

	
}

package persistance;

import domein.domein.Gebruiker;
import domein.domein.Promotor;
import java.util.ArrayList;
import java.util.List;

import domein.domein.Student;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PromotorMapper extends Mapper<Promotor>
{
	@Override
	public List<Promotor> geefLijst() 
        {
		List<Promotor> lijstPromotoren = new ArrayList<>();
              Util util = Util.getInstance();
      EntityManager em = util.getEntitymanager();
      em.getTransaction().begin();
      TypedQuery<Promotor> queryD = em.createNamedQuery("Prom.findAll", Promotor.class);
      lijstPromotoren=queryD.getResultList();
      em.close();
      util.closeFactory();

		return lijstPromotoren;
	}

	
}

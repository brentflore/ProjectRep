package persistance;

import domein.domein.Gebruiker;
import java.util.ArrayList;
import java.util.List;

import domein.domein.Student;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class StudentMapper extends Mapper<Student>
{
	@Override
	public List<Student> geefLijst() {
               List<Student> lijstStudenten = new ArrayList<>();
               Util util = Util.getInstance();
      EntityManager em = util.getEntitymanager();
      em.getTransaction().begin();
      TypedQuery<Student> queryD = em.createNamedQuery("Stud.findAll", Student.class);
      lijstStudenten=queryD.getResultList();
      em.close();
      util.closeFactory();
		return lijstStudenten;
	}

	
}

package persistance;

public class MapperFactory 
{

	public static <E> Mapper <E> geefMapper(SoortMapper soort)
	{
		switch (soort) {
		case STUDENT: return (Mapper<E>) new StudentMapper();
		case PROMOTOR: return (Mapper<E>) new PromotorMapper();
                case PRESENTATIE: return (Mapper<E>) new PresentatieMapper();
		default:return null;
		}
	}
}

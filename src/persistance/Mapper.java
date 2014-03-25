package persistance;

import java.util.List;

//Waarom geen interface
// omdat je in alle subklassen dan niet dezelfde methodes moet uits
public abstract class Mapper<E> 
{
	public List<E> geefLijst()
	{
		throw new UnsupportedOperationException();
	}
	
	public List<E> geefLijstPerItem(int d)
	{
		throw new UnsupportedOperationException();
	}
}

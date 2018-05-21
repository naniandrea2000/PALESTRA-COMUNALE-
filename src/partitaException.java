/**
 * Classe che rappresenta un'eccezione che si solleva durante l'esecuzione del programma
 * L'attributo della classe è il messaggio che si vuole mostrare quando l'eccezione viene sollevata
 * @author Nani Andrea
 *
 */
public class partitaException extends Exception 
{
	private String messaggio;
	/**
	 * Costruttore 
	 * @param messaggio che rappresenta il messaggio da mostrare nel caso in cui si solleva l'eccezione
	 */
	public partitaException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	/**
	 * Metodo to string che ritorna il messaggio da mostrare al verificarsi dell'eccezione
	 */
	public String toString()
	{
		return messaggio;
	}
}

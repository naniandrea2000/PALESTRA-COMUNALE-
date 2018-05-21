import java.io.Serializable;
/**
 * La classe nodo rappresenta un  determinato nodo. Il nodo è costituito da 2 attributi:
 * un info e un link. Info è la componente informativa, contiene un reference a un oggetto presente nella lista,
 * mentre link è un puntatore che punta all'elemento successivo della lista. 
 * 
 * @author Nani Andrea
 * @version 1.0
 */

public class nodo implements Serializable
{
	private Prenotazione info;
	private nodo link;
	/**
	 * Costruttore della classe nodo. Consente di istanziare un oggetto di tipo nodo.
	 * richiede una prenotazione, che rappresenta l'attributo info della classe nodo.
	 * 
	 * @param p è un oggetto di tipo Prenotazione
	 */
	public nodo(Prenotazione p)
	{
		setInfo(p);
		link=null;
		
	}
	/**
	 * Classe che ci consente di creare un nuovo nodo nella nostra lista
	 * 
	 * @param p è un oggetto di tipo Prenotazione
	 * @param link è un oggetto di tipo nodo
	 * @return nodo è un nodo istanziato nel metodo
	 */
	private nodo creaNodo(Prenotazione p, nodo link)
	{
		nodo nodo= new nodo(p);
		nodo.setLink(link);
		return nodo;
	}
	/**
	 * Metodo di tipo getter che restituisce la componente informativa del nodo, ossia una Prenotazione
	 * @return info che rappresenta un oggetto Prenotazione
	 */
	public Prenotazione getInfo() 
	{
		return info;
	}
	/**
	 * Metodo di tipo setter che permette di settare la componente informativa del nodo
	 * @param info rappresenta la Prenotazione che rappresenterà la componente informativa del nodo
	 */
	public void setInfo(Prenotazione info) 
	{
		this.info = new Prenotazione(info);
	}
	/**
	 * Metodo di tipo getter che ritorna il link del nodo
	 * @return link rappresenta il reference al nodo successivo
	 */
	public nodo getLink() 
	{
		return link;
	}
	/**
	 * Metodo setter che permette di settare il link di un nodo
	 * @param link rappresenza il reference al nodo successivo che si vuole far assumere  al nodo
	 */
	public void setLink(nodo link) 
	{
		this.link = link;
	}
}

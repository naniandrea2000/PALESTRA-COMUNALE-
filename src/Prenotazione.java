import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * La classe Prenotazione rappresenta una determinata prenotazione.Una Prenotazione è costituita dai seguenti attributi:
 * Un codice identificativo che rappresenta il codice di ciascuna prenotazione
 * un cognome che rappresenta il cognome di colui che vuole eseguire la prenotazione
 * un nome che rappresenta il nome di colui che vuole eseguire la prenotazione
 * una data che rappresenta la data nella quale si vuole prenotare la palestra
 * una data fine che  che rappresenta la fine della prenotazione della palestra
 * un tempo di utilizzo che rappresenta per quanto si vuole utilizzare la palestra
 * una tariffa ore che rappresenta il costo all'ora della prenotazione per la palestra
 * una tariffa docce che rappresenta il costo delle docce della palestra
 * 
 * @author Nani Andrea
 * @version 1.0
 */
public class Prenotazione implements Serializable
{
	//attributi
	private int codiceIdentificativo;
	private String cognome;
	private String nome;
	private LocalDateTime datainizio;
	private int tempoutilizzo;
	private static int tariffaore=30;
	private static int tariffadocce=5;
	
	/**
	 * Costruttore della classe Prenotazione. Instanzia una nuova Prenotazione.
	 * richiede un codice identificativo(int c),un cognome(String c1),un nome(String n1)
	 * una determinata data(LocalDateTime d1) e un tempo di utilizzo(int t)
	 * 	
	 * @param c che rappresenta il codice della prenotazione
	 * @param  c1 che rappresenta il cognome di colui che vuole eseguire la prenotazione
	 * @param  n1 che rappresenta il nome di colui che vuole eseguire la prenotazione
	 * @param  d1 che rapprsenta la data nella quale si vuole prenotare la palestra
	 * @param t che rappresenta per quanto si vuole utilizzare la palestra
	 */
	public Prenotazione(int c,String c1,String n1,LocalDateTime d1,int t)
	{
		this.codiceIdentificativo=c;
		this.cognome=c1;
		this.nome=n1;
		this.datainizio=d1;
		this.tempoutilizzo=t;
	}

	/**
	 * Costruttore di copia della classe Prenotazione. Istanzia una nuova Prenotazione
	 * @param p rappresenta la prenotazione che si vuole copiare
	 */
	public Prenotazione(Prenotazione p)
	{
		this.setCodiceIdentificativo(p.getCodiceIdentificativo());
		this.setCognome(p.getCognome());
		this.setNome(p.getNome());
		this.setDatainizio(p.getDatainizio());
		this.setTempoutilizzo(p.getTempoutilizzo());
		this.setTariffaore(p.getTariffaore());
		this.setTariffadocce(p.getTariffadocce());
	}

	/**
	 * Costruttore di default della classe Prenotazione. Istanzia una prenotazione
	 * vuota
	 */
	public Prenotazione()
	{
		this.codiceIdentificativo=0;
		this.cognome="";
		this.nome="";
		this.datainizio=null;
		this.tempoutilizzo=0;
	}
	/**
	 * Metodo di tipo getter che restituisce il codice identificativo della prenotazione
	 * @return codiceIdentificativo che rappresenta il codice identificativo della prenotazione
	 */
	public int getCodiceIdentificativo() 
	{
		return codiceIdentificativo;
	}
	/**
	 * Metodo di tipo setter che permette di settare il codice identificativo della prenotazione
	 * @param codiceidentificativo che rappresenta il nuovo valore che si vuole attribuire
	 */
	public void setCodiceIdentificativo(int codiceIdentificativo) 
	{
		this.codiceIdentificativo = codiceIdentificativo;
	}
	/**
	 * Metodo di tipo getter che restituisce il cognome della prenotazione
	 * @return cognome che rappresenta il cogome attribuito a una prenotazione
	 */
	public String getCognome() 
	{
		return cognome;
	}
	/**
	 * Metodo di tipo setter che permette di settare il cognome che si vuole attribuire alla prenotazione
	 * @param cognome che rappresenta il nuovo cognome che si vuole attribuire alla prenotazione
	 */
	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}
	/**
	 * Metodo di tipo getter che restituisce il nome della prenotazione
	 * @return nome che rappresenta il nome attribuito a una prenotazione
	 */
	public String getNome() 
	{
		return nome;
	}
	/**
	 * Metodo di tipo setter che permette di settare il nome che si vuole attribuire alla prenotazione
	 * @param nome che rappresenta il nuovo nome che si vuole attribuire alla prenotazione
	 */
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	/**
	 * Metodo di tipo getter che restituisce la data della prenotazione
	 * @return data che rappresenta la data di una prenotazione
	 */
	public LocalDateTime getDatainizio() 
	{
		return datainizio;
	}
	/**
	 * Metodo di tipo setter che permette di settare la data che si vuole attribuire alla prenotazione
	 * @param data che rappresenta la nuova data che si vuole attribuire
	 */
	public void setDatainizio(LocalDateTime data) 
	{
		this.datainizio = data;
	}

	/**
	 * Metodo di tipo getter che restituisce il tempo di utilizzo attribuito a una  prenotazione
	 * @return tempoutilizzo che rappresenta il tempo di utilizzo attribuito a una  prenotazione
	 */
	public int getTempoutilizzo() 
	{
		return tempoutilizzo;
	}
	/**
	 * Metodo di tipo setter che permette di settare il tempo di utilizzo da attribuire alla prenotazione
	 * @param tempoutilizzo che rappresenta il tempo di utilizzo da attribuire alla prenotazione
	 */
	public void setTempoutilizzo(int tempoutilizzo) 
	{
		this.tempoutilizzo = tempoutilizzo;
	}
	/**
	 * Metodo di tipo getter che restituisce la tariffa del campo attribuita a una prenotazione
	 * @return tariffaore che rappresenta la tariffa del campo attribuita a una  prenotazione
	 */
	public static int getTariffaore() 
	{
		return tariffaore;
	}
	/**
	 * Metodo di tipo setter che permette di settare la tariffa del campo da attribuire a una prenotazione
	 * @return tariffaore che rappresenta la tariffa del campo da attribuire a una  prenotazione
	 */
	public static void setTariffaore(int tariffaore1) 
	{
		tariffaore = tariffaore1;
	}
	/**
	 * Metodo di tipo getter che restituisce la tariffa delle docce attribuita a una prenotazione
	 * @return tariffadocce che rappresenta la tariffa delle docce attribuita a una  prenotazione
	 */
	public static int getTariffadocce()
	{
		return tariffadocce;
	}
	/**
	 * Metodo di tipo setter che permette di settare la tariffa delle docce da attribuire a una prenotazione
	 * @return tariffadocce che rappresenta la tariffa delle docce da attribuire a una  prenotazione
	 */
	public static void setTariffadocce(int tariffadocce1) 
	{
		tariffadocce = tariffadocce1;
	}
	/**
	 * Metodo toString che restituisce una stringa composta
	 * dal codice, il cognome, il nome e una data che sono stati attribuiti a una prenotazione
	 */
	public String toString()
	{
		return ("codice= "+this.getCodiceIdentificativo()+"\tcognome="+this.getCognome()+"\tnome="+this.getNome()+"\tdata  "+this.getDatainizio().getDayOfMonth()+"/"+this.getDatainizio().getMonthValue()+"/2018");
	}



	
}

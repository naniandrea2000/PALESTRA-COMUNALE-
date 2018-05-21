import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.io.BufferedReader;
/**
 * La classe rappresenta una palestra e le relative prenotazioni,è semplicemente una lista di prenotazioni
 * gli attributi sono: il puntatore head di tipo nodo e il numero di elementi(prenotazioni) della nostra palestra
 * La classe ci permette di gestire la nostra palestra
 *  
 * @author Nani Andrea
 * @version 1.0
 */
public class Partita implements Serializable
{
	private nodo head;
	private int elementi;
	
	/**
	 *Costruttore della lista,ci permette di creare una lista(partita) vuota
	 *ovvero senza alcuna prenotazione registrata
	 */
	public Partita()
	{
		head=null;
		elementi=0;
	}
	/**
	 * Metodo getter che restituisce il numero di elementi di cui è composta la nostra Partita,
	 * ovvero il numero di prenotazioni presenti nella lista
	 * @return elementi, rappresenta il numero di Prenotazioni presenti nella lista
	 */
	public int getElementi()
	{
		return elementi;
	}
	/**
	 * Classe che ci consente di creare un nuovo nodo nella nostra lista
	 * 
	 * @param p è un oggetto di tipo Prenotazione
	 * @param link è un oggetto di tipo nodo
	 * @return nodo è un nodo istanziato nel metodo
	 */
	private nodo creaNodo(Prenotazione p,nodo link)
	{
		nodo nodo=new nodo(p);
		nodo.setLink(link);
		return nodo;
	}
	/**
	 * metodo che ci consente di inserire una determinata prenotazione
	 * in un nodo della lista
	 * 
	 * @param info è un oggetto di tipo Prenotazione e non è altro che la prenotazioneche vogliamo inserire nella lista
	 */
	public void inserisciPrenotazione(Prenotazione info)
	{
		nodo p=creaNodo(info, head);
		head=p;
		elementi++;
	}
	/**
	 * Metodo privato che restituisce un oggetto di tipo nodo in una detrminata posizione
	 * @param posizione che rappresenta la posizione nella quale è presente il nodo da estrarre
	 * @return p che rappresenta il nodo cercato
	 * @throws partitaException eccezione che si verifica quando la posizione non è valida o la lista è vuota
	 */
	private nodo getLinkPosizione(int posizione) throws partitaException
	{
		if (elementi==0) 
		{
			throw new partitaException("lista vuota");
		}
		if (posizione<0||posizione>elementi) 
		{
			throw new partitaException("posizione non valida");
		}
		nodo p;
		p=head;
		int n=1;
		while(p.getLink()!=null&&n<posizione)
		{
			p=p.getLink();
			n++;
		}
		return p;
	}
	/**
	 * Metodo che permette di inserire una determinata prenotazione in testa alla lista
	 * @param p rappresenta la prenotazione da inserire in testa
	 */
	public void inserisciInTesta(Prenotazione p)
	{
		nodo p1=creaNodo(p, head);
		head=p1;
		elementi++;
	}
	/**
	 * Metodo che restituisce una stringa con i dati relativi alle prenotazioni
	 * presenti nella lista
	 */
	public String toString()
	{
		String risultato="elenco prenotazioni palestra: ";
		if (elementi==0)
			return risultato+="nessuna prenotazione";
		nodo p=head;
		while(p!=null)
		{
			risultato+='\n'+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	/**
	 * Metodo che permette di inserire una determinata prenotazione in coda alla lista
	 * @param p rappresenta la prenotazione da inserire in coda
	 * @throws partitaException eccezione che si verifica quando la lista è vuota
	 */
	public void inserisciInCoda(Prenotazione p) throws partitaException 
	{
		if (elementi==0) 
		{
			inserisciInTesta(p);
			return;
		}
		nodo pn=creaNodo(p, null);
		nodo p1=getLinkPosizione(elementi);
		p1.setLink(pn);
		elementi++;
	}
	/**
	 * Metodo che permette di inserire una determinata prenotazione in una determinata posizione della lista
	 * @param p rappresenta la prenotazione da inserire in coda
	 * @param posizione rappresenta la posizione nella quale inserire la prenotazione
	 * @throws partitaException eccezione che si verifica quando la posizione non è valida o la lista è vuota
	 */
	public void inserisciInPosizione(Prenotazione p,int posizione) throws partitaException
	{
		if (posizione==1) 
		{
			inserisciInTesta(p);
			return;
		}
		if (posizione<=0||posizione>elementi+1) 
		{
			throw new partitaException("posizione non valida");
		}
		
		if (posizione==elementi+1) 
		{
			inserisciInCoda(p);
			return;
		}
		
		nodo pn=creaNodo(p, getLinkPosizione(posizione));
		nodo nodoprecedente=getLinkPosizione(posizione-1);
		nodoprecedente.setLink(pn);
		elementi++;
	}
	/**
	 * Metodo che permette di eliminare la prenotazione in testa alla lista
	 */
	public void eliminaInTesta() throws partitaException
	{
		if (elementi==0) 
		{
			throw new partitaException("lista vuota");
		}
		head=head.getLink();
		elementi--;
	}
	/**
	 * Metodo che permette di eliminare la prenotazione in coda alla lista
	 */
	public void eliminaInCoda() throws partitaException
	{
		if (elementi==0) 
		{
			throw new partitaException("lista vuota");
		}
		if (elementi==1) 
		{
			eliminaInTesta();
			elementi--;
		}
		nodo penultimo=getLinkPosizione(elementi-1);
		penultimo.setLink(null);
		elementi--;
	}
	/**
	 * Metodo che permette di eliminare la prenotazione presente in una posizione della lista
	 * @param posizione rappresenta la posizione nella quale è presente la prenotazione da eliminare
	 * @throws partitaException eccezione che si verifica quando la posizione non è valida o la lista è vuota
	 */
	public void eliminaInPosizione(int posizione) throws partitaException
	{
		if (elementi==0) 
		{
			throw new partitaException("lista vuota");
		}
		if (posizione<=0||posizione>elementi) 
		{
			throw new partitaException("posizione non valida");
		}
		if (posizione==1)
		{
			eliminaInTesta();
			elementi--;
			return;
		}
		if (posizione==elementi)
		{
			eliminaInCoda();
			elementi--;
			return;
		}
		nodo p=getLinkPosizione(posizione);
		nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
	}
	/**
	 * Metodo che permette di estrarre i dati di una prenotazione presente in una posizione della lista
	 * @param posizione rappresenta la posizione nella quale è presente la prenotazione con i dati necessari
	 * @throws partitaException eccezione che si verifica quando la posizione non è valida o la lista è vuota
	 */
	public String visita(int posizione) throws partitaException
	{
		if (elementi==0) 
		{
			throw new partitaException("lista vuota");
		}
		if (elementi<=0||posizione>elementi) 
		{
			throw new partitaException("posizione non valida");
		}
		nodo p=getLinkPosizione(posizione);
		return (p.getInfo().toString());
	}
	/**
	 * Metodo che permette di recuperare i dati di una prenotazione in una determinata posizione
	 * @param posizione rappresenta la posizione nella quale sono presenti i dati
	 * @return p1 dati della prenotazione nella posizione desiderata
	 * @throws partitaException eccezione che si verifica quando la lista è vuota o la posizione non è valida
	 */
	public Prenotazione getInfo(int posizione) throws partitaException
	{
		if (elementi==0) 
		{
			throw new partitaException("lista vuota");
		}
		if (elementi<=0||posizione>elementi) 
		{
			throw new partitaException("posizione non valida");
		}
		nodo p=getLinkPosizione(posizione);
		Prenotazione p1=new Prenotazione(p.getInfo());
		return(p1);
	}
	/**
	 * Metodo che consente di trasformare una lista in un array per facilitarne l'uso
	 * @return arrayp che rappresenta l'array di prenotazioni ricavato dalla lista
	 * @throws partitaException eccezione che si verifica quando la posizione non è valida o la lista è vuota
	 */
	public Prenotazione[] arrayprenotazioni() throws partitaException
	{
		Prenotazione[] arrayp=new Prenotazione[elementi];
		for (int i = 0; i < arrayp.length; i++) 
		{
			nodo p1=getLinkPosizione(i+1);
			arrayp[i]=p1.getInfo();
		}
		return arrayp;
	}
	/**
	 * Metodo che calcola il prezzo di una determinata prenotazione
	 * @param p che rappresenta la prenotazione della quale si desidera calcolare il prezzo
	 * @return prezzo che rappresenta il prezzo della prenotazione
	 */
	public int calcolaPrezzo(Prenotazione p)
	{
		int prezzocampo=0;
		int prezzodocce=0;
		int prezzo=0;
		prezzocampo=p.getTariffaore()*p.getTempoutilizzo();
		prezzodocce=p.getTariffadocce()*p.getTempoutilizzo();
		prezzo=prezzocampo+prezzodocce;
		return prezzo;
	}
	/**
	 * Metodo che permette di aggiungere una prenotazione alla nostra lista
	 * @param p rappresenta la prenotazione che si vuole aggiungere alla lista
	 * @throws partitaException eccezione che si verifica quando la lista è vuota oppure la posizione non è valida o la palestra è già occupata in quella data o il codice della prenotazione è gia in uso
	 */
	public void registraPrenotazione(Prenotazione p) throws partitaException
	{
		
		LocalDateTime datafine1=LocalDateTime.of(p.getDatainizio().getYear(), p.getDatainizio().getMonth(), p.getDatainizio().getDayOfMonth(),p.getDatainizio().getHour(),p.getDatainizio().getMinute());
		datafine1=datafine1.plusHours(p.getTempoutilizzo());
		if (elementi==0)
		{
			this.inserisciInTesta(p);
			return;
		}
		else
		{
			Prenotazione[] arrayp;
			arrayp=this.arrayprenotazioni();

			for (int i = 0; i < arrayp.length; i++) 
			{
				LocalDateTime datafine2=LocalDateTime.of(arrayp[i].getDatainizio().getYear(),arrayp[i].getDatainizio().getMonth(), arrayp[i].getDatainizio().getDayOfMonth(),arrayp[i].getDatainizio().getHour(),arrayp[i].getDatainizio().getMinute());
				datafine2=datafine2.plusHours(arrayp[i].getTempoutilizzo());
				if(arrayp[i].getDatainizio().compareTo(p.getDatainizio())==0||arrayp[i].getDatainizio().isBefore(p.getDatainizio())==true&&p.getDatainizio().isBefore(datafine2)==true||p.getDatainizio().isBefore(arrayp[i].getDatainizio())&&datafine1.isAfter(arrayp[i].getDatainizio()))
				{
					throw new partitaException("Palestra già occupata");
				}
			}
			for (int i = 0; i < arrayp.length; i++) 
			{
				if(arrayp[i].getCodiceIdentificativo()==p.getCodiceIdentificativo())
				{
					throw new partitaException("Codice già utilizzato reinserire prenotazione con codice diverso");
				}
			}
			this.inserisciInCoda(p);
			System.out.println("prenotazione effetuata");
			return;
		}
	}
	/**
	 * Metodo che permette di elimanre una prenotazione dalla lista
	 * @param p rappresenta la prenotazione che si vuole eliminare alla lista
	 * @param c rappresenta il codice della prenotazione che si vuole eliminare
	 * @throws partitaException eccezione che si verifica quando la lista è vuota o il codice non è relativo a nessuna prenotazione
	 */
	public void EliminaPrenotazione(Partita p,int c) throws partitaException 
	{
		if (elementi==0)
		{
			throw new partitaException("Nessuna prenotazione presente");
		}
		
		for (int i = 1; i <= p.getElementi(); i++) 
		{
			if (getInfo(i).getCodiceIdentificativo()==c)
			{
				if (i==1)
				{
					eliminaInTesta();
					System.out.println("eliminazione avvenuta con successo");
					return;
				}
				if(i==p.getElementi())
				{
					eliminaInCoda();
					System.out.println("eliminazione avvenuta con successo");
					return;
				}
				eliminaInPosizione(i);
				System.out.println("eliminazione avvenuta con successo");
				return;
			}
		}
		throw new partitaException("Nessuna prenotazione con questo codice identificativo");
	}
	/**
	 * Metodo che permette di registrare la fine di una prenotazione calcolando automaticamente
	 * il prezzo ed eliminando la prenotazione dalla lista inserndo il prezzo in un file di testo
	 * @param p rappresenta la prenotazione della quale si desidera registrare la fine della prenotazione
	 * @param codice rappresenta il codice della prenotazione della quale si desidera registrare la fine della prenotazione
	 * @throws partitaException eccezione che si verifica quando la lista è vuota o il codice non è relativo a nessuna prenotazione
	 * @throws IOException eccezione che si verifica per errori nella scrittura del file
	 * @throws FileException eccezione che si verifica quando si verifica un errore nel salvataggio della stringa nel file
	 */
	public void finePartita(Partita p,int codice) throws  IOException, partitaException, FileException
	{
		if (elementi==0)
		{
			throw new partitaException("Nessuna prenotazione presente");
		}
		
		Textfile file=new Textfile("pagamento.txt",'W');
		Prenotazione[] arrayp;
		arrayp=this.arrayprenotazioni();

		for (int i = 0; i < arrayp.length; i++) 
		{
			if(arrayp[i].getCodiceIdentificativo()==codice)
			{
				System.out.println("il prezzo è: "+p.calcolaPrezzo(arrayp[i])+"€");
				file.tofile("Nome="+arrayp[i].getNome()+" Cognome="+arrayp[i].getCognome()+" ora inizio="+arrayp[i].getDatainizio().getHour()+":"+arrayp[i].getDatainizio().getMinute()+'\t'+"data inizio= "+arrayp[i].getDatainizio().getDayOfMonth()+"/"+arrayp[i].getDatainizio().getMonthValue()+"/2018"+" ora fine= "+arrayp[i].getDatainizio().plusHours(arrayp[i].getTempoutilizzo())+":"+arrayp[i].getDatainizio().getMinute()+"  "+"data fine= "+arrayp[i].getDatainizio().getDayOfMonth()+"/"+arrayp[i].getDatainizio().getMonthValue()+"/2018"+ " PAGAMENTO EFFETTUATO");
				file.closFile();
				System.out.println("scritture effettuata correttamente");
			}
		}
		for (int i = 1; i <= p.getElementi(); i++) 
		{
			if (getInfo(i).getCodiceIdentificativo()==codice)
			{
				if (i==1)
				{
					eliminaInTesta();
					System.out.println("eliminazione avvenuta con successo");
					return;
				}
				if(i==p.getElementi())
				{
					eliminaInCoda();
					System.out.println("eliminazione avvenuta con successo");
					return;
				}
				eliminaInPosizione(i);
				System.out.println("eliminazione avvenuta con successo");
				return;
			}
		}
		throw new partitaException("Nessuna prenotazione con questo codice");
		
	}
	/**
	 * Metodo che permette di scambiare due prenotazioni presenti nell'array
	 * @param array rappresenta l'array di prenotazioni nel quale si desidera eseguire lo scambio
	 * @param pos1 rappresenta la posizione di una prenotazione che si deve scambiare
	 * @param pos2 rappresenta la posizione di una prenotazione che si deve scambiare
	 */
	public static int scambia(Prenotazione[] array, int pos1, int pos2)
	{
		Prenotazione p;
		if(pos1<0 || pos1>=array.length || pos2<0 ||pos2>=array.length)
			return -1;
		p=new Prenotazione(array[pos1]);
		array[pos1]=new Prenotazione(array[pos2]);
		array[pos2]=new Prenotazione(p);
		return 0;
	}
	/**
	 * Metodo che permette di copiare un array di prenotazioni 
	 * @param array rappresenta l'array che si desidera copiare
	 * @return arraycopia è l'array di copia
	 */
	public static Prenotazione[] copia(Prenotazione[] array)
	{
		Prenotazione[] arrayCopia=new Prenotazione[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
		{
			arrayCopia[i]=array[i];	
		}
		return arrayCopia;
	}
	/**
	 * Metodo che permette di ordinare un array in ordine crescente in base alla data
	 * @param p rappresenta la lista(ovvero la partita)che si desidera ordinare
	 * @return arrayordinato è l'array ordinato in base alla data
	 */
	public  Prenotazione[] selectionSortCrescenteData(Partita p) throws partitaException
	{
		if (elementi==0)
		{
			throw new partitaException("Nessuna prenotazione presente");
		}
		Prenotazione[] array;
		array=p.arrayprenotazioni();
		Prenotazione[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].getDatainizio().isBefore(arrayOrdinato[i].getDatainizio()))
					scambia(arrayOrdinato, i, j);
			}
		}
		
		return arrayOrdinato;
	}
	/**
	 * Metodo che permette di ordinare un array in ordine crescente in base al nome
	 * @param p rappresenta la lista(ovvero la partita)che si desidera ordinare
	 * @return arrayordinato è l'array ordinato in base al nome
	 * * @throws partitaException eccezione che si verifica quando la lista è vuota
	 */
	public Prenotazione[] selectionSortCrescenteNome(Partita p) throws partitaException
	{
		if (elementi==0)
		{
			throw new partitaException("Nessuna prenotazione presente");
		}
		Prenotazione[] array;
		array=p.arrayprenotazioni();
		Prenotazione[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if (arrayOrdinato[j].getNome().compareTo(arrayOrdinato[i].getNome())<0)
				{
					scambia(arrayOrdinato, i , j);
				}
			}
		}
		return arrayOrdinato;
	}
	/**
	 * Metodo che permette di modificare le tariffe di una determinata prenotazione
	 * @param p rappresenta la lista(ovvero la partita) nella quale è presente la prenotazione desiderata
	 * @param tariffacampo è il nuovo valore della tariffa del campo da attribuire alla prenotazione
	 * @param tariffadoccia è il nuovo valore della tariffa delle docce da attribuire alla prenotazione
	 * @param codice rappresenta il codice della prenotazione della quale si desidera modificare le tariffe
	 * @throws partitaException eccezione che si verifica quando la lista è vuota o il codice non è relativo a nessuna prenotazione
	 */
	public void modificaTariffePalestra(int tariffacampo,int tariffadoccia,int codice) throws partitaException
	{
		if (elementi==0)
		{
			throw new partitaException("Nessuna prenotazione presente");
		}
		for (int i = 1; i <= this.getElementi(); i++) 
		{
			if (this.getInfo(i).getCodiceIdentificativo()==codice)
			{
				this.getInfo(i).setTariffaore(tariffacampo);
				this.getInfo(i).setTariffadocce(tariffadoccia);
				System.out.println("Modifica avvenuta con successo");
				return;
			}
		}
		throw new partitaException("nessuna prenotazione con questo codice identificativo");
	}
	/**
	 * Metodo che permette di verificare la disponibilità di una palestra in una data
	 * @param p rappresenta la lista(ovvero la partita) nella quale si vuole verificare la disponibilità
	 * @param mese rappresenta il mese nel quale si vuole verificare la disponibilità
	 * @param giorno rappresenta il giorno nel quale si vuole verificare la disponibilità
	 * @param ora rappresenta l'ora nella quale si vuole verificare la disponibilità
	 * @throws partitaException eccezione che si verifica quando la lista è vuota o è occupata oppure è libera
	 */
	public void verificaDisponibilità(Partita p,int mese,int giorno,int ora,int minuti) throws partitaException
	{
		
		if (elementi==0)
		{
			throw new partitaException("Nessuna prenotazione presente,la palestra è libera");
		}
		
		LocalDateTime d=LocalDateTime.of(2018, mese, giorno, ora, minuti);

		Prenotazione[] array;
		array=p.arrayprenotazioni();
		for (int i = 0; i < array.length; i++)
		{
			LocalDateTime datafine=LocalDateTime.of(array[i].getDatainizio().getYear(),array[i].getDatainizio().getMonth(), array[i].getDatainizio().getDayOfMonth(),array[i].getDatainizio().getHour(),array[i].getDatainizio().getMinute());
			datafine=datafine.plusHours(array[i].getTempoutilizzo());
			if(array[i].getDatainizio().compareTo(d)==0||array[i].getDatainizio().isBefore(d)&&datafine.isAfter(d))
			{
				throw new partitaException("ATTENZIONE PALESTRA OCCUPATA");
			}
		}
		throw new partitaException("PALESTRA LIBERA");
	}
	/**
	 * Metodo che consente di salvare una lista di prenotazioni in un file binario
	 * @param nomeFile rappresenta il nome del file sul quale si vuole salvare la prenotazione
	 * @throws IOException eccezione che si verifica per errori nella scrittura del file
	 */
	public void salvaLista(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	/**
	 * Metodo che consente di caricare un'oggetto di tipo prenotazione effettuandone la deserializzazione da un file binario
	 * @param nomeFile rappresenta il nome del file binario da deserializzare
	 * @return p rappresenta la lista di prenotazioni deserializzata
	 * @throws IOException eccezione che si verifica per errori durante il caricamento della prenotazione
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare la prenotazione
	 */
	public Partita caricaLista (String nomeFile) throws IOException, ClassNotFoundException 
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Partita p;
		p=(Partita)(reader.readObject());
		file.close();
		return p;
	}
}

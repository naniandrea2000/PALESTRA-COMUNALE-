import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Lista implements Serializable
{
	private Prenotazione[] elencoBarche;
	
	private nodo head;
	private int elementi;
	
	public Lista()
	{
		head=null;
		elementi=0;
	}
	public void inserisciBarca (Prenotazione p1)
	{
		
		nodo p=new nodo(p1);
		head=p;
		elementi++;
	}
	

	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato+="-->";
		nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	
	public void salvaLista(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	
	public Lista caricaLista (String nomeFile) throws IOException, ClassNotFoundException 
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Lista l1;
		
		l1=(Lista)(reader.readObject());
		file.close();
		return l1;
	}
	
	
	
}

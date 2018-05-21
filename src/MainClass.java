import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.xml.bind.DataBindingException;

public class MainClass {

	public static void main(String[] args)  
	{
		ConsoleInput tastiera=new ConsoleInput();
		int mese,giorno,ora,minuti;
		int sceltamenu=0;
		LocalDateTime oraAttuale;
		
		String[] elenco= {"1-Inserisci nuova prenotazione","2-Elimina prenotazione","3-Registra fine partita","4-Visualizza elenco prenotazioni in base al nome","5-Visualizza elenco prenotazioni in base alla data", "6-modifica tariffe palestra","7-verifica diponibilitÓ campo","0-ESCI"};
		System.out.println("BENVENUTO NELLA PALESTRA COMUNALE DI DARFO");
		Partita p1=new Partita();
		Menu m1=new Menu("PRENOTAZIONI",elenco);
		String nomeFile = "prenotazioni.bin";
		
		try 
		{
			p1=p1.caricaLista("prenotazioni.bin");
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			System.out.println("Impossibile caricare la lista");
		}
		
		do 
		{
		sceltamenu=m1.scelta();			
		switch (sceltamenu) 
		{
			case 1:
				Prenotazione p=new Prenotazione();
			try {
				
				System.out.println("Inserisci codice identificativo: ");
				p.setCodiceIdentificativo(tastiera.ReadInt());
				System.out.println("Inserisci il tuo cognome: ");
				p.setCognome(tastiera.ReadString());
				System.out.println("Inserisci il tuo nome: ");
				p.setNome(tastiera.ReadString());
				System.out.println("Inserisci data prenotazione");
				System.out.print("mese(numero): ");
				mese=tastiera.ReadInt();
				System.out.print("giorno(numero): ");
				giorno=tastiera.ReadInt();
				System.out.print("Ora: ");
				ora=tastiera.ReadInt();
				System.out.print("minuti:");
				minuti=tastiera.ReadInt();
				oraAttuale=LocalDateTime.of(2018,mese,giorno,ora,minuti,0);
				p.setDatainizio((oraAttuale));
				System.out.println("Inserisci le ore di utilizzo del campo= ");
				p.setTempoutilizzo(tastiera.ReadInt());
				
				
			} 
			catch (NumberFormatException e1) 
			{
				System.out.println("formato inserito errato..REINSERIRE I DATI");
				break;
			} 
			catch (IOException e1)
			{
				System.out.println("impossibile leggerere dato");
				break;
			}
			catch (DateTimeException e1)
			{
				System.out.println("data inserita errata..REINSERIRE");
				break;
			}
			try 
			{
				p1.registraPrenotazione(p);
			}
			catch (partitaException e1) 
			{
				
				System.out.println(e1.toString());
				break;
			}
			try 
			{
				p1.salvaLista("prenotazioni.bin");
			} 
			catch (IOException e1) 
			{
				System.out.println("impossibile scrivere dati di input");
			}
				
				

			break;
		case 2:
			int c=0;
			
			try 
			{
				System.out.println("inserisci il codice della prenotazione che desideri eliminare: ");
				c=tastiera.ReadInt();
			} catch (NumberFormatException e4) 
			{
				System.out.println("Formato inserito non corretto");
			} catch (IOException e4) 
			{
				System.out.println("impossibile leggere dati");
			}
			try 
			{
				p1.EliminaPrenotazione(p1,c);
			} 
			catch (NumberFormatException e1) 
			{
				System.out.println("formato inserito errato..REINSERIRE I DATI");
				break;
			} 
			catch (partitaException e1) 
			{
				System.out.println(e1.toString());
				break;
			} 

			try 
			{
				p1.salvaLista("prenotazioni.bin");
			} 
			catch (IOException e1) 
			{
				System.out.println("impossibile scrivere dati di input");
			}
			break;
			
		case 3:
			int codice=0;
			
			try 
			{
				System.out.println("inserisci il codice della tua prenotazione: ");
				codice=tastiera.ReadInt();
			} 
			catch (NumberFormatException e3) 
			{
				System.out.println("formato inserito errato..REINSERIRE I DATI");
			} 
			catch (IOException e3) 
			{
				System.out.println("impossibile leggere dati");
			}
			
			try 
				{
					p1.finePartita(p1,codice);
				} 
				catch (FileException e) 
				{
					System.out.println("errore durante la scrittura sul file");
					break;
				}
				catch (IOException e) 
				{
					System.out.println("impossibile leggere dati di input");
					break;
				}
				catch (partitaException e) 
				{
					System.out.println(e.toString());
					break;
				}
			try 
			{
				p1.salvaLista("prenotazioni.bin");
			} 
			catch (IOException e1) 
			{
				System.out.println("impossibile scrivere dati di input");
			}
			break;
		case 4:
			try {
				Prenotazione[] p2=new Prenotazione[p1.getElementi()];
				p2=p1.selectionSortCrescenteNome(p1);
				System.out.println("PRENOTAZIONI IN ORDINE DI NOME: ");
				for (int i = 0; i < p2.length; i++) 
				{
					System.out.println(p2[i].toString());
				}
				}
				catch (partitaException e) 
				{
					System.out.println(e.toString());
					break;
				} 
			
				break;
		case 5:
			
			try {
				Prenotazione[] p2=new Prenotazione[p1.getElementi()];
				p2=p1.selectionSortCrescenteData(p1);
				System.out.println("PRENOTAZIONI IN ORDINE DI TEMPO:");
				for (int i = 0; i < p2.length; i++) 
				{
					System.out.println(p2[i].toString());
					
				}
			
				} 
				catch (partitaException e) 
				{
					System.out.println(e.toString());
					break;
				} 
			
				break;
		case 6:
			int tariffacampo=0;
			int tariffadoccia=0;
			int codice1=0;
			
			try 
			{
				System.out.println("inserisci il codice della prenotazione per modificare le tariffe: ");
				codice1=tastiera.ReadInt();
				System.out.println("Inserire tariffa campo: ");
				tariffacampo=tastiera.ReadInt();
				System.out.println("Inserire tariffa docce: ");
				tariffadoccia=tastiera.ReadInt();
			} 
			catch (NumberFormatException e2) 
			{
				System.out.println("formato inserito errato..REINSERIRE I DATI");
			} 
			catch (IOException e2) 
			{
				System.out.println("impossibile leggere dati");
			}
			
			try 
			{
				p1.modificaTariffePalestra(tariffacampo,tariffadoccia,codice1);
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("formato inserito errato..REINSERIRE I DATI");
				break;
			} 
			catch (partitaException e) 
			{
				System.out.println(e.toString());
				break;
			}
			break;
		case 7:	
			
					int mese1=0;
					int giorno1=0;
					int ora1=0;
					int minuti1=0;
					
			try 
			{
				System.out.println("inserisci il mese in cui vorresti verificare la disponibilitÓ(in numero): ");
				mese1=tastiera.ReadInt();
				System.out.println("inserisci il giorno in cui vorresti verificare la disponibilitÓ(in numero): ");
				giorno1=tastiera.ReadInt();
				System.out.println("inserisci l'ora in cui vorresti verificare la disponibilitÓ: ");
				ora1=tastiera.ReadInt();
				System.out.println("inserisci i minuti in cui vorresti verificare la disponibilitÓ: ");
				minuti1=tastiera.ReadInt();
			}
			catch (NumberFormatException e1) 
			{
				System.out.println("formato inserito errato..REINSERIRE I DATI");
			} 
			catch (IOException e1) 
			{
				System.out.println("impossibile leggere dati");
			}
					
			try
			{
				
				p1.verificaDisponibilitÓ(p1,mese1,giorno1,ora1,minuti1);
			} 
			 catch (NumberFormatException e) 
			{
				 System.out.println("formato inserito errato..REINSERIRE I DATI");
				break;
			} 
			catch (partitaException e)
			{
				System.out.println(e.toString());
				break;
			}
			break;
		case 0:
			System.out.println("ARRIVEDERCI");
			break;
		default:
				break;
			}
		}while(sceltamenu!=0);
	}
}
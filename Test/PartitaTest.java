import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDateTime;

import org.junit.Test;

public class PartitaTest 
{
	@Test
	public void testCostruttorePartita() throws partitaException 
	{
		Partita p=new Partita();
		assertTrue("costruttore partita", p.getElementi()==0);
	}
	@Test
	public void TestinserisciPrenotazione()
	{
		LocalDateTime data1=LocalDateTime.now();
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Partita p1=new Partita();
		p1.inserisciPrenotazione(p);
		assertTrue("metodo inserisci prenotazione", p1.getElementi()==1);
	}
	@Test 
	public void testToStringVuoto() 
	{
		Partita p=new Partita();
		assertTrue("toString vuoto",p.toString().compareToIgnoreCase("elenco prenotazioni palestra: nessuna prenotazione")==0);
	}
	@Test
	public void testToString() throws partitaException 
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Partita p1=new Partita();
		p1.inserisciPrenotazione(p);
		assertTrue("tostring",p1.toString().compareToIgnoreCase("elenco prenotazioni palestra: \n" + 
													"codice= 1	cognome=nani	nome=andrea	data  1/1/2018")==0);
		
	}
	@Test
	public void TestInserisciInTesta()
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Partita p1=new Partita();
		p1.inserisciInTesta(p);
		assertTrue("inserisci in testa",p1.toString().compareToIgnoreCase("elenco prenotazioni palestra: \n" + 
				"codice= 1	cognome=nani	nome=andrea	data  1/1/2018")==0);
	}
	@Test
	public void TestInserisciInCoda() throws partitaException
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p2=new Prenotazione(2,"a","a",data1,1);
		Partita p1=new Partita();
		p1.inserisciInTesta(p);
		p1.inserisciInCoda(p2);
		assertTrue("inserisci in coda",p1.toString().compareToIgnoreCase("elenco prenotazioni palestra: \n" + 
				"codice= 1	cognome=nani	nome=andrea	data  1/1/2018\n"+
				"codice= 2	cognome=a	nome=a	data  1/1/2018")==0);
	}
	@Test
	public void TestEliminaIntesta() throws partitaException
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p2=new Prenotazione(2,"a","a",data1,1);
		Partita p1=new Partita();
		p1.inserisciInTesta(p);
		p1.inserisciInCoda(p2);
		p1.eliminaInTesta();
		assertTrue("elimina in testa",p1.toString().compareToIgnoreCase("elenco prenotazioni palestra: \n" + 
				"codice= 2	cognome=a	nome=a	data  1/1/2018")==0);
	}
	@Test
	public void TestEliminaInCoda() throws partitaException
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p2=new Prenotazione(2,"a","a",data1,1);
		Partita p1=new Partita();
		p1.inserisciInTesta(p);
		p1.inserisciInCoda(p2);
		p1.eliminaInCoda();
		assertTrue("elimina in coda",p1.toString().compareToIgnoreCase("elenco prenotazioni palestra: \n" + 
				"codice= 1	cognome=nani	nome=andrea	data  1/1/2018")==0);
	}
	@Test
	public void TestCalcolaPrezzo()
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Partita p1=new Partita();
		p1.inserisciPrenotazione(p);
		assertTrue("Calcola Prezzo",p1.calcolaPrezzo(p)==35);
	}
	@Test
	public void TestRegistraPrenotazione() throws partitaException
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Partita p1=new Partita();
		p1.registraPrenotazione(p);
		assertTrue("Registra Prenotazione",p1.toString().compareToIgnoreCase("elenco prenotazioni palestra: \n" + 
				"codice= 1	cognome=nani	nome=andrea	data  1/1/2018")==0);
	}
	@Test (expected=partitaException.class)
	public void RegistraPrenotazioneStessaData() throws partitaException 
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p2=new Prenotazione(p);
		Partita p1=new Partita();
		p1.registraPrenotazione(p);
		p1.registraPrenotazione(p2);
	}
	@Test 
	public void TestEliminaPrenotazione() throws partitaException
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		LocalDateTime data2=LocalDateTime.of(2,2,2,2,2);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p2=new Prenotazione(2,"a","a",data2,1);
		Partita p1=new Partita();
		p1.registraPrenotazione(p);
		p1.registraPrenotazione(p2);
		p1.EliminaPrenotazione(p1, 2);
		assertTrue("elimina in coda",p1.toString().compareToIgnoreCase("elenco prenotazioni palestra: \n" + 
				"codice= 1	cognome=nani	nome=andrea	data  1/1/2018")==0);
	}
	@Test (expected=partitaException.class)
	public void TestEliminaPrenotazioneCodiceInesistente() throws partitaException
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		LocalDateTime data2=LocalDateTime.of(2,2,2,2,2);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p2=new Prenotazione(2,"a","a",data2,1);
		Partita p1=new Partita();
		p1.registraPrenotazione(p);
		p1.registraPrenotazione(p2);
		p1.EliminaPrenotazione(p1, 3);

	}
	@Test
	public void TestFinePartita() throws partitaException, IOException, FileException
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Partita p1=new Partita();
		p1.registraPrenotazione(p);
		p1.finePartita(p1, 1);
		assertTrue("Registra Prenotazione",p1.getElementi()==0);
	}
	@Test (expected=partitaException.class)
	public void TestFinePartitaConErrore() throws partitaException, IOException, FileException
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		LocalDateTime data2=LocalDateTime.of(2,2,2,2,2);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p2=new Prenotazione(2,"a","a",data2,1);
		Partita p1=new Partita();
		p1.registraPrenotazione(p);
		p1.registraPrenotazione(p2);
		p1.finePartita(p1, 3);
	}
	@Test
	public void TestselectionSortCrescenteData() throws partitaException
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		LocalDateTime data2=LocalDateTime.of(2,2,2,2,2);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p2=new Prenotazione(2,"a","a",data2,1);
		Partita p1=new Partita();
		p1.registraPrenotazione(p);
		p1.registraPrenotazione(p2);
		p1.arrayprenotazioni();
		p1.selectionSortCrescenteData(p1);
	}
	@Test
	public void TestselectionSortCrescenteNome() throws partitaException
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		LocalDateTime data2=LocalDateTime.of(2,2,2,2,2);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p2=new Prenotazione(2,"a","a",data2,1);
		Partita p1=new Partita();
		p1.registraPrenotazione(p);
		p1.registraPrenotazione(p2);
		p1.arrayprenotazioni();
		p1.selectionSortCrescenteNome(p1);
		
	}
	@Test
	public void TestModificaTariffePalestra() throws partitaException
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		LocalDateTime data2=LocalDateTime.of(2,2,2,2,2);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p2=new Prenotazione(2,"a","a",data2,1);
		Partita p1=new Partita();
		p1.registraPrenotazione(p);
		p1.registraPrenotazione(p2);
		p1.modificaTariffePalestra(1, 1);
		assertTrue("Tariffe Palestra",p.getTariffaore()==1&&p.getTariffadocce()==1);
	}
	@Test
	public void TestVerificaDisponibilit‡() throws partitaException
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		LocalDateTime data2=LocalDateTime.of(2,2,2,2,2);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p2=new Prenotazione(2,"a","a",data2,1);
		Partita p1=new Partita();
		p1.registraPrenotazione(p);
		p1.registraPrenotazione(p2);
		p1.verificaDisponibilit‡(p1, 5, 5, 5, 5);
	}
	@Test(expected=partitaException.class)//per la data uguale a quella di p
	public void TestVerificaDisponibilit‡ConErrore() throws partitaException
	{
		LocalDateTime data1=LocalDateTime.of(2018,1,1,1,1);
		LocalDateTime data2=LocalDateTime.of(2018,2,2,2,2);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p2=new Prenotazione(2,"a","a",data2,1);
		Partita p1=new Partita();
		p1.registraPrenotazione(p);
		p1.registraPrenotazione(p2);
		p1.verificaDisponibilit‡(p1,1,1,1,1);
	}
	
}

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class PrenotazioneTest {
	
	@Test
	public void testCostruttorePrenotazione() 
	{
		LocalDateTime data1=LocalDateTime.now();
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		assertTrue("Costruttore Prenotazione",p.getCodiceIdentificativo()==1&&p.getCognome()=="nani"&&p.getNome()=="andrea"&&p.getDatainizio()==data1&&p.getTempoutilizzo()==1);
	}
	
	@Test
	public void testCostruttoreCopiaPrenotazione() 
	{
		LocalDateTime data1=LocalDateTime.now();
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		Prenotazione p1=new Prenotazione(p);
		assertTrue("Costruttore Prenotazione",p1.getCodiceIdentificativo()==p.getCodiceIdentificativo()&&p1.getCognome()==p.getCognome()&&p1.getNome()==p.getNome()&&p1.getDatainizio()==p.getDatainizio()&&p1.getTempoutilizzo()==p.getTempoutilizzo());
	}
	@Test
	public void testCostruttorePrenotazioneDefault() 
	{
		Prenotazione p=new Prenotazione();
		assertTrue("Costruttore di default Prenotazione",p.getCodiceIdentificativo()==0&&p.getCognome()==""&&p.getNome()==""&&p.getDatainizio()==null&&p.getTempoutilizzo()==0);
	}

	@Test
	public void testSetCodiceIdentificativo() 
	{
		Prenotazione p=new Prenotazione();
		p.setCodiceIdentificativo(1);
		assertTrue("test Set Codice Identificativo",p.getCodiceIdentificativo()==1);
	}
	
	@Test
	public void testSetCognome() 
	{
		Prenotazione p=new Prenotazione();
		p.setCognome("nani");
		assertTrue("set cognome",p.getCognome()=="nani");
	}
	
	@Test
	public void testSetNome() 
	{
		Prenotazione p=new Prenotazione();
		p.setNome("andrea");
		assertTrue("set nome",p.getNome()=="andrea");
	}
	
	@Test
	public void testsetDatainizio() 
	{
		LocalDateTime data1=LocalDateTime.now();
		Prenotazione p=new Prenotazione();
		p.setDatainizio(data1);
		assertTrue("set data inizio",p.getDatainizio()==data1);
	}
	@Test
	public void testSetTempoUtilizzo() 
	{
		Prenotazione p=new Prenotazione();
		p.setTempoutilizzo(1);;
		assertTrue("set tempo utilizzo",p.getTempoutilizzo()==1);
	}
	@Test
	public void testSetTariffaCampo() 
	{
		Prenotazione p=new Prenotazione();
		p.setTariffaore(1);
		assertTrue("set tarifa campo",p.getTariffaore()==1);
	}
	@Test
	public void testSetTariffaDoccia() 
	{
		Prenotazione p=new Prenotazione();
		p.setTariffadocce(1);
		assertTrue("set tariffa doccia",p.getTariffadocce()==1);
	}
	@Test
	public void testToString() 
	{
		LocalDateTime data1=LocalDateTime.of(1,1,1,1,1);
		Prenotazione p=new Prenotazione(1,"nani","andrea",data1,1);
		assertTrue("ToString",p.toString().compareTo("codice= 1	cognome=nani	nome=andrea	data  1/1/2018")==0);
	}
	
}

import static org.junit.Assert.*;

import org.junit.Test;

public class NodoTest 
{
	
	Prenotazione p=new Prenotazione();
	Prenotazione p1=new Prenotazione();
	@Test
	public void testNodo() 
	{
		nodo n=new nodo(p);
		nodo n1=new nodo(p1);
		assertEquals(n.getInfo(),p);
		assertEquals(n.getLink(),null);
		n.setInfo(p1);
		n.setLink(n1);
		assertEquals(n.getInfo(),p1);
		assertEquals(n.getLink(),n1);
	}

	@Test
	public void testSetInfo() 
	{
		Prenotazione p=new Prenotazione();
		Prenotazione p1=new Prenotazione();
		nodo n=new nodo(p);
		n.setInfo(p1);
		assertEquals(n.getInfo(), p1);
		assertEquals(n.getLink(),null);
	}
	
	@Test
	public void testSetLink() 
	{
		Prenotazione p=new Prenotazione();
		Prenotazione p1=new Prenotazione();
		nodo n1=new nodo(p);
		nodo n2=new nodo(p1);
		n1.setLink(n2);
		assertEquals(n1.getInfo(),p1); 
		assertEquals(n1.getLink(),n2);
	}
}

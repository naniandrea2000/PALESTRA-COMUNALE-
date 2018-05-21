

public class FileException extends Exception 
{
	private String messaggio;
	
	public FileException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	public String toString()
	{
		return messaggio;
	}
}

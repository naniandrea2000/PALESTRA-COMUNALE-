

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class ConsoleInput implements Serializable
{
	private InputStreamReader input;
	private BufferedReader reader;
	
	public ConsoleInput()
	{
		input=new InputStreamReader(System.in);
		reader=new BufferedReader(input);
	}
	public int ReadInt() throws NumberFormatException, IOException
	{
		return (Integer.parseInt(reader.readLine()));
	}
	public short ReadShort() throws NumberFormatException, IOException
	{
		return (Short.parseShort(reader.readLine()));
	}
	public long ReadLong() throws NumberFormatException, IOException
	{
		return (Long.parseLong(reader.readLine()));
	}
	public byte ReadByte() throws NumberFormatException, IOException
	{
		return (Byte.parseByte(reader.readLine()));
	}
	public float ReadFloat() throws NumberFormatException, IOException
	{
		return (Float.parseFloat(reader.readLine()));
	}
	public double ReadDouble() throws NumberFormatException, IOException
	{
		return (Double.parseDouble(reader.readLine()));
	}
	public boolean ReadBoolean() throws NumberFormatException, IOException
	{
		return (Boolean.parseBoolean(reader.readLine()));
	}
	public char ReadChar() throws NumberFormatException, IOException
	{
		return (reader.readLine().charAt(0));
	}
	public String ReadString() throws NumberFormatException, IOException
	{
		return (reader.readLine());
	}
}



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.processing.FilerException;

public class Textfile 
{
	private char mode;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	public Textfile(String nomefile,char mode) throws IOException
	{
		this.mode='R';
		if (mode=='W'||mode=='w') 
		{
			this.mode='W';
			writer=new BufferedWriter(new FileWriter(nomefile,true));
		}
		else
		{
			reader=new BufferedReader(new FileReader(nomefile));
		}
	}
	public void tofile(String line) throws IOException, FileException
	{
		if (mode=='R')
			throw new FileException("file aperto in lettura");
		writer.write(line);
		writer.newLine();
	}
	
	public String fromFile() throws FileException, IOException, EccezioneTextFileEOF
	{
		String line;
		if (mode=='W')
			throw new FileException("file aperto in lettura");
		line=reader.readLine();
		if (line==null)
			throw new EccezioneTextFileEOF();
		return line;
		
	}
	public void closFile() throws IOException
	{
		if(mode=='R')
			reader.close();
		else
			writer.close();
	}
}

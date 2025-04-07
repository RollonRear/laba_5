package laba5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class VirtualWriter implements Writable{
	private VirtualWriter scripter;
	private boolean life;
	private List<String> lastString;
	private ArrayList<String> lines;
	private int step;
	
	public VirtualWriter(String script, List<String> lastString) {
		this.lastString = lastString;
		this.lastString.add(script);
		if (checkScript(script)) {
			
			life = true;
			lines = new ArrayList<String>();
			
			try (InputStreamReader isr = new InputStreamReader(
	                new FileInputStream(script), StandardCharsets.UTF_8);
	             BufferedReader reader = new BufferedReader(isr)) {
	            
	            String line;
	            while ((line = reader.readLine()) != null) {
	            	lines.add(line);
	            }
	            
	        } catch (IOException e) {
	            System.out.println("Ошибка чтения файла");
	            life = false;
	        }
			
			step=0;
		} else {
			life = false;
		}
	}
	
	@Override
	public void setScript(String script) {
		if (scripter == null)
			scripter = new VirtualWriter(script, lastString);
		else
			scripter.setScript(script);
	}
	
	public void setLastString(List<String> lastString) {
		this.lastString = lastString;
	}
	
	@Override
	public String getLine(String massage) {
		if (scripter != null) {
			if (scripter.isAlive()) {
				return scripter.getLine(massage);
			}
			else {
				String line;
				if(step < lines.size()) {
					line = lines.get(step);
					step++;
				} else {
					life = false;
					return "";
				}
				return line;
			}
		} else {
			String line;
			if(step < lines.size()) {
				line = lines.get(step);
				step++;
			} else {
				life = false;
				return "";
			}
			return line;
		}
	}

	public boolean isAlive() {
		if(life && step >= lines.size())  {
			life = false;
		}
		return life;
	}

	private boolean checkScript(String script) {
	    try (InputStreamReader isr = new InputStreamReader(
	            new FileInputStream(script), StandardCharsets.UTF_8);
	         BufferedReader reader = new BufferedReader(isr)) {
	        
	        String line;
	        
	        while ((line = reader.readLine()) != null) {
	            line = line.trim();
	            if (line.isEmpty()) continue;
	            
	            String[] parts = line.split(" "); 
	            if (parts.length < 2) continue; 

	            if (parts[0].equals("execute_script")) {
	                String scriptName = parts[1];
	                if (scriptName.isEmpty()) {
	                    return true; 
	                }
	                Iterator<String> scripts = lastString.iterator();
	                
	                while(scripts.hasNext()) {
	                	String nxt = scripts.next();
	                	if(nxt.equals(scriptName)) {
	                		return false; 
	                	}
	                	
	                }

	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Ошибка чтения файла");
	        return false;
	    }
	    return true;
	}


}

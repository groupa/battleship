	/**
	 *
	 * @author dmitryigoshin
	 */

	import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

	public class HighScores {
		private int number;
	    private ArrayList<String> names;
	    private ArrayList<Integer> attempts;

	    public HighScores() {
	        names = new ArrayList<String>();
	        attempts = new ArrayList<Integer>();
	        number = 10;
	    }

	    public void insertScore(String playername, int playerscore) {
		boolean flag = true;
	
			for (int i = 0; i < names.size(); i++) {
				if (playerscore < attempts.get(i)) {
					names.add(i, playername);
					attempts.add(i, playerscore);
					flag = false;
					break;
				}
				if ((flag) && (names.size() < number)) {
					names.add(playername);
					attempts.add(playerscore);
				}
			}
	    }
		        
		
	    void ReadHighScores(String filename) {
	    	  String inLine;
	          File inFile;
	          StringTokenizer st;
	              try {
	              inFile = new File(filename);
	              BufferedReader fIn = new BufferedReader(new FileReader(inFile));
	              for(int i = 0; i < number; i++)
	              {
	            	  inLine = fIn.readLine();
	            	  st = new StringTokenizer(inLine, "#");
	            	  names.add(st.nextToken());
	            	  attempts.add(Integer.parseInt(st.nextToken()));
	            	  if (inLine == null) {
	            		  break;
	            	  }
	              }
	          } catch (Exception ex) {
	              System.out.println(ex.getMessage());
	          }
	 
	    }
	    
	    void SaveHighScores(String filename) {
	    	   PrintWriter pw;
	           try {
	               pw = new PrintWriter(filename);
	               for (int i = 0; i < names.size(); i++)
	               {
	            	  pw.println(names.get(i) + "#" + attempts.get(i)); 
	               }
	               pw.close();
	           } catch (IOException e) {
	               System.out.println("Unable to write to file" + e.getMessage());
	           }		    
	    }

	    public void printHighScores() {
	        System.out.println("HIGH SCORES: ");
	        for (int i = 0; i < names.size(); i++) {
	            System.out.println(names.get(i) + " " + attempts.get(i) + " ");
	        }
	    }
	    
	    public String getText() {
	    	String result = new String("Name                                          Score\n");
	    	for (int i = 0; i < names.size(); i++) {
	            result += names.get(i);
	            for (int j = 0; j < 54 - names.get(i).length() - attempts.get(i).toString().length(); j++)
	            {
	            	result += " ";
	            }
	            result +=  attempts.get(i) + "\n";
	        }
	    	return result;
	    }
	    
	}


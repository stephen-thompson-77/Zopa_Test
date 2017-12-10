package thompson.zopa.loans.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import thompson.zopa.loans.entities.Lender;

public class CSVManager implements FileManager {
	
	private List<String> names;
	private List<Float> rates;
	private List<Integer> amounts;
	private int lender = 0;
	private String NAME_HEADER = "lender";
	private String AVAILABLE_HEADER = "available";
	private String RATE_HEADER = "rate";
	private String INVALID_CSV = "The CSV file used has invalid or currpted data, please check the file and try again.";
	
	public CSVManager(){
	}
	
	/**
	 * Pulls the data from a CSV file of lenders and parses them into POJO lenders.
	 * @param file - the lender file to be read
	 */
	public List<Lender> readData(File file) {
		List<Lender> lenders = new ArrayList<Lender>();
		processValues(file);
		lenders = buildLenders();
		return lenders;
	}
	
	/**
	 * Reads from the file and validates data.
	 * @param file - the lender file in use
	 */
	private void processValues(File file){
		int namePos = -1;
		int ratePos = -1;
		int amountPos = -1;
		int pos = 0;
		
		BufferedReader br = null;
        String line = "";
        String splitBy = ",";

        try {

            br = new BufferedReader(new FileReader(file));
            line = br.readLine();
            String[] headers = line.split(splitBy);
            for(String header : headers){
            	if(header.toLowerCase().equals(NAME_HEADER)){
            		namePos = pos;
            	}else if(header.toLowerCase().equals(AVAILABLE_HEADER)){
            		amountPos = pos;
            	} else if(header.toLowerCase().equals(RATE_HEADER)){
            		ratePos = pos;
            	}
            	pos++;
            }
            
            if(namePos == -1 || ratePos == -1 || amountPos == -1){
            	System.out.println(INVALID_CSV);
            	return;
            } 
            names = new ArrayList<String>();
            rates = new ArrayList<Float>();
            amounts = new ArrayList<Integer>();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(splitBy);
                names.add(values[namePos]);
                try {
                	rates.add(Float.parseFloat(values[ratePos]));
                	amounts.add(Integer.parseInt(values[amountPos]));
                } catch(NumberFormatException e){
                	System.out.println(INVALID_CSV);
                	e.printStackTrace();
                	break;
                }
                lender++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	/**
	 * Constructs lenders from retrieved data.
	 * @return all lenders from the csv
	 */
	private List<Lender> buildLenders(){
		List<Lender> lenders = new ArrayList<Lender>();
		if(lender == 0 || names.size() != rates.size() || rates.size() != amounts.size()){
			return lenders;
		}
		for(int i = 0; i < lender; i++){
			lenders.add(new Lender(names.get(i), rates.get(i), amounts.get(i)));
		}
		return lenders;
	}

}

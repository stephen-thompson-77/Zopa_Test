package thompson.zopa.loans.files;

import java.io.File;
import java.util.List;

import thompson.zopa.loans.entities.Lender;

public interface FileManager {
	
	/**
	 * Reads a file in the current directory
	 * @param file - the file to use
	 * @return list of lenders
	 */
	public List<Lender> readData(File file);

}

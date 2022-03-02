package sg.edu.nus.iss.workshop13;
import static sg.edu.nus.iss.workshop13.util.IOUtil.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop13Application {
	private static final Logger logger = Logger.getLogger(Workshop13Application.class.getName());
	private static final String DATA_DIR = "dataDir";

	public static void main(String[] args) {
		//SpringApplication.run(Workshop13Application.class, args);

		SpringApplication app = new SpringApplication(Workshop13Application.class);
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		List<String> optVals = appArgs.getOptionValues(DATA_DIR);
		if (optVals != null)
		{
			createDir((String)optVals.get(0));	
			
		}else{
			logger.log(Level.WARNING,"No data directory is provided");
			System.exit(1);
		}
		app.run(args);
	}
}

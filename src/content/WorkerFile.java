/*
 * WorkForce: Mission Control
 */
package content;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author G.D. Joyce
 * WorkerFile.java: file access for JavaFX application ' WorkForce: Mission control '
 */

public class WorkerFile extends Worker {
    
    private File file = new File("worker.dat");
    //FileReader fr = new FileReader();
    
    //Worker one = new Worker(); 
    public void addWorker (Worker worker) throws IOException {
        // ensure file exists
        fileExists();
        // declarations
        ArrayList<String> clerk = new ArrayList();
        FileWriter fw = new FileWriter(file.toString(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        // fill ArrayList with Worker values        
        clerk.add(worker.getId() + ",");
        clerk.add(worker.getName() + ",");
        clerk.add(worker.getLastName() + ",");
        clerk.add(worker.getStreetAddress() + ",");
        clerk.add(worker.getCity() + ",");
        clerk.add(Double.toString(worker.getRate()) + ",");        
        clerk.add(Double.toString(worker.getHours()) + ",");
        clerk.add(Double.toString(worker.getPaidLastPeriod()) + ",");          
        // variable will hold worker info as String
        
        String cat = "";
        for(int i=0; i<clerk.size(); i++) {
            cat += clerk.get(i);                        
        }
        if(file.length()== 0) {
            bw.newLine();
        }
        // write String cat to stream then flush to hard disk
        bw.write(cat + "\n");
        // flush stream to hard disk
        bw.flush();
        // housekeeping
        bw.close();
        fw.close();
    }
    
    private void fileExists() throws IOException {
        if(!file.exists()) {
            file.createNewFile();
        }
    }    
}// end WorkerFile class

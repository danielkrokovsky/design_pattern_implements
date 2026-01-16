package pattern.virtualthreads;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class VirtualThreadFileProcessor {

	private String s = "Data8277.csv";
	@SuppressWarnings("unused")
	private Path filePath = Paths.get("teste.csv");

	public void processLargeFile(String file) throws IOException {
		try (var _ = Executors.newVirtualThreadPerTaskExecutor()) {
			
	        String delimiter = ",";

	        // Use a try-with-resources block to ensure the stream is closed automatically
	        try (Stream<String> lines = Files.lines(Paths.get(s))) {
	            List<Data> records = lines
	                // Optional: skip the header line if your CSV has one
	                .skip(1)
	                .map(line -> line.split(delimiter))
	                .map(n -> new Data(n[0]))
	                .collect(Collectors.toList());
	            
	            System.out.println(records);
	                

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	}
	
	
	
	@SuppressWarnings("unused")
	private void processLargeFileChannel(String file) throws IOException {
		try (RandomAccessFile reader = new RandomAccessFile(s, "r");
		        FileChannel channel = reader.getChannel();
		        ByteArrayOutputStream out = new ByteArrayOutputStream()) {

		        int bufferSize = 2048;
		        if (bufferSize > channel.size()) {
		           bufferSize = (int) channel.size();
		        }
		        ByteBuffer buff = ByteBuffer.allocate(bufferSize);

		        while (channel.read(buff) > 0) {
		            out.write(buff.array(), 0, buff.position());
		            buff.clear();
		        }
		        
		     //Files.write(filePath, out.toByteArray());
		     processLargeFile("");
		     
		     
	}
 }
		

	@SuppressWarnings({ "unused", "deprecation" })
	private void processChunk(List<CSVRecord> chunk) throws IOException {
		
		Path filePath = Paths.get("teste.csv");
		
		
		if(!Files.exists(filePath)) {
			Files.createFile(filePath);
		}
		
		String[] HEADERS = {"Year", "Age", "Ethnic", "Sex", "Area", "count"};
		
		CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .build();
		
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("teste.csv"))) {
			
            try (CSVPrinter csvPrinter = new CSVPrinter(writer, format)) {
				chunk.forEach(record -> {
					try {
						csvPrinter.printRecord(record);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				csvPrinter.flush();
			}
		}
	}

	public static void main(String[] args) throws IOException {
			
		new VirtualThreadFileProcessor().processLargeFileChannel("");
	}
}
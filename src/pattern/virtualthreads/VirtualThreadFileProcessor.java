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
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
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
	private Path filePath = Paths.get("Data8277.csv");

	public void processLargeFile(String file) throws IOException {
		
		List<Data> records = new ArrayList<>();
		String delimiter = ",";

		long s1, s2;
		
		s1 = System.currentTimeMillis();
		try (var _ = Executors.newVirtualThreadPerTaskExecutor()) {
			
			try (Stream<String> lines = Files.lines(filePath)) {
				records = lines
							.parallel()
							.skip(1)
							.map(line -> line.split(delimiter))
							.map(n -> new Data.Builder(n[0], n[1], n[2], n[3], n[4], n[5]).build())
							.collect(Collectors.toList());

				System.out.println(records.size());

			} catch (IOException e) {
				e.printStackTrace();
			}

			s2 = System.currentTimeMillis();
		}

		System.out.println("Time taken: "+(s2-s1)+"ms");
	}
	
	public void processFileChannel(String file) throws IOException {
		
		List<Data> records = new ArrayList<>();
		String delimiter = ",";

		long s1, s2;
		
		s1 = System.currentTimeMillis();
		
		try (var _ = Executors.newVirtualThreadPerTaskExecutor()) {
			
			FileChannel channel = FileChannel.open(filePath, StandardOpenOption.READ);
			ByteBuffer bbf = ByteBuffer.allocate(4096);
			
			while (channel.read(bbf) > 0) {
				
				bbf.flip();
				bbf.clear();
				
			}
			
			s2 = System.currentTimeMillis();
		}

		System.out.println("Time taken: "+(s2-s1)+"ms");
	}

	@SuppressWarnings("unused")
	private void processLargeFileChannel(String file) throws IOException {
		try (RandomAccessFile reader = new RandomAccessFile(s, "r");
				FileChannel channel = reader.getChannel();
				ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			int bufferSize = 2 * 4096;
			if (bufferSize > channel.size()) {
				bufferSize = (int) channel.size();
			}
			ByteBuffer buff = ByteBuffer.allocate(bufferSize);

			while (channel.read(buff) > 0) {
				out.write(buff.array(), 0, buff.position());
				buff.clear();
			}

		}
	}

	@SuppressWarnings({ "unused", "deprecation" })
	private void processChunk(List<CSVRecord> chunk) throws IOException {

		Path filePath = Paths.get("teste.csv");

		if (!Files.exists(filePath)) {
			Files.createFile(filePath);
		}

		String[] HEADERS = { "Year", "Age", "Ethnic", "Sex", "Area", "count" };

		CSVFormat format = CSVFormat.DEFAULT.builder().setHeader(HEADERS).build();

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

	public static void main(String[] args) {
		
	}
}
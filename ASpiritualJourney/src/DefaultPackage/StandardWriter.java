package DefaultPackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class StandardWriter {
	Analyzer analyzer = new StandardAnalyzer();
	Directory directory;
	IndexWriter writer;
	
	
	public StandardWriter() {
		this("C:\\Users\\Work\\Documents\\LuceneTest");
	}

	public StandardWriter(String directoryLocation) {
		try {
			directory = FSDirectory.open(new File(directoryLocation).toPath());
			IndexWriterConfig con = new IndexWriterConfig(analyzer);
			con.setUseCompoundFile(false);
			con.setOpenMode(OpenMode.CREATE);
			writer = new IndexWriter(directory, con);
		} catch (IOException e) {
			System.out.println("Still have no idea how to fix something like this.");
			e.printStackTrace();
		}

	}
	
	public void write(ArrayList<Document> docs) throws IOException {
		for(Document doc: docs)
			writer.addDocument(doc);
		writer.commit();
	}
	
	public void close() throws IOException {
		writer.close();
	}
	
	Directory getDirectory() {
		return directory;
	}
	
	Analyzer getAnalyzer() {
		return analyzer;
	}
}

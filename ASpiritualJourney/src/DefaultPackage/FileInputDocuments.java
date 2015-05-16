package DefaultPackage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.Field.Store;

public class FileInputDocuments implements InputDocuments {
	protected ArrayList<File> files = new ArrayList<File>();
	protected ArrayList<Document> docs = new ArrayList<Document>();
	
	private static final String DEFAULTPATH = "C:\\Users\\Work\\Documents\\LuceneTestFolder";

	FileInputDocuments() {
		this(DEFAULTPATH);
	}
	
	FileInputDocuments(String path) {
		File file = new File(path);
		getFiles(file);
		
		try {
			createDocs(docs);
		} catch (IOException e) {
			System.out.println("Something went horribly wrong, and I don't know how to fix it");
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Document> getDocArray() {
		return docs;
	}
		
	protected void getFiles(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory())
	        	getFiles(fileEntry);
	        else
	            files.add(fileEntry);
	    }
	}

	protected void createDocs(ArrayList<Document> docs) throws IOException {
		for(final File fileEntry : files) {
			Document doc = new Document();
			String title = fileEntry.getName();
			String contents = readFileContents(fileEntry.getPath(), StandardCharsets.UTF_8);
			doc.add(new StringField("title", title, Store.YES));
			doc.add(new StringField("content", contents, Store.YES));
			//doc.add(new Field("title", title, Field.Store.YES, Field.Index.ANALYZED));
			//doc.add(new Field("contents", contents, Field.Store.YES, Field.Index.ANALYZED));
			docs.add(doc);
		}
	}
	
	protected String readFileContents(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

}

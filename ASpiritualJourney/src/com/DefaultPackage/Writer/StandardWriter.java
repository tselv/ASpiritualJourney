package com.DefaultPackage.Writer;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.DefaultPackage.Input.GuicePainsMe;
import com.google.inject.Inject;

import DefaultPackage.FirstClass;
import DefaultPackage.InputDoc;

public class StandardWriter {
	Analyzer analyzer = new StandardAnalyzer();
	Directory directory;
	IndexWriter writer;
	GuicePainsMe docMaker;
	
	@Inject
	public StandardWriter(@InputDoc GuicePainsMe docmaker) {
		this(FirstClass.WRITERFOLDER);
		docMaker = docmaker;
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
	
	public void write() throws IOException {
		Iterator<Document> docs = docMaker.iterator();
		while(docs.hasNext())
			writer.addDocument(docs.next());
		writer.commit();
	}
	
	public void close() throws IOException {
		writer.close();
	}
	
	public Directory getDirectory() {
		return directory;
	}
	
	public Analyzer getAnalyzer() {
		return analyzer;
	}
}

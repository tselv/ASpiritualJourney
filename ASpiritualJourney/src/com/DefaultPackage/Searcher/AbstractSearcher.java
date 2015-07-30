package com.DefaultPackage.Searcher;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;

import com.DefaultPackage.Writer.StandardWriter;

public abstract class AbstractSearcher {

	private DirectoryReader ireader;
	private IndexSearcher searcher;
	private Analyzer analyzer;
	
	public AbstractSearcher(StandardWriter writer) {
		try {
			ireader = DirectoryReader.open(writer.getDirectory());
		} catch (IOException e) {
			e.printStackTrace();
		}
		searcher = new IndexSearcher(ireader);
		analyzer = writer.getAnalyzer();
	}
	
	public abstract void addExtraQuery(String field, String fieldValue);
	
	public abstract void clearQueries();
	
	public abstract void  printSearch(String field, String fieldValue) throws IOException;

	protected void printResults(Query finalQuery) throws IOException {
		TopScoreDocCollector collector = TopScoreDocCollector.create(5);
		searcher.search(finalQuery, collector);
		
		ScoreDoc[] hits = collector.topDocs().scoreDocs;
		System.out.println("Size: " + hits.length);
		for(ScoreDoc hit : hits) {
			Document actualDoc = searcher.doc(hit.doc);
			System.out.println("Title: " + actualDoc.get("title"));
			System.out.println("Content: " + actualDoc.get("content"));
		}
	}
}

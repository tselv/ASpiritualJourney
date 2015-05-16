package DefaultPackage;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopScoreDocCollector;

public class FirstClass {
	
	public static void main(String[] args) throws IOException {
		InputDocuments docMaker = new FixedInputDocuments();
		ArrayList<Document> docs = docMaker.getDocArray();

		StandardWriter writer = new StandardWriter();
		writer.write(docs);
		
//		Analyzer analyzer = new StandardAnalyzer();
//		Directory directory = FSDirectory.open(new File("C:\\Users\\Work\\Documents\\LuceneTest").toPath());
//		IndexWriterConfig con = new IndexWriterConfig(analyzer);
//		con.setUseCompoundFile(false);
//		con.setOpenMode(OpenMode.CREATE);
//		IndexWriter writer = new IndexWriter(directory, con);
//		for(Document doc: docs)
//			writer.addDocument(doc);
//		writer.commit();

		
//		DirectoryReader ireader = DirectoryReader.open(writer.getDirectory());
//		IndexSearcher searcher = new IndexSearcher(ireader);
//		
//		searchIndex(searcher, "title", "Word", writer.getAnalyzer());
		AbstractSearcher searcher = new TermQuerySearcher(writer);
		searcher.printSearch("title", "Word");
		writer.close();
	}

	static void searchIndex(IndexSearcher searcher, String field, String fieldValue, Analyzer analyzer) throws IOException {
		Term term = new Term(field, fieldValue);
		TermQuery termQuery = new TermQuery(term);

		QueryParser parser = new QueryParser(fieldValue, analyzer);
		Query query = null;
		try {
			 query = parser.parse(fieldValue);
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
		
		TopScoreDocCollector collector = TopScoreDocCollector.create(5);
		searcher.search(termQuery, collector);
		
		ScoreDoc[] hits = collector.topDocs().scoreDocs;
		System.out.println("Size: " + hits.length);
		for(ScoreDoc hit : hits) {
			Document actualDoc = searcher.doc(hit.doc);
			System.out.println("Content: " + actualDoc.get("content"));
		}
	}

}

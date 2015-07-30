package com.DefaultPackage.Searcher;

import java.io.IOException;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.TermQuery;

import com.DefaultPackage.Writer.StandardWriter;
import com.google.inject.Inject;

public class TermQuerySearcher extends AbstractSearcher {

	@Inject
	public TermQuerySearcher(StandardWriter writer) {
		super(writer);
	}

	@Override
	public void printSearch(String field, String fieldValue) throws IOException {
		Term term = new Term(field, fieldValue);
		TermQuery termQuery = new TermQuery(term);
		
		printResults(termQuery);
	}

	@Override
	public void addExtraQuery(String field, String fieldValue) {
		System.out.println("addExtraQuery doesn't do anything for a TermQueryParser");
	}

	@Override
	public void clearQueries() {
		System.out.println("clearQuery doesn't do anything for a TermQueryParser");
	}

}

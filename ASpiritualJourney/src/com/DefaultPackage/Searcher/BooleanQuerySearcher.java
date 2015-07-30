package com.DefaultPackage.Searcher;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.TermQuery;

import com.DefaultPackage.Writer.StandardWriter;
import com.google.inject.Inject;

public class BooleanQuerySearcher extends AbstractSearcher {
	ArrayList<String> fields = new ArrayList<String>();
	ArrayList<String> fieldValues = new ArrayList<String>();

	@Inject
	public BooleanQuerySearcher(StandardWriter writer) {
		super(writer);
	}

	@Override
	public void printSearch(String field, String fieldValue) throws IOException {
		fields.add(field);
		fieldValues.add(fieldValue);
		
		
		BooleanQuery booleanQuery = new BooleanQuery();
		for(int i = 0; i < fields.size(); ++i) {
			Term term = new Term(fields.get(i), fieldValues.get(i));
			TermQuery termQuery = new TermQuery(term);
			booleanQuery.add(termQuery, BooleanClause.Occur.MUST);
		}
		
		printResults(booleanQuery);

	}

	@Override
	public void addExtraQuery(String field, String fieldValue) {
		fields.add(field);
		fieldValues.add(fieldValue);
	}

	@Override
	public void clearQueries() {
		fields.clear();
		fieldValues.clear();
		
	}

}

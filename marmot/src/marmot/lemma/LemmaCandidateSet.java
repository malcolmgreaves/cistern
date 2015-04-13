package marmot.lemma;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LemmaCandidateSet implements Iterable<Map.Entry<String, LemmaCandidate>>{

	final static int IDENTITY = 0;
	
	private Map<String, LemmaCandidate> map_;
	
	public LemmaCandidateSet(String form) {
		map_ = new HashMap<>();
		getCandidate(form).addFeature(this, IDENTITY);
	}
	
	public LemmaCandidate getCandidate(String lemma) {
		LemmaCandidate candidate = map_.get(lemma);

		if (candidate != null) {
			return candidate;
		}
		
		candidate = new LemmaCandidate();
		map_.put(lemma, candidate);
		return candidate;
	}

	@Override
	public Iterator<Entry<String, LemmaCandidate>> iterator() {
		return map_.entrySet().iterator();
	}

	public int size() {
		return map_.size();
	}

	public boolean contains(String lemma) {
		return map_.containsKey(lemma);
	}
	
}

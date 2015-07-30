package DefaultPackage;

import com.DefaultPackage.Input.UniversityInputDocuments;
import com.google.inject.Binder;
import com.google.inject.Module;

public class UniversityInputModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(Iterable.class).annotatedWith(InputDoc.class).to(UniversityInputDocuments.class);
	}

}

package DefaultPackage;

import com.DefaultPackage.Input.FlagInputDocuments;
import com.DefaultPackage.Input.GuicePainsMe;
import com.DefaultPackage.Writer.StandardWriter;
import com.google.inject.AbstractModule;

public class FlagInputModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(GuicePainsMe.class).annotatedWith(InputDoc.class).toInstance(new FlagInputDocuments());
		bind(StandardWriter.class);
	}

}

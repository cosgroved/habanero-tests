package sequentialruntime;

import static edu.rice.hj.Module0.finish;
import static edu.rice.hj.Module0.launchHabaneroApp;
import static edu.rice.hj.Module1.async;
import static edu.rice.hj.Module1.forall;

import org.junit.Test;

import edu.rice.hj.api.SuspendableException;
import edu.rice.hj.runtime.config.HjSystemProperty;
import edu.rice.hj.runtime.config.RuntimeType;

public class SequentialRuntimeTest {
	@Test
	public void testEmpty() {
		HjSystemProperty.runtime.set(RuntimeType.SEQUENTIAL.shortName);
		launchHabaneroApp(()->{
		});
	}
	@Test
	public void testAsync() {
		HjSystemProperty.runtime.set(RuntimeType.SEQUENTIAL.shortName);
		launchHabaneroApp(()->{
			async(()->{
			});
		});
	}
	@Test
	public void testFinish() {
		HjSystemProperty.runtime.set(RuntimeType.SEQUENTIAL.shortName);
		launchHabaneroApp(()->{
			finish(()->{
			});
		});
	}

	@Test
	public void testForall() {
		HjSystemProperty.runtime.set(RuntimeType.SEQUENTIAL.shortName);
		launchHabaneroApp(()->{
			forall(0, 1, (i)->{
			});
		});
	}
	
	private void doNothing() throws SuspendableException {
	}
	
	@Test
	public void testSuspendableExceptionMethod() {
		HjSystemProperty.runtime.set(RuntimeType.SEQUENTIAL.shortName);
		launchHabaneroApp(()->{
			doNothing();
		});
	}
	
}

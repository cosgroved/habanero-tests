package edu.wustl.cse231s.util;

import static edu.rice.hj.Module0.finish;
import static edu.rice.hj.Module1.async;
import static edu.rice.hj.Module1.forall;
import static edu.rice.hj.Module1.forasync;

import org.junit.Test;

import edu.rice.hj.api.SuspendableException;

public class ForgetToLaunchHabaneroTest {
	@Test
	public void testFinish() throws SuspendableException {
		// :( java.lang.NullPointerException
		finish(() -> {

		});
	}

	@Test
	public void testForall() throws SuspendableException {
		// :( java.lang.NullPointerException
		forall(0, 10, (i) -> {
		});
	}

	@Test
	public void testForasync() {
		try {
			forasync(0, 10, (i) -> {
			});
		} catch (IllegalStateException ise) {
			// :) Habanero Runtime has not been initialized!
		}
	}

	@Test
	public void testAsync() {
		try {
			async(() -> {
			});
		} catch (IllegalStateException ise) {
			// :) Habanero Runtime has not been initialized!
		}
	}
}

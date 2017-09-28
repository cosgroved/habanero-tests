package forseqiterable;

import static edu.rice.hj.Module0.launchHabaneroApp;
import static edu.rice.hj.Module1.forseq;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

public class TestForseqIterable {
	@Test
	public void test() {
		AtomicInteger atom = new AtomicInteger(0);
		launchHabaneroApp(() -> {
			forseq(Arrays.asList(1, 2, 3, 4), (i) -> {
				atom.addAndGet(i);
			});
		});
		Assert.assertEquals(10, atom.get());
	}
}

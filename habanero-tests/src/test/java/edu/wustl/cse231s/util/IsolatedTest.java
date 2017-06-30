package edu.wustl.cse231s.util;

import static edu.rice.hj.Module0.launchHabaneroApp;
import static edu.rice.hj.Module1.async;
import static edu.rice.hj.Module2.isolated;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import org.junit.Test;

public class IsolatedTest {
	@Test
	public void testIsolated() {
		int numBuckets = 16;
		List<Entry<Integer,Integer>>[] buckets = new List[numBuckets];
		for(int i=0; i<buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
		launchHabaneroApp(() -> {
			int numTasks = Runtime.getRuntime().availableProcessors();
			int numIterations = 1_000;
			for( int i=0; i<numTasks; i++ ) {
				async(() -> {
					Random random = new Random();
					for( int j=0; j<numIterations; j++ ) {
						Integer key = random.nextInt();
						Integer value = random.nextInt();
						int bucketIndex = Math.floorMod(key.hashCode(), buckets.length); 
						isolated(buckets[bucketIndex], ()->{
							for( Entry<Integer,Integer> entry : buckets[bucketIndex]) {
								if( entry.getKey().equals(key)) {
									entry.setValue(value);
									return;
								}
							}
							buckets[bucketIndex].add(new KeyMutableValuePair<>(key, value));
						});
					}
				});
			}
		});
	}
}

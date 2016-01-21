package TDD.Blog;

import static org.junit.Assert.*;

import org.junit.Test;

public class BlogTest {

	@Test
	public void testPostNewEntry() {
		Blog blog = new Blog();
		Entry entry = new Entry("Nico", "My first post");
		blog.post(entry);
		assertEquals(1, blog.entrynumber());
	}
	
}

package TDD.Blog;

import static org.junit.Assert.*;

import org.junit.Test;

public class BlogTest {

	@Test
	public void testBlogEmpty() {
		Blog blog = new Blog();
		assertEquals(0, blog.entrynumber());
	}
	
	@Test
	public void testPostNewEntry() {
		Blog blog = new Blog();
		Entry entry = new Entry("Nico", "My first post");
		blog.post(entry);
		assertEquals(1, blog.entrynumber());
	}
	
	@Test
	public void testDeleteEntry() {
		Blog blog = new Blog();
		Entry entry = new Entry("Nico", "My first post");
		blog.post(entry);
		assertEquals(1, blog.entrynumber());
		blog.delete(entry);
		assertEquals(0, blog.entrynumber());
	}
	
	@Test
	public void testShow10RecentEntry() {
		int i;
		String name,opinion;
		Entry entry;
		Blog blog = new Blog();
		for(i = 0; i < 20; i++) {
			name = "Nico";
			opinion = "My "+i+" post";
			entry = new Entry(name, opinion);
			blog.post(entry);
		}
		blog.showentries(10);
	}
}

package TDD.Blog;

import java.util.*;

public class Blog{

	private List<Entry> blog;
	
	public Blog() {
		blog = new ArrayList<Entry>();
	}
	
	public void post(Entry entry) {
		blog.add(0, entry);
	}
	
	public int entrynumber() {
		return blog.size();
	}
}

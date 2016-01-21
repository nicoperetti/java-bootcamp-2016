package TDD.Blog;

import java.util.*;
import java.lang.*;

public class Blog{

	private List<Entry> blog;
	
	public Blog() {
		blog = new ArrayList<Entry>();
	}
	
	public void post(Entry entry) {
		blog.add(0, entry);
	}
	
	public void delete(Entry entry) {
		if (blog.contains(entry)){
			blog.remove(entry);
		}
	}
	
	public int entrynumber() {
		return blog.size();
	}
	
	public void showentries(int n) {
		Entry entry;
		n = Math.min(n, blog.size());
		for(int i = 0; i < n; i++) {
			entry = blog.get(i);
			System.out.println(entry.toString());
		}
	}
}

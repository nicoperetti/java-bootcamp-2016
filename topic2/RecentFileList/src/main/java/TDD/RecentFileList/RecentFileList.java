package TDD.RecentFileList;

import java.io.File;
import java.util.*;

public class RecentFileList{
    
	private List<File> recentfilelist;
	private int length;
	
	public RecentFileList() {
		recentfilelist = new ArrayList<File>();
		length = 15;
	}
	
	public int size() {
		int result = 0;
		if (recentfilelist != null) {
			result = recentfilelist.size();
		}
		return result;
	}
	
	public void OpenFile(File file) {
		if (recentfilelist.contains(file)) {
			recentfilelist.remove(file);
		}
		recentfilelist.add(0, file);
		if (recentfilelist.size() > length) {
			recentfilelist.remove(length - 1);
		}
	}
	public int getlength() {
		return length;
	}
}

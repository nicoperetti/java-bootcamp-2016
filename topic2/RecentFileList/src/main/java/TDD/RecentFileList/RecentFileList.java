package TDD.RecentFileList;

import java.io.File;
import java.util.*;

public class RecentFileList{
    
	private List<File> recentfilelist;
	
	public void RecentFileList() {
		recentfilelist = new ArrayList<File>();
	}
	
	public int size() {
		return recentfilelist.size();
	}
	
	
}

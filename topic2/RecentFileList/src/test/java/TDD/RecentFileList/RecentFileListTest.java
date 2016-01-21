package TDD.RecentFileList;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class RecentFileListTest {

	@Test
	public void testEmptyRecentFileList() {
        RecentFileList Filelist = new RecentFileList();
        assertEquals(0, Filelist.size());
    }
	
	@Test
	public void testOpenFile() {
		RecentFileList Filelist = new RecentFileList();
		File file = new File("~/file1.txt");
		Filelist.OpenFile(file);
		assertEquals(1, Filelist.size());
	}
	
	@Test
	public void testOpenFilefull() {
		RecentFileList Filelist = new RecentFileList();
		int len = Filelist.getlength();
		File file;
		for(int i = 0; i < len; i++) {
			file = new File("~/file" + i + ".txt");
			Filelist.OpenFile(file);
		}
		assertEquals(len, Filelist.size());
	}
}

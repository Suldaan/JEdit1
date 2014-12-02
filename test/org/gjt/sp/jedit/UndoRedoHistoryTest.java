package org.gjt.sp.jedit;

import org.gjt.sp.jedit.Buffer;
import org.gjt.sp.jedit.View;
import org.gjt.sp.jedit.jEdit;
import org.gjt.sp.jedit.buffer.UndoManager;
import org.junit.Assert;
import org.junit.Test;

public class UndoRedoHistoryTest {

	String path = "C:\\Users\\Bullari\\";
	int offset = 0;
	String strInsert = "asdf";
	String strRemove = "asdf";
	@Test
	public void TestUndoRedoFileWriter() {
		this.path = path.replace('\\','/');
		
		jEdit.main(new String[0]);
		View view = jEdit.getActiveView();
		
		Buffer buffer = jEdit.newFile(jEdit.getActiveView(), path);
		
		buffer.insert(offset, strInsert);
		buffer.insert(offset++, strInsert);
		
		buffer.save(jEdit.getActiveView(), path + "testytest");

		Assert.assertTrue("Test case 1", buffer.getLineSegment(0) == strInsert);
	}
}

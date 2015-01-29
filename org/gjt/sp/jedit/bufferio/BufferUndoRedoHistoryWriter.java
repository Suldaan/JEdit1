package org.gjt.sp.jedit.bufferio;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BufferUndoRedoHistoryWriter {

	File undoRedoHistory;
	String fileName;
	String path;
	ArrayList<String> undoRedoContent;
	PrintWriter writer;
	
	public BufferUndoRedoHistoryWriter(String fileName) {
		this.fileName = fileName;
		this.path = "C:/" + this.fileName + ".txt";
		this.path = "C:\\Users\\Fardin\\Desktop\\" + this.fileName + ".txt";
		this.path = path.replace('\\','/');
		this.undoRedoHistory = new File(this.path);
		this.undoRedoContent = new ArrayList<String>();
	}
	
	public void addEdit(String edit) {
		undoRedoContent.add(edit);
	}
	

	
	public void writeToDisk() {
		try {
			writer = new PrintWriter(undoRedoHistory);
			for (String edit : undoRedoContent) {
				writer.println(edit);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
	}
}

package org.gjt.sp.jedit.bufferio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BufferUndoRedoHistoryReader {
	
	String fileName;
	String path;
	List<String> undoRedoContent = new ArrayList<String>();
	
	public BufferUndoRedoHistoryReader (String fileName) {
		this.fileName = fileName;
		this.path = "C:/" + this.fileName + ".txt";
		this.path = "C:\\Users\\Fardin\\Desktop\\" + this.fileName + ".txt";
		this.path = path.replace('\\','/');
	}
	
	public List<String> readFromDisk() {
		try {
			for (String line : Files.readAllLines(Paths.get(path))){
				undoRedoContent.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return undoRedoContent;
	}
}

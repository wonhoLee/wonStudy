package me.book.ch04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileReaderTester extends TestCase {
	private FileReader _input;
	private FileReader _empty;
	private static final String FILE_NAME = "E:\\project\\eclipse\\COURSE\\wonStudy\\refactoring\\src\\ch04\\data.txt";
	
	public FileReaderTester(String name) {
		super(name);
	}

	protected void setUp() {
		try {
			_input = new FileReader(FILE_NAME);
			_empty = newEmptyFile();
		}catch(IOException e) {
			throw new RuntimeException("Unable to open test file");
		}
	}
	
	protected void tearDown() {
		try {
			_input.close();
		}catch(IOException e) {
			throw new RuntimeException("Error on closing test file");
		}
	}
	
	public void testRead() throws IOException{
		char ch = '&';
		//_input.close();			//예외 발생 테스트
		for (int i = 0; i < 4; i++) {
			ch = (char) _input.read();
		}
		assertEquals('d', ch);
		//assertEquals('m', ch);	//틀린값 테스트
	}
	
	public void testReadAtEnd() throws IOException{
		int ch = -1234;
		for (int i = 0; i < 142; i++) {
			ch = _input.read();
		}
		assertEquals("read at end", -1, ch);
	}
	
	public void testReadBoundaries() throws IOException{
		assertEquals("read first char",  'B', _input.read());
		for (int i = 1; i < 140; i++) {
			_input.read();
		}
		assertEquals("read last char",  '6', _input.read());
		assertEquals("read at end",  -1, _input.read());
		assertEquals("read at end",  -1, _input.read());
	}
	
	/*public void testEmptyRead() throws IOException{
		File empty = new File("empty.txt");
		FileOutputStream out = new FileOutputStream(empty);
		out.close();
		FileReader in = new FileReader(empty);
		assertEquals(-1, in.read());
	}*/
	
	private FileReader newEmptyFile() throws IOException{
		File empty = new File("empty.txt");
		FileOutputStream out = new FileOutputStream(empty);
		out.close();
		return new FileReader(empty);
	}
	
	public void testEmptyRead() throws IOException{
		assertEquals(-1, _empty.read());
	}
	
	public void testReadAfterClose() throws IOException{
		_input.close();
		try {
			_input.read();
			fail("no exception for read past end");
		}catch(IOException e) {}
	}
	
	/*public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new FileReaderTester("testRead"));
		suite.addTest(new FileReaderTester("testReadAtEnt"));
		return suite;
	}*/
	
	public static void main(String[] args) {
		//junit.textui.TestRunner.run(suite());
		junit.textui.TestRunner.run(new TestSuite(FileReaderTester.class));
	}
}

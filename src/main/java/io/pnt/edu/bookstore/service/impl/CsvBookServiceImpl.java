package io.pnt.edu.bookstore.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.stereotype.Service;

import io.pnt.edu.bookstore.dto.Book;
import io.pnt.edu.bookstore.service.BookService;

@Service("csvBookServiceImpl")
public class CsvBookServiceImpl implements BookService{
	private List<Book> bookList =new ArrayList<>();
	
	BufferedReader br = null;
	
	
	
	
	@Override
	public List<Book> findAll() {
		try {
			//CSV파일을 읽어서 list에 추가
			br = Files.newBufferedReader(Paths.get("D:\\books.csv"));
			Charset.forName("UTF-8");
			String line = "";
			
			while((line = br.readLine()) !=null) {
				List<String> tempList = new ArrayList<String>();
				String array[] =line.split(",");
				tempList = Arrays.asList(array);
				System.out.println(tempList);
				bookList.add((Book) tempList);
				
				}
			
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}finally {
				try {
					if(br != null){
						br.close();
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
			
			
		}
		// TODO Auto-generated method stub
		return bookList;
	}

	@Override
	public List<Book> findByName(String name) {

		return bookList.stream()
				.filter(b -> b.getTitle().contains(name))
				.collect(Collator.tolist());
	}

	@Override
	public int addBooks(Book... books) {
		// TODO Auto-generated method stub
		return 0;
	}

}

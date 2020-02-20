package com.zhangwenchao.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangwenchao.cms.dao.BookDao;
import com.zhangwenchao.cms.pojo.Book;
import com.zhangwenchao.cms.pojo.ErrorMessage;
import com.zhangwenchao.cms.service.BookService;
import com.zhangwenchao.common.utils.FileUtils;
import com.zhangwenchao.common.utils.StringUtils;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	

	@Override
	public List<Book> save() {
		// TODO Auto-generated method stub
		ArrayList<Book> bookList = new ArrayList<Book>();
		ArrayList<ErrorMessage> errorList = new ArrayList<ErrorMessage>();
		List<String> readTextFileOfList = FileUtils.readTextFileOflist("C:\\Users\\MACHENIKE\\Desktop\\data1.txt");
		for (String string : readTextFileOfList) {
			String[] split = string.split("\t");
			Book book = new Book();
			ErrorMessage errorMessage = new ErrorMessage();
			book.setId2(split[0]);
			book.setName(split[1]);
			book.setType(Integer.valueOf(split[2]));
			if(StringUtils.isPhone(split[3])){
				book.setPhone(split[3]);
			}else {
				errorMessage.setEid(split[0]);
				errorMessage.setBecause(1);
			}
			book.setAuthor(split[4]);
			if(split[5].matches("\\d+")) {
				if(split[5].length()>0) {
					if(split[5].equals(0)) {
						book.setLike(Integer.parseInt(split[1].substring(1)));
					}
				}	
			}
			if(split[5].matches("[a-zA-Z]")){
				errorMessage.setEid(split[0]);
				errorMessage.setBecause(0);
			}
			bookList.add(book);
			errorList.add(errorMessage);
		}
		int i=bookDao.insertBook(bookList);
		System.out.println(i+":book");
		int j=bookDao.insertError(errorList);
		System.out.println(j+":error");
		return bookList;
	}
	
	
}

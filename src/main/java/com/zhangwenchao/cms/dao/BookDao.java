package com.zhangwenchao.cms.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.zhangwenchao.cms.pojo.Book;
import com.zhangwenchao.cms.pojo.ErrorMessage;

public interface BookDao {

	int insertBook(@Param("bookList")ArrayList<Book> bookList);

	int insertError(@Param("errorList")ArrayList<ErrorMessage> errorList);

}

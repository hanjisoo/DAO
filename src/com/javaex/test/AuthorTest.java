package com.javaex.test;
import java.util.List;

import com.javaex.dao.AuthorDao;
import com.javaex.vo.AuthorVo;

public class AuthorTest {

	public static void main(String[] args) {

		AuthorDao authorDao = new AuthorDao();
		
		/*AuthorVo vo = new AuthorVo("이고잉", "생활코딩운영자");
		authorDao.insert(vo);*///꼭막아줘야돼 DB에 들어가
		
		/*List<AuthorVo> authorList=authorDao.select();//받았어
		System.out.println(authorList.toString());*/
		
		/*AuthorVo authorVo=new AuthorVo(7,"기안84","패션왕");
		authorDao.update(authorVo);*/
		
		AuthorVo vo=new AuthorVo(7);//setAuthorId()로 해도 됨
		authorDao.delete(vo);
	}

}

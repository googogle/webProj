package com.lee.bookstore.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.nio.file.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lee.bookstore.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class BookController {
	private static Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	@Autowired
	BookService bookService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map, @RequestParam MultipartFile file) {
		ModelAndView mav = new ModelAndView();
		String imageFolder = "D:\\webProjects\\images";
		String saveFileName = map.get("title").toString() + map.get("category").toString()
				+ map.get("price").toString();
		String finalFilePaht = imageFolder + "\\" + saveFileName + ".jpeg";
		map.put("image_path", saveFileName);
		String bookId = this.bookService.create(map);
		if (bookId == null) {
			mav.setViewName("redirect:/create");
			return mav;
		} else {
			File saveFile = new File(finalFilePaht);
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mav.setViewName("redirect:/detail?bookId=" + bookId);
			return mav;
		}
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.bookService.detail(map);

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		String bookId = map.get("bookId").toString();
		mav.addObject("bookId", bookId);
		mav.setViewName("/book/detail");
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.bookService.detail(map);

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		mav.setViewName("/book/update");
		return mav;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map, @RequestParam MultipartFile file)
			throws IllegalStateException, IOException {
		ModelAndView mav = new ModelAndView();
		String imageFolder = "D:\\webProjects\\images";

		//String originFilePath = imageFolder + "\\" + map.get("image_path") + ".jpeg";
		//Path originPath = Paths.get(originFilePath);
		//Files.deleteIfExists(originPath);
		String saveFileName = map.get("title").toString() + map.get("category").toString()
				+ map.get("price").toString();
		String finalFilePaht = imageFolder + "\\" + saveFileName + ".jpeg";
		Path filePath = Paths.get(finalFilePaht);
		try {
			Files.deleteIfExists(filePath);
			map.put("image_path", saveFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean isUpdateSuccess = this.bookService.edit(map);
		if (isUpdateSuccess) {
			File saveFile = new File(finalFilePaht);
			file.transferTo(saveFile);
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		} else	
			mav.setViewName("redirect:/list");

		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) throws IOException {
		ModelAndView mav = new ModelAndView();
		Map<String,Object> book2delete = this.bookService.detail(map);
		String fileName2delete = (String)book2delete.get("image_path");
		boolean isDeleteSuccess = this.bookService.remove(map);
		if (isDeleteSuccess) {
			String imageFolder = "D:\\webProjects\\images\\";
			Path filePath = Paths.get(imageFolder + fileName2delete+".jpeg");
			System.out.println("Delete >> " + imageFolder + fileName2delete+".jpeg");
			Files.deleteIfExists(filePath);
			mav.setViewName("redirect:/list");
		}
		else {
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		return mav;
	}

	@RequestMapping(value = "list")
	public ModelAndView list(@RequestParam Map<String, Object> map) {

		List<Map<String, Object>> list = this.bookService.list(map);

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list);
		mav.setViewName("/book/list");
		return mav;
	}

	@RequestMapping(value = "/main")
	public ModelAndView mainPage() {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> randomBookListMap = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list = this.bookService.list(map);
		int[] idxs = new int[9];
		Random rand = new Random();
		boolean collapseFlag = false;
		for (int i = 0; i < 9;) {
			collapseFlag = false;
			int n = rand.nextInt(list.size());
			for (int j = 0; j <= i; j++) {
				if (idxs[j] == n)
					collapseFlag = true;
			}
			if (!collapseFlag) {
				idxs[i] = n;
				i++;
			}
		}
		for (int i = 0; i < 9; i++) {
			map = list.get(idxs[i]);
			randomBookListMap.add(map);
		}
		mav.addObject("data", randomBookListMap);
		mav.setViewName("/book/mainPage");
		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap = this.bookService.search(map);
		ModelAndView mav = new ModelAndView();
		System.out.println(resultMap);
		if (resultMap == null) {
			mav.setViewName("redirect:/noSearchResult");
			return mav;
		}
		mav.addObject("data", resultMap);
		mav.setViewName("/book/searchResult");
		return mav;
	}

	@RequestMapping(value = "/noSearchResult")
	public ModelAndView noSearchResult() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/book/noSearchResult");
		return mav;
	}

	public ModelAndView join() {

		ModelAndView mav = new ModelAndView();
		return mav;
	}

}

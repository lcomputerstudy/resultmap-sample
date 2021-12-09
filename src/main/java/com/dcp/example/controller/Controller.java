package com.dcp.example.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dcp.example.domain.Board;
import com.dcp.example.domain.Comment;
import com.dcp.example.domain.FileInfo;
import com.dcp.example.domain.Search;
import com.dcp.example.domain.User;
import com.dcp.example.service.BoardService;
import com.dcp.example.service.CommentService;
import com.dcp.example.service.FileInfoService;
import com.dcp.example.service.UserService;

@org.springframework.stereotype.Controller
public class Controller {
   
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
   @Autowired BoardService boardservice;
   @Autowired UserService userservice;
   @Autowired CommentService commentservice;
   @Autowired FileInfoService fileinfoservice;
   
   @RequestMapping("/")
   public String home(Model model, Principal principal) {
	   logger.debug("debug");
	   logger.info("info");
	   logger.error("error");
	   if (principal != null) {
		   if(((Authentication)principal).getPrincipal() != null) {
			   User user = (User)((Authentication)principal).getPrincipal();
			   model.addAttribute("user", user);
		   }
	   }
	   
       return "/index";
   }
   
   @RequestMapping("/beforeSignUp")
   public String beforeSignUp() {
	   return "/signup";
   }
   
   @RequestMapping("/signup")
   public String signup(User user) {
      //비밀번호 암호화
      String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
      
      //유저 데이터 세팅
      user.setPassword(encodedPassword);
      user.setAccountNonExpired(true);
      user.setEnabled(true);
      user.setAccountNonLocked(true);
      user.setCredentialsNonExpired(true);
      user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));   
      
      //유저 생성
      userservice.createUser(user);
      //유저 권한 생성
      userservice.createAuthorities(user);
      
      return "/login";
   }
   
   @RequestMapping("/login")
   public String beforeLogin(Model model) {
   	return "/login";
   }
   
   @Secured({"ROLE_ADMIN"})
   @RequestMapping("/admin")
   public String admin(Model model) {
	  List<User> list = userservice.readUserlist();
	  model.addAttribute("userList", list);
      return "/admin";
   }
   
   @Secured({"ROLE_USER"})
   @RequestMapping("/user/info")
   public String userInfo(Model model) {
      
      return "/user_info";
   }
   
   @RequestMapping("/denied")
   public String denied(Model model) {
      return "/denied";
   }
   
   @RequestMapping("/userList")
   public String userList(Model model) {
	  List<User> userList = userservice.readUserAndAuthList();
	  model.addAttribute("userList", userList);
	  
      return "/user_list";
   }
   
   @RequestMapping("/deleteAdmin")
   public String deleteAdmin(Model model, User user) {	   
	  userservice.deleteAdmin(user);
	  model.addAttribute("userList", userservice.readUserAndAuthList());

      return "/user_list";
   }
   
   @RequestMapping("/addAdmin")
   public String addAdmin(Model model, User user) {	   
	  userservice.addAdmin(user);
	  model.addAttribute("userList", userservice.readUserAndAuthList());

      return "/user_list";
   }
   
   @RequestMapping("/boardList")
   public String boardList(Model model) {
	   List<Board> boardlist = boardservice.selectBoardList();
	   model.addAttribute("boardlist", boardlist);
	   
	   return "/board_list";
   }
   
   @RequestMapping("/searchProcess")
   public String searchProcess(Model model,Search search) throws Exception {
	   List<Board> searchList = boardservice.searchBoard(search);
	   model.addAttribute("boardlist", searchList);
	   
	   return "/board_list";
   }
   
   @RequestMapping("/writeBoard")
   public String wirteBoard(Model model, Board board) {
	   model.addAttribute("board", board);
	   return "/writeBoard";
   }
   
   @RequestMapping("/readBoard")
   public String readBoard(Model model, Board board, Principal principal) {
	   if (principal != null) {
		   if(((Authentication)principal).getPrincipal() != null) {
			   User user = (User)((Authentication)principal).getPrincipal();
			   model.addAttribute("user", user);
		   }
	   }
	  Comment comment = new Comment();
	
	  comment.setBoard(board);
	  List<Comment> commentlist = commentservice.selectCommentList(comment);
	  boardservice.plusViews(board);
	  board = boardservice.readBoard(board);	 	
	  
	  model.addAttribute("board", board);
	  model.addAttribute("commentlist", commentlist);
	  model.addAttribute("fileinfolist", fileinfoservice.getFileInfo(board.getbId()));
	 
      return "/readBoard";
   }
   
   @RequestMapping("/deleteBoard")
   public String deleteoBoard(Model model, Board board) {	   
	  boardservice.deleteBoard(board);

      return "redirect:/boardList";
   }
   
   @RequestMapping("/adjustBoard")
   public String adjustBoard(Model model, Board board) {	 
	  model.addAttribute("board", boardservice.readBoard(board));
      return "/adjustBoard";
   }
   
   @RequestMapping("/adjustBoardProcess")
   public String adjustBoardProcess(Model model, Board board) {	 
	  boardservice.adjustBoard(board);
      return "redirect:/readBoard?bId="+board.getbId();
   }
   
   @RequestMapping(value="/writeBoardProcess", method=RequestMethod.POST)
   public String wirteBoardProcess(Model model, Board board, Principal principal, @RequestParam("file") List<MultipartFile> files) {
	   User user = (User)((Authentication)principal).getPrincipal();
	   board.setUser(user);
	   
	  if(board.getbId() == 0) {
		  boardservice.writeBoard(board);
	  } else {
		  boardservice.rewriteBoard(board);
	  }
	  
	  FileInfo fi = new FileInfo();
	  String path = "/Users/l6-morning/Documents/dhwork/dcp/src/main/resources/static/images/";
	  String thumbPath = path + "thumb/";
	  for(MultipartFile multipartFile : files) {
		  String filename = multipartFile.getOriginalFilename();
		  String ext = filename.substring(filename.lastIndexOf(".") + 1);
		  
		  File file = new File(path + filename);
		  File thumbFile = new File(thumbPath + filename);
		  try {
			  InputStream input = multipartFile.getInputStream();
			  FileUtils.copyInputStreamToFile(input, file);
			  
			  BufferedImage imageBuf = ImageIO.read(file);
			  int fixWidth = 500;
			  double ratio = imageBuf.getWidth() / (double)fixWidth;
			  int thumbWidth = fixWidth;
			  int thumbHeight = (int)(imageBuf.getHeight() / ratio);
			  BufferedImage thumbImageBf = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_3BYTE_BGR);
			  Graphics2D g = thumbImageBf.createGraphics();
			  Image thumbImage = imageBuf.getScaledInstance(thumbWidth, thumbHeight, Image.SCALE_SMOOTH);
			  g.drawImage(thumbImage, 0, 0, thumbWidth, thumbHeight, null);
			  g.dispose();
			  ImageIO.write(thumbImageBf, ext, thumbFile);
			  fi.setfName(filename);
			  fileinfoservice.saveFileInfo(fi);
				
		   } catch (IOException e) {
				FileUtils.deleteQuietly(file);
				e.printStackTrace();
		   }
	   }	  
	  
	  model.addAttribute("boardlist", boardservice.selectBoardList());

      return "/board_list";
   }
   
   @RequestMapping("/writeComment")
   public String wirteComment(Model model, Comment comment, Principal principal, Board board) {
	  User user = (User)((Authentication)principal).getPrincipal();
	  comment.setUser(user);
	  
	  if(comment.getcId() == 0) {
		  commentservice.writeComment(comment);
	  } else {
		  commentservice.rewriteComment(comment);
	  }
	  comment.setBoard(board);
	  model.addAttribute("commentlist", commentservice.selectCommentList(comment));

      return "/commentlist";
   }
}

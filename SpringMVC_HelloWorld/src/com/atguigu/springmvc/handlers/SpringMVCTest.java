package com.atguigu.springmvc.handlers;


import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.atguigu.springmvc.beans.User;

@Controller
@RequestMapping("/springmvc")
public class SpringMVCTest {
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		System.out.println("testRequestMapping...");
		System.out.println("testRequestMapping...");
		return "success";
	}
	
	//params属性用于映射请求参数，通过表达式来验证参数合法性
	//headers属性用于映射请求头，通过表达式来验证头信息的合法性
	@RequestMapping(value="/testRequestParamsAndHeads",
			params={"username","age!=10"},
			headers={"Accept-Language=zh-CN,zh;q=0.8"})
	public String testRequestParamsAndHeads(){
		System.out.println("testRequestParamsAndHeads...");
		return "success";
	}
	
	//映射Ant风格的请求路径
	@RequestMapping(value="/user/*/path")
	//@RequestMapping(value="/user/**/path")
	public String testAntPath(){
		System.out.println("testAntPath...");
		return "success";
	}
	
	//映射请求路径占位符，通过@PathVariable注解指定站位符名称来获取路径中的值，传递给方法的入参。
	@RequestMapping(value="/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id){
		System.out.println("id="+id);
		return "success";
	}
	
	
	//测试REST风格  GET、POST、PUT、DELETE
	@RequestMapping(value = "/testRESTGet/{id}",method=RequestMethod.GET)
	public String testRESTGet(@PathVariable("id") Integer id){
		System.out.println("testRESTGet... id="+id);
		return "success";
	}

	@RequestMapping(value = "/testRESTPost",method=RequestMethod.POST)
	public String testRESTPost(){
		System.out.println("testRESTPost...");
		return "success";
	}
	
	@RequestMapping(value = "/testRESTPut/{id}",method=RequestMethod.PUT)
	public String testRESTPut(@PathVariable("id") Integer id){
		System.out.println("testRESTPut... id="+id);
		return "success";
	}
	
	@RequestMapping(value = "/testRESTDelete/{id}",method=RequestMethod.DELETE)
	public String testRESTDelete(@PathVariable("id") Integer id){
		System.out.println("testRESTDelete... id="+id);
		return "success";
	}
	
	@RequestMapping(value="testRequestParam")
	public String testRequestParam(
				@RequestParam(value="username") String username,
				@RequestParam(value="age",required=false,defaultValue="0") int age){
		System.out.println("username="+username);
		System.out.println("age="+age);
		return "success";
	}
	
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader("Accept-Language") String acceptLanguage){
		System.out.println("testRequestHeader...Accept-Language="+acceptLanguage);
		return "success";
	}
	
	
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String jsssionid ){
		System.out.println("testCookieValue... jsssionid="+jsssionid);
		return "success";
	}
	
	
	@RequestMapping("/testPOJO")
	public String testPOJO(User user){
		System.out.println(user);
		return "success";
	}
	
	/* 可以获取到这9个固定的入参对象：
	 * HttpServletRequest 
	 * HttpServletResponse 
	 * HttpSession
	 * java.security.Principal 
	 * Locale InputStream 
	 * OutputStream 
	 * Reader 
	 * Writer
	 */
	@RequestMapping("/testServletAPI")
	public String testServletAPI(HttpServletRequest request ,HttpServletResponse response){
		System.out.println("request="+request);
		System.out.println("response="+response);		
		return "success";
	}
	
	
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(){
		String viewName = "success";
		ModelAndView mv = new ModelAndView(viewName);
		mv.addObject("time", new Date()); //相当底层执行了request.setAttribute("time",obj);
		return mv ;
	}
	
	@RequestMapping("/testMap")
	public String testMap(Map map){
		System.out.println(map.getClass());
		//org.springframework.validation.support.BindingAwareModelMap
		//相当于存储到了request域中
		map.put("names", Arrays.asList("a","b","c"));			
		return "success" ;
	}
	
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map map){
		
		User user = new User();
		user.setUsername("zhangsan");
		//@SessionAttributes(value={"user","school"}) 使用这个注解，也可以将数据存放到session域中
		map.put("user", user);
		map.put("school", "邮电大学");
		return "success";
	}
	
	
	//------------------------------------------------------
	@RequestMapping("/testModelAttribute") 
	//public String testModelAttribute(@ModelAttribute("xxx") User user){
	public String testModelAttribute(User user){
		//问题1：org.springframework.web.HttpSessionRequiredException: Session attribute 'user' required - not found in session
		//问题2： 表单提交的数据，其中password并没有提交，不需要修改的。
			//如果直接通过new的user对象封装表单数据，来完成数据更新操作，会出现数据库中password字段值丢失。
			//解决字段值不被修改，而且还不丢失，可以使用隐含域，将password值提交封装到user中，然后更新。
		    //注意：这种解决办法不推荐，原因是：①有时需要大量字段不被更新，使用隐含会比较麻烦。②有些字段属于敏感数据，不能使用隐含域。
		System.out.println(user);
		System.out.println(user.hashCode());
		return "success";
	}
	
	//@ModelAttribute修饰的方法：
	//	①在每一个处理请求的方法前执行
	//	②为处理请求的方法提供模型（一般存放到Map中），用于数据的封装。解决了password字段值丢失这样的问题。
	/*@ModelAttribute
	public void getUser(@RequestParam("id") Integer id,Map map){
		if(id!=null){
			//从数据库中查询一个对象，用于封装表单提交过来的数据
			User user = new User(1,"Tom","123","tom@guigu.com",12);
			System.out.println(user.hashCode());
			//key如果定义为处理请求方法入参的模型对象类型的名称的首字母小写，就是ok的。
			//map.put("user", user); 
			//如果随意命名key，那么，处理请求的方法将无法获取这个对象
				//但是如果有@ModelAttribute来修饰方法入参，并且属性值与map的key一致也是ok的
			//map.put("xxx", user); 
		}
	}*/
}

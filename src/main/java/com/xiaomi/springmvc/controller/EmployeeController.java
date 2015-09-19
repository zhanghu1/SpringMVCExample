package com.xiaomi.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import com.xiaomi.springmvc.service.EmployeeManager;

/**
 * MVC模式也是属于表示层的
 * 这是web应用的第一层：表示层，主要目的是提供与用户交互的内容 
 * 控制器负责接收来自用户的请求，并调用后台服务（manager或者dao）来处理业务逻辑
 * */
/**
 * 在Spring3.0中定义一个控制器类，这个类必须标有@Controller注解。当有@Controller注解的控制器
 * 收到一个请求时，它会寻找一个合适的handler方法去处理这个请求。这就需要控制器通过一个或多个handler
 * 映射去把每个请求映射到handler方法。为了这样做，一个控制器类的方法需要被@RequestMapping注解装饰，
 * 使它们成为handler方法。

	handler方法处理完请求后，它把控制权委托给视图名与handler方法返回值相同的视图。
	为了提供一个灵活的方法，一个handler方法的返回值并不代表一个视图的实现而是一个逻辑视图，
	即没有任何文件扩展名。你可以将这些逻辑视图映射到正确的实现，并将这些实现写入到上下文文件，
	这样你就可以轻松的更改视图层代码甚至不用修改请求handler类的代码。
	为一个逻辑名称匹配正确的文件是视图解析器的责任。一旦控制器类已将一个视图名称解析到一个视图实现。
	它会根据视图实现的设计来渲染对应对象。
 */
/**
 * @Controller注解是@Component注解的具体化，它表明了这个java类不仅是一个Spring组件，
 * 而且它是SpringMVC的控制器组件
 * */
@Controller
@RequestMapping("/employee-module") //类级别的定义表明了这个控制器所处理的根级别的URL
public class EmployeeController 
{
	@Autowired
	EmployeeManager manager;
	
	/**
	 * 方法级别的定义表明了完整的URL，且这个请求必须是GET方式的
	 * */
	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	/**
	 * 这个方法的参数可以随意定义很多种类型，但是向下传递，即向JSP页面等传递
	 * 时只能利用Model或者Map<String, Object>类型
	 * 如果需要向其传递参数，则需要@Param..参数注解（还可以验证之类的操作）
	 * */
	public String getAllEmployees(Model model)
	{
		model.addAttribute("employees", manager.getAllEmployees());
		/**
		 * 这里是需要注意的地方，控制器方法返回的是一个逻辑视图的名字，
		 * 具体的解析工作不是控制器应该关心的，因为控制器应该只需要关注
		 * 业务逻辑的实现
		 * InternalResourceViewResolver定义在Spring环境上下文中，它实现了
		 * 对视图的解析工作
		 * */
		return "employeesListDisplay";
	}
	
	/**
	 * 这是一个需要参数的方法，那么这个请求所对应的URL就应该类似于这样：
	 * /study?user=brucezhang
	 * 接下来，这个方法的参数userName会被赋值为brucezhang，这就是带参数的控制器方法
	 * 这里需要注意的是在两种情况下@RequestParam注解可以省略：
	 * 	1.如果方法的参数名为user，即和URL中的请求是一样的，那么可以依赖约定，不声明参数注解
	 * 	2.如果查询参数名为userName，即和方法中的参数名相同，也可以依赖约定
	 * 	不过，这两种依赖显然都不是太好，不利于排除错误，所以，慎重使用
	 * */
//	@RequestMapping(value = "/study", method = RequestMethod.GET)
//	public String studySpring(
//			@RequestParam("user")
//			String userName, Model model) {
//		return null;
//	}
	
	/**
	 * 下面介绍使用Post方法请求处理的过程，这里的例子是给用户展现一张表单填写用户的信息并处理
	 * 这里定义两个方法，一个是给用户展现表单，另一个是对提交的表单进行处理
	 * */
	/**
	 * 可以看到这里的Mapping定义与之前的并不相同，它没有指定value定义，即没有次级的URL，那么
	 * 它就会使用类级别的URL，在本例中将会是/employee-module，另外，它多了一个param属性，这是
	 * 指URL中需要包含这个属性所对应的值，所以，这个方法匹配的URL应该是/employee-module?new
	 * */
//	@RequestMapping(method = RequestMethod.GET, params = "new")
//	public String createUserProfileForm(Model model) {
//		/**
//		 * 这里的User对象是假设的用户信息对象
//		 * */
//		/**
//		 * 由于这是一个展现表单的请求，需要用户输入他的个人信息，那么最好的方式是构建一个新的
//		 * 用户对象，并传递出去，传递给JSP页面，让用户去填充这个对象
//		 * ？？？但是当用户填充好了之后，JSP页面以POST方式提交之后，这个user对象是怎么传回来的
//		 * 我还不是很清楚，这个应该是JSP的问题
//		 * */
//		model.addAttribute(new User());
//		/**
//		 * 书中的JSP文件只是定义了它的返回请求方式是POST，但是没有指明它定位的URL是什么，如果
//		 * 是这样，它会返回来到这个JSP文件的路径中去，即/employee-module
//		 * */
//		return "edit";
//	}
	
	/**
	 * 处理表单的输入
	 * */
//	@RequestMapping(method = RequestMethod.POST)
	/**
	 * 注意这里的user前面有一个注解@Validated（书中的是@Valid），是为了验证有效性
	 * 
	 * 这里的检验规则是自己定义的，正则表达式什么的都是支持的，它会自动的检测user中的字段设置
	 * （用户填写的表单）是不是满足我们定义的正确形式，我们定义的形式就需要看User类中的定义了
	 * 这里需要知道的是，一旦用户输入的不满足定义，那么就会把错误传递给bindingResult对象，
	 * 同时，这里面也包含了自定义的错误信息（message），可以通过调用bindingResult.getFieldError()
	 * 方法来查看错误提示信息
	 * */
//	public String addUserFromForm(@Validated User user, BindingResult bindingResult) {
//		
//		if (bindingResult.hasErrors()) {
//			return "edit";
//		}
//		
//		//这里保存user对象到数据库中
//		
//		/**
//		 * 这里采用重定向的方式返回，利用的是PRG的设计模式，据说是为了防止表单的重复提交，
//		 * 数据库的重复写入问题，具体的原因我的理解是，它返回的并不是一个视图，而是一个get
//		 * 请求，这样的话，用户再去刷新页面之类的操作时，就不会以post的方式提交请求，那么
//		 * 自然就不会调用到这个方法了
//		 * 
//		 * 注意：
//		 * 		这里返回的是这样的形式 /user/{userName},这是一个带有路径变量的请求，记住啊，
//		 * 		重定向过去后是一个get请求，所以，还需要一个方法来实现这个get，下面实现它
//		 * */
//		return "redirect:/user" + user.getUserName();
//	}
	
	/**
	 * 处理带有路径变量的请求
	 * */
	/**
	 * 这里的value有些奇怪了，它不是一个明确的路径了，而是被花括号{}包围起来的一个值，而且
	 * userName参数也用注解@PathVariable（路径变量）标识
	 * 这两点结合起来就能够处理URL中带有参数的请求，它对应的URL应该是这样：
	 * /userName/brucezhang，这时，brucezhang将会传递到参数userName中
	 * */
//	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
//	public String showUserProfile(@PathVariable String userName, Model model) {
//		
//		/**
//		 * model执行添加操作，传递给JSP页面（本例中是view）
//		 * */
//		
//		return "view";
//	}
	
//	class User{
//		public String getUserName() {
//			return "brucezhang";
//		}
		
		/**
		 * 这里使用了校验规则，message部分是出错信息
		 * */
//		@Size(min = 3, max = 20, message = "userName must be between 3 and 20")
//		@Pattern(regexp="", message)
//		private String userName;
//		
//		@Size(min = 3, max = 20, message = "userName must be between 3 and 20")
//		private String password;
//	}
}

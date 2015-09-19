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
 * MVCģʽҲ�����ڱ�ʾ���
 * ����webӦ�õĵ�һ�㣺��ʾ�㣬��ҪĿ�����ṩ���û����������� 
 * ������������������û������󣬲����ú�̨����manager����dao��������ҵ���߼�
 * */
/**
 * ��Spring3.0�ж���һ���������࣬�����������@Controllerע�⡣����@Controllerע��Ŀ�����
 * �յ�һ������ʱ������Ѱ��һ�����ʵ�handler����ȥ����������������Ҫ������ͨ��һ������handler
 * ӳ��ȥ��ÿ������ӳ�䵽handler������Ϊ����������һ����������ķ�����Ҫ��@RequestMappingע��װ�Σ�
 * ʹ���ǳ�Ϊhandler������

	handler������������������ѿ���Ȩί�и���ͼ����handler��������ֵ��ͬ����ͼ��
	Ϊ���ṩһ�����ķ�����һ��handler�����ķ���ֵ��������һ����ͼ��ʵ�ֶ���һ���߼���ͼ��
	��û���κ��ļ���չ��������Խ���Щ�߼���ͼӳ�䵽��ȷ��ʵ�֣�������Щʵ��д�뵽�������ļ���
	������Ϳ������ɵĸ�����ͼ��������������޸�����handler��Ĵ��롣
	Ϊһ���߼�����ƥ����ȷ���ļ�����ͼ�����������Ρ�һ�����������ѽ�һ����ͼ���ƽ�����һ����ͼʵ�֡�
	���������ͼʵ�ֵ��������Ⱦ��Ӧ����
 */
/**
 * @Controllerע����@Componentע��ľ��廯�������������java�಻����һ��Spring�����
 * ��������SpringMVC�Ŀ��������
 * */
@Controller
@RequestMapping("/employee-module") //�༶��Ķ�����������������������ĸ������URL
public class EmployeeController 
{
	@Autowired
	EmployeeManager manager;
	
	/**
	 * ��������Ķ��������������URL����������������GET��ʽ��
	 * */
	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	/**
	 * ��������Ĳ����������ⶨ��ܶ������ͣ��������´��ݣ�����JSPҳ��ȴ���
	 * ʱֻ������Model����Map<String, Object>����
	 * �����Ҫ���䴫�ݲ���������Ҫ@Param..����ע�⣨��������֤֮��Ĳ�����
	 * */
	public String getAllEmployees(Model model)
	{
		model.addAttribute("employees", manager.getAllEmployees());
		/**
		 * ��������Ҫע��ĵط����������������ص���һ���߼���ͼ�����֣�
		 * ����Ľ����������ǿ�����Ӧ�ù��ĵģ���Ϊ������Ӧ��ֻ��Ҫ��ע
		 * ҵ���߼���ʵ��
		 * InternalResourceViewResolver������Spring�����������У���ʵ����
		 * ����ͼ�Ľ�������
		 * */
		return "employeesListDisplay";
	}
	
	/**
	 * ����һ����Ҫ�����ķ�������ô�����������Ӧ��URL��Ӧ��������������
	 * /study?user=brucezhang
	 * ����������������Ĳ���userName�ᱻ��ֵΪbrucezhang������Ǵ������Ŀ���������
	 * ������Ҫע����������������@RequestParamע�����ʡ�ԣ�
	 * 	1.��������Ĳ�����Ϊuser������URL�е�������һ���ģ���ô��������Լ��������������ע��
	 * 	2.�����ѯ������ΪuserName�����ͷ����еĲ�������ͬ��Ҳ��������Լ��
	 * 	������������������Ȼ������̫�ã��������ų��������ԣ�����ʹ��
	 * */
//	@RequestMapping(value = "/study", method = RequestMethod.GET)
//	public String studySpring(
//			@RequestParam("user")
//			String userName, Model model) {
//		return null;
//	}
	
	/**
	 * �������ʹ��Post����������Ĺ��̣�����������Ǹ��û�չ��һ�ű���д�û�����Ϣ������
	 * ���ﶨ������������һ���Ǹ��û�չ�ֱ�����һ���Ƕ��ύ�ı����д���
	 * */
	/**
	 * ���Կ��������Mapping������֮ǰ�Ĳ�����ͬ����û��ָ��value���壬��û�дμ���URL����ô
	 * ���ͻ�ʹ���༶���URL���ڱ����н�����/employee-module�����⣬������һ��param���ԣ�����
	 * ָURL����Ҫ���������������Ӧ��ֵ�����ԣ��������ƥ���URLӦ����/employee-module?new
	 * */
//	@RequestMapping(method = RequestMethod.GET, params = "new")
//	public String createUserProfileForm(Model model) {
//		/**
//		 * �����User�����Ǽ�����û���Ϣ����
//		 * */
//		/**
//		 * ��������һ��չ�ֱ���������Ҫ�û��������ĸ�����Ϣ����ô��õķ�ʽ�ǹ���һ���µ�
//		 * �û����󣬲����ݳ�ȥ�����ݸ�JSPҳ�棬���û�ȥ����������
//		 * ���������ǵ��û�������֮��JSPҳ����POST��ʽ�ύ֮�����user��������ô��������
//		 * �һ����Ǻ���������Ӧ����JSP������
//		 * */
//		model.addAttribute(new User());
//		/**
//		 * ���е�JSP�ļ�ֻ�Ƕ��������ķ�������ʽ��POST������û��ָ������λ��URL��ʲô�����
//		 * �����������᷵���������JSP�ļ���·����ȥ����/employee-module
//		 * */
//		return "edit";
//	}
	
	/**
	 * �����������
	 * */
//	@RequestMapping(method = RequestMethod.POST)
	/**
	 * ע�������userǰ����һ��ע��@Validated�����е���@Valid������Ϊ����֤��Ч��
	 * 
	 * ����ļ���������Լ�����ģ�������ʽʲô�Ķ���֧�ֵģ������Զ��ļ��user�е��ֶ�����
	 * ���û���д�ı����ǲ����������Ƕ������ȷ��ʽ�����Ƕ������ʽ����Ҫ��User���еĶ�����
	 * ������Ҫ֪�����ǣ�һ���û�����Ĳ����㶨�壬��ô�ͻ�Ѵ��󴫵ݸ�bindingResult����
	 * ͬʱ��������Ҳ�������Զ���Ĵ�����Ϣ��message��������ͨ������bindingResult.getFieldError()
	 * �������鿴������ʾ��Ϣ
	 * */
//	public String addUserFromForm(@Validated User user, BindingResult bindingResult) {
//		
//		if (bindingResult.hasErrors()) {
//			return "edit";
//		}
//		
//		//���ﱣ��user�������ݿ���
//		
//		/**
//		 * ��������ض���ķ�ʽ���أ����õ���PRG�����ģʽ����˵��Ϊ�˷�ֹ�����ظ��ύ��
//		 * ���ݿ���ظ�д�����⣬�����ԭ���ҵ�����ǣ������صĲ�����һ����ͼ������һ��get
//		 * ���������Ļ����û���ȥˢ��ҳ��֮��Ĳ���ʱ���Ͳ�����post�ķ�ʽ�ύ������ô
//		 * ��Ȼ�Ͳ�����õ����������
//		 * 
//		 * ע�⣺
//		 * 		���ﷵ�ص�����������ʽ /user/{userName},����һ������·�����������󣬼�ס����
//		 * 		�ض����ȥ����һ��get�������ԣ�����Ҫһ��������ʵ�����get������ʵ����
//		 * */
//		return "redirect:/user" + user.getUserName();
//	}
	
	/**
	 * �������·������������
	 * */
	/**
	 * �����value��Щ����ˣ�������һ����ȷ��·���ˣ����Ǳ�������{}��Χ������һ��ֵ������
	 * userName����Ҳ��ע��@PathVariable��·����������ʶ
	 * ���������������ܹ�����URL�д��в�������������Ӧ��URLӦ����������
	 * /userName/brucezhang����ʱ��brucezhang���ᴫ�ݵ�����userName��
	 * */
//	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
//	public String showUserProfile(@PathVariable String userName, Model model) {
//		
//		/**
//		 * modelִ����Ӳ��������ݸ�JSPҳ�棨��������view��
//		 * */
//		
//		return "view";
//	}
	
//	class User{
//		public String getUserName() {
//			return "brucezhang";
//		}
		
		/**
		 * ����ʹ����У�����message�����ǳ�����Ϣ
		 * */
//		@Size(min = 3, max = 20, message = "userName must be between 3 and 20")
//		@Pattern(regexp="", message)
//		private String userName;
//		
//		@Size(min = 3, max = 20, message = "userName must be between 3 and 20")
//		private String password;
//	}
}

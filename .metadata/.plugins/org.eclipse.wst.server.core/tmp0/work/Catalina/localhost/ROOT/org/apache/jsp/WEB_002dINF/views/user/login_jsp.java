/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.87
 * Generated at: 2023-03-29 13:30:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<style>\r\n");
      out.write("* {\r\n");
      out.write("	padding: 0;\r\n");
      out.write("	margin: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("html, body {\r\n");
      out.write("	height: 100%;\r\n");
      out.write("	background: #ffffff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#container {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	flex-direction: row;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("	align-items: center;\r\n");
      out.write("	height: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#loginBox {\r\n");
      out.write("	width: 300px;\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	background-color: #ffffff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".input-form-box {\r\n");
      out.write("	border: 0px solid #ff0000;\r\n");
      out.write("	display: flex;\r\n");
      out.write("	margin-bottom: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".input-form-box>span {\r\n");
      out.write("	display: block;\r\n");
      out.write("	text-align: left;\r\n");
      out.write("	padding-top: 5px;\r\n");
      out.write("	min-width: 65px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button-login-box {\r\n");
      out.write("	margin: 10px 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#loginBoxTitle {\r\n");
      out.write("	color: #000000;\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("	font-size: 32px;\r\n");
      out.write("	text-transform: uppercase;\r\n");
      out.write("	padding: 5px;\r\n");
      out.write("	margin-bottom: 20px;\r\n");
      out.write("	background: linear-gradient(to right, #270a09, #8ca6ce);\r\n");
      out.write("	-webkit-background-clip: text;\r\n");
      out.write("	-webkit-text-fill-color: transparent;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#inputBox {\r\n");
      out.write("	margin: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#inputBox button {\r\n");
      out.write("	padding: 3px 5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.0.0/crypto-js.min.js\"></script>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>로그인</title>\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap CSS -->\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\"\r\n");
      out.write("	integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<!-- 나의 스타일 추가 -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/login.css?v=1234\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"text-center\">\r\n");
      out.write("\r\n");
      out.write("	<!--  html 전체 영역을 지정하는 container -->\r\n");
      out.write("	<div id=\"container\">\r\n");
      out.write("		<!--  login 폼 영역을 : loginBox -->\r\n");
      out.write("		<div id=\"loginBox\">\r\n");
      out.write("\r\n");
      out.write("			<!-- 로그인 페이지 타이틀 -->\r\n");
      out.write("			<div id=\"loginBoxTitle\">BookStore Login</div>\r\n");
      out.write("			<!-- 아이디, 비번, 버튼 박스 -->\r\n");
      out.write("			<form method=\"POST\" id=\"loginForm\">\r\n");
      out.write("				<div id=\"inputBox\">\r\n");
      out.write("					<div class=\"input-form-box\">\r\n");
      out.write("						<span>이메일 </span><input type=\"text\" name=\"email\"\r\n");
      out.write("							class=\"form-control\">\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"input-form-box\">\r\n");
      out.write("						<span>비밀번호 </span><input type=\"text\" id=\"plainPW\"\r\n");
      out.write("							class=\"form-control\"> <input type=\"password\"\r\n");
      out.write("							name=\"hashedPW\" class=\"form-control\" hidden>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"button-login-box\">\r\n");
      out.write("						<button type=\"button\" class=\"btn btn-primary btn-xs\"\r\n");
      out.write("							style=\"width: 100%\" onclick=\"doLogin()\">로그인</button>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</form>\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<!-- Bootstrap Bundle with Popper -->\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"\r\n");
      out.write("		integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("	function doLogin(){\r\n");
      out.write("	\r\n");
      out.write("    var hashedPW = document.getElementsByName('hashedPW');\r\n");
      out.write("    var nameDOM = document.getElementsByName('name');\r\n");
      out.write(" 	var inputText = document.getElementById('plainPW').value;\r\n");
      out.write(" 	var loginForm = document.getElementById('loginForm');\r\n");
      out.write(" 	\r\n");
      out.write(" 	var hash = CryptoJS.SHA256(inputText).toString(); \r\n");
      out.write("    hashedPW[0].value = hash;\r\n");
      out.write("    \r\n");
      out.write("    loginForm.submit();\r\n");
      out.write("	}\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.87
 * Generated at: 2023-03-29 00:18:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class join_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"ko\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.0.0/crypto-js.min.js\"></script>\r\n");
      out.write("<title>Join</title>\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap CSS -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n");
      out.write("	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("	min-height: 100vh;\r\n");
      out.write("	background: -webkit-gradient(linear, left bottom, right top, from(#92b5db),\r\n");
      out.write("		to(#1d466c));\r\n");
      out.write("	background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);\r\n");
      out.write("	background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);\r\n");
      out.write("	background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);\r\n");
      out.write("	background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".input-form {\r\n");
      out.write("	max-width: 680px;\r\n");
      out.write("	margin-top: 80px;\r\n");
      out.write("	padding: 32px;\r\n");
      out.write("	background: #fff;\r\n");
      out.write("	-webkit-border-radius: 10px;\r\n");
      out.write("	-moz-border-radius: 10px;\r\n");
      out.write("	border-radius: 10px;\r\n");
      out.write("	-webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);\r\n");
      out.write("	-moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);\r\n");
      out.write("	box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<div class=\"input-form-backgroud row\">\r\n");
      out.write("			<div class=\"input-form col-md-12 mx-auto\">\r\n");
      out.write("				<h4 class=\"mb-3\">회원가입</h4>\r\n");
      out.write("				<form class=\"validation-form\" method=\"POST\" id = \"frm\">\r\n");
      out.write("					<div class=\"row\">\r\n");
      out.write("						<div class=\"col-md-6 mb-3\">\r\n");
      out.write("							<label for=\"name\">이름</label> <input type=\"text\"\r\n");
      out.write("								class=\"form-control\" name=\"name\" placeholder=\"\" value=\"\" required>\r\n");
      out.write("							<div class=\"invalid-feedback\">이름을 입력해주세요.</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"col-md-6 mb-3\">\r\n");
      out.write("							<label for=\"nickname\">별명</label> <input type=\"text\"\r\n");
      out.write("								class=\"form-control\" id=\"nickname\" placeholder=\"\" value=\"\"\r\n");
      out.write("								required>\r\n");
      out.write("							<div class=\"invalid-feedback\">별명을 입력해주세요.</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("					<div class=\"mb-3\">\r\n");
      out.write("						<label for=\"email\">이메일</label> <input type=\"email\"\r\n");
      out.write("							class=\"form-control\" name=\"email\" placeholder=\"you@example.com\"\r\n");
      out.write("							required>\r\n");
      out.write("						<div class=\"invalid-feedback\">이메일을 입력해주세요.</div>\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("					<div class=\"mb-3\">\r\n");
      out.write("						<label for=\"email\">비밀번호</label> <input type=\"password\"\r\n");
      out.write("							class=\"form-control\" id=\"password\" placeholder=\"\" required>\r\n");
      out.write("						<div class=\"invalid-feedback\">비밀번호를 입력해주세요.</div>\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("					<div class=\"mb-3\" style=\"display: none\">\r\n");
      out.write("						<input type=\"text\" class=\"form-control\" name=\"hashedPW\"\r\n");
      out.write("						required	 >\r\n");
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("					<div class=\"mb-3\">\r\n");
      out.write("						<label for=\"address\">주소</label> <input type=\"text\"\r\n");
      out.write("							class=\"form-control\" name=\"address\" placeholder=\"서울특별시 강남구\"\r\n");
      out.write("							required>\r\n");
      out.write("						<div class=\"invalid-feedback\">주소를 입력해주세요.</div>\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("					<hr class=\"mb-4\">\r\n");
      out.write("					<div class=\"custom-control custom-checkbox\">\r\n");
      out.write("						<input type=\"checkbox\" class=\"custom-control-input\" id=\"aggrement\"\r\n");
      out.write("							required> <label class=\"custom-control-label\"\r\n");
      out.write("							for=\"aggrement\">개인정보 수집 및 이용에 동의합니다.</label>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"mb-4\"></div>\r\n");
      out.write("					<button class=\"btn btn-primary btn-lg btn-block\"\r\n");
      out.write("						onclick=\"doEncryption()\" type = \"button\">가입 완료</button>\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<footer class=\"my-3 text-center text-small\">\r\n");
      out.write("			<p class=\"mb-1\">&copy; 2021 YD</p>\r\n");
      out.write("		</footer>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script>\r\n");
      out.write("    window.addEventListener('load', () => {\r\n");
      out.write("      const forms = document.getElementsByClassName('validation-form');\r\n");
      out.write("\r\n");
      out.write("      Array.prototype.filter.call(forms, (form) => {\r\n");
      out.write("        form.addEventListener('submit', function (event) {\r\n");
      out.write("          if (form.checkValidity() === false) {\r\n");
      out.write("            event.preventDefault();\r\n");
      out.write("            event.stopPropagation();\r\n");
      out.write("          }\r\n");
      out.write("\r\n");
      out.write("          form.classList.add('was-validated');\r\n");
      out.write("        }, false);\r\n");
      out.write("      });\r\n");
      out.write("    }, false);\r\n");
      out.write("  </script>\r\n");
      out.write("	<script>\r\n");
      out.write("  function doEncryption() {\r\n");
      out.write("	    var hashedPW = document.getElementsByName('hashedPW');\r\n");
      out.write("	    var nameDOM = document.getElementsByName('name');\r\n");
      out.write("	 	var inputText = document.getElementById('password').value;\r\n");
      out.write("	 	var frm = document.getElementById('frm');\r\n");
      out.write("\r\n");
      out.write("	    var hash = CryptoJS.SHA256(inputText).toString(); \r\n");
      out.write("	    hashedPW[0].value = hash;\r\n");
      out.write("	    console.log(hashedPW[0].value);\r\n");
      out.write("	    \r\n");
      out.write("	    frm.submit();\r\n");
      out.write("\r\n");
      out.write("	}\r\n");
      out.write("  </script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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

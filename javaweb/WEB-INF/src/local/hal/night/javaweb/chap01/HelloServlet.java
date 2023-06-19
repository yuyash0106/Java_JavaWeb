package local.hal.night.javaweb.chap01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JavaWeb Lesson Chap01 Src01
 *
 * JavaWebの基本。
 *
 * @author yuyas
 */
public class HelloServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Hello World!</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>Hello World!</h1>");
		sb.append("</body>");
		sb.append("</html>");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(sb);
		out.flush();
		out.close();
	}
}

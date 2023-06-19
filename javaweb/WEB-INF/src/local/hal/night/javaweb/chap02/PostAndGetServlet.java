package local.hal.night.javaweb.chap02;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JavaWeb Lesson Chap02 Src02
 *
 * POSTとGETの違い。
 *
 * @author yuyas
 */
@WebServlet(name = "PostAndGetServlet", urlPatterns = { "/chap02/postAndGet" })
public class PostAndGetServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String strWeight = request.getParameter("weight");
		String strHeight = request.getParameter("height");

		double weight = Double.parseDouble(strWeight);
		double height = Double.parseDouble(strHeight);

		double bmi = weight / ((height / 100) * (height / 100));

		BigDecimal bigBmi = new BigDecimal(bmi);
		bigBmi = bigBmi.setScale(1, RoundingMode.HALF_UP);

		String strBmi = bigBmi.toString();

		StringBuffer sb = new StringBuffer();
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("<title>POSTとGETの違い</title>\n");
		sb.append("<body>\n");
		sb.append("</head>\n");
		sb.append("<p>あなたのBMIは<span style=\"color: red;font-size:24pt;\">");
		sb.append(strBmi);
		sb.append("</span>です。</p>\n");
		sb.append("<a href=\"/javaweb/chap02/showPostAndGet.html\">戻る</a>\n");
		sb.append("</body>\n");
		sb.append("</html>\n");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(sb);
		out.flush();
		out.close();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
}

package local.hal.night.javaweb.chap03;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JavaWeb Lesson Chap03 Src02
 *
 * JSPの登場。
 *
 * @author yuyas
 */
@WebServlet(name = "CalcBMIWithJSPServlet", urlPatterns = { "/chap03/calcBMI" })
public class CalcBmiWithJSPServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String strWeight = request.getParameter("weight");
		String strHeight = request.getParameter("height");

		double weight = Double.parseDouble(strWeight);
		double height = Double.parseDouble(strHeight);

		double bmi = weight / ((height / 100) * (height / 100));

		BigDecimal bigBmi = new BigDecimal(bmi);
		bigBmi = bigBmi.setScale(1, RoundingMode.HALF_UP);

		String strBmi = bigBmi.toString();

		request.setAttribute("bmiValue", strBmi);

		RequestDispatcher rd = request.getRequestDispatcher("/chap03/showBMI.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
}

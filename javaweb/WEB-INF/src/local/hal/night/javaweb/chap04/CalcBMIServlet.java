package local.hal.night.javaweb.chap04;

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
 * JavaWeb Lesson Chap04 Src02
 *
 * バリデーション。
 * サーブレットクラス。
 *
 * @author yuyas
 */
@WebServlet(name = "CalcBMIServlet", urlPatterns = { "/chap04/calcBMI" })
public class CalcBMIServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws
	IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String strHeight = request.getParameter("height");
		String strWeight = request.getParameter("weight");

		strHeight = strHeight.trim();
		strWeight = strWeight.trim();

		String forwardPath = "/chap04/inputBMI.jsp";

		if (strHeight.equals("") || strWeight.equals("")) {
			request.setAttribute("msg", "身長と体重の両方が必須です。");
		} else {
			try {
				double height = Double.parseDouble(strHeight);
				double weight = Double.parseDouble(strWeight);

				if (height <= 0) {
					request.setAttribute("msg", "身長は正の数で入力してください。");
				} else if (weight <= 0) {
					request.setAttribute("msg", "体重は正の数で入力してください。");
				} else {
					BigDecimal bigBmi = new BigDecimal(weight / ((height / 100) * (height / 100)));
					BigDecimal bigBmiD = bigBmi.setScale(1, RoundingMode.HALF_UP);
					BigDecimal bigBmiI = bigBmi.setScale(0, RoundingMode.HALF_UP);
					double bmi = bigBmiD.doubleValue();
					int bmiInt = bigBmiI.intValue();

					BigDecimal bigIdealWeight = new BigDecimal(22 * (height / 100) * (height / 100));
					bigIdealWeight = bigIdealWeight.setScale(0, RoundingMode.HALF_UP);
					int idealWeight = bigIdealWeight.intValue();

					String advice = "";
					if (bmiInt > 22) {
						advice = "肥満です。体重" + idealWeight + "kgを目指しましょう。";
					} else if (bmiInt < 22) {
						advice = "やせています。体重" + idealWeight + "kgを目指しましょう。";
					} else {
						advice = "ちょうどいいです。現状を維持しましょう。";
					}

					request.setAttribute("bmi", bmi);
					request.setAttribute("advice", advice);
					forwardPath = "/chap04/resultBMI.jsp";
				}
			} catch (NumberFormatException ex) {
				request.setAttribute("msg", "身長と体重には数値を入力してください。");
			}
		}
		request.setAttribute("height", strHeight);
		request.setAttribute("weight", strWeight);

		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

}

package local.hal.night.javaweb.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalcScoreServlet", urlPatterns = { "/practice/calcScore" })
public class CalcScoreServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//UTF-8のセット
		request.setCharacterEncoding("UTF-8");

		//JSPから値を取得
		String name = request.getParameter("name");
		String gradeStr = request.getParameter("grade");
		String strMorning = request.getParameter("morning");
		String strAfternoon = request.getParameter("afternoon");

		int grade = Integer.parseInt(gradeStr);

		//forwardPath
		String forwardPath = "/practice/inputScore.jsp";

		//名前、点数が空白の場合
		if (name.equals("") || strMorning.equals("") || strAfternoon.equals("")) {
			request.setAttribute("Name", name);
			request.setAttribute("grade", grade);
			request.setAttribute("strMorning", strMorning);
			request.setAttribute("strAfternoon", strAfternoon);

			request.setAttribute("msg", "名前、午前と午後の点数を入力してください。");
		}

		//正常入力
		else {
			try {
				//値変換
				int scoreM = Integer.parseInt(strMorning);
				int scoreA = Integer.parseInt(strAfternoon);
				//合計点の変数セット
				int total = scoreM + scoreA;

				//合格の場合
				if (scoreM >= 65 && scoreA >= 65 && total >= 140) {
					request.setAttribute("judge", "合格");
				}

				//不合格
				else {
					request.setAttribute("judge", "不合格");
				}
				forwardPath = "/practice/scoreResult.jsp";
				request.setAttribute("strMorning", scoreM);
				request.setAttribute("strAfternoon", scoreA);
				request.setAttribute("total", total);
			}

			//点数に数字以外が入力された場合
			catch (NumberFormatException ex) {

				request.setAttribute("msg", "午前と午後の点数は数値を入力してください。");

			}
		}

		request.setAttribute("Name", name);
		request.setAttribute("grade", grade);
		request.setAttribute("strMorning", strMorning);
		request.setAttribute("strAfternoon", strAfternoon);
		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
}

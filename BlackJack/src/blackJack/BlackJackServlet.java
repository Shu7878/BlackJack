package blackJack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mathPart.Calc;

/**
 * Servlet implementation class BlackJackServlet
 */
@WebServlet("/BlackJack")
public class BlackJackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Integer num = (Integer)session.getAttribute("number");

		if(num == null){
			num = 0;
			num = Calc.execute(num);
		}
		session.setAttribute("number", num);
		request.setAttribute("message", "ブラックジャックゲームへようこそ");

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/start.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String Btn = request.getParameter("btn");
		Integer num = (Integer)session.getAttribute("number");
		Integer parentNum = (Integer)session.getAttribute("parentNum");
		String jsp = null;

		if(parentNum == null){
			parentNum = 0;
		}

		try{
			if(Btn != null && Btn.equals("once")){
				Calc number = new Calc();
				num = number.execute(num);
				parentNum = number.parentExecute(parentNum);
				session.setAttribute("number", num);
				if(num >= 22){
					request.setAttribute("resultMessage", "ゲームオーバー。。。");
					request.setAttribute("number", num);
					request.setAttribute("parentNum", parentNum);
					jsp = "/finish.jsp";
					session.invalidate();
				}else{
					jsp = "/start.jsp";
				}


			}else if(Btn != null && Btn.equals("stay")){
				Calc number = new Calc();
				parentNum = number.parentExecute(parentNum);
				request.setAttribute("number", num);
				request.setAttribute("parentNum", parentNum);
				if(num > parentNum){
					request.setAttribute("resultMessage", "WIN!!!");
				}else if(num == parentNum){
					request.setAttribute("resultMessage", "draw");
				}else{
					request.setAttribute("resultMessage", "LOSE。。。");
				}
				jsp = "/finish.jsp";
				session.invalidate();
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

}

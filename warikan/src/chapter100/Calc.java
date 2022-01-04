package chapter100;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Contents;

@WebServlet(urlPatterns={"/chapter100/Calc"})
public class Calc extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		try {
			//合計値を取得
			int total = Integer.parseInt(request.getParameter("total"));
			//カンパ額を取得
			int kanpa = Integer.parseInt(request.getParameter("kanpa"));
			total -= kanpa;
			//人数を取得
			int  count = Integer.parseInt(request.getParameter("count"));
			//端数処理方法を取得
			String round = request.getParameter("round"); //value="small"or"big"
			//一人当たりの本来の金額
			double val = (total / count) ;
			double origin = val;
			//端数処理した一人当たりの金額
			int price = 0;
			//端数処理で生じる誤差
			int gosa = 0;

			//端数処理
			if(round.equals("small")) {
				//四捨五入（10円単位）
				val = val / 100;
				long val2 = Math.round(val);
				price  = (int)(val2 * 100);
				gosa = total - (price * count);
			} else if (round.equals("big")) {
				//四捨五入（100円単位）
				val = val / 1000;
				long val2 = Math.round(val);
				price  = (int)(val2 * 1000);
				gosa = total - (price * count);
			}
			//ランダムメッセージの取得
			String msg = new Message().getMsg() ;

			//Beanの生成
			Contents c = new Contents();
			c.setTotal(total); //合計金額
			c.setOrigin(origin);//1人あたりの本来金額
			c.setKanpa(kanpa);//カンパ額
			c.setCount(count); //人数
			c.setPrice(price); //1人あたりの金額
			c.setMsg(msg); //メッセージ
			c.setGosa(gosa); //誤差額1
			c.setRound(round); //端数単位

			request.setAttribute("contents", c);
			request.getRequestDispatcher("gotisousama-out.jsp").forward(request, response);

		} catch (NullPointerException e) {
			out.println("数値を入力してください。");
		} catch (NumberFormatException e) {
		out.println("数値を入力してください。");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

package horse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

import bean.Horse;
import bean.Race;
import bean.Result;
import dao.HorseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/horse/search"})
public class Search extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		Page.spinner_div(out);

		// 最後に送信されたデータを取得
		// 検索キーワード
		String horse_name = request.getParameter("horse_name");
		horse_name = Objects.toString(horse_name, ""); // NULLは空文字に置き換え
		
		String result = request.getParameter("result");
		result = Objects.toString(result, ""); // NULLは空文字に置き換え

		String race = request.getParameter("race");
		race = Objects.toString(race, ""); // NULLは空文字に置き換え
		
		if (horse_name != "") {
			horse_search(out, horse_name);
		}
		else if (result != "") {
			result_search(out, result);
		}
		else if (race != "") {
			race_search(out, race);
		}
		else {
			out.println("<p>検索条件が設定されていません</p><br>");
			out.println("<a class=\"btn btn-primary\" href=\"./horse.jsp\" role=\"button\">戻る</a>");
		}
		
		Page.spinner_script(out);
		Page.footer(out);
	}
	
	public void horse_search(PrintWriter out, String horse_name)
	{
		
		try {
			HorseDAO dao=new HorseDAO();
			List<Horse> list=dao.horse_search(horse_name);

			out.println("<p>" + list.size() + "件ヒットしました</p>");
			out.println("<table align=\"center\" class=\"table_design09\">");
			out.println("	<thead>");
			out.println("		<tr>");
			out.println("		<th scope=\"col\">馬名</th>");
			out.println("		<th scope=\"col\">性別</th>");
			out.println("		<th scope=\"col\">毛色 </th>");
			out.println("		<th scope=\"col\">誕生日</th>");
			out.println("	</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			
			for (Horse h : list) {
	
					out.println("    <tr>");
					out.println("      <th scope=\"col\">" + h.get馬名() + "</th>");
					out.println("      <th scope=\"col\">" + h.get性別() + "</th>");
					out.println("      <th scope=\"col\">" + h.get毛色() + "</th>");
					java.sql.Date birthday = h.get誕生日();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					out.println("      <th scope=\"col\">" + sdf.format(birthday) + "</th>");
					out.println("    </tr>");
			}

			out.println("</tfoot>");
			out.println("</table>");
			out.println("<a class=\"btn btn-primary\" href=\"./horse.jsp\" role=\"button\">戻る</a>");
		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}
	
	public void result_search(PrintWriter out, String result)
	{
		
		try {			
			HorseDAO dao=new HorseDAO();
			List<Result> list=dao.result_search(result);

			out.println("<p>" + list.size() + "件ヒットしました</p>");

			out.println("<table align=\"center\" class=\"table_design09\">");
			out.println("	<thead>");
			out.println("		<tr>");
			out.println("			<th scope=\"col\">回</th>");
			out.println("		<th scope=\"col\">レース名</th>");
			out.println("		<th scope=\"col\">開催日</th>");
			out.println("		<th scope=\"col\">グレード</th>");
			out.println("		<th scope=\"col\">競馬場</th>");
			out.println("		<th scope=\"col\">コース</th>");
			out.println("		<th scope=\"col\">距離</th>");
			out.println("		<th scope=\"col\">条件</th>");
			out.println("		<th scope=\"col\">優勝馬</th>");
			out.println("		<th scope=\"col\">性齢</th>");
			out.println("		<th scope=\"col\">毛色</th>");
			out.println("	</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			
			for (Result r : list) {
				
				out.println("    <tr>");
				out.println("      <th scope=\"col\">" + r.get回() + "</th>");
				out.println("      <th scope=\"col\">" + r.getレース名() + "</th>");
				java.sql.Date raceday = r.get開催日();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				out.println("      <th scope=\"col\">" + sdf.format(raceday) + "</th>");
				out.println("      <th scope=\"col\">" + r.getグレード() + "</th>");
				out.println("      <th scope=\"col\">" + r.get競馬場() + "</th>");
				out.println("      <th scope=\"col\">" + r.getコース() + "</th>");
				out.println("      <th scope=\"col\">" + r.get距離() + "</th>");
				out.println("      <th scope=\"col\">" + r.get条件() + "</th>");
				out.println("      <th scope=\"col\">" + r.get優勝馬() + "</th>");
				out.println("      <th scope=\"col\">" + r.get性別() + r.get年齢() + "</th>");
				out.println("      <th scope=\"col\">" + r.get毛色() + "</th>");
				out.println("    </tr>");
			}

			out.println("</tfoot>");
			out.println("</table>");
			out.println("<a class=\"btn btn-primary\" href=\"./horse.jsp\" role=\"button\">戻る</a>");

			
		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}
	
	public void race_search(PrintWriter out, String race)
	{
		
		try {			
			HorseDAO dao=new HorseDAO();
			List<Race> list=dao.race_search(race);

			out.println("<p>" + list.size() + "件ヒットしました</p>");

			out.println("<table align=\"center\" class=\"table_design09\">");
			out.println("	<thead>");
			out.println("		<tr>");
			out.println("		<th scope=\"col\">レース名</th>");
			out.println("		<th scope=\"col\">グレード</th>");
			out.println("		<th scope=\"col\">競馬場</th>");
			out.println("		<th scope=\"col\">コース</th>");
			out.println("		<th scope=\"col\">距離</th>");
			out.println("		<th scope=\"col\">条件</th>");
			out.println("		<th scope=\"col\">現行</th>");
			out.println("		<th scope=\"col\">創設年</th>");
			out.println("	</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			
			for (Race r : list) {
				
				out.println("    <tr>");
				out.println("      <th scope=\"col\">" + r.getレース名() + "</th>");
				out.println("      <th scope=\"col\">" + r.getグレード() + "</th>");
				out.println("      <th scope=\"col\">" + r.get競馬場() + "</th>");
				out.println("      <th scope=\"col\">" + r.getコース() + "</th>");
				out.println("      <th scope=\"col\">" + r.get距離() + "</th>");
				out.println("      <th scope=\"col\">" + r.get条件() + "</th>");
				out.println("      <th scope=\"col\">" + r.get現行() + "</th>");
				out.println("      <th scope=\"col\">" + r.get創設年() + "</th>");
				out.println("    </tr>");
			}

			out.println("</tfoot>");
			out.println("</table>");
			out.println("<a class=\"btn btn-primary\" href=\"./horse.jsp\" role=\"button\">戻る</a>");

		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}

	
}

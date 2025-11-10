package tool;

import java.io.PrintWriter;

public class Page {

	public static void header(PrintWriter out) {
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet/JSP Sample Programs</title>");
		out.println("<link rel=\"stylesheet\" href=\"./style.css\">");
		out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"");
		out.println("        integrity=\"sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1\" crossorigin=\"anonymous\">");	
		out.println("<style>");
		out.println("#loading {");
		out.println("            background: rgba(0, 0, 0, .5);");
		out.println("   z-index: 10000;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
	}
	
	public static void inputarea(PrintWriter out) {	
		out.println("<form action=\"total\" method=\"post\">");
		out.println("<input type=\"text\" name=\"price\">");
		out.println("円×");
		out.println("<input type=\"text\" name=\"count\">");
		out.println("個＝");
		out.println("<input type=\"submit\" value=\"計算\">");
		out.println("</form>");
	}
	
	public static void horse_name(PrintWriter out) {	
		out.println("<form action=\"search\" method=\"post\">");
 		out.println("   <table>");
 		out.println("       <tr>");
 		out.println("           <td>馬名</td><td><input type=\"text\" name=horse_name></td>");
		out.println("        </tr>");
 		out.println("       <tr>");
 		out.println("<td>実績</td><td><input type=\"text\" name=\"result\"></td>");
 		out.println("       </tr>");
 		out.println("       <tr>");
 		out.println("           <td>レース</td><td><input type=\"text\" name=\"race\"></td>");
 		out.println("       </tr>");
 		out.println("   </table>");
		out.println("    <div><input type=\"submit\" value=\"送信\"></div>");
		out.println("</form>");
	}
	
	public static void spinner_div(PrintWriter out) {	
		out.println("<div id=\"loading\" class=\"position-absolute top-0 start-0 w-100 h-100 d-none\">");
		out.println("    <div class=\"text-center position-absolute top-50 start-50 w-100 translate-middle\">");
		out.println("        <div class=\"spinner-border text-light\" role=\"status\">");
		out.println("            <span class=\"sr-only\"></span>");
		out.println("        </div>");
		out.println("    </div>");
		out.println("</div>");
	}
	
	public static void spinner_script(PrintWriter out) {	
		out.println("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"");
		out.println("        integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"");
		out.println("        crossorigin=\"anonymous\"></script>");

		out.println("<script>");
		out.println("    $(function () {");
		out.println("        //ローディング表示");
		out.println("        show_loading();");
		out.println("        //1.5秒後にローディング非表示");
		out.println("       setTimeout(function () {");
		out.println("            hide_loading();");
		out.println("        }, 1500);");
		out.println("    })");

		out.println("    //ローディング表示");
		out.println("    function show_loading() {");
		out.println("        $('#loading').removeClass('d-none');");
		out.println("    }");

		out.println("    //ローディング非表示");
		out.println("    function hide_loading() {");
		out.println("        $('#loading').addClass('d-none');");

		out.println("    }");
		out.println("    function hello() {");
		out.println("        console.log('Hello');");
		out.println("    }");
		out.println("</script>");
	}	
	

	public static void footer(PrintWriter out) {
		out.println("</body>");
		out.println("</html>");
	}
}

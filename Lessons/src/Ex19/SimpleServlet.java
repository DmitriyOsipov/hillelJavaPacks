package Ex19;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */

public class SimpleServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String htmlTemplate = "<HTML>\n" +
                "\t<HEAD>\n" +
                "\t\t<TITLE>Test servlet</TITLE>\n" +
                "\t</HEAD>\n" +
                "\t<BODY>\n" +
                "\t\t<marquee bgcolor=\"red\" width=\"25%\">%s</marquee>\n" +
                "\t\t<marquee bgcolor=\"aqua\" width=\"25%\" direction=\"right\">%s</marquee>\n" +
                "\t\t<marquee bgcolor=\"silver\" width=\"25%\">%s</marquee>\n" +
                "\t\t<marquee bgcolor=\"aqua\" width=\"25%\" direction=\"right\">%s</marquee>\n" +
                "\t</BODY>\n" +
                "</HTML>";
        String myText = "Hello, World!";

        writer.println(String.format(htmlTemplate, myText));
    }

}

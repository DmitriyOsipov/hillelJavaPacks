package Ex19;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 *
 */

public class SimpleServlet extends HttpServlet{
//*
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String htmlTemplate = "<HTML>\n" +
                "\t<HEAD>\n" +
                "\t\t<TITLE>Hello world - GET</TITLE>\n" +
                "\t</HEAD>\n" +
                "\t<BODY>\n" +
                "\t\t<marquee bgcolor=\"red\" width=\"23%\">Hello, World!</marquee>\n" +
                "\t\t<marquee bgcolor=\"aqua\" width=\"23%\" direction=\"right\">Hello, World!</marquee>\n" +
                "\t\t<marquee bgcolor=\"silver\" width=\"23%\">Hello, World!</marquee>\n" +
                "\t\t<marquee bgcolor=\"aqua\" width=\"23%\" direction=\"right\">Hello, World!</marquee>\n" +
                "\t</BODY>\n" +
                "</HTML>";
        writer.println(htmlTemplate);

    }
//*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        Enumeration attributes = req.getAttributeNames();
                StringBuilder builder = new StringBuilder("<HTML>\n\t<HEAD>\n\t\t<TITLE>Hello world - POST</TITLE>" +
                                "\n\t</HEAD>\n\t<BODY>\n");
        builder.append("\t\t<p align = \"center\"><h3>You posted attributes:</h3></p>\n");
        builder.append("\t\t<Table>");
        writer.println("<!-- --------------- -->");
        //writer.println("<!-- " + req.getAttribute("someText").toString() + "-->");
        while (attributes.hasMoreElements()){
            builder.append("\n\t\t\t<tr>\n\t\t\t\t<td>");
            String attrName = attributes.nextElement().toString();
            writer.println("<!-- " + attrName + "-->");
            builder.append(attrName);
            builder.append("</td>\n\t\t\t\t<td>");
            builder.append(req.getAttribute(attrName).toString());
            builder.append("\n\t\t\t\t</td>\n\t\t\t</tr>");
        }
        builder.append("\n\t\t</Table>\n\t</BODY>\n</HTML>");

        writer.println(builder.toString());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        Enumeration attributes = req.getAttributeNames();

        StringBuilder builder = new StringBuilder("<HTML>\n\t<HEAD>\n\t\t<TITLE>Hello world - PUT</TITLE>" +
                "\n\t</HEAD>\n\t<BODY>\n");
        builder.append("\t\t<p align = \"center\"><h3>You putted attributes:</h3></p>\n");
        builder.append("\t\t<Table>");
        writer.println("<!-- --------------- -->");
        //writer.println("<!-- " + req.getAttribute("someText").toString() + "-->");
        while (attributes.hasMoreElements()){
            builder.append("\n\t\t\t<tr>\n\t\t\t\t<td>");
            String attrName = attributes.nextElement().toString();
            writer.println("<!-- " + attrName + "-->");
            builder.append(attrName);
            builder.append("</td>\n\t\t\t\t<td>");
            builder.append(req.getAttribute(attrName).toString());
            builder.append("\n\t\t\t\t</td>\n\t\t\t</tr>");
        }
        builder.append("\n\t\t</Table>\n\t</BODY>\n</HTML>");

        writer.println(builder.toString());
    }
}

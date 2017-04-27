package Ex19;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

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
        writer.println(getPutPostHtml("POST", req.getParameterMap()));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(getPutPostHtml("PUT", req.getParameterMap()));
    }

    private String getParametersHtmlTable(Map pars){
        StringBuilder builder = new StringBuilder();
        String newRowOpen ="\n\t\t\t<tr>";
        String newRowClose = "\n\t\t\t</tr>";
        builder.append("\t\t<Table border=\"2\" bordercolor=\"black\">"+
                 newRowOpen +
                "\n\t\t\t\t<th>Parameter name</th>" +
                "\n\t\t\t\t<th>Parameter type</th>" +
                "\n\t\t\t\t<th>Value</th>" +
                newRowClose);

        for(Object key : pars.keySet()){
            builder.append("\n<!--" + key + " -->");
            builder.append(newRowOpen);
            builder.append("\n\t\t\t\t<td>");
            builder.append(key);
            builder.append("</td>\n\t\t\t\t<td>");
            builder.append(pars.get(key).getClass().getSimpleName());
            builder.append("</td>\n\t\t\t\t<td>");
            builder.append(Arrays.toString(((String[])pars.get(key))));
            builder.append("\n\t\t\t\t</td>");
            builder.append(newRowClose);
        }
        builder.append("\n\t\t</Table>\n");
        return builder.toString();
    }

    private String getPutPostHtml(String methodName, Map parametersMap){
        StringBuilder builder = new StringBuilder("<HTML>\n\t<HEAD>\n\t\t<TITLE>Hello world - " + methodName +"</TITLE>" +
                "\n\t</HEAD>\n\t<BODY>\n");
        builder.append("\t\t<p align = \"center\"><h3>Attributes:</h3></p>\n");
        builder.append(getParametersHtmlTable(parametersMap));
        builder.append("\t</BODY>\n</HTML>");
        return builder.toString();
    }
}

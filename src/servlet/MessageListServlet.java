package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.ChatMessage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageListServlet extends ChatServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
// Установить кодировку HTTP-ответа UTF-8
        response.setCharacterEncoding("utf8");
// Получить доступ к потоку вывода HTTP-ответа
        PrintWriter pw = response.getWriter();
// Записть в поток HTML-разметку страницы
        pw.println("<html>" +
                "<head>" +
                "<meta http-equiv='Content-Type' " +
                "content='text/html; " +
                "charset=utf-8'/>" +
                "<meta http-equiv='refresh' " +
                "content='10'>" +
                "</head>");
        pw.println("<body>");
// В обратном порядке записать в поток HTML-разметку для каждого

        for (int i = messages.size() - 1; i >= 0; i--) {
            ChatMessage aMessage = messages.get(i);
            if(messages.get(i).getAuthor().getName().equals("system")){
                pw.println("<div>" + aMessage.getMessage() + "</div>");
            }else{
                pw.println("<div><strong>" + aMessage.getAuthor().getName() + "</strong>: " + aMessage.getMessage() + "</div>");
            }
        }
        pw.println("</body></html>");
    }
}

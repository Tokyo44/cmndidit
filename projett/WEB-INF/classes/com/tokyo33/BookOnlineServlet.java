
    import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BookOnlineServlet extends HttpServlet {

    private static final String CSV_FILE_PATH = "/projett/xml/src/Bookings.csv"; // Adjust path as necessary

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String program = request.getParameter("program");

        // Save the form data to a CSV file
        saveToCSV(name, email, program);

        // Set response content type and output message
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('Thank you for booking! We will contact you with payment details soon.');</script>");
        out.println("<meta http-equiv='refresh' content='0;URL=bookonline.html'>");
    }

    private void saveToCSV(String name, String email, String program) throws IOException {
        FileWriter csvWriter = new FileWriter(CSV_FILE_PATH, true); // Append mode
        PrintWriter printWriter = new PrintWriter(csvWriter);
        printWriter.printf("%s,%s,%s%n", name, email, program);
        printWriter.close();
    }
}



package masters;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.prodezy.webservices.WebAPITester;

/**
 * Servlet implementation class ProcessMaster
 */
@WebServlet("/processMaster")
public class ProcessMaster extends HttpServlet {
	String process, details, result;
	String batch_wise, item_wise;
//	WebCall add_new;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		// TODO Auto-generated method stub
		try {
			if (request.getParameter("add_process") != null) 
			{

				process = request.getParameter("process_name");
				batch_wise = request.getParameter("check_batch");
				item_wise = request.getParameter("check_item");
				details = request.getParameter("details");
				System.out.println("processs : " + process);

				System.out.println("batch  : " + batch_wise);
				System.out.println("item : "+ item_wise);
				System.out.println("Details :"+ details);
			
				
					String addEmpAPICall = null ;

					try 
					{
					 addEmpAPICall = "processeadd?PROCESS_NAME="+ URLEncoder.encode(process, "UTF-8")
					        + "&PROCESS_DETAILS=" + URLEncoder.encode(details, "UTF-8")
			         		+ "&IS_BATCH_WISE="+  URLEncoder.encode("true", "UTF-8")
			         		+ "&IS_ITEM_WISE="+  URLEncoder.encode("false", "UTF-8");
					}catch (Exception e) {
					writer.println(e);
					}
					System.out.println(addEmpAPICall);
					writer.println(addEmpAPICall);

					result = WebAPITester.prepareWebCall(addEmpAPICall);
					writer.println(result);

			
				writer.println("successssss .....");

				if(result.contains("Process created successfully."))
					
				{
				  response.setContentType("text/html");
			      writer.println("<script type=\"text/javascript\">");
			 	  writer.println("alert('Process created successfully. !!');"); writer.println("</script>");
			
				}
			}
		} catch (Exception e) {
			System.out.println("error  " + e);
		}

	}

}

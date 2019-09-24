package masters;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.prodezy.webservices.WebAPITester;
import model.ProcessMapModel;
import webcall.SpinnerList;



/**
 * Servlet implementation class ProcessMap
 */
@WebServlet(name = "processmap", urlPatterns = { "/processmap" })
public class ProcessMap extends HttpServlet 
{
	String result,fg_data,uom_id,fg_id,process_id,die_id,machine_id,setup_time,cycle_time,output_hr,output_shift,output_day,cost_rm,rejection,remark,addEmpAPICall;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessMap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out = response.getWriter();
		try
		{
			if(request.getParameter("add") != null)
			{
				String message="";
				fg_data = request.getParameter("isFg");
				process_id = request.getParameter("proc");
				machine_id = request.getParameter("machine");
				die_id = request.getParameter("die");
				setup_time = request.getParameter("setupTime");
				cycle_time = request.getParameter("cycleTime");
				output_hr = request.getParameter("output_hr");
				output_shift = request.getParameter("output_shift");
				output_day = request.getParameter("output_day");
				cost_rm = request.getParameter("cost_rm");
				rejection = request.getParameter("rejection");
				remark = request.getParameter("remark");
				
				if(!setup_time.equals("") && !setup_time.equals(null))
				{
					
				try 
				{
				System.out.println("sss  "+fg_data);
				String[] ids = fg_data.split("\\+",2);
				fg_id = ids[0].trim();
				uom_id = ids[1].trim();
				System.out.println("sss  "+ids[0].trim());
				System.out.println("sss  "+ids[1].trim());
				}catch (ArrayIndexOutOfBoundsException e) {
					System.out.println(e);
				}
				
		
                 
            addEmpAPICall = "processmachmapadd?REF_FG_ID="+URLEncoder.encode(fg_id, "UTF-8")
                         +"&REF_PROCESS_ID="+URLEncoder.encode(process_id,"UTF-8")
                         +"&REF_MCH_ID="+URLEncoder.encode(machine_id, "UTF-8")
                         +"&SETUP_TIME="+URLEncoder.encode(setup_time,"UTF-8")
                         +"&IDEAL_PROCESS_TIME="+URLEncoder.encode(cycle_time,"UTF-8")
                         +"&REMARKS="+URLEncoder.encode(remark, "UTF-8")
                         +"&TG_OPT_HR="+URLEncoder.encode(output_hr,"UTF-8")
                         +"&TG_OPT_SHT="+URLEncoder.encode(output_shift ,"UTF-8")
                         +"&TG_OPT_DAY="+URLEncoder.encode(output_day, "UTF-8")
                         +"&UOM_ID="+URLEncoder.encode(uom_id ,"UTF-8")
                         +"&VAL_AT_PROC="+URLEncoder.encode(cost_rm,"UTF-8")
                         +"&MAX_REJ_PERM="+URLEncoder.encode(rejection, "UTF-8")  
                         +"&REF_TOOL_CODE="+URLEncoder.encode(die_id  ,"UTF-8")  ;
                 result = WebAPITester.prepareWebCall(addEmpAPICall);
			   out.println(result);

				if(result.contains("Process Mach Map created successfully."))
				{
					  response.setContentType("text/html");
				      out.println("<script type=\"text/javascript\">");
				 	  out.println("alert('Process Mach Map created successfully. !!');");
				 	  out.println("</script>");
				}
			}else {
				 message="Please Enter Setup Time!";
		    	 response.sendRedirect("ProcessMap.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
				
			}
			if(request.getParameter("loadmap") != null)
			{
				fg_data = request.getParameter("isFg");
				String[] ids = fg_data.split("\\+",2);
				fg_id = ids[0].trim();
			    ArrayList<ProcessMapModel> map = new SpinnerList().getProcessMapDataList(fg_id);
			    out.println("<table align=\"center\" border=\"1\">");
			    out.println("<tr>");
			    out.println("<th>Process</th>");
			    out.println("<th>Machine</th>");
			    out.println("<th>Die/Tool</th>");
			    out.println("<th>Set up Time</th>");
			    out.println("<th>Cycle Time</th>");
			    out.println("<th>Remark</th>");
			    out.println("<th>O/P per hour</th>");
			    out.println("<th>O/P per shift</th>");
			    out.println("<th>O/P per day</th>");
			    out.println("<th>Unit of Part</th>");
			    out.println("<th>Effective value</th>");
			    out.println("<th>Maximum permissible</th>");
			    out.println("</tr>");
			    out.println("</table>");
			 /*   <tr>
				
				
				
				
				
				
				
				
				
				
				
							

			</tr>
			<% ArrayList<ProcessMapModel> dieList = new SpinnerList().getProcessMapDataList("test");
			   for(int i = 0; i < dieList.size(); i++) 
				{
				  
				%>
				<tr>
				
				<td><%= dieList.get(i).getProcess_id() %></td>
				<td><%= dieList.get(i).getMachine_id() %></td>
				<td><%= dieList.get(i).getDie_id()%></td>
				<td><%= dieList.get(i).getSetup_time()%></td>
				<td><%= dieList.get(i).getCycle_time()%></td>
				<td><%= dieList.get(i).getRemark()%></td>
				<td><%= dieList.get(i).getOutput_hr()%></td>
				<td><%= dieList.get(i).getOutput_shift()%></td>
				<td><%= dieList.get(i).getOutput_day()%></td>
				<td><%= dieList.get(i).getUom_id()%></td>
				<td><%= dieList.get(i).getCost_rm()%></td>
				<td><%= dieList.get(i).getRejection() %></td>
				</tr>
				<% 
				}
			
			%>
			
			
		</table>		*/
				
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
}

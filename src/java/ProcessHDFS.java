/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.ProjectDetails;
import com.oreilly.servlet.MultipartRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raxton
 */
public class ProcessHDFS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = "";

        PrintWriter writer;
//writer.println("The first line");
//writer.println("The second line");

        try {
            if (request.getSession().getAttribute("ProjectList") != null) {
//                ArrayList<ProjectDetails> ProjectList = (ArrayList<ProjectDetails>) request.getSession().getAttribute("ProjectList");
                
                int number = Integer.parseInt(request.getSession().getAttribute("number").toString());
                System.out.println("Number ---- " + number  );
                File file = new File("/home/raxton/uploads/" + number + ".sh");

                if (!file.exists()) {
                    file.createNewFile();

                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    System.out.println("FILE PATH =" + fw);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("#!/bin/sh\n"
                            + "\n"
                            + "#set -e\n"
                            + "success = $?\n"
                            + "\n"
                            + "echo \"The hadoop execution for drill data processing started at \" $(date);\n"
                            + "\n"
                            + "echo \"Processing the files \";\n"
                            + "\n"
                            + "echo \"Starting the process for loading drilling file to HDFS\" ;");
                    bw.write("hadoop fs -rm -r -f /FilesDrillingData &&");
                    bw.write("hadoop fs -put $(eval echo ~$USER)/uploads/" + number + "/ " + "/FilesDrillingData &&");
                    bw.write("echo \"Data moved to hdfs. Now loading in hive\" &&\n"
                            + "\n"
                            + "\n"
                            + "hive -e \"drop table if exists DataMiningDrill;drop table if exists DataMiningDrillFinal;create table DataMiningDrill(Depth double,Backforce double,Comments varchar(80)) row format delimited fields terminated by '|';create table DataMiningDrillFinal(FileName varchar(200),Depth double,Backforce double,Comments varchar(80)) row format delimited fields terminated by '|';\" &&\n"
                            + "\n"
                            + "echo \"Table Created in hive. Processing further .. \" &&\n"
                            + "\n"
                            + "hive -e \"load data inpath '/FilesDrillingData/*.csv' into table DataMiningDrill;\" &&\n"
                            + "\n"
                            + "hive -e \"insert into table DataMiningDrillFinal select split(INPUT__FILE__NAME,'hdfs://localhost:54310/user/hive/warehouse/dataminingdrill/')[1],* from DataMiningDrill;\" &&\n"
                            + "\n"
                            + "echo \"Loaded in Hive Data warehouse.\" &&\n");
                    bw.write("#Added for test only\n"
                            + "#mysql -u root -proot -e 'use MiningProcessSchema;drop table if exists MiningDrillData;drop table if exists MiningDrillDataToExport;create table MiningDrillData (FileName varchar(200),Depth double,Backforce double,Comments varchar(80));create table MiningDrillDataToExport ( PointZ double ,PointY double , PointX double );' &&\n"
                            + "######################\n"
                            + "\n"
                            + "mysql -u root -proot -e 'use MiningProcessSchema;drop table if exists MiningDrillData;drop table if exists MiningDrillDataToExport;create table MiningDrillData (FileName varchar(200),Depth double,Backforce double,Comments varchar(80));create table MiningDrillDataToExport ( PointZ double ,PointY double , PointX double , Material varchar(50));' &&\n"
                            + "\n"
                            + "\n"
                            + "echo \"Table created in mysql\" &&\n"
                            + "\n"
                            + "sqoop export --bindir ./ --connect jdbc:mysql://localhost/MiningProcessSchema  --username root --password root --table MiningDrillData --export-dir /user/hive/warehouse/dataminingdrillfinal --direct --fields-terminated-by '|' &&\n"
                            + "\n"
                            + "\n"
                            + "echo \"Data Loaded in mysql.Exporting required data of Iron..\" &&	\n"
                            + "\n"
                            + "#Added for test only\n"
                            + "#mysql -u root -proot -e \"use MiningProcessSchema;insert into MiningDrillDataToExport (select d.Depth, m.PointX , m.PointY from MiningDrillData d, MiningMasterData m , BackforceAssumptioData b where m.FileName=d.FileName and d.Backforce>=b.BackforceStartValue and d.backforce<b.BackforceEndValue and b.Materail='Iron' order by d.Depth,m.PointX,m.PointY);\" &&\n"
                            + "######################\n"
                            + "\n"
                            + "mysql -u root -proot -e \"use MiningProcessSchema;insert into MiningDrillDataToExport (select d.Depth, m.PointX , m.PointY , b.Materail from MiningDrillData d, MiningMasterData m , BackforceAssumptioData b where m.FileName=d.FileName and d.Backforce>=b.BackforceStartValue and d.backforce<b.BackforceEndValue  order by d.Depth,m.PointX,m.PointY);\" &&");
                    bw.write("hadoop fs -rm -r -f /MiningConvertedData &&\n"
                            + "\n"
                            + "sqoop import --bindir ./ --connect jdbc:mysql://localhost/MiningProcessSchema --username root --password root --table MiningDrillDataToExport --m 1 -target-dir /MiningConvertedData &&");
                    bw.write("hadoop fs -get /MiningConvertedData $(eval echo ~$USER)/uploads/processed/\n"
                            + "\n"
                            + "if [ \"$?\" = \"0\" ] ; then\n"
                            + "	echo \"Process success\"\n"
                            + "else \n"
                            + "	echo \"------------!!!!!Something wrong !!Process failed!!!!------------\";\n"
                            + "fi\n"
                            + "\n"
                            + "echo \" The hadoop execution for file processing ended at \" $(date) ;");
                    bw.close();
                    String msg1 = "Done! File Created Successfully!";
                    request.setAttribute("msg1", msg1);
                }

                path = "analyzeFiles.jsp?mineId="+number;
                System.out.println(path);
                RequestDispatcher rd = request.getRequestDispatcher(path);
                rd.forward(request, response);

            }
        } catch (Exception e) {
            String msg1 = "File Creation Failed!";
            request.setAttribute("msg1", msg1);
            path = "analyzeFiles.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

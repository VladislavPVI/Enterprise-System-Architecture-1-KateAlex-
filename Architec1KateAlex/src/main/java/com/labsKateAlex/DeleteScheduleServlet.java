package com.labsKateAlex;

import com.labsKateAlex.bean.HobbyBean;
import com.labsKateAlex.bean.ScheduleBean;
import com.labsKateAlex.domain.Schedule;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteS")
public class DeleteScheduleServlet extends HttpServlet {
    @EJB
    private ScheduleBean scheduleBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id")!=null && req.getParameter("id")!="")
            scheduleBean.delete(Long.valueOf(req.getParameter("id")));
        resp.sendRedirect(req.getContextPath()+ "/start");
    }
}

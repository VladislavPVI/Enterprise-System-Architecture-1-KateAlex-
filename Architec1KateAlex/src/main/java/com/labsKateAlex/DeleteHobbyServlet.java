package com.labsKateAlex;

import com.labsKateAlex.bean.HobbyBean;
import com.labsKateAlex.bean.ScheduleBean;
import com.labsKateAlex.domain.Hobby;
import com.labsKateAlex.domain.Schedule;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteHobby")
public class DeleteHobbyServlet extends HttpServlet {
    @EJB
    private HobbyBean hobbyBean;

    @EJB
    private ScheduleBean scheduleBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id")!=null && req.getParameter("id")!="") {
            hobbyBean.delete(Long.valueOf(req.getParameter("id")));
            List<Schedule> allSchedule = scheduleBean.getByHobby(Long.valueOf(req.getParameter("id")));
            for (Schedule i : allSchedule) scheduleBean.delete(i.getId());
        }
        resp.sendRedirect(req.getContextPath()+ "/start");
    }
}

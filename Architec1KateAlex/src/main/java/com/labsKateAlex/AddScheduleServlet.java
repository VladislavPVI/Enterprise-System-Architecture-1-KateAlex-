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
import java.time.LocalDateTime;

@WebServlet("/addSchedule")
public class AddScheduleServlet extends HttpServlet {
    @EJB
    private ScheduleBean scheduleBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("edit") != null) {
            long id = Long.valueOf(req.getParameter("edit"));
            Schedule schedule = scheduleBean.get(id);
            req.setAttribute("schedule", schedule);
        }
        req.getRequestDispatcher("/addSchedule.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        Long hobbyid = Long.valueOf(req.getParameter("hobbyid"));
        java.time.LocalDateTime dateTime = LocalDateTime.parse(req.getParameter("localDateTime"));


        if(!req.getParameter("id").equals("")) {
            int mark = Integer.valueOf(req.getParameter("mark"));
            boolean complete = Boolean.valueOf(req.getParameter("complete"));
            long id = Long.valueOf(req.getParameter("id"));
            Schedule schedule = scheduleBean.get(id);
            schedule.setComplete(complete);
            schedule.setHobbyid(hobbyid);
            schedule.setLocalDateTime(dateTime);
            schedule.setMark(mark);
            scheduleBean.update(schedule);
        }
        else scheduleBean.add(new Schedule(hobbyid, dateTime));
        resp.sendRedirect(req.getContextPath()+ "/start");
    }
}

